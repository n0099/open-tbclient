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
import com.baidu.adp.lib.h.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> dyo;
    private ArrayList<ImageView> dyp;
    private b dyq;
    private BaseViewPager dyr;
    private IndicatorView dys;
    private View dyt;
    private a dyn = null;
    private String cyZ = null;
    private boolean dyu = true;
    public boolean dyv = true;
    private final int[] dyw = {t.f.bg_startpage1, t.f.bg_startpage2, t.f.bg_startpage3};
    private final int[] dyx = new int[0];
    private final int[] dyy = {t.f.bg_app_startpage1, t.f.bg_app_startpage2, t.f.bg_app_startpage3};
    private int dyz = 1;
    private int dyA = 0;
    private final ArrayList<Bitmap> dyB = new ArrayList<>();
    private final BaseViewPager.a adH = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dyC = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dyD = new c(this);
    private final HttpMessageListener dyE = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.cyZ = bundle.getString("from_page");
            this.dyz = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.cyZ = getIntent().getStringExtra("from_page");
            this.dyz = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.cyZ)) {
            this.cyZ = "";
        }
        if (this.dyz == 2 && !com.baidu.tieba.d.a.OI().OJ()) {
            this.dyz = 1;
        }
        switch (this.dyz) {
            case 2:
                this.dyA = this.dyx.length;
                com.baidu.tieba.d.a.OI().OO();
                break;
            case 3:
                this.dyA = this.dyy.length;
                break;
            default:
                this.dyA = this.dyw.length;
                break;
        }
        try {
            setContentView(t.h.guide_activity);
            Oo();
            this.dyv = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("jump_to_new_user_guide", true);
            if (this.dyv) {
                aAW();
            }
            try {
                aAT();
                this.dyq = new b(this, null);
                this.dyr = (BaseViewPager) findViewById(t.g.guide_pager);
                this.dyr.setAdapter(this.dyq);
                this.dys = (IndicatorView) findViewById(t.g.guide_page_indicator);
                this.dys.setCount(this.dyA);
                if (this.dyz == 3) {
                    this.dys.setSelector(getResources().getDrawable(t.f.icon_guide_app_pagecontrol_on));
                    this.dys.setDrawable(getResources().getDrawable(t.f.icon_guide_app_pagecontrol_off));
                } else {
                    this.dys.setSelector(getResources().getDrawable(t.f.icon_guide_pagecontrol_on));
                    this.dys.setDrawable(getResources().getDrawable(t.f.icon_guide_pagecontrol_off));
                }
                this.dys.setPosition(0.0f);
                if (this.dyA <= 1) {
                    this.dys.setVisibility(4);
                } else {
                    this.dys.setVisibility(0);
                }
                this.dyr.setOnScrollOutListener(this.adH);
                this.dyr.setOnFlipOutListener(this.adH);
                this.dyr.setOnPageChangeListener(this.dyD);
                this.dyt = findViewById(t.g.start_app);
                if (this.dyz != 2 && this.dyz == 1) {
                    this.dys.setVisibility(0);
                    x(this.dys, t.e.ds40);
                }
                this.dyt.setVisibility(8);
                this.dyt.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.cyZ != null && this.cyZ.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dyn = new a(this, null);
                    this.dyn.setSelfExecute(true);
                    this.dyn.execute(new String[0]);
                    return;
                }
                this.dyn = null;
            } catch (OutOfMemoryError e) {
                aAV();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dyu = true;
                this.dyv = false;
                aAU();
            } catch (RuntimeException e2) {
                aAV();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dyu = true;
                this.dyv = false;
                aAU();
            }
        } catch (RuntimeException e3) {
            this.dyu = true;
            this.dyv = false;
            aAU();
        }
    }

    private void aAT() {
        Bitmap d;
        this.dyo = new ArrayList<>();
        this.dyp = new ArrayList<>();
        for (int i = 0; i < this.dyA; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(t.g.guide_item_img);
            switch (this.dyz) {
                case 2:
                    d = d(imageView, this.dyx[i]);
                    break;
                case 3:
                    d = d(imageView, this.dyy[i]);
                    break;
                default:
                    d = d(imageView, this.dyw[i]);
                    break;
            }
            if (d == null) {
                aAU();
                return;
            }
            this.dyB.add(d);
            this.dyp.add(imageView);
            this.dyo.add(relativeLayout);
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
    public void aAU() {
        if (this.cyZ != null && !this.cyZ.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            LD();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv(int i) {
        x(this.dyt, i);
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
        aAV();
        if (this.dyn != null) {
            this.dyn.cancel(true);
            this.dyn = null;
        }
    }

    protected void aAV() {
        if (this.dyr != null) {
            this.dyr.setBackgroundDrawable(null);
        }
        if (this.dyp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dyp.size()) {
                    break;
                }
                ImageView imageView = this.dyp.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dyB != null) {
            Iterator<Bitmap> it = this.dyB.iterator();
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
                aAU();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LD() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dyu) {
            if (!this.dyv || !NewUserGuideActivityConfig.canResponse()) {
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
                aAX();
                com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("has_shown_app_guide", false)) {
                k.eH().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dyz == 3) {
                com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dyu = false;
        }
    }

    public void Oo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dyE);
    }

    public void aAW() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aAX() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAY() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(t.j.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), t.f.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAZ() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String O = O(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (O == null) {
                O = O(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + O + "/favorites?notify=true"), new String[]{VrPlayerActivityConfig.TITLE, "iconResource"}, "title=?", new String[]{getPageContext().getString(t.j.app_name)}, null);
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

    private String O(Context context, String str) {
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
            return Boolean.valueOf(GuideActivity.this.aAZ());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aAY();
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
            return GuideActivity.this.dyo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dyo.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dyo.get(i), 0);
                if (i == GuideActivity.this.dyo.size() - 1) {
                    ((View) GuideActivity.this.dyo.get(i)).setOnClickListener(GuideActivity.this.dyC);
                }
                return GuideActivity.this.dyo.get(i);
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
