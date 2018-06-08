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
    private ArrayList<ImageView> eFA;
    private b eFB;
    private BaseViewPager eFC;
    private IndicatorView eFD;
    private View eFE;
    private ArrayList<View> eFz;
    private a eFy = null;
    private String bzz = null;
    private boolean eFF = true;
    public boolean eFG = true;
    private final int[] eFH = {d.f.bg_startpage_1, d.f.bg_startpage_2, d.f.bg_startpage_3, d.f.bg_startpage_4};
    private int eFI = 0;
    private final ArrayList<Bitmap> eFJ = new ArrayList<>();
    private final BaseViewPager.a ate = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void db(int i) {
            if (i == 0) {
                if (GuideActivity.this.eFC != null) {
                    GuideActivity.this.eFC.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.bzz.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.Qn();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener eFK = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aOY();
        }
    };
    private final ViewPager.OnPageChangeListener eFL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.eFI - 1) {
                GuideActivity.this.oz(d.e.ds170);
                GuideActivity.this.eFE.setVisibility(0);
                GuideActivity.this.eFD.setVisibility(0);
            } else {
                GuideActivity.this.eFE.setVisibility(8);
                GuideActivity.this.oz(d.e.ds120);
                GuideActivity.this.eFD.setVisibility(0);
            }
            if (GuideActivity.this.eFE.getVisibility() == 0) {
                GuideActivity.this.eFE.requestFocus();
            }
            GuideActivity.this.eFD.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener eFM = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.eFG = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.eFG = true;
                    return;
                }
                GuideActivity.this.eFG = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.eFG = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bzz = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.bzz = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bzz)) {
            this.bzz = "";
        }
        this.eFI = this.eFH.length;
        try {
            setContentView(d.i.guide_activity);
            age();
            this.eFG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.eFG) {
                aPa();
            }
            try {
                aOX();
                this.eFB = new b();
                this.eFC = (BaseViewPager) findViewById(d.g.guide_pager);
                this.eFC.setAdapter(this.eFB);
                this.eFD = (IndicatorView) findViewById(d.g.guide_page_indicator);
                this.eFD.setCount(this.eFI);
                q(this.eFD, d.e.ds70);
                this.eFD.setSpacing(getResources().getDimensionPixelSize(d.e.ds10));
                this.eFD.setSelector(getResources().getDrawable(d.f.icon_guide_pagecontrol_on));
                this.eFD.setDrawable(getResources().getDrawable(d.f.icon_guide_pagecontrol_off));
                this.eFD.setPosition(0.0f);
                if (this.eFI <= 1) {
                    this.eFD.setVisibility(4);
                } else {
                    this.eFD.setVisibility(0);
                }
                this.eFC.setOnScrollOutListener(this.ate);
                this.eFC.setOnFlipOutListener(this.ate);
                this.eFC.setOnPageChangeListener(this.eFL);
                this.eFE = findViewById(d.g.start_app);
                if (this.eFI <= 1) {
                    oz(d.e.ds90);
                    this.eFE.setVisibility(0);
                    this.eFE.requestFocus();
                } else {
                    this.eFE.setVisibility(8);
                }
                this.eFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aOY();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.bzz != null && this.bzz.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.eFy = new a();
                    this.eFy.setSelfExecute(true);
                    this.eFy.execute(new String[0]);
                    return;
                }
                this.eFy = null;
            } catch (OutOfMemoryError e) {
                aOZ();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.eFF = true;
                this.eFG = false;
                aOY();
            } catch (RuntimeException e2) {
                aOZ();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.eFF = true;
                this.eFG = false;
                aOY();
            }
        } catch (RuntimeException e3) {
            this.eFF = true;
            this.eFG = false;
            aOY();
        }
    }

    private void aOX() {
        this.eFz = new ArrayList<>();
        this.eFA = new ArrayList<>();
        for (int i = 0; i < this.eFI; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.g.guide_item_img);
            Bitmap d = d(imageView, this.eFH[i]);
            if (d == null) {
                aOY();
                return;
            }
            this.eFJ.add(d);
            this.eFA.add(imageView);
            this.eFz.add(relativeLayout);
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
    public void aOY() {
        if (this.bzz != null && !this.bzz.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Qn();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(int i) {
        q(this.eFE, i);
    }

    private void q(View view, int i) {
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
        aOZ();
        if (this.eFy != null) {
            this.eFy.cancel(true);
            this.eFy = null;
        }
    }

    protected void aOZ() {
        if (this.eFC != null) {
            this.eFC.setBackgroundDrawable(null);
        }
        if (this.eFA != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eFA.size()) {
                    break;
                }
                ImageView imageView = this.eFA.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.eFJ != null) {
            Iterator<Bitmap> it = this.eFJ.iterator();
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
                aOY();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qn() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.eFF) {
            if (!this.eFG || !NewUserGuideActivityConfig.canResponse()) {
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
                aPb();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                h.in().c(new Runnable() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkApplication.getInst().setUsed();
                    }
                });
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            finish();
            this.eFF = false;
        }
    }

    public void age() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.eFM);
    }

    public void aPa() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.eFG = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aPb() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPc() {
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
    public boolean aPd() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String ai = ai(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (ai == null) {
                ai = ai(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + ai + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(d.k.app_name)}, null);
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

    private String ai(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.aPd());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aPc();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.eFz.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.eFz.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.eFz.get(i), 0);
                if (i == GuideActivity.this.eFz.size() - 1) {
                    ((View) GuideActivity.this.eFz.get(i)).setOnClickListener(GuideActivity.this.eFK);
                }
                return GuideActivity.this.eFz.get(i);
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
