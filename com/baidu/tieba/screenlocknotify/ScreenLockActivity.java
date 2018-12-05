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
    private ImageView exm;
    private Window gTE;
    public c gTG;
    public d gTH;
    private ScreenLockLoadMoreModel gTK;
    private ScreenLockHeaderView gTL;
    private Drawable gIg = null;
    public DynamicHeightListView gTF = null;
    private int gTI = 0;
    private TextView gTJ = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gTM = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(WebSocketAction.PARAM_KEY_REASON)) != null && stringExtra.equals("homekey")) {
                a.bvV().gTS.bHI();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gTN = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.gTL != null && !StringUtils.isNull(ScreenLockActivity.this.gTL.getInputMsg()) && (data = ScreenLockActivity.this.gTL.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").i("msg_id", data.msgId / 100).i("task_id", data.taskId).aA("obj_to", data.url).aA("app_version", TbConfig.getVersion()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gTL.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.HP().gK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gTL.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.gUi);
                    com.baidu.tbadk.coreExtra.messageCenter.a.HP().gK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bvV().gTS.bHI();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gTH = ScreenLockActivity.this.gTG.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gTH);
        }
    };
    private View.OnClickListener gTO = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gTL != null) {
                ScreenLockActivity.this.gTH = ScreenLockActivity.this.gTL.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gTH);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gTP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(e.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gTJ != null) {
                            ScreenLockActivity.this.gTJ.setText(ScreenLockActivity.this.getResources().getString(e.j.data_load_error));
                            ScreenLockActivity.this.gTJ.setEnabled(true);
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
                        ArrayList<d> bwb = data.bwb();
                        if (ScreenLockActivity.this.gTG != null) {
                            ScreenLockActivity.this.gTG.dD(bwb);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gTG.setHasMore(false);
                            if (ScreenLockActivity.this.gTJ != null) {
                                ScreenLockActivity.this.gTF.removeFooterView(ScreenLockActivity.this.gTJ);
                                ScreenLockActivity.this.gTJ = null;
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
        this.gTE = getWindow();
        this.gTE.addFlags(524288);
        this.gTE.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(e.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.transparent, true);
        if (l.ln()) {
            this.gIg = com.baidu.tieba.t.a.bHL();
            if (this.gIg != null) {
                this.gTE.setBackgroundDrawable(this.gIg);
            }
        }
        this.gTI = l.h(getPageContext().getPageActivity(), e.C0210e.ds935) - l.h(getPageContext().getPageActivity(), e.C0210e.ds80);
        this.gTK = new ScreenLockLoadMoreModel(this);
        registerListener(this.gTP);
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
        this.exm = (ImageView) findViewById(e.g.head_close);
        this.exm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.gTG.getCount() > 0 && (item = ScreenLockActivity.this.gTG.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").i("msg_id", item.msgId / 100).i("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bvV().gTS.bHI();
            }
        });
        this.gTF = (DynamicHeightListView) findViewById(e.g.screenlock_chat_list_content);
        this.gTG = new c(getPageContext().getPageActivity());
        this.gTF.setAdapter((ListAdapter) this.gTG);
        this.gTF.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gTM, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bvV().gTY = false;
        this.gTF.setMaxHeight(this.gTI);
        this.gTF.setTranscriptMode(0);
        this.gTF.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gTJ != null && ScreenLockActivity.this.gTJ.getParent() != null) {
                    if (ScreenLockActivity.this.gTF.getHeight() != ScreenLockActivity.this.gTI) {
                        ScreenLockActivity.this.gTJ.setText(ScreenLockActivity.this.getResources().getString(e.j.click_load_more));
                        ScreenLockActivity.this.gTJ.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gTJ.isEnabled()) {
                            ScreenLockActivity.this.gTJ.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                            ScreenLockActivity.this.gTJ.setEnabled(false);
                        }
                        ScreenLockActivity.this.aDe();
                    }
                }
            }
        });
    }

    private void bvT() {
        this.gTJ = new TextView(getActivity());
        this.gTJ.setGravity(17);
        this.gTJ.setText(e.j.click_load_more);
        this.gTJ.setHeight((int) getResources().getDimension(e.C0210e.ds80));
        this.gTJ.setBackgroundResource(e.f.screen_notify_item_background);
        this.gTJ.setTextColor(getResources().getColorStateList(e.d.screen_notify_load_more_text_color));
        this.gTJ.setTextSize(0, getResources().getDimension(e.C0210e.fontsize32));
        this.gTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gTJ.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                ScreenLockActivity.this.gTJ.setEnabled(false);
                ScreenLockActivity.this.aDe();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bvU())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDe() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gTK.bwc();
            if (this.gTG != null && this.gTG.getCount() > 0 && (item = this.gTG.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").i("msg_id", item.msgId / 100).i("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bvV().gTV = 1;
        a.bvV().gTT = 0;
        List<d> bvX = a.bvV().bvX();
        d bvY = a.bvV().bvY();
        a.bvV().release();
        if ((bvX == null || bvX.isEmpty()) && bvY == null && this.gTG.getCount() == 0 && this.gTF.getHeaderViewsCount() == 0) {
            a.bvV().gTS.bHI();
            finish();
            return;
        }
        dC(bvX);
        if (bvY != null) {
            a(bvY);
        }
        if (this.gTL != null) {
            this.gTL.mR(this.gTG.getCount() == 0);
        }
    }

    private void dC(List<d> list) {
        if (list != null && list.size() > 0 && this.gTG != null) {
            this.gTG.dD(list);
            if (this.gTG.isHasMore() && this.gTJ == null) {
                bvT();
                this.gTF.addFooterView(this.gTJ);
            }
        }
    }

    private void a(d dVar) {
        if (this.gTL == null) {
            this.gTL = new ScreenLockHeaderView(getActivity());
            this.gTL.setUIClickListener(this.gTN, this.gTO);
            this.gTL.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gTF.addHeaderView(this.gTL);
        }
        this.gTL.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bvV().gTV = 0;
        a.bvV().gTT = 0;
        if (this.gTL != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gTL.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gTM);
        a.bvV().release();
        a.bvV().gTV = 0;
        this.gIg = null;
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
                a.bvV().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.bvV().d(dVar);
                a.bvV().gTS.bHI();
                if (!a.bvV().gTS.bHK()) {
                    a.bvV().gTS.bHJ();
                }
                a.bvV().gTT = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gTH.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.gUi, 0, dVar.gxB ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bvV().d(dVar);
                a.bvV().gTT = 0;
                a.bvV().gTS.bHI();
                if (!a.bvV().gTS.bHK()) {
                    a.bvV().gTS.bHJ();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gTH.groupId, 0L), dVar.groupName, dVar.gUi, 0, 4)));
                a.bvV().d(dVar);
                a.bvV().gTT = 0;
                a.bvV().gTS.bHI();
                if (!a.bvV().gTS.bHK()) {
                    a.bvV().gTS.bHJ();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bvV().d(dVar);
                a.bvV().gTS.bHI();
                if (!a.bvV().gTS.bHK()) {
                    a.bvV().gTS.bHJ();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bvV().gTS.bHI();
            finish();
            return true;
        } else if (i == 82) {
            a.bvV().gTS.bHI();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bvU() {
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
