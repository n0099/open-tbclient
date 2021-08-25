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
import c.a.q0.i0.a;
import c.a.q0.x2.y;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes7.dex */
public class LegoListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static Set<String> sHasShown;
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
    public c.a.q0.o1.k N;
    public c.a.q0.o1.o.l.l O;
    public c.a.q0.o1.d P;
    public View.OnLayoutChangeListener Q;
    public View.OnTouchListener R;
    public a.b S;
    public AbsListView.OnScrollListener T;
    public Runnable U;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f53615e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f53616f;

    /* renamed from: g  reason: collision with root package name */
    public LegoListView f53617g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.o1.o.l.c f53618h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.o1.o.l.m f53619i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.i0.a f53620j;
    public long k;
    public String l;
    public c.a.q0.o1.p.e m;
    public c.a.q0.o1.p.c n;
    public c.a.q0.o1.s.a o;
    public c.a.p0.f0.h p;
    public c.a.p0.f0.g q;
    public boolean r;
    public c.a.q0.o1.j s;
    public RelativeLayout t;
    public ImageView u;
    public ImageView v;
    public TbImageView w;
    public TbImageView x;
    public c.a.q0.o1.o.h.a y;
    public Rect z;

    /* loaded from: classes7.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53621e;

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
            this.f53621e = legoListFragment;
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
                this.f53621e.x.setVisibility(8);
                this.f53621e.w.setVisibility(8);
                this.f53621e.f53615e.setVisibility(0);
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
                this.f53621e.f53615e.setVisibility(8);
                this.f53621e.w.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53622a;

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
            this.f53622a = legoListFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f53622a.getActivity().finish();
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
                this.f53622a.f53615e.setVisibility(8);
                if (this.f53622a.y.b()) {
                    this.f53622a.x.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.o1.p.d f53623e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53624f;

        public c(LegoListFragment legoListFragment, c.a.q0.o1.p.d dVar) {
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
            this.f53624f = legoListFragment;
            this.f53623e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f53624f.mIsLogin) {
                    if (this.f53624f.s != null) {
                        this.f53624f.s.h(this.f53623e);
                        return;
                    }
                    return;
                }
                ViewHelper.skipToLoginActivity(this.f53624f.getActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.a.q0.o1.s.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53625a;

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
            this.f53625a = legoListFragment;
        }

        @Override // c.a.q0.o1.s.b
        public void a(boolean z, Message message, boolean z2, long j2, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j2), str, Integer.valueOf(i2)}) == null) {
                if (z) {
                    LegoListFragment legoListFragment = this.f53625a;
                    legoListFragment.L(legoListFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    this.f53625a.r = true;
                    this.f53625a.n.c(z, dataRes, z2, i2);
                    if (TextUtils.isEmpty(this.f53625a.n.k()) || TextUtils.isEmpty(this.f53625a.n.l())) {
                        if (this.f53625a.s != null) {
                            this.f53625a.s.i(this.f53625a.n.j());
                        }
                    } else if (this.f53625a.s != null) {
                        this.f53625a.s.j(this.f53625a.n.k(), this.f53625a.n.l());
                    }
                    if (this.f53625a.s != null) {
                        this.f53625a.s.g(this.f53625a.n.f());
                    }
                    this.f53625a.f53617g.refreshView(this.f53625a.n, false);
                    if (this.f53625a.C && this.f53625a.E) {
                        LegoListFragment legoListFragment2 = this.f53625a;
                        legoListFragment2.J(legoListFragment2.n.f());
                    }
                } else if (this.f53625a.getPageContext() == null || this.f53625a.getPageContext().getResources() == null) {
                } else {
                    LegoListFragment legoListFragment3 = this.f53625a;
                    legoListFragment3.showNetRefreshView(legoListFragment3.getView(), this.f53625a.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }
        }

        @Override // c.a.q0.o1.s.b
        public void b(long j2, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, str2, Integer.valueOf(i2)}) == null) {
                LegoListFragment legoListFragment = this.f53625a;
                legoListFragment.L(legoListFragment.getView());
                if (this.f53625a.n.d()) {
                    this.f53625a.f53617g.refreshView(this.f53625a.n, false);
                } else if (this.f53625a.getPageContext() == null || this.f53625a.getPageContext().getResources() == null) {
                } else {
                    LegoListFragment legoListFragment2 = this.f53625a;
                    legoListFragment2.showNetRefreshView(legoListFragment2.getView(), this.f53625a.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
                }
            }
        }

        @Override // c.a.q0.o1.s.b
        public void c(long j2, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, message, Boolean.valueOf(z)}) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53626e;

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
            this.f53626e = legoListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f53626e.o == null) {
                return;
            }
            this.f53626e.o.c(2, this.f53626e.m.f23072a, this.f53626e.m.f23073b, 1, "");
            this.f53626e.hideNetRefreshView();
            LegoListFragment legoListFragment = this.f53626e;
            legoListFragment.Q(legoListFragment.getView(), false, this.f53626e.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c.a.q0.o1.o.l.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53627a;

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
            this.f53627a = legoListFragment;
        }

        @Override // c.a.q0.o1.o.l.l
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f53627a.f53619i == null) {
                return;
            }
            this.f53627a.f53619i.l(str);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements c.a.q0.o1.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53628a;

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
            this.f53628a = legoListFragment;
        }

        @Override // c.a.q0.o1.d
        public void a(int i2, long j2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2}) == null) {
                this.f53628a.o.c(2, j2, str, i2, str2);
            }
        }

        @Override // c.a.q0.o1.d
        public void b(long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, str) == null) {
                this.f53628a.o.a(j2, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53629e;

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
            this.f53629e = legoListFragment;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                this.f53629e.f53618h.u0(this.f53629e.getListViewLocationYInScreen());
                if (this.f53629e.isFullScreen()) {
                    return;
                }
                this.f53629e.f53618h.Q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53630e;

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
            this.f53630e = legoListFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f53630e.f53618h.e0()) {
                    if (this.f53630e.f53617g == null || view != this.f53630e.f53617g.getListView() || this.f53630e.f53620j == null) {
                        return false;
                    }
                    this.f53630e.f53620j.c(motionEvent);
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53631a;

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
            this.f53631a = legoListFragment;
        }

        @Override // c.a.q0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f53631a.K = false;
            }
        }

        @Override // c.a.q0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f53631a.K = true;
            }
        }

        @Override // c.a.q0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.q0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f53632e;

        /* renamed from: f  reason: collision with root package name */
        public int f53633f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f53634g;

        /* renamed from: h  reason: collision with root package name */
        public int f53635h;

        /* renamed from: i  reason: collision with root package name */
        public int f53636i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53637j;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f53638e;

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
                this.f53638e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    LegoListFragment legoListFragment = this.f53638e.f53637j;
                    legoListFragment.P(1, legoListFragment.K);
                    this.f53638e.f53634g = false;
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f53639e;

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
                this.f53639e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f53639e.f53637j.f53617g.getListView().smoothScrollToPositionFromTop(this.f53639e.f53635h, this.f53639e.f53636i, 400);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f53640e;

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
                this.f53640e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f53640e.f53637j.f53617g.getListView().smoothScrollToPositionFromTop(this.f53640e.f53635h, this.f53640e.f53636i, 400);
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
            this.f53637j = legoListFragment;
            this.f53632e = 0;
            this.f53633f = 0;
            this.f53634g = false;
            this.f53635h = -1;
            this.f53636i = 0;
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
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || !this.f53637j.f53618h.e0() || this.f53637j.f53617g == null || this.f53637j.f53617g.getListView() == null || this.f53637j.f53617g.getListView().getChildAt(0) == null) {
                return;
            }
            this.f53637j.f53618h.Q();
            boolean z3 = (i2 == this.f53632e && this.f53637j.K) ? false : true;
            int i5 = (i3 + i2) - 1;
            if (i5 == this.f53633f && !this.f53637j.K) {
                z3 = false;
            }
            if (this.f53633f < i5) {
                z = true;
            } else if (this.f53632e > i2) {
                z = true;
                z2 = true;
                if (z && !this.f53634g) {
                    BaseAdapter adapter = this.f53637j.getAdapter();
                    if (z2) {
                        if (adapter != null && adapter.getCount() > i5) {
                            int i6 = i5 - 1;
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            Object item = adapter.getItem(i6);
                            int page = item instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item).getPage() : 0;
                            Object item2 = adapter.getItem(i5);
                            int page2 = item2 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item2).getPage() : 0;
                            if (page != 0 && page2 != 0 && page < page2) {
                                this.f53634g = true;
                                this.f53635h = i5;
                                this.f53636i = 0;
                                c.a.q0.o1.o.k.c.f22976a = page2;
                                this.f53637j.f53617g.getListView().post(new b(this));
                            }
                        }
                    } else {
                        int i7 = i2 + 1;
                        if (adapter != null && adapter.getCount() > i7) {
                            Object item3 = adapter.getItem(i2);
                            int page3 = item3 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item3).getPage() : 0;
                            Object item4 = adapter.getItem(i7);
                            int page4 = item4 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item4).getPage() : 0;
                            if (page3 != 0 && page4 != 0 && page3 < page4) {
                                int i8 = i2 - 1;
                                double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                int i9 = i2;
                                while (i8 >= 0) {
                                    Object item5 = adapter.getItem(i8);
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
                                this.f53634g = true;
                                if (ratio > 2.67d) {
                                    this.f53635h = i7;
                                    this.f53636i = (int) ((c.a.e.e.p.l.q(this.f53637j.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.f53635h = i9;
                                    this.f53636i = 0;
                                }
                                c.a.q0.o1.o.k.c.f22976a = page3;
                                this.f53637j.f53617g.getListView().post(new c(this));
                            }
                        }
                    }
                }
                this.f53632e = i2;
                this.f53633f = i5;
                if (this.f53636i > 0) {
                    this.f53633f = i5 - 1;
                }
                this.f53637j.J = i2;
                this.f53637j.I = i5;
                if (z3) {
                    return;
                }
                LegoListFragment legoListFragment = this.f53637j;
                legoListFragment.P(2, legoListFragment.K);
                return;
            } else {
                z = false;
            }
            z2 = false;
            if (z) {
                BaseAdapter adapter2 = this.f53637j.getAdapter();
                if (z2) {
                }
            }
            this.f53632e = i2;
            this.f53633f = i5;
            if (this.f53636i > 0) {
            }
            this.f53637j.J = i2;
            this.f53637j.I = i5;
            if (z3) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            View findFocus;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                this.f53637j.L = i2;
                if (1 == i2 && this.f53637j.M != null && (findFocus = this.f53637j.M.findFocus()) != null) {
                    findFocus.clearFocus();
                }
                if (i2 == 0) {
                    LegoListFragment legoListFragment = this.f53637j;
                    legoListFragment.P(1, legoListFragment.K);
                    if (this.f53634g) {
                        this.f53637j.f53618h.K0(c.a.q0.o1.o.k.c.f22976a);
                        this.f53637j.f53617g.getListView().setSelectionFromTop(this.f53635h, this.f53636i);
                        this.f53637j.f53618h.Q();
                        this.f53637j.f53617g.getListView().post(new a(this));
                    }
                }
                if (this.f53637j.N != null) {
                    this.f53637j.N.onScrollStateChanged(absListView, i2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53641e;

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
            this.f53641e = legoListFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53641e.f53619i == null) {
                return;
            }
            this.f53641e.f53619i.m();
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53642e;

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
            this.f53642e = legoListFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53642e.endAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListFragment f53643e;

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
            this.f53643e = legoListFragment;
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
                if (this.f53643e.y.b()) {
                    this.f53643e.f53615e.setVisibility(8);
                    this.f53643e.S();
                    return;
                }
                this.f53643e.f53615e.setVisibility(0);
                this.f53643e.w.setVisibility(8);
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
                this.f53643e.f53615e.setVisibility(8);
                this.f53643e.w.setVisibility(0);
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

    public static void initHasShown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            Set<String> set = sHasShown;
            if (set == null) {
                sHasShown = new HashSet();
            } else {
                set.clear();
            }
        }
    }

    public final void J(List<c.a.q0.o1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || this.v == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.v.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).f23067d == 2) {
                c.a.q0.o1.p.d dVar = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2).f23066c)) {
                    this.v.setVisibility(0);
                    this.v.setOnClickListener(new c(this, dVar));
                }
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (c.a.e.e.p.j.z()) {
                Q(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            this.f53617g.setViewForeground();
        }
    }

    public final void L(View view) {
        c.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (gVar = this.q) == null) {
            return;
        }
        gVar.dettachView(view);
        this.q = null;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.o1.s.a c2 = c.a.q0.o1.r.b.d().c(getPageContext(), getUniqueId());
            this.o = c2;
            c2.b(new d(this));
        }
    }

    public final LegoListView O(c.a.q0.o1.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.C);
            legoListView.cardListAdapter.C(this.F);
            if (this.E) {
                legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
            }
            legoListView.registerListener(getUniqueId());
            legoListView.setCallback(dVar);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    public final void P(int i2, boolean z) {
        LegoListView legoListView;
        c.a.q0.o1.n.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f53619i == null || (legoListView = this.f53617g) == null || legoListView.getListView() == null || (aVar = this.f53617g.cardListAdapter) == null || aVar.getCount() == 0) {
            return;
        }
        this.f53619i.j(this.J, this.I, z, i2);
    }

    public final void Q(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.q == null) {
                if (i2 < 0) {
                    this.q = new c.a.p0.f0.g(getActivity());
                } else {
                    this.q = new c.a.p0.f0.g(getActivity(), i2);
                }
                this.q.onChangeSkinType();
            }
            this.q.attachView(view, z);
        }
    }

    public final void R(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rect) == null) {
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

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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

    public void endAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.x == null) {
                getActivity().finish();
                return;
            }
            this.w.startLoad(this.y.f22948a, 17, false);
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

    public BaseAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LegoListView legoListView = this.f53617g;
            if (legoListView == null) {
                return null;
            }
            return legoListView.cardListAdapter;
        }
        return (BaseAdapter) invokeV.objValue;
    }

    public int getCurrentScrollState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.L : invokeV.intValue;
    }

    public String getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public int getListViewLocationYInScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int[] iArr = new int[2];
            this.f53617g.getLocationOnScreen(iArr);
            return iArr[1];
        }
        return invokeV.intValue;
    }

    public c.a.q0.o1.o.l.m getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f53619i : (c.a.q0.o1.o.l.m) invokeV.objValue;
    }

    public final void hideNetRefreshView() {
        c.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (hVar = this.p) == null) {
            return;
        }
        hVar.dettachView(getView());
        this.p = null;
    }

    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? !this.f53618h.e0() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onActivityCreated(bundle);
            N();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (this.f53616f != null) {
                this.f53616f.onChangeSkinType(c.a.e.a.j.a(getActivity()), i2);
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
        c.a.q0.o1.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            this.A = c.a.e.e.p.l.k(getActivity());
            FrameLayout frameLayout = new FrameLayout(getActivity());
            LinearLayout linearLayout = new LinearLayout(getActivity());
            this.f53615e = linearLayout;
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f53615e.setOrientation(1);
            NoNetworkView noNetworkView = new NoNetworkView(getActivity());
            this.f53616f = noNetworkView;
            if (!this.E) {
                this.f53615e.addView(noNetworkView);
                if (c.a.e.e.p.l.D()) {
                    this.f53616f.setVisibility(8);
                } else {
                    this.f53616f.setVisibility(0);
                }
            }
            LegoListView O = O(this.P);
            this.f53617g = O;
            O.setDrawingCacheEnabled(false);
            c.a.q0.o1.p.e eVar = new c.a.q0.o1.p.e();
            this.m = eVar;
            eVar.f23072a = this.k;
            eVar.f23073b = this.l;
            c.a.q0.o1.p.c cVar = new c.a.q0.o1.p.c(eVar);
            this.n = cVar;
            this.f53617g.refreshView(cVar, true);
            this.f53615e.addView(this.f53617g);
            this.f53617g.getListView().setOnScrollListener(this.T);
            this.f53617g.getListView().addOnLayoutChangeListener(this.Q);
            this.f53617g.getListView().setOnTouchListener(this.R);
            c.a.q0.i0.a aVar2 = new c.a.q0.i0.a();
            this.f53620j = aVar2;
            aVar2.d(this.S);
            this.f53619i = this.f53617g.getPlaySwitchController();
            frameLayout.addView(this.f53615e, new FrameLayout.LayoutParams(-1, -1));
            if (this.E) {
                this.t.setVisibility(0);
                this.v = (ImageView) this.t.findViewById(R.id.btn_share);
                c.a.e.e.p.l.c(getActivity(), this.v, 20, 20, 20, 20);
                this.v.setVisibility(8);
                this.u = (ImageView) this.t.findViewById(R.id.btn_close);
                c.a.e.e.p.l.c(getActivity(), this.u, 20, 20, 20, 20);
                this.u.setOnClickListener(new m(this));
                getBaseFragmentActivity().setSwipeBackEnabled(false);
                if (this.D && (aVar = this.y) != null && aVar.c()) {
                    frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                    int r = c.a.e.e.p.l.r(getActivity());
                    this.B = r;
                    Rect rect = this.y.f22949b;
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
                    this.w.startLoad(this.y.f22948a, 17, false);
                    frameLayout.addView(this.w, layoutParams);
                    if (this.y.b()) {
                        Rect rect4 = this.y.f22951d;
                        Rect rect5 = this.z;
                        float f2 = this.A / (rect5.right - rect5.left);
                        this.H = c.a.e.e.p.l.g(getActivity(), R.dimen.ds10);
                        Rect rect6 = this.z;
                        float f3 = f2 * (rect6.bottom - rect6.top);
                        TbImageView tbImageView2 = new TbImageView(getActivity());
                        this.x = tbImageView2;
                        tbImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                        int i2 = this.A;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, (int) (i2 * (((rect4.bottom - rect4.top) * 1.0d) / (rect4.right - rect4.left))));
                        layoutParams2.setMargins(0, (int) (f3 + this.H), 0, 0);
                        this.x.setLayoutParams(layoutParams2);
                        this.x.startLoad(this.y.f22950c, 17, false);
                        frameLayout.addView(this.x, layoutParams2);
                        this.x.setVisibility(8);
                    }
                    R(this.z);
                    this.f53615e.setVisibility(8);
                }
                y.o().l().f(this.k, this.l, this.F);
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
            this.f53617g.onDestory();
            c.a.q0.o1.o.l.m mVar = this.f53619i;
            if (mVar != null) {
                mVar.c();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.U);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            this.f53617g.setViewBackGround();
            c.a.q0.o1.o.l.m mVar = this.f53619i;
            if (mVar != null) {
                mVar.n(false);
                this.f53619i.t();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.U);
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
                    J(this.n.f());
                    this.f53617g.refreshView(this.n, true);
                    return;
                }
            }
            if (isAdded() && isPrimary() && !this.r) {
                K();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            this.f53617g.setViewForeground();
            c.a.q0.o1.o.l.m mVar = this.f53619i;
            if (mVar != null) {
                mVar.n(true);
                c.a.e.e.m.e.a().postDelayed(this.U, 200L);
            }
        }
    }

    public void setAnimationInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            c.a.q0.o1.o.h.a a2 = c.a.q0.o1.o.h.a.a(str);
            this.y = a2;
            a2.d(str2);
        }
    }

    public void setFloatVideoContainer(c.a.q0.o1.o.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.f53618h = cVar;
            cVar.y0(this.O);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.F = str;
        }
    }

    public void setHasAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.D = z;
        }
    }

    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.C = z;
        }
    }

    public void setItemId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.l = str;
        }
    }

    public void setLandingNavi(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, relativeLayout) == null) {
            this.t = relativeLayout;
        }
    }

    public void setLandingPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.E = z;
        }
    }

    public void setNavigationBarViewHolder(c.a.q0.o1.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jVar) == null) {
            this.s = jVar;
        }
    }

    public void setOnScrollCallbackListener(c.a.q0.o1.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, kVar) == null) {
            this.N = kVar;
        }
    }

    public void setPageData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.G = str;
        }
    }

    public void setPageId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j2) == null) {
            this.k = j2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048613, this, view, str, z) == null) {
            if (this.p == null) {
                this.p = new c.a.p0.f0.h(getPageContext().getPageActivity(), new e(this));
            }
            this.p.j(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.p.l(str);
            this.p.attachView(view, z);
            this.p.o();
        }
    }
}
