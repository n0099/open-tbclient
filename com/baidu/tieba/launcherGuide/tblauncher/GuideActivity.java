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
    private ArrayList<View> dMB;
    private ArrayList<ImageView> dMC;
    private b dMD;
    private BaseViewPager dME;
    private IndicatorView dMF;
    private View dMG;
    private a dMA = null;
    private String beB = null;
    private boolean dMH = true;
    public boolean dMI = true;
    private final int[] dMJ = {d.g.bg_startpage1, d.g.bg_startpage2, d.g.bg_startpage3, d.g.bg_startpage4};
    private final int[] dMK = {d.g.bg_app_startpage1, d.g.bg_app_startpage2};
    private int dML = 1;
    private int dMM = 0;
    private final ArrayList<Bitmap> dMN = new ArrayList<>();
    private final BaseViewPager.a akg = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void db(int i) {
            if (i == 0) {
                if (GuideActivity.this.dME != null) {
                    GuideActivity.this.dME.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.beB.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.KU();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener dMO = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aCh();
        }
    };
    private final ViewPager.OnPageChangeListener dMP = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.dMM - 1) {
                switch (GuideActivity.this.dML) {
                    case 1:
                        GuideActivity.this.nd(d.f.ds154);
                        GuideActivity.this.dMG.setVisibility(0);
                        GuideActivity.this.dMF.setVisibility(0);
                        break;
                    case 2:
                    default:
                        GuideActivity.this.dMG.setVisibility(8);
                        break;
                    case 3:
                        GuideActivity.this.dMG.setVisibility(8);
                        break;
                }
            } else {
                GuideActivity.this.dMG.setVisibility(8);
                GuideActivity.this.nd(d.f.ds120);
                switch (GuideActivity.this.dML) {
                    case 1:
                        GuideActivity.this.dMF.setVisibility(0);
                        break;
                    case 3:
                        GuideActivity.this.dMF.setVisibility(0);
                        break;
                }
            }
            if (GuideActivity.this.dMG.getVisibility() == 0) {
                GuideActivity.this.dMG.requestFocus();
            }
            GuideActivity.this.dMF.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener dMQ = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.dMI = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.dMI = true;
                    return;
                }
                GuideActivity.this.dMI = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.dMI = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.beB = bundle.getString("from_page");
            this.dML = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.beB = getIntent().getStringExtra("from_page");
            this.dML = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.beB)) {
            this.beB = "";
        }
        switch (this.dML) {
            case 3:
                this.dMM = this.dMK.length;
                break;
            default:
                this.dMM = this.dMJ.length;
                break;
        }
        try {
            setContentView(d.j.guide_activity);
            UJ();
            this.dMI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.dMI) {
                aCj();
            }
            try {
                aCg();
                this.dMD = new b();
                this.dME = (BaseViewPager) findViewById(d.h.guide_pager);
                this.dME.setAdapter(this.dMD);
                this.dMF = (IndicatorView) findViewById(d.h.guide_page_indicator);
                this.dMF.setCount(this.dMM);
                w(this.dMF, d.f.ds40);
                if (this.dML == 3) {
                    this.dMF.setSelector(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_on));
                    this.dMF.setDrawable(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_off));
                } else {
                    w(this.dMF, d.f.ds70);
                    this.dMF.setSpacing(getResources().getDimensionPixelSize(d.f.ds6));
                    this.dMF.setSelector(getResources().getDrawable(d.g.icon_guide_pagecontrol_on));
                    this.dMF.setDrawable(getResources().getDrawable(d.g.icon_guide_pagecontrol_off));
                }
                this.dMF.setPosition(0.0f);
                if (this.dMM <= 1) {
                    this.dMF.setVisibility(4);
                } else {
                    this.dMF.setVisibility(0);
                }
                this.dME.setOnScrollOutListener(this.akg);
                this.dME.setOnFlipOutListener(this.akg);
                this.dME.setOnPageChangeListener(this.dMP);
                this.dMG = findViewById(d.h.start_app);
                if (this.dML == 1 && this.dMM <= 1) {
                    nd(d.f.ds90);
                    this.dMG.setVisibility(0);
                    this.dMG.requestFocus();
                } else {
                    this.dMG.setVisibility(8);
                }
                this.dMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aCh();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.beB != null && this.beB.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dMA = new a();
                    this.dMA.setSelfExecute(true);
                    this.dMA.execute(new String[0]);
                    return;
                }
                this.dMA = null;
            } catch (OutOfMemoryError e) {
                aCi();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dMH = true;
                this.dMI = false;
                aCh();
            } catch (RuntimeException e2) {
                aCi();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dMH = true;
                this.dMI = false;
                aCh();
            }
        } catch (RuntimeException e3) {
            this.dMH = true;
            this.dMI = false;
            aCh();
        }
    }

    private void aCg() {
        Bitmap d;
        this.dMB = new ArrayList<>();
        this.dMC = new ArrayList<>();
        for (int i = 0; i < this.dMM; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.h.guide_item_img);
            switch (this.dML) {
                case 3:
                    d = d(imageView, this.dMK[i]);
                    break;
                default:
                    d = d(imageView, this.dMJ[i]);
                    break;
            }
            if (d == null) {
                aCh();
                return;
            }
            this.dMN.add(d);
            this.dMC.add(imageView);
            this.dMB.add(relativeLayout);
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
    public void aCh() {
        if (this.beB != null && !this.beB.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            KU();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(int i) {
        w(this.dMG, i);
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
        aCi();
        if (this.dMA != null) {
            this.dMA.cancel(true);
            this.dMA = null;
        }
    }

    protected void aCi() {
        if (this.dME != null) {
            this.dME.setBackgroundDrawable(null);
        }
        if (this.dMC != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dMC.size()) {
                    break;
                }
                ImageView imageView = this.dMC.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dMN != null) {
            Iterator<Bitmap> it = this.dMN.iterator();
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
                aCh();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dMH) {
            if (!this.dMI || !NewUserGuideActivityConfig.canResponse()) {
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
                aCk();
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
            if (this.dML == 3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dMH = false;
        }
    }

    public void UJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dMQ);
    }

    public void aCj() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.dMI = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aCk() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCl() {
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
    public boolean aCm() {
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
            return Boolean.valueOf(GuideActivity.this.aCm());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aCl();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dMB.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dMB.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dMB.get(i), 0);
                if (i == GuideActivity.this.dMB.size() - 1) {
                    ((View) GuideActivity.this.dMB.get(i)).setOnClickListener(GuideActivity.this.dMO);
                }
                return GuideActivity.this.dMB.get(i);
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
