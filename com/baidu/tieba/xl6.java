package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.view.foldclose.FoldCloseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class xl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCloseView a;
    public EdgeFloat b;
    public final ArrayList<String> c;
    public View.OnClickListener d;
    public View.OnClickListener e;
    public sj9 f;

    /* loaded from: classes6.dex */
    public static final class a implements tl6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl6 a;

        public a(xl6 xl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xl6Var;
        }

        @Override // com.baidu.tieba.tl6
        public void onChangeSkinType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.a.onChangeSkinType(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements ul6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl6 a;

        public b(xl6 xl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xl6Var;
        }

        @Override // com.baidu.tieba.ul6
        public void dispatchTouchEvent(MotionEvent ev) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ev) == null) {
                Intrinsics.checkNotNullParameter(ev, "ev");
                if (!this.a.a.e() && ev.getAction() == 0) {
                    this.a.a.c();
                }
            }
        }

        @Override // com.baidu.tieba.ul6
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a.f();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements rj9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl6 a;

        public c(xl6 xl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xl6Var;
        }

        @Override // com.baidu.tieba.rj9
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.b.x()) {
                    this.a.b.A(0);
                } else {
                    this.a.b.A(i - i2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements sj9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl6 a;

        public d(xl6 xl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xl6Var;
        }

        @Override // com.baidu.tieba.sj9
        public void a(boolean z) {
            sj9 e;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (e = this.a.e()) != null) {
                e.a(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public View b;
        public final ArrayList<String> c;

        public e(Activity activity, View childView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, childView};
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
            Intrinsics.checkNotNullParameter(childView, "childView");
            this.a = activity;
            this.b = childView;
            this.c = new ArrayList<>();
        }

        public final xl6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                xl6 xl6Var = new xl6(this.a);
                xl6Var.i(this.b);
                xl6Var.m(this.c);
                return xl6Var;
            }
            return (xl6) invokeV.objValue;
        }

        public final e b(List<String> pageNoSupport) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pageNoSupport)) == null) {
                Intrinsics.checkNotNullParameter(pageNoSupport, "pageNoSupport");
                this.c.clear();
                this.c.addAll(pageNoSupport);
                return this;
            }
            return (e) invokeL.objValue;
        }
    }

    public xl6(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
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
        this.c = new ArrayList<>();
        int l = ej.l(activity);
        int j = ej.j(activity);
        int u = ej.u(activity);
        int b2 = (l - yl6.a.b()) - (yl6.a.c() * 2);
        Context context = TbadkCoreApplication.getInst().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getInst().context");
        this.a = new FoldCloseView(context);
        EdgeFloat.a aVar = new EdgeFloat.a(activity);
        aVar.m(this.a);
        aVar.i(b2);
        aVar.j(j - yl6.a.a());
        aVar.c(yl6.a.b() + (yl6.a.c() * 2));
        aVar.n(yl6.a.b() + (yl6.a.c() * 2));
        aVar.g(j);
        aVar.h(l);
        aVar.k(u);
        aVar.l(ej.g(activity, R.dimen.tbds352));
        aVar.a(ej.g(activity, R.dimen.tbds150));
        aVar.f(this.c);
        aVar.e(new a(this));
        aVar.d(new b(this));
        this.b = aVar.b();
        qj9 qj9Var = new qj9();
        qj9Var.e(yl6.a.b());
        qj9Var.g(yl6.a.d());
        qj9Var.f(yl6.a.c());
        this.a.setData(qj9Var);
        this.a.setOnCloseClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vl6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    xl6.a(xl6.this, view2);
                }
            }
        });
        this.a.setOnFoldCloseWidthChangeListener(new c(this));
        this.a.setOnOtherClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wl6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    xl6.b(xl6.this, view2);
                }
            }
        });
        this.a.setOnFoldStateChangeListener(new d(this));
    }

    public static final void a(xl6 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.a.e()) {
                this$0.b.v();
            }
            View.OnClickListener onClickListener = this$0.d;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public static final void b(xl6 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View.OnClickListener onClickListener = this$0.e;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public final void i(View childView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, childView) == null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            this.a.setChild(childView, yl6.a.b(), yl6.a.b());
        }
    }

    public final void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public final void k(sj9 sj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sj9Var) == null) {
            this.f = sj9Var;
        }
    }

    public final void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public final void m(List<String> pageNoSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pageNoSupport) == null) {
            Intrinsics.checkNotNullParameter(pageNoSupport, "pageNoSupport");
            this.c.clear();
            this.c.addAll(pageNoSupport);
            this.b.I(this.c);
        }
    }

    public final sj9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (sj9) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.v();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.e();
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b.z();
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.J();
        }
    }
}
