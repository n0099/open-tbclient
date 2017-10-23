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
    private ArrayList<View> dQe;
    private ArrayList<ImageView> dQf;
    private b dQg;
    private BaseViewPager dQh;
    private IndicatorView dQi;
    private View dQj;
    private a dQd = null;
    private String bfV = null;
    private boolean dQk = true;
    public boolean dQl = true;
    private final int[] dQm = {d.g.bg_startpage1, d.g.bg_startpage2, d.g.bg_startpage3, d.g.bg_startpage4, d.g.bg_startpage5};
    private int dQn = 0;
    private final ArrayList<Bitmap> dQo = new ArrayList<>();
    private final BaseViewPager.a aiP = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void cZ(int i) {
            if (i == 0) {
                if (GuideActivity.this.dQh != null) {
                    GuideActivity.this.dQh.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.bfV.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.Lq();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener dQp = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aCN();
        }
    };
    private final ViewPager.OnPageChangeListener dQq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.dQn - 1) {
                GuideActivity.this.nt(d.f.ds154);
                GuideActivity.this.dQj.setVisibility(0);
                GuideActivity.this.dQi.setVisibility(0);
            } else {
                GuideActivity.this.dQj.setVisibility(8);
                GuideActivity.this.nt(d.f.ds120);
                GuideActivity.this.dQi.setVisibility(0);
            }
            if (GuideActivity.this.dQj.getVisibility() == 0) {
                GuideActivity.this.dQj.requestFocus();
            }
            GuideActivity.this.dQi.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener dQr = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.dQl = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.dQl = true;
                    return;
                }
                GuideActivity.this.dQl = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.dQl = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bfV = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.bfV = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bfV)) {
            this.bfV = "";
        }
        this.dQn = this.dQm.length;
        try {
            setContentView(d.j.guide_activity);
            VU();
            this.dQl = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.dQl) {
                aCP();
            }
            try {
                aCM();
                this.dQg = new b();
                this.dQh = (BaseViewPager) findViewById(d.h.guide_pager);
                this.dQh.setAdapter(this.dQg);
                this.dQi = (IndicatorView) findViewById(d.h.guide_page_indicator);
                this.dQi.setCount(this.dQn);
                v(this.dQi, d.f.ds70);
                this.dQi.setSpacing(getResources().getDimensionPixelSize(d.f.ds6));
                this.dQi.setSelector(getResources().getDrawable(d.g.icon_guide_pagecontrol_on));
                this.dQi.setDrawable(getResources().getDrawable(d.g.icon_guide_pagecontrol_off));
                this.dQi.setPosition(0.0f);
                if (this.dQn <= 1) {
                    this.dQi.setVisibility(4);
                } else {
                    this.dQi.setVisibility(0);
                }
                this.dQh.setOnScrollOutListener(this.aiP);
                this.dQh.setOnFlipOutListener(this.aiP);
                this.dQh.setOnPageChangeListener(this.dQq);
                this.dQj = findViewById(d.h.start_app);
                if (this.dQn <= 1) {
                    nt(d.f.ds90);
                    this.dQj.setVisibility(0);
                    this.dQj.requestFocus();
                } else {
                    this.dQj.setVisibility(8);
                }
                this.dQj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aCN();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.bfV != null && this.bfV.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dQd = new a();
                    this.dQd.setSelfExecute(true);
                    this.dQd.execute(new String[0]);
                    return;
                }
                this.dQd = null;
            } catch (OutOfMemoryError e) {
                aCO();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dQk = true;
                this.dQl = false;
                aCN();
            } catch (RuntimeException e2) {
                aCO();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dQk = true;
                this.dQl = false;
                aCN();
            }
        } catch (RuntimeException e3) {
            this.dQk = true;
            this.dQl = false;
            aCN();
        }
    }

    private void aCM() {
        this.dQe = new ArrayList<>();
        this.dQf = new ArrayList<>();
        for (int i = 0; i < this.dQn; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.h.guide_item_img);
            Bitmap d = d(imageView, this.dQm[i]);
            if (d == null) {
                aCN();
                return;
            }
            this.dQo.add(d);
            this.dQf.add(imageView);
            this.dQe.add(relativeLayout);
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
    public void aCN() {
        if (this.bfV != null && !this.bfV.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Lq();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(int i) {
        v(this.dQj, i);
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
        aCO();
        if (this.dQd != null) {
            this.dQd.cancel(true);
            this.dQd = null;
        }
    }

    protected void aCO() {
        if (this.dQh != null) {
            this.dQh.setBackgroundDrawable(null);
        }
        if (this.dQf != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dQf.size()) {
                    break;
                }
                ImageView imageView = this.dQf.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dQo != null) {
            Iterator<Bitmap> it = this.dQo.iterator();
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
                aCN();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dQk) {
            if (!this.dQl || !NewUserGuideActivityConfig.canResponse()) {
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
                aCQ();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                h.fQ().c(new Runnable() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkApplication.getInst().setUsed();
                    }
                });
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            finish();
            this.dQk = false;
        }
    }

    public void VU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dQr);
    }

    public void aCP() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.dQl = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aCQ() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCR() {
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
    public boolean aCS() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String ak = ak(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (ak == null) {
                ak = ak(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + ak + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(d.l.app_name)}, null);
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

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.aCS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aCR();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dQe.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dQe.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dQe.get(i), 0);
                if (i == GuideActivity.this.dQe.size() - 1) {
                    ((View) GuideActivity.this.dQe.get(i)).setOnClickListener(GuideActivity.this.dQp);
                }
                return GuideActivity.this.dQe.get(i);
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
