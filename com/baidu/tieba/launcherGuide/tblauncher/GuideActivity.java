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
    private ArrayList<View> dJo;
    private ArrayList<ImageView> dJp;
    private b dJq;
    private BaseViewPager dJr;
    private IndicatorView dJs;
    private View dJt;
    private a dJn = null;
    private String bdp = null;
    private boolean dJu = true;
    public boolean dJv = true;
    private final int[] dJw = {d.g.bg_startpage1, d.g.bg_startpage2, d.g.bg_startpage3, d.g.bg_startpage4};
    private final int[] dJx = {d.g.bg_app_startpage1, d.g.bg_app_startpage2};
    private int dJy = 1;
    private int dJz = 0;
    private final ArrayList<Bitmap> dJA = new ArrayList<>();
    private final BaseViewPager.a aiL = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void cZ(int i) {
            if (i == 0) {
                if (GuideActivity.this.dJr != null) {
                    GuideActivity.this.dJr.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.bdp.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.KP();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener dJB = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aBp();
        }
    };
    private final ViewPager.OnPageChangeListener dJC = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.dJz - 1) {
                switch (GuideActivity.this.dJy) {
                    case 1:
                        GuideActivity.this.mU(d.f.ds154);
                        GuideActivity.this.dJt.setVisibility(0);
                        GuideActivity.this.dJs.setVisibility(0);
                        break;
                    case 2:
                    default:
                        GuideActivity.this.dJt.setVisibility(8);
                        break;
                    case 3:
                        GuideActivity.this.dJt.setVisibility(8);
                        break;
                }
            } else {
                GuideActivity.this.dJt.setVisibility(8);
                GuideActivity.this.mU(d.f.ds120);
                switch (GuideActivity.this.dJy) {
                    case 1:
                        GuideActivity.this.dJs.setVisibility(0);
                        break;
                    case 3:
                        GuideActivity.this.dJs.setVisibility(0);
                        break;
                }
            }
            if (GuideActivity.this.dJt.getVisibility() == 0) {
                GuideActivity.this.dJt.requestFocus();
            }
            GuideActivity.this.dJs.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener dJD = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.dJv = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.dJv = true;
                    return;
                }
                GuideActivity.this.dJv = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.dJv = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bdp = bundle.getString("from_page");
            this.dJy = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.bdp = getIntent().getStringExtra("from_page");
            this.dJy = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.bdp)) {
            this.bdp = "";
        }
        switch (this.dJy) {
            case 3:
                this.dJz = this.dJx.length;
                break;
            default:
                this.dJz = this.dJw.length;
                break;
        }
        try {
            setContentView(d.j.guide_activity);
            Ui();
            this.dJv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.dJv) {
                aBr();
            }
            try {
                aBo();
                this.dJq = new b();
                this.dJr = (BaseViewPager) findViewById(d.h.guide_pager);
                this.dJr.setAdapter(this.dJq);
                this.dJs = (IndicatorView) findViewById(d.h.guide_page_indicator);
                this.dJs.setCount(this.dJz);
                w(this.dJs, d.f.ds40);
                if (this.dJy == 3) {
                    this.dJs.setSelector(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_on));
                    this.dJs.setDrawable(getResources().getDrawable(d.g.icon_guide_app_pagecontrol_off));
                } else {
                    w(this.dJs, d.f.ds70);
                    this.dJs.setSpacing(getResources().getDimensionPixelSize(d.f.ds6));
                    this.dJs.setSelector(getResources().getDrawable(d.g.icon_guide_pagecontrol_on));
                    this.dJs.setDrawable(getResources().getDrawable(d.g.icon_guide_pagecontrol_off));
                }
                this.dJs.setPosition(0.0f);
                if (this.dJz <= 1) {
                    this.dJs.setVisibility(4);
                } else {
                    this.dJs.setVisibility(0);
                }
                this.dJr.setOnScrollOutListener(this.aiL);
                this.dJr.setOnFlipOutListener(this.aiL);
                this.dJr.setOnPageChangeListener(this.dJC);
                this.dJt = findViewById(d.h.start_app);
                if (this.dJy == 1 && this.dJz <= 1) {
                    mU(d.f.ds90);
                    this.dJt.setVisibility(0);
                    this.dJt.requestFocus();
                } else {
                    this.dJt.setVisibility(8);
                }
                this.dJt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aBp();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.bdp != null && this.bdp.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dJn = new a();
                    this.dJn.setSelfExecute(true);
                    this.dJn.execute(new String[0]);
                    return;
                }
                this.dJn = null;
            } catch (OutOfMemoryError e) {
                aBq();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dJu = true;
                this.dJv = false;
                aBp();
            } catch (RuntimeException e2) {
                aBq();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dJu = true;
                this.dJv = false;
                aBp();
            }
        } catch (RuntimeException e3) {
            this.dJu = true;
            this.dJv = false;
            aBp();
        }
    }

    private void aBo() {
        Bitmap d;
        this.dJo = new ArrayList<>();
        this.dJp = new ArrayList<>();
        for (int i = 0; i < this.dJz; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.h.guide_item_img);
            switch (this.dJy) {
                case 3:
                    d = d(imageView, this.dJx[i]);
                    break;
                default:
                    d = d(imageView, this.dJw[i]);
                    break;
            }
            if (d == null) {
                aBp();
                return;
            }
            this.dJA.add(d);
            this.dJp.add(imageView);
            this.dJo.add(relativeLayout);
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
    public void aBp() {
        if (this.bdp != null && !this.bdp.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            KP();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(int i) {
        w(this.dJt, i);
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
        aBq();
        if (this.dJn != null) {
            this.dJn.cancel(true);
            this.dJn = null;
        }
    }

    protected void aBq() {
        if (this.dJr != null) {
            this.dJr.setBackgroundDrawable(null);
        }
        if (this.dJp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dJp.size()) {
                    break;
                }
                ImageView imageView = this.dJp.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dJA != null) {
            Iterator<Bitmap> it = this.dJA.iterator();
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
                aBp();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KP() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dJu) {
            if (!this.dJv || !NewUserGuideActivityConfig.canResponse()) {
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
                aBs();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_app_guide", false)) {
                h.fQ().e(new Runnable() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkApplication.getInst().setUsed();
                    }
                });
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dJy == 3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dJu = false;
        }
    }

    public void Ui() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dJD);
    }

    public void aBr() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.dJv = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aBs() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBt() {
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
    public boolean aBu() {
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
            return Boolean.valueOf(GuideActivity.this.aBu());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aBt();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.dJo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dJo.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dJo.get(i), 0);
                if (i == GuideActivity.this.dJo.size() - 1) {
                    ((View) GuideActivity.this.dJo.get(i)).setOnClickListener(GuideActivity.this.dJB);
                }
                return GuideActivity.this.dJo.get(i);
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
