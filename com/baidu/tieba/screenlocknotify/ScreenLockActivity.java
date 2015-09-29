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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText bHL;
    private RelativeLayout cJA;
    private RelativeLayout cJB;
    private TextView cJC;
    private TextView cJD;
    private TextView cJE;
    private TextView cJF;
    private ImageView cJG;
    private int cJH;
    private int cJI;
    public n cJL;
    public p cJM;
    private Window cJy;
    private TextView cJz;
    private InputMethodManager mInputManager;
    private Drawable cJJ = null;
    public DynamicHeightListView cJK = null;
    private BroadcastReceiver cJN = new a(this);
    private AdapterView.OnItemClickListener Hw = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.cJy = getWindow();
        this.cJy.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.cJy.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(i.g.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (com.baidu.adp.lib.util.k.jh()) {
            this.cJJ = aqz();
            if (this.cJJ != null) {
                this.cJy.setBackgroundDrawable(this.cJJ);
            }
        }
        initUI();
        this.cJH = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds360);
        this.cJI = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds484);
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
        this.cJA = (RelativeLayout) findViewById(i.f.screenlock_input_layout);
        this.cJz = (TextView) findViewById(i.f.screenlock_send_button);
        this.bHL = (EditText) findViewById(i.f.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cJB = (RelativeLayout) findViewById(i.f.one_chat_head_layout);
        this.cJC = (TextView) findViewById(i.f.friend_name_head);
        this.cJD = (TextView) findViewById(i.f.last_msg_time_head);
        this.cJF = (TextView) findViewById(i.f.unread_msg_count);
        this.cJE = (TextView) findViewById(i.f.look_more_textview);
        this.cJE.setOnClickListener(new c(this));
        this.cJz.setOnClickListener(new d(this));
        this.cJG = (ImageView) findViewById(i.f.head_close);
        this.cJG.setOnClickListener(new e(this));
        this.cJK = (DynamicHeightListView) findViewById(i.f.screenlock_chat_list_content);
        this.cJL = new n(getPageContext().getPageActivity());
        this.cJK.setAdapter((ListAdapter) this.cJL);
        this.cJK.setOnItemClickListener(this.Hw);
        registerReceiver(this.cJN, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.aqB().cJY = false;
    }

    public String aqy() {
        if (this.bHL != null) {
            return com.baidu.adp.lib.util.j.a(this.bHL.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aqA())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> aqD = f.aqB().aqD();
        if (aqD == null || aqD.isEmpty()) {
            f.aqB().cJS.aqJ();
            finish();
            return;
        }
        if (f.aqB().aqE().size() == 1) {
            p pVar = f.aqB().aqE().get(0);
            if (f.aqB().aqI()) {
                this.cJA.setVisibility(8);
                this.cJF.setVisibility(8);
                this.cJB.setVisibility(8);
                this.cJK.setMaxHeight(0);
            } else {
                this.cJA.setVisibility(0);
                this.cJF.setText(kr(pVar.cKr));
                this.cJF.setVisibility(0);
                this.cJB.setVisibility(0);
                this.cJC.setText(pVar.groupName);
                this.cJD.setText(aX(pVar.cIs));
                this.cJK.setMaxHeight(this.cJH);
            }
            this.cJE.setVisibility(8);
            this.cJL.fP(false);
        } else {
            this.cJA.setVisibility(8);
            this.cJB.setVisibility(8);
            this.cJF.setVisibility(8);
            if (f.aqB().aqI()) {
                if (f.aqB().aqE().size() < 3) {
                    this.cJE.setVisibility(8);
                    linkedList = aqD;
                } else {
                    List<p> aqD2 = f.aqB().aqD();
                    LinkedList linkedList2 = new LinkedList(aqD2.subList(0, 2));
                    linkedList2.add(aqD2.get(aqD2.size() - 1));
                    this.cJE.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.aqB().aqE().size() <= 3) {
                this.cJE.setVisibility(8);
                linkedList = aqD;
            } else {
                this.cJE.setVisibility(0);
                linkedList = aqD;
            }
            this.cJL.fP(true);
            this.cJK.setMaxHeight(this.cJI);
            aqD = linkedList;
        }
        this.cJL.fQ(f.aqB().aqI());
        this.cJL.setData(aqD);
        this.cJL.notifyDataSetChanged();
        f.aqB().cJV = 1;
        f.aqB().cJT = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.aqB().cJV = 0;
        f.aqB().cJT = 0;
        HidenSoftKeyPad(this.mInputManager, this.bHL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.cJN);
        f.aqB().cJV = 0;
        this.cJJ = null;
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                ay.uV().b(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new ap("c10316").ae("obj_type", pVar.stat).r("obj_locate", 2));
                f.aqB().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.aqB().c(pVar);
                f.aqB().cJS.aqJ();
                if (!f.aqB().cJS.aqL()) {
                    f.aqB().cJS.aqK();
                }
                f.aqB().cJT = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cJM.groupId, 0L), pVar.groupName, pVar.cKs, 0, pVar.cKu ? 1 : 0)));
                f.aqB().c(pVar);
                f.aqB().cJT = 0;
                f.aqB().cJS.aqJ();
                if (!f.aqB().cJS.aqL()) {
                    f.aqB().cJS.aqK();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cJM.groupId, 0L), pVar.groupName, pVar.cKs, 0, 4)));
                f.aqB().c(pVar);
                f.aqB().cJT = 0;
                f.aqB().cJS.aqJ();
                if (!f.aqB().cJS.aqL()) {
                    f.aqB().cJS.aqK();
                }
                TiebaStatic.log(new ap("c10321").r("obj_type", 1).ae("obj_name", "click"));
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.aqB().c(pVar);
                f.aqB().cJS.aqJ();
                if (!f.aqB().cJS.aqL()) {
                    f.aqB().cJS.aqK();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.aqB().cJS.aqJ();
            finish();
            return true;
        } else if (i == 82) {
            f.aqB().cJS.aqJ();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String aX(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String kr(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aqz() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String aqA() {
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
