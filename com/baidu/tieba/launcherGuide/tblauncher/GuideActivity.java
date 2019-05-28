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
    private View gVF;
    private View gVG;
    private View gVH;
    private ArrayList<View> gVt;
    private ArrayList<ImageView> gVu;
    private b gVv;
    private BaseViewPager gVw;
    private IndicatorView gVx;
    private View gVy;
    private a gVs = null;
    private String dvf = null;
    private boolean gVz = true;
    public boolean gVA = true;
    private final int[] gVB = {R.drawable.bg_startpage_1, R.drawable.bg_startpage_2, R.drawable.bg_startpage_3, R.drawable.bg_startpage_4};
    private int gVC = 0;
    private final int[] gVD = {R.raw.ai_game_guid};
    private final ArrayList<Bitmap> gVE = new ArrayList<>();
    private final BaseViewPager.a bWd = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void is(int i) {
        }
    };
    public View.OnClickListener gVI = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.bGW();
            if (view.getId() == GuideActivity.this.gVH.getId()) {
                TiebaStatic.log(new am("c13410").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener gVJ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.gVC - 1) {
                GuideActivity.this.vM(R.dimen.ds170);
                GuideActivity.this.gVy.setVisibility(0);
                GuideActivity.this.gVx.setVisibility(0);
            } else {
                GuideActivity.this.gVy.setVisibility(8);
                GuideActivity.this.vM(R.dimen.ds120);
                GuideActivity.this.gVx.setVisibility(0);
            }
            if (GuideActivity.this.gVy.getVisibility() == 0) {
                GuideActivity.this.gVy.requestFocus();
            }
            GuideActivity.this.gVx.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener gVK = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.gVA = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.gVA = true;
                    return;
                }
                GuideActivity.this.gVA = false;
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.gVA = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.gVG.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.bGW();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.dvf = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.dvf = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.dvf)) {
            this.dvf = "";
        }
        this.gVC = this.gVD.length;
        try {
            setContentView(R.layout.guide_activity);
            aUD();
            this.gVA = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("jump_to_new_user_guide", true);
            if (this.gVA) {
                bGY();
            }
            try {
                bGV();
                this.gVv = new b();
                this.gVw = (BaseViewPager) findViewById(R.id.guide_pager);
                this.gVw.setAdapter(this.gVv);
                this.gVx = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.gVx.setCount(this.gVC);
                B(this.gVx, R.dimen.ds70);
                this.gVx.setSpacing(getResources().getDimensionPixelSize(R.dimen.ds10));
                this.gVx.setSelector(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_on));
                this.gVx.setDrawable(getResources().getDrawable(R.drawable.icon_guide_pagecontrol_off));
                this.gVx.setPosition(0.0f);
                if (this.gVC <= 1) {
                    this.gVx.setVisibility(4);
                } else {
                    this.gVx.setVisibility(0);
                }
                this.gVw.setOnScrollOutListener(this.bWd);
                this.gVw.setOnFlipOutListener(this.bWd);
                this.gVw.setOnPageChangeListener(this.gVJ);
                this.gVy = findViewById(R.id.start_app);
                this.gVF = findViewById(R.id.opt_container);
                this.gVG = findViewById(R.id.img_start_game);
                this.gVG.setOnClickListener(this.mOnClickListener);
                this.gVH = findViewById(R.id.text_start_app);
                this.gVH.setOnClickListener(this.gVI);
                if (this.gVC <= 1) {
                    vM(R.dimen.ds90);
                    this.gVy.setVisibility(0);
                    this.gVy.requestFocus();
                } else {
                    this.gVy.setVisibility(8);
                }
                this.gVy.setOnClickListener(this.gVI);
                this.gVF.setVisibility(0);
                this.gVy.setVisibility(8);
                TiebaStatic.log("new_user_guide_pv");
                if (this.dvf != null && this.dvf.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.gVs = new a();
                    this.gVs.setSelfExecute(true);
                    this.gVs.execute(new String[0]);
                } else {
                    this.gVs = null;
                }
                TiebaStatic.log(new am("c13433").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            } catch (OutOfMemoryError e) {
                bGX();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.gVz = true;
                this.gVA = false;
                bGW();
            } catch (RuntimeException e2) {
                bGX();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.gVz = true;
                this.gVA = false;
                bGW();
            }
        } catch (RuntimeException e3) {
            this.gVz = true;
            this.gVA = false;
            bGW();
        }
    }

    private void bGV() {
        this.gVt = new ArrayList<>();
        this.gVu = new ArrayList<>();
        for (int i = 0; i < this.gVC; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            GifView gifView = (GifView) relativeLayout.findViewById(R.id.view_gif);
            ((ImageView) relativeLayout.findViewById(R.id.guide_item_img)).setVisibility(8);
            gifView.setVisibility(0);
            gifView.setGifRaw(this.gVD[i]);
            this.gVt.add(relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGW() {
        if (this.dvf != null && !this.dvf.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            aBz();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM(int i) {
        B(this.gVy, i);
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
        bGX();
        if (this.gVs != null) {
            this.gVs.cancel(true);
            this.gVs = null;
        }
    }

    protected void bGX() {
        if (this.gVw != null) {
            this.gVw.setBackgroundDrawable(null);
        }
        if (this.gVu != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gVu.size()) {
                    break;
                }
                ImageView imageView = this.gVu.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.gVE != null) {
            Iterator<Bitmap> it = this.gVE.iterator();
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
                bGW();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void aBz() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.gVz) {
            if (!this.gVA || !NewUserGuideActivityConfig.canResponse()) {
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
                bGZ();
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("jump_to_new_user_guide", false);
            }
            finish();
            this.gVz = false;
        }
    }

    public void aUD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.gVK);
    }

    public void bGY() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.gVA = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void bGZ() {
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
    public boolean bHa() {
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
            return Boolean.valueOf(GuideActivity.this.bHa());
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
            return GuideActivity.this.gVt.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.gVt.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.gVt.get(i), 0);
                return GuideActivity.this.gVt.get(i);
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
