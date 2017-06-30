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
/* loaded from: classes2.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> dAM;
    private ArrayList<ImageView> dAN;
    private b dAO;
    private BaseViewPager dAP;
    private IndicatorView dAQ;
    private View dAR;
    private a dAL = null;
    private String bcT = null;
    private boolean dAS = true;
    public boolean dAT = true;
    private final int[] dAU = {w.g.bg_startpage1, w.g.bg_startpage2, w.g.bg_startpage3, w.g.bg_startpage4};
    private final int[] dAV = {w.g.bg_app_startpage1, w.g.bg_app_startpage2};
    private int dAW = 1;
    private int dAX = 0;
    private final ArrayList<Bitmap> dAY = new ArrayList<>();
    private final BaseViewPager.a aip = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dAZ = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dBa = new c(this);
    private final HttpMessageListener dBb = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bcT = bundle.getString("from_page");
            this.dAW = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.bcT = getIntent().getStringExtra("from_page");
            this.dAW = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.bcT)) {
            this.bcT = "";
        }
        switch (this.dAW) {
            case 3:
                this.dAX = this.dAV.length;
                break;
            default:
                this.dAX = this.dAU.length;
                break;
        }
        try {
            setContentView(w.j.guide_activity);
            Ty();
            this.dAT = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.dAT) {
                azO();
            }
            try {
                azL();
                this.dAO = new b(this, null);
                this.dAP = (BaseViewPager) findViewById(w.h.guide_pager);
                this.dAP.setAdapter(this.dAO);
                this.dAQ = (IndicatorView) findViewById(w.h.guide_page_indicator);
                this.dAQ.setCount(this.dAX);
                v(this.dAQ, w.f.ds40);
                if (this.dAW == 3) {
                    this.dAQ.setSelector(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_on));
                    this.dAQ.setDrawable(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_off));
                } else {
                    v(this.dAQ, w.f.ds40);
                    this.dAQ.setSpacing(getResources().getDimensionPixelSize(w.f.ds6));
                    this.dAQ.setSelector(getResources().getDrawable(w.g.icon_guide_pagecontrol_on));
                    this.dAQ.setDrawable(getResources().getDrawable(w.g.icon_guide_pagecontrol_off));
                }
                this.dAQ.setPosition(0.0f);
                if (this.dAX <= 1) {
                    this.dAQ.setVisibility(4);
                } else {
                    this.dAQ.setVisibility(0);
                }
                this.dAP.setOnScrollOutListener(this.aip);
                this.dAP.setOnFlipOutListener(this.aip);
                this.dAP.setOnPageChangeListener(this.dBa);
                this.dAR = findViewById(w.h.start_app);
                if (this.dAW == 1 && this.dAX <= 1) {
                    mL(w.f.ds90);
                    this.dAR.setVisibility(0);
                    this.dAR.requestFocus();
                } else {
                    this.dAR.setVisibility(8);
                }
                this.dAR.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.bcT != null && this.bcT.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dAL = new a(this, null);
                    this.dAL.setSelfExecute(true);
                    this.dAL.execute(new String[0]);
                    return;
                }
                this.dAL = null;
            } catch (OutOfMemoryError e) {
                azN();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dAS = true;
                this.dAT = false;
                azM();
            } catch (RuntimeException e2) {
                azN();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dAS = true;
                this.dAT = false;
                azM();
            }
        } catch (RuntimeException e3) {
            this.dAS = true;
            this.dAT = false;
            azM();
        }
    }

    private void azL() {
        Bitmap d;
        this.dAM = new ArrayList<>();
        this.dAN = new ArrayList<>();
        for (int i = 0; i < this.dAX; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(w.h.guide_item_img);
            switch (this.dAW) {
                case 3:
                    d = d(imageView, this.dAV[i]);
                    break;
                default:
                    d = d(imageView, this.dAU[i]);
                    break;
            }
            if (d == null) {
                azM();
                return;
            }
            this.dAY.add(d);
            this.dAN.add(imageView);
            this.dAM.add(relativeLayout);
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
    public void azM() {
        if (this.bcT != null && !this.bcT.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            KI();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(int i) {
        v(this.dAR, i);
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
        azN();
        if (this.dAL != null) {
            this.dAL.cancel(true);
            this.dAL = null;
        }
    }

    protected void azN() {
        if (this.dAP != null) {
            this.dAP.setBackgroundDrawable(null);
        }
        if (this.dAN != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dAN.size()) {
                    break;
                }
                ImageView imageView = this.dAN.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dAY != null) {
            Iterator<Bitmap> it = this.dAY.iterator();
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
                azM();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KI() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dAS) {
            if (!this.dAT || !NewUserGuideActivityConfig.canResponse()) {
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
                azP();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_app_guide", false)) {
                k.fS().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dAW == 3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dAS = false;
        }
    }

    public void Ty() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dBb);
    }

    public void azO() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.dAT = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void azP() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azQ() {
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
    public boolean azR() {
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

    /* loaded from: classes2.dex */
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
            return Boolean.valueOf(GuideActivity.this.azR());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.azQ();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        /* synthetic */ b(GuideActivity guideActivity, b bVar) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dAM.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dAM.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dAM.get(i), 0);
                if (i == GuideActivity.this.dAM.size() - 1) {
                    ((View) GuideActivity.this.dAM.get(i)).setOnClickListener(GuideActivity.this.dAZ);
                }
                return GuideActivity.this.dAM.get(i);
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
