package com.baidu.tieba;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class y9b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    @IdRes
    public int b;
    @IdRes
    public int c;
    public Object d;
    public int e;
    public int f;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final y9b a;

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
                    return;
                }
            }
            this.a = new y9b();
        }

        public final y9b a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.a != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return this.a;
                }
                throw new IllegalStateException("必须设置引导视图 GuideView".toString());
            }
            return (y9b) invokeV.objValue;
        }

        public final a b(Object viewTag) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewTag)) == null) {
                Intrinsics.checkNotNullParameter(viewTag, "viewTag");
                this.a.c(viewTag);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(@IdRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.a.d(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a d(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                this.a.e(view2);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.a.f(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.a.g(i);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public y9b() {
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
        this.b = -1;
        this.c = -1;
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.a;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("guideView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        r5 = com.baidu.tieba.x9b.c(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PointF a(ViewGroup rootView) {
        InterceptResult invokeL;
        View findViewById;
        RectF rectF;
        float f;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rootView)) == null) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Object obj = this.d;
            if (obj != null) {
                findViewById = rootView.findViewWithTag(obj);
            } else {
                findViewById = rootView.findViewById(this.c);
            }
            if (findViewById == null || rectF == null) {
                rectF = new RectF();
            }
            View findViewById2 = b().findViewById(this.b);
            float f2 = rectF.left + this.e;
            if (findViewById2 != null) {
                f = rectF.bottom - (findViewById2.getTop() + findViewById2.getHeight());
                i = this.f;
            } else {
                f = rectF.bottom;
                i = this.f;
            }
            return new PointF(f2, f + i);
        }
        return (PointF) invokeL.objValue;
    }

    public final void c(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.d = obj;
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b = i;
        }
    }

    public final void e(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.a = view2;
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e = i;
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
        }
    }
}
