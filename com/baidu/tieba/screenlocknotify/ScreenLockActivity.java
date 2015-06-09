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
import android.view.KeyEvent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private Window ccE;
    private TextView ccF;
    private RelativeLayout ccG;
    private RelativeLayout ccH;
    private TextView ccI;
    private TextView ccJ;
    private TextView ccK;
    private TextView ccL;
    private ImageView ccM;
    private int ccN;
    private int ccO;
    public m ccR;
    public r ccS;
    private EditText mEditText;
    private InputMethodManager mInputManager;
    private Drawable ccP = null;
    public DynamicHeightListView ccQ = null;
    private BroadcastReceiver ccT = new a(this);
    private AdapterView.OnItemClickListener Hv = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.ccE = getWindow();
        this.ccE.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.ccE.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(com.baidu.tieba.r.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (com.baidu.adp.lib.util.n.jp()) {
            this.ccP = ahO();
            if (this.ccP != null) {
                this.ccE.setBackgroundDrawable(this.ccP);
            }
        }
        initUI();
        this.ccN = com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), com.baidu.tieba.o.ds360);
        this.ccO = com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), com.baidu.tieba.o.ds484);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    public void initUI() {
        this.ccG = (RelativeLayout) findViewById(com.baidu.tieba.q.screenlock_input_layout);
        this.ccF = (TextView) findViewById(com.baidu.tieba.q.screenlock_send_button);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.q.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.ccH = (RelativeLayout) findViewById(com.baidu.tieba.q.one_chat_head_layout);
        this.ccI = (TextView) findViewById(com.baidu.tieba.q.friend_name_head);
        this.ccJ = (TextView) findViewById(com.baidu.tieba.q.last_msg_time_head);
        this.ccL = (TextView) findViewById(com.baidu.tieba.q.unread_msg_count);
        this.ccK = (TextView) findViewById(com.baidu.tieba.q.look_more_textview);
        this.ccK.setOnClickListener(new c(this));
        this.ccF.setOnClickListener(new d(this));
        this.ccM = (ImageView) findViewById(com.baidu.tieba.q.head_close);
        this.ccM.setOnClickListener(new e(this));
        this.ccQ = (DynamicHeightListView) findViewById(com.baidu.tieba.q.screenlock_chat_list_content);
        this.ccR = new m(getPageContext().getPageActivity());
        this.ccQ.setAdapter((ListAdapter) this.ccR);
        this.ccQ.setOnItemClickListener(this.Hv);
        registerReceiver(this.ccT, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.ahQ().cde = false;
    }

    public String ahN() {
        if (this.mEditText != null) {
            return com.baidu.adp.lib.util.m.a(this.mEditText.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(ahP())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<r> ahR = f.ahQ().ahR();
        if (ahR == null || ahR.isEmpty()) {
            f.ahQ().ccY.ahW();
            finish();
            return;
        }
        if (f.ahQ().ahS().size() == 1) {
            this.ccG.setVisibility(0);
            r rVar = f.ahQ().ahS().get(0);
            this.ccH.setVisibility(0);
            this.ccL.setText(ip(rVar.cdr));
            this.ccL.setVisibility(0);
            this.ccI.setText(rVar.groupName);
            this.ccJ.setText(an(rVar.cdt));
            this.ccK.setVisibility(8);
            this.ccR.eC(false);
            this.ccQ.setMaxHeight(this.ccN);
        } else {
            this.ccG.setVisibility(8);
            this.ccH.setVisibility(8);
            this.ccL.setVisibility(8);
            if (f.ahQ().ahS().size() <= 3) {
                this.ccK.setVisibility(8);
            } else {
                this.ccK.setVisibility(0);
            }
            this.ccR.eC(true);
            this.ccQ.setMaxHeight(this.ccO);
        }
        this.ccR.setData(ahR);
        this.ccR.notifyDataSetChanged();
        f.ahQ().cdb = 1;
        f.ahQ().ccZ = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.ahQ().cdb = 0;
        f.ahQ().ccZ = 0;
        HidenSoftKeyPad(this.mInputManager, this.mEditText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ccT);
        f.ahQ().cdb = 0;
        this.ccP = null;
    }

    public void a(r rVar) {
        if (rVar != null) {
            if (rVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(rVar.groupId), rVar.groupName, 0L, "from_lock")));
                f.ahQ().c(rVar);
                f.ahQ().ccY.ahW();
                if (!f.ahQ().ccY.ahY()) {
                    f.ahQ().ccY.ahX();
                }
                f.ahQ().ccZ = 0;
                finish();
            } else if (rVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(this.ccS.groupId, 0L), rVar.groupName, rVar.cds, 0, rVar.cdv ? 1 : 0)));
                f.ahQ().c(rVar);
                f.ahQ().ccZ = 0;
                f.ahQ().ccY.ahW();
                if (!f.ahQ().ccY.ahY()) {
                    f.ahQ().ccY.ahX();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.ahQ().ccY.ahW();
                if (!f.ahQ().ccY.ahY()) {
                    f.ahQ().ccY.ahX();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.ahQ().ccY.ahW();
            finish();
            return true;
        } else if (i == 82) {
            f.ahQ().ccY.ahW();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String an(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String ip(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable ahO() {
        Bitmap bitmap;
        Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
        if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            int min = Math.min(com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity()), bitmap.getWidth());
            int min2 = Math.min(com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity()), bitmap.getHeight());
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
    }

    public String ahP() {
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
