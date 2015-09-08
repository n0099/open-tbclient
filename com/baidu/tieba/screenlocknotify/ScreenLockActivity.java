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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText bEI;
    private RelativeLayout cCA;
    private TextView cCB;
    private TextView cCC;
    private TextView cCD;
    private TextView cCE;
    private ImageView cCF;
    private int cCG;
    private int cCH;
    public n cCK;
    public p cCL;
    private Window cCx;
    private TextView cCy;
    private RelativeLayout cCz;
    private InputMethodManager mInputManager;
    private Drawable cCI = null;
    public DynamicHeightListView cCJ = null;
    private BroadcastReceiver cCM = new a(this);
    private AdapterView.OnItemClickListener Hw = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.cCx = getWindow();
        this.cCx.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.cCx.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(i.g.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (com.baidu.adp.lib.util.k.jg()) {
            this.cCI = aoh();
            if (this.cCI != null) {
                this.cCx.setBackgroundDrawable(this.cCI);
            }
        }
        initUI();
        this.cCG = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds360);
        this.cCH = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds484);
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
        this.cCz = (RelativeLayout) findViewById(i.f.screenlock_input_layout);
        this.cCy = (TextView) findViewById(i.f.screenlock_send_button);
        this.bEI = (EditText) findViewById(i.f.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cCA = (RelativeLayout) findViewById(i.f.one_chat_head_layout);
        this.cCB = (TextView) findViewById(i.f.friend_name_head);
        this.cCC = (TextView) findViewById(i.f.last_msg_time_head);
        this.cCE = (TextView) findViewById(i.f.unread_msg_count);
        this.cCD = (TextView) findViewById(i.f.look_more_textview);
        this.cCD.setOnClickListener(new c(this));
        this.cCy.setOnClickListener(new d(this));
        this.cCF = (ImageView) findViewById(i.f.head_close);
        this.cCF.setOnClickListener(new e(this));
        this.cCJ = (DynamicHeightListView) findViewById(i.f.screenlock_chat_list_content);
        this.cCK = new n(getPageContext().getPageActivity());
        this.cCJ.setAdapter((ListAdapter) this.cCK);
        this.cCJ.setOnItemClickListener(this.Hw);
        registerReceiver(this.cCM, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.aoj().cCX = false;
    }

    public String aog() {
        if (this.bEI != null) {
            return com.baidu.adp.lib.util.j.a(this.bEI.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aoi())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> aol = f.aoj().aol();
        if (aol == null || aol.isEmpty()) {
            f.aoj().cCR.aor();
            finish();
            return;
        }
        if (f.aoj().aom().size() == 1) {
            p pVar = f.aoj().aom().get(0);
            if (f.aoj().aoq()) {
                this.cCz.setVisibility(8);
                this.cCE.setVisibility(8);
                this.cCA.setVisibility(8);
                this.cCJ.setMaxHeight(0);
            } else {
                this.cCz.setVisibility(0);
                this.cCE.setText(jS(pVar.cDq));
                this.cCE.setVisibility(0);
                this.cCA.setVisibility(0);
                this.cCB.setText(pVar.groupName);
                this.cCC.setText(aA(pVar.cBq));
                this.cCJ.setMaxHeight(this.cCG);
            }
            this.cCD.setVisibility(8);
            this.cCK.fE(false);
        } else {
            this.cCz.setVisibility(8);
            this.cCA.setVisibility(8);
            this.cCE.setVisibility(8);
            if (f.aoj().aoq()) {
                if (f.aoj().aom().size() < 3) {
                    this.cCD.setVisibility(8);
                    linkedList = aol;
                } else {
                    List<p> aol2 = f.aoj().aol();
                    LinkedList linkedList2 = new LinkedList(aol2.subList(0, 2));
                    linkedList2.add(aol2.get(aol2.size() - 1));
                    this.cCD.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.aoj().aom().size() <= 3) {
                this.cCD.setVisibility(8);
                linkedList = aol;
            } else {
                this.cCD.setVisibility(0);
                linkedList = aol;
            }
            this.cCK.fE(true);
            this.cCJ.setMaxHeight(this.cCH);
            aol = linkedList;
        }
        this.cCK.fF(f.aoj().aoq());
        this.cCK.setData(aol);
        this.cCK.notifyDataSetChanged();
        f.aoj().cCU = 1;
        f.aoj().cCS = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.aoj().cCU = 0;
        f.aoj().cCS = 0;
        HidenSoftKeyPad(this.mInputManager, this.bEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.cCM);
        f.aoj().cCU = 0;
        this.cCI = null;
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                ax.uX().b(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new ao("c10316").af("obj_type", pVar.stat).r("obj_locate", 2));
                f.aoj().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.aoj().c(pVar);
                f.aoj().cCR.aor();
                if (!f.aoj().cCR.aot()) {
                    f.aoj().cCR.aos();
                }
                f.aoj().cCS = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cCL.groupId, 0L), pVar.groupName, pVar.cDr, 0, pVar.cDt ? 1 : 0)));
                f.aoj().c(pVar);
                f.aoj().cCS = 0;
                f.aoj().cCR.aor();
                if (!f.aoj().cCR.aot()) {
                    f.aoj().cCR.aos();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cCL.groupId, 0L), pVar.groupName, pVar.cDr, 0, 4)));
                f.aoj().c(pVar);
                f.aoj().cCS = 0;
                f.aoj().cCR.aor();
                if (!f.aoj().cCR.aot()) {
                    f.aoj().cCR.aos();
                }
                TiebaStatic.log(new ao("c10321").r("obj_type", 1).af("obj_name", "click"));
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.aoj().c(pVar);
                f.aoj().cCR.aor();
                if (!f.aoj().cCR.aot()) {
                    f.aoj().cCR.aos();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.aoj().cCR.aor();
            finish();
            return true;
        } else if (i == 82) {
            f.aoj().cCR.aor();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String aA(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String jS(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aoh() {
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

    public String aoi() {
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
