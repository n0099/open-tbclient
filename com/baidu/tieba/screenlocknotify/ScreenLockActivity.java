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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.f;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView dZJ;
    public c gwB;
    public d gwC;
    private ScreenLockLoadMoreModel gwF;
    private ScreenLockHeaderView gwG;
    private Window gwz;
    private Drawable gkW = null;
    public DynamicHeightListView gwA = null;
    private int gwD = 0;
    private TextView gwE = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gwH = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.boK().gwN.bAb();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gwI = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.gwG != null && !StringUtils.isNull(ScreenLockActivity.this.gwG.getInputMsg()) && (data = ScreenLockActivity.this.gwG.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ae("obj_to", data.url).ae("app_version", TbConfig.getVersion()).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gwG.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fG(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gwG.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.nameShow, data.gxd);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fG(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ah("lockscreen_reply", true).start();
                a.boK().gwN.bAb();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gwC = ScreenLockActivity.this.gwB.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gwC);
        }
    };
    private View.OnClickListener gwJ = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gwG != null) {
                ScreenLockActivity.this.gwC = ScreenLockActivity.this.gwG.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gwC);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gwK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(f.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gwE != null) {
                            ScreenLockActivity.this.gwE.setText(ScreenLockActivity.this.getResources().getString(f.j.data_load_error));
                            ScreenLockActivity.this.gwE.setEnabled(true);
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
                        ArrayList<d> boQ = data.boQ();
                        if (ScreenLockActivity.this.gwB != null) {
                            ScreenLockActivity.this.gwB.dm(boQ);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gwB.setHasMore(false);
                            if (ScreenLockActivity.this.gwE != null) {
                                ScreenLockActivity.this.gwA.removeFooterView(ScreenLockActivity.this.gwE);
                                ScreenLockActivity.this.gwE = null;
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
        this.gwz = getWindow();
        this.gwz.addFlags(524288);
        this.gwz.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(f.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(f.d.transparent, true);
        if (l.jY()) {
            this.gkW = com.baidu.tieba.t.a.bAe();
            if (this.gkW != null) {
                this.gwz.setBackgroundDrawable(this.gkW);
            }
        }
        this.gwD = l.f(getPageContext().getPageActivity(), f.e.ds935) - l.f(getPageContext().getPageActivity(), f.e.ds80);
        this.gwF = new ScreenLockLoadMoreModel(this);
        registerListener(this.gwK);
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
        this.dZJ = (ImageView) findViewById(f.g.head_close);
        this.dZJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.gwB.getCount() > 0 && (item = ScreenLockActivity.this.gwB.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.boK().gwN.bAb();
            }
        });
        this.gwA = (DynamicHeightListView) findViewById(f.g.screenlock_chat_list_content);
        this.gwB = new c(getPageContext().getPageActivity());
        this.gwA.setAdapter((ListAdapter) this.gwB);
        this.gwA.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gwH, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.boK().gwT = false;
        this.gwA.setMaxHeight(this.gwD);
        this.gwA.setTranscriptMode(0);
        this.gwA.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gwE != null && ScreenLockActivity.this.gwE.getParent() != null) {
                    if (ScreenLockActivity.this.gwA.getHeight() != ScreenLockActivity.this.gwD) {
                        ScreenLockActivity.this.gwE.setText(ScreenLockActivity.this.getResources().getString(f.j.click_load_more));
                        ScreenLockActivity.this.gwE.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gwE.isEnabled()) {
                            ScreenLockActivity.this.gwE.setText(ScreenLockActivity.this.getResources().getString(f.j.loading));
                            ScreenLockActivity.this.gwE.setEnabled(false);
                        }
                        ScreenLockActivity.this.aws();
                    }
                }
            }
        });
    }

    private void boI() {
        this.gwE = new TextView(getActivity());
        this.gwE.setGravity(17);
        this.gwE.setText(f.j.click_load_more);
        this.gwE.setHeight((int) getResources().getDimension(f.e.ds80));
        this.gwE.setBackgroundResource(f.C0146f.screen_notify_item_background);
        this.gwE.setTextColor(getResources().getColorStateList(f.d.screen_notify_load_more_text_color));
        this.gwE.setTextSize(0, getResources().getDimension(f.e.fontsize32));
        this.gwE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gwE.setText(ScreenLockActivity.this.getResources().getString(f.j.loading));
                ScreenLockActivity.this.gwE.setEnabled(false);
                ScreenLockActivity.this.aws();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(boJ())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aws() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gwF.boR();
            if (this.gwB != null && this.gwB.getCount() > 0 && (item = this.gwB.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.boK().gwQ = 1;
        a.boK().gwO = 0;
        List<d> boM = a.boK().boM();
        d boN = a.boK().boN();
        a.boK().release();
        if ((boM == null || boM.isEmpty()) && boN == null && this.gwB.getCount() == 0 && this.gwA.getHeaderViewsCount() == 0) {
            a.boK().gwN.bAb();
            finish();
            return;
        }
        dl(boM);
        if (boN != null) {
            a(boN);
        }
        if (this.gwG != null) {
            this.gwG.lM(this.gwB.getCount() == 0);
        }
    }

    private void dl(List<d> list) {
        if (list != null && list.size() > 0 && this.gwB != null) {
            this.gwB.dm(list);
            if (this.gwB.isHasMore() && this.gwE == null) {
                boI();
                this.gwA.addFooterView(this.gwE);
            }
        }
    }

    private void a(d dVar) {
        if (this.gwG == null) {
            this.gwG = new ScreenLockHeaderView(getActivity());
            this.gwG.setUIClickListener(this.gwI, this.gwJ);
            this.gwG.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gwA.addHeaderView(this.gwG);
        }
        this.gwG.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.boK().gwQ = 0;
        a.boK().gwO = 0;
        if (this.gwG != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gwG.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gwH);
        a.boK().release();
        a.boK().gwQ = 0;
        this.gkW = null;
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
            TiebaStatic.log(new an("c11703").f("msg_id", dVar.msgId / 100).f("task_id", dVar.taskId).ae("obj_to", dVar.url).ae("app_version", TbConfig.getVersion()).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.jE()) {
                showToast(getResources().getString(f.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                az.zI().c(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new an("c10316").ae("obj_type", dVar.stat).r("obj_locate", 2));
                a.boK().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.boK().d(dVar);
                a.boK().gwN.bAb();
                if (!a.boK().gwN.bAd()) {
                    a.boK().gwN.bAc();
                }
                a.boK().gwO = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gwC.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.gxd, 0, dVar.gat ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.boK().d(dVar);
                a.boK().gwO = 0;
                a.boK().gwN.bAb();
                if (!a.boK().gwN.bAd()) {
                    a.boK().gwN.bAc();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gwC.groupId, 0L), dVar.groupName, dVar.gxd, 0, 4)));
                a.boK().d(dVar);
                a.boK().gwO = 0;
                a.boK().gwN.bAb();
                if (!a.boK().gwN.bAd()) {
                    a.boK().gwN.bAc();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.boK().d(dVar);
                a.boK().gwN.bAb();
                if (!a.boK().gwN.bAd()) {
                    a.boK().gwN.bAc();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.boK().gwN.bAb();
            finish();
            return true;
        } else if (i == 82) {
            a.boK().gwN.bAb();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String boJ() {
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
