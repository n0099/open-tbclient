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
import com.baidu.tieba.r95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public ArrayList<View> b;
    public ArrayList<ImageView> c;
    public f d;
    public BaseViewPager e;
    public IndicatorView f;
    public View g;
    public boolean h;
    public boolean i;
    public final int[] j;
    public int k;
    public final ArrayList<Bitmap> l;
    public View m;
    public View n;
    public View o;
    public final BaseViewPager.a p;
    public View.OnClickListener q;
    public final ViewPager.OnPageChangeListener r;
    public final HttpMessageListener s;
    public View.OnClickListener t;

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                if (this.a.e != null) {
                    this.a.e.setOnScrollOutListener(null);
                }
                if (!this.a.a.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                    this.a.T1();
                }
                CompatibleUtile.setAnim(this.a.getPageContext().getPageActivity(), 0, R.anim.obfuscated_res_0x7f0100ae);
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideActivity a;

        public b(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L1();
                if (view2.getId() == this.a.o.getId()) {
                    TiebaStatic.log(new StatisticItem("c13410").param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideActivity a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public c(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i != this.a.k - 1) {
                    this.a.g.setVisibility(8);
                    this.a.R1(R.dimen.tbds170);
                    this.a.f.setVisibility(0);
                } else {
                    this.a.R1(R.dimen.tbds170);
                    this.a.g.setVisibility(0);
                    this.a.f.setVisibility(0);
                }
                if (this.a.g.getVisibility() == 0) {
                    this.a.g.requestFocus();
                }
                this.a.f.setPosition(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GuideActivity guideActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                            this.a.i = true;
                            return;
                        }
                        this.a.i = false;
                        r95.p().A("jump_to_new_user_guide", false);
                        return;
                    }
                    this.a.i = false;
                    return;
                }
                this.a.i = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideActivity a;

        public e(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == this.a.n.getId()) {
                TbSingleton.getInstance().mStartGameClicked = true;
                this.a.L1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideActivity a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        public f(GuideActivity guideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideActivity;
        }

        public /* synthetic */ f(GuideActivity guideActivity, a aVar) {
            this(guideActivity);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view2, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, obj) == null) {
                ((ViewPager) view2).removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.b.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view2, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i)) == null) {
                if (i >= this.a.b.size()) {
                    View view3 = new View(this.a.getPageContext().getPageActivity());
                    view3.setBackgroundColor(-1);
                    ((ViewPager) view2).addView(view3, 0);
                    return view3;
                }
                ((ViewPager) view2).addView((View) this.a.b.get(i), 0);
                if (i == this.a.b.size() - 1) {
                    ((View) this.a.b.get(i)).setOnClickListener(this.a.q);
                }
                return this.a.b.get(i);
            }
            return invokeLI.objValue;
        }
    }

    public GuideActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.h = true;
        this.i = true;
        this.j = new int[]{R.drawable.obfuscated_res_0x7f08020f, R.drawable.obfuscated_res_0x7f080210, R.drawable.obfuscated_res_0x7f080211};
        this.k = 0;
        this.l = new ArrayList<>();
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        this.t = new e(this);
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = new ArrayList<>();
            this.c = new ArrayList<>();
            for (int i = 0; i < this.k; i++) {
                RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03dc, (ViewGroup) null, false);
                ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090ead);
                imageView.setVisibility(0);
                ((GifView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0928f3)).setVisibility(8);
                imageView.setBackgroundResource(this.j[i]);
                Bitmap Q1 = Q1(imageView, this.j[i]);
                if (Q1 == null) {
                    L1();
                    return;
                }
                this.l.add(Q1);
                this.c.add(imageView);
                this.b.add(relativeLayout);
            }
        }
    }

    public final void R1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            S1(this.g, i);
        }
    }

    public final void S1(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, view2, i) != null) || view2 == null) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.bottomMargin = dimensionPixelSize;
            view2.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, keyEvent)) == null) {
            if (i != 4) {
                return super.onKeyDown(i, keyEvent);
            }
            L1();
            return true;
        }
        return invokeIL.booleanValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.a;
            if (str != null && !str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                T1();
            }
            closeActivity();
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (TextUtils.isEmpty(currentAccount)) {
                this.i = false;
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
            httpMessage.addParam("uid", currentAccount);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            P1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
        }
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, TbConfig.SERVER_ADDRESS + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            registerListener(this.s);
        }
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BaseViewPager baseViewPager = this.e;
            if (baseViewPager != null) {
                baseViewPager.setBackgroundDrawable(null);
            }
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    ImageView imageView = this.c.get(i);
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageBitmap(null);
                }
            }
            ArrayList<Bitmap> arrayList = this.l;
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

    public final Bitmap Q1(ImageView imageView, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, imageView, i)) == null) {
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
        return (Bitmap) invokeLI.objValue;
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
            if (this.h) {
                if (!TbSingleton.getInstance().isNeedShowInterestGuide()) {
                    if (!isFirstUse) {
                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                        if (!TbadkCoreApplication.isLogin()) {
                            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                        } else {
                            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                        }
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
                }
                finish();
                this.h = false;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            if (bundle != null) {
                this.a = bundle.getString(GuildActivityConfig.FROM_PAGE);
            } else if (getIntent() != null) {
                this.a = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            if (TextUtils.isEmpty(this.a)) {
                this.a = "";
            }
            this.k = this.j.length;
            try {
                setContentView(R.layout.obfuscated_res_0x7f0d03db);
                O1();
                boolean l = r95.p().l("jump_to_new_user_guide", true);
                this.i = l;
                if (l) {
                    M1();
                }
                try {
                    N1();
                    this.d = new f(this, null);
                    BaseViewPager baseViewPager = (BaseViewPager) findViewById(R.id.obfuscated_res_0x7f090eb0);
                    this.e = baseViewPager;
                    baseViewPager.setAdapter(this.d);
                    IndicatorView indicatorView = (IndicatorView) findViewById(R.id.obfuscated_res_0x7f090eaf);
                    this.f = indicatorView;
                    indicatorView.setCount(this.k);
                    S1(this.f, R.dimen.tbds46);
                    this.f.setSpacing(getResources().getDimensionPixelSize(R.dimen.tbds35));
                    this.f.setSelector(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0811db));
                    this.f.setDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0811dd));
                    this.f.setPosition(0.0f);
                    if (this.k <= 1) {
                        this.f.setVisibility(4);
                    } else {
                        this.f.setVisibility(0);
                    }
                    this.e.setOnScrollOutListener(this.p);
                    this.e.setOnFlipOutListener(this.p);
                    this.e.setOnPageChangeListener(this.r);
                    this.g = findViewById(R.id.obfuscated_res_0x7f092259);
                    TBSelector.makeDrawableSelector().setType(2).defaultDrawable(R.drawable.obfuscated_res_0x7f080428).pressedDrawable(R.drawable.obfuscated_res_0x7f080412).into(this.g);
                    this.m = findViewById(R.id.obfuscated_res_0x7f0919b2);
                    View findViewById = findViewById(R.id.obfuscated_res_0x7f0910de);
                    this.n = findViewById;
                    findViewById.setOnClickListener(this.t);
                    View findViewById2 = findViewById(R.id.obfuscated_res_0x7f09243e);
                    this.o = findViewById2;
                    findViewById2.setOnClickListener(this.q);
                    this.m.setVisibility(8);
                    this.g.setVisibility(0);
                    if (this.k <= 1) {
                        R1(R.dimen.obfuscated_res_0x7f07041c);
                        this.g.setVisibility(0);
                        this.g.requestFocus();
                    } else {
                        this.g.setVisibility(8);
                    }
                    this.g.setOnClickListener(this.q);
                    TiebaStatic.log("new_user_guide_pv");
                } catch (OutOfMemoryError e2) {
                    P1();
                    TbadkApplication.getInst().onAppMemoryLow();
                    BdLog.detailException(e2);
                    this.h = true;
                    this.i = false;
                    L1();
                } catch (RuntimeException e3) {
                    P1();
                    TbadkApplication.getInst().onAppMemoryLow();
                    BdLog.detailException(e3);
                    this.h = true;
                    this.i = false;
                    L1();
                }
            } catch (RuntimeException unused) {
                this.h = true;
                this.i = false;
                L1();
            }
        }
    }
}
