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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText cZK;
    private Window eUf;
    private TextView eUg;
    private RelativeLayout eUh;
    private RelativeLayout eUi;
    private TextView eUj;
    private TextView eUk;
    private TextView eUl;
    private TextView eUm;
    private ImageView eUn;
    private int eUo;
    private int eUp;
    public n eUs;
    public p eUt;
    private InputMethodManager mInputManager;
    private Drawable eUq = null;
    public DynamicHeightListView eUr = null;
    private BroadcastReceiver eUu = new a(this);
    private AdapterView.OnItemClickListener zr = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.eUf = getWindow();
        this.eUf.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.eUf.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(u.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(u.d.transparent, true);
        if (com.baidu.adp.lib.util.k.fK()) {
            this.eUq = aYj();
            if (this.eUq != null) {
                this.eUf.setBackgroundDrawable(this.eUq);
            }
        }
        initUI();
        this.eUo = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds360);
        this.eUp = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds484);
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
        this.eUh = (RelativeLayout) findViewById(u.g.screenlock_input_layout);
        this.eUg = (TextView) findViewById(u.g.screenlock_send_button);
        this.cZK = (EditText) findViewById(u.g.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.eUi = (RelativeLayout) findViewById(u.g.one_chat_head_layout);
        this.eUj = (TextView) findViewById(u.g.friend_name_head);
        this.eUk = (TextView) findViewById(u.g.last_msg_time_head);
        this.eUm = (TextView) findViewById(u.g.unread_msg_count);
        this.eUl = (TextView) findViewById(u.g.look_more_textview);
        this.eUl.setOnClickListener(new c(this));
        this.eUg.setOnClickListener(new d(this));
        this.eUn = (ImageView) findViewById(u.g.head_close);
        this.eUn.setOnClickListener(new e(this));
        this.eUr = (DynamicHeightListView) findViewById(u.g.screenlock_chat_list_content);
        this.eUs = new n(getPageContext().getPageActivity());
        this.eUr.setAdapter((ListAdapter) this.eUs);
        this.eUr.setOnItemClickListener(this.zr);
        registerReceiver(this.eUu, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        f.aYk().eUF = false;
    }

    public String axy() {
        if (this.cZK != null) {
            return com.baidu.adp.lib.util.j.a(this.cZK.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(aXB())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> aYm = f.aYk().aYm();
        if (aYm == null || aYm.isEmpty()) {
            f.aYk().eUz.aYs();
            finish();
            return;
        }
        if (f.aYk().aYn().size() == 1) {
            p pVar = f.aYk().aYn().get(0);
            if (f.aYk().aYr()) {
                this.eUh.setVisibility(8);
                this.eUm.setVisibility(8);
                this.eUi.setVisibility(8);
                this.eUr.setMaxHeight(0);
            } else {
                this.eUh.setVisibility(0);
                this.eUm.setText(qh(pVar.eUX));
                this.eUm.setVisibility(0);
                this.eUi.setVisibility(0);
                this.eUj.setText(pVar.groupName);
                this.eUk.setText(cy(pVar.lastTime));
                this.eUr.setMaxHeight(this.eUo);
                this.eUr.setTranscriptMode(2);
            }
            this.eUl.setVisibility(8);
            this.eUs.jR(false);
        } else {
            this.eUh.setVisibility(8);
            this.eUi.setVisibility(8);
            this.eUm.setVisibility(8);
            if (f.aYk().aYr()) {
                if (f.aYk().aYn().size() < 3) {
                    this.eUl.setVisibility(8);
                    linkedList = aYm;
                } else {
                    List<p> aYm2 = f.aYk().aYm();
                    LinkedList linkedList2 = new LinkedList(aYm2.subList(0, 2));
                    linkedList2.add(aYm2.get(aYm2.size() - 1));
                    this.eUl.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (f.aYk().aYn().size() <= 3) {
                this.eUl.setVisibility(8);
                linkedList = aYm;
            } else {
                this.eUl.setVisibility(0);
                linkedList = aYm;
            }
            this.eUs.jR(true);
            this.eUr.setMaxHeight(this.eUp);
            this.eUr.setTranscriptMode(0);
            aYm = linkedList;
        }
        this.eUs.jS(f.aYk().aYr());
        this.eUs.setData(aYm);
        this.eUs.notifyDataSetChanged();
        f.aYk().eUC = 1;
        f.aYk().eUA = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f.aYk().eUC = 0;
        f.aYk().eUA = 0;
        HidenSoftKeyPad(this.mInputManager, this.cZK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.eUu);
        f.aYk().eUC = 0;
        this.eUq = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AUDIO_VIEW_SHOW_WHEN_LOCK_DESTROY));
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (!TextUtils.isEmpty(pVar.url)) {
                bi.us().c(getPageContext(), new String[]{pVar.url});
                TiebaStatic.log(new ay("c10316").ab("obj_type", pVar.stat).s("obj_locate", 2));
                f.aYk().c(pVar);
                finish();
            } else if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                f.aYk().c(pVar);
                f.aYk().eUz.aYs();
                if (!f.aYk().eUz.aYu()) {
                    f.aYk().eUz.aYt();
                }
                f.aYk().eUA = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.eUt.groupId, 0L), pVar.groupName, pVar.eUY, 0, pVar.eVa ? 1 : 0)));
                f.aYk().c(pVar);
                f.aYk().eUA = 0;
                f.aYk().eUz.aYs();
                if (!f.aYk().eUz.aYu()) {
                    f.aYk().eUz.aYt();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.eUt.groupId, 0L), pVar.groupName, pVar.eUY, 0, 4)));
                f.aYk().c(pVar);
                f.aYk().eUA = 0;
                f.aYk().eUz.aYs();
                if (!f.aYk().eUz.aYu()) {
                    f.aYk().eUz.aYt();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                f.aYk().c(pVar);
                f.aYk().eUz.aYs();
                if (!f.aYk().eUz.aYu()) {
                    f.aYk().eUz.aYt();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f.aYk().eUz.aYs();
            finish();
            return true;
        } else if (i == 82) {
            f.aYk().eUz.aYs();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cy(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String qh(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable aYj() {
        Bitmap bitmap;
        try {
            Drawable drawable = WallpaperManager.getInstance(getPageContext().getPageActivity()).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(com.baidu.adp.lib.util.k.A(getPageContext().getPageActivity()), bitmap.getWidth());
                int min2 = Math.min(com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity()), bitmap.getHeight());
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

    public String aXB() {
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
