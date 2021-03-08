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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.AdExtParam;
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
/* loaded from: classes7.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView izx;
    private Window nem;
    public c neo;
    public d nep;
    private ScreenLockLoadMoreModel nes;
    private ScreenLockHeaderView neu;
    private Drawable mPV = null;
    public DynamicHeightListView nen = null;
    private int neq = 0;
    private TextView ner = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver nev = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dFx().neB.dRZ();
                ScreenLockActivity.this.finish();
            }
        }
    };

    /* renamed from: new  reason: not valid java name */
    View.OnClickListener f5new = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.neu != null && !StringUtils.isNull(ScreenLockActivity.this.neu.getInputMsg()) && (data = ScreenLockActivity.this.neu.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.PUSH_CCLICK).v("msg_id", data.msgId / 100).v("task_id", data.taskId).v(Constants.EXTRA_SERVICE, data.serviceId).dR(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, data.url).dR("app_version", TbConfig.getVersion()).aq("obj_source", 2).aq("obj_id", TbadkCoreApplication.getInst().getStartType()).aq("obj_ishost", 1));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.neu.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().Ch(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.neu.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.neR);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().Ch(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new aj("lockscreen_reply", true).start();
                a.dFx().neB.dRZ();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.nep = ScreenLockActivity.this.neo.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.nep);
        }
    };
    private View.OnClickListener nex = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.neu != null) {
                ScreenLockActivity.this.nep = ScreenLockActivity.this.neu.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.nep);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ney = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.ner != null) {
                            ScreenLockActivity.this.ner.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.ner.setEnabled(true);
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
                        ArrayList<d> dFD = data.dFD();
                        if (ScreenLockActivity.this.neo != null) {
                            ScreenLockActivity.this.neo.fP(dFD);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.neo.setHasMore(false);
                            if (ScreenLockActivity.this.ner != null) {
                                ScreenLockActivity.this.nen.removeFooterView(ScreenLockActivity.this.ner);
                                ScreenLockActivity.this.ner = null;
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
        this.nem = getWindow();
        this.nem.addFlags(524288);
        this.nem.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.mPV = com.baidu.tieba.v.b.dSd();
            if (this.mPV != null) {
                this.nem.setBackgroundDrawable(this.mPV);
            }
        }
        this.neq = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.nes = new ScreenLockLoadMoreModel(this);
        registerListener(this.ney);
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
        this.izx = (ImageView) findViewById(R.id.head_close);
        this.izx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.neo.getCount() > 0 && (item = ScreenLockActivity.this.neo.getItem(0)) != null) {
                    TiebaStatic.log(new ar("c11704").v("msg_id", item.msgId / 100).v("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dFx().neB.dRZ();
            }
        });
        this.nen = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.neo = new c(getPageContext().getPageActivity());
        this.nen.setAdapter((ListAdapter) this.neo);
        this.nen.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.nev, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dFx().neH = false;
        this.nen.setMaxHeight(this.neq);
        this.nen.setTranscriptMode(0);
        this.nen.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.ner != null && ScreenLockActivity.this.ner.getParent() != null) {
                    if (ScreenLockActivity.this.nen.getHeight() != ScreenLockActivity.this.neq) {
                        ScreenLockActivity.this.ner.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.ner.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.ner.isEnabled()) {
                            ScreenLockActivity.this.ner.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.ner.setEnabled(false);
                        }
                        ScreenLockActivity.this.cFL();
                    }
                }
            }
        });
    }

    private void cRc() {
        this.ner = new TextView(getActivity());
        this.ner.setGravity(17);
        this.ner.setText(R.string.click_load_more);
        this.ner.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.ner.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.ner.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.ner.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.ner.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.ner.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.ner.setEnabled(false);
                ScreenLockActivity.this.cFL();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dFw())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFL() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.nes.dFE();
            if (this.neo != null && this.neo.getCount() > 0 && (item = this.neo.getItem(0)) != null) {
                TiebaStatic.log(new ar("c11738").v("msg_id", item.msgId / 100).v("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dFx().neE = 1;
        a.dFx().neC = 0;
        List<d> dFz = a.dFx().dFz();
        d dFA = a.dFx().dFA();
        a.dFx().release();
        if ((dFz == null || dFz.isEmpty()) && dFA == null && this.neo.getCount() == 0 && this.nen.getHeaderViewsCount() == 0) {
            a.dFx().neB.dRZ();
            finish();
            return;
        }
        fO(dFz);
        if (dFA != null) {
            a(dFA);
        }
        if (this.neu != null) {
            this.neu.xL(this.neo.getCount() == 0);
        }
    }

    private void fO(List<d> list) {
        if (list != null && list.size() > 0 && this.neo != null) {
            this.neo.fP(list);
            if (this.neo.isHasMore() && this.ner == null) {
                cRc();
                this.nen.addFooterView(this.ner);
            }
        }
    }

    private void a(d dVar) {
        if (this.neu == null) {
            this.neu = new ScreenLockHeaderView(getActivity());
            this.neu.setUIClickListener(this.f5new, this.nex);
            this.neu.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.nen.addHeaderView(this.neu);
        }
        this.neu.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dFx().neE = 0;
        a.dFx().neC = 0;
        if (this.neu != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.neu.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.nev);
        a.dFx().release();
        a.dFx().neE = 0;
        this.mPV = null;
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
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.PUSH_CCLICK).v("msg_id", dVar.msgId / 100).v("task_id", dVar.taskId).v(Constants.EXTRA_SERVICE, dVar.serviceId).dR(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, dVar.url).dR("app_version", TbConfig.getVersion()).aq("obj_source", i).aq("obj_id", TbadkCoreApplication.getInst().getStartType()).aq("obj_ishost", 1));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                bf.bsY().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new ar("c10316").dR("obj_type", dVar.stat).aq("obj_locate", 2));
                a.dFx().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dFx().d(dVar);
                a.dFx().neB.dRZ();
                if (!a.dFx().neB.dSb()) {
                    a.dFx().neB.dSa();
                }
                a.dFx().neC = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.nep.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.neR, 0, dVar.mDo ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dFx().d(dVar);
                a.dFx().neC = 0;
                a.dFx().neB.dRZ();
                if (!a.dFx().neB.dSb()) {
                    a.dFx().neB.dSa();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.nep.groupId, 0L), dVar.groupName, dVar.neR, 0, 4)));
                a.dFx().d(dVar);
                a.dFx().neC = 0;
                a.dFx().neB.dRZ();
                if (!a.dFx().neB.dSb()) {
                    a.dFx().neB.dSa();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dFx().d(dVar);
                a.dFx().neB.dRZ();
                if (!a.dFx().neB.dSb()) {
                    a.dFx().neB.dSa();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dFx().neB.dRZ();
            finish();
            return true;
        } else if (i == 82) {
            a.dFx().neB.dRZ();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dFw() {
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
