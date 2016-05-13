package com.baidu.tieba.launcherGuide.tblauncher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> cEh;
    private ArrayList<ImageView> cEi;
    private b cEj;
    private BaseViewPager cEk;
    private IndicatorView cEl;
    private View cEm;
    private a cEg = null;
    private String aAB = null;
    private boolean cEn = true;
    public boolean cEo = true;
    private final int[] cEp = {t.f.bg_startpage1, t.f.bg_startpage2};
    private final int[] cEq = {t.f.spring_guide_1, t.f.spring_guide_2, t.f.spring_guide_3, t.f.spring_guide_4};
    private final int[] cEr = {t.f.bg_app_startpage1, t.f.bg_app_startpage2, t.f.bg_app_startpage3};
    private int cEs = 1;
    private int cEt = 0;
    private final ArrayList<Bitmap> cEu = new ArrayList<>();
    private final BaseViewPager.a ZX = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener cEv = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener cEw = new c(this);
    private final HttpMessageListener cEx = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.aAB = bundle.getString("from_page");
            this.cEs = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.aAB = getIntent().getStringExtra("from_page");
            this.cEs = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.aAB)) {
            this.aAB = "";
        }
        if (this.cEs == 2 && !com.baidu.tieba.b.a.Lh().Li()) {
            this.cEs = 1;
        }
        switch (this.cEs) {
            case 2:
                this.cEt = this.cEq.length;
                com.baidu.tieba.b.a.Lh().Ln();
                break;
            case 3:
                this.cEt = this.cEr.length;
                break;
            default:
                this.cEt = this.cEp.length;
                break;
        }
        try {
            setContentView(t.h.guide_activity);
            KN();
            this.cEo = com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("jump_to_new_user_guide", true);
            if (this.cEo) {
                anl();
            }
            try {
                ani();
                this.cEj = new b(this, null);
                this.cEk = (BaseViewPager) findViewById(t.g.guide_pager);
                this.cEk.setAdapter(this.cEj);
                this.cEl = (IndicatorView) findViewById(t.g.guide_page_indicator);
                this.cEl.setCount(this.cEt);
                if (this.cEs == 3) {
                    this.cEl.setSelector(getResources().getDrawable(t.f.icon_guide_app_pagecontrol_on));
                    this.cEl.setDrawable(getResources().getDrawable(t.f.icon_guide_app_pagecontrol_off));
                } else {
                    this.cEl.setSelector(getResources().getDrawable(t.f.icon_guide_pagecontrol_on));
                    this.cEl.setDrawable(getResources().getDrawable(t.f.icon_guide_pagecontrol_off));
                }
                this.cEl.setPosition(0.0f);
                if (this.cEt <= 1) {
                    this.cEl.setVisibility(4);
                } else {
                    this.cEl.setVisibility(0);
                }
                this.cEk.setOnScrollOutListener(this.ZX);
                this.cEk.setOnFlipOutListener(this.ZX);
                this.cEk.setOnPageChangeListener(this.cEw);
                this.cEm = findViewById(t.g.start_app);
                if (this.cEs == 2) {
                    ((ImageView) this.cEm).setImageDrawable(getResources().getDrawable(t.f.spring_guide_btn));
                }
                this.cEm.setVisibility(8);
                this.cEm.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.aAB != null && this.aAB.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.cEg = new a(this, null);
                    this.cEg.setSelfExecute(true);
                    this.cEg.execute(new String[0]);
                    return;
                }
                this.cEg = null;
            } catch (OutOfMemoryError e) {
                ank();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.cEn = true;
                this.cEo = false;
                anj();
            } catch (RuntimeException e2) {
                ank();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.cEn = true;
                this.cEo = false;
                anj();
            }
        } catch (RuntimeException e3) {
            this.cEn = true;
            this.cEo = false;
            anj();
        }
    }

    private void ani() {
        Bitmap d;
        this.cEh = new ArrayList<>();
        this.cEi = new ArrayList<>();
        for (int i = 0; i < this.cEt; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(t.g.guide_item_img);
            switch (this.cEs) {
                case 2:
                    d = d(imageView, this.cEq[i]);
                    break;
                case 3:
                    d = d(imageView, this.cEr[i]);
                    break;
                default:
                    d = d(imageView, this.cEp[i]);
                    break;
            }
            if (d == null) {
                anj();
                return;
            }
            this.cEu.add(d);
            this.cEi.add(imageView);
            this.cEh.add(relativeLayout);
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
    public void anj() {
        if (this.aAB != null && !this.aAB.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Id();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cEm.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.bottomMargin = dimensionPixelSize;
            this.cEm.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ank();
        if (this.cEg != null) {
            this.cEg.cancel(true);
            this.cEg = null;
        }
    }

    protected void ank() {
        if (this.cEk != null) {
            this.cEk.setBackgroundDrawable(null);
        }
        if (this.cEi != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.cEi.size()) {
                    break;
                }
                ImageView imageView = this.cEi.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.cEu != null) {
            Iterator<Bitmap> it = this.cEu.iterator();
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
                anj();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Id() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.cEn) {
            if (!this.cEo || !NewUserGuideActivityConfig.canResponse()) {
                int i = TbadkCoreApplication.getCurrentAccount() == null ? 2 : 1;
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                }
            } else {
                anm();
                com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("has_shown_app_guide", false)) {
                k.dM().b(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.cEs == 3) {
                com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.cEn = false;
        }
    }

    public void KN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.cEx);
    }

    public void anl() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void anm() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ann() {
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
    public boolean ano() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(t.j.app_name)}, null);
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
            return Boolean.valueOf(GuideActivity.this.ano());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.ann();
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
            return GuideActivity.this.cEh.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.cEh.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.cEh.get(i), 0);
                if (i == GuideActivity.this.cEh.size() - 1) {
                    ((View) GuideActivity.this.cEh.get(i)).setOnClickListener(GuideActivity.this.cEv);
                }
                return GuideActivity.this.cEh.get(i);
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
