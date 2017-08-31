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
import android.support.v4.view.accessibility.AccessibilityEventCompat;
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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView btT;
    private Window fKo;
    public c fKr;
    public e fKs;
    private ScreenLockLoadMoreModel fKv;
    private com.baidu.tieba.screenlocknotify.a.a fKw;
    private Drawable fKp = null;
    public DynamicHeightListView fKq = null;
    private int fKt = 0;
    private TextView fKu = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fKx = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bip().fKD.biu();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fKy = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fKw != null && !StringUtils.isNull(ScreenLockActivity.this.fKw.getInputMsg()) && (data = ScreenLockActivity.this.fKw.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).ad("obj_to", data.url).ad(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fKw.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().eL(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fKw.getInputMsg(), com.baidu.adp.lib.g.b.c(data.groupId, 0L), data.userName, data.fKX);
                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().eL(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bip().fKD.biu();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fKs = ScreenLockActivity.this.fKr.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fKs);
        }
    };
    private View.OnClickListener fKz = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fKw != null) {
                ScreenLockActivity.this.fKs = ScreenLockActivity.this.fKw.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fKs);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fKA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.l.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fKu != null) {
                            ScreenLockActivity.this.fKu.setText(ScreenLockActivity.this.getResources().getString(d.l.data_load_error));
                            ScreenLockActivity.this.fKu.setEnabled(true);
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
                        ArrayList<e> bix = data.bix();
                        if (ScreenLockActivity.this.fKr != null) {
                            ScreenLockActivity.this.fKr.db(bix);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fKr.setHasMore(false);
                            if (ScreenLockActivity.this.fKu != null) {
                                ScreenLockActivity.this.fKq.removeFooterView(ScreenLockActivity.this.fKu);
                                ScreenLockActivity.this.fKu = null;
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
        this.fKo = getWindow();
        this.fKo.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fKo.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.transparent, true);
        if (k.hC()) {
            this.fKp = bin();
            if (this.fKp != null) {
                this.fKo.setBackgroundDrawable(this.fKp);
            }
        }
        this.fKt = k.g(getPageContext().getPageActivity(), d.f.ds935) - k.g(getPageContext().getPageActivity(), d.f.ds80);
        this.fKv = new ScreenLockLoadMoreModel(this);
        registerListener(this.fKA);
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
        this.btT = (ImageView) findViewById(d.h.head_close);
        this.btT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fKr.getCount() > 0 && (item = ScreenLockActivity.this.fKr.getItem(0)) != null) {
                    TiebaStatic.log(new ak("c11704").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bip().fKD.biu();
            }
        });
        this.fKq = (DynamicHeightListView) findViewById(d.h.screenlock_chat_list_content);
        this.fKr = new c(getPageContext().getPageActivity());
        this.fKq.setAdapter((ListAdapter) this.fKr);
        this.fKq.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fKx, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bip().fKJ = false;
        this.fKq.setMaxHeight(this.fKt);
        this.fKq.setTranscriptMode(0);
        this.fKq.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fKu != null && ScreenLockActivity.this.fKu.getParent() != null) {
                    if (ScreenLockActivity.this.fKq.getHeight() != ScreenLockActivity.this.fKt) {
                        ScreenLockActivity.this.fKu.setText(ScreenLockActivity.this.getResources().getString(d.l.click_load_more));
                        ScreenLockActivity.this.fKu.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fKu.isEnabled()) {
                            ScreenLockActivity.this.fKu.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                            ScreenLockActivity.this.fKu.setEnabled(false);
                        }
                        ScreenLockActivity.this.NL();
                    }
                }
            }
        });
    }

    private void bim() {
        this.fKu = new TextView(getActivity());
        this.fKu.setGravity(17);
        this.fKu.setText(d.l.click_load_more);
        this.fKu.setHeight((int) getResources().getDimension(d.f.ds80));
        this.fKu.setBackgroundResource(d.g.screen_notify_item_background);
        this.fKu.setTextColor(getResources().getColorStateList(d.e.screen_notify_load_more_text_color));
        this.fKu.setTextSize(0, getResources().getDimension(d.f.fontsize32));
        this.fKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fKu.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                ScreenLockActivity.this.fKu.setEnabled(false);
                ScreenLockActivity.this.NL();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bio())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NL() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fKv.biy();
            if (this.fKr != null && this.fKr.getCount() > 0 && (item = this.fKr.getItem(0)) != null) {
                TiebaStatic.log(new ak("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bip().fKG = 1;
        a.bip().fKE = 0;
        List<e> bir = a.bip().bir();
        e bis = a.bip().bis();
        a.bip().release();
        if ((bir == null || bir.isEmpty()) && bis == null && this.fKr.getCount() == 0 && this.fKq.getHeaderViewsCount() == 0) {
            a.bip().fKD.biu();
            finish();
            return;
        }
        da(bir);
        if (bis != null) {
            a(bis);
        }
        if (this.fKw != null) {
            this.fKw.lQ(this.fKr.getCount() == 0);
        }
    }

    private void da(List<e> list) {
        if (list != null && list.size() > 0 && this.fKr != null) {
            this.fKr.db(list);
            if (this.fKr.isHasMore() && this.fKu == null) {
                bim();
                this.fKq.addFooterView(this.fKu);
            }
        }
    }

    private void a(e eVar) {
        if (this.fKw == null) {
            this.fKw = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fKw.a(this.fKy, this.fKz);
            this.fKw.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fKq.addHeaderView(this.fKw);
        }
        this.fKw.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bip().fKG = 0;
        a.bip().fKE = 0;
        if (this.fKw != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fKw.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fKx);
        a.bip().release();
        a.bip().fKG = 0;
        this.fKp = null;
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new ak("c11703").f(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).ad("obj_to", eVar.url).ad(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!i.hi()) {
                showToast(getResources().getString(d.l.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                au.wd().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new ak("c10316").ad("obj_type", eVar.stat).r("obj_locate", 2));
                a.bip().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.bip().d(eVar);
                a.bip().fKD.biu();
                if (!a.bip().fKD.biw()) {
                    a.bip().fKD.biv();
                }
                a.bip().fKE = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fKs.groupId, 0L), eVar.groupName, eVar.fKX, 0, eVar.fjV ? 1 : 0)));
                a.bip().d(eVar);
                a.bip().fKE = 0;
                a.bip().fKD.biu();
                if (!a.bip().fKD.biw()) {
                    a.bip().fKD.biv();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fKs.groupId, 0L), eVar.groupName, eVar.fKX, 0, 4)));
                a.bip().d(eVar);
                a.bip().fKE = 0;
                a.bip().fKD.biu();
                if (!a.bip().fKD.biw()) {
                    a.bip().fKD.biv();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.bip().d(eVar);
                a.bip().fKD.biu();
                if (!a.bip().fKD.biw()) {
                    a.bip().fKD.biv();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bip().fKD.biu();
            finish();
            return true;
        } else if (i == 82) {
            a.bip().fKD.biu();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable bin() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(k.ad(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(k.ae(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bio() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService("activity")).getRunningTasks(5);
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
