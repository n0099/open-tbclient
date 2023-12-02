package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.widget.SecondFloorExt;
import com.baidu.tieba.forum.widget.TbLinkageScrollView;
import com.baidu.tieba.km7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nm7<T extends km7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity a;
    public final ActivityForumBinding b;
    public final in7 c;
    public SecondFloorExt d;
    public lm7<T> e;
    public final b f;

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                float dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds48);
                if (outline != null) {
                    if (view2 != null) {
                        i = view2.getWidth();
                    } else {
                        i = 0;
                    }
                    if (view2 != null) {
                        i2 = view2.getHeight();
                    } else {
                        i2 = 0;
                    }
                    outline.setRoundRect(0, 0, i, i2, dimenPixelSize);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends kp7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ nm7<T> b;

        public b(nm7<T> nm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nm7Var;
        }

        @Override // com.baidu.tieba.jp7
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i != 0) {
                    if (i != 4) {
                        return;
                    }
                    this.b.o(this.a);
                    return;
                }
                this.b.n();
            }
        }

        @Override // com.baidu.tieba.jp7
        public void c(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) != null) {
                return;
            }
            this.b.p(f);
        }

        @Override // com.baidu.tieba.jp7
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a = z;
                this.b.r();
            }
        }

        @Override // com.baidu.tieba.jp7
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) != null) {
                return;
            }
            this.b.p(f);
        }
    }

    public nm7(FragmentActivity activity, ActivityForumBinding binding, in7 in7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, binding, in7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.a = activity;
        this.b = binding;
        this.c = in7Var;
        this.f = new b(this);
    }

    public final void o(boolean z) {
        lm7<T> lm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (lm7Var = this.e) != null) {
            lm7Var.c(z);
        }
    }

    public final void p(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            float height = f / this.b.r.getHeight();
            lm7<T> lm7Var = this.e;
            if (lm7Var != null) {
                lm7Var.a(height, f);
            }
            this.b.q.setAlpha(im7.a(height));
        }
    }

    public final void t(T data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            lm7<T> lm7Var = this.e;
            if (lm7Var != null) {
                lm7Var.e(data);
            }
        }
    }

    public final void e() {
        SecondFloorExt secondFloorExt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (secondFloorExt = this.d) != null) {
            secondFloorExt.h();
        }
    }

    public final void f() {
        SecondFloorExt secondFloorExt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (secondFloorExt = this.d) != null) {
            secondFloorExt.i();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SecondFloorExt secondFloorExt = this.d;
            if (secondFloorExt != null) {
                return secondFloorExt.q(UtilHelper.getDimenPixelSize(R.dimen.tbds390));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        SecondFloorExt secondFloorExt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (secondFloorExt = this.d) != null) {
            secondFloorExt.m();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SecondFloorExt secondFloorExt = this.d;
            if (secondFloorExt != null) {
                if (secondFloorExt != null && secondFloorExt.j() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    SecondFloorExt secondFloorExt2 = this.d;
                    if (secondFloorExt2 != null) {
                        secondFloorExt2.h();
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        lm7<T> lm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (lm7Var = this.e) != null) {
            lm7Var.f();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SecondFloorExt secondFloorExt = this.d;
            if (secondFloorExt != null) {
                secondFloorExt.n();
            }
            lm7<T> lm7Var = this.e;
            if (lm7Var != null) {
                om7.c(lm7Var);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.p.setAlpha(1.0f);
            this.b.d.setClipToOutline(false);
            this.b.j.setVisibility(0);
            lm7<T> lm7Var = this.e;
            if (lm7Var != null) {
                lm7Var.g();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.d.setClipToOutline(false);
            SecondFloorExt secondFloorExt = this.d;
            if (secondFloorExt != null) {
                secondFloorExt.n();
            }
            this.d = null;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.p.setAlpha(0.0f);
            this.b.d.setClipToOutline(true);
            this.b.j.setVisibility(8);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.d.setOutlineProvider(new a());
            this.b.p.setClickable(false);
            this.b.p.setFocusableInTouchMode(false);
        }
    }

    public final void i(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) && i == 1111) {
            lm7<T> lm7Var = this.e;
            if (lm7Var != null) {
                lm7Var.b(this.a);
            }
            SecondFloorExt secondFloorExt = this.d;
            if (secondFloorExt != null) {
                secondFloorExt.h();
            }
        }
    }

    public final void u(T t) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, t) == null) {
            if (t == null) {
                q();
                return;
            }
            s();
            FrameLayout frameLayout = this.b.r;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.rootLoadingContainer");
            this.e = om7.e(frameLayout, t, om7.a(this.a, this.b, this, t));
            FrameLayout frameLayout2 = this.b.q;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.rootContainer");
            in7 in7Var = this.c;
            if (in7Var != null) {
                view2 = in7Var.H();
            } else {
                view2 = null;
            }
            SecondFloorExt secondFloorExt = new SecondFloorExt(frameLayout2, view2);
            secondFloorExt.f(this.f);
            secondFloorExt.p(0.3f);
            TbLinkageScrollView tbLinkageScrollView = this.b.m;
            Intrinsics.checkNotNullExpressionValue(tbLinkageScrollView, "binding.linkageView");
            secondFloorExt.l(tbLinkageScrollView);
            this.d = secondFloorExt;
        }
    }
}
