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
    private ArrayList<View> cEp;
    private ArrayList<ImageView> cEq;
    private b cEr;
    private BaseViewPager cEs;
    private IndicatorView cEt;
    private View cEu;
    private a cEo = null;
    private String aEr = null;
    private boolean cEv = true;
    public boolean cEw = true;
    private final int[] cEx = {t.f.bg_startpage1, t.f.bg_startpage2, t.f.bg_startpage3};
    private final int[] cEy = {t.f.spring_guide_1, t.f.spring_guide_2, t.f.spring_guide_3, t.f.spring_guide_4};
    private final int[] cEz = {t.f.bg_app_startpage1, t.f.bg_app_startpage2, t.f.bg_app_startpage3};
    private int cEA = 1;
    private int cEB = 0;
    private final ArrayList<Bitmap> cEC = new ArrayList<>();
    private final BaseViewPager.a aey = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener cED = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener cEE = new c(this);
    private final HttpMessageListener cEF = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.aEr = bundle.getString("from_page");
            this.cEA = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.aEr = getIntent().getStringExtra("from_page");
            this.cEA = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.aEr)) {
            this.aEr = "";
        }
        if (this.cEA == 2 && !com.baidu.tieba.a.a.Mw().Mx()) {
            this.cEA = 1;
        }
        switch (this.cEA) {
            case 2:
                this.cEB = this.cEy.length;
                com.baidu.tieba.a.a.Mw().MC();
                break;
            case 3:
                this.cEB = this.cEz.length;
                break;
            default:
                this.cEB = this.cEx.length;
                break;
        }
        try {
            setContentView(t.h.guide_activity);
            Mc();
            this.cEw = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("jump_to_new_user_guide", true);
            if (this.cEw) {
                anm();
            }
            try {
                anj();
                this.cEr = new b(this, null);
                this.cEs = (BaseViewPager) findViewById(t.g.guide_pager);
                this.cEs.setAdapter(this.cEr);
                this.cEt = (IndicatorView) findViewById(t.g.guide_page_indicator);
                this.cEt.setCount(this.cEB);
                if (this.cEA == 3) {
                    this.cEt.setSelector(getResources().getDrawable(t.f.icon_guide_app_pagecontrol_on));
                    this.cEt.setDrawable(getResources().getDrawable(t.f.icon_guide_app_pagecontrol_off));
                } else {
                    this.cEt.setSelector(getResources().getDrawable(t.f.icon_guide_pagecontrol_on));
                    this.cEt.setDrawable(getResources().getDrawable(t.f.icon_guide_pagecontrol_off));
                }
                this.cEt.setPosition(0.0f);
                if (this.cEB <= 1) {
                    this.cEt.setVisibility(4);
                } else {
                    this.cEt.setVisibility(0);
                }
                this.cEs.setOnScrollOutListener(this.aey);
                this.cEs.setOnFlipOutListener(this.aey);
                this.cEs.setOnPageChangeListener(this.cEE);
                this.cEu = findViewById(t.g.start_app);
                if (this.cEA == 2) {
                    ((ImageView) this.cEu).setImageDrawable(getResources().getDrawable(t.f.spring_guide_btn));
                }
                this.cEu.setVisibility(8);
                this.cEu.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.aEr != null && this.aEr.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.cEo = new a(this, null);
                    this.cEo.setSelfExecute(true);
                    this.cEo.execute(new String[0]);
                    return;
                }
                this.cEo = null;
            } catch (OutOfMemoryError e) {
                anl();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.cEv = true;
                this.cEw = false;
                ank();
            } catch (RuntimeException e2) {
                anl();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.cEv = true;
                this.cEw = false;
                ank();
            }
        } catch (RuntimeException e3) {
            this.cEv = true;
            this.cEw = false;
            ank();
        }
    }

    private void anj() {
        Bitmap d;
        this.cEp = new ArrayList<>();
        this.cEq = new ArrayList<>();
        for (int i = 0; i < this.cEB; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(t.g.guide_item_img);
            switch (this.cEA) {
                case 2:
                    d = d(imageView, this.cEy[i]);
                    break;
                case 3:
                    d = d(imageView, this.cEz[i]);
                    break;
                default:
                    d = d(imageView, this.cEx[i]);
                    break;
            }
            if (d == null) {
                ank();
                return;
            }
            this.cEC.add(d);
            this.cEq.add(imageView);
            this.cEp.add(relativeLayout);
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
    public void ank() {
        if (this.aEr != null && !this.aEr.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            JK();
        }
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        anl();
        if (this.cEo != null) {
            this.cEo.cancel(true);
            this.cEo = null;
        }
    }

    protected void anl() {
        if (this.cEs != null) {
            this.cEs.setBackgroundDrawable(null);
        }
        if (this.cEq != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.cEq.size()) {
                    break;
                }
                ImageView imageView = this.cEq.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.cEC != null) {
            Iterator<Bitmap> it = this.cEC.iterator();
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
                ank();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JK() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.cEv) {
            if (!this.cEw) {
                int i = TbadkCoreApplication.getCurrentAccount() == null ? 2 : 1;
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
                }
            } else {
                ann();
                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("has_shown_app_guide", false)) {
                k.hy().b(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.cEA == 3) {
                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.cEv = false;
        }
    }

    public void Mc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.cEF);
    }

    public void anm() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void ann() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ano() {
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
    public boolean anp() {
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
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.anp());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.ano();
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
            return GuideActivity.this.cEp.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.cEp.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.cEp.get(i), 0);
                if (i == GuideActivity.this.cEp.size() - 1) {
                    ((View) GuideActivity.this.cEp.get(i)).setOnClickListener(GuideActivity.this.cED);
                }
                return GuideActivity.this.cEp.get(i);
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
