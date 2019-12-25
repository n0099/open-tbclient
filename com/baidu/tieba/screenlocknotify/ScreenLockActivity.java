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
/* loaded from: classes5.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView fdH;
    private Window jKl;
    public c jKn;
    public d jKo;
    private ScreenLockLoadMoreModel jKr;
    private ScreenLockHeaderView jKs;
    private Drawable jxG = null;
    public DynamicHeightListView jKm = null;
    private int jKp = 0;
    private TextView jKq = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver jKt = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.cBq().jKz.cMt();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener jKu = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.jKs != null && !StringUtils.isNull(ScreenLockActivity.this.jKs.getInputMsg()) && (data = ScreenLockActivity.this.jKs.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", data.msgId / 100).s("task_id", data.taskId).cp(TiebaInitialize.Params.OBJ_TO, data.url).cp("app_version", TbConfig.getVersion()).Z("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.jKs.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aHP().tS(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.jKs.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.jKP);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aHP().tS(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cBq().jKz.cMt();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.jKo = ScreenLockActivity.this.jKn.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.jKo);
        }
    };
    private View.OnClickListener jKv = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.jKs != null) {
                ScreenLockActivity.this.jKo = ScreenLockActivity.this.jKs.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.jKo);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jKw = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.jKq != null) {
                            ScreenLockActivity.this.jKq.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.jKq.setEnabled(true);
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
                        ArrayList<d> items = data.getItems();
                        if (ScreenLockActivity.this.jKn != null) {
                            ScreenLockActivity.this.jKn.eg(items);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.jKn.setHasMore(false);
                            if (ScreenLockActivity.this.jKq != null) {
                                ScreenLockActivity.this.jKm.removeFooterView(ScreenLockActivity.this.jKq);
                                ScreenLockActivity.this.jKq = null;
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
        this.jKl = getWindow();
        this.jKl.addFlags(524288);
        this.jKl.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.jxG = com.baidu.tieba.u.b.cMx();
            if (this.jxG != null) {
                this.jKl.setBackgroundDrawable(this.jxG);
            }
        }
        this.jKp = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.jKr = new ScreenLockLoadMoreModel(this);
        registerListener(this.jKw);
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
        this.fdH = (ImageView) findViewById(R.id.head_close);
        this.fdH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.jKn.getCount() > 0 && (item = ScreenLockActivity.this.jKn.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cBq().jKz.cMt();
            }
        });
        this.jKm = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.jKn = new c(getPageContext().getPageActivity());
        this.jKm.setAdapter((ListAdapter) this.jKn);
        this.jKm.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.jKt, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cBq().jKF = false;
        this.jKm.setMaxHeight(this.jKp);
        this.jKm.setTranscriptMode(0);
        this.jKm.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.jKq != null && ScreenLockActivity.this.jKq.getParent() != null) {
                    if (ScreenLockActivity.this.jKm.getHeight() != ScreenLockActivity.this.jKp) {
                        ScreenLockActivity.this.jKq.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.jKq.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.jKq.isEnabled()) {
                            ScreenLockActivity.this.jKq.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.jKq.setEnabled(false);
                        }
                        ScreenLockActivity.this.bDQ();
                    }
                }
            }
        });
    }

    private void cBo() {
        this.jKq = new TextView(getActivity());
        this.jKq.setGravity(17);
        this.jKq.setText(R.string.click_load_more);
        this.jKq.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.jKq.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.jKq.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.jKq.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.jKq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.jKq.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.jKq.setEnabled(false);
                ScreenLockActivity.this.bDQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cBp())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDQ() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.jKr.cBw();
            if (this.jKn != null && this.jKn.getCount() > 0 && (item = this.jKn.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cBq().jKC = 1;
        a.cBq().jKA = 0;
        List<d> cBs = a.cBq().cBs();
        d cBt = a.cBq().cBt();
        a.cBq().release();
        if ((cBs == null || cBs.isEmpty()) && cBt == null && this.jKn.getCount() == 0 && this.jKm.getHeaderViewsCount() == 0) {
            a.cBq().jKz.cMt();
            finish();
            return;
        }
        ef(cBs);
        if (cBt != null) {
            a(cBt);
        }
        if (this.jKs != null) {
            this.jKs.rV(this.jKn.getCount() == 0);
        }
    }

    private void ef(List<d> list) {
        if (list != null && list.size() > 0 && this.jKn != null) {
            this.jKn.eg(list);
            if (this.jKn.isHasMore() && this.jKq == null) {
                cBo();
                this.jKm.addFooterView(this.jKq);
            }
        }
    }

    private void a(d dVar) {
        if (this.jKs == null) {
            this.jKs = new ScreenLockHeaderView(getActivity());
            this.jKs.setUIClickListener(this.jKu, this.jKv);
            this.jKs.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.jKm.addHeaderView(this.jKs);
        }
        this.jKs.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cBq().jKC = 0;
        a.cBq().jKA = 0;
        if (this.jKs != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.jKs.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.jKt);
        a.cBq().release();
        a.cBq().jKC = 0;
        this.jxG = null;
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
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", dVar.msgId / 100).s("task_id", dVar.taskId).cp(TiebaInitialize.Params.OBJ_TO, dVar.url).cp("app_version", TbConfig.getVersion()).Z("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.aEa().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new an("c10316").cp("obj_type", dVar.stat).Z("obj_locate", 2));
                a.cBq().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cBq().d(dVar);
                a.cBq().jKz.cMt();
                if (!a.cBq().jKz.cMv()) {
                    a.cBq().jKz.cMu();
                }
                a.cBq().jKA = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jKo.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.jKP, 0, dVar.jjF ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.cBq().d(dVar);
                a.cBq().jKA = 0;
                a.cBq().jKz.cMt();
                if (!a.cBq().jKz.cMv()) {
                    a.cBq().jKz.cMu();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jKo.groupId, 0L), dVar.groupName, dVar.jKP, 0, 4)));
                a.cBq().d(dVar);
                a.cBq().jKA = 0;
                a.cBq().jKz.cMt();
                if (!a.cBq().jKz.cMv()) {
                    a.cBq().jKz.cMu();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cBq().d(dVar);
                a.cBq().jKz.cMt();
                if (!a.cBq().jKz.cMv()) {
                    a.cBq().jKz.cMu();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cBq().jKz.cMt();
            finish();
            return true;
        } else if (i == 82) {
            a.cBq().jKz.cMt();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cBp() {
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
