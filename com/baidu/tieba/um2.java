package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.ao2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class um2 extends kj2<ao2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ao2.a h;

    /* loaded from: classes8.dex */
    public class a implements ao2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ um2 a;

        public a(um2 um2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {um2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = um2Var;
        }

        @Override // com.baidu.tieba.ao2.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onStateChange", Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.ao2.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onInfo", Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.ao2.a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onNetStatus", str);
            }
        }

        @Override // com.baidu.tieba.ao2.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, GameAssistConstKt.TYPE_CALLBACK_ERROR, Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.ao2.a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                if (um2.i) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                hw1.e().q(str);
            }
        }

        @Override // com.baidu.tieba.ao2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    hw1.e().l(str, false);
                }
            }
        }

        @Override // com.baidu.tieba.ao2.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPlayed", null);
                }
                hw1.e().l(str, true);
                hw1.e().k(str);
            }
        }

        @Override // com.baidu.tieba.ao2.a
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onVideoSizeChanged", null);
            }
        }

        @Override // com.baidu.tieba.ao2.a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onEnded", null);
            }
        }

        @Override // com.baidu.tieba.ao2.a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948215727, "Lcom/baidu/tieba/um2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948215727, "Lcom/baidu/tieba/um2;");
                return;
            }
        }
        i = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public um2(@NonNull ao2 ao2Var) {
        super(ao2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ao2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((mj2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        ao2Var.g0(aVar);
        this.a.a(new xm2());
        this.a.a(new ym2());
        this.a.a(new zm2());
        this.a.a(new cn2());
        this.a.a(new bn2());
        this.a.a(new an2());
        this.a.a(new dn2());
        this.a.a(new en2());
        this.a.a(new fn2());
        this.a.a(new gn2());
        this.a.a(new in2());
        this.a.a(new jn2());
        this.a.a(new kn2());
        this.a.a(new ln2());
        this.a.a(new nn2());
        this.a.a(new on2());
        this.a.a(new pn2());
        this.a.a(new rn2());
        this.a.a(new sn2());
        this.a.a(new mn2());
        this.a.a(new hn2());
        this.a.a(new qn2());
    }
}
