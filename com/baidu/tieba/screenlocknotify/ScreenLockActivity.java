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
    private Window ccD;
    private TextView ccE;
    private RelativeLayout ccF;
    private RelativeLayout ccG;
    private TextView ccH;
    private TextView ccI;
    private TextView ccJ;
    private TextView ccK;
    private ImageView ccL;
    private int ccM;
    private int ccN;
    public m ccQ;
    public r ccR;
    private EditText mEditText;
    private InputMethodManager mInputManager;
    private Drawable ccO = null;
    public DynamicHeightListView ccP = null;
    private BroadcastReceiver ccS = new a(this);
    private AdapterView.OnItemClickListener Hv = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.ccD = getWindow();
        this.ccD.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.ccD.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(com.baidu.tieba.r.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (com.baidu.adp.lib.util.n.jp()) {
            this.ccO = ahN();
            if (this.ccO != null) {
                this.ccD.setBackgroundDrawable(this.ccO);
            }
        }
        initUI();
        this.ccM = com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), com.baidu.tieba.o.ds360);
        this.ccN = com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), com.baidu.tieba.o.ds484);
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
        this.ccF = (RelativeLayout) findViewById(com.baidu.tieba.q.screenlock_input_layout);
        this.ccE = (TextView) findViewById(com.baidu.tieba.q.screenlock_send_button);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.q.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.ccG = (RelativeLayout) findViewById(com.baidu.tieba.q.one_chat_head_layout);
        this.ccH = (TextView) findViewById(com.baidu.tieba.q.friend_name_head);
        this.ccI = (TextView) findViewById(com.baidu.tieba.q.last_msg_time_head);
        this.ccK = (TextView) findViewById(com.baidu.tieba.q.unread_msg_count);
        this.ccJ = (TextView) findViewById(com.baidu.tieba.q.look_more_textview);
        this.ccJ.setOnClickListener(new c(this));
        this.ccE.setOnClickListener(new d(this));
        this.ccL = (ImageView) findViewById(com.baidu.tieba.q.head_close);
        this.ccL.setOnClickListener(new e(this));
        this.ccP = (DynamicHeightListView) findViewById(com.baidu.tieba.q.screenlock_chat_list_content);
        this.ccQ = new m(getPageContext().getPageActivity());
        this.ccP.setAdapter((ListAdapter) this.ccQ);
        this.ccP.setOnItemClickListener(this.Hv);
        registerReceiver(this.ccS, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.ahP().cdd = false;
    }

    public String ahM() {
        if (this.mEditText != null) {
            return com.baidu.adp.lib.util.m.a(this.mEditText.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(ahO())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<r> ahQ = f.ahP().ahQ();
        if (ahQ == null || ahQ.isEmpty()) {
            f.ahP().ccX.ahV();
            finish();
            return;
        }
        if (f.ahP().ahR().size() == 1) {
            this.ccF.setVisibility(0);
            r rVar = f.ahP().ahR().get(0);
            this.ccG.setVisibility(0);
            this.ccK.setText(ip(rVar.cdq));
            this.ccK.setVisibility(0);
            this.ccH.setText(rVar.groupName);
            this.ccI.setText(an(rVar.cds));
            this.ccJ.setVisibility(8);
            this.ccQ.eC(false);
            this.ccP.setMaxHeight(this.ccM);
        } else {
            this.ccF.setVisibility(8);
            this.ccG.setVisibility(8);
            this.ccK.setVisibility(8);
            if (f.ahP().ahR().size() <= 3) {
                this.ccJ.setVisibility(8);
            } else {
                this.ccJ.setVisibility(0);
            }
            this.ccQ.eC(true);
            this.ccP.setMaxHeight(this.ccN);
        }
        this.ccQ.setData(ahQ);
        this.ccQ.notifyDataSetChanged();
        f.ahP().cda = 1;
        f.ahP().ccY = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.ahP().cda = 0;
        f.ahP().ccY = 0;
        HidenSoftKeyPad(this.mInputManager, this.mEditText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ccS);
        f.ahP().cda = 0;
        this.ccO = null;
    }

    public void a(r rVar) {
        if (rVar != null) {
            if (rVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(rVar.groupId), rVar.groupName, 0L, "from_lock")));
                f.ahP().c(rVar);
                f.ahP().ccX.ahV();
                if (!f.ahP().ccX.ahX()) {
                    f.ahP().ccX.ahW();
                }
                f.ahP().ccY = 0;
                finish();
            } else if (rVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(this.ccR.groupId, 0L), rVar.groupName, rVar.cdr, 0, rVar.cdu ? 1 : 0)));
                f.ahP().c(rVar);
                f.ahP().ccY = 0;
                f.ahP().ccX.ahV();
                if (!f.ahP().ccX.ahX()) {
                    f.ahP().ccX.ahW();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.ahP().ccX.ahV();
                if (!f.ahP().ccX.ahX()) {
                    f.ahP().ccX.ahW();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.ahP().ccX.ahV();
            finish();
            return true;
        } else if (i == 82) {
            f.ahP().ccX.ahV();
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

    public Drawable ahN() {
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

    public String ahO() {
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
