package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView efa;
    private Window gRL;
    public c gRO;
    public e gRP;
    private ScreenLockLoadMoreModel gRS;
    private com.baidu.tieba.screenlocknotify.a.a gRT;
    private Drawable gRM = null;
    public DynamicHeightListView gRN = null;
    private int gRQ = 0;
    private TextView gRR = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver gRU = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.buI().gSa.buN();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener gRV = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.gRT != null && !StringUtils.isNull(ScreenLockActivity.this.gRT.getInputMsg()) && (data = ScreenLockActivity.this.gRT.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f("msg_id", data.msgId / 100).f("task_id", data.taskId).ab("obj_to", data.url).ab(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.gRT.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gm().eW(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.gRT.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.gSu);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gm().eW(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.buI().gSa.buN();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.gRP = ScreenLockActivity.this.gRO.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.gRP);
        }
    };
    private View.OnClickListener gRW = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.gRT != null) {
                ScreenLockActivity.this.gRP = ScreenLockActivity.this.gRT.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.gRP);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gRX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.gRR != null) {
                            ScreenLockActivity.this.gRR.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.gRR.setEnabled(true);
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
                        ArrayList<e> buQ = data.buQ();
                        if (ScreenLockActivity.this.gRO != null) {
                            ScreenLockActivity.this.gRO.dx(buQ);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.gRO.setHasMore(false);
                            if (ScreenLockActivity.this.gRR != null) {
                                ScreenLockActivity.this.gRN.removeFooterView(ScreenLockActivity.this.gRR);
                                ScreenLockActivity.this.gRR = null;
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
        this.gRL = getWindow();
        this.gRL.addFlags(524288);
        this.gRL.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0108d.transparent, true);
        if (l.pc()) {
            this.gRM = buG();
            if (this.gRM != null) {
                this.gRL.setBackgroundDrawable(this.gRM);
            }
        }
        this.gRQ = l.s(getPageContext().getPageActivity(), d.e.ds935) - l.s(getPageContext().getPageActivity(), d.e.ds80);
        this.gRS = new ScreenLockLoadMoreModel(this);
        registerListener(this.gRX);
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
        this.efa = (ImageView) findViewById(d.g.head_close);
        this.efa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.gRO.getCount() > 0 && (item = ScreenLockActivity.this.gRO.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.buI().gSa.buN();
            }
        });
        this.gRN = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.gRO = new c(getPageContext().getPageActivity());
        this.gRN.setAdapter((ListAdapter) this.gRO);
        this.gRN.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.gRU, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.buI().gSg = false;
        this.gRN.setMaxHeight(this.gRQ);
        this.gRN.setTranscriptMode(0);
        this.gRN.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.gRR != null && ScreenLockActivity.this.gRR.getParent() != null) {
                    if (ScreenLockActivity.this.gRN.getHeight() != ScreenLockActivity.this.gRQ) {
                        ScreenLockActivity.this.gRR.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.gRR.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.gRR.isEnabled()) {
                            ScreenLockActivity.this.gRR.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.gRR.setEnabled(false);
                        }
                        ScreenLockActivity.this.Xd();
                    }
                }
            }
        });
    }

    private void buF() {
        this.gRR = new TextView(getActivity());
        this.gRR.setGravity(17);
        this.gRR.setText(d.j.click_load_more);
        this.gRR.setHeight((int) getResources().getDimension(d.e.ds80));
        this.gRR.setBackgroundResource(d.f.screen_notify_item_background);
        this.gRR.setTextColor(getResources().getColorStateList(d.C0108d.screen_notify_load_more_text_color));
        this.gRR.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.gRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.gRR.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.gRR.setEnabled(false);
                ScreenLockActivity.this.Xd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(buH())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xd() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.gRS.buR();
            if (this.gRO != null && this.gRO.getCount() > 0 && (item = this.gRO.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f("msg_id", item.msgId / 100).f("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.buI().gSd = 1;
        a.buI().gSb = 0;
        List<e> buK = a.buI().buK();
        e buL = a.buI().buL();
        a.buI().release();
        if ((buK == null || buK.isEmpty()) && buL == null && this.gRO.getCount() == 0 && this.gRN.getHeaderViewsCount() == 0) {
            a.buI().gSa.buN();
            finish();
            return;
        }
        dw(buK);
        if (buL != null) {
            a(buL);
        }
        if (this.gRT != null) {
            this.gRT.mS(this.gRO.getCount() == 0);
        }
    }

    private void dw(List<e> list) {
        if (list != null && list.size() > 0 && this.gRO != null) {
            this.gRO.dx(list);
            if (this.gRO.isHasMore() && this.gRR == null) {
                buF();
                this.gRN.addFooterView(this.gRR);
            }
        }
    }

    private void a(e eVar) {
        if (this.gRT == null) {
            this.gRT = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.gRT.a(this.gRV, this.gRW);
            this.gRT.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gRN.addHeaderView(this.gRT);
        }
        this.gRT.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.buI().gSd = 0;
        a.buI().gSb = 0;
        if (this.gRT != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gRT.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.gRU);
        a.buI().release();
        a.buI().gSd = 0;
        this.gRM = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId).ab("obj_to", eVar.url).ab(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!j.oI()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                av.Di().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ab("obj_type", eVar.stat).s("obj_locate", 2));
                a.buI().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.buI().d(eVar);
                a.buI().gSa.buN();
                if (!a.buI().gSa.buP()) {
                    a.buI().gSa.buO();
                }
                a.buI().gSb = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gRP.groupId, 0L), eVar.groupName, eVar.gSu, 0, eVar.glz ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(eVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.buI().d(eVar);
                a.buI().gSb = 0;
                a.buI().gSa.buN();
                if (!a.buI().gSa.buP()) {
                    a.buI().gSa.buO();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.gRP.groupId, 0L), eVar.groupName, eVar.gSu, 0, 4)));
                a.buI().d(eVar);
                a.buI().gSb = 0;
                a.buI().gSa.buN();
                if (!a.buI().gSa.buP()) {
                    a.buI().gSa.buO();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.buI().d(eVar);
                a.buI().gSa.buN();
                if (!a.buI().gSa.buP()) {
                    a.buI().gSa.buO();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.buI().gSa.buN();
            finish();
            return true;
        } else if (i == 82) {
            a.buI().gSa.buN();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable buG() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.ao(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(l.aq(getPageContext().getPageActivity()), bitmap.getHeight());
                try {
                    return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
                } catch (Throwable th) {
                    try {
                        return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
                    } catch (Throwable th2) {
                        BdLog.e(th2.getMessage());
                        return null;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String buH() {
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
