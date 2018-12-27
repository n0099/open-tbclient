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
    private ImageView eAf;
    public c gWB;
    public d gWC;
    private ScreenLockLoadMoreModel gWF;
    private ScreenLockHeaderView gWG;
    private Window gWz;
    private Drawable gKX = null;
    public DynamicHeightListView gWA = null;
    private int gWD = 0;
    private TextView gWE = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gWH = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(WebSocketAction.PARAM_KEY_REASON)) != null && stringExtra.equals("homekey")) {
                a.bwI().gWN.bIx();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gWI = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.gWG != null && !StringUtils.isNull(ScreenLockActivity.this.gWG.getInputMsg()) && (data = ScreenLockActivity.this.gWG.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").i("msg_id", data.msgId / 100).i("task_id", data.taskId).aA("obj_to", data.url).aA("app_version", TbConfig.getVersion()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gWG.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.HQ().gL(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gWG.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.gXd);
                    com.baidu.tbadk.coreExtra.messageCenter.a.HQ().gL(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bwI().gWN.bIx();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gWC = ScreenLockActivity.this.gWB.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gWC);
        }
    };
    private View.OnClickListener gWJ = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gWG != null) {
                ScreenLockActivity.this.gWC = ScreenLockActivity.this.gWG.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gWC);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gWK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(e.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gWE != null) {
                            ScreenLockActivity.this.gWE.setText(ScreenLockActivity.this.getResources().getString(e.j.data_load_error));
                            ScreenLockActivity.this.gWE.setEnabled(true);
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
                        ArrayList<d> bwO = data.bwO();
                        if (ScreenLockActivity.this.gWB != null) {
                            ScreenLockActivity.this.gWB.dE(bwO);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gWB.setHasMore(false);
                            if (ScreenLockActivity.this.gWE != null) {
                                ScreenLockActivity.this.gWA.removeFooterView(ScreenLockActivity.this.gWE);
                                ScreenLockActivity.this.gWE = null;
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
        this.gWz = getWindow();
        this.gWz.addFlags(524288);
        this.gWz.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(e.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.transparent, true);
        if (l.ln()) {
            this.gKX = com.baidu.tieba.u.a.bIA();
            if (this.gKX != null) {
                this.gWz.setBackgroundDrawable(this.gKX);
            }
        }
        this.gWD = l.h(getPageContext().getPageActivity(), e.C0210e.ds935) - l.h(getPageContext().getPageActivity(), e.C0210e.ds80);
        this.gWF = new ScreenLockLoadMoreModel(this);
        registerListener(this.gWK);
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
        this.eAf = (ImageView) findViewById(e.g.head_close);
        this.eAf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.gWB.getCount() > 0 && (item = ScreenLockActivity.this.gWB.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").i("msg_id", item.msgId / 100).i("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bwI().gWN.bIx();
            }
        });
        this.gWA = (DynamicHeightListView) findViewById(e.g.screenlock_chat_list_content);
        this.gWB = new c(getPageContext().getPageActivity());
        this.gWA.setAdapter((ListAdapter) this.gWB);
        this.gWA.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gWH, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bwI().gWT = false;
        this.gWA.setMaxHeight(this.gWD);
        this.gWA.setTranscriptMode(0);
        this.gWA.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gWE != null && ScreenLockActivity.this.gWE.getParent() != null) {
                    if (ScreenLockActivity.this.gWA.getHeight() != ScreenLockActivity.this.gWD) {
                        ScreenLockActivity.this.gWE.setText(ScreenLockActivity.this.getResources().getString(e.j.click_load_more));
                        ScreenLockActivity.this.gWE.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gWE.isEnabled()) {
                            ScreenLockActivity.this.gWE.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                            ScreenLockActivity.this.gWE.setEnabled(false);
                        }
                        ScreenLockActivity.this.aDT();
                    }
                }
            }
        });
    }

    private void bwG() {
        this.gWE = new TextView(getActivity());
        this.gWE.setGravity(17);
        this.gWE.setText(e.j.click_load_more);
        this.gWE.setHeight((int) getResources().getDimension(e.C0210e.ds80));
        this.gWE.setBackgroundResource(e.f.screen_notify_item_background);
        this.gWE.setTextColor(getResources().getColorStateList(e.d.screen_notify_load_more_text_color));
        this.gWE.setTextSize(0, getResources().getDimension(e.C0210e.fontsize32));
        this.gWE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gWE.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                ScreenLockActivity.this.gWE.setEnabled(false);
                ScreenLockActivity.this.aDT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bwH())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDT() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gWF.bwP();
            if (this.gWB != null && this.gWB.getCount() > 0 && (item = this.gWB.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").i("msg_id", item.msgId / 100).i("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bwI().gWQ = 1;
        a.bwI().gWO = 0;
        List<d> bwK = a.bwI().bwK();
        d bwL = a.bwI().bwL();
        a.bwI().release();
        if ((bwK == null || bwK.isEmpty()) && bwL == null && this.gWB.getCount() == 0 && this.gWA.getHeaderViewsCount() == 0) {
            a.bwI().gWN.bIx();
            finish();
            return;
        }
        dD(bwK);
        if (bwL != null) {
            a(bwL);
        }
        if (this.gWG != null) {
            this.gWG.mU(this.gWB.getCount() == 0);
        }
    }

    private void dD(List<d> list) {
        if (list != null && list.size() > 0 && this.gWB != null) {
            this.gWB.dE(list);
            if (this.gWB.isHasMore() && this.gWE == null) {
                bwG();
                this.gWA.addFooterView(this.gWE);
            }
        }
    }

    private void a(d dVar) {
        if (this.gWG == null) {
            this.gWG = new ScreenLockHeaderView(getActivity());
            this.gWG.setUIClickListener(this.gWI, this.gWJ);
            this.gWG.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gWA.addHeaderView(this.gWG);
        }
        this.gWG.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bwI().gWQ = 0;
        a.bwI().gWO = 0;
        if (this.gWG != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gWG.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gWH);
        a.bwI().release();
        a.bwI().gWQ = 0;
        this.gKX = null;
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
            TiebaStatic.log(new am("c11703").i("msg_id", dVar.msgId / 100).i("task_id", dVar.taskId).aA("obj_to", dVar.url).aA("app_version", TbConfig.getVersion()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.kV()) {
                showToast(getResources().getString(e.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ay.Ef().c(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new am("c10316").aA("obj_type", dVar.stat).x("obj_locate", 2));
                a.bwI().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.bwI().d(dVar);
                a.bwI().gWN.bIx();
                if (!a.bwI().gWN.bIz()) {
                    a.bwI().gWN.bIy();
                }
                a.bwI().gWO = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gWC.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.gXd, 0, dVar.gAs ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bwI().d(dVar);
                a.bwI().gWO = 0;
                a.bwI().gWN.bIx();
                if (!a.bwI().gWN.bIz()) {
                    a.bwI().gWN.bIy();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gWC.groupId, 0L), dVar.groupName, dVar.gXd, 0, 4)));
                a.bwI().d(dVar);
                a.bwI().gWO = 0;
                a.bwI().gWN.bIx();
                if (!a.bwI().gWN.bIz()) {
                    a.bwI().gWN.bIy();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bwI().d(dVar);
                a.bwI().gWN.bIx();
                if (!a.bwI().gWN.bIz()) {
                    a.bwI().gWN.bIy();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bwI().gWN.bIx();
            finish();
            return true;
        } else if (i == 82) {
            a.bwI().gWN.bIx();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bwH() {
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
