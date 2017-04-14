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
    private ArrayList<View> dqk;
    private ArrayList<ImageView> dql;
    private b dqm;
    private BaseViewPager dqn;
    private IndicatorView dqo;
    private View dqp;
    private a dqj = null;
    private String cqm = null;
    private boolean dqq = true;
    public boolean dqr = true;
    private final int[] dqs = {w.g.bg_startpage1, w.g.bg_startpage2};
    private final int[] dqt = {w.g.bg_app_startpage1, w.g.bg_app_startpage2, w.g.bg_app_startpage3};
    private int dqu = 1;
    private int dqv = 0;
    private final ArrayList<Bitmap> dqw = new ArrayList<>();
    private final BaseViewPager.a aix = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dqx = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dqy = new c(this);
    private final HttpMessageListener dqz = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.cqm = bundle.getString("from_page");
            this.dqu = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.cqm = getIntent().getStringExtra("from_page");
            this.dqu = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.cqm)) {
            this.cqm = "";
        }
        switch (this.dqu) {
            case 3:
                this.dqv = this.dqt.length;
                break;
            default:
                this.dqv = this.dqs.length;
                break;
        }
        try {
            setContentView(w.j.guide_activity);
            Ra();
            this.dqr = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("jump_to_new_user_guide", true);
            if (this.dqr) {
                awZ();
            }
            try {
                awW();
                this.dqm = new b(this, null);
                this.dqn = (BaseViewPager) findViewById(w.h.guide_pager);
                this.dqn.setAdapter(this.dqm);
                this.dqo = (IndicatorView) findViewById(w.h.guide_page_indicator);
                this.dqo.setCount(this.dqv);
                w(this.dqo, w.f.ds40);
                if (this.dqu == 3) {
                    this.dqo.setSelector(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_on));
                    this.dqo.setDrawable(getResources().getDrawable(w.g.icon_guide_app_pagecontrol_off));
                } else {
                    this.dqo.setSelector(getResources().getDrawable(w.g.icon_guide_pagecontrol_on));
                    this.dqo.setDrawable(getResources().getDrawable(w.g.icon_guide_pagecontrol_off));
                }
                this.dqo.setPosition(0.0f);
                if (this.dqv <= 1) {
                    this.dqo.setVisibility(4);
                } else {
                    this.dqo.setVisibility(0);
                }
                this.dqn.setOnScrollOutListener(this.aix);
                this.dqn.setOnFlipOutListener(this.aix);
                this.dqn.setOnPageChangeListener(this.dqy);
                this.dqp = findViewById(w.h.start_app);
                if (this.dqu == 1 && this.dqv <= 1) {
                    mm(w.f.ds90);
                    this.dqp.setVisibility(0);
                    this.dqp.requestFocus();
                } else {
                    this.dqp.setVisibility(8);
                }
                this.dqp.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.cqm != null && this.cqm.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dqj = new a(this, null);
                    this.dqj.setSelfExecute(true);
                    this.dqj.execute(new String[0]);
                    return;
                }
                this.dqj = null;
            } catch (OutOfMemoryError e) {
                awY();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dqq = true;
                this.dqr = false;
                awX();
            } catch (RuntimeException e2) {
                awY();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dqq = true;
                this.dqr = false;
                awX();
            }
        } catch (RuntimeException e3) {
            this.dqq = true;
            this.dqr = false;
            awX();
        }
    }

    private void awW() {
        Bitmap d;
        this.dqk = new ArrayList<>();
        this.dql = new ArrayList<>();
        for (int i = 0; i < this.dqv; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(w.h.guide_item_img);
            switch (this.dqu) {
                case 3:
                    d = d(imageView, this.dqt[i]);
                    break;
                default:
                    d = d(imageView, this.dqs[i]);
                    break;
            }
            if (d == null) {
                awX();
                return;
            }
            this.dqw.add(d);
            this.dql.add(imageView);
            this.dqk.add(relativeLayout);
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
    public void awX() {
        if (this.cqm != null && !this.cqm.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Mb();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(int i) {
        w(this.dqp, i);
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
        awY();
        if (this.dqj != null) {
            this.dqj.cancel(true);
            this.dqj = null;
        }
    }

    protected void awY() {
        if (this.dqn != null) {
            this.dqn.setBackgroundDrawable(null);
        }
        if (this.dql != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dql.size()) {
                    break;
                }
                ImageView imageView = this.dql.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dqw != null) {
            Iterator<Bitmap> it = this.dqw.iterator();
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
                awX();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mb() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dqq) {
            if (!this.dqr || !NewUserGuideActivityConfig.canResponse()) {
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
                axa();
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("has_shown_app_guide", false)) {
                k.fS().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dqu == 3) {
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dqq = false;
        }
    }

    public void Ra() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dqz);
    }

    public void awZ() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void axa() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axb() {
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
    public boolean axc() {
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
            return Boolean.valueOf(GuideActivity.this.axc());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.axb();
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
            return GuideActivity.this.dqk.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dqk.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dqk.get(i), 0);
                if (i == GuideActivity.this.dqk.size() - 1) {
                    ((View) GuideActivity.this.dqk.get(i)).setOnClickListener(GuideActivity.this.dqx);
                }
                return GuideActivity.this.dqk.get(i);
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
