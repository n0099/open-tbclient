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
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private int bYA;
    private int bYB;
    public m bYE;
    public r bYF;
    private Window bYr;
    private TextView bYs;
    private RelativeLayout bYt;
    private RelativeLayout bYu;
    private TextView bYv;
    private TextView bYw;
    private TextView bYx;
    private TextView bYy;
    private ImageView bYz;
    private EditText mEditText;
    private InputMethodManager mInputManager;
    private Drawable bYC = null;
    public DynamicHeightListView bYD = null;
    private BroadcastReceiver bYG = new a(this);
    private AdapterView.OnItemClickListener HF = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.bYr = getWindow();
        this.bYr.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.bYr.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(w.activity_screen_lock);
        if (com.baidu.adp.lib.util.n.ja()) {
            this.bYC = aga();
            if (this.bYC != null) {
                this.bYr.setBackgroundDrawable(this.bYC);
            }
        }
        initUI();
        this.bYA = com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), t.ds400);
        this.bYB = com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), t.ds484);
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
        this.bYt = (RelativeLayout) findViewById(v.screenlock_input_layout);
        this.bYs = (TextView) findViewById(v.screenlock_send_button);
        this.mEditText = (EditText) findViewById(v.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.bYu = (RelativeLayout) findViewById(v.one_chat_head_layout);
        this.bYv = (TextView) findViewById(v.friend_name_head);
        this.bYw = (TextView) findViewById(v.last_msg_time_head);
        this.bYy = (TextView) findViewById(v.unread_msg_count);
        this.bYx = (TextView) findViewById(v.look_more_textview);
        this.bYx.setOnClickListener(new c(this));
        this.bYs.setOnClickListener(new d(this));
        this.bYz = (ImageView) findViewById(v.head_close);
        this.bYz.setOnClickListener(new e(this));
        this.bYD = (DynamicHeightListView) findViewById(v.screenlock_chat_list_content);
        this.bYE = new m(getPageContext().getPageActivity());
        this.bYD.setAdapter((ListAdapter) this.bYE);
        this.bYD.setOnItemClickListener(this.HF);
        registerReceiver(this.bYG, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.agc().bYS = false;
    }

    public String afX() {
        if (this.mEditText != null) {
            return com.baidu.adp.lib.util.m.a(this.mEditText.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(agb())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<r> agd = f.agc().agd();
        if (agd == null || agd.isEmpty()) {
            afZ();
            finish();
            return;
        }
        if (f.agc().age().size() == 1) {
            this.bYt.setVisibility(0);
            r rVar = f.agc().age().get(0);
            this.bYu.setVisibility(0);
            this.bYy.setText(hR(rVar.bZf));
            this.bYy.setVisibility(0);
            this.bYv.setText(rVar.groupName);
            this.bYw.setText(am(rVar.Uy));
            this.bYx.setVisibility(8);
            this.bYE.em(false);
            this.bYD.setMaxHeight(this.bYA);
        } else {
            this.bYt.setVisibility(8);
            this.bYu.setVisibility(8);
            this.bYy.setVisibility(8);
            if (f.agc().age().size() <= 3) {
                this.bYx.setVisibility(8);
            } else {
                this.bYx.setVisibility(0);
            }
            this.bYE.em(true);
            this.bYD.setMaxHeight(this.bYB);
        }
        this.bYE.setData(agd);
        this.bYE.notifyDataSetChanged();
        f.agc().bYP = 1;
        f.agc().bYN = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.agc().bYP = 0;
        f.agc().bYN = 0;
        HidenSoftKeyPad(this.mInputManager, this.mEditText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.bYG);
        f.agc().bYP = 0;
        this.bYC = null;
    }

    public void a(r rVar) {
        if (rVar != null) {
            if (rVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(rVar.groupId), rVar.groupName, 0L, "from_lock")));
                f.agc().c(rVar);
                afZ();
                if (!f.agc().bYM.agi()) {
                    afY();
                }
                f.agc().bYN = 0;
                finish();
            } else if (rVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bYF.groupId, 0L), rVar.groupName, rVar.bZg, 0, rVar.bZi ? 1 : 0)));
                f.agc().c(rVar);
                f.agc().bYN = 0;
                afZ();
                if (!f.agc().bYM.agi()) {
                    afY();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                afZ();
                if (!f.agc().bYM.agi()) {
                    afY();
                }
                finish();
            }
        }
    }

    public void afY() {
        f.agc().bYM.afY();
    }

    public void afZ() {
        f.agc().bYM.afZ();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            afZ();
            finish();
            return true;
        } else if (i == 82) {
            afZ();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String am(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String hR(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aga() {
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

    public String agb() {
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
