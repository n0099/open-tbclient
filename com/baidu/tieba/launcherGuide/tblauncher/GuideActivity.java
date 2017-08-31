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
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.h;
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
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> dTo;
    private ArrayList<ImageView> dTp;
    private b dTq;
    private BaseViewPager dTr;
    private IndicatorView dTs;
    private View dTt;
    private a dTn = null;
    private String bez = null;
    private boolean dTu = true;
    public boolean dTv = true;
    private final int[] dTw = {d.g.bg_startpage1, d.g.bg_startpage2, d.g.bg_startpage3, d.g.bg_startpage4};
    private final int[] dTx = {d.g.bg_app_startpage1, d.g.bg_app_startpage2};
    private int dTy = 1;
    private int dTz = 0;
    private final ArrayList<Bitmap> dTA = new ArrayList<>();
    private final BaseViewPager.a ajA = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void dc(int i) {
            if (i == 0) {
                if (GuideActivity.this.dTr != null) {
                    GuideActivity.this.dTr.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.bez.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.Le();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener dTB = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aDR();
        }
    };
    private final ViewPager.OnPageChangeListener dTC = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.dTz - 1) {
                switch (GuideActivity.this.dTy) {
                    case 1:
                        GuideActivity.this.nw(d.f.ds154);
                        GuideActivity.this.dTt.setVisibility(0);
                        GuideActivity.this.dTs.setVisibility(0);
                        break;
                    case 2:
                    default:
                        GuideActivity.this.dTt.setVisibility(8);
                        break;
                    case 3:
                        GuideActivity.this.dTt.setVisibility(8);
                        break;
                }
            } else {
                GuideActivity.this.dTt.setVisibility(8);
                GuideActivity.this.nw(d.f.ds120);
                switch (GuideActivity.this.dTy) {
                    case 1:
                        GuideActivity.this.dTs.setVisibility(0);
                        break;
                    case 3:
                        GuideActivity.this.dTs.setVisibility(0);
                        break;
                }
            }
            if (GuideActivity.this.dTt.getVisibility() == 0) {
                GuideActivity.this.dTt.requestFocus();
            }
            GuideActivity.this.dTs.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener dTD = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.dTv = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.dTv = true;
                    return;
                }
                GuideActivity.this.dTv = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.dTv = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bez = bundle.getString("from_page");
            this.dTy = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.bez = getIntent().getStringExtra("from_page");
            this.dTy = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.bez)) {
            this.bez = "";
        }
        switch (this.dTy) {
            case 3:
                this.dTz = this.dTx.length;
                break;
            default:
                this.dTz = this.dTw.length;
                break;
        }
        try {
            setContentView(d.j.guide_activity);
            Vt();
            this.dTv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.dTv) {
                aDT();
            }
            try {
                aDQ();
                this.dTq = new b();
                this.dTr = (BaseViewPager) findViewById(d.h.guide_pager);
                this.dTr.setAdapter(this.dTq);
                this.dTs = (IndicatorView) findViewById(d.h.guide_page_indicator);
                this.dTs.setCount(this.dTz);
                x(this.dTs, d.f.ds40);
                if (this.dTy == 3) {
                    this.dTs.setSelector(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_on));
                    this.dTs.setDrawable(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_off));
                } else {
                    x(this.dTs, d.f.ds70);
                    this.dTs.setSpacing(getResources().getDimensionPixelSize(d.f.ds6));
                    this.dTs.setSelector(getResources().getDrawable(d.g.icon_guide_pagecontrol_on));
                    this.dTs.setDrawable(getResources().getDrawable(d.g.icon_guide_pagecontrol_off));
                }
                this.dTs.setPosition(0.0f);
                if (this.dTz <= 1) {
                    this.dTs.setVisibility(4);
                } else {
                    this.dTs.setVisibility(0);
                }
                this.dTr.setOnScrollOutListener(this.ajA);
                this.dTr.setOnFlipOutListener(this.ajA);
                this.dTr.setOnPageChangeListener(this.dTC);
                this.dTt = findViewById(d.h.start_app);
                if (this.dTy == 1 && this.dTz <= 1) {
                    nw(d.f.ds90);
                    this.dTt.setVisibility(0);
                    this.dTt.requestFocus();
                } else {
                    this.dTt.setVisibility(8);
                }
                this.dTt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aDR();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.bez != null && this.bez.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dTn = new a();
                    this.dTn.setSelfExecute(true);
                    this.dTn.execute(new String[0]);
                    return;
                }
                this.dTn = null;
            } catch (OutOfMemoryError e) {
                aDS();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dTu = true;
                this.dTv = false;
                aDR();
            } catch (RuntimeException e2) {
                aDS();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dTu = true;
                this.dTv = false;
                aDR();
            }
        } catch (RuntimeException e3) {
            this.dTu = true;
            this.dTv = false;
            aDR();
        }
    }

    private void aDQ() {
        Bitmap d;
        this.dTo = new ArrayList<>();
        this.dTp = new ArrayList<>();
        for (int i = 0; i < this.dTz; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.h.guide_item_img);
            switch (this.dTy) {
                case 3:
                    d = d(imageView, this.dTx[i]);
                    break;
                default:
                    d = d(imageView, this.dTw[i]);
                    break;
            }
            if (d == null) {
                aDR();
                return;
            }
            this.dTA.add(d);
            this.dTp.add(imageView);
            this.dTo.add(relativeLayout);
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
    public void aDR() {
        if (this.bez != null && !this.bez.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Le();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw(int i) {
        x(this.dTt, i);
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
        aDS();
        if (this.dTn != null) {
            this.dTn.cancel(true);
            this.dTn = null;
        }
    }

    protected void aDS() {
        if (this.dTr != null) {
            this.dTr.setBackgroundDrawable(null);
        }
        if (this.dTp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dTp.size()) {
                    break;
                }
                ImageView imageView = this.dTp.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dTA != null) {
            Iterator<Bitmap> it = this.dTA.iterator();
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
                aDR();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dTu) {
            if (!this.dTv || !NewUserGuideActivityConfig.canResponse()) {
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
                aDU();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_app_guide", false)) {
                h.fR().c(new Runnable() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkApplication.getInst().setUsed();
                    }
                });
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dTy == 3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dTu = false;
        }
    }

    public void Vt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dTD);
    }

    public void aDT() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.dTv = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aDU() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDV() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(d.l.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), d.g.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDW() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String an = an(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (an == null) {
                an = an(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + an + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(d.l.app_name)}, null);
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.aDW());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aDV();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dTo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dTo.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dTo.get(i), 0);
                if (i == GuideActivity.this.dTo.size() - 1) {
                    ((View) GuideActivity.this.dTo.get(i)).setOnClickListener(GuideActivity.this.dTB);
                }
                return GuideActivity.this.dTo.get(i);
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
