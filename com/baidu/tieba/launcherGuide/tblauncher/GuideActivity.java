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
    private ArrayList<View> eeQ;
    private ArrayList<ImageView> eeR;
    private b eeS;
    private BaseViewPager eeT;
    private IndicatorView eeU;
    private View eeV;
    private a eeP = null;
    private String boU = null;
    private boolean eeW = true;
    public boolean eeX = true;
    private final int[] eeY = {d.f.bg_startpage1, d.f.bg_startpage2, d.f.bg_startpage3, d.f.bg_startpage4, d.f.bg_startpage5};
    private int eeZ = 0;
    private final ArrayList<Bitmap> efa = new ArrayList<>();
    private final BaseViewPager.a ajB = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void da(int i) {
            if (i == 0) {
                if (GuideActivity.this.eeT != null) {
                    GuideActivity.this.eeT.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.boU.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.Mp();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, d.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener efb = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aGc();
        }
    };
    private final ViewPager.OnPageChangeListener efc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.eeZ - 1) {
                GuideActivity.this.od(d.e.ds170);
                GuideActivity.this.eeV.setVisibility(0);
                GuideActivity.this.eeU.setVisibility(0);
            } else {
                GuideActivity.this.eeV.setVisibility(8);
                GuideActivity.this.od(d.e.ds120);
                GuideActivity.this.eeU.setVisibility(0);
            }
            if (GuideActivity.this.eeV.getVisibility() == 0) {
                GuideActivity.this.eeV.requestFocus();
            }
            GuideActivity.this.eeU.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener efd = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.eeX = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.eeX = true;
                    return;
                }
                GuideActivity.this.eeX = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.eeX = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.boU = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.boU = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.boU)) {
            this.boU = "";
        }
        this.eeZ = this.eeY.length;
        try {
            setContentView(d.h.guide_activity);
            aac();
            this.eeX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.eeX) {
                aGe();
            }
            try {
                aGb();
                this.eeS = new b();
                this.eeT = (BaseViewPager) findViewById(d.g.guide_pager);
                this.eeT.setAdapter(this.eeS);
                this.eeU = (IndicatorView) findViewById(d.g.guide_page_indicator);
                this.eeU.setCount(this.eeZ);
                s(this.eeU, d.e.ds68);
                this.eeU.setSpacing(getResources().getDimensionPixelSize(d.e.ds6));
                this.eeU.setSelector(getResources().getDrawable(d.f.icon_guide_pagecontrol_on));
                this.eeU.setDrawable(getResources().getDrawable(d.f.icon_guide_pagecontrol_off));
                this.eeU.setPosition(0.0f);
                if (this.eeZ <= 1) {
                    this.eeU.setVisibility(4);
                } else {
                    this.eeU.setVisibility(0);
                }
                this.eeT.setOnScrollOutListener(this.ajB);
                this.eeT.setOnFlipOutListener(this.ajB);
                this.eeT.setOnPageChangeListener(this.efc);
                this.eeV = findViewById(d.g.start_app);
                if (this.eeZ <= 1) {
                    od(d.e.ds90);
                    this.eeV.setVisibility(0);
                    this.eeV.requestFocus();
                } else {
                    this.eeV.setVisibility(8);
                }
                this.eeV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aGc();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.boU != null && this.boU.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.eeP = new a();
                    this.eeP.setSelfExecute(true);
                    this.eeP.execute(new String[0]);
                    return;
                }
                this.eeP = null;
            } catch (OutOfMemoryError e) {
                aGd();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.eeW = true;
                this.eeX = false;
                aGc();
            } catch (RuntimeException e2) {
                aGd();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.eeW = true;
                this.eeX = false;
                aGc();
            }
        } catch (RuntimeException e3) {
            this.eeW = true;
            this.eeX = false;
            aGc();
        }
    }

    private void aGb() {
        this.eeQ = new ArrayList<>();
        this.eeR = new ArrayList<>();
        for (int i = 0; i < this.eeZ; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(d.g.guide_item_img);
            Bitmap d = d(imageView, this.eeY[i]);
            if (d == null) {
                aGc();
                return;
            }
            this.efa.add(d);
            this.eeR.add(imageView);
            this.eeQ.add(relativeLayout);
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
    public void aGc() {
        if (this.boU != null && !this.boU.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Mp();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void od(int i) {
        s(this.eeV, i);
    }

    private void s(View view, int i) {
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
        aGd();
        if (this.eeP != null) {
            this.eeP.cancel(true);
            this.eeP = null;
        }
    }

    protected void aGd() {
        if (this.eeT != null) {
            this.eeT.setBackgroundDrawable(null);
        }
        if (this.eeR != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eeR.size()) {
                    break;
                }
                ImageView imageView = this.eeR.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.efa != null) {
            Iterator<Bitmap> it = this.efa.iterator();
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
                aGc();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.eeW) {
            if (!this.eeX || !NewUserGuideActivityConfig.canResponse()) {
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
                aGf();
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
            this.eeW = false;
        }
    }

    public void aac() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.efd);
    }

    public void aGe() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.eeX = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aGf() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGg() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(d.j.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), d.f.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGh() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String ai = ai(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (ai == null) {
                ai = ai(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + ai + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(d.j.app_name)}, null);
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

    private String ai(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.aGh());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aGg();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.eeQ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.eeQ.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.eeQ.get(i), 0);
                if (i == GuideActivity.this.eeQ.size() - 1) {
                    ((View) GuideActivity.this.eeQ.get(i)).setOnClickListener(GuideActivity.this.efb);
                }
                return GuideActivity.this.eeQ.get(i);
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
