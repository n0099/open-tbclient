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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView ehf;
    private Window gDQ;
    public c gDS;
    public d gDT;
    private ScreenLockLoadMoreModel gDW;
    private ScreenLockHeaderView gDX;
    private Drawable gso = null;
    public DynamicHeightListView gDR = null;
    private int gDU = 0;
    private TextView gDV = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gDY = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.brr().gEe.bCQ();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gDZ = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.gDX != null && !StringUtils.isNull(ScreenLockActivity.this.gDX.getInputMsg()) && (data = ScreenLockActivity.this.gDX.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").g("msg_id", data.msgId / 100).g("task_id", data.taskId).al("obj_to", data.url).al("app_version", TbConfig.getVersion()).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gDX.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().gc(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gDX.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.gEu);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().gc(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.brr().gEe.bCQ();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gDT = ScreenLockActivity.this.gDS.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gDT);
        }
    };
    private View.OnClickListener gEa = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gDX != null) {
                ScreenLockActivity.this.gDT = ScreenLockActivity.this.gDX.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gDT);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gEb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(e.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gDV != null) {
                            ScreenLockActivity.this.gDV.setText(ScreenLockActivity.this.getResources().getString(e.j.data_load_error));
                            ScreenLockActivity.this.gDV.setEnabled(true);
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
                        ArrayList<d> brx = data.brx();
                        if (ScreenLockActivity.this.gDS != null) {
                            ScreenLockActivity.this.gDS.dn(brx);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gDS.setHasMore(false);
                            if (ScreenLockActivity.this.gDV != null) {
                                ScreenLockActivity.this.gDR.removeFooterView(ScreenLockActivity.this.gDV);
                                ScreenLockActivity.this.gDV = null;
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
        this.gDQ = getWindow();
        this.gDQ.addFlags(524288);
        this.gDQ.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(e.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(e.d.transparent, true);
        if (l.le()) {
            this.gso = com.baidu.tieba.t.a.bCT();
            if (this.gso != null) {
                this.gDQ.setBackgroundDrawable(this.gso);
            }
        }
        this.gDU = l.h(getPageContext().getPageActivity(), e.C0141e.ds935) - l.h(getPageContext().getPageActivity(), e.C0141e.ds80);
        this.gDW = new ScreenLockLoadMoreModel(this);
        registerListener(this.gEb);
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
        this.ehf = (ImageView) findViewById(e.g.head_close);
        this.ehf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.gDS.getCount() > 0 && (item = ScreenLockActivity.this.gDS.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").g("msg_id", item.msgId / 100).g("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.brr().gEe.bCQ();
            }
        });
        this.gDR = (DynamicHeightListView) findViewById(e.g.screenlock_chat_list_content);
        this.gDS = new c(getPageContext().getPageActivity());
        this.gDR.setAdapter((ListAdapter) this.gDS);
        this.gDR.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gDY, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.brr().gEk = false;
        this.gDR.setMaxHeight(this.gDU);
        this.gDR.setTranscriptMode(0);
        this.gDR.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gDV != null && ScreenLockActivity.this.gDV.getParent() != null) {
                    if (ScreenLockActivity.this.gDR.getHeight() != ScreenLockActivity.this.gDU) {
                        ScreenLockActivity.this.gDV.setText(ScreenLockActivity.this.getResources().getString(e.j.click_load_more));
                        ScreenLockActivity.this.gDV.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gDV.isEnabled()) {
                            ScreenLockActivity.this.gDV.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                            ScreenLockActivity.this.gDV.setEnabled(false);
                        }
                        ScreenLockActivity.this.ayD();
                    }
                }
            }
        });
    }

    private void brp() {
        this.gDV = new TextView(getActivity());
        this.gDV.setGravity(17);
        this.gDV.setText(e.j.click_load_more);
        this.gDV.setHeight((int) getResources().getDimension(e.C0141e.ds80));
        this.gDV.setBackgroundResource(e.f.screen_notify_item_background);
        this.gDV.setTextColor(getResources().getColorStateList(e.d.screen_notify_load_more_text_color));
        this.gDV.setTextSize(0, getResources().getDimension(e.C0141e.fontsize32));
        this.gDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gDV.setText(ScreenLockActivity.this.getResources().getString(e.j.loading));
                ScreenLockActivity.this.gDV.setEnabled(false);
                ScreenLockActivity.this.ayD();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(brq())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayD() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gDW.bry();
            if (this.gDS != null && this.gDS.getCount() > 0 && (item = this.gDS.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").g("msg_id", item.msgId / 100).g("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.brr().gEh = 1;
        a.brr().gEf = 0;
        List<d> brt = a.brr().brt();
        d bru = a.brr().bru();
        a.brr().release();
        if ((brt == null || brt.isEmpty()) && bru == null && this.gDS.getCount() == 0 && this.gDR.getHeaderViewsCount() == 0) {
            a.brr().gEe.bCQ();
            finish();
            return;
        }
        dm(brt);
        if (bru != null) {
            a(bru);
        }
        if (this.gDX != null) {
            this.gDX.ml(this.gDS.getCount() == 0);
        }
    }

    private void dm(List<d> list) {
        if (list != null && list.size() > 0 && this.gDS != null) {
            this.gDS.dn(list);
            if (this.gDS.isHasMore() && this.gDV == null) {
                brp();
                this.gDR.addFooterView(this.gDV);
            }
        }
    }

    private void a(d dVar) {
        if (this.gDX == null) {
            this.gDX = new ScreenLockHeaderView(getActivity());
            this.gDX.setUIClickListener(this.gDZ, this.gEa);
            this.gDX.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gDR.addHeaderView(this.gDX);
        }
        this.gDX.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.brr().gEh = 0;
        a.brr().gEf = 0;
        if (this.gDX != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gDX.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gDY);
        a.brr().release();
        a.brr().gEh = 0;
        this.gso = null;
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
            TiebaStatic.log(new am("c11703").g("msg_id", dVar.msgId / 100).g("task_id", dVar.taskId).al("obj_to", dVar.url).al("app_version", TbConfig.getVersion()).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.kK()) {
                showToast(getResources().getString(e.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ay.AN().c(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new am("c10316").al("obj_type", dVar.stat).w("obj_locate", 2));
                a.brr().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.brr().d(dVar);
                a.brr().gEe.bCQ();
                if (!a.brr().gEe.bCS()) {
                    a.brr().gEe.bCR();
                }
                a.brr().gEf = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gDT.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.gEu, 0, dVar.ghK ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.brr().d(dVar);
                a.brr().gEf = 0;
                a.brr().gEe.bCQ();
                if (!a.brr().gEe.bCS()) {
                    a.brr().gEe.bCR();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.gDT.groupId, 0L), dVar.groupName, dVar.gEu, 0, 4)));
                a.brr().d(dVar);
                a.brr().gEf = 0;
                a.brr().gEe.bCQ();
                if (!a.brr().gEe.bCS()) {
                    a.brr().gEe.bCR();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.brr().d(dVar);
                a.brr().gEe.bCQ();
                if (!a.brr().gEe.bCS()) {
                    a.brr().gEe.bCR();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.brr().gEe.bCQ();
            finish();
            return true;
        } else if (i == 82) {
            a.brr().gEe.bCQ();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String brq() {
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
