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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes23.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> kPG;
    private ArrayList<ImageView> kPH;
    private b kPI;
    private BaseViewPager kPJ;
    private IndicatorView kPK;
    private View kPL;
    private View kPS;
    private View kPT;
    private View kPU;
    private a kPF = null;
    private String mFromPage = null;
    private boolean kPM = true;
    public boolean kPN = true;
    private final int[] kPO = {R.drawable.android_guide_1, R.drawable.android_guide_2, R.drawable.android_guide_3};
    private int kPP = 0;
    private final int[] kPQ = new int[0];
    private final ArrayList<Bitmap> kPR = new ArrayList<>();
    private final BaseViewPager.a eXI = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                if (GuideActivity.this.kPJ != null) {
                    GuideActivity.this.kPJ.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.bMd();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, R.anim.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener kPV = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.ddf();
            if (view.getId() == GuideActivity.this.kPU.getId()) {
                TiebaStatic.log(new ar("c13410").dY("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener kPW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.kPP - 1) {
                GuideActivity.this.Fh(R.dimen.tbds170);
                GuideActivity.this.kPL.setVisibility(0);
                GuideActivity.this.kPK.setVisibility(0);
            } else {
                GuideActivity.this.kPL.setVisibility(8);
                GuideActivity.this.Fh(R.dimen.tbds170);
                GuideActivity.this.kPK.setVisibility(0);
            }
            if (GuideActivity.this.kPL.getVisibility() == 0) {
                GuideActivity.this.kPL.requestFocus();
            }
            GuideActivity.this.kPK.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener kPX = new HttpMessageListener(1001520) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.kPN = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.kPN = true;
                    return;
                }
                GuideActivity.this.kPN = false;
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, false);
            } else {
                GuideActivity.this.kPN = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.kPT.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.ddf();
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
        this.kPP = this.kPO.length;
        try {
            setContentView(R.layout.guide_activity);
            bse();
            this.kPN = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, true);
            if (this.kPN) {
                ddg();
            }
            try {
                dde();
                this.kPI = new b();
                this.kPJ = (BaseViewPager) findViewById(R.id.guide_pager);
                this.kPJ.setAdapter(this.kPI);
                this.kPK = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.kPK.setCount(this.kPP);
                v(this.kPK, R.dimen.tbds46);
                this.kPK.setSpacing(getResources().getDimensionPixelSize(R.dimen.tbds35));
                this.kPK.setSelector(getResources().getDrawable(R.drawable.pic_mask_selected_n));
                this.kPK.setDrawable(getResources().getDrawable(R.drawable.pic_mask_unselected_n));
                this.kPK.setPosition(0.0f);
                if (this.kPP <= 1) {
                    this.kPK.setVisibility(4);
                } else {
                    this.kPK.setVisibility(0);
                }
                this.kPJ.setOnScrollOutListener(this.eXI);
                this.kPJ.setOnFlipOutListener(this.eXI);
                this.kPJ.setOnPageChangeListener(this.kPW);
                this.kPL = findViewById(R.id.start_app);
                com.baidu.tbadk.core.util.e.a.buz().qo(2).qd(R.drawable.btn_mask_guide_n).qe(R.drawable.btn_intro_guide_n).bq(this.kPL);
                this.kPS = findViewById(R.id.opt_container);
                this.kPT = findViewById(R.id.img_start_game);
                this.kPT.setOnClickListener(this.mOnClickListener);
                this.kPU = findViewById(R.id.text_start_app);
                this.kPU.setOnClickListener(this.kPV);
                this.kPS.setVisibility(8);
                this.kPL.setVisibility(0);
                if (this.kPP <= 1) {
                    Fh(R.dimen.ds90);
                    this.kPL.setVisibility(0);
                    this.kPL.requestFocus();
                } else {
                    this.kPL.setVisibility(8);
                }
                this.kPL.setOnClickListener(this.kPV);
                TiebaStatic.log("new_user_guide_pv");
                if (this.mFromPage != null && this.mFromPage.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.kPF = new a();
                    this.kPF.setSelfExecute(true);
                    this.kPF.execute(new String[0]);
                    return;
                }
                this.kPF = null;
            } catch (OutOfMemoryError e) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.kPM = true;
                this.kPN = false;
                ddf();
            } catch (RuntimeException e2) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.kPM = true;
                this.kPN = false;
                ddf();
            }
        } catch (RuntimeException e3) {
            this.kPM = true;
            this.kPN = false;
            ddf();
        }
    }

    private void dde() {
        this.kPG = new ArrayList<>();
        this.kPH = new ArrayList<>();
        for (int i = 0; i < this.kPP; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.guide_item_img);
            imageView.setVisibility(0);
            ((GifView) relativeLayout.findViewById(R.id.view_gif)).setVisibility(8);
            imageView.setBackgroundResource(this.kPO[i]);
            Bitmap a2 = a(imageView, this.kPO[i]);
            if (a2 == null) {
                ddf();
                return;
            }
            this.kPR.add(a2);
            this.kPH.add(imageView);
            this.kPG.add(relativeLayout);
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
    public void ddf() {
        if (this.mFromPage != null && !this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            bMd();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(int i) {
        v(this.kPL, i);
    }

    private void v(View view, int i) {
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
        if (this.kPF != null) {
            this.kPF.cancel(true);
            this.kPF = null;
        }
    }

    protected void releaseResources() {
        if (this.kPJ != null) {
            this.kPJ.setBackgroundDrawable(null);
        }
        if (this.kPH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kPH.size()) {
                    break;
                }
                ImageView imageView = this.kPH.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.kPR != null) {
            Iterator<Bitmap> it = this.kPR.iterator();
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
                ddf();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMd() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.kPM) {
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
            this.kPM = false;
        }
    }

    public void bse() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001520, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.kPX);
    }

    public void ddg() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.kPN = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1001520);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEn() {
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
    public boolean ddh() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aU = aU(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aU == null) {
                aU = aU(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aU + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aU(Context context, String str) {
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

    /* loaded from: classes23.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.ddh());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aEn();
            }
        }
    }

    /* loaded from: classes23.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.kPG.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.kPG.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.kPG.get(i), 0);
                if (i == GuideActivity.this.kPG.size() - 1) {
                    ((View) GuideActivity.this.kPG.get(i)).setOnClickListener(GuideActivity.this.kPV);
                }
                return GuideActivity.this.kPG.get(i);
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
