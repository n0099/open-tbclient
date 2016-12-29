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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private Window eQm;
    private ImageView eQn;
    public q eQq;
    public s eQr;
    private com.baidu.tieba.screenlocknotify.loadmore.b eQu;
    private com.baidu.tieba.screenlocknotify.a.a eQv;
    private Drawable eQo = null;
    public DynamicHeightListView eQp = null;
    private int eQs = 0;
    private TextView eQt = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver eQw = new a(this);
    View.OnClickListener eQx = new b(this);
    private AdapterView.OnItemClickListener BH = new c(this);
    private View.OnClickListener eQy = new d(this);
    private com.baidu.adp.framework.listener.a eQz = new e(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.eQm = getWindow();
        this.eQm.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.eQm.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(r.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(r.d.transparent, true);
        if (com.baidu.adp.lib.util.k.gG()) {
            this.eQo = aYL();
            if (this.eQo != null) {
                this.eQm.setBackgroundDrawable(this.eQo);
            }
        }
        this.eQs = com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds935) - com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds80);
        this.eQu = new com.baidu.tieba.screenlocknotify.loadmore.b(this);
        registerListener(this.eQz);
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
        this.eQn = (ImageView) findViewById(r.g.head_close);
        this.eQn.setOnClickListener(new f(this));
        this.eQp = (DynamicHeightListView) findViewById(r.g.screenlock_chat_list_content);
        this.eQq = new q(getPageContext().getPageActivity());
        this.eQp.setAdapter((ListAdapter) this.eQq);
        this.eQp.setOnItemClickListener(this.BH);
        registerReceiver(this.eQw, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        i.aYM().eQJ = false;
        this.eQp.setMaxHeight(this.eQs);
        this.eQp.setTranscriptMode(0);
        this.eQp.setOnScrollListener(new g(this));
    }

    private void aYK() {
        this.eQt = new TextView(getActivity());
        this.eQt.setGravity(17);
        this.eQt.setText(r.j.screen_notify_load_more);
        this.eQt.setHeight((int) getResources().getDimension(r.e.ds80));
        this.eQt.setBackgroundResource(r.f.screen_notify_item_background);
        this.eQt.setTextColor(getResources().getColorStateList(r.d.screen_notify_load_more_text_color));
        this.eQt.setTextSize(0, getResources().getDimension(r.e.fontsize32));
        this.eQt.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aXE())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IV() {
        s item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.eQu.aYV();
            if (this.eQq != null && this.eQq.getCount() > 0 && (item = this.eQq.getItem(0)) != null) {
                TiebaStatic.log(new at("c11738").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i.aYM().eQG = 1;
        i.aYM().eQE = 0;
        List<s> aYO = i.aYM().aYO();
        s aYP = i.aYM().aYP();
        i.aYM().release();
        if ((aYO == null || aYO.isEmpty()) && aYP == null && this.eQq.getCount() == 0 && this.eQp.getHeaderViewsCount() == 0) {
            i.aYM().eQD.aYR();
            finish();
            return;
        }
        cP(aYO);
        if (aYP != null) {
            a(aYP);
        }
        if (this.eQv != null) {
            this.eQv.kr(this.eQq.getCount() == 0);
        }
    }

    private void cP(List<s> list) {
        if (list != null && list.size() > 0 && this.eQq != null) {
            this.eQq.cQ(list);
            if (this.eQq.isHasMore() && this.eQt == null) {
                aYK();
                this.eQp.addFooterView(this.eQt);
            }
        }
    }

    private void a(s sVar) {
        if (this.eQv == null) {
            this.eQv = new com.baidu.tieba.screenlocknotify.a.a(getActivity());
            this.eQv.b(this.eQx, this.eQy);
            this.eQv.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eQp.addHeaderView(this.eQv);
        }
        this.eQv.f(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i.aYM().eQG = 0;
        i.aYM().eQE = 0;
        if (this.eQv != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.eQv.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.eQw);
        i.aYM().release();
        i.aYM().eQG = 0;
        this.eQo = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void b(s sVar) {
        if (sVar != null) {
            TiebaStatic.log(new at("c11703").g(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId));
            if (!com.baidu.adp.lib.util.i.gm()) {
                showToast(getResources().getString(r.j.neterror));
            } else if (!TextUtils.isEmpty(sVar.url)) {
                bc.vz().c(getPageContext(), new String[]{sVar.url});
                TiebaStatic.log(new at("c10316").ab("obj_type", sVar.stat).s("obj_locate", 2));
                i.aYM().d(sVar);
                finish();
            } else if (sVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(sVar.groupId), sVar.groupName, 0L, "from_lock")));
                i.aYM().d(sVar);
                i.aYM().eQD.aYR();
                if (!i.aYM().eQD.aYT()) {
                    i.aYM().eQD.aYS();
                }
                i.aYM().eQE = 0;
                finish();
            } else if (sVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.eQr.groupId, 0L), sVar.groupName, sVar.eQW, 0, sVar.euu ? 1 : 0)));
                i.aYM().d(sVar);
                i.aYM().eQE = 0;
                i.aYM().eQD.aYR();
                if (!i.aYM().eQD.aYT()) {
                    i.aYM().eQD.aYS();
                }
                finish();
            } else if (sVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.eQr.groupId, 0L), sVar.groupName, sVar.eQW, 0, 4)));
                i.aYM().d(sVar);
                i.aYM().eQE = 0;
                i.aYM().eQD.aYR();
                if (!i.aYM().eQD.aYT()) {
                    i.aYM().eQD.aYS();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                i.aYM().d(sVar);
                i.aYM().eQD.aYR();
                if (!i.aYM().eQD.aYT()) {
                    i.aYM().eQD.aYS();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i.aYM().eQD.aYR();
            finish();
            return true;
        } else if (i == 82) {
            i.aYM().eQD.aYR();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public Drawable aYL() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.I(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.J(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String aXE() {
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
