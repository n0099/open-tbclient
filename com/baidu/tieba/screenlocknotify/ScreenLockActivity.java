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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
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
    private ImageView bsS;
    private ScreenLockLoadMoreModel fKC;
    private com.baidu.tieba.screenlocknotify.a.a fKD;
    private Window fKv;
    public c fKy;
    public e fKz;
    private Drawable fKw = null;
    public DynamicHeightListView fKx = null;
    private int fKA = 0;
    private TextView fKB = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fKE = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.biP().fKK.biU();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener fKF = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e data;
            if (ScreenLockActivity.this.fKD != null && !StringUtils.isNull(ScreenLockActivity.this.fKD.getInputMsg()) && (data = ScreenLockActivity.this.fKD.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aj("c11703").g(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId).aa("obj_to", data.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.fKD.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().eN(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.fKD.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.fLe);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().eN(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new af("lockscreen_reply", true).start();
                a.biP().fKK.biU();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.fKz = ScreenLockActivity.this.fKy.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.fKz);
        }
    };
    private View.OnClickListener fKG = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.fKD != null) {
                ScreenLockActivity.this.fKz = ScreenLockActivity.this.fKD.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.fKz);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fKH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.l.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.fKB != null) {
                            ScreenLockActivity.this.fKB.setText(ScreenLockActivity.this.getResources().getString(d.l.data_load_error));
                            ScreenLockActivity.this.fKB.setEnabled(true);
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
                        ArrayList<e> biX = data.biX();
                        if (ScreenLockActivity.this.fKy != null) {
                            ScreenLockActivity.this.fKy.db(biX);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.fKy.setHasMore(false);
                            if (ScreenLockActivity.this.fKB != null) {
                                ScreenLockActivity.this.fKx.removeFooterView(ScreenLockActivity.this.fKB);
                                ScreenLockActivity.this.fKB = null;
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
        this.fKv = getWindow();
        this.fKv.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fKv.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.e.transparent, true);
        if (k.hL()) {
            this.fKw = biO();
            if (this.fKw != null) {
                this.fKv.setBackgroundDrawable(this.fKw);
            }
        }
        this.fKA = k.g(getPageContext().getPageActivity(), d.f.ds935) - k.g(getPageContext().getPageActivity(), d.f.ds80);
        this.fKC = new ScreenLockLoadMoreModel(this);
        registerListener(this.fKH);
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
        this.bsS = (ImageView) findViewById(d.h.head_close);
        this.bsS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e item;
                if (ScreenLockActivity.this.fKy.getCount() > 0 && (item = ScreenLockActivity.this.fKy.getItem(0)) != null) {
                    TiebaStatic.log(new aj("c11704").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.biP().fKK.biU();
            }
        });
        this.fKx = (DynamicHeightListView) findViewById(d.h.screenlock_chat_list_content);
        this.fKy = new c(getPageContext().getPageActivity());
        this.fKx.setAdapter((ListAdapter) this.fKy);
        this.fKx.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fKE, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.biP().fKQ = false;
        this.fKx.setMaxHeight(this.fKA);
        this.fKx.setTranscriptMode(0);
        this.fKx.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.fKB != null && ScreenLockActivity.this.fKB.getParent() != null) {
                    if (ScreenLockActivity.this.fKx.getHeight() != ScreenLockActivity.this.fKA) {
                        ScreenLockActivity.this.fKB.setText(ScreenLockActivity.this.getResources().getString(d.l.click_load_more));
                        ScreenLockActivity.this.fKB.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.fKB.isEnabled()) {
                            ScreenLockActivity.this.fKB.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                            ScreenLockActivity.this.fKB.setEnabled(false);
                        }
                        ScreenLockActivity.this.Nv();
                    }
                }
            }
        });
    }

    private void biN() {
        this.fKB = new TextView(getActivity());
        this.fKB.setGravity(17);
        this.fKB.setText(d.l.click_load_more);
        this.fKB.setHeight((int) getResources().getDimension(d.f.ds80));
        this.fKB.setBackgroundResource(d.g.screen_notify_item_background);
        this.fKB.setTextColor(getResources().getColorStateList(d.e.screen_notify_load_more_text_color));
        this.fKB.setTextSize(0, getResources().getDimension(d.f.fontsize32));
        this.fKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.fKB.setText(ScreenLockActivity.this.getResources().getString(d.l.loading));
                ScreenLockActivity.this.fKB.setEnabled(false);
                ScreenLockActivity.this.Nv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bgV())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nv() {
        e item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fKC.biY();
            if (this.fKy != null && this.fKy.getCount() > 0 && (item = this.fKy.getItem(0)) != null) {
                TiebaStatic.log(new aj("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.biP().fKN = 1;
        a.biP().fKL = 0;
        List<e> biR = a.biP().biR();
        e biS = a.biP().biS();
        a.biP().release();
        if ((biR == null || biR.isEmpty()) && biS == null && this.fKy.getCount() == 0 && this.fKx.getHeaderViewsCount() == 0) {
            a.biP().fKK.biU();
            finish();
            return;
        }
        da(biR);
        if (biS != null) {
            a(biS);
        }
        if (this.fKD != null) {
            this.fKD.lH(this.fKy.getCount() == 0);
        }
    }

    private void da(List<e> list) {
        if (list != null && list.size() > 0 && this.fKy != null) {
            this.fKy.db(list);
            if (this.fKy.isHasMore() && this.fKB == null) {
                biN();
                this.fKx.addFooterView(this.fKB);
            }
        }
    }

    private void a(e eVar) {
        if (this.fKD == null) {
            this.fKD = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.fKD.b(this.fKF, this.fKG);
            this.fKD.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fKx.addHeaderView(this.fKD);
        }
        this.fKD.f(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.biP().fKN = 0;
        a.biP().fKL = 0;
        if (this.fKD != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.fKD.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fKE);
        a.biP().release();
        a.biP().fKN = 0;
        this.fKw = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(e eVar) {
        if (eVar != null) {
            TiebaStatic.log(new aj("c11703").g(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId).aa("obj_to", eVar.url).aa(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()));
            if (!i.hr()) {
                showToast(getResources().getString(d.l.neterror));
            } else if (!TextUtils.isEmpty(eVar.url)) {
                at.wf().c(getPageContext(), new String[]{eVar.url + "&is_from_push=true"});
                TiebaStatic.log(new aj("c10316").aa("obj_type", eVar.stat).r("obj_locate", 2));
                a.biP().d(eVar);
                finish();
            } else if (eVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(eVar.groupId), eVar.groupName, 0L, "from_lock")));
                a.biP().d(eVar);
                a.biP().fKK.biU();
                if (!a.biP().fKK.biW()) {
                    a.biP().fKK.biV();
                }
                a.biP().fKL = 0;
                finish();
            } else if (eVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.fKz.groupId, 0L), eVar.groupName, eVar.fLe, 0, eVar.fjG ? 1 : 0)));
                a.biP().d(eVar);
                a.biP().fKL = 0;
                a.biP().fKK.biU();
                if (!a.biP().fKK.biW()) {
                    a.biP().fKK.biV();
                }
                finish();
            } else if (eVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.fKz.groupId, 0L), eVar.groupName, eVar.fLe, 0, 4)));
                a.biP().d(eVar);
                a.biP().fKL = 0;
                a.biP().fKK.biU();
                if (!a.biP().fKK.biW()) {
                    a.biP().fKK.biV();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                a.biP().d(eVar);
                a.biP().fKK.biU();
                if (!a.biP().fKK.biW()) {
                    a.biP().fKK.biV();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.biP().fKK.biU();
            finish();
            return true;
        } else if (i == 82) {
            a.biP().fKK.biU();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable biO() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(k.ag(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(k.ah(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String bgV() {
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
