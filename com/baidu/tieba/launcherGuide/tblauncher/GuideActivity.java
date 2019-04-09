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
    private ArrayList<View> gEa;
    private ArrayList<ImageView> gEb;
    private b gEc;
    private BaseViewPager gEd;
    private IndicatorView gEe;
    private View gEf;
    private a gDZ = null;
    private String dky = null;
    private boolean gEg = true;
    public boolean gEh = true;
    private final int[] gEi = {d.f.bg_startpage_1, d.f.bg_startpage_2, d.f.bg_startpage_3, d.f.bg_startpage_4};
    private int gEj = 0;
    private final ArrayList<Bitmap> gEk = new ArrayList<>();
    private final BaseViewPager.a bOp = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void hE(int i) {
            if (i == 0) {
                if (GuideActivity.this.gEd != null) {
                    GuideActivity.this.gEd.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.dky.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.awq();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener gEl = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bzj();
        }
    };
    private final ViewPager.OnPageChangeListener gEm = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.gEj - 1) {
                GuideActivity.this.uF(d.e.ds170);
                GuideActivity.this.gEf.setVisibility(0);
                GuideActivity.this.gEe.setVisibility(0);
            } else {
                GuideActivity.this.gEf.setVisibility(8);
                GuideActivity.this.uF(d.e.ds120);
                GuideActivity.this.gEe.setVisibility(0);
            }
            if (GuideActivity.this.gEf.getVisibility() == 0) {
                GuideActivity.this.gEf.requestFocus();
            }
            GuideActivity.this.gEe.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener gEn = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.gEh = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.gEh = true;
                    return;
                }
                GuideActivity.this.gEh = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.gEh = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.dky = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.dky = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.dky)) {
            this.dky = "";
        }
        this.gEj = this.gEi.length;
        try {
            setContentView(d.h.guide_activity);
            aOL();
            this.gEh = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.gEh) {
                bzl();
            }
            try {
                bzi();
                this.gEc = new b();
                this.gEd = (BaseViewPager) findViewById(d.g.guide_pager);
                this.gEd.setAdapter(this.gEc);
                this.gEe = (IndicatorView) findViewById(d.g.guide_page_indicator);
                this.gEe.setCount(this.gEj);
                z(this.gEe, d.e.ds70);
                this.gEe.setSpacing(getResources().getDimensionPixelSize(d.e.ds10));
                this.gEe.setSelector(getResources().getDrawable(d.f.icon_guide_pagecontrol_on));
                this.gEe.setDrawable(getResources().getDrawable(d.f.icon_guide_pagecontrol_off));
                this.gEe.setPosition(0.0f);
                if (this.gEj <= 1) {
                    this.gEe.setVisibility(4);
                } else {
                    this.gEe.setVisibility(0);
                }
                this.gEd.setOnScrollOutListener(this.bOp);
                this.gEd.setOnFlipOutListener(this.bOp);
                this.gEd.setOnPageChangeListener(this.gEm);
                this.gEf = findViewById(d.g.start_app);
                if (this.gEj <= 1) {
                    uF(d.e.ds90);
                    this.gEf.setVisibility(0);
                    this.gEf.requestFocus();
                } else {
                    this.gEf.setVisibility(8);
                }
                this.gEf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.bzj();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.dky != null && this.dky.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.gDZ = new a();
                    this.gDZ.setSelfExecute(true);
                    this.gDZ.execute(new String[0]);
                    return;
                }
                this.gDZ = null;
            } catch (OutOfMemoryError e) {
                bzk();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.gEg = true;
                this.gEh = false;
                bzj();
            } catch (RuntimeException e2) {
                bzk();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.gEg = true;
                this.gEh = false;
                bzj();
            }
        } catch (RuntimeException e3) {
            this.gEg = true;
            this.gEh = false;
            bzj();
        }
    }

    private void bzi() {
        this.gEa = new ArrayList<>();
        this.gEb = new ArrayList<>();
        for (int i = 0; i < this.gEj; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.g.guide_item_img);
            imageView.setBackgroundResource(this.gEi[i]);
            Bitmap e = e(imageView, this.gEi[i]);
            if (e == null) {
                bzj();
                return;
            }
            this.gEk.add(e);
            this.gEb.add(imageView);
            this.gEa.add(relativeLayout);
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
    public void bzj() {
        if (this.dky != null && !this.dky.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            awq();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(int i) {
        z(this.gEf, i);
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
        bzk();
        if (this.gDZ != null) {
            this.gDZ.cancel(true);
            this.gDZ = null;
        }
    }

    protected void bzk() {
        if (this.gEd != null) {
            this.gEd.setBackgroundDrawable(null);
        }
        if (this.gEb != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gEb.size()) {
                    break;
                }
                ImageView imageView = this.gEb.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.gEk != null) {
            Iterator<Bitmap> it = this.gEk.iterator();
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
                bzj();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awq() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.gEg) {
            if (!this.gEh || !NewUserGuideActivityConfig.canResponse()) {
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
                bzm();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            finish();
            this.gEg = false;
        }
    }

    public void aOL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.gEn);
    }

    public void bzl() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.gEh = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void bzm() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MV() {
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
    public boolean bzn() {
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
            return Boolean.valueOf(GuideActivity.this.bzn());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.MV();
            }
        }
    }

    /* loaded from: classes5.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.gEa.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.gEa.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.gEa.get(i), 0);
                if (i == GuideActivity.this.gEa.size() - 1) {
                    ((View) GuideActivity.this.gEa.get(i)).setOnClickListener(GuideActivity.this.gEl);
                }
                return GuideActivity.this.gEa.get(i);
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
