package com.baidu.tieba;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.wv1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qw1 extends mw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PageScrollToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements wv1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qw1 a;

        /* renamed from: com.baidu.tieba.qw1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0399a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            /* renamed from: com.baidu.tieba.qw1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0400a implements ValueAnimator.AnimatorUpdateListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ au1 a;

                public C0400a(RunnableC0399a runnableC0399a, au1 au1Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0399a, au1Var};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = au1Var;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                        this.a.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            }

            public RunnableC0399a(a aVar, int i, int i2) {
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
                au1 i;
                int f;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (i = gt2.U().i()) == null) {
                    return;
                }
                if (i instanceof NgWebView) {
                    f = qw1.z(i, kl3.f(this.c.a.getContext(), this.a));
                } else {
                    f = kl3.f(this.c.a.getContext(), this.a);
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(i.getWebViewScrollY(), f);
                ofInt.setDuration(this.b);
                ofInt.addUpdateListener(new C0400a(this, i));
                ofInt.start();
            }
        }

        public a(qw1 qw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qw1Var;
        }

        @Override // com.baidu.tieba.wv1.a
        public tz1 a(t73 t73Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, t73Var, jSONObject, str)) == null) {
                int optInt = jSONObject.optInt("scrollTop", -1);
                int optInt2 = jSONObject.optInt("duration", -1);
                if (optInt > -1 && optInt2 > -1) {
                    nl3.e0(new RunnableC0399a(this, optInt, optInt2));
                    return new tz1(0);
                }
                t42.c("PageScrollToApi", "illegal scrollTop or duration");
                return new tz1(1001, "illegal params");
            }
            return (tz1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qw1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public tz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#pageScrollTo", false);
            return l(str, false, new a(this));
        }
        return (tz1) invokeL.objValue;
    }

    public static int z(@NonNull au1 au1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, au1Var, i)) == null) {
            int contentHeight = ((int) (au1Var.getContentHeight() * au1Var.getScale())) - ((Integer) gt2.U().r().second).intValue();
            if (contentHeight <= 0) {
                return 0;
            }
            if (i > contentHeight) {
                return contentHeight;
            }
            return i;
        }
        return invokeLI.intValue;
    }
}
