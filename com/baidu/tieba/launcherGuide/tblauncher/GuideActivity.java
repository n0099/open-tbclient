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
import com.baidu.adp.lib.g.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> dsB;
    private ArrayList<ImageView> dsC;
    private b dsD;
    private BaseViewPager dsE;
    private IndicatorView dsF;
    private View dsG;
    private a dsA = null;
    private String csE = null;
    private boolean dsH = true;
    public boolean dsI = true;
    private final int[] dsJ = {w.g.bg_startpage1, w.g.bg_startpage2};
    private final int[] dsK = {w.g.bg_app_startpage1, w.g.bg_app_startpage2, w.g.bg_app_startpage3};
    private int dsL = 1;
    private int dsM = 0;
    private final ArrayList<Bitmap> dsN = new ArrayList<>();
    private final BaseViewPager.a aiy = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dsO = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dsP = new c(this);
    private final HttpMessageListener dsQ = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.csE = bundle.getString("from_page");
            this.dsL = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.csE = getIntent().getStringExtra("from_page");
            this.dsL = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.csE)) {
            this.csE = "";
        }
        switch (this.dsL) {
            case 3:
                this.dsM = this.dsK.length;
                break;
            default:
                this.dsM = this.dsJ.length;
                break;
        }
        try {
            setContentView(w.j.guide_activity);
            Sc();
            this.dsI = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("jump_to_new_user_guide", true);
            if (this.dsI) {
                aya();
            }
            try {
                axX();
                this.dsD = new b(this, null);
                this.dsE = (BaseViewPager) findViewById(w.h.guide_pager);
                this.dsE.setAdapter(this.dsD);
                this.dsF = (IndicatorView) findViewById(w.h.guide_page_indicator);
                this.dsF.setCount(this.dsM);
                w(this.dsF, w.f.ds40);
                if (this.dsL == 3) {
                    this.dsF.setSelector(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_on));
                    this.dsF.setDrawable(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_off));
                } else {
                    this.dsF.setSelector(getResources().getDrawable(w.g.icon_guide_pagecontrol_on));
                    this.dsF.setDrawable(getResources().getDrawable(w.g.icon_guide_pagecontrol_off));
                }
                this.dsF.setPosition(0.0f);
                if (this.dsM <= 1) {
                    this.dsF.setVisibility(4);
                } else {
                    this.dsF.setVisibility(0);
                }
                this.dsE.setOnScrollOutListener(this.aiy);
                this.dsE.setOnFlipOutListener(this.aiy);
                this.dsE.setOnPageChangeListener(this.dsP);
                this.dsG = findViewById(w.h.start_app);
                if (this.dsL == 1 && this.dsM <= 1) {
                    ms(w.f.ds90);
                    this.dsG.setVisibility(0);
                    this.dsG.requestFocus();
                } else {
                    this.dsG.setVisibility(8);
                }
                this.dsG.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.csE != null && this.csE.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dsA = new a(this, null);
                    this.dsA.setSelfExecute(true);
                    this.dsA.execute(new String[0]);
                    return;
                }
                this.dsA = null;
            } catch (OutOfMemoryError e) {
                axZ();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dsH = true;
                this.dsI = false;
                axY();
            } catch (RuntimeException e2) {
                axZ();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dsH = true;
                this.dsI = false;
                axY();
            }
        } catch (RuntimeException e3) {
            this.dsH = true;
            this.dsI = false;
            axY();
        }
    }

    private void axX() {
        Bitmap d;
        this.dsB = new ArrayList<>();
        this.dsC = new ArrayList<>();
        for (int i = 0; i < this.dsM; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(w.h.guide_item_img);
            switch (this.dsL) {
                case 3:
                    d = d(imageView, this.dsK[i]);
                    break;
                default:
                    d = d(imageView, this.dsJ[i]);
                    break;
            }
            if (d == null) {
                axY();
                return;
            }
            this.dsN.add(d);
            this.dsC.add(imageView);
            this.dsB.add(relativeLayout);
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
    public void axY() {
        if (this.csE != null && !this.csE.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Mb();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        w(this.dsG, i);
    }

    private void w(View view, int i) {
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
        axZ();
        if (this.dsA != null) {
            this.dsA.cancel(true);
            this.dsA = null;
        }
    }

    protected void axZ() {
        if (this.dsE != null) {
            this.dsE.setBackgroundDrawable(null);
        }
        if (this.dsC != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dsC.size()) {
                    break;
                }
                ImageView imageView = this.dsC.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dsN != null) {
            Iterator<Bitmap> it = this.dsN.iterator();
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
                axY();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mb() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dsH) {
            if (!this.dsI || !NewUserGuideActivityConfig.canResponse()) {
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
                ayb();
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("has_shown_app_guide", false)) {
                k.fT().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dsL == 3) {
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dsH = false;
        }
    }

    public void Sc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dsQ);
    }

    public void aya() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void ayb() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayc() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(w.l.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), w.g.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayd() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String an = an(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (an == null) {
                an = an(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + an + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(w.l.app_name)}, null);
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

    private String an(Context context, String str) {
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
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.ayd());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.ayc();
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
            return GuideActivity.this.dsB.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dsB.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dsB.get(i), 0);
                if (i == GuideActivity.this.dsB.size() - 1) {
                    ((View) GuideActivity.this.dsB.get(i)).setOnClickListener(GuideActivity.this.dsO);
                }
                return GuideActivity.this.dsB.get(i);
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
