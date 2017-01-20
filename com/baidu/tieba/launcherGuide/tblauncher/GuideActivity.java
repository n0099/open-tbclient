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
    private ArrayList<View> dpr;
    private ArrayList<ImageView> dps;
    private b dpt;
    private BaseViewPager dpu;
    private IndicatorView dpv;
    private View dpw;
    private a dpq = null;
    private String cqo = null;
    private boolean dpx = true;
    public boolean dpy = true;
    private final int[] dpz = {r.g.bg_startpage1, r.g.bg_startpage2};
    private final int[] dpA = {r.g.spring_festival_image_1, r.g.spring_festival_image_2, r.g.spring_festival_image_3, r.g.spring_festival_image_4};
    private final int[] dpB = {r.g.bg_app_startpage1, r.g.bg_app_startpage2, r.g.bg_app_startpage3};
    private int dpC = 1;
    private int dpD = 0;
    private final ArrayList<Bitmap> dpE = new ArrayList<>();
    private final BaseViewPager.a acT = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dpF = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dpG = new c(this);
    private final HttpMessageListener dpH = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.cqo = bundle.getString("from_page");
            this.dpC = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.cqo = getIntent().getStringExtra("from_page");
            this.dpC = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.cqo)) {
            this.cqo = "";
        }
        if (this.dpC == 2 && !com.baidu.tieba.e.a.Tj().Tk()) {
            this.dpC = 1;
        }
        switch (this.dpC) {
            case 2:
                this.dpD = this.dpA.length;
                com.baidu.tieba.e.a.Tj().Tl();
                break;
            case 3:
                this.dpD = this.dpB.length;
                break;
            default:
                this.dpD = this.dpz.length;
                break;
        }
        try {
            setContentView(r.j.guide_activity);
            PJ();
            this.dpy = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("jump_to_new_user_guide", true);
            if (this.dpy) {
                axK();
            }
            try {
                axH();
                this.dpt = new b(this, null);
                this.dpu = (BaseViewPager) findViewById(r.h.guide_pager);
                this.dpu.setAdapter(this.dpt);
                this.dpv = (IndicatorView) findViewById(r.h.guide_page_indicator);
                this.dpv.setCount(this.dpD);
                if (this.dpC == 3) {
                    this.dpv.setSelector(getResources().getDrawable(r.g.icon_guide_app_pagecontrol_on));
                    this.dpv.setDrawable(getResources().getDrawable(r.g.icon_guide_app_pagecontrol_off));
                } else if (this.dpC == 2) {
                    this.dpv.setSelector(getResources().getDrawable(r.g.icon_guide_spring_pagecontrol_on));
                    this.dpv.setDrawable(getResources().getDrawable(r.g.icon_guide_spring_pagecontrol_off));
                } else {
                    this.dpv.setSelector(getResources().getDrawable(r.g.icon_guide_pagecontrol_on));
                    this.dpv.setDrawable(getResources().getDrawable(r.g.icon_guide_pagecontrol_off));
                }
                this.dpv.setPosition(0.0f);
                if (this.dpD <= 1) {
                    this.dpv.setVisibility(4);
                } else {
                    this.dpv.setVisibility(0);
                }
                this.dpu.setOnScrollOutListener(this.acT);
                this.dpu.setOnFlipOutListener(this.acT);
                this.dpu.setOnPageChangeListener(this.dpG);
                this.dpw = findViewById(r.h.start_app);
                if (this.dpC == 1 && this.dpD <= 1) {
                    mv(r.f.ds90);
                    this.dpw.setVisibility(0);
                    this.dpw.requestFocus();
                } else {
                    this.dpw.setVisibility(8);
                }
                this.dpw.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.cqo != null && this.cqo.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dpq = new a(this, null);
                    this.dpq.setSelfExecute(true);
                    this.dpq.execute(new String[0]);
                    return;
                }
                this.dpq = null;
            } catch (OutOfMemoryError e) {
                axJ();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dpx = true;
                this.dpy = false;
                axI();
            } catch (RuntimeException e2) {
                axJ();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dpx = true;
                this.dpy = false;
                axI();
            }
        } catch (RuntimeException e3) {
            this.dpx = true;
            this.dpy = false;
            axI();
        }
    }

    private void axH() {
        Bitmap d;
        this.dpr = new ArrayList<>();
        this.dps = new ArrayList<>();
        for (int i = 0; i < this.dpD; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(r.h.guide_item_img);
            switch (this.dpC) {
                case 2:
                    d = d(imageView, this.dpA[i]);
                    break;
                case 3:
                    d = d(imageView, this.dpB[i]);
                    break;
                default:
                    d = d(imageView, this.dpz[i]);
                    break;
            }
            if (d == null) {
                axI();
                return;
            }
            this.dpE.add(d);
            this.dps.add(imageView);
            this.dpr.add(relativeLayout);
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
    public void axI() {
        if (this.cqo != null && !this.cqo.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            KV();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv(int i) {
        w(this.dpw, i);
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
        axJ();
        if (this.dpq != null) {
            this.dpq.cancel(true);
            this.dpq = null;
        }
    }

    protected void axJ() {
        if (this.dpu != null) {
            this.dpu.setBackgroundDrawable(null);
        }
        if (this.dps != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dps.size()) {
                    break;
                }
                ImageView imageView = this.dps.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dpE != null) {
            Iterator<Bitmap> it = this.dpE.iterator();
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
                axI();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dpx) {
            if (!this.dpy || !NewUserGuideActivityConfig.canResponse()) {
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
                axL();
                com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("has_shown_app_guide", false)) {
                k.eF().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dpC == 3) {
                com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dpx = false;
        }
    }

    public void PJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dpH);
    }

    public void axK() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void axL() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axM() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(r.l.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), r.g.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axN() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String Q = Q(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (Q == null) {
                Q = Q(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + Q + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(r.l.app_name)}, null);
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

    private String Q(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.axN());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.axM();
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
            return GuideActivity.this.dpr.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dpr.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dpr.get(i), 0);
                if (i == GuideActivity.this.dpr.size() - 1) {
                    ((View) GuideActivity.this.dpr.get(i)).setOnClickListener(GuideActivity.this.dpF);
                }
                return GuideActivity.this.dpr.get(i);
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
