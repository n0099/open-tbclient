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
    private ArrayList<View> dmG;
    private ArrayList<ImageView> dmH;
    private b dmI;
    private BaseViewPager dmJ;
    private IndicatorView dmK;
    private View dmL;
    private a dmF = null;
    private String cnQ = null;
    private boolean dmM = true;
    public boolean dmN = true;
    private final int[] dmO = {u.f.bg_startpage1, u.f.bg_startpage2};
    private final int[] dmP = new int[0];
    private final int[] dmQ = {u.f.bg_app_startpage1, u.f.bg_app_startpage2, u.f.bg_app_startpage3};
    private int dmR = 1;
    private int dmS = 0;
    private final ArrayList<Bitmap> dmT = new ArrayList<>();
    private final BaseViewPager.a aaX = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener dmU = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener dmV = new c(this);
    private final HttpMessageListener dmW = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.cnQ = bundle.getString("from_page");
            this.dmR = bundle.getInt(GuildActivityConfig.GUIDE_TYPE);
        } else if (getIntent() != null) {
            this.cnQ = getIntent().getStringExtra("from_page");
            this.dmR = getIntent().getIntExtra(GuildActivityConfig.GUIDE_TYPE, 1);
        }
        if (TextUtils.isEmpty(this.cnQ)) {
            this.cnQ = "";
        }
        if (this.dmR == 2 && !com.baidu.tieba.c.a.Md().Me()) {
            this.dmR = 1;
        }
        switch (this.dmR) {
            case 2:
                this.dmS = this.dmP.length;
                com.baidu.tieba.c.a.Md().Mj();
                break;
            case 3:
                this.dmS = this.dmQ.length;
                break;
            default:
                this.dmS = this.dmO.length;
                break;
        }
        try {
            setContentView(u.h.guide_activity);
            LJ();
            this.dmN = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("jump_to_new_user_guide", true);
            if (this.dmN) {
                awj();
            }
            try {
                awg();
                this.dmI = new b(this, null);
                this.dmJ = (BaseViewPager) findViewById(u.g.guide_pager);
                this.dmJ.setAdapter(this.dmI);
                this.dmK = (IndicatorView) findViewById(u.g.guide_page_indicator);
                this.dmK.setCount(this.dmS);
                if (this.dmR == 3) {
                    this.dmK.setSelector(getResources().getDrawable(u.f.icon_guide_app_pagecontrol_on));
                    this.dmK.setDrawable(getResources().getDrawable(u.f.icon_guide_app_pagecontrol_off));
                } else {
                    this.dmK.setSelector(getResources().getDrawable(u.f.icon_guide_pagecontrol_on));
                    this.dmK.setDrawable(getResources().getDrawable(u.f.icon_guide_pagecontrol_off));
                }
                this.dmK.setPosition(0.0f);
                if (this.dmS <= 1) {
                    this.dmK.setVisibility(4);
                } else {
                    this.dmK.setVisibility(0);
                }
                this.dmJ.setOnScrollOutListener(this.aaX);
                this.dmJ.setOnFlipOutListener(this.aaX);
                this.dmJ.setOnPageChangeListener(this.dmV);
                this.dmL = findViewById(u.g.start_app);
                if (this.dmR != 2 && this.dmR == 1) {
                    this.dmK.setVisibility(8);
                }
                this.dmL.setVisibility(8);
                this.dmL.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.cnQ != null && this.cnQ.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.dmF = new a(this, null);
                    this.dmF.setSelfExecute(true);
                    this.dmF.execute(new String[0]);
                    return;
                }
                this.dmF = null;
            } catch (OutOfMemoryError e) {
                awi();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.dmM = true;
                this.dmN = false;
                awh();
            } catch (RuntimeException e2) {
                awi();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.dmM = true;
                this.dmN = false;
                awh();
            }
        } catch (RuntimeException e3) {
            this.dmM = true;
            this.dmN = false;
            awh();
        }
    }

    private void awg() {
        Bitmap d;
        this.dmG = new ArrayList<>();
        this.dmH = new ArrayList<>();
        for (int i = 0; i < this.dmS; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(u.g.guide_item_img);
            switch (this.dmR) {
                case 2:
                    d = d(imageView, this.dmP[i]);
                    break;
                case 3:
                    d = d(imageView, this.dmQ[i]);
                    break;
                default:
                    d = d(imageView, this.dmO[i]);
                    break;
            }
            if (d == null) {
                awh();
                return;
            }
            this.dmT.add(d);
            this.dmH.add(imageView);
            this.dmG.add(relativeLayout);
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
    public void awh() {
        if (this.cnQ != null && !this.cnQ.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            Jb();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dmL.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.bottomMargin = dimensionPixelSize;
            this.dmL.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        awi();
        if (this.dmF != null) {
            this.dmF.cancel(true);
            this.dmF = null;
        }
    }

    protected void awi() {
        if (this.dmJ != null) {
            this.dmJ.setBackgroundDrawable(null);
        }
        if (this.dmH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dmH.size()) {
                    break;
                }
                ImageView imageView = this.dmH.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.dmT != null) {
            Iterator<Bitmap> it = this.dmT.iterator();
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
                awh();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jb() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.dmM) {
            if (!this.dmN || !NewUserGuideActivityConfig.canResponse()) {
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
                awk();
                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse && com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("has_shown_app_guide", false)) {
                k.dM().e(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            if (this.dmR == 3) {
                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("has_shown_app_guide", true);
            }
            finish();
            this.dmM = false;
        }
    }

    public void LJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.dmW);
    }

    public void awj() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void awk() {
        if (NewUserGuideActivityConfig.canResponse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awl() {
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
    public boolean awm() {
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
            return Boolean.valueOf(GuideActivity.this.awm());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.awl();
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
            return GuideActivity.this.dmG.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.dmG.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.dmG.get(i), 0);
                if (i == GuideActivity.this.dmG.size() - 1) {
                    ((View) GuideActivity.this.dmG.get(i)).setOnClickListener(GuideActivity.this.dmU);
                }
                return GuideActivity.this.dmG.get(i);
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
