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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private View gVC;
    private View gVD;
    private View gVE;
    private ArrayList<View> gVq;
    private ArrayList<ImageView> gVr;
    private b gVs;
    private BaseViewPager gVt;
    private IndicatorView gVu;
    private View gVv;
    private a gVp = null;
    private String dve = null;
    private boolean gVw = true;
    public boolean gVx = true;
    private final int[] gVy = {R.drawable.bg_startpage_1, R.drawable.bg_startpage_2, R.drawable.bg_startpage_3, R.drawable.bg_startpage_4};
    private int gVz = 0;
    private final int[] gVA = {R.raw.ai_game_guid};
    private final ArrayList<Bitmap> gVB = new ArrayList<>();
    private final BaseViewPager.a bWd = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void is(int i) {
        }
    };
    public View.OnClickListener gVF = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bGT();
            if (view.getId() == GuideActivity.this.gVE.getId()) {
                TiebaStatic.log(new am("c13410").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener gVG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.gVz - 1) {
                GuideActivity.this.vM(R.dimen.ds170);
                GuideActivity.this.gVv.setVisibility(0);
                GuideActivity.this.gVu.setVisibility(0);
            } else {
                GuideActivity.this.gVv.setVisibility(8);
                GuideActivity.this.vM(R.dimen.ds120);
                GuideActivity.this.gVu.setVisibility(0);
            }
            if (GuideActivity.this.gVv.getVisibility() == 0) {
                GuideActivity.this.gVv.requestFocus();
            }
            GuideActivity.this.gVu.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener gVH = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.gVx = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.gVx = true;
                    return;
                }
                GuideActivity.this.gVx = false;
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.gVx = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.gVD.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.bGT();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.dve = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.dve = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.dve)) {
            this.dve = "";
        }
        this.gVz = this.gVA.length;
        try {
            setContentView(R.layout.guide_activity);
            aUA();
            this.gVx = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("jump_to_new_user_guide", true);
            if (this.gVx) {
                bGV();
            }
            try {
                bGS();
                this.gVs = new b();
                this.gVt = (BaseViewPager) findViewById(R.id.guide_pager);
                this.gVt.setAdapter(this.gVs);
                this.gVu = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.gVu.setCount(this.gVz);
                B(this.gVu, R.dimen.ds70);
                this.gVu.setSpacing(getResources().getDimensionPixelSize(R.dimen.ds10));
                this.gVu.setSelector(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_on));
                this.gVu.setDrawable(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_off));
                this.gVu.setPosition(0.0f);
                if (this.gVz <= 1) {
                    this.gVu.setVisibility(4);
                } else {
                    this.gVu.setVisibility(0);
                }
                this.gVt.setOnScrollOutListener(this.bWd);
                this.gVt.setOnFlipOutListener(this.bWd);
                this.gVt.setOnPageChangeListener(this.gVG);
                this.gVv = findViewById(R.id.start_app);
                this.gVC = findViewById(R.id.opt_container);
                this.gVD = findViewById(R.id.img_start_game);
                this.gVD.setOnClickListener(this.mOnClickListener);
                this.gVE = findViewById(R.id.text_start_app);
                this.gVE.setOnClickListener(this.gVF);
                if (this.gVz <= 1) {
                    vM(R.dimen.ds90);
                    this.gVv.setVisibility(0);
                    this.gVv.requestFocus();
                } else {
                    this.gVv.setVisibility(8);
                }
                this.gVv.setOnClickListener(this.gVF);
                this.gVC.setVisibility(0);
                this.gVv.setVisibility(8);
                TiebaStatic.log("new_user_guide_pv");
                if (this.dve != null && this.dve.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.gVp = new a();
                    this.gVp.setSelfExecute(true);
                    this.gVp.execute(new String[0]);
                } else {
                    this.gVp = null;
                }
                TiebaStatic.log(new am("c13433").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            } catch (OutOfMemoryError e) {
                bGU();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.gVw = true;
                this.gVx = false;
                bGT();
            } catch (RuntimeException e2) {
                bGU();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.gVw = true;
                this.gVx = false;
                bGT();
            }
        } catch (RuntimeException e3) {
            this.gVw = true;
            this.gVx = false;
            bGT();
        }
    }

    private void bGS() {
        this.gVq = new ArrayList<>();
        this.gVr = new ArrayList<>();
        for (int i = 0; i < this.gVz; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            GifView gifView = (GifView) relativeLayout.findViewById(R.id.view_gif);
            ((ImageView) relativeLayout.findViewById(R.id.guide_item_img)).setVisibility(8);
            gifView.setVisibility(0);
            gifView.setGifRaw(this.gVA[i]);
            this.gVq.add(relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        if (this.dve != null && !this.dve.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            aBw();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM(int i) {
        B(this.gVv, i);
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
        bGU();
        if (this.gVp != null) {
            this.gVp.cancel(true);
            this.gVp = null;
        }
    }

    protected void bGU() {
        if (this.gVt != null) {
            this.gVt.setBackgroundDrawable(null);
        }
        if (this.gVr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gVr.size()) {
                    break;
                }
                ImageView imageView = this.gVr.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.gVB != null) {
            Iterator<Bitmap> it = this.gVB.iterator();
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
                bGT();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void aBw() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.gVw) {
            if (!this.gVx || !NewUserGuideActivityConfig.canResponse()) {
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
                bGW();
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("jump_to_new_user_guide", false);
            }
            finish();
            this.gVw = false;
        }
    }

    public void aUA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.gVH);
    }

    public void bGV() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.gVx = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void bGW() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PE() {
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
    public boolean bGX() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aC = aC(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aC == null) {
                aC = aC(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aC + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aC(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.bGX());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.PE();
            }
        }
    }

    /* loaded from: classes5.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.gVq.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.gVq.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.gVq.get(i), 0);
                return GuideActivity.this.gVq.get(i);
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
