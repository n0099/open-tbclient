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
import com.repackage.ae7;
import com.repackage.dc7;
import com.repackage.f9;
import com.repackage.fa8;
import com.repackage.fe7;
import com.repackage.g45;
import com.repackage.ge7;
import com.repackage.h45;
import com.repackage.he7;
import com.repackage.id7;
import com.repackage.j36;
import com.repackage.jc7;
import com.repackage.kc7;
import com.repackage.mi;
import com.repackage.nd7;
import com.repackage.oi;
import com.repackage.pg;
import com.repackage.rc7;
import com.repackage.td7;
import com.repackage.ud7;
import com.repackage.yd7;
import com.repackage.zc7;
import com.repackage.zd7;
import com.squareup.wire.Message;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
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
    public kc7 J;
    public td7 K;
    public dc7 L;
    public View.OnLayoutChangeListener M;
    public View.OnTouchListener N;
    public j36.b O;
    public AbsListView.OnScrollListener P;
    public Runnable Q;
    public LinearLayout a;
    public NoNetworkView b;
    public LegoListView c;
    public nd7 d;
    public ud7 e;
    public j36 f;
    public long g;
    public String h;
    public ae7 i;
    public yd7 j;
    public ge7 k;
    public h45 l;
    public g45 m;
    public boolean n;
    public jc7 o;
    public RelativeLayout p;
    public ImageView q;
    public ImageView r;
    public TbImageView s;
    public TbImageView t;
    public zc7 u;
    public Rect v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

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
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
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
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
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

    /* loaded from: classes3.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

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
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
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

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zd7 a;
        public final /* synthetic */ LegoListFragment b;

        public c(LegoListFragment legoListFragment, zd7 zd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListFragment, zd7Var};
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
            this.a = zd7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.mIsLogin) {
                    if (this.b.o != null) {
                        this.b.o.h(this.a);
                        return;
                    }
                    return;
                }
                ViewHelper.skipToLoginActivity(this.b.getActivity());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements he7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

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

        @Override // com.repackage.he7
        public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
                if (z) {
                    LegoListFragment legoListFragment = this.a;
                    legoListFragment.l1(legoListFragment.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    this.a.n = true;
                    this.a.j.c(z, dataRes, z2, i);
                    if (TextUtils.isEmpty(this.a.j.j()) || TextUtils.isEmpty(this.a.j.k())) {
                        if (this.a.o != null) {
                            this.a.o.i(this.a.j.i());
                        }
                    } else if (this.a.o != null) {
                        this.a.o.j(this.a.j.j(), this.a.j.k());
                    }
                    if (this.a.o != null) {
                        this.a.o.g(this.a.j.e());
                    }
                    this.a.c.u(this.a.j, false);
                    if (this.a.y && this.a.A) {
                        LegoListFragment legoListFragment2 = this.a;
                        legoListFragment2.e1(legoListFragment2.j.e());
                    }
                } else if (this.a.getPageContext() == null || this.a.getPageContext().getResources() == null) {
                } else {
                    LegoListFragment legoListFragment3 = this.a;
                    legoListFragment3.showNetRefreshView(legoListFragment3.getView(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c18), false);
                }
            }
        }

        @Override // com.repackage.he7
        public void b(long j, String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) {
                LegoListFragment legoListFragment = this.a;
                legoListFragment.l1(legoListFragment.getView());
                if (this.a.j.a()) {
                    this.a.c.u(this.a.j, false);
                } else if (this.a.getPageContext() == null || this.a.getPageContext().getResources() == null) {
                } else {
                    LegoListFragment legoListFragment2 = this.a;
                    legoListFragment2.showNetRefreshView(legoListFragment2.getView(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17, str2, Integer.valueOf(i)), false);
                }
            }
        }

        @Override // com.repackage.he7
        public void c(long j, String str, Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.k == null) {
                return;
            }
            this.a.k.c(2, this.a.i.a, this.a.i.b, 1, "");
            this.a.m1();
            LegoListFragment legoListFragment = this.a;
            legoListFragment.C1(legoListFragment.getView(), false, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ad));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements td7 {
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

        @Override // com.repackage.td7
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.e == null) {
                return;
            }
            this.a.e.l(str);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements dc7 {
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

        @Override // com.repackage.dc7
        public void a(int i, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) {
                this.a.k.c(2, j, str, i, str2);
            }
        }

        @Override // com.repackage.dc7
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                this.a.k.a(j, str);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.d.u0(this.a.j1());
                if (this.a.isFullScreen()) {
                    return;
                }
                this.a.d.Q();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.d.e0()) {
                    if (this.a.c == null || view2 != this.a.c.getListView() || this.a.f == null) {
                        return false;
                    }
                    this.a.f.c(motionEvent);
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements j36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

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

        @Override // com.repackage.j36.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.G = false;
            }
        }

        @Override // com.repackage.j36.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.G = true;
            }
        }

        @Override // com.repackage.j36.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.j36.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public boolean c;
        public int d;
        public int e;
        public final /* synthetic */ LegoListFragment f;

        /* loaded from: classes3.dex */
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
                    legoListFragment.q1(1, legoListFragment.G);
                    this.a.c = false;
                }
            }
        }

        /* loaded from: classes3.dex */
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

        /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || !this.f.d.e0() || this.f.c == null || this.f.c.getListView() == null || this.f.c.getListView().getChildAt(0) == null) {
                return;
            }
            this.f.d.Q();
            boolean z3 = (i == this.a && this.f.G) ? false : true;
            int i4 = (i2 + i) - 1;
            if (i4 == this.b && !this.f.G) {
                z3 = false;
            }
            if (this.b < i4) {
                z = true;
            } else if (this.a > i) {
                z = true;
                z2 = true;
                if (z && !this.c) {
                    BaseAdapter h1 = this.f.h1();
                    if (z2) {
                        if (h1 != null && h1.getCount() > i4) {
                            int i5 = i4 - 1;
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            Object item = h1.getItem(i5);
                            int page = item instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item).getPage() : 0;
                            Object item2 = h1.getItem(i4);
                            int page2 = item2 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item2).getPage() : 0;
                            if (page != 0 && page2 != 0 && page < page2) {
                                this.c = true;
                                this.d = i4;
                                this.e = 0;
                                id7.a = page2;
                                this.f.c.getListView().post(new b(this));
                            }
                        }
                    } else {
                        int i6 = i + 1;
                        if (h1 != null && h1.getCount() > i6) {
                            Object item3 = h1.getItem(i);
                            int page3 = item3 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item3).getPage() : 0;
                            Object item4 = h1.getItem(i6);
                            int page4 = item4 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item4).getPage() : 0;
                            if (page3 != 0 && page4 != 0 && page3 < page4) {
                                int i7 = i - 1;
                                double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                int i8 = i;
                                while (i7 >= 0) {
                                    Object item5 = h1.getItem(i7);
                                    if (item5 instanceof BaseLegoCardInfo) {
                                        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) item5;
                                        if (baseLegoCardInfo.getPage() != page3) {
                                            break;
                                        }
                                        ratio += baseLegoCardInfo.getRatio();
                                        int i9 = i7;
                                        i7--;
                                        i8 = i9;
                                    }
                                }
                                this.c = true;
                                if (ratio > 2.67d) {
                                    this.d = i6;
                                    this.e = (int) ((oi.q(this.f.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.d = i8;
                                    this.e = 0;
                                }
                                id7.a = page3;
                                this.f.c.getListView().post(new c(this));
                            }
                        }
                    }
                }
                this.a = i;
                this.b = i4;
                if (this.e > 0) {
                    this.b = i4 - 1;
                }
                this.f.F = i;
                this.f.E = i4;
                if (z3) {
                    return;
                }
                LegoListFragment legoListFragment = this.f;
                legoListFragment.q1(2, legoListFragment.G);
                return;
            } else {
                z = false;
            }
            z2 = false;
            if (z) {
                BaseAdapter h12 = this.f.h1();
                if (z2) {
                }
            }
            this.a = i;
            this.b = i4;
            if (this.e > 0) {
            }
            this.f.F = i;
            this.f.E = i4;
            if (z3) {
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
                    legoListFragment.q1(1, legoListFragment.G);
                    if (this.c) {
                        this.f.d.K0(id7.a);
                        this.f.c.getListView().setSelectionFromTop(this.d, this.e);
                        this.f.d.Q();
                        this.f.c.getListView().post(new a(this));
                    }
                }
                if (this.f.J != null) {
                    this.f.J.onScrollStateChanged(absListView, i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.e == null) {
                return;
            }
            this.a.e.m();
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.f1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListFragment a;

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
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.a.u.b()) {
                    this.a.a.setVisibility(8);
                    this.a.E1();
                    return;
                }
                this.a.a.setVisibility(0);
                this.a.s.setVisibility(8);
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
                this.a.a.setVisibility(8);
                this.a.s.setVisibility(0);
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

    public static void n1() {
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

    public void A1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.C = str;
        }
    }

    public void B1(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.g = j2;
        }
    }

    public final void C1(View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.m == null) {
                if (i2 < 0) {
                    this.m = new g45(getActivity());
                } else {
                    this.m = new g45(getActivity(), i2);
                }
                this.m.onChangeSkinType();
            }
            this.m.attachView(view2, z);
        }
    }

    public final void D1(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rect) == null) {
            int i2 = rect.right;
            int i3 = rect.left;
            float f2 = this.w / (i2 - i3);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, AnimationProperty.SCALE_X, 1.0f, f2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s, AnimationProperty.SCALE_Y, 1.0f, f2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.s, AnimationProperty.TRANSLATE_X, -i3);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.s, AnimationProperty.TRANSLATE_Y, -rect.top);
            this.s.setPivotX(0.0f);
            this.s.setPivotY(0.0f);
            animatorSet.setDuration(500L);
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            animatorSet.addListener(new n(this));
            animatorSet.start();
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.t, AnimationProperty.TRANSLATE_Y, -this.D);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.t, AnimationProperty.OPACITY, 0.0f, 1.0f);
            animatorSet.setDuration(500L);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
            animatorSet.addListener(new a(this));
        }
    }

    public final void e1(List<zd7> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || this.r == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.r.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).d == 2) {
                zd7 zd7Var = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2).c)) {
                    this.r.setVisibility(0);
                    this.r.setOnClickListener(new c(this, zd7Var));
                }
            }
        }
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.t == null) {
                getActivity().finish();
                return;
            }
            this.s.K(this.u.a, 17, false);
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

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (mi.z()) {
                C1(getView(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ad));
            }
            this.c.setViewForeground();
        }
    }

    public BaseAdapter h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LegoListView legoListView = this.c;
            if (legoListView == null) {
                return null;
            }
            return legoListView.d;
        }
        return (BaseAdapter) invokeV.objValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.H : invokeV.intValue;
    }

    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !this.d.e0() : invokeV.booleanValue;
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int[] iArr = new int[2];
            this.c.getLocationOnScreen(iArr);
            return iArr[1];
        }
        return invokeV.intValue;
    }

    public ud7 k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e : (ud7) invokeV.objValue;
    }

    public final void l1(View view2) {
        g45 g45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view2) == null) || (g45Var = this.m) == null) {
            return;
        }
        g45Var.dettachView(view2);
        this.m = null;
    }

    public final void m1() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (h45Var = this.l) == null) {
            return;
        }
        h45Var.dettachView(getView());
        this.l = null;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ge7 c2 = fe7.d().c(getPageContext(), getUniqueId());
            this.k = c2;
            c2.b(new d(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onActivityCreated(bundle);
            o1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (this.b != null) {
                this.b.c(f9.a(getActivity()), i2);
            }
            if (this.p != null) {
                getBaseFragmentActivity().getLayoutMode().j(this.p);
            }
            super.onChangeSkinType(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, configuration) == null) || configuration == null || (relativeLayout = this.p) == null) {
            return;
        }
        if (configuration.orientation == 2) {
            relativeLayout.setVisibility(8);
        } else if (this.A) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        zc7 zc7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            this.w = oi.k(getActivity());
            FrameLayout frameLayout = new FrameLayout(getActivity());
            LinearLayout linearLayout = new LinearLayout(getActivity());
            this.a = linearLayout;
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.a.setOrientation(1);
            NoNetworkView noNetworkView = new NoNetworkView(getActivity());
            this.b = noNetworkView;
            if (!this.A) {
                this.a.addView(noNetworkView);
                if (oi.C()) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                }
            }
            LegoListView p1 = p1(this.L);
            this.c = p1;
            p1.setDrawingCacheEnabled(false);
            ae7 ae7Var = new ae7();
            this.i = ae7Var;
            ae7Var.a = this.g;
            ae7Var.b = this.h;
            yd7 yd7Var = new yd7(ae7Var);
            this.j = yd7Var;
            this.c.u(yd7Var, true);
            this.a.addView(this.c);
            this.c.getListView().setOnScrollListener(this.P);
            this.c.getListView().addOnLayoutChangeListener(this.M);
            this.c.getListView().setOnTouchListener(this.N);
            j36 j36Var = new j36();
            this.f = j36Var;
            j36Var.d(this.O);
            this.e = this.c.getPlaySwitchController();
            frameLayout.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            if (this.A) {
                this.p.setVisibility(0);
                this.r = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f09043f);
                oi.b(getActivity(), this.r, 20, 20, 20, 20);
                this.r.setVisibility(8);
                this.q = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f090416);
                oi.b(getActivity(), this.q, 20, 20, 20, 20);
                this.q.setOnClickListener(new m(this));
                getBaseFragmentActivity().setSwipeBackEnabled(false);
                if (this.z && (zc7Var = this.u) != null && zc7Var.c()) {
                    frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                    int r = oi.r(getActivity());
                    this.x = r;
                    Rect rect = this.u.b;
                    this.v = rect;
                    rect.top -= r;
                    rect.bottom -= r;
                    TbImageView tbImageView = new TbImageView(getActivity());
                    this.s = tbImageView;
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Rect rect2 = this.v;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect2.right - rect2.left, rect2.bottom - rect2.top);
                    Rect rect3 = this.v;
                    layoutParams.setMargins(rect3.left, rect3.top, 0, 0);
                    this.s.setLayoutParams(layoutParams);
                    this.s.K(this.u.a, 17, false);
                    frameLayout.addView(this.s, layoutParams);
                    if (this.u.b()) {
                        Rect rect4 = this.u.d;
                        Rect rect5 = this.v;
                        float f2 = this.w / (rect5.right - rect5.left);
                        this.D = oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070234);
                        Rect rect6 = this.v;
                        float f3 = f2 * (rect6.bottom - rect6.top);
                        TbImageView tbImageView2 = new TbImageView(getActivity());
                        this.t = tbImageView2;
                        tbImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                        int i2 = this.w;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, (int) (i2 * (((rect4.bottom - rect4.top) * 1.0d) / (rect4.right - rect4.left))));
                        layoutParams2.setMargins(0, (int) (f3 + this.D), 0, 0);
                        this.t.setLayoutParams(layoutParams2);
                        this.t.K(this.u.c, 17, false);
                        frameLayout.addView(this.t, layoutParams2);
                        this.t.setVisibility(8);
                    }
                    D1(this.v);
                    this.a.setVisibility(8);
                }
                fa8.q().l().f(this.g, this.h, this.B);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            this.c.t();
            ud7 ud7Var = this.e;
            if (ud7Var != null) {
                ud7Var.c();
            }
            pg.a().removeCallbacks(this.Q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            this.c.setViewBackGround();
            ud7 ud7Var = this.e;
            if (ud7Var != null) {
                ud7Var.n(false);
                this.e.t();
            }
            pg.a().removeCallbacks(this.Q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
            if (!TextUtils.isEmpty(this.C)) {
                this.j.q(this.C);
                if (this.j.n()) {
                    e1(this.j.e());
                    this.c.u(this.j, true);
                    return;
                }
            }
            if (isAdded() && isPrimary() && !this.n) {
                g1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            this.c.setViewForeground();
            ud7 ud7Var = this.e;
            if (ud7Var != null) {
                ud7Var.n(true);
                pg.a().postDelayed(this.Q, 200L);
            }
        }
    }

    public final LegoListView p1(dc7 dc7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, dc7Var)) == null) {
            LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.y);
            legoListView.d.E(this.B);
            if (this.A) {
                legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
            }
            legoListView.v(getUniqueId());
            legoListView.setCallback(dc7Var);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    public final void q1(int i2, boolean z) {
        LegoListView legoListView;
        rc7 rc7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.e == null || (legoListView = this.c) == null || legoListView.getListView() == null || (rc7Var = this.c.d) == null || rc7Var.getCount() == 0) {
            return;
        }
        this.e.j(this.F, this.E, z, i2);
    }

    public void r1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            zc7 a2 = zc7.a(str);
            this.u = a2;
            a2.d(str2);
        }
    }

    public void s1(nd7 nd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, nd7Var) == null) {
            this.d = nd7Var;
            nd7Var.y0(this.K);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.B = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048605, this, view2, str, z) == null) {
            if (this.l == null) {
                this.l = new h45(getPageContext().getPageActivity(), new e(this));
            }
            this.l.k(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070256));
            this.l.m(str);
            this.l.attachView(view2, z);
            this.l.p();
        }
    }

    public void t1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.z = z;
        }
    }

    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.y = z;
        }
    }

    public void v1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.h = str;
        }
    }

    public void w1(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, relativeLayout) == null) {
            this.p = relativeLayout;
        }
    }

    public void x1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.A = z;
        }
    }

    public void y1(jc7 jc7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, jc7Var) == null) {
            this.o = jc7Var;
        }
    }

    public void z1(kc7 kc7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, kc7Var) == null) {
            this.J = kc7Var;
        }
    }
}
