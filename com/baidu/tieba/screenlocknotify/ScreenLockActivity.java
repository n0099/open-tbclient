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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private EditText bEb;
    private Window cub;
    private TextView cuc;
    private RelativeLayout cud;
    private RelativeLayout cue;
    private TextView cuf;
    private TextView cug;
    private TextView cuh;
    private TextView cui;
    private ImageView cuj;
    private int cuk;
    private int cul;
    public n cuo;
    public p cup;
    private InputMethodManager mInputManager;
    private Drawable cum = null;
    public DynamicHeightListView cun = null;
    private BroadcastReceiver cuq = new a(this);
    private AdapterView.OnItemClickListener Hw = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.cub = getWindow();
        this.cub.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        this.cub.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(i.g.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (com.baidu.adp.lib.util.k.jj()) {
            this.cum = akb();
            if (this.cum != null) {
                this.cub.setBackgroundDrawable(this.cum);
            }
        }
        initUI();
        this.cuk = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds360);
        this.cul = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds484);
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
        this.cud = (RelativeLayout) findViewById(i.f.screenlock_input_layout);
        this.cuc = (TextView) findViewById(i.f.screenlock_send_button);
        this.bEb = (EditText) findViewById(i.f.screenlock_edit_view);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.cue = (RelativeLayout) findViewById(i.f.one_chat_head_layout);
        this.cuf = (TextView) findViewById(i.f.friend_name_head);
        this.cug = (TextView) findViewById(i.f.last_msg_time_head);
        this.cui = (TextView) findViewById(i.f.unread_msg_count);
        this.cuh = (TextView) findViewById(i.f.look_more_textview);
        this.cuh.setOnClickListener(new c(this));
        this.cuc.setOnClickListener(new d(this));
        this.cuj = (ImageView) findViewById(i.f.head_close);
        this.cuj.setOnClickListener(new e(this));
        this.cun = (DynamicHeightListView) findViewById(i.f.screenlock_chat_list_content);
        this.cuo = new n(getPageContext().getPageActivity());
        this.cun.setAdapter((ListAdapter) this.cuo);
        this.cun.setOnItemClickListener(this.Hw);
        registerReceiver(this.cuq, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        g.akd().cuC = false;
    }

    public String aka() {
        if (this.bEb != null) {
            return com.baidu.adp.lib.util.j.a(this.bEb.getText(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(akc())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        LinkedList linkedList;
        super.onResume();
        List<p> ake = g.akd().ake();
        if (ake == null || ake.isEmpty()) {
            g.akd().cuw.akk();
            finish();
            return;
        }
        if (g.akd().akf().size() == 1) {
            p pVar = g.akd().akf().get(0);
            if (g.akd().akj()) {
                this.cud.setVisibility(8);
                this.cui.setVisibility(8);
                this.cue.setVisibility(8);
                this.cun.setMaxHeight(0);
            } else {
                this.cud.setVisibility(0);
                this.cui.setText(ji(pVar.cuU));
                this.cui.setVisibility(0);
                this.cue.setVisibility(0);
                this.cuf.setText(pVar.groupName);
                this.cug.setText(av(pVar.csY));
                this.cun.setMaxHeight(this.cuk);
            }
            this.cuh.setVisibility(8);
            this.cuo.eT(false);
        } else {
            this.cud.setVisibility(8);
            this.cue.setVisibility(8);
            this.cui.setVisibility(8);
            if (g.akd().akj()) {
                if (g.akd().akf().size() < 3) {
                    this.cuh.setVisibility(8);
                    linkedList = ake;
                } else {
                    List<p> ake2 = g.akd().ake();
                    LinkedList linkedList2 = new LinkedList(ake2.subList(0, 2));
                    linkedList2.add(ake2.get(ake2.size() - 1));
                    this.cuh.setVisibility(0);
                    linkedList = linkedList2;
                }
            } else if (g.akd().akf().size() <= 3) {
                this.cuh.setVisibility(8);
                linkedList = ake;
            } else {
                this.cuh.setVisibility(0);
                linkedList = ake;
            }
            this.cuo.eT(true);
            this.cun.setMaxHeight(this.cul);
            ake = linkedList;
        }
        this.cuo.eU(g.akd().akj());
        this.cuo.setData(ake);
        this.cuo.notifyDataSetChanged();
        g.akd().cuz = 1;
        g.akd().cux = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        g.akd().cuz = 0;
        g.akd().cux = 0;
        HidenSoftKeyPad(this.mInputManager, this.bEb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.cuq);
        g.akd().cuz = 0;
        this.cum = null;
    }

    public void a(p pVar) {
        if (pVar != null) {
            if (pVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), Integer.parseInt(pVar.groupId), pVar.groupName, 0L, "from_lock")));
                g.akd().c(pVar);
                g.akd().cuw.akk();
                if (!g.akd().cuw.akm()) {
                    g.akd().cuw.akl();
                }
                g.akd().cux = 0;
                finish();
            } else if (pVar.customGroupType == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cup.groupId, 0L), pVar.groupName, pVar.cuV, 0, pVar.cuX ? 1 : 0)));
                g.akd().c(pVar);
                g.akd().cux = 0;
                g.akd().cuw.akk();
                if (!g.akd().cuw.akm()) {
                    g.akd().cuw.akl();
                }
                finish();
            } else if (pVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cup.groupId, 0L), pVar.groupName, pVar.cuV, 0, 4)));
                g.akd().c(pVar);
                g.akd().cux = 0;
                g.akd().cuw.akk();
                if (!g.akd().cuw.akm()) {
                    g.akd().cuw.akl();
                }
                finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(getPageContext().getPageActivity())));
                g.akd().cuw.akk();
                if (!g.akd().cuw.akm()) {
                    g.akd().cuw.akl();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            g.akd().cuw.akk();
            finish();
            return true;
        } else if (i == 82) {
            g.akd().cuw.akk();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String av(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public String ji(int i) {
        return i < 100 ? new StringBuilder().append(i).toString() : "99+";
    }

    public Drawable akb() {
        Bitmap bitmap;
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
    }

    public String akc() {
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
