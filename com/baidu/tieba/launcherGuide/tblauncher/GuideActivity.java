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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
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
    private ArrayList<View> hbE;
    private ArrayList<ImageView> hbF;
    private b hbG;
    private BaseViewPager hbH;
    private IndicatorView hbI;
    private View hbJ;
    private View hbQ;
    private View hbR;
    private View hbS;
    private a hbC = null;
    private String hbD = null;
    private boolean hbK = true;
    public boolean hbL = true;
    private final int[] hbM = {R.drawable.bg_startpage_1, R.drawable.bg_startpage_2, R.drawable.bg_startpage_3, R.drawable.bg_startpage_4};
    private int hbN = 0;
    private final int[] hbO = {R.raw.ai_game_guid};
    private final ArrayList<Bitmap> hbP = new ArrayList<>();
    private final BaseViewPager.a cmr = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
        }
    };
    public View.OnClickListener hbT = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bHn();
            if (view.getId() == GuideActivity.this.hbS.getId()) {
                TiebaStatic.log(new an("c13410").bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener hbU = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.hbN - 1) {
                GuideActivity.this.uY(R.dimen.ds170);
                GuideActivity.this.hbJ.setVisibility(0);
                GuideActivity.this.hbI.setVisibility(0);
            } else {
                GuideActivity.this.hbJ.setVisibility(8);
                GuideActivity.this.uY(R.dimen.ds120);
                GuideActivity.this.hbI.setVisibility(0);
            }
            if (GuideActivity.this.hbJ.getVisibility() == 0) {
                GuideActivity.this.hbJ.requestFocus();
            }
            GuideActivity.this.hbI.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener hbV = new HttpMessageListener(1001520) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.hbL = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.hbL = true;
                    return;
                }
                GuideActivity.this.hbL = false;
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, false);
            } else {
                GuideActivity.this.hbL = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.hbR.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.bHn();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.hbD = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.hbD = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.hbD)) {
            this.hbD = "";
        }
        this.hbN = this.hbO.length;
        try {
            setContentView(R.layout.guide_activity);
            aMH();
            this.hbL = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, true);
            if (this.hbL) {
                bHp();
            }
            try {
                bHm();
                this.hbG = new b();
                this.hbH = (BaseViewPager) findViewById(R.id.guide_pager);
                this.hbH.setAdapter(this.hbG);
                this.hbI = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.hbI.setCount(this.hbN);
                q(this.hbI, R.dimen.ds70);
                this.hbI.setSpacing(getResources().getDimensionPixelSize(R.dimen.ds10));
                this.hbI.setSelector(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_on));
                this.hbI.setDrawable(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_off));
                this.hbI.setPosition(0.0f);
                if (this.hbN <= 1) {
                    this.hbI.setVisibility(4);
                } else {
                    this.hbI.setVisibility(0);
                }
                this.hbH.setOnScrollOutListener(this.cmr);
                this.hbH.setOnFlipOutListener(this.cmr);
                this.hbH.setOnPageChangeListener(this.hbU);
                this.hbJ = findViewById(R.id.start_app);
                this.hbQ = findViewById(R.id.opt_container);
                this.hbR = findViewById(R.id.img_start_game);
                this.hbR.setOnClickListener(this.mOnClickListener);
                this.hbS = findViewById(R.id.text_start_app);
                this.hbS.setOnClickListener(this.hbT);
                if (this.hbN <= 1) {
                    uY(R.dimen.ds90);
                    this.hbJ.setVisibility(0);
                    this.hbJ.requestFocus();
                } else {
                    this.hbJ.setVisibility(8);
                }
                this.hbJ.setOnClickListener(this.hbT);
                this.hbQ.setVisibility(0);
                this.hbJ.setVisibility(8);
                TiebaStatic.log("new_user_guide_pv");
                if (this.hbD != null && this.hbD.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.hbC = new a();
                    this.hbC.setSelfExecute(true);
                    this.hbC.execute(new String[0]);
                } else {
                    this.hbC = null;
                }
                TiebaStatic.log(new an("c13433").bS("uid", TbadkCoreApplication.getCurrentAccount()));
            } catch (OutOfMemoryError e) {
                bHo();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.hbK = true;
                this.hbL = false;
                bHn();
            } catch (RuntimeException e2) {
                bHo();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.hbK = true;
                this.hbL = false;
                bHn();
            }
        } catch (RuntimeException e3) {
            this.hbK = true;
            this.hbL = false;
            bHn();
        }
    }

    private void bHm() {
        this.hbE = new ArrayList<>();
        this.hbF = new ArrayList<>();
        for (int i = 0; i < this.hbN; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            GifView gifView = (GifView) relativeLayout.findViewById(R.id.view_gif);
            ((ImageView) relativeLayout.findViewById(R.id.guide_item_img)).setVisibility(8);
            gifView.setVisibility(0);
            gifView.setGifRaw(this.hbO[i]);
            this.hbE.add(relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHn() {
        if (this.hbD != null && !this.hbD.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            aDl();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(int i) {
        q(this.hbJ, i);
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
        bHo();
        if (this.hbC != null) {
            this.hbC.cancel(true);
            this.hbC = null;
        }
    }

    protected void bHo() {
        if (this.hbH != null) {
            this.hbH.setBackgroundDrawable(null);
        }
        if (this.hbF != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hbF.size()) {
                    break;
                }
                ImageView imageView = this.hbF.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.hbP != null) {
            Iterator<Bitmap> it = this.hbP.iterator();
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
                bHn();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void aDl() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.hbK) {
            if (!this.hbL || !NewUserGuideActivityConfig.canResponse()) {
                int i = TbadkCoreApplication.getCurrentAccount() == null ? 2 : 1;
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    if (!TbadkCoreApplication.isLogin()) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    } else {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                    }
                }
            } else {
                bHq();
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, false);
            }
            finish();
            this.hbK = false;
        }
    }

    public void aMH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001520, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.hbV);
    }

    public void bHp() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.hbL = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1001520);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void bHq() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
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
    public boolean bHr() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aH = aH(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aH == null) {
                aH = aH(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aH + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aH(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.bHr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.Vo();
            }
        }
    }

    /* loaded from: classes5.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.hbE.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.hbE.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.hbE.get(i), 0);
                return GuideActivity.this.hbE.get(i);
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
