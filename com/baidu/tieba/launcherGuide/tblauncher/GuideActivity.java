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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> fch;
    private ArrayList<ImageView> fci;
    private b fcj;
    private BaseViewPager fck;
    private IndicatorView fcl;
    private View fcm;
    private a fcg = null;
    private String bQf = null;
    private boolean fcn = true;
    public boolean fco = true;
    private final int[] fcp = new int[0];
    private int fcq = 0;
    private final ArrayList<Bitmap> fcr = new ArrayList<>();
    private final BaseViewPager.a aBl = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void dz(int i) {
            if (i == 0) {
                if (GuideActivity.this.fck != null) {
                    GuideActivity.this.fck.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.bQf.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.UG();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, e.a.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener fcs = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.aWe();
        }
    };
    private final ViewPager.OnPageChangeListener fct = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.fcq - 1) {
                GuideActivity.this.pX(e.C0175e.ds170);
                GuideActivity.this.fcm.setVisibility(0);
                GuideActivity.this.fcl.setVisibility(0);
            } else {
                GuideActivity.this.fcm.setVisibility(8);
                GuideActivity.this.pX(e.C0175e.ds120);
                GuideActivity.this.fcl.setVisibility(0);
            }
            if (GuideActivity.this.fcm.getVisibility() == 0) {
                GuideActivity.this.fcm.requestFocus();
            }
            GuideActivity.this.fcl.setPosition(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener fcu = new HttpMessageListener(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.fco = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.fco = true;
                    return;
                }
                GuideActivity.this.fco = false;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            } else {
                GuideActivity.this.fco = false;
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bQf = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.bQf = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bQf)) {
            this.bQf = "";
        }
        this.fcq = this.fcp.length;
        try {
            setContentView(e.h.guide_activity);
            amx();
            this.fco = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("jump_to_new_user_guide", true);
            if (this.fco) {
                aWg();
            }
            try {
                aWd();
                this.fcj = new b();
                this.fck = (BaseViewPager) findViewById(e.g.guide_pager);
                this.fck.setAdapter(this.fcj);
                this.fcl = (IndicatorView) findViewById(e.g.guide_page_indicator);
                this.fcl.setCount(this.fcq);
                t(this.fcl, e.C0175e.ds70);
                this.fcl.setSpacing(getResources().getDimensionPixelSize(e.C0175e.ds10));
                this.fcl.setSelector(getResources().getDrawable(e.f.icon_guide_pagecontrol_on));
                this.fcl.setDrawable(getResources().getDrawable(e.f.icon_guide_pagecontrol_off));
                this.fcl.setPosition(0.0f);
                if (this.fcq <= 1) {
                    this.fcl.setVisibility(4);
                } else {
                    this.fcl.setVisibility(0);
                }
                this.fck.setOnScrollOutListener(this.aBl);
                this.fck.setOnFlipOutListener(this.aBl);
                this.fck.setOnPageChangeListener(this.fct);
                this.fcm = findViewById(e.g.start_app);
                if (this.fcq <= 1) {
                    pX(e.C0175e.ds90);
                    this.fcm.setVisibility(0);
                    this.fcm.requestFocus();
                } else {
                    this.fcm.setVisibility(8);
                }
                this.fcm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        GuideActivity.this.aWe();
                    }
                });
                TiebaStatic.log("new_user_guide_pv");
                if (this.bQf != null && this.bQf.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.fcg = new a();
                    this.fcg.setSelfExecute(true);
                    this.fcg.execute(new String[0]);
                    return;
                }
                this.fcg = null;
            } catch (OutOfMemoryError e) {
                aWf();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.fcn = true;
                this.fco = false;
                aWe();
            } catch (RuntimeException e2) {
                aWf();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.fcn = true;
                this.fco = false;
                aWe();
            }
        } catch (RuntimeException e3) {
            this.fcn = true;
            this.fco = false;
            aWe();
        }
    }

    private void aWd() {
        this.fch = new ArrayList<>();
        this.fci = new ArrayList<>();
        for (int i = 0; i < this.fcq; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(e.g.guide_item_img);
            Bitmap d = d(imageView, this.fcp[i]);
            if (d == null) {
                aWe();
                return;
            }
            this.fcr.add(d);
            this.fci.add(imageView);
            this.fch.add(relativeLayout);
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
    public void aWe() {
        if (this.bQf != null && !this.bQf.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            UG();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(int i) {
        t(this.fcm, i);
    }

    private void t(View view, int i) {
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
        aWf();
        if (this.fcg != null) {
            this.fcg.cancel(true);
            this.fcg = null;
        }
    }

    protected void aWf() {
        if (this.fck != null) {
            this.fck.setBackgroundDrawable(null);
        }
        if (this.fci != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fci.size()) {
                    break;
                }
                ImageView imageView = this.fci.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.fcr != null) {
            Iterator<Bitmap> it = this.fcr.iterator();
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
                aWe();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UG() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.fcn) {
            if (!this.fco || !NewUserGuideActivityConfig.canResponse()) {
                int i = TbadkCoreApplication.getCurrentAccount() == null ? 2 : 1;
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    if (!TbadkCoreApplication.isLogin()) {
                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    } else {
                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                    }
                }
            } else {
                aWh();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("jump_to_new_user_guide", false);
            }
            finish();
            this.fcn = false;
        }
    }

    public void amx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.fcu);
    }

    public void aWg() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.fco = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aWh() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWi() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(e.j.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), e.f.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWj() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aC = aC(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aC == null) {
                aC = aC(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aC + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(e.j.app_name)}, null);
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

    private String aC(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.aWj());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aWi();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return GuideActivity.this.fch.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.fch.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.fch.get(i), 0);
                if (i == GuideActivity.this.fch.size() - 1) {
                    ((View) GuideActivity.this.fch.get(i)).setOnClickListener(GuideActivity.this.fcs);
                }
                return GuideActivity.this.fch.get(i);
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
