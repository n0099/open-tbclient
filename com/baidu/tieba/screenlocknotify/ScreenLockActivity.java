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
    private ImageView bjd;
    private Window fdT;
    public q fdW;
    public s fdX;
    private ScreenLockLoadMoreModel fea;
    private com.baidu.tieba.screenlocknotify.a.a feb;
    private Drawable fdU = null;
    public DynamicHeightListView fdV = null;
    private int fdY = 0;
    private TextView fdZ = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver fec = new a(this);
    View.OnClickListener fed = new b(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new c(this);
    private View.OnClickListener fee = new d(this);
    private com.baidu.adp.framework.listener.a fef = new e(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.fdT = getWindow();
        this.fdT.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.fdT.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(w.j.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(w.e.transparent, true);
        if (com.baidu.adp.lib.util.k.hE()) {
            this.fdU = aZu();
            if (this.fdU != null) {
                this.fdT.setBackgroundDrawable(this.fdU);
            }
        }
        this.fdY = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds935) - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds80);
        this.fea = new ScreenLockLoadMoreModel(this);
        registerListener(this.fef);
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
        this.bjd = (ImageView) findViewById(w.h.head_close);
        this.bjd.setOnClickListener(new f(this));
        this.fdV = (DynamicHeightListView) findViewById(w.h.screenlock_chat_list_content);
        this.fdW = new q(getPageContext().getPageActivity());
        this.fdV.setAdapter((ListAdapter) this.fdW);
        this.fdV.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.fec, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        i.aZv().feo = false;
        this.fdV.setMaxHeight(this.fdY);
        this.fdV.setTranscriptMode(0);
        this.fdV.setOnScrollListener(new g(this));
    }

    private void aZt() {
        this.fdZ = new TextView(getActivity());
        this.fdZ.setGravity(17);
        this.fdZ.setText(w.l.click_load_more);
        this.fdZ.setHeight((int) getResources().getDimension(w.f.ds80));
        this.fdZ.setBackgroundResource(w.g.screen_notify_item_background);
        this.fdZ.setTextColor(getResources().getColorStateList(w.e.screen_notify_load_more_text_color));
        this.fdZ.setTextSize(0, getResources().getDimension(w.f.fontsize32));
        this.fdZ.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aXG())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JC() {
        s item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.fea.aZE();
            if (this.fdW != null && this.fdW.getCount() > 0 && (item = this.fdW.getItem(0)) != null) {
                TiebaStatic.log(new as("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i.aZv().fel = 1;
        i.aZv().fej = 0;
        List<s> aZx = i.aZv().aZx();
        s aZy = i.aZv().aZy();
        i.aZv().release();
        if ((aZx == null || aZx.isEmpty()) && aZy == null && this.fdW.getCount() == 0 && this.fdV.getHeaderViewsCount() == 0) {
            i.aZv().fei.aZA();
            finish();
            return;
        }
        cr(aZx);
        if (aZy != null) {
            a(aZy);
        }
        if (this.feb != null) {
            this.feb.kt(this.fdW.getCount() == 0);
        }
    }

    private void cr(List<s> list) {
        if (list != null && list.size() > 0 && this.fdW != null) {
            this.fdW.cs(list);
            if (this.fdW.isHasMore() && this.fdZ == null) {
                aZt();
                this.fdV.addFooterView(this.fdZ);
            }
        }
    }

    private void a(s sVar) {
        if (this.feb == null) {
            this.feb = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.feb.b(this.fed, this.fee);
            this.feb.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fdV.addHeaderView(this.feb);
        }
        this.feb.f(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.aZv().fel = 0;
        i.aZv().fej = 0;
        if (this.feb != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.feb.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.fec);
        i.aZv().release();
        i.aZv().fel = 0;
        this.fdU = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(s sVar) {
        if (sVar != null) {
            TiebaStatic.log(new as("c11703").g(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId).aa("url", sVar.url).aa("app_version", TbConfig.getVersion()));
            if (!com.baidu.adp.lib.util.i.hk()) {
                showToast(getResources().getString(w.l.neterror));
            } else if (!TextUtils.isEmpty(sVar.url)) {
                bb.vB().c(getPageContext(), new String[]{String.valueOf(sVar.url) + "&is_from_push=true"});
                TiebaStatic.log(new as("c10316").aa("obj_type", sVar.stat).s("obj_locate", 2));
                i.aZv().d(sVar);
                finish();
            } else if (sVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(sVar.groupId), sVar.groupName, 0L, "from_lock")));
                i.aZv().d(sVar);
                i.aZv().fei.aZA();
                if (!i.aZv().fei.aZC()) {
                    i.aZv().fei.aZB();
                }
                i.aZv().fej = 0;
                finish();
            } else if (sVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fdX.groupId, 0L), sVar.groupName, sVar.feC, 0, sVar.eDv ? 1 : 0)));
                i.aZv().d(sVar);
                i.aZv().fej = 0;
                i.aZv().fei.aZA();
                if (!i.aZv().fei.aZC()) {
                    i.aZv().fei.aZB();
                }
                finish();
            } else if (sVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.fdX.groupId, 0L), sVar.groupName, sVar.feC, 0, 4)));
                i.aZv().d(sVar);
                i.aZv().fej = 0;
                i.aZv().fei.aZA();
                if (!i.aZv().fei.aZC()) {
                    i.aZv().fei.aZB();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                i.aZv().d(sVar);
                i.aZv().fei.aZA();
                if (!i.aZv().fei.aZC()) {
                    i.aZv().fei.aZB();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i.aZv().fei.aZA();
            finish();
            return true;
        } else if (i == 82) {
            i.aZv().fei.aZA();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable aZu() {
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

    public String aXG() {
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
