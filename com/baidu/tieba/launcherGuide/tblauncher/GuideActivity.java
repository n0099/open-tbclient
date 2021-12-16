package com.baidu.tieba.launcherGuide.tblauncher;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes12.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MODE_GIF = 2;
    public static final int MODE_IMAGE = 1;
    public static final int mMode = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] GUIDE_GIF_LIST;
    public final int[] GUIDE_PIC_LIST;
    public int guideListSize;
    public IndicatorView guide_page_indicator;
    public boolean isFirstStartApp;
    public boolean isJumpToNewGuide;
    public final ArrayList<Bitmap> mBmpList;
    public View mBtnStartGame;
    public View mBtnStartTieba;
    public String mFromPage;
    public ArrayList<ImageView> mGuideImages;
    public f mGuidePagerAdapter;
    public BaseViewPager mGuideViewPager;
    public ArrayList<View> mGuideViews;
    public final HttpMessageListener mNewUserGuideListener;
    public View.OnClickListener mOnClickListener;
    public final BaseViewPager.a mOnScrollOutListener;
    public View mOptContainer;
    public View mStartButton;
    public final ViewPager.OnPageChangeListener mViewPagerPageChanged;
    public View.OnClickListener startOnClickListener;

    /* loaded from: classes12.dex */
    public class a implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideActivity a;

        public a(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0) {
                if (this.a.mGuideViewPager != null) {
                    this.a.mGuideViewPager.setOnScrollOutListener(null);
                }
                if (!this.a.mFromPage.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    this.a.startApp();
                }
                CompatibleUtile.setAnim(this.a.getPageContext().getPageActivity(), 0, R.anim.left);
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuideActivity f46966e;

        public b(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46966e = guideActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f46966e.endGuide();
                if (view.getId() == this.f46966e.mBtnStartTieba.getId()) {
                    TiebaStatic.log(new StatisticItem("c13410").param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuideActivity f46967e;

        public c(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46967e = guideActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (i2 == this.f46967e.guideListSize - 1) {
                    this.f46967e.setStartButtonBottomMargin(R.dimen.tbds170);
                    this.f46967e.mStartButton.setVisibility(0);
                    this.f46967e.guide_page_indicator.setVisibility(0);
                } else {
                    this.f46967e.mStartButton.setVisibility(8);
                    this.f46967e.setStartButtonBottomMargin(R.dimen.tbds170);
                    this.f46967e.guide_page_indicator.setVisibility(0);
                }
                if (this.f46967e.mStartButton.getVisibility() == 0) {
                    this.f46967e.mStartButton.requestFocus();
                }
                this.f46967e.guide_page_indicator.setPosition(i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GuideActivity guideActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001520) {
                    if (httpResponsedMessage.getError() == 0) {
                        if (((ShowNewUserGuideResponseMessage) httpResponsedMessage).isJump == 1) {
                            this.a.isJumpToNewGuide = true;
                            return;
                        }
                        this.a.isJumpToNewGuide = false;
                        c.a.r0.s.g0.b.j().t("jump_to_new_user_guide", false);
                        return;
                    }
                    this.a.isJumpToNewGuide = false;
                    return;
                }
                this.a.isJumpToNewGuide = false;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuideActivity f46968e;

        public e(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46968e = guideActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == this.f46968e.mBtnStartGame.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                this.f46968e.endGuide();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideActivity a;

        public f(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, obj) == null) {
                ((ViewPager) view).removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.mGuideViews.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2)) == null) {
                if (i2 < this.a.mGuideViews.size()) {
                    ((ViewPager) view).addView((View) this.a.mGuideViews.get(i2), 0);
                    if (i2 == this.a.mGuideViews.size() - 1) {
                        ((View) this.a.mGuideViews.get(i2)).setOnClickListener(this.a.startOnClickListener);
                    }
                    return this.a.mGuideViews.get(i2);
                }
                View view2 = new View(this.a.getPageContext().getPageActivity());
                view2.setBackgroundColor(-1);
                ((ViewPager) view).addView(view2, 0);
                return view2;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
            }
        }

        public /* synthetic */ f(GuideActivity guideActivity, a aVar) {
            this(guideActivity);
        }
    }

    public GuideActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFromPage = null;
        this.isFirstStartApp = true;
        this.isJumpToNewGuide = true;
        this.GUIDE_PIC_LIST = new int[]{R.drawable.android_guide_1, R.drawable.android_guide_2, R.drawable.android_guide_3};
        this.guideListSize = 0;
        this.GUIDE_GIF_LIST = new int[0];
        this.mBmpList = new ArrayList<>();
        this.mOnScrollOutListener = new a(this);
        this.startOnClickListener = new b(this);
        this.mViewPagerPageChanged = new c(this);
        this.mNewUserGuideListener = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        this.mOnClickListener = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            String str = this.mFromPage;
            if (str != null && !str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                startApp();
            }
            closeActivity();
        }
    }

    private void initGuideView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mGuideViews = new ArrayList<>();
            this.mGuideImages = new ArrayList<>();
            for (int i2 = 0; i2 < this.guideListSize; i2++) {
                RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.guide_page_item, (ViewGroup) null, false);
                ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.guide_item_img);
                imageView.setVisibility(0);
                ((GifView) relativeLayout.findViewById(R.id.view_gif)).setVisibility(8);
                imageView.setBackgroundResource(this.GUIDE_PIC_LIST[i2]);
                Bitmap imageView2 = setImageView(imageView, this.GUIDE_PIC_LIST[i2]);
                if (imageView2 == null) {
                    endGuide();
                    return;
                }
                this.mBmpList.add(imageView2);
                this.mGuideImages.add(imageView);
                this.mGuideViews.add(relativeLayout);
            }
        }
    }

    private Bitmap setImageView(ImageView imageView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, this, imageView, i2)) == null) {
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), i2);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 4;
                logoBitmap = BitmapHelper.getResBitmap(getPageContext().getPageActivity(), i2, options);
            }
            if (logoBitmap != null) {
                imageView.setImageBitmap(logoBitmap);
            }
            return logoBitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartButtonBottomMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            setViewBottomMargin(this.mStartButton, i2);
        }
    }

    private void setViewBottomMargin(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65553, this, view, i2) == null) || view == null) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(i2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.bottomMargin = dimensionPixelSize;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
            if (this.isFirstStartApp) {
                if (TbSingleton.getInstance().isNeedShowInterestGuide()) {
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
    }

    public void getJumpInfoFromServer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (TextUtils.isEmpty(currentAccount)) {
                this.isJumpToNewGuide = false;
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
            httpMessage.addParam("uid", currentAccount);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
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
                boolean g2 = c.a.r0.s.g0.b.j().g("jump_to_new_user_guide", true);
                this.isJumpToNewGuide = g2;
                if (g2) {
                    getJumpInfoFromServer();
                }
                try {
                    initGuideView();
                    this.mGuidePagerAdapter = new f(this, null);
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            releaseResources();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                return super.onKeyDown(i2, keyEvent);
            }
            endGuide();
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
        }
    }

    public void registerHttpTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            registerListener(this.mNewUserGuideListener);
        }
    }

    public void releaseResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BaseViewPager baseViewPager = this.mGuideViewPager;
            if (baseViewPager != null) {
                baseViewPager.setBackgroundDrawable(null);
            }
            if (this.mGuideImages != null) {
                for (int i2 = 0; i2 < this.mGuideImages.size(); i2++) {
                    ImageView imageView = this.mGuideImages.get(i2);
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
    }

    public void showWelcome() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
