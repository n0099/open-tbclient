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
    private ImageView eAQ;
    private Window gXE;
    public c gXG;
    public d gXH;
    private ScreenLockLoadMoreModel gXK;
    private ScreenLockHeaderView gXL;
    private Drawable gMb = null;
    public DynamicHeightListView gXF = null;
    private int gXI = 0;
    private TextView gXJ = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gXM = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(WebSocketAction.PARAM_KEY_REASON)) != null && stringExtra.equals("homekey")) {
                a.bxr().gXS.bJg();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gXN = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.gXL != null && !StringUtils.isNull(ScreenLockActivity.this.gXL.getInputMsg()) && (data = ScreenLockActivity.this.gXL.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").i("msg_id", data.msgId / 100).i("task_id", data.taskId).aB("obj_to", data.url).aB("app_version", TbConfig.getVersion()).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gXL.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().gY(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gXL.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.gYi);
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().gY(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bxr().gXS.bJg();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gXH = ScreenLockActivity.this.gXG.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gXH);
        }
    };
    private View.OnClickListener gXO = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gXL != null) {
                ScreenLockActivity.this.gXH = ScreenLockActivity.this.gXL.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gXH);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gXP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(e.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gXJ != null) {
                            ScreenLockActivity.this.gXJ.setText(ScreenLockActivity.this.getResources().getString(e.j.data_load_error));
                            ScreenLockActivity.this.gXJ.setEnabled(true);
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
                        ArrayList<d> bxx = data.bxx();
                        if (ScreenLockActivity.this.gXG != null) {
                            ScreenLockActivity.this.gXG.dF(bxx);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gXG.setHasMore(false);
                            if (ScreenLockActivity.this.gXJ != null) {
                                ScreenLockActivity.this.gXF.removeFooterView(ScreenLockActivity.this.gXJ);
                                ScreenLockActivity.this.gXJ = null;
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
        this.gXE = getWindow();
        this.gXE.addFlags(524288);
        this.gXE.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(e.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.transparent, true);
        if (l.ln()) {
            this.gMb = com.baidu.tieba.u.a.bJj();
            if (this.gMb != null) {
                this.gXE.setBackgroundDrawable(this.gMb);
            }
        }
        this.gXI = l.h(getPageContext().getPageActivity(), e.C0210e.ds935) - l.h(getPageContext().getPageActivity(), e.C0210e.ds80);
        this.gXK = new ScreenLockLoadMoreModel(this);
        registerListener(this.gXP);
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
        this.eAQ = (ImageView) findViewById(e.g.head_close);
        this.eAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.gXG.getCount() > 0 && (item = ScreenLockActivity.this.gXG.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").i("msg_id", item.msgId / 100).i("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bxr().gXS.bJg();
            }
        });
        this.gXF = (DynamicHeightListView) findViewById(e.g.screenlock_chat_list_content);
        this.gXG = new c(getPageContext().getPageActivity());
        this.gXF.setAdapter((ListAdapter) this.gXG);
        this.gXF.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gXM, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bxr().gXY = false;
        this.gXF.setMaxHeight(this.gXI);
        this.gXF.setTranscriptMode(0);
        this.gXF.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gXJ != null && ScreenLockActivity.this.gXJ.getParent() != null) {
                    if (ScreenLockActivity.this.gXF.getHeight() != ScreenLockActivity.this.gXI) {
                        ScreenLockActivity.this.gXJ.setText(ScreenLockActivity.this.getResources().getString(e.j.click_load_more));
                        ScreenLockActivity.this.gXJ.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gXJ.isEnabled()) {
                            ScreenLockActivity.this.gXJ.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                            ScreenLockActivity.this.gXJ.setEnabled(false);
                        }
                        ScreenLockActivity.this.aEq();
                    }
                }
            }
        });
    }

    private void bxp() {
        this.gXJ = new TextView(getActivity());
        this.gXJ.setGravity(17);
        this.gXJ.setText(e.j.click_load_more);
        this.gXJ.setHeight((int) getResources().getDimension(e.C0210e.ds80));
        this.gXJ.setBackgroundResource(e.f.screen_notify_item_background);
        this.gXJ.setTextColor(getResources().getColorStateList(e.d.screen_notify_load_more_text_color));
        this.gXJ.setTextSize(0, getResources().getDimension(e.C0210e.fontsize32));
        this.gXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gXJ.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                ScreenLockActivity.this.gXJ.setEnabled(false);
                ScreenLockActivity.this.aEq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bxq())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEq() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gXK.bxy();
            if (this.gXG != null && this.gXG.getCount() > 0 && (item = this.gXG.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").i("msg_id", item.msgId / 100).i("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bxr().gXV = 1;
        a.bxr().gXT = 0;
        List<d> bxt = a.bxr().bxt();
        d bxu = a.bxr().bxu();
        a.bxr().release();
        if ((bxt == null || bxt.isEmpty()) && bxu == null && this.gXG.getCount() == 0 && this.gXF.getHeaderViewsCount() == 0) {
            a.bxr().gXS.bJg();
            finish();
            return;
        }
        dE(bxt);
        if (bxu != null) {
            a(bxu);
        }
        if (this.gXL != null) {
            this.gXL.mV(this.gXG.getCount() == 0);
        }
    }

    private void dE(List<d> list) {
        if (list != null && list.size() > 0 && this.gXG != null) {
            this.gXG.dF(list);
            if (this.gXG.isHasMore() && this.gXJ == null) {
                bxp();
                this.gXF.addFooterView(this.gXJ);
            }
        }
    }

    private void a(d dVar) {
        if (this.gXL == null) {
            this.gXL = new ScreenLockHeaderView(getActivity());
            this.gXL.setUIClickListener(this.gXN, this.gXO);
            this.gXL.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gXF.addHeaderView(this.gXL);
        }
        this.gXL.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bxr().gXV = 0;
        a.bxr().gXT = 0;
        if (this.gXL != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gXL.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gXM);
        a.bxr().release();
        a.bxr().gXV = 0;
        this.gMb = null;
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
            TiebaStatic.log(new am("c11703").i("msg_id", dVar.msgId / 100).i("task_id", dVar.taskId).aB("obj_to", dVar.url).aB("app_version", TbConfig.getVersion()).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.kV()) {
                showToast(getResources().getString(e.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ay.Es().c(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new am("c10316").aB("obj_type", dVar.stat).y("obj_locate", 2));
                a.bxr().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.bxr().d(dVar);
                a.bxr().gXS.bJg();
                if (!a.bxr().gXS.bJi()) {
                    a.bxr().gXS.bJh();
                }
                a.bxr().gXT = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gXH.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.gYi, 0, dVar.gBw ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bxr().d(dVar);
                a.bxr().gXT = 0;
                a.bxr().gXS.bJg();
                if (!a.bxr().gXS.bJi()) {
                    a.bxr().gXS.bJh();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gXH.groupId, 0L), dVar.groupName, dVar.gYi, 0, 4)));
                a.bxr().d(dVar);
                a.bxr().gXT = 0;
                a.bxr().gXS.bJg();
                if (!a.bxr().gXS.bJi()) {
                    a.bxr().gXS.bJh();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bxr().d(dVar);
                a.bxr().gXS.bJg();
                if (!a.bxr().gXS.bJi()) {
                    a.bxr().gXS.bJh();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bxr().gXS.bJg();
            finish();
            return true;
        } else if (i == 82) {
            a.bxr().gXS.bJg();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bxq() {
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
