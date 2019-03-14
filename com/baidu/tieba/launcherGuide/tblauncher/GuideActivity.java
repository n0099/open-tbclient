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
/* loaded from: classes5.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> gEl;
    private ArrayList<ImageView> gEm;
    private b gEn;
    private BaseViewPager gEo;
    private IndicatorView gEp;
    private View gEq;
    private a gEk = null;
    private String dku = null;
    private boolean gEr = true;
    public boolean gEs = true;
    private final int[] gEt = {d.f.bg_startpage_1, d.f.bg_startpage_2, d.f.bg_startpage_3, d.f.bg_startpage_4};
    private int gEu = 0;
    private final ArrayList<Bitmap> gEv = new ArrayList<>();
    private final BaseViewPager.a bOm = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void hF(int i) {
            if (i == 0) {
                if (GuideActivity.this.gEo != null) {
                    GuideActivity.this.gEo.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.dku.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.awt();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener gEw = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bzm();
        }
    };
    private final ViewPager.OnPageChangeListener gEx = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.gEu - 1) {
                GuideActivity.this.uJ(d.e.ds170);
                GuideActivity.this.gEq.setVisibility(0);
                GuideActivity.this.gEp.setVisibility(0);
            } else {
                GuideActivity.this.gEq.setVisibility(8);
                GuideActivity.this.uJ(d.e.ds120);
                GuideActivity.this.gEp.setVisibility(0);
            }
            if (GuideActivity.this.gEq.getVisibility() == 0) {
                GuideActivity.this.gEq.requestFocus();
            }
            GuideActivity.this.gEp.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener gEy = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.gEs = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.gEs = true;
                    return;
                }
                GuideActivity.this.gEs = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.gEs = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.dku = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.dku = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.dku)) {
            this.dku = "";
        }
        this.gEu = this.gEt.length;
        try {
            setContentView(d.h.guide_activity);
            aOQ();
            this.gEs = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.gEs) {
                bzo();
            }
            try {
                bzl();
                this.gEn = new b();
                this.gEo = (BaseViewPager) findViewById(d.g.guide_pager);
                this.gEo.setAdapter(this.gEn);
                this.gEp = (IndicatorView) findViewById(d.g.guide_page_indicator);
                this.gEp.setCount(this.gEu);
                z(this.gEp, d.e.ds70);
                this.gEp.setSpacing(getResources().getDimensionPixelSize(d.e.ds10));
                this.gEp.setSelector(getResources().getDrawable(d.f.icon_guide_pagecontrol_on));
                this.gEp.setDrawable(getResources().getDrawable(d.f.icon_guide_pagecontrol_off));
                this.gEp.setPosition(0.0f);
                if (this.gEu <= 1) {
                    this.gEp.setVisibility(4);
                } else {
                    this.gEp.setVisibility(0);
                }
                this.gEo.setOnScrollOutListener(this.bOm);
                this.gEo.setOnFlipOutListener(this.bOm);
                this.gEo.setOnPageChangeListener(this.gEx);
                this.gEq = findViewById(d.g.start_app);
                if (this.gEu <= 1) {
                    uJ(d.e.ds90);
                    this.gEq.setVisibility(0);
                    this.gEq.requestFocus();
                } else {
                    this.gEq.setVisibility(8);
                }
                this.gEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.bzm();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.dku != null && this.dku.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.gEk = new a();
                    this.gEk.setSelfExecute(true);
                    this.gEk.execute(new String[0]);
                    return;
                }
                this.gEk = null;
            } catch (OutOfMemoryError e) {
                bzn();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.gEr = true;
                this.gEs = false;
                bzm();
            } catch (RuntimeException e2) {
                bzn();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.gEr = true;
                this.gEs = false;
                bzm();
            }
        } catch (RuntimeException e3) {
            this.gEr = true;
            this.gEs = false;
            bzm();
        }
    }

    private void bzl() {
        this.gEl = new ArrayList<>();
        this.gEm = new ArrayList<>();
        for (int i = 0; i < this.gEu; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.g.guide_item_img);
            imageView.setBackgroundResource(this.gEt[i]);
            Bitmap e = e(imageView, this.gEt[i]);
            if (e == null) {
                bzm();
                return;
            }
            this.gEv.add(e);
            this.gEm.add(imageView);
            this.gEl.add(relativeLayout);
        }
    }

    private Bitmap e(ImageView imageView, int i) {
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
    public void bzm() {
        if (this.dku != null && !this.dku.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            awt();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uJ(int i) {
        z(this.gEq, i);
    }

    private void z(View view, int i) {
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
        bzn();
        if (this.gEk != null) {
            this.gEk.cancel(true);
            this.gEk = null;
        }
    }

    protected void bzn() {
        if (this.gEo != null) {
            this.gEo.setBackgroundDrawable(null);
        }
        if (this.gEm != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gEm.size()) {
                    break;
                }
                ImageView imageView = this.gEm.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.gEv != null) {
            Iterator<Bitmap> it = this.gEv.iterator();
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
                bzm();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awt() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.gEr) {
            if (!this.gEs || !NewUserGuideActivityConfig.canResponse()) {
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
                bzp();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            finish();
            this.gEr = false;
        }
    }

    public void aOQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.gEy);
    }

    public void bzo() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.gEs = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void bzp() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MX() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(d.j.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), d.f.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzq() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aO = aO(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aO == null) {
                aO = aO(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aO + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(d.j.app_name)}, null);
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

    private String aO(Context context, String str) {
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

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.bzq());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.MX();
            }
        }
    }

    /* loaded from: classes5.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.gEl.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.gEl.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.gEl.get(i), 0);
                if (i == GuideActivity.this.gEl.size() - 1) {
                    ((View) GuideActivity.this.gEl.get(i)).setOnClickListener(GuideActivity.this.gEw);
                }
                return GuideActivity.this.gEl.get(i);
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
