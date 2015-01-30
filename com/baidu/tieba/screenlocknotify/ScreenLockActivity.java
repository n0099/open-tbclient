package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.KeyEvent;
import android.view.Window;
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
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private Window bNH;
    private TextView bNI;
    private RelativeLayout bNJ;
    private RelativeLayout bNK;
    private TextView bNL;
    private TextView bNM;
    private TextView bNN;
    private TextView bNO;
    private ImageView bNP;
    private int bNQ;
    private int bNR;
    public o bNU;
    public t bNV;
    private EditText mEditText;
    private Drawable bNS = null;
    public DynamicHeightListView bNT = null;
    private BroadcastReceiver bNW = new a(this);
    private AdapterView.OnItemClickListener wO = new b(this);

    static {
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            TbadkApplication.getInst().getApp().getClassLoader().loadClass(ScreenLockNotifyService.class.getName());
            f.acG();
            TbadkApplication.getInst().getApp().startService(new Intent(TbadkApplication.getInst().getApp(), ScreenLockNotifyService.class));
            BdLog.i("-------------------启动ScreenlockManager,service!");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.hU().d("plugin_load", "screenlock_failed", null, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bNH = getWindow();
        this.bNH.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.bNH.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(x.activity_screen_lock);
        if (com.baidu.adp.lib.util.l.fx()) {
            this.bNS = acE();
            if (this.bNS != null) {
                this.bNH.setBackgroundDrawable(this.bNS);
            }
        }
        initUI();
        this.bNQ = com.baidu.adp.lib.util.l.d(getPageContext().getPageActivity(), u.ds400);
        this.bNR = com.baidu.adp.lib.util.l.d(getPageContext().getPageActivity(), u.ds484);
    }

    public void initUI() {
        this.bNJ = (RelativeLayout) findViewById(w.screenlock_input_layout);
        this.bNI = (TextView) findViewById(w.screenlock_send_button);
        this.mEditText = (EditText) findViewById(w.screenlock_edit_view);
        this.bNK = (RelativeLayout) findViewById(w.one_chat_head_layout);
        this.bNL = (TextView) findViewById(w.friend_name_head);
        this.bNM = (TextView) findViewById(w.last_msg_time_head);
        this.bNO = (TextView) findViewById(w.unread_msg_count);
        this.bNN = (TextView) findViewById(w.look_more_textview);
        this.bNN.setOnClickListener(new c(this));
        this.bNI.setOnClickListener(new d(this));
        this.bNP = (ImageView) findViewById(w.head_close);
        this.bNP.setOnClickListener(new e(this));
        this.bNT = (DynamicHeightListView) findViewById(w.screenlock_chat_list_content);
        this.bNU = new o(getPageContext().getPageActivity());
        this.bNT.setAdapter((ListAdapter) this.bNU);
        this.bNT.setOnItemClickListener(this.wO);
        registerReceiver(this.bNW, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.acG().bOi = false;
    }

    public String acD() {
        if (this.mEditText != null) {
            return com.baidu.adp.lib.util.k.a(this.mEditText.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(acF())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<t> acH = f.acG().acH();
        if (acH == null || acH.isEmpty()) {
            f.acG().bOc.acM();
            finish();
            return;
        }
        if (f.acG().acI().size() == 1) {
            this.bNJ.setVisibility(0);
            t tVar = f.acG().acI().get(0);
            this.bNK.setVisibility(0);
            this.bNO.setText(hz(tVar.bOu));
            this.bNO.setVisibility(0);
            this.bNL.setText(tVar.groupName);
            this.bNM.setText(aj(tVar.IU));
            this.bNN.setVisibility(8);
            this.bNU.ep(false);
            this.bNT.setMaxHeight(this.bNQ);
        } else {
            this.bNJ.setVisibility(8);
            this.bNK.setVisibility(8);
            this.bNO.setVisibility(8);
            if (f.acG().acI().size() <= 3) {
                this.bNN.setVisibility(8);
            } else {
                this.bNN.setVisibility(0);
            }
            this.bNU.ep(true);
            this.bNT.setMaxHeight(this.bNR);
        }
        this.bNU.setData(acH);
        this.bNU.notifyDataSetChanged();
        f.acG().bOf = 1;
        f.acG().bOd = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.acG().bOf = 0;
        f.acG().bOd = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.bNW);
        f.acG().bOf = 0;
        this.bNS = null;
    }

    public void a(t tVar) {
        if (tVar != null) {
            if (tVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(tVar.groupId), tVar.groupName, 0L, "from_lock")));
                f.acG().c(tVar);
                f.acG().bOd = 0;
                finish();
            } else if (tVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bNV.groupId, 0L), tVar.groupName, tVar.bOv, 0, tVar.bOx ? 1 : 0)));
                f.acG().c(tVar);
                f.acG().bOd = 0;
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.acG().bOc.acM();
            finish();
            return true;
        } else if (i == 82) {
            f.acG().bOc.acM();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String aj(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String hz(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable acE() {
        Bitmap bitmap;
        Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
        if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            int min = Math.min(com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity()), bitmap.getWidth());
            int min2 = Math.min(com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String acF() {
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
