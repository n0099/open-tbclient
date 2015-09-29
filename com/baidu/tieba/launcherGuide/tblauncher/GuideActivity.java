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
import com.baidu.adp.lib.g.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> bSm;
    private ArrayList<ImageView> bSn;
    private b bSo;
    private BaseViewPager bSp;
    private IndicatorView bSq;
    private View bSr;
    private a bSk = null;
    private String bSl = null;
    private boolean bSs = true;
    public boolean bSt = true;
    private final int[] bSu = {i.e.bg_startpage1, i.e.bg_startpage2};
    private final ArrayList<Bitmap> bSv = new ArrayList<>();
    private final BaseViewPager.a acU = new com.baidu.tieba.launcherGuide.tblauncher.a(this);
    public View.OnClickListener bSw = new com.baidu.tieba.launcherGuide.tblauncher.b(this);
    private final ViewPager.OnPageChangeListener bSx = new c(this);
    private final HttpMessageListener bSy = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bSl = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else {
            this.bSl = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bSl)) {
            this.bSl = "";
        }
        try {
            setContentView(i.g.guide_activity);
            Hm();
            this.bSt = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("jump_to_new_user_guide", true);
            if (this.bSt) {
                aaL();
            }
            try {
                aaI();
                this.bSo = new b(this, null);
                this.bSp = (BaseViewPager) findViewById(i.f.guide_pager);
                this.bSp.setAdapter(this.bSo);
                this.bSq = (IndicatorView) findViewById(i.f.guide_page_indicator);
                this.bSq.setCount(this.bSu.length);
                this.bSq.setSelector(getResources().getDrawable(i.e.icon_guide_pagecontrol_on));
                this.bSq.setDrawable(getResources().getDrawable(i.e.icon_guide_pagecontrol_off));
                this.bSq.setPosition(0.0f);
                if (this.bSu.length <= 1) {
                    this.bSq.setVisibility(4);
                } else {
                    this.bSq.setVisibility(0);
                }
                this.bSp.setOnScrollOutListener(this.acU);
                this.bSp.setOnFlipOutListener(this.acU);
                this.bSp.setOnPageChangeListener(this.bSx);
                this.bSr = findViewById(i.f.start_app);
                this.bSr.setVisibility(8);
                this.bSr.setOnClickListener(new e(this));
                TiebaStatic.log("new_user_guide_pv");
                if (this.bSl != null && this.bSl.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.bSk = new a(this, null);
                    this.bSk.setSelfExecute(true);
                    this.bSk.execute(new String[0]);
                    return;
                }
                this.bSk = null;
            } catch (OutOfMemoryError e) {
                aaK();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.bSs = true;
                this.bSt = false;
                aaJ();
            } catch (RuntimeException e2) {
                aaK();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.bSs = true;
                this.bSt = false;
                aaJ();
            }
        } catch (RuntimeException e3) {
            this.bSs = true;
            this.bSt = false;
            aaJ();
        }
    }

    private void aaI() {
        this.bSm = new ArrayList<>();
        this.bSn = new ArrayList<>();
        for (int i = 0; i < this.bSu.length; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(i.f.guide_item_img);
            Bitmap e = e(imageView, this.bSu[i]);
            if (e == null) {
                aaJ();
                return;
            }
            this.bSv.add(e);
            this.bSn.add(imageView);
            this.bSm.add(relativeLayout);
        }
    }

    private Bitmap e(ImageView imageView, int i) {
        Bitmap f = com.baidu.tbadk.core.util.c.f(getPageContext().getPageActivity(), i);
        if (f == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            options.inSampleSize = 4;
            f = com.baidu.tbadk.core.util.c.a(getPageContext().getPageActivity(), i, options);
        }
        if (f != null) {
            imageView.setImageBitmap(f);
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaJ() {
        if (this.bSl != null && !this.bSl.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            FY();
        }
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aaK();
        if (this.bSk != null) {
            this.bSk.cancel(true);
            this.bSk = null;
        }
    }

    protected void aaK() {
        if (this.bSp != null) {
            this.bSp.setBackgroundDrawable(null);
        }
        if (this.bSn != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bSn.size()) {
                    break;
                }
                ImageView imageView = this.bSn.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.bSv != null) {
            Iterator<Bitmap> it = this.bSv.iterator();
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
                aaJ();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FY() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.bSs) {
            if (!this.bSt) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
            } else {
                aaM();
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                k.hh().b(new f(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            finish();
            this.bSs = false;
        }
    }

    public void Hm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.bSy);
    }

    public void aaL() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    public void aaM() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaN() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(i.h.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), i.e.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaO() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(i.h.app_name)}, null);
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
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.aaO());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aaN();
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
            return GuideActivity.this.bSm.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.bSm.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.bSm.get(i), 0);
                if (i == GuideActivity.this.bSm.size() - 1) {
                    ((View) GuideActivity.this.bSm.get(i)).setOnClickListener(GuideActivity.this.bSw);
                }
                return GuideActivity.this.bSm.get(i);
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
