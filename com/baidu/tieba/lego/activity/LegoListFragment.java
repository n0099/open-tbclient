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
import d.a.q0.i0.a;
import d.a.q0.w2.w;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
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
    public d.a.q0.n1.k N;
    public d.a.q0.n1.o.l.l O;
    public d.a.q0.n1.d P;
    public View.OnLayoutChangeListener Q;
    public View.OnTouchListener R;
    public a.b S;
    public AbsListView.OnScrollListener T;
    public Runnable U;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f18207e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f18208f;

    /* renamed from: g  reason: collision with root package name */
    public LegoListView f18209g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.n1.o.l.c f18210h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.n1.o.l.m f18211i;
    public d.a.q0.i0.a j;
    public long k;
    public String l;
    public d.a.q0.n1.p.e m;
    public d.a.q0.n1.p.c n;
    public d.a.q0.n1.s.a o;
    public d.a.p0.f0.h p;
    public d.a.p0.f0.g q;
    public boolean r;
    public d.a.q0.n1.j s;
    public RelativeLayout t;
    public ImageView u;
    public ImageView v;
    public TbImageView w;
    public TbImageView x;
    public d.a.q0.n1.o.h.a y;
    public Rect z;

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18212e;

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
            this.f18212e = legoListFragment;
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
                this.f18212e.x.setVisibility(8);
                this.f18212e.w.setVisibility(8);
                this.f18212e.f18207e.setVisibility(0);
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
                this.f18212e.f18207e.setVisibility(8);
                this.f18212e.w.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18213a;

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
            this.f18213a = legoListFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f18213a.getActivity().finish();
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
                this.f18213a.f18207e.setVisibility(8);
                if (this.f18213a.y.b()) {
                    this.f18213a.x.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.n1.p.d f18214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18215f;

        public c(LegoListFragment legoListFragment, d.a.q0.n1.p.d dVar) {
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
            this.f18215f = legoListFragment;
            this.f18214e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18215f.mIsLogin) {
                    if (this.f18215f.s != null) {
                        this.f18215f.s.h(this.f18214e);
                        return;
                    }
                    return;
                }
                ViewHelper.skipToLoginActivity(this.f18215f.getActivity());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.q0.n1.s.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18216a;

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
            this.f18216a = legoListFragment;
        }

        @Override // d.a.q0.n1.s.b
        public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i2)}) == null) {
                if (z) {
                    LegoListFragment legoListFragment = this.f18216a;
                    legoListFragment.w1(legoListFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    this.f18216a.r = true;
                    this.f18216a.n.c(z, dataRes, z2, i2);
                    if (TextUtils.isEmpty(this.f18216a.n.k()) || TextUtils.isEmpty(this.f18216a.n.l())) {
                        if (this.f18216a.s != null) {
                            this.f18216a.s.i(this.f18216a.n.j());
                        }
                    } else if (this.f18216a.s != null) {
                        this.f18216a.s.j(this.f18216a.n.k(), this.f18216a.n.l());
                    }
                    if (this.f18216a.s != null) {
                        this.f18216a.s.g(this.f18216a.n.f());
                    }
                    this.f18216a.f18209g.u(this.f18216a.n, false);
                    if (this.f18216a.C && this.f18216a.E) {
                        LegoListFragment legoListFragment2 = this.f18216a;
                        legoListFragment2.p1(legoListFragment2.n.f());
                    }
                } else if (this.f18216a.getPageContext() == null || this.f18216a.getPageContext().getResources() == null) {
                } else {
                    LegoListFragment legoListFragment3 = this.f18216a;
                    legoListFragment3.showNetRefreshView(legoListFragment3.getView(), this.f18216a.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }
        }

        @Override // d.a.q0.n1.s.b
        public void b(long j, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) {
                LegoListFragment legoListFragment = this.f18216a;
                legoListFragment.w1(legoListFragment.getView());
                if (this.f18216a.n.d()) {
                    this.f18216a.f18209g.u(this.f18216a.n, false);
                } else if (this.f18216a.getPageContext() == null || this.f18216a.getPageContext().getResources() == null) {
                } else {
                    LegoListFragment legoListFragment2 = this.f18216a;
                    legoListFragment2.showNetRefreshView(legoListFragment2.getView(), this.f18216a.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
                }
            }
        }

        @Override // d.a.q0.n1.s.b
        public void c(long j, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18217e;

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
            this.f18217e = legoListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18217e.o == null) {
                return;
            }
            this.f18217e.o.c(2, this.f18217e.m.f61283a, this.f18217e.m.f61284b, 1, "");
            this.f18217e.x1();
            LegoListFragment legoListFragment = this.f18217e;
            legoListFragment.N1(legoListFragment.getView(), false, this.f18217e.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.q0.n1.o.l.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18218a;

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
            this.f18218a = legoListFragment;
        }

        @Override // d.a.q0.n1.o.l.l
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f18218a.f18211i == null) {
                return;
            }
            this.f18218a.f18211i.l(str);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.q0.n1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18219a;

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
            this.f18219a = legoListFragment;
        }

        @Override // d.a.q0.n1.d
        public void a(int i2, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2}) == null) {
                this.f18219a.o.c(2, j, str, i2, str2);
            }
        }

        @Override // d.a.q0.n1.d
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                this.f18219a.o.a(j, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18220e;

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
            this.f18220e = legoListFragment;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                this.f18220e.f18210h.u0(this.f18220e.u1());
                if (this.f18220e.C()) {
                    return;
                }
                this.f18220e.f18210h.Q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18221e;

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
            this.f18221e = legoListFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f18221e.f18210h.e0()) {
                    if (this.f18221e.f18209g == null || view != this.f18221e.f18209g.getListView() || this.f18221e.j == null) {
                        return false;
                    }
                    this.f18221e.j.c(motionEvent);
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18222a;

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
            this.f18222a = legoListFragment;
        }

        @Override // d.a.q0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f18222a.K = false;
            }
        }

        @Override // d.a.q0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f18222a.K = true;
            }
        }

        @Override // d.a.q0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.q0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f18223e;

        /* renamed from: f  reason: collision with root package name */
        public int f18224f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18225g;

        /* renamed from: h  reason: collision with root package name */
        public int f18226h;

        /* renamed from: i  reason: collision with root package name */
        public int f18227i;
        public final /* synthetic */ LegoListFragment j;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f18228e;

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
                this.f18228e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    LegoListFragment legoListFragment = this.f18228e.j;
                    legoListFragment.B1(1, legoListFragment.K);
                    this.f18228e.f18225g = false;
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f18229e;

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
                this.f18229e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f18229e.j.f18209g.getListView().smoothScrollToPositionFromTop(this.f18229e.f18226h, this.f18229e.f18227i, 400);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f18230e;

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
                this.f18230e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f18230e.j.f18209g.getListView().smoothScrollToPositionFromTop(this.f18230e.f18226h, this.f18230e.f18227i, 400);
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
            this.f18223e = 0;
            this.f18224f = 0;
            this.f18225g = false;
            this.f18226h = -1;
            this.f18227i = 0;
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
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || !this.j.f18210h.e0() || this.j.f18209g == null || this.j.f18209g.getListView() == null || this.j.f18209g.getListView().getChildAt(0) == null) {
                return;
            }
            this.j.f18210h.Q();
            boolean z3 = (i2 == this.f18223e && this.j.K) ? false : true;
            int i5 = (i3 + i2) - 1;
            if (i5 == this.f18224f && !this.j.K) {
                z3 = false;
            }
            if (this.f18224f < i5) {
                z = true;
            } else if (this.f18223e > i2) {
                z = true;
                z2 = true;
                if (z && !this.f18225g) {
                    BaseAdapter s1 = this.j.s1();
                    if (z2) {
                        if (s1 != null && s1.getCount() > i5) {
                            int i6 = i5 - 1;
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            Object item = s1.getItem(i6);
                            int page = item instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item).getPage() : 0;
                            Object item2 = s1.getItem(i5);
                            int page2 = item2 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item2).getPage() : 0;
                            if (page != 0 && page2 != 0 && page < page2) {
                                this.f18225g = true;
                                this.f18226h = i5;
                                this.f18227i = 0;
                                d.a.q0.n1.o.k.c.f61192a = page2;
                                this.j.f18209g.getListView().post(new b(this));
                            }
                        }
                    } else {
                        int i7 = i2 + 1;
                        if (s1 != null && s1.getCount() > i7) {
                            Object item3 = s1.getItem(i2);
                            int page3 = item3 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item3).getPage() : 0;
                            Object item4 = s1.getItem(i7);
                            int page4 = item4 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item4).getPage() : 0;
                            if (page3 != 0 && page4 != 0 && page3 < page4) {
                                int i8 = i2 - 1;
                                double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                int i9 = i2;
                                while (i8 >= 0) {
                                    Object item5 = s1.getItem(i8);
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
                                this.f18225g = true;
                                if (ratio > 2.67d) {
                                    this.f18226h = i7;
                                    this.f18227i = (int) ((d.a.d.e.p.l.q(this.j.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.f18226h = i9;
                                    this.f18227i = 0;
                                }
                                d.a.q0.n1.o.k.c.f61192a = page3;
                                this.j.f18209g.getListView().post(new c(this));
                            }
                        }
                    }
                }
                this.f18223e = i2;
                this.f18224f = i5;
                if (this.f18227i > 0) {
                    this.f18224f = i5 - 1;
                }
                this.j.J = i2;
                this.j.I = i5;
                if (z3) {
                    return;
                }
                LegoListFragment legoListFragment = this.j;
                legoListFragment.B1(2, legoListFragment.K);
                return;
            } else {
                z = false;
            }
            z2 = false;
            if (z) {
                BaseAdapter s12 = this.j.s1();
                if (z2) {
                }
            }
            this.f18223e = i2;
            this.f18224f = i5;
            if (this.f18227i > 0) {
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
                    legoListFragment.B1(1, legoListFragment.K);
                    if (this.f18225g) {
                        this.j.f18210h.K0(d.a.q0.n1.o.k.c.f61192a);
                        this.j.f18209g.getListView().setSelectionFromTop(this.f18226h, this.f18227i);
                        this.j.f18210h.Q();
                        this.j.f18209g.getListView().post(new a(this));
                    }
                }
                if (this.j.N != null) {
                    this.j.N.onScrollStateChanged(absListView, i2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18231e;

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
            this.f18231e = legoListFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18231e.f18211i == null) {
                return;
            }
            this.f18231e.f18211i.m();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18232e;

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
            this.f18232e = legoListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18232e.q1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f18233e;

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
            this.f18233e = legoListFragment;
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
                if (this.f18233e.y.b()) {
                    this.f18233e.f18207e.setVisibility(8);
                    this.f18233e.P1();
                    return;
                }
                this.f18233e.f18207e.setVisibility(0);
                this.f18233e.w.setVisibility(8);
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
                this.f18233e.f18207e.setVisibility(8);
                this.f18233e.w.setVisibility(0);
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

    public static void y1() {
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

    public final LegoListView A1(d.a.q0.n1.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.C);
            legoListView.f18192h.E(this.F);
            if (this.E) {
                legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
            }
            legoListView.v(getUniqueId());
            legoListView.setCallback(dVar);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    public final void B1(int i2, boolean z) {
        LegoListView legoListView;
        d.a.q0.n1.n.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f18211i == null || (legoListView = this.f18209g) == null || legoListView.getListView() == null || (aVar = this.f18209g.f18192h) == null || aVar.getCount() == 0) {
            return;
        }
        this.f18211i.j(this.J, this.I, z, i2);
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.f18210h.e0() : invokeV.booleanValue;
    }

    public void C1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            d.a.q0.n1.o.h.a a2 = d.a.q0.n1.o.h.a.a(str);
            this.y = a2;
            a2.d(str2);
        }
    }

    public void D1(d.a.q0.n1.o.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f18210h = cVar;
            cVar.y0(this.O);
        }
    }

    public void E1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.D = z;
        }
    }

    public void F1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.C = z;
        }
    }

    public void G1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.l = str;
        }
    }

    public void H1(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, relativeLayout) == null) {
            this.t = relativeLayout;
        }
    }

    public void I1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.E = z;
        }
    }

    public void J1(d.a.q0.n1.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
            this.s = jVar;
        }
    }

    public void K1(d.a.q0.n1.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, kVar) == null) {
            this.N = kVar;
        }
    }

    public void L1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.G = str;
        }
    }

    public void M1(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.k = j2;
        }
    }

    public final void N1(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.q == null) {
                if (i2 < 0) {
                    this.q = new d.a.p0.f0.g(getActivity());
                } else {
                    this.q = new d.a.p0.f0.g(getActivity(), i2);
                }
                this.q.onChangeSkinType();
            }
            this.q.attachView(view, z);
        }
    }

    public final void O1(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rect) == null) {
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

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onActivityCreated(bundle);
            z1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (this.f18208f != null) {
                this.f18208f.c(d.a.d.a.j.a(getActivity()), i2);
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
        d.a.q0.n1.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            this.A = d.a.d.e.p.l.k(getActivity());
            FrameLayout frameLayout = new FrameLayout(getActivity());
            LinearLayout linearLayout = new LinearLayout(getActivity());
            this.f18207e = linearLayout;
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f18207e.setOrientation(1);
            NoNetworkView noNetworkView = new NoNetworkView(getActivity());
            this.f18208f = noNetworkView;
            if (!this.E) {
                this.f18207e.addView(noNetworkView);
                if (d.a.d.e.p.l.D()) {
                    this.f18208f.setVisibility(8);
                } else {
                    this.f18208f.setVisibility(0);
                }
            }
            LegoListView A1 = A1(this.P);
            this.f18209g = A1;
            A1.setDrawingCacheEnabled(false);
            d.a.q0.n1.p.e eVar = new d.a.q0.n1.p.e();
            this.m = eVar;
            eVar.f61283a = this.k;
            eVar.f61284b = this.l;
            d.a.q0.n1.p.c cVar = new d.a.q0.n1.p.c(eVar);
            this.n = cVar;
            this.f18209g.u(cVar, true);
            this.f18207e.addView(this.f18209g);
            this.f18209g.getListView().setOnScrollListener(this.T);
            this.f18209g.getListView().addOnLayoutChangeListener(this.Q);
            this.f18209g.getListView().setOnTouchListener(this.R);
            d.a.q0.i0.a aVar2 = new d.a.q0.i0.a();
            this.j = aVar2;
            aVar2.d(this.S);
            this.f18211i = this.f18209g.getPlaySwitchController();
            frameLayout.addView(this.f18207e, new FrameLayout.LayoutParams(-1, -1));
            if (this.E) {
                this.t.setVisibility(0);
                this.v = (ImageView) this.t.findViewById(R.id.btn_share);
                d.a.d.e.p.l.c(getActivity(), this.v, 20, 20, 20, 20);
                this.v.setVisibility(8);
                this.u = (ImageView) this.t.findViewById(R.id.btn_close);
                d.a.d.e.p.l.c(getActivity(), this.u, 20, 20, 20, 20);
                this.u.setOnClickListener(new m(this));
                getBaseFragmentActivity().setSwipeBackEnabled(false);
                if (this.D && (aVar = this.y) != null && aVar.c()) {
                    frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                    int r = d.a.d.e.p.l.r(getActivity());
                    this.B = r;
                    Rect rect = this.y.f61166b;
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
                    this.w.M(this.y.f61165a, 17, false);
                    frameLayout.addView(this.w, layoutParams);
                    if (this.y.b()) {
                        Rect rect4 = this.y.f61168d;
                        Rect rect5 = this.z;
                        float f2 = this.A / (rect5.right - rect5.left);
                        this.H = d.a.d.e.p.l.g(getActivity(), R.dimen.ds10);
                        Rect rect6 = this.z;
                        float f3 = f2 * (rect6.bottom - rect6.top);
                        TbImageView tbImageView2 = new TbImageView(getActivity());
                        this.x = tbImageView2;
                        tbImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                        int i2 = this.A;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, (int) (i2 * (((rect4.bottom - rect4.top) * 1.0d) / (rect4.right - rect4.left))));
                        layoutParams2.setMargins(0, (int) (f3 + this.H), 0, 0);
                        this.x.setLayoutParams(layoutParams2);
                        this.x.M(this.y.f61167c, 17, false);
                        frameLayout.addView(this.x, layoutParams2);
                        this.x.setVisibility(8);
                    }
                    O1(this.z);
                    this.f18207e.setVisibility(8);
                }
                w.o().l().f(this.k, this.l, this.F);
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
            this.f18209g.t();
            d.a.q0.n1.o.l.m mVar = this.f18211i;
            if (mVar != null) {
                mVar.c();
            }
            d.a.d.e.m.e.a().removeCallbacks(this.U);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            this.f18209g.setViewBackGround();
            d.a.q0.n1.o.l.m mVar = this.f18211i;
            if (mVar != null) {
                mVar.n(false);
                this.f18211i.t();
            }
            d.a.d.e.m.e.a().removeCallbacks(this.U);
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
                    p1(this.n.f());
                    this.f18209g.u(this.n, true);
                    return;
                }
            }
            if (isAdded() && isPrimary() && !this.r) {
                r1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            this.f18209g.setViewForeground();
            d.a.q0.n1.o.l.m mVar = this.f18211i;
            if (mVar != null) {
                mVar.n(true);
                d.a.d.e.m.e.a().postDelayed(this.U, 200L);
            }
        }
    }

    public final void p1(List<d.a.q0.n1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, list) == null) || this.v == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.v.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).f61278d == 2) {
                d.a.q0.n1.p.d dVar = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2).f61277c)) {
                    this.v.setVisibility(0);
                    this.v.setOnClickListener(new c(this, dVar));
                }
            }
        }
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.x == null) {
                getActivity().finish();
                return;
            }
            this.w.M(this.y.f61165a, 17, false);
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

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (d.a.d.e.p.j.z()) {
                N1(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            this.f18209g.setViewForeground();
        }
    }

    public BaseAdapter s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            LegoListView legoListView = this.f18209g;
            if (legoListView == null) {
                return null;
            }
            return legoListView.f18192h;
        }
        return (BaseAdapter) invokeV.objValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.F = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048606, this, view, str, z) == null) {
            if (this.p == null) {
                this.p = new d.a.p0.f0.h(getPageContext().getPageActivity(), new e(this));
            }
            this.p.j(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.p.l(str);
            this.p.attachView(view, z);
            this.p.o();
        }
    }

    public int t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.L : invokeV.intValue;
    }

    public int u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            int[] iArr = new int[2];
            this.f18209g.getLocationOnScreen(iArr);
            return iArr[1];
        }
        return invokeV.intValue;
    }

    public d.a.q0.n1.o.l.m v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f18211i : (d.a.q0.n1.o.l.m) invokeV.objValue;
    }

    public final void w1(View view) {
        d.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, view) == null) || (gVar = this.q) == null) {
            return;
        }
        gVar.dettachView(view);
        this.q = null;
    }

    public final void x1() {
        d.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (hVar = this.p) == null) {
            return;
        }
        hVar.dettachView(getView());
        this.p = null;
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            d.a.q0.n1.s.a c2 = d.a.q0.n1.r.b.d().c(getPageContext(), getUniqueId());
            this.o = c2;
            c2.b(new d(this));
        }
    }
}
