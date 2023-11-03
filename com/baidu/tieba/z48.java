package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.banner.data.FrsHeadBannerData;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tbclient.SignActivityInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public abstract class z48 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, String> p0;
    public static HashSet<Integer> q0;
    public transient /* synthetic */ FieldHolder $fh;
    public CoverFlowView<FrsHeadBannerData> A;
    public FrsTopView B;
    public View C;
    public View D;
    public View E;
    public FrsVoiceRoomListLayout F;
    public EMTextView G;
    public boolean H;
    public SignActivityInfo I;
    public PopupWindow J;
    public View K;
    public ImageView L;
    public PopupWindow M;
    public BarImageView N;
    public UserIconBox O;
    public ArrayList<nw4> P;
    public l48 Q;
    public k48 R;
    public FrsLikeRecommendLayout S;

    /* renamed from: T  reason: collision with root package name */
    public String f1186T;
    public String U;
    public String V;
    public FrsViewData W;
    public ThreadData X;
    public int Y;
    public int Z;
    public TbPageContext a;
    public int a0;
    public FrsFragment b;
    public int b0;
    public Handler c;
    public int c0;
    public View d;
    public boolean d0;
    public TextView e;
    public boolean e0;
    public TextView f;
    public yw4 f0;
    public TextView g;
    public boolean g0;
    public List<TBSpecificationBtn> h;
    public boolean h0;
    public List<TBSpecificationBtn> i;
    public boolean i0;
    public TextView j;
    public boolean j0;
    public ImageView k;
    public boolean k0;
    public ImageView l;
    public float l0;
    public View m;
    public ViewGroup m0;
    public TextView n;
    public vx7 n0;
    public TextView o;
    public boolean o0;
    public RelativeLayout p;
    public RelativeLayout q;
    public View r;
    public TextView s;
    public RelativeLayout t;
    public View u;
    public RelativeLayout v;
    public LinearGradientView w;
    public TbImageView x;
    public ServiceAreaView y;
    public FrameLayout z;

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public abstract void C();

    public abstract void F(boolean z, float f);

    public abstract void G();

    public abstract void H();

    public abstract void I();

    public abstract void J();

    public abstract void K(View.OnClickListener onClickListener);

    public abstract void L(ForumData forumData, FrsViewData frsViewData);

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    public void U(yi yiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, yiVar) == null) {
        }
    }

    public abstract void W();

    public abstract void Y();

    public abstract void a();

    public abstract void a0();

    public abstract void c();

    public abstract void d(int i);

    public abstract void e();

    public abstract String f();

    public abstract SignActivityInfo m();

    public abstract void q();

    public abstract boolean t();

    public abstract boolean v();

    public abstract void z(boolean z);

    /* loaded from: classes9.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

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

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        /* loaded from: classes9.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    b bVar = this.a;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.a, Key.SCALE_X, 0.0f, bVar.b);
                    ofFloat.setDuration(300L);
                    ofFloat.start();
                }
            }
        }

        public b(z48 z48Var, View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z48Var, view2, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                a aVar = new a(this);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, Key.SCALE_X, 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(aVar);
                ofFloat.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements a08 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z48 a;

        public a(z48 z48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z48Var;
        }

        @Override // com.baidu.tieba.a08
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948310091, "Lcom/baidu/tieba/z48;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948310091, "Lcom/baidu/tieba/z48;");
                return;
            }
        }
        p0 = new HashMap<>();
        q0 = new HashSet<>();
        p0.put(1, "c0117");
        p0.put(2, "c0124");
        p0.put(3, "c0125");
        p0.put(4, "c0126");
        p0.put(5, "c0127");
    }

    public z48() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o0 = false;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            r();
            q();
        }
    }

    public BarImageView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.N;
        }
        return (BarImageView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        yw4 yw4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.d0 || (yw4Var = this.f0) == null) {
                return "";
            }
            return yw4Var.c();
        }
        return (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.n;
        }
        return (TextView) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.d0 = true;
            O(this.i0 ? 1 : 0);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.g0;
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            PopupWindow popupWindow2 = this.J;
            if (popupWindow2 != null && popupWindow2.isShowing()) {
                this.J.dismiss();
            }
        }
    }

    public void s() {
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (frsLikeRecommendLayout = this.S) != null && frsLikeRecommendLayout.getVisibility() == 0) {
            this.S.p();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.j0;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            int[] iArr = new int[2];
            try {
                this.L.getLocationOnScreen(iArr);
                if (iArr[0] < 160 || iArr[1] < 105) {
                    return false;
                }
                return true;
            } catch (NullPointerException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.h0 = true;
            q0.clear();
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && !z) {
            r();
            q();
        }
    }

    public void E(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            F(false, f);
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (i == 0) {
                this.i0 = false;
                J();
                return;
            }
            this.i0 = true;
            I();
        }
    }

    public void P(SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, signData) == null) && signData != null) {
            if (signData.forum_rank == -2) {
                O(signData.is_signed);
                b(false);
                return;
            }
            b(true);
            O(signData.is_signed);
        }
    }

    public void R(k48 k48Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, k48Var) == null) && k48Var != null && (list = this.h) != null) {
            this.R = k48Var;
            k48Var.j(list);
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.c0 = i;
        }
    }

    public void T(l48 l48Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, l48Var) == null) && l48Var != null && (list = this.i) != null) {
            this.Q = l48Var;
            l48Var.j(list);
        }
    }

    public void b(boolean z) {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && (l48Var = this.Q) != null) {
            l48Var.k(z);
        }
    }

    public /* synthetic */ void x(View view2) {
        this.S.p();
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i == 0) {
                this.g0 = false;
                this.o0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
            }
            z(this.g0);
        }
    }

    public void N(int i, String str, int i2, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            this.V = str;
            this.Y = i2;
            if (i == 0) {
                this.g0 = false;
                this.o0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                if (z && !this.o0) {
                    Y();
                    this.o0 = true;
                }
            }
            z(this.g0);
        }
    }

    public void V(List<jqa> list) {
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, list) == null) && this.a != null && !TextUtils.isEmpty(this.U) && !TextUtils.isEmpty(this.f1186T) && !ListUtils.isEmpty(list) && (frsLikeRecommendLayout = this.S) != null) {
            frsLikeRecommendLayout.setHeightChangeListener(new a(this));
            this.S.o(this.a, this.U, this.f1186T, list);
            this.S.setCloseListener(new View.OnClickListener() { // from class: com.baidu.tieba.u48
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        z48.this.x(view2);
                    }
                }
            });
        }
    }

    public void X(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            view2.setPivotX(0.0f);
            b bVar = new b(this, view2, f2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, f, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(bVar);
            ofFloat.start();
        }
    }

    public void Z(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (new BigDecimal(f + "").compareTo(new BigDecimal(f2 + "")) == 0) {
                return;
            }
            view2.setPivotX(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, f, f2);
            ofFloat.setDuration(1000L);
            ofFloat.start();
        }
    }
}
