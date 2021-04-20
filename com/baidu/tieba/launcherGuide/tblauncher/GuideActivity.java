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
import androidx.core.content.pm.ShortcutManagerCompat;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    public static final int MODE_GIF = 2;
    public static final int MODE_IMAGE = 1;
    public static final int mMode = 1;
    public IndicatorView guide_page_indicator;
    public View mBtnStartGame;
    public View mBtnStartTieba;
    public ArrayList<ImageView> mGuideImages;
    public g mGuidePagerAdapter;
    public BaseViewPager mGuideViewPager;
    public ArrayList<View> mGuideViews;
    public View mOptContainer;
    public View mStartButton;
    public f mTask = null;
    public String mFromPage = null;
    public boolean isFirstStartApp = true;
    public boolean isJumpToNewGuide = true;
    public final int[] GUIDE_PIC_LIST = {R.drawable.android_guide_1, R.drawable.android_guide_2, R.drawable.android_guide_3};
    public int guideListSize = 0;
    public final int[] GUIDE_GIF_LIST = new int[0];
    public final ArrayList<Bitmap> mBmpList = new ArrayList<>();
    public final BaseViewPager.a mOnScrollOutListener = new a();
    public View.OnClickListener startOnClickListener = new b();
    public final ViewPager.OnPageChangeListener mViewPagerPageChanged = new c();
    public final HttpMessageListener mNewUserGuideListener = new d(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
    public View.OnClickListener mOnClickListener = new e();

    /* loaded from: classes4.dex */
    public class a implements BaseViewPager.a {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i) {
            if (i == 0) {
                if (GuideActivity.this.mGuideViewPager != null) {
                    GuideActivity.this.mGuideViewPager.setOnScrollOutListener(null);
                }
                if (!GuideActivity.this.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    GuideActivity.this.startApp();
                }
                CompatibleUtile.setAnim(GuideActivity.this.getPageContext().getPageActivity(), 0, R.anim.left);
                GuideActivity.this.closeActivity();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideActivity.this.endGuide();
            if (view.getId() == GuideActivity.this.mBtnStartTieba.getId()) {
                TiebaStatic.log(new StatisticItem("c13410").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == GuideActivity.this.guideListSize - 1) {
                GuideActivity.this.setStartButtonBottomMargin(R.dimen.tbds170);
                GuideActivity.this.mStartButton.setVisibility(0);
                GuideActivity.this.guide_page_indicator.setVisibility(0);
            } else {
                GuideActivity.this.mStartButton.setVisibility(8);
                GuideActivity.this.setStartButtonBottomMargin(R.dimen.tbds170);
                GuideActivity.this.guide_page_indicator.setVisibility(0);
            }
            if (GuideActivity.this.mStartButton.getVisibility() == 0) {
                GuideActivity.this.mStartButton.requestFocus();
            }
            GuideActivity.this.guide_page_indicator.setPosition(i);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends HttpMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001520) {
                if (httpResponsedMessage.getError() == 0) {
                    if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                        GuideActivity.this.isJumpToNewGuide = true;
                        return;
                    }
                    GuideActivity.this.isJumpToNewGuide = false;
                    d.b.h0.r.d0.b.j().t("jump_to_new_user_guide", false);
                    return;
                }
                GuideActivity.this.isJumpToNewGuide = false;
                return;
            }
            GuideActivity.this.isJumpToNewGuide = false;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == GuideActivity.this.mBtnStartGame.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                GuideActivity.this.endGuide();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<String, Integer, Boolean> {
        public f() {
        }

        public /* synthetic */ f(GuideActivity guideActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(GuideActivity.this.checkShortCut());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                return;
            }
            GuideActivity.this.addShortcut();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends PagerAdapter {
        public g() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i, Object obj) {
            ((ViewPager) view).removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return GuideActivity.this.mGuideViews.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i) {
            if (i < GuideActivity.this.mGuideViews.size()) {
                ((ViewPager) view).addView((View) GuideActivity.this.mGuideViews.get(i), 0);
                if (i == GuideActivity.this.mGuideViews.size() - 1) {
                    ((View) GuideActivity.this.mGuideViews.get(i)).setOnClickListener(GuideActivity.this.startOnClickListener);
                }
                return GuideActivity.this.mGuideViews.get(i);
            }
            View view2 = new View(GuideActivity.this.getPageContext().getPageActivity());
            view2.setBackgroundColor(-1);
            ((ViewPager) view).addView(view2, 0);
            return view2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
        }

        public /* synthetic */ g(GuideActivity guideActivity, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addShortcut() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        String packageName = getPageContext().getPageActivity().getPackageName();
        intent.setComponent(new ComponentName(packageName, getPageContext().getPageActivity().getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), R.drawable.tb_launcher_icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkShortCut() {
        try {
            ContentResolver contentResolver = getContentResolver();
            String authorityFromPermission = getAuthorityFromPermission(getBaseContext(), "com.android.launcher.permission.READ_SETTINGS");
            if (authorityFromPermission == null) {
                authorityFromPermission = getAuthorityFromPermission(getBaseContext(), "com.android.launcher.permission.WRITE_SETTINGS");
            }
            Cursor query = contentResolver.query(Uri.parse("content://" + authorityFromPermission + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(R.string.app_name)}, null);
            if (query != null) {
                return query.getCount() > 0;
            }
            return false;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endGuide() {
        String str = this.mFromPage;
        if (str != null && !str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            startApp();
        }
        closeActivity();
    }

    private String getAuthorityFromPermission(Context context, String str) {
        List<PackageInfo> installedPackages;
        if (str != null && (installedPackages = context.getPackageManager().getInstalledPackages(8)) != null) {
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

    private void initGuideView() {
        this.mGuideViews = new ArrayList<>();
        this.mGuideImages = new ArrayList<>();
        for (int i = 0; i < this.guideListSize; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.guide_item_img);
            imageView.setVisibility(0);
            ((GifView) relativeLayout.findViewById(R.id.view_gif)).setVisibility(8);
            imageView.setBackgroundResource(this.GUIDE_PIC_LIST[i]);
            Bitmap imageView2 = setImageView(imageView, this.GUIDE_PIC_LIST[i]);
            if (imageView2 == null) {
                endGuide();
                return;
            }
            this.mBmpList.add(imageView2);
            this.mGuideImages.add(imageView);
            this.mGuideViews.add(relativeLayout);
        }
    }

    private Bitmap setImageView(ImageView imageView, int i) {
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
    public void setStartButtonBottomMargin(int i) {
        setViewBottomMargin(this.mStartButton, i);
    }

    private void setViewBottomMargin(View view, int i) {
        if (view == null) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.bottomMargin = dimensionPixelSize;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startApp() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.isFirstStartApp) {
            if (TbadkApplication.getInst().isNeedNewUserLead()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
            } else if (!isFirstUse) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                if (!TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                } else {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                }
            }
            finish();
            this.isFirstStartApp = false;
        }
    }

    public void getJumpInfoFromServer() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            this.isJumpToNewGuide = false;
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam("uid", currentAccount);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.mFromPage = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else if (getIntent() != null) {
            this.mFromPage = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TextUtils.isEmpty(this.mFromPage)) {
            this.mFromPage = "";
        }
        this.guideListSize = this.GUIDE_PIC_LIST.length;
        try {
            setContentView(R.layout.guide_activity);
            registerHttpTask();
            boolean g2 = d.b.h0.r.d0.b.j().g("jump_to_new_user_guide", true);
            this.isJumpToNewGuide = g2;
            if (g2) {
                getJumpInfoFromServer();
            }
            try {
                initGuideView();
                this.mGuidePagerAdapter = new g(this, null);
                BaseViewPager baseViewPager = (BaseViewPager) findViewById(R.id.guide_pager);
                this.mGuideViewPager = baseViewPager;
                baseViewPager.setAdapter(this.mGuidePagerAdapter);
                IndicatorView indicatorView = (IndicatorView) findViewById(R.id.guide_page_indicator);
                this.guide_page_indicator = indicatorView;
                indicatorView.setCount(this.guideListSize);
                setViewBottomMargin(this.guide_page_indicator, R.dimen.tbds46);
                this.guide_page_indicator.setSpacing(getResources().getDimensionPixelSize(R.dimen.tbds35));
                this.guide_page_indicator.setSelector(getResources().getDrawable(R.drawable.pic_mask_selected_n));
                this.guide_page_indicator.setDrawable(getResources().getDrawable(R.drawable.pic_mask_unselected_n));
                this.guide_page_indicator.setPosition(0.0f);
                if (this.guideListSize <= 1) {
                    this.guide_page_indicator.setVisibility(4);
                } else {
                    this.guide_page_indicator.setVisibility(0);
                }
                this.mGuideViewPager.setOnScrollOutListener(this.mOnScrollOutListener);
                this.mGuideViewPager.setOnFlipOutListener(this.mOnScrollOutListener);
                this.mGuideViewPager.setOnPageChangeListener(this.mViewPagerPageChanged);
                this.mStartButton = findViewById(R.id.start_app);
                TBSelector.makeDrawableSelector().setType(2).defaultDrawable(R.drawable.btn_mask_guide_n).pressedDrawable(R.drawable.btn_intro_guide_n).into(this.mStartButton);
                this.mOptContainer = findViewById(R.id.opt_container);
                View findViewById = findViewById(R.id.img_start_game);
                this.mBtnStartGame = findViewById;
                findViewById.setOnClickListener(this.mOnClickListener);
                View findViewById2 = findViewById(R.id.text_start_app);
                this.mBtnStartTieba = findViewById2;
                findViewById2.setOnClickListener(this.startOnClickListener);
                this.mOptContainer.setVisibility(8);
                this.mStartButton.setVisibility(0);
                if (this.guideListSize <= 1) {
                    setStartButtonBottomMargin(R.dimen.ds90);
                    this.mStartButton.setVisibility(0);
                    this.mStartButton.requestFocus();
                } else {
                    this.mStartButton.setVisibility(8);
                }
                this.mStartButton.setOnClickListener(this.startOnClickListener);
                TiebaStatic.log("new_user_guide_pv");
                String str = this.mFromPage;
                if (str != null && str.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    f fVar = new f(this, null);
                    this.mTask = fVar;
                    fVar.setSelfExecute(true);
                    this.mTask.execute(new String[0]);
                    return;
                }
                this.mTask = null;
            } catch (OutOfMemoryError e2) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.isFirstStartApp = true;
                this.isJumpToNewGuide = false;
                endGuide();
            } catch (RuntimeException e3) {
                releaseResources();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e3);
                this.isFirstStartApp = true;
                this.isJumpToNewGuide = false;
                endGuide();
            }
        } catch (RuntimeException unused) {
            this.isFirstStartApp = true;
            this.isJumpToNewGuide = false;
            endGuide();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        releaseResources();
        f fVar = this.mTask;
        if (fVar != null) {
            fVar.cancel(true);
            this.mTask = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        endGuide();
        return true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void registerHttpTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.mNewUserGuideListener);
    }

    public void releaseResources() {
        BaseViewPager baseViewPager = this.mGuideViewPager;
        if (baseViewPager != null) {
            baseViewPager.setBackgroundDrawable(null);
        }
        if (this.mGuideImages != null) {
            for (int i = 0; i < this.mGuideImages.size(); i++) {
                ImageView imageView = this.mGuideImages.get(i);
                imageView.setBackgroundDrawable(null);
                imageView.setImageBitmap(null);
            }
        }
        ArrayList<Bitmap> arrayList = this.mBmpList;
        if (arrayList != null) {
            Iterator<Bitmap> it = arrayList.iterator();
            while (it.hasNext()) {
                Bitmap next = it.next();
                if (next != null && !next.isRecycled()) {
                    next.recycle();
                }
            }
        }
    }

    public void showWelcome() {
    }
}
