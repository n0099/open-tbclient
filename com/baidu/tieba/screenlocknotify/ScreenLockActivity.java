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
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView gdN;
    private Window kRY;
    public c kSa;
    public d kSb;
    private ScreenLockLoadMoreModel kSe;
    private ScreenLockHeaderView kSf;
    private Drawable kFJ = null;
    public DynamicHeightListView kRZ = null;
    private int kSc = 0;
    private TextView kSd = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver kSg = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.cVX().kSm.dhA();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener kSh = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.kSf != null && !StringUtils.isNull(ScreenLockActivity.this.kSf.getInputMsg()) && (data = ScreenLockActivity.this.kSf.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", data.msgId / 100).s("task_id", data.taskId).dh(TiebaInitialize.Params.OBJ_TO, data.url).dh("app_version", TbConfig.getVersion()).ag("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.kSf.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZl().xm(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.kSf.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.kSB);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZl().xm(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cVX().kSm.dhA();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.kSb = ScreenLockActivity.this.kSa.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.kSb);
        }
    };
    private View.OnClickListener kSi = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.kSf != null) {
                ScreenLockActivity.this.kSb = ScreenLockActivity.this.kSf.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.kSb);
            }
        }
    };
    private com.baidu.adp.framework.listener.a kSj = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.kSd != null) {
                            ScreenLockActivity.this.kSd.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.kSd.setEnabled(true);
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
                        ArrayList<d> cWd = data.cWd();
                        if (ScreenLockActivity.this.kSa != null) {
                            ScreenLockActivity.this.kSa.ex(cWd);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.kSa.setHasMore(false);
                            if (ScreenLockActivity.this.kSd != null) {
                                ScreenLockActivity.this.kRZ.removeFooterView(ScreenLockActivity.this.kSd);
                                ScreenLockActivity.this.kSd = null;
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
        this.kRY = getWindow();
        this.kRY.addFlags(524288);
        this.kRY.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.kFJ = com.baidu.tieba.v.b.dhE();
            if (this.kFJ != null) {
                this.kRY.setBackgroundDrawable(this.kFJ);
            }
        }
        this.kSc = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.kSe = new ScreenLockLoadMoreModel(this);
        registerListener(this.kSj);
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
        this.gdN = (ImageView) findViewById(R.id.head_close);
        this.gdN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.kSa.getCount() > 0 && (item = ScreenLockActivity.this.kSa.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cVX().kSm.dhA();
            }
        });
        this.kRZ = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.kSa = new c(getPageContext().getPageActivity());
        this.kRZ.setAdapter((ListAdapter) this.kSa);
        this.kRZ.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.kSg, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cVX().kSs = false;
        this.kRZ.setMaxHeight(this.kSc);
        this.kRZ.setTranscriptMode(0);
        this.kRZ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.kSd != null && ScreenLockActivity.this.kSd.getParent() != null) {
                    if (ScreenLockActivity.this.kRZ.getHeight() != ScreenLockActivity.this.kSc) {
                        ScreenLockActivity.this.kSd.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.kSd.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.kSd.isEnabled()) {
                            ScreenLockActivity.this.kSd.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.kSd.setEnabled(false);
                        }
                        ScreenLockActivity.this.bXF();
                    }
                }
            }
        });
    }

    private void cVV() {
        this.kSd = new TextView(getActivity());
        this.kSd.setGravity(17);
        this.kSd.setText(R.string.click_load_more);
        this.kSd.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.kSd.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.kSd.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.kSd.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.kSd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.kSd.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.kSd.setEnabled(false);
                ScreenLockActivity.this.bXF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cVW())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXF() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.kSe.cWe();
            if (this.kSa != null && this.kSa.getCount() > 0 && (item = this.kSa.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cVX().kSp = 1;
        a.cVX().kSn = 0;
        List<d> cVZ = a.cVX().cVZ();
        d cWa = a.cVX().cWa();
        a.cVX().release();
        if ((cVZ == null || cVZ.isEmpty()) && cWa == null && this.kSa.getCount() == 0 && this.kRZ.getHeaderViewsCount() == 0) {
            a.cVX().kSm.dhA();
            finish();
            return;
        }
        ew(cVZ);
        if (cWa != null) {
            a(cWa);
        }
        if (this.kSf != null) {
            this.kSf.tP(this.kSa.getCount() == 0);
        }
    }

    private void ew(List<d> list) {
        if (list != null && list.size() > 0 && this.kSa != null) {
            this.kSa.ex(list);
            if (this.kSa.isHasMore() && this.kSd == null) {
                cVV();
                this.kRZ.addFooterView(this.kSd);
            }
        }
    }

    private void a(d dVar) {
        if (this.kSf == null) {
            this.kSf = new ScreenLockHeaderView(getActivity());
            this.kSf.setUIClickListener(this.kSh, this.kSi);
            this.kSf.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.kRZ.addHeaderView(this.kSf);
        }
        this.kSf.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cVX().kSp = 0;
        a.cVX().kSn = 0;
        if (this.kSf != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.kSf.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.kSg);
        a.cVX().release();
        a.cVX().kSp = 0;
        this.kFJ = null;
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
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", dVar.msgId / 100).s("task_id", dVar.taskId).dh(TiebaInitialize.Params.OBJ_TO, dVar.url).dh("app_version", TbConfig.getVersion()).ag("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.aUZ().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new an("c10316").dh("obj_type", dVar.stat).ag("obj_locate", 2));
                a.cVX().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cVX().d(dVar);
                a.cVX().kSm.dhA();
                if (!a.cVX().kSm.dhC()) {
                    a.cVX().kSm.dhB();
                }
                a.cVX().kSn = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kSb.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.kSB, 0, dVar.ksd ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.cVX().d(dVar);
                a.cVX().kSn = 0;
                a.cVX().kSm.dhA();
                if (!a.cVX().kSm.dhC()) {
                    a.cVX().kSm.dhB();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kSb.groupId, 0L), dVar.groupName, dVar.kSB, 0, 4)));
                a.cVX().d(dVar);
                a.cVX().kSn = 0;
                a.cVX().kSm.dhA();
                if (!a.cVX().kSm.dhC()) {
                    a.cVX().kSm.dhB();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cVX().d(dVar);
                a.cVX().kSm.dhA();
                if (!a.cVX().kSm.dhC()) {
                    a.cVX().kSm.dhB();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cVX().kSm.dhA();
            finish();
            return true;
        } else if (i == 82) {
            a.cVX().kSm.dhA();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cVW() {
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
