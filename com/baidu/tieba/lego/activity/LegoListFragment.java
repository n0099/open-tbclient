package com.baidu.tieba.lego.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.co5;
import com.baidu.tieba.d19;
import com.baidu.tieba.do5;
import com.baidu.tieba.e19;
import com.baidu.tieba.ez6;
import com.baidu.tieba.ez8;
import com.baidu.tieba.f19;
import com.baidu.tieba.i09;
import com.baidu.tieba.kz8;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lz8;
import com.baidu.tieba.n09;
import com.baidu.tieba.r09;
import com.baidu.tieba.r9;
import com.baidu.tieba.s09;
import com.baidu.tieba.sz8;
import com.baidu.tieba.w09;
import com.baidu.tieba.x09;
import com.baidu.tieba.y09;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg;
import com.baidu.tieba.zz8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes6.dex */
public class LegoListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static Set<String> R;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public String B;
    public String C;
    public float D;
    public int E;
    public int F;
    public boolean G;
    public int H;
    public View I;
    public lz8 J;
    public r09 K;
    public ez8 L;
    public View.OnLayoutChangeListener M;
    public View.OnTouchListener N;
    public ez6.b O;
    public AbsListView.OnScrollListener P;
    public Runnable Q;
    public LinearLayout a;
    public NoNetworkView b;
    public LegoListView c;
    public n09 d;
    public s09 e;
    public ez6 f;
    public long g;
    public String h;
    public y09 i;
    public w09 j;
    public e19 k;
    public do5 l;
    public co5 m;
    public boolean n;
    public kz8 o;
    public RelativeLayout p;
    public ImageView q;
    public ImageView r;
    public TbImageView s;
    public TbImageView t;
    public zz8 u;
    public Rect v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class k implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public boolean c;
        public int d;
        public int e;
        public final /* synthetic */ LegoListFragment f;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    LegoListFragment legoListFragment = this.a.f;
                    legoListFragment.w2(1, legoListFragment.G);
                    this.a.c = false;
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public b(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f.c.getListView().smoothScrollToPositionFromTop(this.a.d, this.a.e, 400);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public c(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f.c.getListView().smoothScrollToPositionFromTop(this.a.d, this.a.e, 400);
                }
            }
        }

        public k(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = legoListFragment;
            this.a = 0;
            this.b = 0;
            this.c = false;
            this.d = -1;
            this.e = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x017c  */
        @Override // android.widget.AbsListView.OnScrollListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z;
            boolean z2;
            boolean z3;
            int i4;
            int i5;
            int i6;
            int i7;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.f.d.c0() && this.f.c != null && this.f.c.getListView() != null && this.f.c.getListView().getChildAt(0) != null) {
                this.f.d.O();
                if (i == this.a && this.f.G) {
                    z = false;
                } else {
                    z = true;
                }
                int i8 = (i2 + i) - 1;
                if (i8 == this.b && !this.f.G) {
                    z = false;
                }
                if (this.b < i8) {
                    z2 = true;
                } else if (this.a > i) {
                    z2 = true;
                    z3 = true;
                    if (z2 && !this.c) {
                        BaseAdapter n2 = this.f.n2();
                        if (z3) {
                            if (n2 != null && n2.getCount() > i8) {
                                int i9 = i8 - 1;
                                if (i9 < 0) {
                                    i9 = 0;
                                }
                                Object item = n2.getItem(i9);
                                if (item instanceof BaseLegoCardInfo) {
                                    i6 = ((BaseLegoCardInfo) item).getPage();
                                } else {
                                    i6 = 0;
                                }
                                Object item2 = n2.getItem(i8);
                                if (item2 instanceof BaseLegoCardInfo) {
                                    i7 = ((BaseLegoCardInfo) item2).getPage();
                                } else {
                                    i7 = 0;
                                }
                                if (i6 != 0 && i7 != 0 && i6 < i7) {
                                    this.c = true;
                                    this.d = i8;
                                    this.e = 0;
                                    i09.a = i7;
                                    this.f.c.getListView().post(new b(this));
                                }
                            }
                        } else {
                            int i10 = i + 1;
                            if (n2 != null && n2.getCount() > i10) {
                                Object item3 = n2.getItem(i);
                                if (item3 instanceof BaseLegoCardInfo) {
                                    i4 = ((BaseLegoCardInfo) item3).getPage();
                                } else {
                                    i4 = 0;
                                }
                                Object item4 = n2.getItem(i10);
                                if (item4 instanceof BaseLegoCardInfo) {
                                    i5 = ((BaseLegoCardInfo) item4).getPage();
                                } else {
                                    i5 = 0;
                                }
                                if (i4 != 0 && i5 != 0 && i4 < i5) {
                                    int i11 = i - 1;
                                    double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                    int i12 = i;
                                    while (i11 >= 0) {
                                        Object item5 = n2.getItem(i11);
                                        if (item5 instanceof BaseLegoCardInfo) {
                                            BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) item5;
                                            if (baseLegoCardInfo.getPage() != i4) {
                                                break;
                                            }
                                            ratio += baseLegoCardInfo.getRatio();
                                            int i13 = i11;
                                            i11--;
                                            i12 = i13;
                                        }
                                    }
                                    this.c = true;
                                    if (ratio > 2.67d) {
                                        this.d = i10;
                                        this.e = (int) ((yi.u(this.f.getActivity()).widthPixels * 1.78d) + 0.5d);
                                    } else {
                                        this.d = i12;
                                        this.e = 0;
                                    }
                                    i09.a = i4;
                                    this.f.c.getListView().post(new c(this));
                                }
                            }
                        }
                    }
                    this.a = i;
                    this.b = i8;
                    if (this.e > 0) {
                        this.b = i8 - 1;
                    }
                    this.f.F = i;
                    this.f.E = i8;
                    if (!z) {
                        LegoListFragment legoListFragment = this.f;
                        legoListFragment.w2(2, legoListFragment.G);
                        return;
                    }
                    return;
                } else {
                    z2 = false;
                }
                z3 = false;
                if (z2) {
                    BaseAdapter n22 = this.f.n2();
                    if (z3) {
                    }
                }
                this.a = i;
                this.b = i8;
                if (this.e > 0) {
                }
                this.f.F = i;
                this.f.E = i8;
                if (!z) {
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                this.f.H = i;
                if (1 == i && this.f.I != null && (findFocus = this.f.I.findFocus()) != null) {
                    findFocus.clearFocus();
                }
                if (i == 0) {
                    LegoListFragment legoListFragment = this.f;
                    legoListFragment.w2(1, legoListFragment.G);
                    if (this.c) {
                        this.f.d.I0(i09.a);
                        this.f.c.getListView().setSelectionFromTop(this.d, this.e);
                        this.f.d.O();
                        this.f.c.getListView().post(new a(this));
                    }
                }
                if (this.f.J != null) {
                    this.f.J.onScrollStateChanged(absListView, i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        public a(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.t.setVisibility(8);
                this.a.s.setVisibility(8);
                this.a.a.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.a.setVisibility(8);
                this.a.s.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        public b(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.getActivity().finish();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.a.a.setVisibility(8);
                if (this.a.u.b()) {
                    this.a.t.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x09 a;
        public final /* synthetic */ LegoListFragment b;

        public c(LegoListFragment legoListFragment, x09 x09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment, x09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = legoListFragment;
            this.a = x09Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.b.mIsLogin) {
                    ViewHelper.skipToLoginActivity(this.b.getActivity());
                } else if (this.b.o != null) {
                    this.b.o.h(this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements f19 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        @Override // com.baidu.tieba.f19
        public void c(long j, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
            }
        }

        public d(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // com.baidu.tieba.f19
        public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
                if (z) {
                    LegoListFragment legoListFragment = this.a;
                    legoListFragment.r2(legoListFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (z && (dataRes == null || dataRes.cards == null)) {
                    if (this.a.getPageContext() != null && this.a.getPageContext().getResources() != null) {
                        LegoListFragment legoListFragment2 = this.a;
                        legoListFragment2.showNetRefreshView(legoListFragment2.getView(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e1f), false);
                        return;
                    }
                    return;
                }
                this.a.n = true;
                this.a.j.b(z, dataRes, z2, i);
                if (!TextUtils.isEmpty(this.a.j.j()) && !TextUtils.isEmpty(this.a.j.k())) {
                    if (this.a.o != null) {
                        this.a.o.j(this.a.j.j(), this.a.j.k());
                    }
                } else if (this.a.o != null) {
                    this.a.o.i(this.a.j.i());
                }
                if (this.a.o != null) {
                    this.a.o.g(this.a.j.e());
                }
                this.a.c.u(this.a.j, false);
                if (this.a.y && this.a.A) {
                    LegoListFragment legoListFragment3 = this.a;
                    legoListFragment3.k2(legoListFragment3.j.e());
                }
            }
        }

        @Override // com.baidu.tieba.f19
        public void b(long j, String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) {
                LegoListFragment legoListFragment = this.a;
                legoListFragment.r2(legoListFragment.getView());
                if (this.a.j.d()) {
                    this.a.c.u(this.a.j, false);
                } else if (this.a.getPageContext() != null && this.a.getPageContext().getResources() != null) {
                    LegoListFragment legoListFragment2 = this.a;
                    legoListFragment2.showNetRefreshView(legoListFragment2.getView(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        public e(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null) {
                this.a.k.c(2, this.a.i.a, this.a.i.b, 1, "");
                this.a.s2();
                LegoListFragment legoListFragment = this.a;
                legoListFragment.I2(legoListFragment.getView(), false, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c8));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements r09 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        public f(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // com.baidu.tieba.r09
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.e != null) {
                this.a.e.l(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ez8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        public g(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // com.baidu.tieba.ez8
        public void a(int i, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) {
                this.a.k.c(2, j, str, i, str2);
            }
        }

        @Override // com.baidu.tieba.ez8
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                this.a.k.a(j, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        public h(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                this.a.d.s0(this.a.p2());
                if (!this.a.isFullScreen()) {
                    this.a.d.O();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        public i(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (!this.a.d.c0()) {
                    return true;
                }
                if (this.a.c != null && view2 == this.a.c.getListView() && this.a.f != null) {
                    this.a.f.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ez6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        @Override // com.baidu.tieba.ez6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.ez6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public j(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // com.baidu.tieba.ez6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.a.G = false;
        }

        @Override // com.baidu.tieba.ez6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) != null) {
                return;
            }
            this.a.G = true;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        public l(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e != null) {
                this.a.e.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        public m(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        public n(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.a.setVisibility(8);
                this.a.s.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.a.u.b()) {
                    this.a.a.setVisibility(8);
                    this.a.K2();
                    return;
                }
                this.a.a.setVisibility(0);
                this.a.s.setVisibility(8);
            }
        }
    }

    public LegoListFragment() {
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
        this.n = false;
        this.y = false;
        this.E = -1;
        this.F = -1;
        this.G = false;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = new f(this);
        this.L = new g(this);
        this.M = new h(this);
        this.N = new i(this);
        this.O = new j(this);
        this.P = new k(this);
        this.Q = new l(this);
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.t == null) {
                getActivity().finish();
                return;
            }
            this.s.N(this.u.a, 17, false);
            Rect rect = this.v;
            int i2 = rect.left;
            float f2 = rect.top - this.x;
            float f3 = this.w / (rect.right - i2);
            AnimationSet animationSet = new AnimationSet(false);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i2, 0.0f, f2);
            float f4 = 1.0f / f3;
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f4, 1.0f, f4);
            this.s.setPivotX(0.5f);
            this.s.setPivotY(0.5f);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.setDuration(200L);
            this.s.startAnimation(animationSet);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(new b(this));
        }
    }

    public void A2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.y = z;
        }
    }

    public void B2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.h = str;
        }
    }

    public void C2(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relativeLayout) == null) {
            this.p = relativeLayout;
        }
    }

    public void D2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.A = z;
        }
    }

    public void E2(kz8 kz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kz8Var) == null) {
            this.o = kz8Var;
        }
    }

    public void F2(lz8 lz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lz8Var) == null) {
            this.J = lz8Var;
        }
    }

    public void G2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.C = str;
        }
    }

    public void H2(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.g = j2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onActivityCreated(bundle);
            u2();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, configuration) == null) && configuration != null && (relativeLayout = this.p) != null) {
            if (configuration.orientation == 2) {
                relativeLayout.setVisibility(8);
            } else if (this.A) {
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(8);
            }
        }
    }

    public final void r2(View view2) {
        co5 co5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, view2) == null) && (co5Var = this.m) != null) {
            co5Var.dettachView(view2);
            this.m = null;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.B = str;
        }
    }

    public void y2(n09 n09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, n09Var) == null) {
            this.d = n09Var;
            n09Var.w0(this.K);
        }
    }

    public void z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.z = z;
        }
    }

    public void x2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            zz8 a2 = zz8.a(str);
            this.u = a2;
            a2.d(str2);
        }
    }

    public static void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            Set<String> set = R;
            if (set == null) {
                R = new HashSet();
            } else {
                set.clear();
            }
        }
    }

    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return !this.d.c0();
        }
        return invokeV.booleanValue;
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                I2(getView(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c8));
            }
            this.c.setViewForeground();
        }
    }

    public BaseAdapter n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LegoListView legoListView = this.c;
            if (legoListView == null) {
                return null;
            }
            return legoListView.d;
        }
        return (BaseAdapter) invokeV.objValue;
    }

    public int o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            this.c.t();
            s09 s09Var = this.e;
            if (s09Var != null) {
                s09Var.c();
            }
            zg.a().removeCallbacks(this.Q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            this.c.setViewBackGround();
            s09 s09Var = this.e;
            if (s09Var != null) {
                s09Var.n(false);
                this.e.t();
            }
            zg.a().removeCallbacks(this.Q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            this.c.setViewForeground();
            s09 s09Var = this.e;
            if (s09Var != null) {
                s09Var.n(true);
                zg.a().postDelayed(this.Q, 200L);
            }
        }
    }

    public int p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int[] iArr = new int[2];
            this.c.getLocationOnScreen(iArr);
            return iArr[1];
        }
        return invokeV.intValue;
    }

    public s09 q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.e;
        }
        return (s09) invokeV.objValue;
    }

    public final void s2() {
        do5 do5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (do5Var = this.l) != null) {
            do5Var.dettachView(getView());
            this.l = null;
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            e19 c2 = d19.d().c(getPageContext(), getUniqueId());
            this.k = c2;
            c2.b(new d(this));
        }
    }

    public final void I2(View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.m == null) {
                if (i2 < 0) {
                    this.m = new co5(getActivity());
                } else {
                    this.m = new co5(getActivity(), i2);
                }
                this.m.onChangeSkinType();
            }
            this.m.attachView(view2, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048606, this, view2, str, z) == null) {
            if (this.l == null) {
                this.l = new do5(getPageContext().getPageActivity(), new e(this));
            }
            this.l.k(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07037a));
            this.l.m(str);
            this.l.attachView(view2, z);
            this.l.p();
        }
    }

    public final void J2(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            int i2 = rect.right;
            int i3 = rect.left;
            float f2 = this.w / (i2 - i3);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, Key.SCALE_X, 1.0f, f2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s, Key.SCALE_Y, 1.0f, f2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.s, Key.TRANSLATION_X, -i3);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.s, Key.TRANSLATION_Y, -rect.top);
            this.s.setPivotX(0.0f);
            this.s.setPivotY(0.0f);
            animatorSet.setDuration(500L);
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            animatorSet.addListener(new n(this));
            animatorSet.start();
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.t.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.t, Key.TRANSLATION_Y, -this.D);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.t, Key.ALPHA, 0.0f, 1.0f);
            animatorSet.setDuration(500L);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            if (!TextUtils.isEmpty(this.C)) {
                this.j.q(this.C);
                if (this.j.n()) {
                    k2(this.j.e());
                    this.c.u(this.j, true);
                    return;
                }
            }
            if (isAdded() && isPrimary() && !this.n) {
                m2();
            }
        }
    }

    public final void k2(List<x09> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, list) != null) || this.r == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.r.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).d == 2) {
                x09 x09Var = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2).c)) {
                    this.r.setVisibility(0);
                    this.r.setOnClickListener(new c(this, x09Var));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (this.b != null) {
                this.b.d(r9.a(getActivity()), i2);
            }
            if (this.p != null) {
                getBaseFragmentActivity().getLayoutMode().k(this.p);
            }
            super.onChangeSkinType(i2);
        }
    }

    public final LegoListView v2(ez8 ez8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, ez8Var)) == null) {
            LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.y);
            legoListView.d.E(this.B);
            if (this.A) {
                legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
            }
            legoListView.v(getUniqueId());
            legoListView.setCallback(ez8Var);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        zz8 zz8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            this.w = yi.l(getActivity());
            FrameLayout frameLayout = new FrameLayout(getActivity());
            LinearLayout linearLayout = new LinearLayout(getActivity());
            this.a = linearLayout;
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.a.setOrientation(1);
            NoNetworkView noNetworkView = new NoNetworkView(getActivity());
            this.b = noNetworkView;
            if (!this.A) {
                this.a.addView(noNetworkView);
                if (yi.G()) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                }
            }
            LegoListView v2 = v2(this.L);
            this.c = v2;
            v2.setDrawingCacheEnabled(false);
            y09 y09Var = new y09();
            this.i = y09Var;
            y09Var.a = this.g;
            y09Var.b = this.h;
            w09 w09Var = new w09(y09Var);
            this.j = w09Var;
            this.c.u(w09Var, true);
            this.a.addView(this.c);
            this.c.getListView().setOnScrollListener(this.P);
            this.c.getListView().addOnLayoutChangeListener(this.M);
            this.c.getListView().setOnTouchListener(this.N);
            ez6 ez6Var = new ez6();
            this.f = ez6Var;
            ez6Var.d(this.O);
            this.e = this.c.getPlaySwitchController();
            frameLayout.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            if (this.A) {
                this.p.setVisibility(0);
                this.r = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f0904e3);
                yi.b(getActivity(), this.r, 20, 20, 20, 20);
                this.r.setVisibility(8);
                this.q = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f0904ab);
                yi.b(getActivity(), this.q, 20, 20, 20, 20);
                this.q.setOnClickListener(new m(this));
                getBaseFragmentActivity().setSwipeBackEnabled(false);
                if (this.z && (zz8Var = this.u) != null && zz8Var.c()) {
                    frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                    int v = yi.v(getActivity());
                    this.x = v;
                    Rect rect = this.u.b;
                    this.v = rect;
                    rect.top -= v;
                    rect.bottom -= v;
                    TbImageView tbImageView = new TbImageView(getActivity());
                    this.s = tbImageView;
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Rect rect2 = this.v;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect2.right - rect2.left, rect2.bottom - rect2.top);
                    Rect rect3 = this.v;
                    layoutParams.setMargins(rect3.left, rect3.top, 0, 0);
                    this.s.setLayoutParams(layoutParams);
                    this.s.N(this.u.a, 17, false);
                    frameLayout.addView(this.s, layoutParams);
                    if (this.u.b()) {
                        Rect rect4 = this.u.d;
                        Rect rect5 = this.v;
                        float f2 = this.w / (rect5.right - rect5.left);
                        this.D = yi.g(getActivity(), R.dimen.obfuscated_res_0x7f070359);
                        Rect rect6 = this.v;
                        float f3 = f2 * (rect6.bottom - rect6.top);
                        TbImageView tbImageView2 = new TbImageView(getActivity());
                        this.t = tbImageView2;
                        tbImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                        int i2 = this.w;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, (int) (i2 * (((rect4.bottom - rect4.top) * 1.0d) / (rect4.right - rect4.left))));
                        layoutParams2.setMargins(0, (int) (f3 + this.D), 0, 0);
                        this.t.setLayoutParams(layoutParams2);
                        this.t.N(this.u.c, 17, false);
                        frameLayout.addView(this.t, layoutParams2);
                        this.t.setVisibility(8);
                    }
                    J2(this.v);
                    this.a.setVisibility(8);
                }
            } else {
                RelativeLayout relativeLayout = this.p;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.I = activity.getWindow().getDecorView();
            }
            return frameLayout;
        }
        return (View) invokeLLL.objValue;
    }

    public final void w2(int i2, boolean z) {
        LegoListView legoListView;
        sz8 sz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.e != null && (legoListView = this.c) != null && legoListView.getListView() != null && (sz8Var = this.c.d) != null && sz8Var.getCount() != 0) {
            this.e.j(this.F, this.E, z, i2);
        }
    }
}
