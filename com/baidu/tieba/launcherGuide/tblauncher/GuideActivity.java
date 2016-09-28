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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.h.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> dzG;
    private ArrayList<ImageView> dzH;
    private b dzI;
    private BaseViewPager dzJ;
    private IndicatorView dzK;
    private View dzL;
    private a dzF = null;
    private String czD = null;
    private boolean dzM = true;
    public boolean dzN = true;
    private final int[] dzO = {r.f.bg_startpage1, r.f.bg_startpage2};
    private final int[] dzP = {r.f.bg_app_startpage1, r.f.bg_app_startpage2, r.f.bg_app_startpage3};
    private int dzQ = 1;
    private int dzR = 0;
    private final ArrayList<Bitmap> dzS = new ArrayList<>();
    private final BaseViewPager.a adS = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dzT = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dzU = new c(this);
    private final HttpMessageListener dzV = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.czD = bundle.getString("from_page");
            this.dzQ = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.czD = getIntent().getStringExtra("from_page");
            this.dzQ = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.czD)) {
            this.czD = "";
        }
        switch (this.dzQ) {
            case 3:
                this.dzR = this.dzP.length;
                break;
            default:
                this.dzR = this.dzO.length;
                break;
        }
        try {
            setContentView(r.h.guide_activity);
            OQ();
            this.dzN = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("jump_to_new_user_guide", true);
            if (this.dzN) {
                aBu();
            }
            try {
                aBr();
                this.dzI = new b(this, null);
                this.dzJ = (BaseViewPager) findViewById(r.g.guide_pager);
                this.dzJ.setAdapter(this.dzI);
                this.dzK = (IndicatorView) findViewById(r.g.guide_page_indicator);
                this.dzK.setCount(this.dzR);
                if (this.dzQ == 3) {
                    this.dzK.setSelector(getResources().getDrawable(r.f.icon_guide_app_pagecontrol_on));
                    this.dzK.setDrawable(getResources().getDrawable(r.f.icon_guide_app_pagecontrol_off));
                } else {
                    this.dzK.setSelector(getResources().getDrawable(r.f.icon_guide_pagecontrol_on));
                    this.dzK.setDrawable(getResources().getDrawable(r.f.icon_guide_pagecontrol_off));
                }
                this.dzK.setPosition(0.0f);
                if (this.dzR <= 1) {
                    this.dzK.setVisibility(4);
                } else {
                    this.dzK.setVisibility(0);
                }
                this.dzJ.setOnScrollOutListener(this.adS);
                this.dzJ.setOnFlipOutListener(this.adS);
                this.dzJ.setOnPageChangeListener(this.dzU);
                this.dzL = findViewById(r.g.start_app);
                if (this.dzQ == 1) {
                    this.dzK.setVisibility(0);
                    x(this.dzK, r.e.ds70);
                    this.dzK.setSpacing(getResources().getDimensionPixelSize(r.e.ds18));
                }
                this.dzL.setVisibility(8);
                this.dzL.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.czD != null && this.czD.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dzF = new a(this, null);
                    this.dzF.setSelfExecute(true);
                    this.dzF.execute(new String[0]);
                    return;
                }
                this.dzF = null;
            } catch (OutOfMemoryError e) {
                aBt();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dzM = true;
                this.dzN = false;
                aBs();
            } catch (RuntimeException e2) {
                aBt();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dzM = true;
                this.dzN = false;
                aBs();
            }
        } catch (RuntimeException e3) {
            this.dzM = true;
            this.dzN = false;
            aBs();
        }
    }

    private void aBr() {
        Bitmap d;
        this.dzG = new ArrayList<>();
        this.dzH = new ArrayList<>();
        for (int i = 0; i < this.dzR; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(r.g.guide_item_img);
            switch (this.dzQ) {
                case 3:
                    d = d(imageView, this.dzP[i]);
                    break;
                default:
                    d = d(imageView, this.dzO[i]);
                    break;
            }
            if (d == null) {
                aBs();
                return;
            }
            this.dzS.add(d);
            this.dzH.add(imageView);
            this.dzG.add(relativeLayout);
        }
    }

    private Bitmap d(ImageView imageView, int i) {
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
    public void aBs() {
        if (this.czD != null && !this.czD.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Mh();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(int i) {
        x(this.dzL, i);
    }

    private void x(View view, int i) {
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
        aBt();
        if (this.dzF != null) {
            this.dzF.cancel(true);
            this.dzF = null;
        }
    }

    protected void aBt() {
        if (this.dzJ != null) {
            this.dzJ.setBackgroundDrawable(null);
        }
        if (this.dzH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dzH.size()) {
                    break;
                }
                ImageView imageView = this.dzH.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dzS != null) {
            Iterator<Bitmap> it = this.dzS.iterator();
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
                aBs();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dzM) {
            if (!this.dzN || !NewUserGuideActivityConfig.canResponse()) {
                int i = TbadkCoreApplication.getCurrentAccount() == null ? 2 : 1;
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    if (!TbadkCoreApplication.isLogin()) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
                    } else {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                    }
                }
            } else {
                aBv();
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("has_shown_app_guide", false)) {
                k.eH().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dzQ == 3) {
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dzM = false;
        }
    }

    public void OQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dzV);
    }

    public void aBu() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aBv() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBw() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(r.j.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), r.f.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBx() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String O = O(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (O == null) {
                O = O(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + O + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(r.j.app_name)}, null);
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

    private String O(Context context, String str) {
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

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* synthetic */ a(GuideActivity guideActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.aBx());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aBw();
            }
        }
    }

    /* loaded from: classes.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        /* synthetic */ b(GuideActivity guideActivity, b bVar) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dzG.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dzG.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dzG.get(i), 0);
                if (i == GuideActivity.this.dzG.size() - 1) {
                    ((View) GuideActivity.this.dzG.get(i)).setOnClickListener(GuideActivity.this.dzT);
                }
                return GuideActivity.this.dzG.get(i);
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
