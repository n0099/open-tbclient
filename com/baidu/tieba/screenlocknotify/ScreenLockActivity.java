package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
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
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes2.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView bkk;
    private Window flL;
    public q flO;
    public s flP;
    private ScreenLockLoadMoreModel flS;
    private com.baidu.tieba.screenlocknotify.a.a flT;
    private Drawable flM = null;
    public DynamicHeightListView flN = null;
    private int flQ = 0;
    private TextView flR = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver flU = new a(this);
    View.OnClickListener flV = new b(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new c(this);
    private View.OnClickListener flW = new d(this);
    private com.baidu.adp.framework.listener.a flX = new e(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.flL = getWindow();
        this.flL.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.flL.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(w.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(w.e.transparent, true);
        if (com.baidu.adp.lib.util.k.hE()) {
            this.flM = baO();
            if (this.flM != null) {
                this.flL.setBackgroundDrawable(this.flM);
            }
        }
        this.flQ = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds935) - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds80);
        this.flS = new ScreenLockLoadMoreModel(this);
        registerListener(this.flX);
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
        this.bkk = (ImageView) findViewById(w.h.head_close);
        this.bkk.setOnClickListener(new f(this));
        this.flN = (DynamicHeightListView) findViewById(w.h.screenlock_chat_list_content);
        this.flO = new q(getPageContext().getPageActivity());
        this.flN.setAdapter((ListAdapter) this.flO);
        this.flN.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.flU, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        i.baP().fmg = false;
        this.flN.setMaxHeight(this.flQ);
        this.flN.setTranscriptMode(0);
        this.flN.setOnScrollListener(new g(this));
    }

    private void baN() {
        this.flR = new TextView(getActivity());
        this.flR.setGravity(17);
        this.flR.setText(w.l.click_load_more);
        this.flR.setHeight((int) getResources().getDimension(w.f.ds80));
        this.flR.setBackgroundResource(w.g.screen_notify_item_background);
        this.flR.setTextColor(getResources().getColorStateList(w.e.screen_notify_load_more_text_color));
        this.flR.setTextSize(0, getResources().getDimension(w.f.fontsize32));
        this.flR.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aZa())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MC() {
        s item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.flS.baY();
            if (this.flO != null && this.flO.getCount() > 0 && (item = this.flO.getItem(0)) != null) {
                TiebaStatic.log(new as("c11738").f(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i.baP().fmd = 1;
        i.baP().fmb = 0;
        List<s> baR = i.baP().baR();
        s baS = i.baP().baS();
        i.baP().release();
        if ((baR == null || baR.isEmpty()) && baS == null && this.flO.getCount() == 0 && this.flN.getHeaderViewsCount() == 0) {
            i.baP().fma.baU();
            finish();
            return;
        }
        cu(baR);
        if (baS != null) {
            a(baS);
        }
        if (this.flT != null) {
            this.flT.kN(this.flO.getCount() == 0);
        }
    }

    private void cu(List<s> list) {
        if (list != null && list.size() > 0 && this.flO != null) {
            this.flO.cv(list);
            if (this.flO.isHasMore() && this.flR == null) {
                baN();
                this.flN.addFooterView(this.flR);
            }
        }
    }

    private void a(s sVar) {
        if (this.flT == null) {
            this.flT = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.flT.b(this.flV, this.flW);
            this.flT.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.flN.addHeaderView(this.flT);
        }
        this.flT.f(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.baP().fmd = 0;
        i.baP().fmb = 0;
        if (this.flT != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.flT.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.flU);
        i.baP().release();
        i.baP().fmd = 0;
        this.flM = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(s sVar) {
        if (sVar != null) {
            TiebaStatic.log(new as("c11703").f(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId).Z("url", sVar.url).Z("app_version", TbConfig.getVersion()));
            if (!com.baidu.adp.lib.util.i.hk()) {
                showToast(getResources().getString(w.l.neterror));
            } else if (!TextUtils.isEmpty(sVar.url)) {
                bb.vy().c(getPageContext(), new String[]{String.valueOf(sVar.url) + "&is_from_push=true"});
                TiebaStatic.log(new as("c10316").Z("obj_type", sVar.stat).r("obj_locate", 2));
                i.baP().d(sVar);
                finish();
            } else if (sVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(sVar.groupId), sVar.groupName, 0L, "from_lock")));
                i.baP().d(sVar);
                i.baP().fma.baU();
                if (!i.baP().fma.baW()) {
                    i.baP().fma.baV();
                }
                i.baP().fmb = 0;
                finish();
            } else if (sVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.flP.groupId, 0L), sVar.groupName, sVar.fmu, 0, sVar.eLL ? 1 : 0)));
                i.baP().d(sVar);
                i.baP().fmb = 0;
                i.baP().fma.baU();
                if (!i.baP().fma.baW()) {
                    i.baP().fma.baV();
                }
                finish();
            } else if (sVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.flP.groupId, 0L), sVar.groupName, sVar.fmu, 0, 4)));
                i.baP().d(sVar);
                i.baP().fmb = 0;
                i.baP().fma.baU();
                if (!i.baP().fma.baW()) {
                    i.baP().fma.baV();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                i.baP().d(sVar);
                i.baP().fma.baU();
                if (!i.baP().fma.baW()) {
                    i.baP().fma.baV();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i.baP().fma.baU();
            finish();
            return true;
        } else if (i == 82) {
            i.baP().fma.baU();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable baO() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String aZa() {
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
