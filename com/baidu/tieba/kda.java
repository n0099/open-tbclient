package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.gma;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class kda {
    public static /* synthetic */ Interceptable $ic = null;
    public static int S = 5000;

    /* renamed from: T  reason: collision with root package name */
    public static final float f1123T;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public int B;
    public int C;
    public GradientDrawable D;
    public FrameLayout E;
    public FrameLayout.LayoutParams F;
    public AlphaAnimation G;
    public AlphaAnimation H;
    public lca I;
    public fda J;
    public ValueAnimator K;
    public long L;
    public boolean M;
    public int N;
    public int O;
    public boolean P;
    public Runnable Q;
    public gba R;
    public TbPageContext a;
    public NoNetworkView b;
    public View c;
    public vo9 d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public rba i;
    public boolean j;
    public BdUniqueId k;
    public lba l;
    public BaseFragment m;
    public float[] n;
    public float o;
    public int p;
    public LottieSlideLoadingLayout q;
    public PersonHeaderBackgroundController r;
    public AppBarLayout s;
    public FrameLayout t;
    public NewPagerSlidingTabBaseStrip u;
    public View v;
    public CustomViewPager w;
    public m x;
    public LinearLayout y;
    public FrameLayout z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kda kdaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar, Integer.valueOf(i)};
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
            this.a = kdaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.a.N == ((Integer) customResponsedMessage.getData()).intValue() && this.a.M) {
                SafeHandler.getInst().removeCallbacks(this.a.Q);
                this.a.W();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        public b(kda kdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kdaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.M) {
                return;
            }
            this.a.W();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements gba {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        public c(kda kdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kdaVar;
        }

        @Override // com.baidu.tieba.gba
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.F.height = -2;
                this.a.E.setLayoutParams(this.a.F);
            }
        }

        @Override // com.baidu.tieba.gba
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.P = z;
            if (this.a.I != null && this.a.I.B() != null) {
                this.a.I.B().setOpen(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements r65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        @Override // com.baidu.tieba.r65
        public void onLoadingEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public d(kda kdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kdaVar;
        }

        @Override // com.baidu.tieba.r65
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SafeHandler.getInst().postDelayed(this.a.Q, kda.S);
                this.a.M = true;
                kda kdaVar = this.a;
                kdaVar.N = kdaVar.x.d();
                this.a.N();
                this.a.x.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        public e(kda kdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kdaVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            boolean z;
            boolean z2;
            boolean z3;
            float abs;
            boolean z4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    if (i == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    UtilHelper.changeStatusBarIconAndTextColor(z4, this.a.a.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.a.a.getPageActivity());
                }
                LottieSlideLoadingLayout lottieSlideLoadingLayout = this.a.q;
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                lottieSlideLoadingLayout.setEnableSlideLoading(z);
                int abs2 = Math.abs(i);
                fda fdaVar = this.a.J;
                if (abs2 == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fdaVar.i(z2);
                fda fdaVar2 = this.a.J;
                float f = abs2;
                if (f > this.a.o / 2.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                fdaVar2.m(z3);
                if (this.a.o == 0.0d) {
                    abs = 0.0f;
                } else {
                    abs = Math.abs(f / this.a.o);
                }
                this.a.J.h(abs);
                if (abs < 1.0f) {
                    this.a.n = new float[]{kda.f1123T, kda.f1123T, kda.f1123T, kda.f1123T, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.a.D.setCornerRadii(this.a.n);
                    this.a.t.setBackgroundDrawable(this.a.D);
                    this.a.P();
                } else {
                    this.a.n = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.a.D.setCornerRadii(this.a.n);
                    this.a.t.setBackgroundDrawable(this.a.D);
                    this.a.Z();
                }
                int i2 = this.a.C - this.a.B;
                if (this.a.C > 0 && Math.abs(i) >= i2) {
                    this.a.q.o();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

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

        public f(kda kdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kdaVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.x.h(i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(kda kdaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar, Integer.valueOf(i)};
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
            this.a = kdaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.J != null) {
                this.a.J.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public h(kda kdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kdaVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.G.reset();
                this.a.G = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public i(kda kdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kdaVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.v.setVisibility(8);
                this.a.H.reset();
                this.a.H = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        public j(kda kdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kdaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B == 0) {
                kda kdaVar = this.a;
                kdaVar.B = kdaVar.E.getMeasuredHeight();
                kda kdaVar2 = this.a;
                kdaVar2.o = kdaVar2.E.getMeasuredHeight() - this.a.J.e().getMeasuredHeight();
                if (this.a.r != null) {
                    kda kdaVar3 = this.a;
                    kdaVar3.O = kdaVar3.p + this.a.J.e().getMeasuredHeight() + this.a.E.getMeasuredHeight() + this.a.u.getMeasuredHeight();
                    int i = 0;
                    if (!this.a.j && this.a.i.j() != null && this.a.i.j().getNewGodData() != null && this.a.i.j().getNewGodData().isNewGod()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.a.F.height = this.a.O;
                    this.a.E.setLayoutParams(this.a.F);
                    kda kdaVar4 = this.a;
                    if (z) {
                        i = kca.b0;
                    }
                    kda.v(kdaVar4, i);
                    this.a.F.height = -2;
                    this.a.E.setLayoutParams(this.a.F);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(kda kdaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar, Integer.valueOf(i)};
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
            this.a = kdaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof gma)) {
                SparseArray<gma.a> sparseArray = ((gma) customResponsedMessage.getData()).a;
                if (sparseArray.size() <= 0) {
                    return;
                }
                gma.a aVar = sparseArray.get(2);
                if (this.a.I != null && aVar != null) {
                    this.a.I.I(aVar.a);
                }
                gma.a aVar2 = sparseArray.get(4);
                gma.a aVar3 = sparseArray.get(3);
                gma.a aVar4 = sparseArray.get(1);
                gma.a aVar5 = sparseArray.get(7);
                gma.a aVar6 = sparseArray.get(8);
                if (this.a.i != null) {
                    if (this.a.i.w != null && this.a.i.w.b != null && aVar2 != null) {
                        this.a.i.w.b.putBoolean("person_center_item_red_tip_show", aVar2.a);
                    }
                    if (aVar3 != null && this.a.i.v != null && this.a.i.v.b != null) {
                        this.a.i.v.b.putBoolean("person_center_item_red_tip_show", aVar3.a);
                    }
                    if (aVar4 != null && this.a.i.u != null && this.a.i.u.b != null) {
                        this.a.i.u.b.putBoolean("person_center_item_red_tip_show", aVar4.a);
                    }
                    if (aVar5 != null && this.a.i.x != null && this.a.i.x.b != null) {
                        this.a.i.x.b.putBoolean("person_center_item_red_tip_show", aVar5.a);
                    }
                    if (aVar6 != null && this.a.i.y != null && this.a.i.y.b != null) {
                        this.a.i.y.b.putBoolean("person_center_item_red_tip_show", aVar6.a);
                        this.a.i.y.b.putString("person_center_item_txt", String.valueOf(aVar6.b));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kda a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(kda kdaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar, Integer.valueOf(i)};
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
            this.a = kdaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData) && (userPendantData = (UserPendantData) customResponsedMessage.getData()) != null) {
                this.a.I.K(userPendantData.getImgUrl());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;
        public List<PersonCenterTabBaseFragment> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(kda kdaVar, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kdaVar, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(kdaVar.a.getResources().getString(R.string.obfuscated_res_0x7f0f10aa));
            this.a.add(kdaVar.a.getResources().getString(R.string.obfuscated_res_0x7f0f10ad));
            this.a.add(kdaVar.a.getResources().getString(R.string.obfuscated_res_0x7f0f10a9));
            ArrayList arrayList2 = new ArrayList();
            this.b = arrayList2;
            arrayList2.add(PersonCenterMainTabFragment.M2(kdaVar.L, kdaVar.j));
            this.b.add(PersonCenterThreadTabFragment.S2(kdaVar.L, kdaVar.j));
            this.b.add(PersonCenterDynamicTabFragment.P2(kdaVar.L, kdaVar.j));
        }

        public PersonCenterTabBaseFragment e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i < this.b.size()) {
                    return this.b.get(i);
                }
                return null;
            }
            return (PersonCenterTabBaseFragment) invokeI.objValue;
        }

        public final String f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.a.get(i);
            }
            return (String) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                return e(i);
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                return f(i);
            }
            return (CharSequence) invokeI.objValue;
        }

        public void h(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                for (int i2 = 0; i2 < this.a.size() && (personCenterTabBaseFragment = this.b.get(i2)) != null; i2++) {
                    if (i2 == i) {
                        personCenterTabBaseFragment.setPrimary(true);
                    } else {
                        personCenterTabBaseFragment.setPrimary(false);
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || ListUtils.isEmpty(this.b)) {
                return;
            }
            for (int i = 0; i < this.b.size(); i++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.G2(false);
                }
            }
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (ListUtils.isEmpty(this.b)) {
                    return -1;
                }
                for (int i = 0; i < this.b.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                    if (personCenterTabBaseFragment != null && personCenterTabBaseFragment.isPrimary()) {
                        return personCenterTabBaseFragment.H2();
                    }
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public void g(int i) {
            List<PersonCenterTabBaseFragment> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (list = this.b) != null && list.size() > 0) {
                int size = this.b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i2);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }

        public void i(rba rbaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, rbaVar) == null) && rbaVar != null && !ListUtils.isEmpty(this.b)) {
                for (int i = 0; i < this.b.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                    if (personCenterTabBaseFragment instanceof PersonCenterMainTabFragment) {
                        ((PersonCenterMainTabFragment) personCenterTabBaseFragment).O2(rbaVar);
                    }
                }
            }
        }

        public void j(rba rbaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, rbaVar) == null) && rbaVar != null && rbaVar.i() != null && !ListUtils.isEmpty(this.b)) {
                for (int i = 0; i < this.b.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.J2(rbaVar.C);
                        personCenterTabBaseFragment.K2(rbaVar.i());
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<PersonCenterTabBaseFragment> list = this.b;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947910625, "Lcom/baidu/tieba/kda;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947910625, "Lcom/baidu/tieba/kda;");
                return;
            }
        }
        f1123T = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    }

    public lca M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.I;
        }
        return (lca) invokeV.objValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.d.resetData();
                this.d.a();
                this.l.k();
                return;
            }
            this.l.p();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.p();
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.v.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.N = -1;
            this.M = false;
            LottieSlideLoadingLayout lottieSlideLoadingLayout = this.q;
            if (lottieSlideLoadingLayout != null) {
                lottieSlideLoadingLayout.o();
            }
        }
    }

    public kda(BaseFragment baseFragment, mba mbaVar, BdUniqueId bdUniqueId, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, mbaVar, bdUniqueId, Boolean.valueOf(z), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        float f2 = f1123T;
        this.n = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
        this.o = 674.0f;
        this.M = false;
        this.N = -1;
        this.Q = new b(this);
        this.R = new c(this);
        this.m = baseFragment;
        this.a = baseFragment.getPageContext();
        this.k = bdUniqueId;
        this.j = z;
        this.L = j2;
        this.l = mbaVar.k();
        S(mbaVar.e);
    }

    public final void Q(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            g gVar = new g(this, 2005016);
            this.h = gVar;
            gVar.setTag(this.k);
            tbPageContext.registerListener(this.h);
        }
    }

    public void X(vo9 vo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vo9Var) == null) {
            this.d = vo9Var;
        }
    }

    public void Y(aab aabVar) {
        fda fdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, aabVar) == null) && (fdaVar = this.J) != null) {
            fdaVar.j(aabVar);
        }
    }

    public static /* synthetic */ int v(kda kdaVar, int i2) {
        int i3 = kdaVar.O + i2;
        kdaVar.O = i3;
        return i3;
    }

    public void P() {
        AlphaAnimation alphaAnimation;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && T() && (alphaAnimation = this.H) == null && alphaAnimation == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.H = alphaAnimation2;
            alphaAnimation2.setFillAfter(true);
            this.H.setDuration(300L);
            this.H.setAnimationListener(new i(this));
            this.v.startAnimation(this.H);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            lca lcaVar = this.I;
            if (lcaVar != null) {
                lcaVar.G();
            }
            ValueAnimator valueAnimator = this.K;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.K.removeAllListeners();
                this.K.removeAllUpdateListeners();
                this.K = null;
            }
            SafeHandler.getInst().removeCallbacks(this.Q);
        }
    }

    public final void R(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            k kVar = new k(this, 2001435);
            this.e = kVar;
            kVar.setTag(this.k);
            tbPageContext.registerListener(this.e);
            l lVar = new l(this, 2016485);
            this.f = lVar;
            lVar.setTag(this.k);
            tbPageContext.registerListener(this.f);
            a aVar = new a(this, 2921435);
            this.g = aVar;
            aVar.setTag(this.k);
            tbPageContext.registerListener(this.g);
        }
    }

    public final void S(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            this.c = view2;
            this.p = UtilHelper.getStatusBarHeight();
            this.q = (LottieSlideLoadingLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c90);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091c93);
            this.r = new PersonHeaderBackgroundController(this.a, tbImageView, this.c.findViewById(R.id.obfuscated_res_0x7f091c8e), this.j);
            this.q.l(tbImageView);
            TbPageContext tbPageContext = this.a;
            View view3 = this.c;
            this.J = new fda(tbPageContext, view3, view3.findViewById(R.id.obfuscated_res_0x7f091cb4), this.j);
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c94);
            this.E = frameLayout;
            this.F = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            this.q.l(this.E);
            this.q.j(new d(this));
            AppBarLayout appBarLayout = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c8b);
            this.s = appBarLayout;
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e(this));
            this.t = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091cb6);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f091cb5);
            this.u = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.u.setRectPaintColor(R.color.CAM_X0302);
            this.u.E(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds46), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds46), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds10), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds46), true);
            this.u.setIndicatorOffset(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds64));
            this.u.setIndicatorOvershot(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds8));
            this.u.setIndicatorRadius(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds8));
            this.u.setIndicatorMarginBottom(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds0));
            this.u.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds166), -1));
            this.u.setOnPageChangeListener(new f(this));
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.D = gradientDrawable;
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            this.D.setCornerRadii(this.n);
            this.t.setBackgroundDrawable(this.D);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091cb0);
            this.v = findViewById;
            SkinManager.setBackgroundResource(findViewById, R.drawable.personalize_tab_shadow);
            this.w = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091cba);
            m mVar = new m(this, this.m.getActivity().getSupportFragmentManager());
            this.x = mVar;
            this.w.setAdapter(mVar);
            this.w.setOffscreenPageLimit(this.x.b.size());
            this.x.notifyDataSetChanged();
            this.u.setViewPager(this.w);
            this.w.setCurrentItem(1);
            lca lcaVar = new lca(this.a, this.j);
            this.I = lcaVar;
            lcaVar.H(this.R);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            this.E.addView(this.I.C(), layoutParams);
            if (this.J.f()) {
                R(this.a);
            }
            Q(this.a);
            this.b = (NoNetworkView) this.c.findViewById(R.id.obfuscated_res_0x7f091cab);
            this.y = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c86);
            this.z = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c87);
            this.A = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091cac);
        }
    }

    public void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            fda fdaVar = this.J;
            if (fdaVar != null) {
                fdaVar.g(i2);
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.u;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
                this.u.setRectPaintColor(R.color.CAM_X0302);
                this.u.H();
            }
            GradientDrawable gradientDrawable = this.D;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            }
            lca lcaVar = this.I;
            if (lcaVar != null) {
                lcaVar.F(i2);
            }
            m mVar = this.x;
            if (mVar != null) {
                mVar.g(i2);
            }
            NoNetworkView noNetworkView = this.b;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a, i2);
            }
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.c, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.v, R.drawable.personalize_tab_shadow);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !T() && this.G == null) {
            this.v.setVisibility(0);
            if (this.G == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.G = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.G.setDuration(300L);
                this.G.setAnimationListener(new h(this));
                this.v.startAnimation(this.G);
            }
        }
    }

    public void a0(rba rbaVar, boolean z, PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{rbaVar, Boolean.valueOf(z), personStatus}) != null) || rbaVar == null) {
            return;
        }
        this.i = rbaVar;
        this.y.setVisibility(8);
        this.A.setVisibility(0);
        fda fdaVar = this.J;
        if (fdaVar != null) {
            fdaVar.l(rbaVar, personStatus);
        }
        lca lcaVar = this.I;
        if (lcaVar != null) {
            lcaVar.p(rbaVar);
        }
        PersonHeaderBackgroundController personHeaderBackgroundController = this.r;
        if (personHeaderBackgroundController != null) {
            personHeaderBackgroundController.e(this.i.j());
        }
        this.E.post(new j(this));
        this.x.j(rbaVar);
        this.x.i(rbaVar);
        if (ListUtils.isEmpty(rbaVar.f())) {
            this.l.l();
            BdUtilHelper.showToast(this.a.getContext(), this.a.getString(R.string.data_load_error));
            return;
        }
        PersonRedTipManager.getInstance().syncRedTipState(this.j);
        int size = rbaVar.f().size();
        for (int i2 = 0; i2 < size; i2++) {
            pi piVar = rbaVar.f().get(i2);
            if (piVar != null && (piVar instanceof zba)) {
                this.l.l();
                return;
            }
        }
        if (!z) {
            this.l.B(true, rbaVar.f());
        }
    }
}
