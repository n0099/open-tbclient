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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText bIr;
    private TextView cLA;
    private ImageView cLB;
    private int cLC;
    private int cLD;
    public n cLG;
    public p cLH;
    private Window cLt;
    private TextView cLu;
    private RelativeLayout cLv;
    private RelativeLayout cLw;
    private TextView cLx;
    private TextView cLy;
    private TextView cLz;
    private InputMethodManager mInputManager;
    private Drawable cLE = null;
    public DynamicHeightListView cLF = null;
    private BroadcastReceiver cLI = new a(this);
    private AdapterView.OnItemClickListener Hy = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.cLt = getWindow();
        this.cLt.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.cLt.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(i.g.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (com.baidu.adp.lib.util.k.ji()) {
            this.cLE = arh();
            if (this.cLE != null) {
                this.cLt.setBackgroundDrawable(this.cLE);
            }
        }
        initUI();
        this.cLC = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds360);
        this.cLD = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds484);
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
        this.cLv = (RelativeLayout) findViewById(i.f.screenlock_input_layout);
        this.cLu = (TextView) findViewById(i.f.screenlock_send_button);
        this.bIr = (EditText) findViewById(i.f.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cLw = (RelativeLayout) findViewById(i.f.one_chat_head_layout);
        this.cLx = (TextView) findViewById(i.f.friend_name_head);
        this.cLy = (TextView) findViewById(i.f.last_msg_time_head);
        this.cLA = (TextView) findViewById(i.f.unread_msg_count);
        this.cLz = (TextView) findViewById(i.f.look_more_textview);
        this.cLz.setOnClickListener(new c(this));
        this.cLu.setOnClickListener(new d(this));
        this.cLB = (ImageView) findViewById(i.f.head_close);
        this.cLB.setOnClickListener(new e(this));
        this.cLF = (DynamicHeightListView) findViewById(i.f.screenlock_chat_list_content);
        this.cLG = new n(getPageContext().getPageActivity());
        this.cLF.setAdapter((ListAdapter) this.cLG);
        this.cLF.setOnItemClickListener(this.Hy);
        registerReceiver(this.cLI, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.arj().cLT = false;
    }

    public String arg() {
        if (this.bIr != null) {
            return com.baidu.adp.lib.util.j.a(this.bIr.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(ari())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> arl = f.arj().arl();
        if (arl == null || arl.isEmpty()) {
            f.arj().cLN.arr();
            finish();
            return;
        }
        if (f.arj().arm().size() == 1) {
            p pVar = f.arj().arm().get(0);
            if (f.arj().arq()) {
                this.cLv.setVisibility(8);
                this.cLA.setVisibility(8);
                this.cLw.setVisibility(8);
                this.cLF.setMaxHeight(0);
            } else {
                this.cLv.setVisibility(0);
                this.cLA.setText(kH(pVar.cMm));
                this.cLA.setVisibility(0);
                this.cLw.setVisibility(0);
                this.cLx.setText(pVar.groupName);
                this.cLy.setText(bf(pVar.cKn));
                this.cLF.setMaxHeight(this.cLC);
            }
            this.cLz.setVisibility(8);
            this.cLG.fS(false);
        } else {
            this.cLv.setVisibility(8);
            this.cLw.setVisibility(8);
            this.cLA.setVisibility(8);
            if (f.arj().arq()) {
                if (f.arj().arm().size() < 3) {
                    this.cLz.setVisibility(8);
                    linkedList = arl;
                } else {
                    List<p> arl2 = f.arj().arl();
                    LinkedList linkedList2 = new LinkedList(arl2.subList(0, 2));
                    linkedList2.add(arl2.get(arl2.size() - 1));
                    this.cLz.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.arj().arm().size() <= 3) {
                this.cLz.setVisibility(8);
                linkedList = arl;
            } else {
                this.cLz.setVisibility(0);
                linkedList = arl;
            }
            this.cLG.fS(true);
            this.cLF.setMaxHeight(this.cLD);
            arl = linkedList;
        }
        this.cLG.fT(f.arj().arq());
        this.cLG.setData(arl);
        this.cLG.notifyDataSetChanged();
        f.arj().cLQ = 1;
        f.arj().cLO = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.arj().cLQ = 0;
        f.arj().cLO = 0;
        HidenSoftKeyPad(this.mInputManager, this.bIr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.cLI);
        f.arj().cLQ = 0;
        this.cLE = null;
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                az.uX().b(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new aq("c10316").ae("obj_type", pVar.stat).r("obj_locate", 2));
                f.arj().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.arj().c(pVar);
                f.arj().cLN.arr();
                if (!f.arj().cLN.art()) {
                    f.arj().cLN.ars();
                }
                f.arj().cLO = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cLH.groupId, 0L), pVar.groupName, pVar.cMn, 0, pVar.cMp ? 1 : 0)));
                f.arj().c(pVar);
                f.arj().cLO = 0;
                f.arj().cLN.arr();
                if (!f.arj().cLN.art()) {
                    f.arj().cLN.ars();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cLH.groupId, 0L), pVar.groupName, pVar.cMn, 0, 4)));
                f.arj().c(pVar);
                f.arj().cLO = 0;
                f.arj().cLN.arr();
                if (!f.arj().cLN.art()) {
                    f.arj().cLN.ars();
                }
                TiebaStatic.log(new aq("c10321").r("obj_type", 1).ae("obj_name", "click"));
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.arj().c(pVar);
                f.arj().cLN.arr();
                if (!f.arj().cLN.art()) {
                    f.arj().cLN.ars();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.arj().cLN.arr();
            finish();
            return true;
        } else if (i == 82) {
            f.arj().cLN.arr();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bf(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String kH(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable arh() {
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

    public String ari() {
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
