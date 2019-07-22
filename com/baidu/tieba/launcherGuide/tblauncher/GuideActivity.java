package com.baidu.tieba.launcherGuide.tblauncher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> hbF;
    private ArrayList<ImageView> hbG;
    private b hbH;
    private BaseViewPager hbI;
    private IndicatorView hbJ;
    private View hbK;
    private View hbR;
    private View hbS;
    private View hbT;
    private a hbE = null;
    private String dxn = null;
    private boolean hbL = true;
    public boolean hbM = true;
    private final int[] hbN = {R.drawable.bg_startpage_1, R.drawable.bg_startpage_2, R.drawable.bg_startpage_3, R.drawable.bg_startpage_4};
    private int hbO = 0;
    private final int[] hbP = {R.raw.ai_game_guid};
    private final ArrayList<Bitmap> hbQ = new ArrayList<>();
    private final BaseViewPager.a bXg = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void iy(int i) {
        }
    };
    public View.OnClickListener hbU = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bJE();
            if (view.getId() == GuideActivity.this.hbT.getId()) {
                TiebaStatic.log(new an("c13410").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener hbV = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.hbO - 1) {
                GuideActivity.this.wo(R.dimen.ds170);
                GuideActivity.this.hbK.setVisibility(0);
                GuideActivity.this.hbJ.setVisibility(0);
            } else {
                GuideActivity.this.hbK.setVisibility(8);
                GuideActivity.this.wo(R.dimen.ds120);
                GuideActivity.this.hbJ.setVisibility(0);
            }
            if (GuideActivity.this.hbK.getVisibility() == 0) {
                GuideActivity.this.hbK.requestFocus();
            }
            GuideActivity.this.hbJ.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener hbW = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.hbM = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.hbM = true;
                    return;
                }
                GuideActivity.this.hbM = false;
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.hbM = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.hbS.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.bJE();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.dxn = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.dxn = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.dxn)) {
            this.dxn = "";
        }
        this.hbO = this.hbP.length;
        try {
            setContentView(R.layout.guide_activity);
            aWA();
            this.hbM = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("jump_to_new_user_guide", true);
            if (this.hbM) {
                bJG();
            }
            try {
                bJD();
                this.hbH = new b();
                this.hbI = (BaseViewPager) findViewById(R.id.guide_pager);
                this.hbI.setAdapter(this.hbH);
                this.hbJ = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.hbJ.setCount(this.hbO);
                B(this.hbJ, R.dimen.ds70);
                this.hbJ.setSpacing(getResources().getDimensionPixelSize(R.dimen.ds10));
                this.hbJ.setSelector(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_on));
                this.hbJ.setDrawable(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_off));
                this.hbJ.setPosition(0.0f);
                if (this.hbO <= 1) {
                    this.hbJ.setVisibility(4);
                } else {
                    this.hbJ.setVisibility(0);
                }
                this.hbI.setOnScrollOutListener(this.bXg);
                this.hbI.setOnFlipOutListener(this.bXg);
                this.hbI.setOnPageChangeListener(this.hbV);
                this.hbK = findViewById(R.id.start_app);
                this.hbR = findViewById(R.id.opt_container);
                this.hbS = findViewById(R.id.img_start_game);
                this.hbS.setOnClickListener(this.mOnClickListener);
                this.hbT = findViewById(R.id.text_start_app);
                this.hbT.setOnClickListener(this.hbU);
                if (this.hbO <= 1) {
                    wo(R.dimen.ds90);
                    this.hbK.setVisibility(0);
                    this.hbK.requestFocus();
                } else {
                    this.hbK.setVisibility(8);
                }
                this.hbK.setOnClickListener(this.hbU);
                this.hbR.setVisibility(0);
                this.hbK.setVisibility(8);
                TiebaStatic.log("new_user_guide_pv");
                if (this.dxn != null && this.dxn.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.hbE = new a();
                    this.hbE.setSelfExecute(true);
                    this.hbE.execute(new String[0]);
                } else {
                    this.hbE = null;
                }
                TiebaStatic.log(new an("c13433").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            } catch (OutOfMemoryError e) {
                bJF();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.hbL = true;
                this.hbM = false;
                bJE();
            } catch (RuntimeException e2) {
                bJF();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.hbL = true;
                this.hbM = false;
                bJE();
            }
        } catch (RuntimeException e3) {
            this.hbL = true;
            this.hbM = false;
            bJE();
        }
    }

    private void bJD() {
        this.hbF = new ArrayList<>();
        this.hbG = new ArrayList<>();
        for (int i = 0; i < this.hbO; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            GifView gifView = (GifView) relativeLayout.findViewById(R.id.view_gif);
            ((ImageView) relativeLayout.findViewById(R.id.guide_item_img)).setVisibility(8);
            gifView.setVisibility(0);
            gifView.setGifRaw(this.hbP[i]);
            this.hbF.add(relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJE() {
        if (this.dxn != null && !this.dxn.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            aCO();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wo(int i) {
        B(this.hbK, i);
    }

    private void B(View view, int i) {
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
        bJF();
        if (this.hbE != null) {
            this.hbE.cancel(true);
            this.hbE = null;
        }
    }

    protected void bJF() {
        if (this.hbI != null) {
            this.hbI.setBackgroundDrawable(null);
        }
        if (this.hbG != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hbG.size()) {
                    break;
                }
                ImageView imageView = this.hbG.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.hbQ != null) {
            Iterator<Bitmap> it = this.hbQ.iterator();
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
                bJE();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void aCO() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.hbL) {
            if (!this.hbM || !NewUserGuideActivityConfig.canResponse()) {
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
                bJH();
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("jump_to_new_user_guide", false);
            }
            finish();
            this.hbL = false;
        }
    }

    public void aWA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.hbW);
    }

    public void bJG() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.hbM = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void bJH() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qw() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), R.drawable.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJI() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aD = aD(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aD == null) {
                aD = aD(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aD + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aD(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.bJI());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.Qw();
            }
        }
    }

    /* loaded from: classes5.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.hbF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.hbF.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.hbF.get(i), 0);
                return GuideActivity.this.hbF.get(i);
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
