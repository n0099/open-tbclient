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
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.h;
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
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> dKF;
    private ArrayList<ImageView> dKG;
    private b dKH;
    private BaseViewPager dKI;
    private IndicatorView dKJ;
    private View dKK;
    private a dKE = null;
    private String beA = null;
    private boolean dKL = true;
    public boolean dKM = true;
    private final int[] dKN = {d.g.bg_startpage1, d.g.bg_startpage2, d.g.bg_startpage3, d.g.bg_startpage4};
    private final int[] dKO = {d.g.bg_app_startpage1, d.g.bg_app_startpage2};
    private int dKP = 1;
    private int dKQ = 0;
    private final ArrayList<Bitmap> dKR = new ArrayList<>();
    private final BaseViewPager.a ake = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void db(int i) {
            if (i == 0) {
                if (GuideActivity.this.dKI != null) {
                    GuideActivity.this.dKI.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.beA.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.KU();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener dKS = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aBA();
        }
    };
    private final ViewPager.OnPageChangeListener dKT = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.dKQ - 1) {
                switch (GuideActivity.this.dKP) {
                    case 1:
                        GuideActivity.this.mT(d.f.ds154);
                        GuideActivity.this.dKK.setVisibility(0);
                        GuideActivity.this.dKJ.setVisibility(0);
                        break;
                    case 2:
                    default:
                        GuideActivity.this.dKK.setVisibility(8);
                        break;
                    case 3:
                        GuideActivity.this.dKK.setVisibility(8);
                        break;
                }
            } else {
                GuideActivity.this.dKK.setVisibility(8);
                GuideActivity.this.mT(d.f.ds120);
                switch (GuideActivity.this.dKP) {
                    case 1:
                        GuideActivity.this.dKJ.setVisibility(0);
                        break;
                    case 3:
                        GuideActivity.this.dKJ.setVisibility(0);
                        break;
                }
            }
            if (GuideActivity.this.dKK.getVisibility() == 0) {
                GuideActivity.this.dKK.requestFocus();
            }
            GuideActivity.this.dKJ.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener dKU = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.dKM = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.dKM = true;
                    return;
                }
                GuideActivity.this.dKM = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.dKM = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.beA = bundle.getString("from_page");
            this.dKP = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.beA = getIntent().getStringExtra("from_page");
            this.dKP = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.beA)) {
            this.beA = "";
        }
        switch (this.dKP) {
            case 3:
                this.dKQ = this.dKO.length;
                break;
            default:
                this.dKQ = this.dKN.length;
                break;
        }
        try {
            setContentView(d.j.guide_activity);
            Un();
            this.dKM = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.dKM) {
                aBC();
            }
            try {
                aBz();
                this.dKH = new b();
                this.dKI = (BaseViewPager) findViewById(d.h.guide_pager);
                this.dKI.setAdapter(this.dKH);
                this.dKJ = (IndicatorView) findViewById(d.h.guide_page_indicator);
                this.dKJ.setCount(this.dKQ);
                w(this.dKJ, d.f.ds40);
                if (this.dKP == 3) {
                    this.dKJ.setSelector(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_on));
                    this.dKJ.setDrawable(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_off));
                } else {
                    w(this.dKJ, d.f.ds70);
                    this.dKJ.setSpacing(getResources().getDimensionPixelSize(d.f.ds6));
                    this.dKJ.setSelector(getResources().getDrawable(d.g.icon_guide_pagecontrol_on));
                    this.dKJ.setDrawable(getResources().getDrawable(d.g.icon_guide_pagecontrol_off));
                }
                this.dKJ.setPosition(0.0f);
                if (this.dKQ <= 1) {
                    this.dKJ.setVisibility(4);
                } else {
                    this.dKJ.setVisibility(0);
                }
                this.dKI.setOnScrollOutListener(this.ake);
                this.dKI.setOnFlipOutListener(this.ake);
                this.dKI.setOnPageChangeListener(this.dKT);
                this.dKK = findViewById(d.h.start_app);
                if (this.dKP == 1 && this.dKQ <= 1) {
                    mT(d.f.ds90);
                    this.dKK.setVisibility(0);
                    this.dKK.requestFocus();
                } else {
                    this.dKK.setVisibility(8);
                }
                this.dKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aBA();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.beA != null && this.beA.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dKE = new a();
                    this.dKE.setSelfExecute(true);
                    this.dKE.execute(new String[0]);
                    return;
                }
                this.dKE = null;
            } catch (OutOfMemoryError e) {
                aBB();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dKL = true;
                this.dKM = false;
                aBA();
            } catch (RuntimeException e2) {
                aBB();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dKL = true;
                this.dKM = false;
                aBA();
            }
        } catch (RuntimeException e3) {
            this.dKL = true;
            this.dKM = false;
            aBA();
        }
    }

    private void aBz() {
        Bitmap d;
        this.dKF = new ArrayList<>();
        this.dKG = new ArrayList<>();
        for (int i = 0; i < this.dKQ; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.h.guide_item_img);
            switch (this.dKP) {
                case 3:
                    d = d(imageView, this.dKO[i]);
                    break;
                default:
                    d = d(imageView, this.dKN[i]);
                    break;
            }
            if (d == null) {
                aBA();
                return;
            }
            this.dKR.add(d);
            this.dKG.add(imageView);
            this.dKF.add(relativeLayout);
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
    public void aBA() {
        if (this.beA != null && !this.beA.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            KU();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mT(int i) {
        w(this.dKK, i);
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
        aBB();
        if (this.dKE != null) {
            this.dKE.cancel(true);
            this.dKE = null;
        }
    }

    protected void aBB() {
        if (this.dKI != null) {
            this.dKI.setBackgroundDrawable(null);
        }
        if (this.dKG != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dKG.size()) {
                    break;
                }
                ImageView imageView = this.dKG.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dKR != null) {
            Iterator<Bitmap> it = this.dKR.iterator();
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
                aBA();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dKL) {
            if (!this.dKM || !NewUserGuideActivityConfig.canResponse()) {
                int i = TbadkCoreApplication.getCurrentAccount() == null ? 2 : 1;
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    if (!TbadkCoreApplication.isLogin()) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    } else {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                    }
                }
            } else {
                aBD();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_app_guide", false)) {
                h.gb().e(new Runnable() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkApplication.getInst().setUsed();
                    }
                });
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dKP == 3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dKL = false;
        }
    }

    public void Un() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dKU);
    }

    public void aBC() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.dKM = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aBD() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBE() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(d.l.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), d.g.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBF() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String an = an(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (an == null) {
                an = an(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + an + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(d.l.app_name)}, null);
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

    private String an(Context context, String str) {
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

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.aBF());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aBE();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dKF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dKF.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dKF.get(i), 0);
                if (i == GuideActivity.this.dKF.size() - 1) {
                    ((View) GuideActivity.this.dKF.get(i)).setOnClickListener(GuideActivity.this.dKS);
                }
                return GuideActivity.this.dKF.get(i);
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
