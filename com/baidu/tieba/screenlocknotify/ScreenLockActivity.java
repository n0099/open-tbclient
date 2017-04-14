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
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView bgD;
    private Window ffF;
    public q ffI;
    public s ffJ;
    private ScreenLockLoadMoreModel ffM;
    private com.baidu.tieba.screenlocknotify.a.a ffN;
    private Drawable ffG = null;
    public DynamicHeightListView ffH = null;
    private int ffK = 0;
    private TextView ffL = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver ffO = new a(this);
    View.OnClickListener ffP = new b(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new c(this);
    private View.OnClickListener ffQ = new d(this);
    private com.baidu.adp.framework.listener.a ffR = new e(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.ffF = getWindow();
        this.ffF.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.ffF.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(w.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(w.e.transparent, true);
        if (com.baidu.adp.lib.util.k.hD()) {
            this.ffG = baU();
            if (this.ffG != null) {
                this.ffF.setBackgroundDrawable(this.ffG);
            }
        }
        this.ffK = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds935) - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds80);
        this.ffM = new ScreenLockLoadMoreModel(this);
        registerListener(this.ffR);
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
        this.bgD = (ImageView) findViewById(w.h.head_close);
        this.bgD.setOnClickListener(new f(this));
        this.ffH = (DynamicHeightListView) findViewById(w.h.screenlock_chat_list_content);
        this.ffI = new q(getPageContext().getPageActivity());
        this.ffH.setAdapter((ListAdapter) this.ffI);
        this.ffH.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.ffO, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        i.baV().fgb = false;
        this.ffH.setMaxHeight(this.ffK);
        this.ffH.setTranscriptMode(0);
        this.ffH.setOnScrollListener(new g(this));
    }

    private void baT() {
        this.ffL = new TextView(getActivity());
        this.ffL.setGravity(17);
        this.ffL.setText(w.l.click_load_more);
        this.ffL.setHeight((int) getResources().getDimension(w.f.ds80));
        this.ffL.setBackgroundResource(w.g.screen_notify_item_background);
        this.ffL.setTextColor(getResources().getColorStateList(w.e.screen_notify_load_more_text_color));
        this.ffL.setTextSize(0, getResources().getDimension(w.f.fontsize32));
        this.ffL.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aZg())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ko() {
        s item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.ffM.bbe();
            if (this.ffI != null && this.ffI.getCount() > 0 && (item = this.ffI.getItem(0)) != null) {
                TiebaStatic.log(new as("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i.baV().ffY = 1;
        i.baV().ffW = 0;
        List<s> baX = i.baV().baX();
        s baY = i.baV().baY();
        i.baV().release();
        if ((baX == null || baX.isEmpty()) && baY == null && this.ffI.getCount() == 0 && this.ffH.getHeaderViewsCount() == 0) {
            i.baV().ffV.bba();
            finish();
            return;
        }
        cA(baX);
        if (baY != null) {
            a(baY);
        }
        if (this.ffN != null) {
            this.ffN.kD(this.ffI.getCount() == 0);
        }
    }

    private void cA(List<s> list) {
        if (list != null && list.size() > 0 && this.ffI != null) {
            this.ffI.cB(list);
            if (this.ffI.isHasMore() && this.ffL == null) {
                baT();
                this.ffH.addFooterView(this.ffL);
            }
        }
    }

    private void a(s sVar) {
        if (this.ffN == null) {
            this.ffN = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.ffN.b(this.ffP, this.ffQ);
            this.ffN.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.ffH.addHeaderView(this.ffN);
        }
        this.ffN.f(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.baV().ffY = 0;
        i.baV().ffW = 0;
        if (this.ffN != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.ffN.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ffO);
        i.baV().release();
        i.baV().ffY = 0;
        this.ffG = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(s sVar) {
        if (sVar != null) {
            TiebaStatic.log(new as("c11703").g(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId).aa("url", sVar.url).aa("app_version", TbConfig.getVersion()));
            if (!com.baidu.adp.lib.util.i.hj()) {
                showToast(getResources().getString(w.l.neterror));
            } else if (!TextUtils.isEmpty(sVar.url)) {
                bb.wn().c(getPageContext(), new String[]{String.valueOf(sVar.url) + "&is_from_push=true"});
                TiebaStatic.log(new as("c10316").aa("obj_type", sVar.stat).s("obj_locate", 2));
                i.baV().d(sVar);
                finish();
            } else if (sVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(sVar.groupId), sVar.groupName, 0L, "from_lock")));
                i.baV().d(sVar);
                i.baV().ffV.bba();
                if (!i.baV().ffV.bbc()) {
                    i.baV().ffV.bbb();
                }
                i.baV().ffW = 0;
                finish();
            } else if (sVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.ffJ.groupId, 0L), sVar.groupName, sVar.fgo, 0, sVar.eFL ? 1 : 0)));
                i.baV().d(sVar);
                i.baV().ffW = 0;
                i.baV().ffV.bba();
                if (!i.baV().ffV.bbc()) {
                    i.baV().ffV.bbb();
                }
                finish();
            } else if (sVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.ffJ.groupId, 0L), sVar.groupName, sVar.fgo, 0, 4)));
                i.baV().d(sVar);
                i.baV().ffW = 0;
                i.baV().ffV.bba();
                if (!i.baV().ffV.bbc()) {
                    i.baV().ffV.bbb();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                i.baV().d(sVar);
                i.baV().ffV.bba();
                if (!i.baV().ffV.bbc()) {
                    i.baV().ffV.bbb();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i.baV().ffV.bba();
            finish();
            return true;
        } else if (i == 82) {
            i.baV().ffV.bba();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable baU() {
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

    public String aZg() {
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
