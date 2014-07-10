package com.baidu.tieba.tblauncher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.StatService;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ap;
import com.baidu.tbadk.core.atomData.as;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity {
    private ArrayList<View> g;
    private ArrayList<ImageView> h;
    private j i;
    private BaseViewPager j;
    private ImageView k;
    private boolean m;
    private ViewGroup n;
    private Button o;
    private i e = null;
    private String f = null;
    private boolean l = true;
    public boolean a = true;
    private final com.baidu.tbadk.core.view.a p = new b(this);
    private View.OnClickListener q = new c(this);
    private View.OnClickListener r = new d(this);
    public View.OnClickListener b = new e(this);
    public View.OnClickListener c = new f(this);
    private final ViewPager.OnPageChangeListener s = new g(this);
    public HttpMessageListener d = new h(this, 1001520);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015000, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.guide_activity);
        a();
        this.a = com.baidu.tbadk.core.sharedPref.b.a().a("jump_to_new_user_guide", true);
        if (this.a) {
            b();
        }
        d();
        this.i = new j(this, null);
        this.j = (BaseViewPager) findViewById(com.baidu.tieba.v.guide_pager);
        this.j.setAdapter(this.i);
        this.j.setOnFlipOutListener(this.p);
        this.j.setOnPageChangeListener(this.s);
        if (bundle != null) {
            this.f = bundle.getString("from_page");
        } else {
            this.f = getIntent().getStringExtra("from_page");
        }
        if (TextUtils.isEmpty(this.f)) {
            this.f = "";
        }
        com.baidu.tbadk.core.f.a(this, "new_user_guide_pv");
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.setAppChannel(TbConfig.getFrom());
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
        if (this.f != null && this.f.equals("from_logo_page")) {
            this.e = new i(this, null);
            this.e.setSelfExecute(true);
            this.e.execute(new String[0]);
            return;
        }
        this.e = null;
    }

    private void d() {
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(com.baidu.tieba.w.guide_page_first, (ViewGroup) null, false);
        View inflate2 = from.inflate(com.baidu.tieba.w.guide_page_second, (ViewGroup) null, false);
        View inflate3 = from.inflate(com.baidu.tieba.w.guide_page_third, (ViewGroup) null, false);
        View inflate4 = from.inflate(com.baidu.tieba.w.guide_page_forth, (ViewGroup) null, false);
        this.h.add((ImageView) inflate.findViewById(com.baidu.tieba.v.image_first));
        this.h.add((ImageView) inflate2.findViewById(com.baidu.tieba.v.image_second));
        this.h.add((ImageView) inflate3.findViewById(com.baidu.tieba.v.image_third));
        this.h.add((ImageView) inflate4.findViewById(com.baidu.tieba.v.image_forth));
        this.n = (ViewGroup) inflate4.findViewById(com.baidu.tieba.v.guide_page_forth_hao123_open_layout);
        this.k = (ImageView) inflate4.findViewById(com.baidu.tieba.v.radio_hao123_open);
        this.o = (Button) inflate4.findViewById(com.baidu.tieba.v.start_app);
        if (!TbadkApplication.m252getInst().isHao123HelperShouldOpen()) {
            this.n.setVisibility(8);
            this.o.setVisibility(0);
        } else {
            this.n.setVisibility(0);
            this.o.setVisibility(8);
        }
        this.k.setSelected(TbadkApplication.m252getInst().isTiebaHelperOpen());
        this.n.setOnClickListener(this.r);
        this.o.setOnClickListener(this.q);
        this.g.add(inflate);
        this.g.add(inflate2);
        this.g.add(inflate3);
        this.g.add(inflate4);
    }

    public void e() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012117));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            MessageManager.getInstance().unRegisterListener(this.d);
        }
        if (this.j != null) {
            this.j.setBackgroundDrawable(null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                break;
            }
            ImageView imageView = this.h.get(i2);
            imageView.setBackgroundDrawable(null);
            imageView.setImageBitmap(null);
            i = i2 + 1;
        }
        if (this.e != null) {
            this.e.cancel(true);
            this.e = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.onResume((Context) this);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.onPause((Context) this);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (!this.f.equals("from_about_page")) {
                    f();
                }
                closeActivity();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void f() {
        boolean isFirstUse = TbadkApplication.m252getInst().getIsFirstUse();
        if (this.l) {
            if (!this.a) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015001, new ap(this).a(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    sendMessage(new CustomMessage(2015001, new ap(this).a(1)));
                }
            } else {
                c();
                com.baidu.tbadk.core.sharedPref.b.a().c("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                TbadkApplication.m252getInst().setUsed();
                TbadkApplication.m252getInst().setFirstGoMaintab(true);
                TbadkApplication.m252getInst().setFirstGoFrs(true);
            }
            finish();
            this.l = false;
        }
    }

    public void a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001520, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.d);
    }

    public void b() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(1001520);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void c() {
        sendMessage(new CustomMessage(2012116, new as(this, false, true)));
    }

    public void g() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPackageName(), String.valueOf(getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(com.baidu.tieba.y.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.u.icon));
        sendBroadcast(intent2);
    }

    public boolean h() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getString(com.baidu.tieba.y.app_name)}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }
}
