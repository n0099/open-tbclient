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
    private ArrayList<View> drL;
    private ArrayList<ImageView> drM;
    private b drN;
    private BaseViewPager drO;
    private IndicatorView drP;
    private View drQ;
    private a drK = null;
    private String crN = null;
    private boolean drR = true;
    public boolean drS = true;
    private final int[] drT = {w.g.bg_startpage1, w.g.bg_startpage2, w.g.bg_startpage3, w.g.bg_startpage4};
    private final int[] drU = {w.g.bg_app_startpage1, w.g.bg_app_startpage2, w.g.bg_app_startpage3};
    private int drV = 1;
    private int drW = 0;
    private final ArrayList<Bitmap> drX = new ArrayList<>();
    private final BaseViewPager.a aij = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener drY = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener drZ = new c(this);
    private final HttpMessageListener dsa = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.crN = bundle.getString("from_page");
            this.drV = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.crN = getIntent().getStringExtra("from_page");
            this.drV = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.crN)) {
            this.crN = "";
        }
        switch (this.drV) {
            case 3:
                this.drW = this.drU.length;
                break;
            default:
                this.drW = this.drT.length;
                break;
        }
        try {
            setContentView(w.j.guide_activity);
            QC();
            this.drS = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("jump_to_new_user_guide", true);
            if (this.drS) {
                axg();
            }
            try {
                axd();
                this.drN = new b(this, null);
                this.drO = (BaseViewPager) findViewById(w.h.guide_pager);
                this.drO.setAdapter(this.drN);
                this.drP = (IndicatorView) findViewById(w.h.guide_page_indicator);
                this.drP.setCount(this.drW);
                w(this.drP, w.f.ds40);
                if (this.drV == 3) {
                    this.drP.setSelector(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_on));
                    this.drP.setDrawable(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_off));
                } else {
                    this.drP.setSelector(getResources().getDrawable(w.g.icon_guide_pagecontrol_on));
                    this.drP.setDrawable(getResources().getDrawable(w.g.icon_guide_pagecontrol_off));
                }
                this.drP.setPosition(0.0f);
                if (this.drW <= 1) {
                    this.drP.setVisibility(4);
                } else {
                    this.drP.setVisibility(0);
                }
                this.drO.setOnScrollOutListener(this.aij);
                this.drO.setOnFlipOutListener(this.aij);
                this.drO.setOnPageChangeListener(this.drZ);
                this.drQ = findViewById(w.h.start_app);
                if (this.drV == 1 && this.drW <= 1) {
                    ml(w.f.ds90);
                    this.drQ.setVisibility(0);
                    this.drQ.requestFocus();
                } else {
                    this.drQ.setVisibility(8);
                }
                this.drQ.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.crN != null && this.crN.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.drK = new a(this, null);
                    this.drK.setSelfExecute(true);
                    this.drK.execute(new String[0]);
                    return;
                }
                this.drK = null;
            } catch (OutOfMemoryError e) {
                axf();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.drR = true;
                this.drS = false;
                axe();
            } catch (RuntimeException e2) {
                axf();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.drR = true;
                this.drS = false;
                axe();
            }
        } catch (RuntimeException e3) {
            this.drR = true;
            this.drS = false;
            axe();
        }
    }

    private void axd() {
        Bitmap d;
        this.drL = new ArrayList<>();
        this.drM = new ArrayList<>();
        for (int i = 0; i < this.drW; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(w.h.guide_item_img);
            switch (this.drV) {
                case 3:
                    d = d(imageView, this.drU[i]);
                    break;
                default:
                    d = d(imageView, this.drT[i]);
                    break;
            }
            if (d == null) {
                axe();
                return;
            }
            this.drX.add(d);
            this.drM.add(imageView);
            this.drL.add(relativeLayout);
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
    public void axe() {
        if (this.crN != null && !this.crN.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            LA();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml(int i) {
        w(this.drQ, i);
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
        axf();
        if (this.drK != null) {
            this.drK.cancel(true);
            this.drK = null;
        }
    }

    protected void axf() {
        if (this.drO != null) {
            this.drO.setBackgroundDrawable(null);
        }
        if (this.drM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.drM.size()) {
                    break;
                }
                ImageView imageView = this.drM.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.drX != null) {
            Iterator<Bitmap> it = this.drX.iterator();
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
                axe();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LA() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.drR) {
            if (!this.drS || !NewUserGuideActivityConfig.canResponse()) {
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
                axh();
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("has_shown_app_guide", false)) {
                k.fN().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.drV == 3) {
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.drR = false;
        }
    }

    public void QC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dsa);
    }

    public void axg() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void axh() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axi() {
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
    public boolean axj() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String ak = ak(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (ak == null) {
                ak = ak(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + ak + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(w.l.app_name)}, null);
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

    private String ak(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.axj());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.axi();
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
            return GuideActivity.this.drL.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.drL.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.drL.get(i), 0);
                if (i == GuideActivity.this.drL.size() - 1) {
                    ((View) GuideActivity.this.drL.get(i)).setOnClickListener(GuideActivity.this.drY);
                }
                return GuideActivity.this.drL.get(i);
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
