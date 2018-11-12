package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView eqs;
    private Window gMO;
    public c gMQ;
    public d gMR;
    private ScreenLockLoadMoreModel gMU;
    private ScreenLockHeaderView gMV;
    private Drawable gBq = null;
    public DynamicHeightListView gMP = null;
    private int gMS = 0;
    private TextView gMT = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gMW = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(WebSocketAction.PARAM_KEY_REASON)) != null && stringExtra.equals("homekey")) {
                a.buc().gNc.bFD();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gMX = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.gMV != null && !StringUtils.isNull(ScreenLockActivity.this.gMV.getInputMsg()) && (data = ScreenLockActivity.this.gMV.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").h("msg_id", data.msgId / 100).h("task_id", data.taskId).ax("obj_to", data.url).ax("app_version", TbConfig.getVersion()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gMV.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().gr(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gMV.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.gNs);
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().gr(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.buc().gNc.bFD();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gMR = ScreenLockActivity.this.gMQ.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gMR);
        }
    };
    private View.OnClickListener gMY = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gMV != null) {
                ScreenLockActivity.this.gMR = ScreenLockActivity.this.gMV.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gMR);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gMZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(e.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gMT != null) {
                            ScreenLockActivity.this.gMT.setText(ScreenLockActivity.this.getResources().getString(e.j.data_load_error));
                            ScreenLockActivity.this.gMT.setEnabled(true);
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) {
                        data = ((ScreenLockLoadMoreHttpResponseMessage) responsedMessage).getData();
                    } else {
                        data = responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage ? ((ScreenLockLoadMoreSocketResponseMessage) responsedMessage).getData() : null;
                    }
                    if (data != null) {
                        ArrayList<d> bui = data.bui();
                        if (ScreenLockActivity.this.gMQ != null) {
                            ScreenLockActivity.this.gMQ.dz(bui);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gMQ.setHasMore(false);
                            if (ScreenLockActivity.this.gMT != null) {
                                ScreenLockActivity.this.gMP.removeFooterView(ScreenLockActivity.this.gMT);
                                ScreenLockActivity.this.gMT = null;
                            }
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.gMO = getWindow();
        this.gMO.addFlags(524288);
        this.gMO.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(e.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.transparent, true);
        if (l.lo()) {
            this.gBq = com.baidu.tieba.t.a.bFG();
            if (this.gBq != null) {
                this.gMO.setBackgroundDrawable(this.gBq);
            }
        }
        this.gMS = l.h(getPageContext().getPageActivity(), e.C0200e.ds935) - l.h(getPageContext().getPageActivity(), e.C0200e.ds80);
        this.gMU = new ScreenLockLoadMoreModel(this);
        registerListener(this.gMZ);
        initUI();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void initUI() {
        this.eqs = (ImageView) findViewById(e.g.head_close);
        this.eqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.gMQ.getCount() > 0 && (item = ScreenLockActivity.this.gMQ.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").h("msg_id", item.msgId / 100).h("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.buc().gNc.bFD();
            }
        });
        this.gMP = (DynamicHeightListView) findViewById(e.g.screenlock_chat_list_content);
        this.gMQ = new c(getPageContext().getPageActivity());
        this.gMP.setAdapter((ListAdapter) this.gMQ);
        this.gMP.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gMW, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.buc().gNi = false;
        this.gMP.setMaxHeight(this.gMS);
        this.gMP.setTranscriptMode(0);
        this.gMP.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gMT != null && ScreenLockActivity.this.gMT.getParent() != null) {
                    if (ScreenLockActivity.this.gMP.getHeight() != ScreenLockActivity.this.gMS) {
                        ScreenLockActivity.this.gMT.setText(ScreenLockActivity.this.getResources().getString(e.j.click_load_more));
                        ScreenLockActivity.this.gMT.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gMT.isEnabled()) {
                            ScreenLockActivity.this.gMT.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                            ScreenLockActivity.this.gMT.setEnabled(false);
                        }
                        ScreenLockActivity.this.aBu();
                    }
                }
            }
        });
    }

    private void bua() {
        this.gMT = new TextView(getActivity());
        this.gMT.setGravity(17);
        this.gMT.setText(e.j.click_load_more);
        this.gMT.setHeight((int) getResources().getDimension(e.C0200e.ds80));
        this.gMT.setBackgroundResource(e.f.screen_notify_item_background);
        this.gMT.setTextColor(getResources().getColorStateList(e.d.screen_notify_load_more_text_color));
        this.gMT.setTextSize(0, getResources().getDimension(e.C0200e.fontsize32));
        this.gMT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gMT.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                ScreenLockActivity.this.gMT.setEnabled(false);
                ScreenLockActivity.this.aBu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bub())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gMU.buj();
            if (this.gMQ != null && this.gMQ.getCount() > 0 && (item = this.gMQ.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").h("msg_id", item.msgId / 100).h("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.buc().gNf = 1;
        a.buc().gNd = 0;
        List<d> bue = a.buc().bue();
        d buf = a.buc().buf();
        a.buc().release();
        if ((bue == null || bue.isEmpty()) && buf == null && this.gMQ.getCount() == 0 && this.gMP.getHeaderViewsCount() == 0) {
            a.buc().gNc.bFD();
            finish();
            return;
        }
        dy(bue);
        if (buf != null) {
            a(buf);
        }
        if (this.gMV != null) {
            this.gMV.mO(this.gMQ.getCount() == 0);
        }
    }

    private void dy(List<d> list) {
        if (list != null && list.size() > 0 && this.gMQ != null) {
            this.gMQ.dz(list);
            if (this.gMQ.isHasMore() && this.gMT == null) {
                bua();
                this.gMP.addFooterView(this.gMT);
            }
        }
    }

    private void a(d dVar) {
        if (this.gMV == null) {
            this.gMV = new ScreenLockHeaderView(getActivity());
            this.gMV.setUIClickListener(this.gMX, this.gMY);
            this.gMV.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gMP.addHeaderView(this.gMV);
        }
        this.gMV.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.buc().gNf = 0;
        a.buc().gNd = 0;
        if (this.gMV != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gMV.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gMW);
        a.buc().release();
        a.buc().gNf = 0;
        this.gBq = null;
    }

    public void b(d dVar) {
        int i;
        if (dVar != null) {
            switch (dVar.customGroupType) {
                case 1:
                case 2:
                    i = 3;
                    break;
                case 3:
                default:
                    i = 0;
                    break;
                case 4:
                    i = 2;
                    break;
                case 5:
                    i = 1;
                    break;
            }
            TiebaStatic.log(new am("c11703").h("msg_id", dVar.msgId / 100).h("task_id", dVar.taskId).ax("obj_to", dVar.url).ax("app_version", TbConfig.getVersion()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.kV()) {
                showToast(getResources().getString(e.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ay.Db().c(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new am("c10316").ax("obj_type", dVar.stat).x("obj_locate", 2));
                a.buc().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.buc().d(dVar);
                a.buc().gNc.bFD();
                if (!a.buc().gNc.bFF()) {
                    a.buc().gNc.bFE();
                }
                a.buc().gNd = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gMR.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.gNs, 0, dVar.gqL ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.buc().d(dVar);
                a.buc().gNd = 0;
                a.buc().gNc.bFD();
                if (!a.buc().gNc.bFF()) {
                    a.buc().gNc.bFE();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gMR.groupId, 0L), dVar.groupName, dVar.gNs, 0, 4)));
                a.buc().d(dVar);
                a.buc().gNd = 0;
                a.buc().gNc.bFD();
                if (!a.buc().gNc.bFF()) {
                    a.buc().gNc.bFE();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.buc().d(dVar);
                a.buc().gNc.bFD();
                if (!a.buc().gNc.bFF()) {
                    a.buc().gNc.bFE();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.buc().gNc.bFD();
            finish();
            return true;
        } else if (i == 82) {
            a.buc().gNc.bFD();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bub() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(5);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return null;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        if (runningTaskInfo == null) {
            return null;
        }
        return runningTaskInfo.topActivity.getClassName();
    }
}
