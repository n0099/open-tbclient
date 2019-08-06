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
    private BaseViewPager hcA;
    private IndicatorView hcB;
    private View hcC;
    private View hcJ;
    private View hcK;
    private View hcL;
    private ArrayList<View> hcx;
    private ArrayList<ImageView> hcy;
    private b hcz;
    private a hcw = null;
    private String dxu = null;
    private boolean hcD = true;
    public boolean hcE = true;
    private final int[] hcF = {R.drawable.bg_startpage_1, R.drawable.bg_startpage_2, R.drawable.bg_startpage_3, R.drawable.bg_startpage_4};
    private int hcG = 0;
    private final int[] hcH = {R.raw.ai_game_guid};
    private final ArrayList<Bitmap> hcI = new ArrayList<>();
    private final BaseViewPager.a bXm = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void iy(int i) {
        }
    };
    public View.OnClickListener hcM = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bJS();
            if (view.getId() == GuideActivity.this.hcL.getId()) {
                TiebaStatic.log(new an("c13410").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener hcN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.hcG - 1) {
                GuideActivity.this.wq(R.dimen.ds170);
                GuideActivity.this.hcC.setVisibility(0);
                GuideActivity.this.hcB.setVisibility(0);
            } else {
                GuideActivity.this.hcC.setVisibility(8);
                GuideActivity.this.wq(R.dimen.ds120);
                GuideActivity.this.hcB.setVisibility(0);
            }
            if (GuideActivity.this.hcC.getVisibility() == 0) {
                GuideActivity.this.hcC.requestFocus();
            }
            GuideActivity.this.hcB.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener hcO = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.hcE = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.hcE = true;
                    return;
                }
                GuideActivity.this.hcE = false;
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.hcE = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.hcK.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.bJS();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.dxu = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.dxu = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.dxu)) {
            this.dxu = "";
        }
        this.hcG = this.hcH.length;
        try {
            setContentView(R.layout.guide_activity);
            aWC();
            this.hcE = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("jump_to_new_user_guide", true);
            if (this.hcE) {
                bJU();
            }
            try {
                bJR();
                this.hcz = new b();
                this.hcA = (BaseViewPager) findViewById(R.id.guide_pager);
                this.hcA.setAdapter(this.hcz);
                this.hcB = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.hcB.setCount(this.hcG);
                B(this.hcB, R.dimen.ds70);
                this.hcB.setSpacing(getResources().getDimensionPixelSize(R.dimen.ds10));
                this.hcB.setSelector(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_on));
                this.hcB.setDrawable(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_off));
                this.hcB.setPosition(0.0f);
                if (this.hcG <= 1) {
                    this.hcB.setVisibility(4);
                } else {
                    this.hcB.setVisibility(0);
                }
                this.hcA.setOnScrollOutListener(this.bXm);
                this.hcA.setOnFlipOutListener(this.bXm);
                this.hcA.setOnPageChangeListener(this.hcN);
                this.hcC = findViewById(R.id.start_app);
                this.hcJ = findViewById(R.id.opt_container);
                this.hcK = findViewById(R.id.img_start_game);
                this.hcK.setOnClickListener(this.mOnClickListener);
                this.hcL = findViewById(R.id.text_start_app);
                this.hcL.setOnClickListener(this.hcM);
                if (this.hcG <= 1) {
                    wq(R.dimen.ds90);
                    this.hcC.setVisibility(0);
                    this.hcC.requestFocus();
                } else {
                    this.hcC.setVisibility(8);
                }
                this.hcC.setOnClickListener(this.hcM);
                this.hcJ.setVisibility(0);
                this.hcC.setVisibility(8);
                TiebaStatic.log("new_user_guide_pv");
                if (this.dxu != null && this.dxu.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.hcw = new a();
                    this.hcw.setSelfExecute(true);
                    this.hcw.execute(new String[0]);
                } else {
                    this.hcw = null;
                }
                TiebaStatic.log(new an("c13433").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            } catch (OutOfMemoryError e) {
                bJT();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.hcD = true;
                this.hcE = false;
                bJS();
            } catch (RuntimeException e2) {
                bJT();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.hcD = true;
                this.hcE = false;
                bJS();
            }
        } catch (RuntimeException e3) {
            this.hcD = true;
            this.hcE = false;
            bJS();
        }
    }

    private void bJR() {
        this.hcx = new ArrayList<>();
        this.hcy = new ArrayList<>();
        for (int i = 0; i < this.hcG; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            GifView gifView = (GifView) relativeLayout.findViewById(R.id.view_gif);
            ((ImageView) relativeLayout.findViewById(R.id.guide_item_img)).setVisibility(8);
            gifView.setVisibility(0);
            gifView.setGifRaw(this.hcH[i]);
            this.hcx.add(relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJS() {
        if (this.dxu != null && !this.dxu.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            aCQ();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq(int i) {
        B(this.hcC, i);
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
        bJT();
        if (this.hcw != null) {
            this.hcw.cancel(true);
            this.hcw = null;
        }
    }

    protected void bJT() {
        if (this.hcA != null) {
            this.hcA.setBackgroundDrawable(null);
        }
        if (this.hcy != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hcy.size()) {
                    break;
                }
                ImageView imageView = this.hcy.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.hcI != null) {
            Iterator<Bitmap> it = this.hcI.iterator();
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
                bJS();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void aCQ() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.hcD) {
            if (!this.hcE || !NewUserGuideActivityConfig.canResponse()) {
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
                bJV();
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("jump_to_new_user_guide", false);
            }
            finish();
            this.hcD = false;
        }
    }

    public void aWC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.hcO);
    }

    public void bJU() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.hcE = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void bJV() {
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
    public boolean bJW() {
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
            return Boolean.valueOf(GuideActivity.this.bJW());
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
            return GuideActivity.this.hcx.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.hcx.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.hcx.get(i), 0);
                return GuideActivity.this.hcx.get(i);
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
