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
    private View heD;
    private View heE;
    private View heF;
    private ArrayList<View> her;
    private ArrayList<ImageView> hes;
    private b het;
    private BaseViewPager heu;
    private IndicatorView hev;
    private View hew;
    private a heq = null;
    private String dzf = null;
    private boolean hex = true;
    public boolean hey = true;
    private final int[] hez = {R.drawable.bg_startpage_1, R.drawable.bg_startpage_2, R.drawable.bg_startpage_3, R.drawable.bg_startpage_4};
    private int heA = 0;
    private final int[] heB = {R.raw.ai_game_guid};
    private final ArrayList<Bitmap> heC = new ArrayList<>();
    private final BaseViewPager.a bYf = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void iB(int i) {
        }
    };
    public View.OnClickListener heG = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bKF();
            if (view.getId() == GuideActivity.this.heF.getId()) {
                TiebaStatic.log(new an("c13410").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener heH = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.heA - 1) {
                GuideActivity.this.wt(R.dimen.ds170);
                GuideActivity.this.hew.setVisibility(0);
                GuideActivity.this.hev.setVisibility(0);
            } else {
                GuideActivity.this.hew.setVisibility(8);
                GuideActivity.this.wt(R.dimen.ds120);
                GuideActivity.this.hev.setVisibility(0);
            }
            if (GuideActivity.this.hew.getVisibility() == 0) {
                GuideActivity.this.hew.requestFocus();
            }
            GuideActivity.this.hev.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener heI = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.hey = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.hey = true;
                    return;
                }
                GuideActivity.this.hey = false;
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.hey = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.heE.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.bKF();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.dzf = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.dzf = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.dzf)) {
            this.dzf = "";
        }
        this.heA = this.heB.length;
        try {
            setContentView(R.layout.guide_activity);
            aXg();
            this.hey = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("jump_to_new_user_guide", true);
            if (this.hey) {
                bKH();
            }
            try {
                bKE();
                this.het = new b();
                this.heu = (BaseViewPager) findViewById(R.id.guide_pager);
                this.heu.setAdapter(this.het);
                this.hev = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.hev.setCount(this.heA);
                B(this.hev, R.dimen.ds70);
                this.hev.setSpacing(getResources().getDimensionPixelSize(R.dimen.ds10));
                this.hev.setSelector(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_on));
                this.hev.setDrawable(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_off));
                this.hev.setPosition(0.0f);
                if (this.heA <= 1) {
                    this.hev.setVisibility(4);
                } else {
                    this.hev.setVisibility(0);
                }
                this.heu.setOnScrollOutListener(this.bYf);
                this.heu.setOnFlipOutListener(this.bYf);
                this.heu.setOnPageChangeListener(this.heH);
                this.hew = findViewById(R.id.start_app);
                this.heD = findViewById(R.id.opt_container);
                this.heE = findViewById(R.id.img_start_game);
                this.heE.setOnClickListener(this.mOnClickListener);
                this.heF = findViewById(R.id.text_start_app);
                this.heF.setOnClickListener(this.heG);
                if (this.heA <= 1) {
                    wt(R.dimen.ds90);
                    this.hew.setVisibility(0);
                    this.hew.requestFocus();
                } else {
                    this.hew.setVisibility(8);
                }
                this.hew.setOnClickListener(this.heG);
                this.heD.setVisibility(0);
                this.hew.setVisibility(8);
                TiebaStatic.log("new_user_guide_pv");
                if (this.dzf != null && this.dzf.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.heq = new a();
                    this.heq.setSelfExecute(true);
                    this.heq.execute(new String[0]);
                } else {
                    this.heq = null;
                }
                TiebaStatic.log(new an("c13433").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            } catch (OutOfMemoryError e) {
                bKG();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.hex = true;
                this.hey = false;
                bKF();
            } catch (RuntimeException e2) {
                bKG();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.hex = true;
                this.hey = false;
                bKF();
            }
        } catch (RuntimeException e3) {
            this.hex = true;
            this.hey = false;
            bKF();
        }
    }

    private void bKE() {
        this.her = new ArrayList<>();
        this.hes = new ArrayList<>();
        for (int i = 0; i < this.heA; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            GifView gifView = (GifView) relativeLayout.findViewById(R.id.view_gif);
            ((ImageView) relativeLayout.findViewById(R.id.guide_item_img)).setVisibility(8);
            gifView.setVisibility(0);
            gifView.setGifRaw(this.heB[i]);
            this.her.add(relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKF() {
        if (this.dzf != null && !this.dzf.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            aDe();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wt(int i) {
        B(this.hew, i);
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
        bKG();
        if (this.heq != null) {
            this.heq.cancel(true);
            this.heq = null;
        }
    }

    protected void bKG() {
        if (this.heu != null) {
            this.heu.setBackgroundDrawable(null);
        }
        if (this.hes != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hes.size()) {
                    break;
                }
                ImageView imageView = this.hes.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.heC != null) {
            Iterator<Bitmap> it = this.heC.iterator();
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
                bKF();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void aDe() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.hex) {
            if (!this.hey || !NewUserGuideActivityConfig.canResponse()) {
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
                bKI();
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("jump_to_new_user_guide", false);
            }
            finish();
            this.hex = false;
        }
    }

    public void aXg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.heI);
    }

    public void bKH() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.hey = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void bKI() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QA() {
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
    public boolean bKJ() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aK = aK(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aK == null) {
                aK = aK(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aK + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aK(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.bKJ());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.QA();
            }
        }
    }

    /* loaded from: classes5.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.her.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.her.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.her.get(i), 0);
                return GuideActivity.this.her.get(i);
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
