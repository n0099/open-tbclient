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
    private ArrayList<View> dmF;
    private ArrayList<ImageView> dmG;
    private b dmH;
    private BaseViewPager dmI;
    private IndicatorView dmJ;
    private View dmK;
    private a dmE = null;
    private String cpD = null;
    private boolean dmL = true;
    public boolean dmM = true;
    private final int[] dmN = {w.g.bg_startpage1, w.g.bg_startpage2, w.g.bg_startpage3, w.g.bg_startpage4};
    private final int[] dmO = {w.g.bg_app_startpage1, w.g.bg_app_startpage2, w.g.bg_app_startpage3};
    private int dmP = 1;
    private int dmQ = 0;
    private final ArrayList<Bitmap> dmR = new ArrayList<>();
    private final BaseViewPager.a ahQ = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dmS = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dmT = new c(this);
    private final HttpMessageListener dmU = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.cpD = bundle.getString("from_page");
            this.dmP = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.cpD = getIntent().getStringExtra("from_page");
            this.dmP = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.cpD)) {
            this.cpD = "";
        }
        switch (this.dmP) {
            case 3:
                this.dmQ = this.dmO.length;
                break;
            default:
                this.dmQ = this.dmN.length;
                break;
        }
        try {
            setContentView(w.j.guide_activity);
            Rx();
            this.dmM = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("jump_to_new_user_guide", true);
            if (this.dmM) {
                auW();
            }
            try {
                auT();
                this.dmH = new b(this, null);
                this.dmI = (BaseViewPager) findViewById(w.h.guide_pager);
                this.dmI.setAdapter(this.dmH);
                this.dmJ = (IndicatorView) findViewById(w.h.guide_page_indicator);
                this.dmJ.setCount(this.dmQ);
                v(this.dmJ, w.f.ds40);
                if (this.dmP == 3) {
                    this.dmJ.setSelector(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_on));
                    this.dmJ.setDrawable(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_off));
                } else {
                    v(this.dmJ, w.f.ds120);
                    this.dmJ.setSelector(getResources().getDrawable(w.g.icon_guide_pagecontrol_on));
                    this.dmJ.setDrawable(getResources().getDrawable(w.g.icon_guide_pagecontrol_off));
                }
                this.dmJ.setPosition(0.0f);
                if (this.dmQ <= 1) {
                    this.dmJ.setVisibility(4);
                } else {
                    this.dmJ.setVisibility(0);
                }
                this.dmI.setOnScrollOutListener(this.ahQ);
                this.dmI.setOnFlipOutListener(this.ahQ);
                this.dmI.setOnPageChangeListener(this.dmT);
                this.dmK = findViewById(w.h.start_app);
                if (this.dmP == 1 && this.dmQ <= 1) {
                    mf(w.f.ds90);
                    this.dmK.setVisibility(0);
                    this.dmK.requestFocus();
                } else {
                    this.dmK.setVisibility(8);
                }
                this.dmK.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.cpD != null && this.cpD.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dmE = new a(this, null);
                    this.dmE.setSelfExecute(true);
                    this.dmE.execute(new String[0]);
                    return;
                }
                this.dmE = null;
            } catch (OutOfMemoryError e) {
                auV();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dmL = true;
                this.dmM = false;
                auU();
            } catch (RuntimeException e2) {
                auV();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dmL = true;
                this.dmM = false;
                auU();
            }
        } catch (RuntimeException e3) {
            this.dmL = true;
            this.dmM = false;
            auU();
        }
    }

    private void auT() {
        Bitmap d;
        this.dmF = new ArrayList<>();
        this.dmG = new ArrayList<>();
        for (int i = 0; i < this.dmQ; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(w.h.guide_item_img);
            switch (this.dmP) {
                case 3:
                    d = d(imageView, this.dmO[i]);
                    break;
                default:
                    d = d(imageView, this.dmN[i]);
                    break;
            }
            if (d == null) {
                auU();
                return;
            }
            this.dmR.add(d);
            this.dmG.add(imageView);
            this.dmF.add(relativeLayout);
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
    public void auU() {
        if (this.cpD != null && !this.cpD.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Lp();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(int i) {
        v(this.dmK, i);
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
        auV();
        if (this.dmE != null) {
            this.dmE.cancel(true);
            this.dmE = null;
        }
    }

    protected void auV() {
        if (this.dmI != null) {
            this.dmI.setBackgroundDrawable(null);
        }
        if (this.dmG != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dmG.size()) {
                    break;
                }
                ImageView imageView = this.dmG.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dmR != null) {
            Iterator<Bitmap> it = this.dmR.iterator();
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
                auU();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lp() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dmL) {
            if (!this.dmM || !NewUserGuideActivityConfig.canResponse()) {
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
                auX();
                com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("has_shown_app_guide", false)) {
                k.fT().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dmP == 3) {
                com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dmL = false;
        }
    }

    public void Rx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dmU);
    }

    public void auW() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.dmM = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void auX() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auY() {
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
    public boolean auZ() {
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
            return Boolean.valueOf(GuideActivity.this.auZ());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.auY();
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
            return GuideActivity.this.dmF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dmF.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dmF.get(i), 0);
                if (i == GuideActivity.this.dmF.size() - 1) {
                    ((View) GuideActivity.this.dmF.get(i)).setOnClickListener(GuideActivity.this.dmS);
                }
                return GuideActivity.this.dmF.get(i);
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
