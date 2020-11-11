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
/* loaded from: classes23.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> kBX;
    private ArrayList<ImageView> kBY;
    private b kBZ;
    private BaseViewPager kCa;
    private IndicatorView kCb;
    private View kCc;
    private View kCj;
    private View kCk;
    private View kCl;
    private a kBW = null;
    private String mFromPage = null;
    private boolean kCd = true;
    public boolean kCe = true;
    private final int[] kCf = {R.drawable.android_guide_1, R.drawable.android_guide_2, R.drawable.android_guide_3};
    private int kCg = 0;
    private final int[] kCh = new int[0];
    private final ArrayList<Bitmap> kCi = new ArrayList<>();
    private final BaseViewPager.a eRs = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                if (GuideActivity.this.kCa != null) {
                    GuideActivity.this.kCa.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.bJa();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, R.anim.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener kCm = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.cYx();
            if (view.getId() == GuideActivity.this.kCl.getId()) {
                TiebaStatic.log(new aq("c13410").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener kCn = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.kCg - 1) {
                GuideActivity.this.DU(R.dimen.tbds170);
                GuideActivity.this.kCc.setVisibility(0);
                GuideActivity.this.kCb.setVisibility(0);
            } else {
                GuideActivity.this.kCc.setVisibility(8);
                GuideActivity.this.DU(R.dimen.tbds170);
                GuideActivity.this.kCb.setVisibility(0);
            }
            if (GuideActivity.this.kCc.getVisibility() == 0) {
                GuideActivity.this.kCc.requestFocus();
            }
            GuideActivity.this.kCb.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener kCo = new HttpMessageListener(1001520) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.kCe = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.kCe = true;
                    return;
                }
                GuideActivity.this.kCe = false;
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, false);
            } else {
                GuideActivity.this.kCe = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.kCk.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.cYx();
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
        this.kCg = this.kCf.length;
        try {
            setContentView(R.layout.guide_activity);
            bpx();
            this.kCe = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, true);
            if (this.kCe) {
                cYy();
            }
            try {
                cYw();
                this.kBZ = new b();
                this.kCa = (BaseViewPager) findViewById(R.id.guide_pager);
                this.kCa.setAdapter(this.kBZ);
                this.kCb = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.kCb.setCount(this.kCg);
                t(this.kCb, R.dimen.tbds46);
                this.kCb.setSpacing(getResources().getDimensionPixelSize(R.dimen.tbds35));
                this.kCb.setSelector(getResources().getDrawable(R.drawable.pic_mask_selected_n));
                this.kCb.setDrawable(getResources().getDrawable(R.drawable.pic_mask_unselected_n));
                this.kCb.setPosition(0.0f);
                if (this.kCg <= 1) {
                    this.kCb.setVisibility(4);
                } else {
                    this.kCb.setVisibility(0);
                }
                this.kCa.setOnScrollOutListener(this.eRs);
                this.kCa.setOnFlipOutListener(this.eRs);
                this.kCa.setOnPageChangeListener(this.kCn);
                this.kCc = findViewById(R.id.start_app);
                com.baidu.tbadk.core.util.e.a.brO().pr(2).ph(R.drawable.btn_mask_guide_n).pi(R.drawable.btn_intro_guide_n).bk(this.kCc);
                this.kCj = findViewById(R.id.opt_container);
                this.kCk = findViewById(R.id.img_start_game);
                this.kCk.setOnClickListener(this.mOnClickListener);
                this.kCl = findViewById(R.id.text_start_app);
                this.kCl.setOnClickListener(this.kCm);
                this.kCj.setVisibility(8);
                this.kCc.setVisibility(0);
                if (this.kCg <= 1) {
                    DU(R.dimen.ds90);
                    this.kCc.setVisibility(0);
                    this.kCc.requestFocus();
                } else {
                    this.kCc.setVisibility(8);
                }
                this.kCc.setOnClickListener(this.kCm);
                TiebaStatic.log("new_user_guide_pv");
                if (this.mFromPage != null && this.mFromPage.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.kBW = new a();
                    this.kBW.setSelfExecute(true);
                    this.kBW.execute(new String[0]);
                    return;
                }
                this.kBW = null;
            } catch (OutOfMemoryError e) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.kCd = true;
                this.kCe = false;
                cYx();
            } catch (RuntimeException e2) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.kCd = true;
                this.kCe = false;
                cYx();
            }
        } catch (RuntimeException e3) {
            this.kCd = true;
            this.kCe = false;
            cYx();
        }
    }

    private void cYw() {
        this.kBX = new ArrayList<>();
        this.kBY = new ArrayList<>();
        for (int i = 0; i < this.kCg; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.guide_item_img);
            imageView.setVisibility(0);
            ((GifView) relativeLayout.findViewById(R.id.view_gif)).setVisibility(8);
            imageView.setBackgroundResource(this.kCf[i]);
            Bitmap a2 = a(imageView, this.kCf[i]);
            if (a2 == null) {
                cYx();
                return;
            }
            this.kCi.add(a2);
            this.kBY.add(imageView);
            this.kBX.add(relativeLayout);
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
    public void cYx() {
        if (this.mFromPage != null && !this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            bJa();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DU(int i) {
        t(this.kCc, i);
    }

    private void t(View view, int i) {
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
        if (this.kBW != null) {
            this.kBW.cancel(true);
            this.kBW = null;
        }
    }

    protected void releaseResources() {
        if (this.kCa != null) {
            this.kCa.setBackgroundDrawable(null);
        }
        if (this.kBY != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kBY.size()) {
                    break;
                }
                ImageView imageView = this.kBY.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.kCi != null) {
            Iterator<Bitmap> it = this.kCi.iterator();
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
                cYx();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJa() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.kCd) {
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
            this.kCd = false;
        }
    }

    public void bpx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001520, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.kCo);
    }

    public void cYy() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.kCe = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1001520);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBM() {
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
    public boolean cYz() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aT = aT(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aT == null) {
                aT = aT(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aT + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aT(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.cYz());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aBM();
            }
        }
    }

    /* loaded from: classes23.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.kBX.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.kBX.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.kBX.get(i), 0);
                if (i == GuideActivity.this.kBX.size() - 1) {
                    ((View) GuideActivity.this.kBX.get(i)).setOnClickListener(GuideActivity.this.kCm);
                }
                return GuideActivity.this.kBX.get(i);
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
