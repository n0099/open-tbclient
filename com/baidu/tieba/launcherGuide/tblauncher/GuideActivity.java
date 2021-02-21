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
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> kYW;
    private ArrayList<ImageView> kYX;
    private b kYY;
    private BaseViewPager kYZ;
    private IndicatorView kZa;
    private View kZb;
    private View kZi;
    private View kZj;
    private View kZk;
    private a kYV = null;
    private String mFromPage = null;
    private boolean kZc = true;
    public boolean kZd = true;
    private final int[] kZe = {R.drawable.android_guide_1, R.drawable.android_guide_2, R.drawable.android_guide_3};
    private int kZf = 0;
    private final int[] kZg = new int[0];
    private final ArrayList<Bitmap> kZh = new ArrayList<>();
    private final BaseViewPager.a feP = new BaseViewPager.a() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.1
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                if (GuideActivity.this.kYZ != null) {
                    GuideActivity.this.kYZ.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.bLd();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, R.anim.left);
                GuideActivity.this.closeActivity();
            }
        }
    };
    public View.OnClickListener kZl = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.dbd();
            if (view.getId() == GuideActivity.this.kZk.getId()) {
                TiebaStatic.log(new ar("c13410").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private final ViewPager.OnPageChangeListener kZm = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.kZf - 1) {
                GuideActivity.this.DN(R.dimen.tbds170);
                GuideActivity.this.kZb.setVisibility(0);
                GuideActivity.this.kZa.setVisibility(0);
            } else {
                GuideActivity.this.kZb.setVisibility(8);
                GuideActivity.this.DN(R.dimen.tbds170);
                GuideActivity.this.kZa.setVisibility(0);
            }
            if (GuideActivity.this.kZb.getVisibility() == 0) {
                GuideActivity.this.kZb.requestFocus();
            }
            GuideActivity.this.kZa.setPosition(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    };
    private final HttpMessageListener kZn = new HttpMessageListener(1001520) { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001520) {
                GuideActivity.this.kZd = false;
            } else if (httpResponsedMessage.getError() == 0) {
                if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                    GuideActivity.this.kZd = true;
                    return;
                }
                GuideActivity.this.kZd = false;
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, false);
            } else {
                GuideActivity.this.kZd = false;
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.launcherGuide.tblauncher.GuideActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.kZj.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.dbd();
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.mFromPage = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.mFromPage = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TextUtils.isEmpty(this.mFromPage)) {
            this.mFromPage = "";
        }
        this.kZf = this.kZe.length;
        try {
            setContentView(R.layout.guide_activity);
            brg();
            this.kZd = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.JUMP_TO_NEW_USER_GUIDE, true);
            if (this.kZd) {
                dbf();
            }
            try {
                dbc();
                this.kYY = new b();
                this.kYZ = (BaseViewPager) findViewById(R.id.guide_pager);
                this.kYZ.setAdapter(this.kYY);
                this.kZa = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.kZa.setCount(this.kZf);
                y(this.kZa, R.dimen.tbds46);
                this.kZa.setSpacing(getResources().getDimensionPixelSize(R.dimen.tbds35));
                this.kZa.setSelector(getResources().getDrawable(R.drawable.pic_mask_selected_n));
                this.kZa.setDrawable(getResources().getDrawable(R.drawable.pic_mask_unselected_n));
                this.kZa.setPosition(0.0f);
                if (this.kZf <= 1) {
                    this.kZa.setVisibility(4);
                } else {
                    this.kZa.setVisibility(0);
                }
                this.kYZ.setOnScrollOutListener(this.feP);
                this.kYZ.setOnFlipOutListener(this.feP);
                this.kYZ.setOnPageChangeListener(this.kZm);
                this.kZb = findViewById(R.id.start_app);
                com.baidu.tbadk.core.util.f.a.btv().oX(2).oM(R.drawable.btn_mask_guide_n).oN(R.drawable.btn_intro_guide_n).bv(this.kZb);
                this.kZi = findViewById(R.id.opt_container);
                this.kZj = findViewById(R.id.img_start_game);
                this.kZj.setOnClickListener(this.mOnClickListener);
                this.kZk = findViewById(R.id.text_start_app);
                this.kZk.setOnClickListener(this.kZl);
                this.kZi.setVisibility(8);
                this.kZb.setVisibility(0);
                if (this.kZf <= 1) {
                    DN(R.dimen.ds90);
                    this.kZb.setVisibility(0);
                    this.kZb.requestFocus();
                } else {
                    this.kZb.setVisibility(8);
                }
                this.kZb.setOnClickListener(this.kZl);
                TiebaStatic.log("new_user_guide_pv");
                if (this.mFromPage != null && this.mFromPage.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.kYV = new a();
                    this.kYV.setSelfExecute(true);
                    this.kYV.execute(new String[0]);
                    return;
                }
                this.kYV = null;
            } catch (OutOfMemoryError e) {
                dbe();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.kZc = true;
                this.kZd = false;
                dbd();
            } catch (RuntimeException e2) {
                dbe();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.kZc = true;
                this.kZd = false;
                dbd();
            }
        } catch (RuntimeException e3) {
            this.kZc = true;
            this.kZd = false;
            dbd();
        }
    }

    private void dbc() {
        this.kYW = new ArrayList<>();
        this.kYX = new ArrayList<>();
        for (int i = 0; i < this.kZf; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.guide_item_img);
            imageView.setVisibility(0);
            ((GifView) relativeLayout.findViewById(R.id.view_gif)).setVisibility(8);
            imageView.setBackgroundResource(this.kZe[i]);
            Bitmap a2 = a(imageView, this.kZe[i]);
            if (a2 == null) {
                dbd();
                return;
            }
            this.kZh.add(a2);
            this.kYX.add(imageView);
            this.kYW.add(relativeLayout);
        }
    }

    private Bitmap a(ImageView imageView, int i) {
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
    public void dbd() {
        if (this.mFromPage != null && !this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            bLd();
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN(int i) {
        y(this.kZb, i);
    }

    private void y(View view, int i) {
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
        dbe();
        if (this.kYV != null) {
            this.kYV.cancel(true);
            this.kYV = null;
        }
    }

    protected void dbe() {
        if (this.kYZ != null) {
            this.kYZ.setBackgroundDrawable(null);
        }
        if (this.kYX != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kYX.size()) {
                    break;
                }
                ImageView imageView = this.kYX.get(i2);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
                i = i2 + 1;
            }
        }
        if (this.kZh != null) {
            Iterator<Bitmap> it = this.kZh.iterator();
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
                dbd();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLd() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.kZc) {
            if (!TbadkApplication.getInst().isNeedNewUserLead()) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE, null));
                    if (!TbadkCoreApplication.isLogin()) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    } else {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    }
                }
            } else {
                sendMessage(new CustomMessage(2921454, new IntentConfig(this)));
            }
            finish();
            this.kZc = false;
        }
    }

    public void brg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001520, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.kZn);
    }

    public void dbf() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.kZd = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1001520);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCk() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), R.drawable.tb_launcher_icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dbg() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String aX = aX(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (aX == null) {
                aX = aX(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + aX + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
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

    private String aX(Context context, String str) {
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

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.dbg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                GuideActivity.this.aCk();
            }
        }
    }

    /* loaded from: classes8.dex */
    private class b extends PagerAdapter {
        private b() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return GuideActivity.this.kYW.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.kYW.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.kYW.get(i), 0);
                if (i == GuideActivity.this.kYW.size() - 1) {
                    ((View) GuideActivity.this.kYW.get(i)).setOnClickListener(GuideActivity.this.kZl);
                }
                return GuideActivity.this.kYW.get(i);
            }
            View view2 = new View(GuideActivity.this.getPageContext().getPageActivity());
            view2.setBackgroundColor(-1);
            ((ViewPager) view).addView(view2, 0);
            return view2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i, Object obj) {
            ((ViewPager) view).removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }
}
