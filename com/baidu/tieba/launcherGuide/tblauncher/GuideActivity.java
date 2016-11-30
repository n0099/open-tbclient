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
    private ArrayList<View> dFk;
    private ArrayList<ImageView> dFl;
    private b dFm;
    private BaseViewPager dFn;
    private IndicatorView dFo;
    private View dFp;
    private a dFj = null;
    private String cEN = null;
    private boolean dFq = true;
    public boolean dFr = true;
    private final int[] dFs = {r.f.bg_startpage1, r.f.bg_startpage2, r.f.bg_startpage3};
    private final int[] dFt = {r.f.bg_app_startpage1, r.f.bg_app_startpage2, r.f.bg_app_startpage3};
    private int dFu = 1;
    private int dFv = 0;
    private final ArrayList<Bitmap> dFw = new ArrayList<>();
    private final BaseViewPager.a aeq = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dFx = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dFy = new c(this);
    private final HttpMessageListener dFz = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.cEN = bundle.getString("from_page");
            this.dFu = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.cEN = getIntent().getStringExtra("from_page");
            this.dFu = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.cEN)) {
            this.cEN = "";
        }
        switch (this.dFu) {
            case 3:
                this.dFv = this.dFt.length;
                break;
            default:
                this.dFv = this.dFs.length;
                break;
        }
        try {
            setContentView(r.h.guide_activity);
            PT();
            this.dFr = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("jump_to_new_user_guide", true);
            if (this.dFr) {
                aDq();
            }
            try {
                aDn();
                this.dFm = new b(this, null);
                this.dFn = (BaseViewPager) findViewById(r.g.guide_pager);
                this.dFn.setAdapter(this.dFm);
                this.dFo = (IndicatorView) findViewById(r.g.guide_page_indicator);
                this.dFo.setCount(this.dFv);
                if (this.dFu == 3) {
                    this.dFo.setSelector(getResources().getDrawable(r.f.icon_guide_app_pagecontrol_on));
                    this.dFo.setDrawable(getResources().getDrawable(r.f.icon_guide_app_pagecontrol_off));
                } else {
                    this.dFo.setSelector(getResources().getDrawable(r.f.icon_guide_pagecontrol_on));
                    this.dFo.setDrawable(getResources().getDrawable(r.f.icon_guide_pagecontrol_off));
                }
                this.dFo.setPosition(0.0f);
                if (this.dFv <= 1) {
                    this.dFo.setVisibility(4);
                } else {
                    this.dFo.setVisibility(0);
                }
                this.dFn.setOnScrollOutListener(this.aeq);
                this.dFn.setOnFlipOutListener(this.aeq);
                this.dFn.setOnPageChangeListener(this.dFy);
                this.dFp = findViewById(r.g.start_app);
                if (this.dFu == 1) {
                    this.dFo.setVisibility(0);
                    y(this.dFo, r.e.ds40);
                    this.dFo.setSpacing(getResources().getDimensionPixelSize(r.e.ds18));
                }
                this.dFp.setVisibility(8);
                this.dFp.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.cEN != null && this.cEN.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dFj = new a(this, null);
                    this.dFj.setSelfExecute(true);
                    this.dFj.execute(new String[0]);
                    return;
                }
                this.dFj = null;
            } catch (OutOfMemoryError e) {
                aDp();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dFq = true;
                this.dFr = false;
                aDo();
            } catch (RuntimeException e2) {
                aDp();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dFq = true;
                this.dFr = false;
                aDo();
            }
        } catch (RuntimeException e3) {
            this.dFq = true;
            this.dFr = false;
            aDo();
        }
    }

    private void aDn() {
        Bitmap d;
        this.dFk = new ArrayList<>();
        this.dFl = new ArrayList<>();
        for (int i = 0; i < this.dFv; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(r.g.guide_item_img);
            switch (this.dFu) {
                case 3:
                    d = d(imageView, this.dFt[i]);
                    break;
                default:
                    d = d(imageView, this.dFs[i]);
                    break;
            }
            if (d == null) {
                aDo();
                return;
            }
            this.dFw.add(d);
            this.dFl.add(imageView);
            this.dFk.add(relativeLayout);
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
    public void aDo() {
        if (this.cEN != null && !this.cEN.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            MN();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(int i) {
        y(this.dFp, i);
    }

    private void y(View view, int i) {
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
        aDp();
        if (this.dFj != null) {
            this.dFj.cancel(true);
            this.dFj = null;
        }
    }

    protected void aDp() {
        if (this.dFn != null) {
            this.dFn.setBackgroundDrawable(null);
        }
        if (this.dFl != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dFl.size()) {
                    break;
                }
                ImageView imageView = this.dFl.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dFw != null) {
            Iterator<Bitmap> it = this.dFw.iterator();
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
                aDo();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MN() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dFq) {
            if (!this.dFr || !NewUserGuideActivityConfig.canResponse()) {
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
                aDr();
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.um().getBoolean("has_shown_app_guide", false)) {
                k.eH().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dFu == 3) {
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dFq = false;
        }
    }

    public void PT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dFz);
    }

    public void aDq() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aDr() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDs() {
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
    public boolean aDt() {
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
            return Boolean.valueOf(GuideActivity.this.aDt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aDs();
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
            return GuideActivity.this.dFk.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dFk.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dFk.get(i), 0);
                if (i == GuideActivity.this.dFk.size() - 1) {
                    ((View) GuideActivity.this.dFk.get(i)).setOnClickListener(GuideActivity.this.dFx);
                }
                return GuideActivity.this.dFk.get(i);
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
