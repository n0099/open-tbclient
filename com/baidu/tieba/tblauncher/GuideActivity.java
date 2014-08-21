package com.baidu.tieba.tblauncher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.atomData.ay;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity {
    private ArrayList<View> e;
    private ArrayList<ImageView> f;
    private h g;
    private BaseViewPager h;
    private ImageView i;
    private View j;
    private boolean l;
    private ViewGroup m;
    private g c = null;
    private String d = null;
    private boolean k = true;
    public boolean a = true;
    private final com.baidu.tbadk.core.view.a n = new b(this);
    private View.OnClickListener o = new c(this);
    public View.OnClickListener b = new d(this);
    private final ViewPager.OnPageChangeListener p = new e(this);
    private final HttpMessageListener q = new f(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015000, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.d = bundle.getString("from_page");
        } else {
            this.d = getIntent().getStringExtra("from_page");
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = "";
        }
        try {
            setContentView(com.baidu.tieba.v.guide_activity);
            b();
            this.a = com.baidu.tbadk.core.sharedPref.b.a().a("jump_to_new_user_guide", true);
            if (this.a) {
                c();
            }
            try {
                e();
                this.g = new h(this, null);
                this.h = (BaseViewPager) findViewById(com.baidu.tieba.u.guide_pager);
                this.h.setAdapter(this.g);
                this.h.setOnFlipOutListener(this.n);
                this.h.setOnPageChangeListener(this.p);
                com.baidu.tbadk.core.f.a(this, "new_user_guide_pv");
                if (this.d != null && this.d.equals("from_logo_page")) {
                    this.c = new g(this, null);
                    this.c.setSelfExecute(true);
                    this.c.execute(new String[0]);
                    return;
                }
                this.c = null;
            } catch (OutOfMemoryError e) {
                a();
                TbadkApplication.m252getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.k = true;
                this.a = false;
                g();
            } catch (RuntimeException e2) {
                a();
                TbadkApplication.m252getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.k = true;
                this.a = false;
                g();
            }
        } catch (RuntimeException e3) {
            this.k = true;
            this.a = false;
            g();
        }
    }

    private void e() {
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        View a = com.baidu.adp.lib.e.b.a().a(this, com.baidu.tieba.v.guide_page_first, null, false);
        View a2 = com.baidu.adp.lib.e.b.a().a(this, com.baidu.tieba.v.guide_page_second, null, false);
        View a3 = com.baidu.adp.lib.e.b.a().a(this, com.baidu.tieba.v.guide_page_third, null, false);
        this.f.add((ImageView) a.findViewById(com.baidu.tieba.u.image_first));
        this.f.add((ImageView) a2.findViewById(com.baidu.tieba.u.image_second));
        this.f.add((ImageView) a3.findViewById(com.baidu.tieba.u.image_third));
        this.m = (ViewGroup) a3.findViewById(com.baidu.tieba.u.guide_page_end_hao123_open_layout);
        this.i = (ImageView) a3.findViewById(com.baidu.tieba.u.radio_hao123_open);
        this.j = a3.findViewById(com.baidu.tieba.u.start_app);
        if (!TbadkApplication.m252getInst().isHao123HelperShouldOpen()) {
            this.m.setVisibility(8);
            this.j.setVisibility(0);
        } else {
            this.m.setVisibility(0);
            this.j.setVisibility(8);
        }
        this.i.setSelected(TbadkApplication.m252getInst().isTiebaHelperOpen());
        this.m.setOnClickListener(this.o);
        this.j.setOnClickListener(this.b);
        this.e.add(a);
        this.e.add(a2);
        this.e.add(a3);
    }

    public void f() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012117));
    }

    public void g() {
        if (this.d != null && !this.d.equals("from_about_page")) {
            h();
        }
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a();
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
        }
    }

    protected void a() {
        if (this.h != null) {
            this.h.setBackgroundDrawable(null);
        }
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    ImageView imageView = this.f.get(i2);
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageBitmap(null);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                g();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void h() {
        boolean isFirstUse = TbadkApplication.m252getInst().getIsFirstUse();
        if (this.k) {
            if (!this.a) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015001, new at(this).a(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    sendMessage(new CustomMessage(2015001, new at(this).a(4)));
                }
            } else {
                d();
                com.baidu.tbadk.core.sharedPref.b.a().b("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                TbadkApplication.m252getInst().setUsed();
                TbadkApplication.m252getInst().setFirstGoMaintab(true);
                TbadkApplication.m252getInst().setFirstGoFrs(true);
            }
            finish();
            this.k = false;
        }
    }

    public void b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.q);
    }

    public void c() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void d() {
        sendMessage(new CustomMessage(2012116, new ay(this, false, true)));
    }

    public void i() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPackageName(), String.valueOf(getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(com.baidu.tieba.x.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.t.icon));
        sendBroadcast(intent2);
    }

    public boolean j() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getString(com.baidu.tieba.x.app_name)}, null);
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
