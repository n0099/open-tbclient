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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView gwo;
    private ScreenLockLoadMoreModel luB;
    private ScreenLockHeaderView luC;
    private Window luv;
    public c lux;
    public d luy;
    private Drawable lid = null;
    public DynamicHeightListView luw = null;
    private int luz = 0;
    private TextView luA = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver luD = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.ddK().luJ.dpl();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener luE = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.luC != null && !StringUtils.isNull(ScreenLockActivity.this.luC.getInputMsg()) && (data = ScreenLockActivity.this.luC.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.PUSH_CCLICK).t("msg_id", data.msgId / 100).t("task_id", data.taskId).dn(TiebaInitialize.Params.OBJ_TO, data.url).dn("app_version", TbConfig.getVersion()).ah("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.luC.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().yK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.luC.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.luY);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().yK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ai("lockscreen_reply", true).start();
                a.ddK().luJ.dpl();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.luy = ScreenLockActivity.this.lux.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.luy);
        }
    };
    private View.OnClickListener luF = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.luC != null) {
                ScreenLockActivity.this.luy = ScreenLockActivity.this.luC.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.luy);
            }
        }
    };
    private com.baidu.adp.framework.listener.a luG = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.luA != null) {
                            ScreenLockActivity.this.luA.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.luA.setEnabled(true);
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
                        ArrayList<d> ddQ = data.ddQ();
                        if (ScreenLockActivity.this.lux != null) {
                            ScreenLockActivity.this.lux.eT(ddQ);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.lux.setHasMore(false);
                            if (ScreenLockActivity.this.luA != null) {
                                ScreenLockActivity.this.luw.removeFooterView(ScreenLockActivity.this.luA);
                                ScreenLockActivity.this.luA = null;
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
        this.luv = getWindow();
        this.luv.addFlags(524288);
        this.luv.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.lid = com.baidu.tieba.v.b.dpp();
            if (this.lid != null) {
                this.luv.setBackgroundDrawable(this.lid);
            }
        }
        this.luz = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.luB = new ScreenLockLoadMoreModel(this);
        registerListener(this.luG);
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
        this.gwo = (ImageView) findViewById(R.id.head_close);
        this.gwo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.lux.getCount() > 0 && (item = ScreenLockActivity.this.lux.getItem(0)) != null) {
                    TiebaStatic.log(new ap("c11704").t("msg_id", item.msgId / 100).t("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.ddK().luJ.dpl();
            }
        });
        this.luw = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.lux = new c(getPageContext().getPageActivity());
        this.luw.setAdapter((ListAdapter) this.lux);
        this.luw.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.luD, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.ddK().luP = false;
        this.luw.setMaxHeight(this.luz);
        this.luw.setTranscriptMode(0);
        this.luw.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.luA != null && ScreenLockActivity.this.luA.getParent() != null) {
                    if (ScreenLockActivity.this.luw.getHeight() != ScreenLockActivity.this.luz) {
                        ScreenLockActivity.this.luA.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.luA.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.luA.isEnabled()) {
                            ScreenLockActivity.this.luA.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.luA.setEnabled(false);
                        }
                        ScreenLockActivity.this.cer();
                    }
                }
            }
        });
    }

    private void ddI() {
        this.luA = new TextView(getActivity());
        this.luA.setGravity(17);
        this.luA.setText(R.string.click_load_more);
        this.luA.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.luA.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.luA.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.luA.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.luA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.luA.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.luA.setEnabled(false);
                ScreenLockActivity.this.cer();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(ddJ())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cer() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.luB.ddR();
            if (this.lux != null && this.lux.getCount() > 0 && (item = this.lux.getItem(0)) != null) {
                TiebaStatic.log(new ap("c11738").t("msg_id", item.msgId / 100).t("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.ddK().luM = 1;
        a.ddK().luK = 0;
        List<d> ddM = a.ddK().ddM();
        d ddN = a.ddK().ddN();
        a.ddK().release();
        if ((ddM == null || ddM.isEmpty()) && ddN == null && this.lux.getCount() == 0 && this.luw.getHeaderViewsCount() == 0) {
            a.ddK().luJ.dpl();
            finish();
            return;
        }
        eS(ddM);
        if (ddN != null) {
            a(ddN);
        }
        if (this.luC != null) {
            this.luC.uI(this.lux.getCount() == 0);
        }
    }

    private void eS(List<d> list) {
        if (list != null && list.size() > 0 && this.lux != null) {
            this.lux.eT(list);
            if (this.lux.isHasMore() && this.luA == null) {
                ddI();
                this.luw.addFooterView(this.luA);
            }
        }
    }

    private void a(d dVar) {
        if (this.luC == null) {
            this.luC = new ScreenLockHeaderView(getActivity());
            this.luC.setUIClickListener(this.luE, this.luF);
            this.luC.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.luw.addHeaderView(this.luC);
        }
        this.luC.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.ddK().luM = 0;
        a.ddK().luK = 0;
        if (this.luC != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.luC.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.luD);
        a.ddK().release();
        a.ddK().luM = 0;
        this.lid = null;
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
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.PUSH_CCLICK).t("msg_id", dVar.msgId / 100).t("task_id", dVar.taskId).dn(TiebaInitialize.Params.OBJ_TO, dVar.url).dn("app_version", TbConfig.getVersion()).ah("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                bd.baV().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new ap("c10316").dn("obj_type", dVar.stat).ah("obj_locate", 2));
                a.ddK().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.ddK().d(dVar);
                a.ddK().luJ.dpl();
                if (!a.ddK().luJ.dpn()) {
                    a.ddK().luJ.dpm();
                }
                a.ddK().luK = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.luy.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.luY, 0, dVar.kWe ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.ddK().d(dVar);
                a.ddK().luK = 0;
                a.ddK().luJ.dpl();
                if (!a.ddK().luJ.dpn()) {
                    a.ddK().luJ.dpm();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.luy.groupId, 0L), dVar.groupName, dVar.luY, 0, 4)));
                a.ddK().d(dVar);
                a.ddK().luK = 0;
                a.ddK().luJ.dpl();
                if (!a.ddK().luJ.dpn()) {
                    a.ddK().luJ.dpm();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.ddK().d(dVar);
                a.ddK().luJ.dpl();
                if (!a.ddK().luJ.dpn()) {
                    a.ddK().luJ.dpm();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.ddK().luJ.dpl();
            finish();
            return true;
        } else if (i == 82) {
            a.ddK().luJ.dpl();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String ddJ() {
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
