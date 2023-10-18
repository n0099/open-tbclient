package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public class jy2 extends d52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer N0;

    /* loaded from: classes6.dex */
    public class a extends a72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy2 c;

        public a(jy2 jy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jy2Var;
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                p22.k("SwanAppWxPayFragment", "onReceivedSslError:  statusCode = " + i);
            }
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                p22.k("SwanAppWxPayFragment", "title: " + str);
            }
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                p22.k("SwanAppWxPayFragment", "url: " + str);
            }
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null && str.startsWith("weixin://wap/pay")) {
                    p22.i("SwanAppWxPayFragment", " weixin  url:   " + str);
                    ic3.K("wechatH5Action", "intoPayment", 0);
                    this.c.N0.cancel();
                    this.c.N0 = null;
                    d52.f3();
                    return false;
                }
                return super.a(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void c(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                String str3 = "onReceivedError:  failingUrl = " + str2 + " errorCode = " + i + " description = " + str;
                p22.k("SwanAppWxPayFragment", str3);
                ic3.H(false, "wechatH5Action", ic3.m(str2, str3));
            }
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                p22.k("SwanAppWxPayFragment", "goBack: ");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy2 a;

        public b(jy2 jy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jy2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p22.k("SwanAppWxPayFragment", " WeChat H5 pay redirect time out : ");
                ic3.K("wechatH5Action", "outOfTime", 0);
            }
        }
    }

    public jy2() {
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

    @Override // com.baidu.tieba.d52
    public d72 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new a(this);
        }
        return (d72) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d52
    public zr1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.N0 == null) {
                this.N0 = p3();
            }
            return jc2.V().g0().i(s());
        }
        return (zr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d52, com.baidu.tieba.v42
    public void b2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            super.b2(view2);
            this.f0.setTitle(J().getString(R.string.obfuscated_res_0x7f0f021b));
            E2(false);
        }
    }

    @Override // com.baidu.tieba.d52
    public void d3(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
            frameLayout.addView((RelativeLayout) LayoutInflater.from(s()).inflate(R.layout.obfuscated_res_0x7f0d00e5, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public Timer p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            p22.k("SwanAppWxPayFragment", " start WeChat H5 redirect timer start : ");
            Timer timer = new Timer();
            try {
                timer.schedule(new b(this), 10000L);
            } catch (Exception e) {
                if (d52.M0) {
                    e.printStackTrace();
                }
                p22.k("SwanAppWxPayFragment", e.getMessage());
            }
            return timer;
        }
        return (Timer) invokeV.objValue;
    }
}
