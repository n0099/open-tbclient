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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> jUF;
    private ArrayList<ImageView> jUG;
    private b jUH;
    private BaseViewPager jUI;
    private IndicatorView jUJ;
    private View jUK;
    private View jUR;
    private View jUS;
    private View jUT;
    private a jUE = null;
    private String mFromPage = null;
    private boolean jUL = true;
    public boolean jUM = true;
    private final int[] jUN = {R.drawable.android_guide_1, R.drawable.android_guide_2, R.drawable.android_guide_3};
    private int jUO = 0;
    private final int[] jUP = new int[0];
    private final ArrayList<Bitmap> jUQ = new ArrayList<>();
    private final BaseViewPager.a eqV = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                if (GuideActivity.this.jUI != null) {
                    GuideActivity.this.jUI.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.bBW();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, R.anim.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener jUU = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.cPh();
            if (view.getId() == GuideActivity.this.jUT.getId()) {
                TiebaStatic.log(new aq("c13410").dF("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener jUV = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.jUO - 1) {
                GuideActivity.this.CI(R.dimen.tbds170);
                GuideActivity.this.jUK.setVisibility(0);
                GuideActivity.this.jUJ.setVisibility(0);
            } else {
                GuideActivity.this.jUK.setVisibility(8);
                GuideActivity.this.CI(R.dimen.tbds170);
                GuideActivity.this.jUJ.setVisibility(0);
            }
            if (GuideActivity.this.jUK.getVisibility() == 0) {
                GuideActivity.this.jUK.requestFocus();
            }
            GuideActivity.this.jUJ.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener jUW = new HttpMessageListener(1001520) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.jUM = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.jUM = true;
                    return;
                }
                GuideActivity.this.jUM = false;
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, false);
            } else {
                GuideActivity.this.jUM = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.jUS.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.cPh();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.mFromPage = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.mFromPage = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TextUtils.isEmpty(this.mFromPage)) {
            this.mFromPage = "";
        }
        this.jUO = this.jUN.length;
        try {
            setContentView(R.layout.guide_activity);
            biv();
            this.jUM = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, true);
            if (this.jUM) {
                cPi();
            }
            try {
                cPg();
                this.jUH = new b();
                this.jUI = (BaseViewPager) findViewById(R.id.guide_pager);
                this.jUI.setAdapter(this.jUH);
                this.jUJ = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.jUJ.setCount(this.jUO);
                r(this.jUJ, R.dimen.tbds46);
                this.jUJ.setSpacing(getResources().getDimensionPixelSize(R.dimen.tbds35));
                this.jUJ.setSelector(getResources().getDrawable(R.drawable.pic_mask_selected_n));
                this.jUJ.setDrawable(getResources().getDrawable(R.drawable.pic_mask_unselected_n));
                this.jUJ.setPosition(0.0f);
                if (this.jUO <= 1) {
                    this.jUJ.setVisibility(4);
                } else {
                    this.jUJ.setVisibility(0);
                }
                this.jUI.setOnScrollOutListener(this.eqV);
                this.jUI.setOnFlipOutListener(this.eqV);
                this.jUI.setOnPageChangeListener(this.jUV);
                this.jUK = findViewById(R.id.start_app);
                com.baidu.tbadk.core.util.e.a.bkL().ox(2).oo(R.drawable.btn_mask_guide_n).op(R.drawable.btn_intro_guide_n).bb(this.jUK);
                this.jUR = findViewById(R.id.opt_container);
                this.jUS = findViewById(R.id.img_start_game);
                this.jUS.setOnClickListener(this.mOnClickListener);
                this.jUT = findViewById(R.id.text_start_app);
                this.jUT.setOnClickListener(this.jUU);
                this.jUR.setVisibility(8);
                this.jUK.setVisibility(0);
                if (this.jUO <= 1) {
                    CI(R.dimen.ds90);
                    this.jUK.setVisibility(0);
                    this.jUK.requestFocus();
                } else {
                    this.jUK.setVisibility(8);
                }
                this.jUK.setOnClickListener(this.jUU);
                TiebaStatic.log("new_user_guide_pv");
                if (this.mFromPage != null && this.mFromPage.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.jUE = new a();
                    this.jUE.setSelfExecute(true);
                    this.jUE.execute(new String[0]);
                    return;
                }
                this.jUE = null;
            } catch (OutOfMemoryError e) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.jUL = true;
                this.jUM = false;
                cPh();
            } catch (RuntimeException e2) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.jUL = true;
                this.jUM = false;
                cPh();
            }
        } catch (RuntimeException e3) {
            this.jUL = true;
            this.jUM = false;
            cPh();
        }
    }

    private void cPg() {
        this.jUF = new ArrayList<>();
        this.jUG = new ArrayList<>();
        for (int i = 0; i < this.jUO; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.guide_item_img);
            imageView.setVisibility(0);
            ((GifView) relativeLayout.findViewById(R.id.view_gif)).setVisibility(8);
            imageView.setBackgroundResource(this.jUN[i]);
            Bitmap a2 = a(imageView, this.jUN[i]);
            if (a2 == null) {
                cPh();
                return;
            }
            this.jUQ.add(a2);
            this.jUG.add(imageView);
            this.jUF.add(relativeLayout);
        }
    }

    private Bitmap a(ImageView imageView, int i) {
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
    public void cPh() {
        if (this.mFromPage != null && !this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            bBW();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CI(int i) {
        r(this.jUK, i);
    }

    private void r(View view, int i) {
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
        releaseResources();
        if (this.jUE != null) {
            this.jUE.cancel(true);
            this.jUE = null;
        }
    }

    protected void releaseResources() {
        if (this.jUI != null) {
            this.jUI.setBackgroundDrawable(null);
        }
        if (this.jUG != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jUG.size()) {
                    break;
                }
                ImageView imageView = this.jUG.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.jUQ != null) {
            Iterator<Bitmap> it = this.jUQ.iterator();
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
                cPh();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBW() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.jUL) {
            if (!TbadkApplication.getInst().isNeedNewUserLead()) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    if (!TbadkCoreApplication.isLogin()) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    } else {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    }
                }
            } else {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            }
            finish();
            this.jUL = false;
        }
    }

    public void biv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001520, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.jUW);
    }

    public void cPi() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.jUM = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1001520);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auH() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), R.drawable.tb_launcher_icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPj() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aP = aP(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aP == null) {
                aP = aP(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aP + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aP(Context context, String str) {
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

    /* loaded from: classes22.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.cPj());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.auH();
            }
        }
    }

    /* loaded from: classes22.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.jUF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.jUF.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.jUF.get(i), 0);
                if (i == GuideActivity.this.jUF.size() - 1) {
                    ((View) GuideActivity.this.jUF.get(i)).setOnClickListener(GuideActivity.this.jUU);
                }
                return GuideActivity.this.jUF.get(i);
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
