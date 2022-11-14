package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qm2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class kl2 extends ai2<qm2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final qm2.a h;

    /* loaded from: classes4.dex */
    public class a implements qm2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kl2 a;

        public a(kl2 kl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kl2Var;
        }

        @Override // com.baidu.tieba.qm2.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onStateChange", Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onInfo", Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onNetStatus", str);
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onError", Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                if (kl2.i) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                wu1.e().q(str);
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    wu1.e().l(str, false);
                }
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPlayed", null);
                }
                wu1.e().l(str, true);
                wu1.e().k(str);
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onVideoSizeChanged", null);
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onEnded", null);
            }
        }

        @Override // com.baidu.tieba.qm2.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onPrepared", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947916856, "Lcom/baidu/tieba/kl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947916856, "Lcom/baidu/tieba/kl2;");
                return;
            }
        }
        i = pk1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kl2(@NonNull qm2 qm2Var) {
        super(qm2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qm2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ci2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        qm2Var.g0(aVar);
        this.a.a(new nl2());
        this.a.a(new ol2());
        this.a.a(new pl2());
        this.a.a(new sl2());
        this.a.a(new rl2());
        this.a.a(new ql2());
        this.a.a(new tl2());
        this.a.a(new ul2());
        this.a.a(new vl2());
        this.a.a(new wl2());
        this.a.a(new yl2());
        this.a.a(new zl2());
        this.a.a(new am2());
        this.a.a(new bm2());
        this.a.a(new dm2());
        this.a.a(new em2());
        this.a.a(new fm2());
        this.a.a(new hm2());
        this.a.a(new im2());
        this.a.a(new cm2());
        this.a.a(new xl2());
        this.a.a(new gm2());
    }
}
