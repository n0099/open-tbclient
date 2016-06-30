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
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> djH;
    private ArrayList<ImageView> djI;
    private b djJ;
    private BaseViewPager djK;
    private IndicatorView djL;
    private View djM;
    private a djG = null;
    private String clB = null;
    private boolean djN = true;
    public boolean djO = true;
    private final int[] djP = {u.f.bg_startpage1, u.f.bg_startpage2};
    private final int[] djQ = {u.f.spring_guide_1, u.f.spring_guide_2, u.f.spring_guide_3, u.f.spring_guide_4};
    private final int[] djR = {u.f.bg_app_startpage1, u.f.bg_app_startpage2, u.f.bg_app_startpage3};
    private int djS = 1;
    private int djT = 0;
    private final ArrayList<Bitmap> djU = new ArrayList<>();
    private final BaseViewPager.a aao = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener djV = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener djW = new c(this);
    private final HttpMessageListener djX = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.clB = bundle.getString("from_page");
            this.djS = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.clB = getIntent().getStringExtra("from_page");
            this.djS = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.clB)) {
            this.clB = "";
        }
        if (this.djS == 2 && !com.baidu.tieba.c.a.Me().Mf()) {
            this.djS = 1;
        }
        switch (this.djS) {
            case 2:
                this.djT = this.djQ.length;
                com.baidu.tieba.c.a.Me().Mk();
                break;
            case 3:
                this.djT = this.djR.length;
                break;
            default:
                this.djT = this.djP.length;
                break;
        }
        try {
            setContentView(u.h.guide_activity);
            LK();
            this.djO = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("jump_to_new_user_guide", true);
            if (this.djO) {
                avx();
            }
            try {
                avu();
                this.djJ = new b(this, null);
                this.djK = (BaseViewPager) findViewById(u.g.guide_pager);
                this.djK.setAdapter(this.djJ);
                this.djL = (IndicatorView) findViewById(u.g.guide_page_indicator);
                this.djL.setCount(this.djT);
                if (this.djS == 3) {
                    this.djL.setSelector(getResources().getDrawable(u.f.icon_guide_app_pagecontrol_on));
                    this.djL.setDrawable(getResources().getDrawable(u.f.icon_guide_app_pagecontrol_off));
                } else {
                    this.djL.setSelector(getResources().getDrawable(u.f.icon_guide_pagecontrol_on));
                    this.djL.setDrawable(getResources().getDrawable(u.f.icon_guide_pagecontrol_off));
                }
                this.djL.setPosition(0.0f);
                if (this.djT <= 1) {
                    this.djL.setVisibility(4);
                } else {
                    this.djL.setVisibility(0);
                }
                this.djK.setOnScrollOutListener(this.aao);
                this.djK.setOnFlipOutListener(this.aao);
                this.djK.setOnPageChangeListener(this.djW);
                this.djM = findViewById(u.g.start_app);
                if (this.djS == 2) {
                    ((ImageView) this.djM).setImageDrawable(getResources().getDrawable(u.f.spring_guide_btn));
                } else if (this.djS == 1) {
                    this.djL.setVisibility(8);
                }
                this.djM.setVisibility(8);
                this.djM.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.clB != null && this.clB.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.djG = new a(this, null);
                    this.djG.setSelfExecute(true);
                    this.djG.execute(new String[0]);
                    return;
                }
                this.djG = null;
            } catch (OutOfMemoryError e) {
                avw();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.djN = true;
                this.djO = false;
                avv();
            } catch (RuntimeException e2) {
                avw();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.djN = true;
                this.djO = false;
                avv();
            }
        } catch (RuntimeException e3) {
            this.djN = true;
            this.djO = false;
            avv();
        }
    }

    private void avu() {
        Bitmap d;
        this.djH = new ArrayList<>();
        this.djI = new ArrayList<>();
        for (int i = 0; i < this.djT; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(u.g.guide_item_img);
            switch (this.djS) {
                case 2:
                    d = d(imageView, this.djQ[i]);
                    break;
                case 3:
                    d = d(imageView, this.djR[i]);
                    break;
                default:
                    d = d(imageView, this.djP[i]);
                    break;
            }
            if (d == null) {
                avv();
                return;
            }
            this.djU.add(d);
            this.djI.add(imageView);
            this.djH.add(relativeLayout);
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
    public void avv() {
        if (this.clB != null && !this.clB.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Jc();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.djM.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.bottomMargin = dimensionPixelSize;
            this.djM.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        avw();
        if (this.djG != null) {
            this.djG.cancel(true);
            this.djG = null;
        }
    }

    protected void avw() {
        if (this.djK != null) {
            this.djK.setBackgroundDrawable(null);
        }
        if (this.djI != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.djI.size()) {
                    break;
                }
                ImageView imageView = this.djI.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.djU != null) {
            Iterator<Bitmap> it = this.djU.iterator();
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
                avv();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jc() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.djN) {
            if (!this.djO || !NewUserGuideActivityConfig.canResponse()) {
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
                avy();
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("has_shown_app_guide", false)) {
                k.dN().b(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.djS == 3) {
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.djN = false;
        }
    }

    public void LK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.djX);
    }

    public void avx() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void avy() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avz() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(u.j.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), u.f.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avA() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(u.j.app_name)}, null);
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
            return Boolean.valueOf(GuideActivity.this.avA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.avz();
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
            return GuideActivity.this.djH.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.djH.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.djH.get(i), 0);
                if (i == GuideActivity.this.djH.size() - 1) {
                    ((View) GuideActivity.this.djH.get(i)).setOnClickListener(GuideActivity.this.djV);
                }
                return GuideActivity.this.djH.get(i);
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
