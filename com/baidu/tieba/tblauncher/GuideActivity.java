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
import com.baidu.tbadk.core.atomData.al;
import com.baidu.tbadk.core.atomData.ao;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity {
    private ArrayList<View> g;
    private ArrayList<ImageView> h;
    private h i;
    private BaseViewPager j;
    private g e = null;
    private String f = null;
    private boolean k = true;
    public boolean a = true;
    private final com.baidu.tbadk.core.view.a l = new b(this);
    public View.OnClickListener b = new c(this);
    public View.OnClickListener c = new d(this);
    private final ViewPager.OnPageChangeListener m = new e(this);
    public HttpMessageListener d = new f(this, CmdConfig.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2017000, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.guide_activity);
        a();
        this.a = com.baidu.tbadk.core.sharedPref.b.a().a("jump_to_new_user_guide", true);
        if (this.a) {
            b();
        }
        d();
        this.i = new h(this, null);
        this.j = (BaseViewPager) findViewById(com.baidu.tieba.r.guide_pager);
        this.j.setAdapter(this.i);
        this.j.setOnScrollOutListener(this.l);
        this.j.setOnPageChangeListener(this.m);
        if (bundle != null) {
            this.f = bundle.getString("from_page");
        } else {
            this.f = getIntent().getStringExtra("from_page");
        }
        if (TextUtils.isEmpty(this.f)) {
            this.f = "";
        }
        com.baidu.tbadk.core.g.a(this, "new_user_guide_pv");
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.setAppChannel(TbConfig.getFrom());
            } catch (Throwable th) {
                BdLog.e(getClass().getName(), "onCreate", th.getMessage());
            }
        }
        if (this.f != null && this.f.equals("from_logo_page")) {
            this.e = new g(this, null);
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
        View inflate = from.inflate(com.baidu.tieba.s.guide_page_first, (ViewGroup) null, false);
        View inflate2 = from.inflate(com.baidu.tieba.s.guide_page_second, (ViewGroup) null, false);
        View inflate3 = from.inflate(com.baidu.tieba.s.guide_page_third, (ViewGroup) null, false);
        this.h.add((ImageView) inflate.findViewById(com.baidu.tieba.r.image_first));
        this.h.add((ImageView) inflate2.findViewById(com.baidu.tieba.r.image_second));
        this.h.add((ImageView) inflate3.findViewById(com.baidu.tieba.r.image_third));
        ((Button) inflate3.findViewById(com.baidu.tieba.r.btn_next)).setOnClickListener(this.b);
        this.g.add(inflate);
        this.g.add(inflate2);
        this.g.add(inflate3);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            MessageManager.getInstance().unRegisterListener(this.d);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.onResume((Context) this);
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "onResume", e.getMessage());
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
                BdLog.e(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (!this.f.equals("from_about_page")) {
                    e();
                }
                closeActivity();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void e() {
        boolean isFirstUse = TbadkApplication.m252getInst().getIsFirstUse();
        if (this.k) {
            if (!this.a) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2017001, new al(this).a(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2009006, null));
                    sendMessage(new CustomMessage(2017001, new al(this).a(2)));
                }
            } else {
                c();
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

    public void a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfig.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.d);
    }

    public void b() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfig.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void c() {
        sendMessage(new CustomMessage((int) CmdConfig.NEW_USER_GUIDE_PAGE, new ao(this, false, true)));
    }

    public void f() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPackageName(), String.valueOf(getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(com.baidu.tieba.u.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.q.icon));
        sendBroadcast(intent2);
    }

    public boolean g() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getString(com.baidu.tieba.u.app_name)}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.i(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
