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
    private ImageView eoY;
    private Window gLo;
    public c gLq;
    public d gLr;
    private ScreenLockLoadMoreModel gLu;
    private ScreenLockHeaderView gLv;
    private Drawable gzO = null;
    public DynamicHeightListView gLp = null;
    private int gLs = 0;
    private TextView gLt = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gLw = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(WebSocketAction.PARAM_KEY_REASON)) != null && stringExtra.equals("homekey")) {
                a.buG().gLC.bGe();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gLx = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.gLv != null && !StringUtils.isNull(ScreenLockActivity.this.gLv.getInputMsg()) && (data = ScreenLockActivity.this.gLv.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").h("msg_id", data.msgId / 100).h("task_id", data.taskId).ax("obj_to", data.url).ax("app_version", TbConfig.getVersion()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gLv.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().gq(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gLv.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.gLS);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().gq(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.buG().gLC.bGe();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gLr = ScreenLockActivity.this.gLq.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gLr);
        }
    };
    private View.OnClickListener gLy = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gLv != null) {
                ScreenLockActivity.this.gLr = ScreenLockActivity.this.gLv.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gLr);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gLz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(e.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gLt != null) {
                            ScreenLockActivity.this.gLt.setText(ScreenLockActivity.this.getResources().getString(e.j.data_load_error));
                            ScreenLockActivity.this.gLt.setEnabled(true);
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
                        ArrayList<d> buM = data.buM();
                        if (ScreenLockActivity.this.gLq != null) {
                            ScreenLockActivity.this.gLq.dB(buM);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gLq.setHasMore(false);
                            if (ScreenLockActivity.this.gLt != null) {
                                ScreenLockActivity.this.gLp.removeFooterView(ScreenLockActivity.this.gLt);
                                ScreenLockActivity.this.gLt = null;
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
        this.gLo = getWindow();
        this.gLo.addFlags(524288);
        this.gLo.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(e.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.transparent, true);
        if (l.lq()) {
            this.gzO = com.baidu.tieba.t.a.bGh();
            if (this.gzO != null) {
                this.gLo.setBackgroundDrawable(this.gzO);
            }
        }
        this.gLs = l.h(getPageContext().getPageActivity(), e.C0175e.ds935) - l.h(getPageContext().getPageActivity(), e.C0175e.ds80);
        this.gLu = new ScreenLockLoadMoreModel(this);
        registerListener(this.gLz);
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
        this.eoY = (ImageView) findViewById(e.g.head_close);
        this.eoY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.gLq.getCount() > 0 && (item = ScreenLockActivity.this.gLq.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").h("msg_id", item.msgId / 100).h("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.buG().gLC.bGe();
            }
        });
        this.gLp = (DynamicHeightListView) findViewById(e.g.screenlock_chat_list_content);
        this.gLq = new c(getPageContext().getPageActivity());
        this.gLp.setAdapter((ListAdapter) this.gLq);
        this.gLp.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gLw, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.buG().gLI = false;
        this.gLp.setMaxHeight(this.gLs);
        this.gLp.setTranscriptMode(0);
        this.gLp.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gLt != null && ScreenLockActivity.this.gLt.getParent() != null) {
                    if (ScreenLockActivity.this.gLp.getHeight() != ScreenLockActivity.this.gLs) {
                        ScreenLockActivity.this.gLt.setText(ScreenLockActivity.this.getResources().getString(e.j.click_load_more));
                        ScreenLockActivity.this.gLt.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gLt.isEnabled()) {
                            ScreenLockActivity.this.gLt.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                            ScreenLockActivity.this.gLt.setEnabled(false);
                        }
                        ScreenLockActivity.this.aBW();
                    }
                }
            }
        });
    }

    private void buE() {
        this.gLt = new TextView(getActivity());
        this.gLt.setGravity(17);
        this.gLt.setText(e.j.click_load_more);
        this.gLt.setHeight((int) getResources().getDimension(e.C0175e.ds80));
        this.gLt.setBackgroundResource(e.f.screen_notify_item_background);
        this.gLt.setTextColor(getResources().getColorStateList(e.d.screen_notify_load_more_text_color));
        this.gLt.setTextSize(0, getResources().getDimension(e.C0175e.fontsize32));
        this.gLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gLt.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                ScreenLockActivity.this.gLt.setEnabled(false);
                ScreenLockActivity.this.aBW();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(buF())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBW() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gLu.buN();
            if (this.gLq != null && this.gLq.getCount() > 0 && (item = this.gLq.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").h("msg_id", item.msgId / 100).h("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.buG().gLF = 1;
        a.buG().gLD = 0;
        List<d> buI = a.buG().buI();
        d buJ = a.buG().buJ();
        a.buG().release();
        if ((buI == null || buI.isEmpty()) && buJ == null && this.gLq.getCount() == 0 && this.gLp.getHeaderViewsCount() == 0) {
            a.buG().gLC.bGe();
            finish();
            return;
        }
        dA(buI);
        if (buJ != null) {
            a(buJ);
        }
        if (this.gLv != null) {
            this.gLv.mD(this.gLq.getCount() == 0);
        }
    }

    private void dA(List<d> list) {
        if (list != null && list.size() > 0 && this.gLq != null) {
            this.gLq.dB(list);
            if (this.gLq.isHasMore() && this.gLt == null) {
                buE();
                this.gLp.addFooterView(this.gLt);
            }
        }
    }

    private void a(d dVar) {
        if (this.gLv == null) {
            this.gLv = new ScreenLockHeaderView(getActivity());
            this.gLv.setUIClickListener(this.gLx, this.gLy);
            this.gLv.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gLp.addHeaderView(this.gLv);
        }
        this.gLv.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.buG().gLF = 0;
        a.buG().gLD = 0;
        if (this.gLv != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gLv.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gLw);
        a.buG().release();
        a.buG().gLF = 0;
        this.gzO = null;
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
            if (!j.kX()) {
                showToast(getResources().getString(e.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ay.CU().c(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new am("c10316").ax("obj_type", dVar.stat).x("obj_locate", 2));
                a.buG().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.buG().d(dVar);
                a.buG().gLC.bGe();
                if (!a.buG().gLC.bGg()) {
                    a.buG().gLC.bGf();
                }
                a.buG().gLD = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gLr.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.gLS, 0, dVar.gpl ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.buG().d(dVar);
                a.buG().gLD = 0;
                a.buG().gLC.bGe();
                if (!a.buG().gLC.bGg()) {
                    a.buG().gLC.bGf();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gLr.groupId, 0L), dVar.groupName, dVar.gLS, 0, 4)));
                a.buG().d(dVar);
                a.buG().gLD = 0;
                a.buG().gLC.bGe();
                if (!a.buG().gLC.bGg()) {
                    a.buG().gLC.bGf();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.buG().d(dVar);
                a.buG().gLC.bGe();
                if (!a.buG().gLC.bGg()) {
                    a.buG().gLC.bGf();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.buG().gLC.bGe();
            finish();
            return true;
        } else if (i == 82) {
            a.buG().gLC.bGe();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String buF() {
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
