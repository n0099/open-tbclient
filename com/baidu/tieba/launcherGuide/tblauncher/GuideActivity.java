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
    private ArrayList<View> gDZ;
    private ArrayList<ImageView> gEa;
    private b gEb;
    private BaseViewPager gEc;
    private IndicatorView gEd;
    private View gEe;
    private a gDY = null;
    private String dkx = null;
    private boolean gEf = true;
    public boolean gEg = true;
    private final int[] gEh = {d.f.bg_startpage_1, d.f.bg_startpage_2, d.f.bg_startpage_3, d.f.bg_startpage_4};
    private int gEi = 0;
    private final ArrayList<Bitmap> gEj = new ArrayList<>();
    private final BaseViewPager.a bOo = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void hE(int i) {
            if (i == 0) {
                if (GuideActivity.this.gEc != null) {
                    GuideActivity.this.gEc.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.dkx.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.awq();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener gEk = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bzj();
        }
    };
    private final ViewPager.OnPageChangeListener gEl = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.gEi - 1) {
                GuideActivity.this.uF(d.e.ds170);
                GuideActivity.this.gEe.setVisibility(0);
                GuideActivity.this.gEd.setVisibility(0);
            } else {
                GuideActivity.this.gEe.setVisibility(8);
                GuideActivity.this.uF(d.e.ds120);
                GuideActivity.this.gEd.setVisibility(0);
            }
            if (GuideActivity.this.gEe.getVisibility() == 0) {
                GuideActivity.this.gEe.requestFocus();
            }
            GuideActivity.this.gEd.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener gEm = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.gEg = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.gEg = true;
                    return;
                }
                GuideActivity.this.gEg = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.gEg = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.dkx = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.dkx = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.dkx)) {
            this.dkx = "";
        }
        this.gEi = this.gEh.length;
        try {
            setContentView(d.h.guide_activity);
            aOL();
            this.gEg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.gEg) {
                bzl();
            }
            try {
                bzi();
                this.gEb = new b();
                this.gEc = (BaseViewPager) findViewById(d.g.guide_pager);
                this.gEc.setAdapter(this.gEb);
                this.gEd = (IndicatorView) findViewById(d.g.guide_page_indicator);
                this.gEd.setCount(this.gEi);
                z(this.gEd, d.e.ds70);
                this.gEd.setSpacing(getResources().getDimensionPixelSize(d.e.ds10));
                this.gEd.setSelector(getResources().getDrawable(d.f.icon_guide_pagecontrol_on));
                this.gEd.setDrawable(getResources().getDrawable(d.f.icon_guide_pagecontrol_off));
                this.gEd.setPosition(0.0f);
                if (this.gEi <= 1) {
                    this.gEd.setVisibility(4);
                } else {
                    this.gEd.setVisibility(0);
                }
                this.gEc.setOnScrollOutListener(this.bOo);
                this.gEc.setOnFlipOutListener(this.bOo);
                this.gEc.setOnPageChangeListener(this.gEl);
                this.gEe = findViewById(d.g.start_app);
                if (this.gEi <= 1) {
                    uF(d.e.ds90);
                    this.gEe.setVisibility(0);
                    this.gEe.requestFocus();
                } else {
                    this.gEe.setVisibility(8);
                }
                this.gEe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.bzj();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.dkx != null && this.dkx.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.gDY = new a();
                    this.gDY.setSelfExecute(true);
                    this.gDY.execute(new String[0]);
                    return;
                }
                this.gDY = null;
            } catch (OutOfMemoryError e) {
                bzk();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.gEf = true;
                this.gEg = false;
                bzj();
            } catch (RuntimeException e2) {
                bzk();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.gEf = true;
                this.gEg = false;
                bzj();
            }
        } catch (RuntimeException e3) {
            this.gEf = true;
            this.gEg = false;
            bzj();
        }
    }

    private void bzi() {
        this.gDZ = new ArrayList<>();
        this.gEa = new ArrayList<>();
        for (int i = 0; i < this.gEi; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.g.guide_item_img);
            imageView.setBackgroundResource(this.gEh[i]);
            Bitmap e = e(imageView, this.gEh[i]);
            if (e == null) {
                bzj();
                return;
            }
            this.gEj.add(e);
            this.gEa.add(imageView);
            this.gDZ.add(relativeLayout);
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
        if (this.dkx != null && !this.dkx.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            awq();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(int i) {
        z(this.gEe, i);
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
        if (this.gDY != null) {
            this.gDY.cancel(true);
            this.gDY = null;
        }
    }

    protected void bzk() {
        if (this.gEc != null) {
            this.gEc.setBackgroundDrawable(null);
        }
        if (this.gEa != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gEa.size()) {
                    break;
                }
                ImageView imageView = this.gEa.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.gEj != null) {
            Iterator<Bitmap> it = this.gEj.iterator();
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
        if (this.gEf) {
            if (!this.gEg || !NewUserGuideActivityConfig.canResponse()) {
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
            this.gEf = false;
        }
    }

    public void aOL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.gEm);
    }

    public void bzl() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.gEg = false;
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
            return GuideActivity.this.gDZ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.gDZ.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.gDZ.get(i), 0);
                if (i == GuideActivity.this.gDZ.size() - 1) {
                    ((View) GuideActivity.this.gDZ.get(i)).setOnClickListener(GuideActivity.this.gEk);
                }
                return GuideActivity.this.gDZ.get(i);
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
