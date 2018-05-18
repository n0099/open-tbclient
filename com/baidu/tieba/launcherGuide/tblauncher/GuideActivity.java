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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
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
    private ArrayList<View> eui;
    private ArrayList<ImageView> euj;
    private b euk;
    private BaseViewPager eul;
    private IndicatorView eum;
    private View eun;
    private a euh = null;
    private String bru = null;
    private boolean euo = true;
    public boolean eup = true;
    private final int[] euq = {d.f.bg_startpage1, d.f.bg_startpage2, d.f.bg_startpage3};
    private int eur = 0;
    private final ArrayList<Bitmap> eus = new ArrayList<>();
    private final BaseViewPager.a akW = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void cZ(int i) {
            if (i == 0) {
                if (GuideActivity.this.eul != null) {
                    GuideActivity.this.eul.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.bru.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.MO();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener eut = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            GuideActivity.this.aKc();
        }
    };
    private final ViewPager.OnPageChangeListener euu = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.eur - 1) {
                GuideActivity.this.on(d.e.ds180);
                GuideActivity.this.eun.setVisibility(0);
                GuideActivity.this.eum.setVisibility(0);
            } else {
                GuideActivity.this.eun.setVisibility(8);
                GuideActivity.this.on(d.e.ds120);
                GuideActivity.this.eum.setVisibility(0);
            }
            if (GuideActivity.this.eun.getVisibility() == 0) {
                GuideActivity.this.eun.requestFocus();
            }
            GuideActivity.this.eum.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener euv = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.eup = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.eup = true;
                    return;
                }
                GuideActivity.this.eup = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.eup = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bru = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.bru = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bru)) {
            this.bru = "";
        }
        this.eur = this.euq.length;
        try {
            setContentView(d.i.guide_activity);
            acH();
            this.eup = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.eup) {
                aKe();
            }
            try {
                aKb();
                this.euk = new b();
                this.eul = (BaseViewPager) findViewById(d.g.guide_pager);
                this.eul.setAdapter(this.euk);
                this.eum = (IndicatorView) findViewById(d.g.guide_page_indicator);
                this.eum.setCount(this.eur);
                q(this.eum, d.e.ds60);
                this.eum.setSpacing(getResources().getDimensionPixelSize(d.e.ds6));
                this.eum.setSelector(getResources().getDrawable(d.f.icon_guide_pagecontrol_on));
                this.eum.setDrawable(getResources().getDrawable(d.f.icon_guide_pagecontrol_off));
                this.eum.setPosition(0.0f);
                if (this.eur <= 1) {
                    this.eum.setVisibility(4);
                } else {
                    this.eum.setVisibility(0);
                }
                this.eul.setOnScrollOutListener(this.akW);
                this.eul.setOnFlipOutListener(this.akW);
                this.eul.setOnPageChangeListener(this.euu);
                this.eun = findViewById(d.g.start_app);
                if (this.eur <= 1) {
                    on(d.e.ds90);
                    this.eun.setVisibility(0);
                    this.eun.requestFocus();
                } else {
                    this.eun.setVisibility(8);
                }
                this.eun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        GuideActivity.this.aKc();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.bru != null && this.bru.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.euh = new a();
                    this.euh.setSelfExecute(true);
                    this.euh.execute(new String[0]);
                    return;
                }
                this.euh = null;
            } catch (OutOfMemoryError e) {
                aKd();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.euo = true;
                this.eup = false;
                aKc();
            } catch (RuntimeException e2) {
                aKd();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.euo = true;
                this.eup = false;
                aKc();
            }
        } catch (RuntimeException e3) {
            this.euo = true;
            this.eup = false;
            aKc();
        }
    }

    private void aKb() {
        this.eui = new ArrayList<>();
        this.euj = new ArrayList<>();
        for (int i = 0; i < this.eur; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.g.guide_item_img);
            Bitmap d = d(imageView, this.euq[i]);
            if (d == null) {
                aKc();
                return;
            }
            this.eus.add(d);
            this.euj.add(imageView);
            this.eui.add(relativeLayout);
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
    public void aKc() {
        if (this.bru != null && !this.bru.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            MO();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
        q(this.eun, i);
    }

    private void q(View view2, int i) {
        if (view2 != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.bottomMargin = dimensionPixelSize;
                view2.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aKd();
        if (this.euh != null) {
            this.euh.cancel(true);
            this.euh = null;
        }
    }

    protected void aKd() {
        if (this.eul != null) {
            this.eul.setBackgroundDrawable(null);
        }
        if (this.euj != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.euj.size()) {
                    break;
                }
                ImageView imageView = this.euj.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.eus != null) {
            Iterator<Bitmap> it = this.eus.iterator();
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
                aKc();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MO() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.euo) {
            if (!this.eup || !NewUserGuideActivityConfig.canResponse()) {
                int i = TbadkCoreApplication.getCurrentAccount() == null ? 2 : 1;
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    if (!TbadkCoreApplication.isLogin()) {
                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    } else {
                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                    }
                }
            } else {
                aKf();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                h.fx().c(new Runnable() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkApplication.getInst().setUsed();
                    }
                });
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            finish();
            this.euo = false;
        }
    }

    public void acH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.euv);
    }

    public void aKe() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.eup = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aKf() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKg() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(d.k.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), d.f.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKh() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String ag = ag(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (ag == null) {
                ag = ag(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + ag + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(d.k.app_name)}, null);
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

    private String ag(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.aKh());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aKg();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.eui.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view2, int i) {
            if (i < GuideActivity.this.eui.size()) {
                ((ViewPager) view2).addView((View) GuideActivity.this.eui.get(i), 0);
                if (i == GuideActivity.this.eui.size() - 1) {
                    ((View) GuideActivity.this.eui.get(i)).setOnClickListener(GuideActivity.this.eut);
                }
                return GuideActivity.this.eui.get(i);
            }
            View view3 = new View(GuideActivity.this.getPageContext().getPageActivity());
            view3.setBackgroundColor(-1);
            ((ViewPager) view2).addView(view3, 0);
            return view3;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(View view2, int i, Object obj) {
            ((ViewPager) view2).removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            return view2 == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }
}
