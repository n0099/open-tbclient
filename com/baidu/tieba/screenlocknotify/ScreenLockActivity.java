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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
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
    private ImageView gnh;
    private Window iQJ;
    public c iQL;
    public d iQM;
    private ScreenLockLoadMoreModel iQP;
    private ScreenLockHeaderView iQQ;
    private Drawable iEd = null;
    public DynamicHeightListView iQK = null;
    private int iQN = 0;
    private TextView iQO = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver iQR = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.chp().iQX.cst();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener iQS = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.iQQ != null && !StringUtils.isNull(ScreenLockActivity.this.iQQ.getInputMsg()) && (data = ScreenLockActivity.this.iQQ.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).p("msg_id", data.msgId / 100).p("task_id", data.taskId).bS(TiebaInitialize.Params.OBJ_TO, data.url).bS("app_version", TbConfig.getVersion()).O("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.iQQ.getInputMsg(), com.baidu.adp.lib.g.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqt().oP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.iQQ.getInputMsg(), com.baidu.adp.lib.g.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.iRn);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqt().oP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.chp().iQX.cst();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.iQM = ScreenLockActivity.this.iQL.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.iQM);
        }
    };
    private View.OnClickListener iQT = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.iQQ != null) {
                ScreenLockActivity.this.iQM = ScreenLockActivity.this.iQQ.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.iQM);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iQU = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.iQO != null) {
                            ScreenLockActivity.this.iQO.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.iQO.setEnabled(true);
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
                        ArrayList<d> chv = data.chv();
                        if (ScreenLockActivity.this.iQL != null) {
                            ScreenLockActivity.this.iQL.eo(chv);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.iQL.setHasMore(false);
                            if (ScreenLockActivity.this.iQO != null) {
                                ScreenLockActivity.this.iQK.removeFooterView(ScreenLockActivity.this.iQO);
                                ScreenLockActivity.this.iQO = null;
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
        this.iQJ = getWindow();
        this.iQJ.addFlags(524288);
        this.iQJ.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.iEd = com.baidu.tieba.t.b.csx();
            if (this.iEd != null) {
                this.iQJ.setBackgroundDrawable(this.iEd);
            }
        }
        this.iQN = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.iQP = new ScreenLockLoadMoreModel(this);
        registerListener(this.iQU);
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
        this.gnh = (ImageView) findViewById(R.id.head_close);
        this.gnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.iQL.getCount() > 0 && (item = ScreenLockActivity.this.iQL.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").p("msg_id", item.msgId / 100).p("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.chp().iQX.cst();
            }
        });
        this.iQK = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.iQL = new c(getPageContext().getPageActivity());
        this.iQK.setAdapter((ListAdapter) this.iQL);
        this.iQK.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.iQR, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.chp().iRd = false;
        this.iQK.setMaxHeight(this.iQN);
        this.iQK.setTranscriptMode(0);
        this.iQK.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.iQO != null && ScreenLockActivity.this.iQO.getParent() != null) {
                    if (ScreenLockActivity.this.iQK.getHeight() != ScreenLockActivity.this.iQN) {
                        ScreenLockActivity.this.iQO.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.iQO.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.iQO.isEnabled()) {
                            ScreenLockActivity.this.iQO.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.iQO.setEnabled(false);
                        }
                        ScreenLockActivity.this.bmw();
                    }
                }
            }
        });
    }

    private void chn() {
        this.iQO = new TextView(getActivity());
        this.iQO.setGravity(17);
        this.iQO.setText(R.string.click_load_more);
        this.iQO.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iQO.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.iQO.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.iQO.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.iQO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.iQO.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.iQO.setEnabled(false);
                ScreenLockActivity.this.bmw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cho())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmw() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.iQP.chw();
            if (this.iQL != null && this.iQL.getCount() > 0 && (item = this.iQL.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").p("msg_id", item.msgId / 100).p("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.chp().iRa = 1;
        a.chp().iQY = 0;
        List<d> chr = a.chp().chr();
        d chs = a.chp().chs();
        a.chp().release();
        if ((chr == null || chr.isEmpty()) && chs == null && this.iQL.getCount() == 0 && this.iQK.getHeaderViewsCount() == 0) {
            a.chp().iQX.cst();
            finish();
            return;
        }
        en(chr);
        if (chs != null) {
            a(chs);
        }
        if (this.iQQ != null) {
            this.iQQ.qm(this.iQL.getCount() == 0);
        }
    }

    private void en(List<d> list) {
        if (list != null && list.size() > 0 && this.iQL != null) {
            this.iQL.eo(list);
            if (this.iQL.isHasMore() && this.iQO == null) {
                chn();
                this.iQK.addFooterView(this.iQO);
            }
        }
    }

    private void a(d dVar) {
        if (this.iQQ == null) {
            this.iQQ = new ScreenLockHeaderView(getActivity());
            this.iQQ.setUIClickListener(this.iQS, this.iQT);
            this.iQQ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.iQK.addHeaderView(this.iQQ);
        }
        this.iQQ.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.chp().iRa = 0;
        a.chp().iQY = 0;
        if (this.iQQ != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.iQQ.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.iQR);
        a.chp().release();
        a.chp().iRa = 0;
        this.iEd = null;
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
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).p("msg_id", dVar.msgId / 100).p("task_id", dVar.taskId).bS(TiebaInitialize.Params.OBJ_TO, dVar.url).bS("app_version", TbConfig.getVersion()).O("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.amQ().b(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new an("c10316").bS("obj_type", dVar.stat).O("obj_locate", 2));
                a.chp().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.chp().d(dVar);
                a.chp().iQX.cst();
                if (!a.chp().iQX.csv()) {
                    a.chp().iQX.csu();
                }
                a.chp().iQY = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(this.iQM.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.iRn, 0, dVar.irU ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.chp().d(dVar);
                a.chp().iQY = 0;
                a.chp().iQX.cst();
                if (!a.chp().iQX.csv()) {
                    a.chp().iQX.csu();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(this.iQM.groupId, 0L), dVar.groupName, dVar.iRn, 0, 4)));
                a.chp().d(dVar);
                a.chp().iQY = 0;
                a.chp().iQX.cst();
                if (!a.chp().iQX.csv()) {
                    a.chp().iQX.csu();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.chp().d(dVar);
                a.chp().iQX.cst();
                if (!a.chp().iQX.csv()) {
                    a.chp().iQX.csu();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.chp().iQX.cst();
            finish();
            return true;
        } else if (i == 82) {
            a.chp().iQX.cst();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cho() {
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
