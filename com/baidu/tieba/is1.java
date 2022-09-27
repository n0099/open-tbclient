package com.baidu.tieba;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.or1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class is1 extends es1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements or1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ is1 a;

        /* renamed from: com.baidu.tieba.is1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0292a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            /* renamed from: com.baidu.tieba.is1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0293a implements ValueAnimator.AnimatorUpdateListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ sp1 a;

                public C0293a(RunnableC0292a runnableC0292a, sp1 sp1Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0292a, sp1Var};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = sp1Var;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                        this.a.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            }

            public RunnableC0292a(a aVar, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                sp1 i;
                int f;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i = yo2.U().i()) == null) {
                    return;
                }
                if (!(i instanceof NgWebView)) {
                    f = ch3.f(this.c.a.getContext(), this.a);
                } else {
                    f = is1.z(i, ch3.f(this.c.a.getContext(), this.a));
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(i.getWebViewScrollY(), f);
                ofInt.setDuration(this.b);
                ofInt.addUpdateListener(new C0293a(this, i));
                ofInt.start();
            }
        }

        public a(is1 is1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {is1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = is1Var;
        }

        @Override // com.baidu.tieba.or1.a
        public lv1 a(l33 l33Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l33Var, jSONObject, str)) == null) {
                int optInt = jSONObject.optInt("scrollTop", -1);
                int optInt2 = jSONObject.optInt("duration", -1);
                if (optInt > -1 && optInt2 > -1) {
                    fh3.e0(new RunnableC0292a(this, optInt, optInt2));
                    return new lv1(0);
                }
                l02.c("PageScrollToApi", "illegal scrollTop or duration");
                return new lv1(1001, "illegal params");
            }
            return (lv1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public is1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int z(@NonNull sp1 sp1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, sp1Var, i)) == null) {
            int contentHeight = ((int) (sp1Var.getContentHeight() * sp1Var.getScale())) - ((Integer) yo2.U().r().second).intValue();
            if (contentHeight <= 0) {
                return 0;
            }
            return i > contentHeight ? contentHeight : i;
        }
        return invokeLI.intValue;
    }

    public lv1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#pageScrollTo", false);
            return l(str, false, new a(this));
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PageScrollToApi" : (String) invokeV.objValue;
    }
}
