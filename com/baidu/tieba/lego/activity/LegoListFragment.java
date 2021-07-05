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
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import d.a.s0.i0.a;
import d.a.s0.w2.w;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class LegoListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static Set<String> V;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public float H;
    public int I;
    public int J;
    public boolean K;
    public int L;
    public View M;
    public d.a.s0.n1.k N;
    public d.a.s0.n1.o.l.m O;
    public d.a.s0.n1.d P;
    public View.OnLayoutChangeListener Q;
    public View.OnTouchListener R;
    public a.b S;
    public AbsListView.OnScrollListener T;
    public Runnable U;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f18111e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f18112f;

    /* renamed from: g  reason: collision with root package name */
    public LegoListView f18113g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.n1.o.l.c f18114h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.n1.o.l.n f18115i;
    public d.a.s0.i0.a j;
    public long k;
    public String l;
    public d.a.s0.n1.p.e m;
    public d.a.s0.n1.p.c n;
    public d.a.s0.n1.s.a o;
    public d.a.r0.d0.h p;
    public d.a.r0.d0.g q;
    public boolean r;
    public d.a.s0.n1.j s;
    public RelativeLayout t;
    public ImageView u;
    public ImageView v;
    public TbImageView w;
    public TbImageView x;
    public d.a.s0.n1.o.h.a y;
    public Rect z;

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18116e;

        public a(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18116e = legoListFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f18116e.x.setVisibility(8);
                this.f18116e.w.setVisibility(8);
                this.f18116e.f18111e.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f18116e.f18111e.setVisibility(8);
                this.f18116e.w.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18117a;

        public b(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18117a = legoListFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f18117a.getActivity().finish();
            }
        }

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
                this.f18117a.f18111e.setVisibility(8);
                if (this.f18117a.y.b()) {
                    this.f18117a.x.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.n1.p.d f18118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18119f;

        public c(LegoListFragment legoListFragment, d.a.s0.n1.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18119f = legoListFragment;
            this.f18118e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18119f.mIsLogin) {
                    if (this.f18119f.s != null) {
                        this.f18119f.s.h(this.f18118e);
                        return;
                    }
                    return;
                }
                ViewHelper.skipToLoginActivity(this.f18119f.getActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.s0.n1.s.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18120a;

        public d(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18120a = legoListFragment;
        }

        @Override // d.a.s0.n1.s.b
        public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i2)}) == null) {
                if (z) {
                    LegoListFragment legoListFragment = this.f18120a;
                    legoListFragment.q1(legoListFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    this.f18120a.r = true;
                    this.f18120a.n.c(z, dataRes, z2, i2);
                    if (TextUtils.isEmpty(this.f18120a.n.k()) || TextUtils.isEmpty(this.f18120a.n.l())) {
                        if (this.f18120a.s != null) {
                            this.f18120a.s.i(this.f18120a.n.j());
                        }
                    } else if (this.f18120a.s != null) {
                        this.f18120a.s.j(this.f18120a.n.k(), this.f18120a.n.l());
                    }
                    if (this.f18120a.s != null) {
                        this.f18120a.s.g(this.f18120a.n.f());
                    }
                    this.f18120a.f18113g.u(this.f18120a.n, false);
                    if (this.f18120a.C && this.f18120a.E) {
                        LegoListFragment legoListFragment2 = this.f18120a;
                        legoListFragment2.j1(legoListFragment2.n.f());
                    }
                } else if (this.f18120a.getPageContext() == null || this.f18120a.getPageContext().getResources() == null) {
                } else {
                    LegoListFragment legoListFragment3 = this.f18120a;
                    legoListFragment3.showNetRefreshView(legoListFragment3.getView(), this.f18120a.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }
        }

        @Override // d.a.s0.n1.s.b
        public void b(long j, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) {
                LegoListFragment legoListFragment = this.f18120a;
                legoListFragment.q1(legoListFragment.getView());
                if (this.f18120a.n.d()) {
                    this.f18120a.f18113g.u(this.f18120a.n, false);
                } else if (this.f18120a.getPageContext() == null || this.f18120a.getPageContext().getResources() == null) {
                } else {
                    LegoListFragment legoListFragment2 = this.f18120a;
                    legoListFragment2.showNetRefreshView(legoListFragment2.getView(), this.f18120a.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
                }
            }
        }

        @Override // d.a.s0.n1.s.b
        public void c(long j, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18121e;

        public e(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18121e = legoListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18121e.o == null) {
                return;
            }
            this.f18121e.o.c(2, this.f18121e.m.f63903a, this.f18121e.m.f63904b, 1, "");
            this.f18121e.r1();
            LegoListFragment legoListFragment = this.f18121e;
            legoListFragment.H1(legoListFragment.getView(), false, this.f18121e.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements d.a.s0.n1.o.l.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18122a;

        public f(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18122a = legoListFragment;
        }

        @Override // d.a.s0.n1.o.l.m
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f18122a.f18115i == null) {
                return;
            }
            this.f18122a.f18115i.l(str);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements d.a.s0.n1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18123a;

        public g(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18123a = legoListFragment;
        }

        @Override // d.a.s0.n1.d
        public void a(int i2, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2}) == null) {
                this.f18123a.o.c(2, j, str, i2, str2);
            }
        }

        @Override // d.a.s0.n1.d
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                this.f18123a.o.a(j, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18124e;

        public h(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18124e = legoListFragment;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                this.f18124e.f18114h.u0(this.f18124e.o1());
                if (this.f18124e.C()) {
                    return;
                }
                this.f18124e.f18114h.Q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18125e;

        public i(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18125e = legoListFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f18125e.f18114h.e0()) {
                    if (this.f18125e.f18113g == null || view != this.f18125e.f18113g.getListView() || this.f18125e.j == null) {
                        return false;
                    }
                    this.f18125e.j.c(motionEvent);
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18126a;

        public j(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18126a = legoListFragment;
        }

        @Override // d.a.s0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f18126a.K = false;
            }
        }

        @Override // d.a.s0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f18126a.K = true;
            }
        }

        @Override // d.a.s0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.s0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f18127e;

        /* renamed from: f  reason: collision with root package name */
        public int f18128f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18129g;

        /* renamed from: h  reason: collision with root package name */
        public int f18130h;

        /* renamed from: i  reason: collision with root package name */
        public int f18131i;
        public final /* synthetic */ LegoListFragment j;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f18132e;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18132e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    LegoListFragment legoListFragment = this.f18132e.j;
                    legoListFragment.v1(1, legoListFragment.K);
                    this.f18132e.f18129g = false;
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f18133e;

            public b(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18133e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f18133e.j.f18113g.getListView().smoothScrollToPositionFromTop(this.f18133e.f18130h, this.f18133e.f18131i, 400);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f18134e;

            public c(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18134e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f18134e.j.f18113g.getListView().smoothScrollToPositionFromTop(this.f18134e.f18130h, this.f18134e.f18131i, 400);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = legoListFragment;
            this.f18127e = 0;
            this.f18128f = 0;
            this.f18129g = false;
            this.f18130h = -1;
            this.f18131i = 0;
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
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || !this.j.f18114h.e0() || this.j.f18113g == null || this.j.f18113g.getListView() == null || this.j.f18113g.getListView().getChildAt(0) == null) {
                return;
            }
            this.j.f18114h.Q();
            boolean z3 = (i2 == this.f18127e && this.j.K) ? false : true;
            int i5 = (i3 + i2) - 1;
            if (i5 == this.f18128f && !this.j.K) {
                z3 = false;
            }
            if (this.f18128f < i5) {
                z = true;
            } else if (this.f18127e > i2) {
                z = true;
                z2 = true;
                if (z && !this.f18129g) {
                    BaseAdapter m1 = this.j.m1();
                    if (z2) {
                        if (m1 != null && m1.getCount() > i5) {
                            int i6 = i5 - 1;
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            Object item = m1.getItem(i6);
                            int page = item instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item).getPage() : 0;
                            Object item2 = m1.getItem(i5);
                            int page2 = item2 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item2).getPage() : 0;
                            if (page != 0 && page2 != 0 && page < page2) {
                                this.f18129g = true;
                                this.f18130h = i5;
                                this.f18131i = 0;
                                d.a.s0.n1.o.k.c.f63812a = page2;
                                this.j.f18113g.getListView().post(new b(this));
                            }
                        }
                    } else {
                        int i7 = i2 + 1;
                        if (m1 != null && m1.getCount() > i7) {
                            Object item3 = m1.getItem(i2);
                            int page3 = item3 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item3).getPage() : 0;
                            Object item4 = m1.getItem(i7);
                            int page4 = item4 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item4).getPage() : 0;
                            if (page3 != 0 && page4 != 0 && page3 < page4) {
                                int i8 = i2 - 1;
                                double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                int i9 = i2;
                                while (i8 >= 0) {
                                    Object item5 = m1.getItem(i8);
                                    if (item5 instanceof BaseLegoCardInfo) {
                                        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) item5;
                                        if (baseLegoCardInfo.getPage() != page3) {
                                            break;
                                        }
                                        ratio += baseLegoCardInfo.getRatio();
                                        int i10 = i8;
                                        i8--;
                                        i9 = i10;
                                    }
                                }
                                this.f18129g = true;
                                if (ratio > 2.67d) {
                                    this.f18130h = i7;
                                    this.f18131i = (int) ((d.a.c.e.p.l.q(this.j.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.f18130h = i9;
                                    this.f18131i = 0;
                                }
                                d.a.s0.n1.o.k.c.f63812a = page3;
                                this.j.f18113g.getListView().post(new c(this));
                            }
                        }
                    }
                }
                this.f18127e = i2;
                this.f18128f = i5;
                if (this.f18131i > 0) {
                    this.f18128f = i5 - 1;
                }
                this.j.J = i2;
                this.j.I = i5;
                if (z3) {
                    return;
                }
                LegoListFragment legoListFragment = this.j;
                legoListFragment.v1(2, legoListFragment.K);
                return;
            } else {
                z = false;
            }
            z2 = false;
            if (z) {
                BaseAdapter m12 = this.j.m1();
                if (z2) {
                }
            }
            this.f18127e = i2;
            this.f18128f = i5;
            if (this.f18131i > 0) {
            }
            this.j.J = i2;
            this.j.I = i5;
            if (z3) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            View findFocus;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                this.j.L = i2;
                if (1 == i2 && this.j.M != null && (findFocus = this.j.M.findFocus()) != null) {
                    findFocus.clearFocus();
                }
                if (i2 == 0) {
                    LegoListFragment legoListFragment = this.j;
                    legoListFragment.v1(1, legoListFragment.K);
                    if (this.f18129g) {
                        this.j.f18114h.K0(d.a.s0.n1.o.k.c.f63812a);
                        this.j.f18113g.getListView().setSelectionFromTop(this.f18130h, this.f18131i);
                        this.j.f18114h.Q();
                        this.j.f18113g.getListView().post(new a(this));
                    }
                }
                if (this.j.N != null) {
                    this.j.N.onScrollStateChanged(absListView, i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18135e;

        public l(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18135e = legoListFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18135e.f18115i == null) {
                return;
            }
            this.f18135e.f18115i.m();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18136e;

        public m(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18136e = legoListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18136e.k1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18137e;

        public n(LegoListFragment legoListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18137e = legoListFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.f18137e.y.b()) {
                    this.f18137e.f18111e.setVisibility(8);
                    this.f18137e.J1();
                    return;
                }
                this.f18137e.f18111e.setVisibility(0);
                this.f18137e.w.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f18137e.f18111e.setVisibility(8);
                this.f18137e.w.setVisibility(0);
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
        this.r = false;
        this.C = false;
        this.I = -1;
        this.J = -1;
        this.K = false;
        this.L = 0;
        this.M = null;
        this.N = null;
        this.O = new f(this);
        this.P = new g(this);
        this.Q = new h(this);
        this.R = new i(this);
        this.S = new j(this);
        this.T = new k(this);
        this.U = new l(this);
    }

    public static void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            Set<String> set = V;
            if (set == null) {
                V = new HashSet();
            } else {
                set.clear();
            }
        }
    }

    public void A1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.l = str;
        }
    }

    public void B1(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, relativeLayout) == null) {
            this.t = relativeLayout;
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.f18114h.e0() : invokeV.booleanValue;
    }

    public void C1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.E = z;
        }
    }

    public void D1(d.a.s0.n1.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jVar) == null) {
            this.s = jVar;
        }
    }

    public void E1(d.a.s0.n1.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            this.N = kVar;
        }
    }

    public void F1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.G = str;
        }
    }

    public void G1(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.k = j2;
        }
    }

    public final void H1(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.q == null) {
                if (i2 < 0) {
                    this.q = new d.a.r0.d0.g(getActivity());
                } else {
                    this.q = new d.a.r0.d0.g(getActivity(), i2);
                }
                this.q.onChangeSkinType();
            }
            this.q.attachView(view, z);
        }
    }

    public final void I1(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            int i2 = rect.right;
            int i3 = rect.left;
            float f2 = this.A / (i2 - i3);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.w, "scaleX", 1.0f, f2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w, "scaleY", 1.0f, f2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w, "translationX", -i3);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.w, "translationY", -rect.top);
            this.w.setPivotX(0.0f);
            this.w.setPivotY(0.0f);
            animatorSet.setDuration(500L);
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            animatorSet.addListener(new n(this));
            animatorSet.start();
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.x.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.x, "translationY", -this.H);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.x, "alpha", 0.0f, 1.0f);
            animatorSet.setDuration(500L);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new a(this));
        }
    }

    public final void j1(List<d.a.s0.n1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || this.v == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.v.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).f63898d == 2) {
                d.a.s0.n1.p.d dVar = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2).f63897c)) {
                    this.v.setVisibility(0);
                    this.v.setOnClickListener(new c(this, dVar));
                }
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.x == null) {
                getActivity().finish();
                return;
            }
            this.w.M(this.y.f63785a, 17, false);
            Rect rect = this.z;
            int i2 = rect.left;
            float f2 = rect.top - this.B;
            float f3 = this.A / (rect.right - i2);
            AnimationSet animationSet = new AnimationSet(false);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i2, 0.0f, f2);
            float f4 = 1.0f / f3;
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f4, 1.0f, f4);
            this.w.setPivotX(0.5f);
            this.w.setPivotY(0.5f);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.setDuration(200L);
            this.w.startAnimation(animationSet);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(new b(this));
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (d.a.c.e.p.j.z()) {
                H1(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            this.f18113g.setViewForeground();
        }
    }

    public BaseAdapter m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            LegoListView legoListView = this.f18113g;
            if (legoListView == null) {
                return null;
            }
            return legoListView.f18096h;
        }
        return (BaseAdapter) invokeV.objValue;
    }

    public int n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.L : invokeV.intValue;
    }

    public int o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int[] iArr = new int[2];
            this.f18113g.getLocationOnScreen(iArr);
            return iArr[1];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onActivityCreated(bundle);
            t1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (this.f18112f != null) {
                this.f18112f.c(d.a.c.a.j.a(getActivity()), i2);
            }
            if (this.t != null) {
                getBaseFragmentActivity().getLayoutMode().j(this.t);
            }
            super.onChangeSkinType(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, configuration) == null) || configuration == null || (relativeLayout = this.t) == null) {
            return;
        }
        if (configuration.orientation == 2) {
            relativeLayout.setVisibility(8);
        } else if (this.E) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        d.a.s0.n1.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            this.A = d.a.c.e.p.l.k(getActivity());
            FrameLayout frameLayout = new FrameLayout(getActivity());
            LinearLayout linearLayout = new LinearLayout(getActivity());
            this.f18111e = linearLayout;
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f18111e.setOrientation(1);
            NoNetworkView noNetworkView = new NoNetworkView(getActivity());
            this.f18112f = noNetworkView;
            if (!this.E) {
                this.f18111e.addView(noNetworkView);
                if (d.a.c.e.p.l.D()) {
                    this.f18112f.setVisibility(8);
                } else {
                    this.f18112f.setVisibility(0);
                }
            }
            LegoListView u1 = u1(this.P);
            this.f18113g = u1;
            u1.setDrawingCacheEnabled(false);
            d.a.s0.n1.p.e eVar = new d.a.s0.n1.p.e();
            this.m = eVar;
            eVar.f63903a = this.k;
            eVar.f63904b = this.l;
            d.a.s0.n1.p.c cVar = new d.a.s0.n1.p.c(eVar);
            this.n = cVar;
            this.f18113g.u(cVar, true);
            this.f18111e.addView(this.f18113g);
            this.f18113g.getListView().setOnScrollListener(this.T);
            this.f18113g.getListView().addOnLayoutChangeListener(this.Q);
            this.f18113g.getListView().setOnTouchListener(this.R);
            d.a.s0.i0.a aVar2 = new d.a.s0.i0.a();
            this.j = aVar2;
            aVar2.d(this.S);
            this.f18115i = this.f18113g.getPlaySwitchController();
            frameLayout.addView(this.f18111e, new FrameLayout.LayoutParams(-1, -1));
            if (this.E) {
                this.t.setVisibility(0);
                this.v = (ImageView) this.t.findViewById(R.id.btn_share);
                d.a.c.e.p.l.c(getActivity(), this.v, 20, 20, 20, 20);
                this.v.setVisibility(8);
                this.u = (ImageView) this.t.findViewById(R.id.btn_close);
                d.a.c.e.p.l.c(getActivity(), this.u, 20, 20, 20, 20);
                this.u.setOnClickListener(new m(this));
                getBaseFragmentActivity().setSwipeBackEnabled(false);
                if (this.D && (aVar = this.y) != null && aVar.c()) {
                    frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                    int r = d.a.c.e.p.l.r(getActivity());
                    this.B = r;
                    Rect rect = this.y.f63786b;
                    this.z = rect;
                    rect.top -= r;
                    rect.bottom -= r;
                    TbImageView tbImageView = new TbImageView(getActivity());
                    this.w = tbImageView;
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Rect rect2 = this.z;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect2.right - rect2.left, rect2.bottom - rect2.top);
                    Rect rect3 = this.z;
                    layoutParams.setMargins(rect3.left, rect3.top, 0, 0);
                    this.w.setLayoutParams(layoutParams);
                    this.w.M(this.y.f63785a, 17, false);
                    frameLayout.addView(this.w, layoutParams);
                    if (this.y.b()) {
                        Rect rect4 = this.y.f63788d;
                        Rect rect5 = this.z;
                        float f2 = this.A / (rect5.right - rect5.left);
                        this.H = d.a.c.e.p.l.g(getActivity(), R.dimen.ds10);
                        Rect rect6 = this.z;
                        float f3 = f2 * (rect6.bottom - rect6.top);
                        TbImageView tbImageView2 = new TbImageView(getActivity());
                        this.x = tbImageView2;
                        tbImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                        int i2 = this.A;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, (int) (i2 * (((rect4.bottom - rect4.top) * 1.0d) / (rect4.right - rect4.left))));
                        layoutParams2.setMargins(0, (int) (f3 + this.H), 0, 0);
                        this.x.setLayoutParams(layoutParams2);
                        this.x.M(this.y.f63787c, 17, false);
                        frameLayout.addView(this.x, layoutParams2);
                        this.x.setVisibility(8);
                    }
                    I1(this.z);
                    this.f18111e.setVisibility(8);
                }
                w.p().m().f(this.k, this.l, this.F);
            } else {
                RelativeLayout relativeLayout = this.t;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.M = activity.getWindow().getDecorView();
            }
            return frameLayout;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            this.f18113g.t();
            d.a.s0.n1.o.l.n nVar = this.f18115i;
            if (nVar != null) {
                nVar.c();
            }
            d.a.c.e.m.e.a().removeCallbacks(this.U);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            this.f18113g.setViewBackGround();
            d.a.s0.n1.o.l.n nVar = this.f18115i;
            if (nVar != null) {
                nVar.n(false);
                this.f18115i.t();
            }
            d.a.c.e.m.e.a().removeCallbacks(this.U);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            if (!TextUtils.isEmpty(this.G)) {
                this.n.r(this.G);
                if (this.n.o()) {
                    j1(this.n.f());
                    this.f18113g.u(this.n, true);
                    return;
                }
            }
            if (isAdded() && isPrimary() && !this.r) {
                l1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            this.f18113g.setViewForeground();
            d.a.s0.n1.o.l.n nVar = this.f18115i;
            if (nVar != null) {
                nVar.n(true);
                d.a.c.e.m.e.a().postDelayed(this.U, 200L);
            }
        }
    }

    public d.a.s0.n1.o.l.n p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f18115i : (d.a.s0.n1.o.l.n) invokeV.objValue;
    }

    public final void q1(View view) {
        d.a.r0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, view) == null) || (gVar = this.q) == null) {
            return;
        }
        gVar.dettachView(view);
        this.q = null;
    }

    public final void r1() {
        d.a.r0.d0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (hVar = this.p) == null) {
            return;
        }
        hVar.dettachView(getView());
        this.p = null;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.F = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048605, this, view, str, z) == null) {
            if (this.p == null) {
                this.p = new d.a.r0.d0.h(getPageContext().getPageActivity(), new e(this));
            }
            this.p.j(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.p.l(str);
            this.p.attachView(view, z);
            this.p.o();
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            d.a.s0.n1.s.a c2 = d.a.s0.n1.r.b.d().c(getPageContext(), getUniqueId());
            this.o = c2;
            c2.b(new d(this));
        }
    }

    public final LegoListView u1(d.a.s0.n1.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, dVar)) == null) {
            LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.C);
            legoListView.f18096h.E(this.F);
            if (this.E) {
                legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
            }
            legoListView.v(getUniqueId());
            legoListView.setCallback(dVar);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    public final void v1(int i2, boolean z) {
        LegoListView legoListView;
        d.a.s0.n1.n.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f18115i == null || (legoListView = this.f18113g) == null || legoListView.getListView() == null || (aVar = this.f18113g.f18096h) == null || aVar.getCount() == 0) {
            return;
        }
        this.f18115i.j(this.J, this.I, z, i2);
    }

    public void w1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            d.a.s0.n1.o.h.a a2 = d.a.s0.n1.o.h.a.a(str);
            this.y = a2;
            a2.d(str2);
        }
    }

    public void x1(d.a.s0.n1.o.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, cVar) == null) {
            this.f18114h = cVar;
            cVar.y0(this.O);
        }
    }

    public void y1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.D = z;
        }
    }

    public void z1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.C = z;
        }
    }
}
