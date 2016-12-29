package com.baidu.tieba.launcherGuide.tblauncher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.h.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> dii;
    private ArrayList<ImageView> dij;
    private b dik;
    private BaseViewPager dil;
    private IndicatorView dim;
    private View din;
    private a dih = null;
    private String ckd = null;
    private boolean dio = true;
    public boolean dip = true;
    private final int[] diq = {r.f.bg_startpage1};
    private final int[] dir = {r.f.bg_app_startpage1, r.f.bg_app_startpage2, r.f.bg_app_startpage3};
    private int dis = 1;
    private int dit = 0;
    private final ArrayList<Bitmap> diu = new ArrayList<>();
    private final BaseViewPager.a adJ = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener div = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener diw = new c(this);
    private final HttpMessageListener dix = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.ckd = bundle.getString("from_page");
            this.dis = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.ckd = getIntent().getStringExtra("from_page");
            this.dis = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.ckd)) {
            this.ckd = "";
        }
        switch (this.dis) {
            case 3:
                this.dit = this.dir.length;
                break;
            default:
                this.dit = this.diq.length;
                break;
        }
        try {
            setContentView(r.h.guide_activity);
            Ps();
            this.dip = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("jump_to_new_user_guide", true);
            if (this.dip) {
                awD();
            }
            try {
                awA();
                this.dik = new b(this, null);
                this.dil = (BaseViewPager) findViewById(r.g.guide_pager);
                this.dil.setAdapter(this.dik);
                this.dim = (IndicatorView) findViewById(r.g.guide_page_indicator);
                this.dim.setCount(this.dit);
                if (this.dis == 3) {
                    this.dim.setSelector(getResources().getDrawable(r.f.icon_guide_app_pagecontrol_on));
                    this.dim.setDrawable(getResources().getDrawable(r.f.icon_guide_app_pagecontrol_off));
                } else {
                    this.dim.setSelector(getResources().getDrawable(r.f.icon_guide_pagecontrol_on));
                    this.dim.setDrawable(getResources().getDrawable(r.f.icon_guide_pagecontrol_off));
                }
                this.dim.setPosition(0.0f);
                if (this.dit <= 1) {
                    this.dim.setVisibility(4);
                } else {
                    this.dim.setVisibility(0);
                }
                this.dil.setOnScrollOutListener(this.adJ);
                this.dil.setOnFlipOutListener(this.adJ);
                this.dil.setOnPageChangeListener(this.diw);
                this.din = findViewById(r.g.start_app);
                if (this.dis == 1 && this.dit <= 1) {
                    lI(r.e.ds90);
                    this.din.setVisibility(0);
                    this.din.requestFocus();
                } else {
                    this.din.setVisibility(8);
                }
                this.din.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.ckd != null && this.ckd.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dih = new a(this, null);
                    this.dih.setSelfExecute(true);
                    this.dih.execute(new String[0]);
                    return;
                }
                this.dih = null;
            } catch (OutOfMemoryError e) {
                awC();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dio = true;
                this.dip = false;
                awB();
            } catch (RuntimeException e2) {
                awC();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dio = true;
                this.dip = false;
                awB();
            }
        } catch (RuntimeException e3) {
            this.dio = true;
            this.dip = false;
            awB();
        }
    }

    private void awA() {
        Bitmap d;
        this.dii = new ArrayList<>();
        this.dij = new ArrayList<>();
        for (int i = 0; i < this.dit; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(r.g.guide_item_img);
            switch (this.dis) {
                case 3:
                    d = d(imageView, this.dir[i]);
                    break;
                default:
                    d = d(imageView, this.diq[i]);
                    break;
            }
            if (d == null) {
                awB();
                return;
            }
            this.diu.add(d);
            this.dij.add(imageView);
            this.dii.add(relativeLayout);
        }
    }

    private Bitmap d(ImageView imageView, int i) {
        Bitmap logoBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), i);
        if (logoBitmap == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            options.inSampleSize = 4;
            logoBitmap = BitmapHelper.getResBitmap(getPageContext().getPageActivity(), i, options);
        }
        if (logoBitmap != null) {
            imageView.setImageBitmap(logoBitmap);
        }
        return logoBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awB() {
        if (this.ckd != null && !this.ckd.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Mg();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(int i) {
        w(this.din, i);
    }

    private void w(View view, int i) {
        if (view != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.bottomMargin = dimensionPixelSize;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        awC();
        if (this.dih != null) {
            this.dih.cancel(true);
            this.dih = null;
        }
    }

    protected void awC() {
        if (this.dil != null) {
            this.dil.setBackgroundDrawable(null);
        }
        if (this.dij != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dij.size()) {
                    break;
                }
                ImageView imageView = this.dij.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.diu != null) {
            Iterator<Bitmap> it = this.diu.iterator();
            while (it.hasNext()) {
                Bitmap next = it.next();
                if (next != null && !next.isRecycled()) {
                    next.recycle();
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
                awB();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mg() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dio) {
            if (!this.dip || !NewUserGuideActivityConfig.canResponse()) {
                int i = TbadkCoreApplication.getCurrentAccount() == null ? 2 : 1;
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    if (!TbadkCoreApplication.isLogin()) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
                    } else {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                    }
                }
            } else {
                awE();
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("has_shown_app_guide", false)) {
                k.eH().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dis == 3) {
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dio = false;
        }
    }

    public void Ps() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dix);
    }

    public void awD() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void awE() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awF() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(r.j.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), r.f.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awG() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String P = P(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (P == null) {
                P = P(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + P + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(r.j.app_name)}, null);
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

    private String P(Context context, String str) {
        if (str == null) {
            return null;
        }
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8);
        if (installedPackages != null) {
            for (PackageInfo packageInfo : installedPackages) {
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (providerInfoArr != null) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (str.equals(providerInfo.readPermission)) {
                            return providerInfo.authority;
                        }
                        if (str.equals(providerInfo.writePermission)) {
                            return providerInfo.authority;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* synthetic */ a(GuideActivity guideActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.awG());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.awF();
            }
        }
    }

    /* loaded from: classes.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        /* synthetic */ b(GuideActivity guideActivity, b bVar) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dii.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dii.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dii.get(i), 0);
                if (i == GuideActivity.this.dii.size() - 1) {
                    ((View) GuideActivity.this.dii.get(i)).setOnClickListener(GuideActivity.this.div);
                }
                return GuideActivity.this.dii.get(i);
            }
            View view2 = new View(GuideActivity.this.getPageContext().getPageActivity());
            view2.setBackgroundColor(-1);
            ((ViewPager) view).addView(view2, 0);
            return view2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(View view, int i, Object obj) {
            ((ViewPager) view).removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }
}
