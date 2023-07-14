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
/* loaded from: classes7.dex */
public class p43 extends jb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer N0;

    /* loaded from: classes7.dex */
    public class a extends gd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p43 c;

        public a(p43 p43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p43Var;
        }

        @Override // com.baidu.tieba.gd2, com.baidu.tieba.jd2
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                v82.k("SwanAppWxPayFragment", "onReceivedSslError:  statusCode = " + i);
            }
        }

        @Override // com.baidu.tieba.gd2, com.baidu.tieba.jd2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                v82.k("SwanAppWxPayFragment", "title: " + str);
            }
        }

        @Override // com.baidu.tieba.gd2, com.baidu.tieba.jd2
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                v82.k("SwanAppWxPayFragment", "url: " + str);
            }
        }

        @Override // com.baidu.tieba.gd2, com.baidu.tieba.jd2
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null && str.startsWith("weixin://wap/pay")) {
                    v82.i("SwanAppWxPayFragment", " weixin  url:   " + str);
                    oi3.K("wechatH5Action", "intoPayment", 0);
                    this.c.N0.cancel();
                    this.c.N0 = null;
                    jb2.a3();
                    return false;
                }
                return super.a(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.gd2, com.baidu.tieba.jd2
        public void c(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                String str3 = "onReceivedError:  failingUrl = " + str2 + " errorCode = " + i + " description = " + str;
                v82.k("SwanAppWxPayFragment", str3);
                oi3.H(false, "wechatH5Action", oi3.m(str2, str3));
            }
        }

        @Override // com.baidu.tieba.gd2, com.baidu.tieba.jd2
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                v82.k("SwanAppWxPayFragment", "goBack: ");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p43 a;

        public b(p43 p43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p43Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v82.k("SwanAppWxPayFragment", " WeChat H5 pay redirect time out : ");
                oi3.K("wechatH5Action", "outOfTime", 0);
            }
        }
    }

    public p43() {
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

    @Override // com.baidu.tieba.jb2
    public jd2 b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new a(this);
        }
        return (jd2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jb2
    public ey1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.N0 == null) {
                this.N0 = k3();
            }
            return pi2.U().f0().i(getContext());
        }
        return (ey1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jb2, com.baidu.tieba.bb2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            super.W1(view2);
            this.f0.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0218));
            z2(false);
        }
    }

    @Override // com.baidu.tieba.jb2
    public void Y2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
            frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00e3, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public Timer k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            v82.k("SwanAppWxPayFragment", " start WeChat H5 redirect timer start : ");
            Timer timer = new Timer();
            try {
                timer.schedule(new b(this), 10000L);
            } catch (Exception e) {
                if (jb2.M0) {
                    e.printStackTrace();
                }
                v82.k("SwanAppWxPayFragment", e.getMessage());
            }
            return timer;
        }
        return (Timer) invokeV.objValue;
    }
}
