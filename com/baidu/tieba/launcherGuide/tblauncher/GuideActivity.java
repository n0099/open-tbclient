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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes17.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<ImageView> jwA;
    private b jwB;
    private BaseViewPager jwC;
    private IndicatorView jwD;
    private View jwE;
    private View jwL;
    private View jwM;
    private View jwN;
    private ArrayList<View> jwz;
    private a jwy = null;
    private String mFromPage = null;
    private boolean jwF = true;
    public boolean jwG = true;
    private final int[] jwH = {R.drawable.android_guide_1, R.drawable.android_guide_2, R.drawable.android_guide_3, R.drawable.android_guide_4};
    private int jwI = 0;
    private final int[] jwJ = {R.raw.ai_game_guid};
    private final ArrayList<Bitmap> jwK = new ArrayList<>();
    private final BaseViewPager.a efm = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                if (GuideActivity.this.jwC != null) {
                    GuideActivity.this.jwC.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.brM();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, R.anim.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener jwO = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.cAI();
            if (view.getId() == GuideActivity.this.jwN.getId()) {
                TiebaStatic.log(new ap("c13410").dn("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener jwP = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.jwI - 1) {
                GuideActivity.this.zO(R.dimen.tbds170);
                GuideActivity.this.jwE.setVisibility(0);
                GuideActivity.this.jwD.setVisibility(0);
            } else {
                GuideActivity.this.jwE.setVisibility(8);
                GuideActivity.this.zO(R.dimen.tbds170);
                GuideActivity.this.jwD.setVisibility(0);
            }
            if (GuideActivity.this.jwE.getVisibility() == 0) {
                GuideActivity.this.jwE.requestFocus();
            }
            GuideActivity.this.jwD.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener jwQ = new HttpMessageListener(1001520) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.jwG = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.jwG = true;
                    return;
                }
                GuideActivity.this.jwG = false;
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, false);
            } else {
                GuideActivity.this.jwG = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.jwM.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.cAI();
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
        this.jwI = this.jwH.length;
        try {
            setContentView(R.layout.guide_activity);
            aZg();
            this.jwG = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, true);
            if (this.jwG) {
                cAJ();
            }
            try {
                cAH();
                this.jwB = new b();
                this.jwC = (BaseViewPager) findViewById(R.id.guide_pager);
                this.jwC.setAdapter(this.jwB);
                this.jwD = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.jwD.setCount(this.jwI);
                q(this.jwD, R.dimen.tbds46);
                this.jwD.setSpacing(getResources().getDimensionPixelSize(R.dimen.tbds35));
                this.jwD.setSelector(getResources().getDrawable(R.drawable.pic_mask_selected_n));
                this.jwD.setDrawable(getResources().getDrawable(R.drawable.pic_mask_unselected_n));
                this.jwD.setPosition(0.0f);
                if (this.jwI <= 1) {
                    this.jwD.setVisibility(4);
                } else {
                    this.jwD.setVisibility(0);
                }
                this.jwC.setOnScrollOutListener(this.efm);
                this.jwC.setOnFlipOutListener(this.efm);
                this.jwC.setOnPageChangeListener(this.jwP);
                this.jwE = findViewById(R.id.start_app);
                com.baidu.tbadk.core.util.e.a.bbr().mh(2).lY(R.drawable.btn_mask_guide_n).lZ(R.drawable.btn_intro_guide_n).aX(this.jwE);
                this.jwL = findViewById(R.id.opt_container);
                this.jwM = findViewById(R.id.img_start_game);
                this.jwM.setOnClickListener(this.mOnClickListener);
                this.jwN = findViewById(R.id.text_start_app);
                this.jwN.setOnClickListener(this.jwO);
                this.jwL.setVisibility(8);
                this.jwE.setVisibility(0);
                if (this.jwI <= 1) {
                    zO(R.dimen.ds90);
                    this.jwE.setVisibility(0);
                    this.jwE.requestFocus();
                } else {
                    this.jwE.setVisibility(8);
                }
                this.jwE.setOnClickListener(this.jwO);
                TiebaStatic.log("new_user_guide_pv");
                if (this.mFromPage != null && this.mFromPage.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.jwy = new a();
                    this.jwy.setSelfExecute(true);
                    this.jwy.execute(new String[0]);
                    return;
                }
                this.jwy = null;
            } catch (OutOfMemoryError e) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.jwF = true;
                this.jwG = false;
                cAI();
            } catch (RuntimeException e2) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.jwF = true;
                this.jwG = false;
                cAI();
            }
        } catch (RuntimeException e3) {
            this.jwF = true;
            this.jwG = false;
            cAI();
        }
    }

    private void cAH() {
        this.jwz = new ArrayList<>();
        this.jwA = new ArrayList<>();
        for (int i = 0; i < this.jwI; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.guide_item_img);
            imageView.setVisibility(0);
            ((GifView) relativeLayout.findViewById(R.id.view_gif)).setVisibility(8);
            imageView.setBackgroundResource(this.jwH[i]);
            Bitmap a2 = a(imageView, this.jwH[i]);
            if (a2 == null) {
                cAI();
                return;
            }
            this.jwK.add(a2);
            this.jwA.add(imageView);
            this.jwz.add(relativeLayout);
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
    public void cAI() {
        if (this.mFromPage != null && !this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            brM();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO(int i) {
        q(this.jwE, i);
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
        releaseResources();
        if (this.jwy != null) {
            this.jwy.cancel(true);
            this.jwy = null;
        }
    }

    protected void releaseResources() {
        if (this.jwC != null) {
            this.jwC.setBackgroundDrawable(null);
        }
        if (this.jwA != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jwA.size()) {
                    break;
                }
                ImageView imageView = this.jwA.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.jwK != null) {
            Iterator<Bitmap> it = this.jwK.iterator();
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
                cAI();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.jwF) {
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
            this.jwF = false;
        }
    }

    public void aZg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001520, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.jwQ);
    }

    public void cAJ() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.jwG = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1001520);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amj() {
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
    public boolean cAK() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aI = aI(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aI == null) {
                aI = aI(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aI + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aI(Context context, String str) {
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

    /* loaded from: classes17.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.cAK());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.amj();
            }
        }
    }

    /* loaded from: classes17.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.jwz.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.jwz.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.jwz.get(i), 0);
                if (i == GuideActivity.this.jwz.size() - 1) {
                    ((View) GuideActivity.this.jwz.get(i)).setOnClickListener(GuideActivity.this.jwO);
                }
                return GuideActivity.this.jwz.get(i);
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
