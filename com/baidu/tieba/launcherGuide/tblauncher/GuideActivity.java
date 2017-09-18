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
    private ArrayList<View> dUi;
    private ArrayList<ImageView> dUj;
    private b dUk;
    private BaseViewPager dUl;
    private IndicatorView dUm;
    private View dUn;
    private a dUh = null;
    private String bew = null;
    private boolean dUo = true;
    public boolean dUp = true;
    private final int[] dUq = {d.g.bg_startpage1, d.g.bg_startpage2, d.g.bg_startpage3, d.g.bg_startpage4};
    private final int[] dUr = {d.g.bg_app_startpage1, d.g.bg_app_startpage2};
    private int dUs = 1;
    private int dUt = 0;
    private final ArrayList<Bitmap> dUu = new ArrayList<>();
    private final BaseViewPager.a ajz = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void dc(int i) {
            if (i == 0) {
                if (GuideActivity.this.dUl != null) {
                    GuideActivity.this.dUl.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.bew.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.Le();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener dUv = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aEc();
        }
    };
    private final ViewPager.OnPageChangeListener dUw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.dUt - 1) {
                switch (GuideActivity.this.dUs) {
                    case 1:
                        GuideActivity.this.ny(d.f.ds154);
                        GuideActivity.this.dUn.setVisibility(0);
                        GuideActivity.this.dUm.setVisibility(0);
                        break;
                    case 2:
                    default:
                        GuideActivity.this.dUn.setVisibility(8);
                        break;
                    case 3:
                        GuideActivity.this.dUn.setVisibility(8);
                        break;
                }
            } else {
                GuideActivity.this.dUn.setVisibility(8);
                GuideActivity.this.ny(d.f.ds120);
                switch (GuideActivity.this.dUs) {
                    case 1:
                        GuideActivity.this.dUm.setVisibility(0);
                        break;
                    case 3:
                        GuideActivity.this.dUm.setVisibility(0);
                        break;
                }
            }
            if (GuideActivity.this.dUn.getVisibility() == 0) {
                GuideActivity.this.dUn.requestFocus();
            }
            GuideActivity.this.dUm.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener dUx = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.dUp = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.dUp = true;
                    return;
                }
                GuideActivity.this.dUp = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.dUp = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bew = bundle.getString("from_page");
            this.dUs = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.bew = getIntent().getStringExtra("from_page");
            this.dUs = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.bew)) {
            this.bew = "";
        }
        switch (this.dUs) {
            case 3:
                this.dUt = this.dUr.length;
                break;
            default:
                this.dUt = this.dUq.length;
                break;
        }
        try {
            setContentView(d.j.guide_activity);
            VE();
            this.dUp = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.dUp) {
                aEe();
            }
            try {
                aEb();
                this.dUk = new b();
                this.dUl = (BaseViewPager) findViewById(d.h.guide_pager);
                this.dUl.setAdapter(this.dUk);
                this.dUm = (IndicatorView) findViewById(d.h.guide_page_indicator);
                this.dUm.setCount(this.dUt);
                x(this.dUm, d.f.ds40);
                if (this.dUs == 3) {
                    this.dUm.setSelector(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_on));
                    this.dUm.setDrawable(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_off));
                } else {
                    x(this.dUm, d.f.ds70);
                    this.dUm.setSpacing(getResources().getDimensionPixelSize(d.f.ds6));
                    this.dUm.setSelector(getResources().getDrawable(d.g.icon_guide_pagecontrol_on));
                    this.dUm.setDrawable(getResources().getDrawable(d.g.icon_guide_pagecontrol_off));
                }
                this.dUm.setPosition(0.0f);
                if (this.dUt <= 1) {
                    this.dUm.setVisibility(4);
                } else {
                    this.dUm.setVisibility(0);
                }
                this.dUl.setOnScrollOutListener(this.ajz);
                this.dUl.setOnFlipOutListener(this.ajz);
                this.dUl.setOnPageChangeListener(this.dUw);
                this.dUn = findViewById(d.h.start_app);
                if (this.dUs == 1 && this.dUt <= 1) {
                    ny(d.f.ds90);
                    this.dUn.setVisibility(0);
                    this.dUn.requestFocus();
                } else {
                    this.dUn.setVisibility(8);
                }
                this.dUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aEc();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.bew != null && this.bew.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dUh = new a();
                    this.dUh.setSelfExecute(true);
                    this.dUh.execute(new String[0]);
                    return;
                }
                this.dUh = null;
            } catch (OutOfMemoryError e) {
                aEd();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dUo = true;
                this.dUp = false;
                aEc();
            } catch (RuntimeException e2) {
                aEd();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dUo = true;
                this.dUp = false;
                aEc();
            }
        } catch (RuntimeException e3) {
            this.dUo = true;
            this.dUp = false;
            aEc();
        }
    }

    private void aEb() {
        Bitmap d;
        this.dUi = new ArrayList<>();
        this.dUj = new ArrayList<>();
        for (int i = 0; i < this.dUt; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.h.guide_item_img);
            switch (this.dUs) {
                case 3:
                    d = d(imageView, this.dUr[i]);
                    break;
                default:
                    d = d(imageView, this.dUq[i]);
                    break;
            }
            if (d == null) {
                aEc();
                return;
            }
            this.dUu.add(d);
            this.dUj.add(imageView);
            this.dUi.add(relativeLayout);
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
    public void aEc() {
        if (this.bew != null && !this.bew.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Le();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(int i) {
        x(this.dUn, i);
    }

    private void x(View view, int i) {
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
        aEd();
        if (this.dUh != null) {
            this.dUh.cancel(true);
            this.dUh = null;
        }
    }

    protected void aEd() {
        if (this.dUl != null) {
            this.dUl.setBackgroundDrawable(null);
        }
        if (this.dUj != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dUj.size()) {
                    break;
                }
                ImageView imageView = this.dUj.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dUu != null) {
            Iterator<Bitmap> it = this.dUu.iterator();
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
                aEc();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dUo) {
            if (!this.dUp || !NewUserGuideActivityConfig.canResponse()) {
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
                aEf();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_app_guide", false)) {
                h.fR().c(new Runnable() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkApplication.getInst().setUsed();
                    }
                });
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dUs == 3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dUo = false;
        }
    }

    public void VE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dUx);
    }

    public void aEe() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.dUp = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aEf() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEg() {
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
    public boolean aEh() {
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
            return Boolean.valueOf(GuideActivity.this.aEh());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aEg();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dUi.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dUi.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dUi.get(i), 0);
                if (i == GuideActivity.this.dUi.size() - 1) {
                    ((View) GuideActivity.this.dUi.get(i)).setOnClickListener(GuideActivity.this.dUv);
                }
                return GuideActivity.this.dUi.get(i);
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
