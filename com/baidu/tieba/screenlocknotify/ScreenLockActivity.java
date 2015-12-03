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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText bXx;
    private Window djK;
    private TextView djL;
    private RelativeLayout djM;
    private RelativeLayout djN;
    private TextView djO;
    private TextView djP;
    private TextView djQ;
    private TextView djR;
    private ImageView djS;
    private int djT;
    private int djU;
    public n djX;
    public p djY;
    private InputMethodManager mInputManager;
    private Drawable djV = null;
    public DynamicHeightListView djW = null;
    private BroadcastReceiver djZ = new a(this);
    private AdapterView.OnItemClickListener HP = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.djK = getWindow();
        this.djK.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.djK.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(n.g.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (com.baidu.adp.lib.util.k.jj()) {
            this.djV = awF();
            if (this.djV != null) {
                this.djK.setBackgroundDrawable(this.djV);
            }
        }
        initUI();
        this.djT = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.d.ds360);
        this.djU = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.d.ds484);
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
        this.djM = (RelativeLayout) findViewById(n.f.screenlock_input_layout);
        this.djL = (TextView) findViewById(n.f.screenlock_send_button);
        this.bXx = (EditText) findViewById(n.f.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.djN = (RelativeLayout) findViewById(n.f.one_chat_head_layout);
        this.djO = (TextView) findViewById(n.f.friend_name_head);
        this.djP = (TextView) findViewById(n.f.last_msg_time_head);
        this.djR = (TextView) findViewById(n.f.unread_msg_count);
        this.djQ = (TextView) findViewById(n.f.look_more_textview);
        this.djQ.setOnClickListener(new c(this));
        this.djL.setOnClickListener(new d(this));
        this.djS = (ImageView) findViewById(n.f.head_close);
        this.djS.setOnClickListener(new e(this));
        this.djW = (DynamicHeightListView) findViewById(n.f.screenlock_chat_list_content);
        this.djX = new n(getPageContext().getPageActivity());
        this.djW.setAdapter((ListAdapter) this.djX);
        this.djW.setOnItemClickListener(this.HP);
        registerReceiver(this.djZ, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.awH().dkk = false;
    }

    public String awE() {
        if (this.bXx != null) {
            return com.baidu.adp.lib.util.j.a(this.bXx.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(awG())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> awJ = f.awH().awJ();
        if (awJ == null || awJ.isEmpty()) {
            f.awH().dke.awP();
            finish();
            return;
        }
        if (f.awH().awK().size() == 1) {
            p pVar = f.awH().awK().get(0);
            if (f.awH().awO()) {
                this.djM.setVisibility(8);
                this.djR.setVisibility(8);
                this.djN.setVisibility(8);
                this.djW.setMaxHeight(0);
            } else {
                this.djM.setVisibility(0);
                this.djR.setText(lP(pVar.dkC));
                this.djR.setVisibility(0);
                this.djN.setVisibility(0);
                this.djO.setText(pVar.groupName);
                this.djP.setText(bB(pVar.dkE));
                this.djW.setMaxHeight(this.djT);
            }
            this.djQ.setVisibility(8);
            this.djX.gI(false);
        } else {
            this.djM.setVisibility(8);
            this.djN.setVisibility(8);
            this.djR.setVisibility(8);
            if (f.awH().awO()) {
                if (f.awH().awK().size() < 3) {
                    this.djQ.setVisibility(8);
                    linkedList = awJ;
                } else {
                    List<p> awJ2 = f.awH().awJ();
                    LinkedList linkedList2 = new LinkedList(awJ2.subList(0, 2));
                    linkedList2.add(awJ2.get(awJ2.size() - 1));
                    this.djQ.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.awH().awK().size() <= 3) {
                this.djQ.setVisibility(8);
                linkedList = awJ;
            } else {
                this.djQ.setVisibility(0);
                linkedList = awJ;
            }
            this.djX.gI(true);
            this.djW.setMaxHeight(this.djU);
            awJ = linkedList;
        }
        this.djX.gJ(f.awH().awO());
        this.djX.setData(awJ);
        this.djX.notifyDataSetChanged();
        f.awH().dkh = 1;
        f.awH().dkf = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.awH().dkh = 0;
        f.awH().dkf = 0;
        HidenSoftKeyPad(this.mInputManager, this.bXx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.djZ);
        f.awH().dkh = 0;
        this.djV = null;
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                bf.vD().b(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new av("c10316").ab("obj_type", pVar.stat).r("obj_locate", 2));
                f.awH().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.awH().c(pVar);
                f.awH().dke.awP();
                if (!f.awH().dke.awR()) {
                    f.awH().dke.awQ();
                }
                f.awH().dkf = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.djY.groupId, 0L), pVar.groupName, pVar.dkD, 0, pVar.dkG ? 1 : 0)));
                f.awH().c(pVar);
                f.awH().dkf = 0;
                f.awH().dke.awP();
                if (!f.awH().dke.awR()) {
                    f.awH().dke.awQ();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.djY.groupId, 0L), pVar.groupName, pVar.dkD, 0, 4)));
                f.awH().c(pVar);
                f.awH().dkf = 0;
                f.awH().dke.awP();
                if (!f.awH().dke.awR()) {
                    f.awH().dke.awQ();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.awH().c(pVar);
                f.awH().dke.awP();
                if (!f.awH().dke.awR()) {
                    f.awH().dke.awQ();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.awH().dke.awP();
            finish();
            return true;
        } else if (i == 82) {
            f.awH().dke.awP();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bB(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String lP(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable awF() {
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

    public String awG() {
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
