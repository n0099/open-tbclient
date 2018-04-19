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
    private ArrayList<View> etd;
    private ArrayList<ImageView> ete;
    private b etf;
    private BaseViewPager etg;
    private IndicatorView eth;
    private View eti;
    private a etb = null;
    private String brf = null;
    private boolean etj = true;
    public boolean etk = true;
    private final int[] etl = {d.f.bg_startpage1, d.f.bg_startpage2, d.f.bg_startpage3};
    private int etm = 0;
    private final ArrayList<Bitmap> etn = new ArrayList<>();
    private final BaseViewPager.a akW = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void cY(int i) {
            if (i == 0) {
                if (GuideActivity.this.etg != null) {
                    GuideActivity.this.etg.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.brf.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.MQ();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener eto = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            GuideActivity.this.aKd();
        }
    };
    private final ViewPager.OnPageChangeListener etp = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.etm - 1) {
                GuideActivity.this.oo(d.e.ds180);
                GuideActivity.this.eti.setVisibility(0);
                GuideActivity.this.eth.setVisibility(0);
            } else {
                GuideActivity.this.eti.setVisibility(8);
                GuideActivity.this.oo(d.e.ds120);
                GuideActivity.this.eth.setVisibility(0);
            }
            if (GuideActivity.this.eti.getVisibility() == 0) {
                GuideActivity.this.eti.requestFocus();
            }
            GuideActivity.this.eth.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener etq = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.etk = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.etk = true;
                    return;
                }
                GuideActivity.this.etk = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.etk = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.brf = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.brf = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.brf)) {
            this.brf = "";
        }
        this.etm = this.etl.length;
        try {
            setContentView(d.i.guide_activity);
            acH();
            this.etk = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.etk) {
                aKf();
            }
            try {
                aKc();
                this.etf = new b();
                this.etg = (BaseViewPager) findViewById(d.g.guide_pager);
                this.etg.setAdapter(this.etf);
                this.eth = (IndicatorView) findViewById(d.g.guide_page_indicator);
                this.eth.setCount(this.etm);
                q(this.eth, d.e.ds60);
                this.eth.setSpacing(getResources().getDimensionPixelSize(d.e.ds6));
                this.eth.setSelector(getResources().getDrawable(d.f.icon_guide_pagecontrol_on));
                this.eth.setDrawable(getResources().getDrawable(d.f.icon_guide_pagecontrol_off));
                this.eth.setPosition(0.0f);
                if (this.etm <= 1) {
                    this.eth.setVisibility(4);
                } else {
                    this.eth.setVisibility(0);
                }
                this.etg.setOnScrollOutListener(this.akW);
                this.etg.setOnFlipOutListener(this.akW);
                this.etg.setOnPageChangeListener(this.etp);
                this.eti = findViewById(d.g.start_app);
                if (this.etm <= 1) {
                    oo(d.e.ds90);
                    this.eti.setVisibility(0);
                    this.eti.requestFocus();
                } else {
                    this.eti.setVisibility(8);
                }
                this.eti.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        GuideActivity.this.aKd();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.brf != null && this.brf.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.etb = new a();
                    this.etb.setSelfExecute(true);
                    this.etb.execute(new String[0]);
                    return;
                }
                this.etb = null;
            } catch (OutOfMemoryError e) {
                aKe();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.etj = true;
                this.etk = false;
                aKd();
            } catch (RuntimeException e2) {
                aKe();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.etj = true;
                this.etk = false;
                aKd();
            }
        } catch (RuntimeException e3) {
            this.etj = true;
            this.etk = false;
            aKd();
        }
    }

    private void aKc() {
        this.etd = new ArrayList<>();
        this.ete = new ArrayList<>();
        for (int i = 0; i < this.etm; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.g.guide_item_img);
            Bitmap d = d(imageView, this.etl[i]);
            if (d == null) {
                aKd();
                return;
            }
            this.etn.add(d);
            this.ete.add(imageView);
            this.etd.add(relativeLayout);
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
    public void aKd() {
        if (this.brf != null && !this.brf.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            MQ();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(int i) {
        q(this.eti, i);
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
        aKe();
        if (this.etb != null) {
            this.etb.cancel(true);
            this.etb = null;
        }
    }

    protected void aKe() {
        if (this.etg != null) {
            this.etg.setBackgroundDrawable(null);
        }
        if (this.ete != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ete.size()) {
                    break;
                }
                ImageView imageView = this.ete.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.etn != null) {
            Iterator<Bitmap> it = this.etn.iterator();
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
                aKd();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MQ() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.etj) {
            if (!this.etk || !NewUserGuideActivityConfig.canResponse()) {
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
                aKg();
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
            this.etj = false;
        }
    }

    public void acH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.etq);
    }

    public void aKf() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.etk = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aKg() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
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
    public boolean aKi() {
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
            return Boolean.valueOf(GuideActivity.this.aKi());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aKh();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.etd.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view2, int i) {
            if (i < GuideActivity.this.etd.size()) {
                ((ViewPager) view2).addView((View) GuideActivity.this.etd.get(i), 0);
                if (i == GuideActivity.this.etd.size() - 1) {
                    ((View) GuideActivity.this.etd.get(i)).setOnClickListener(GuideActivity.this.eto);
                }
                return GuideActivity.this.etd.get(i);
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
