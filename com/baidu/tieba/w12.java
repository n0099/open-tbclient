package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w12 extends n12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final int B(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                return i;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RequestFullScreenApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ w12 c;

        public a(w12 w12Var, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w12Var, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w12Var;
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View b = da3.b();
                LinearLayout d = da3.d();
                int i = this.a;
                if (i != -90) {
                    if (i != 0) {
                        if (i != 90) {
                            da3.o();
                            if (b != null) {
                                b.setVisibility(0);
                            }
                            if (d != null) {
                                d.setVisibility(0);
                            }
                            w12.E();
                        } else {
                            if (b != null) {
                                b.setVisibility(8);
                            }
                            if (d != null) {
                                d.setVisibility(8);
                            }
                            da3.g();
                            da3.m(true);
                            w12.D(0);
                        }
                    } else {
                        if (d != null) {
                            d.setVisibility(8);
                        }
                        w12.C();
                    }
                } else {
                    if (b != null) {
                        b.setVisibility(8);
                    }
                    if (d != null) {
                        d.setVisibility(8);
                    }
                    da3.g();
                    da3.m(true);
                    w12.D(8);
                }
                y12.e().u(this.a);
                this.c.d(this.b, new h32(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w12(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            SwanAppActivity activity = uw2.T().getActivity();
            if (qn3.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            pa2 H = uw2.T().H();
            if (H != null) {
                H.T3(true);
                H.r2();
            }
        }
    }

    public static void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            if (uw2.T().H() != null) {
                uw2.T().H().T3(false);
            }
            SwanAppActivity activity = uw2.T().getActivity();
            if (qn3.d(activity)) {
                activity.setRequestedOrientation(i);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(2048);
                activity.getWindow().setFlags(1024, 1024);
            }
        }
    }

    public h32 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setFullScreen", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            A(B(jSONObject.optBoolean("fullScreen"), jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)), jSONObject.optString("cb"));
            return h32.f();
        }
        return (h32) invokeL.objValue;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            SwanAppActivity activity = uw2.T().getActivity();
            pa2 H = uw2.T().H();
            if (qn3.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            if (!da3.i(da3.e(activity))) {
                da3.m(false);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
                activity.getWindow().clearFlags(2048);
            }
            if (H != null) {
                H.T3(false);
                H.r2();
                iq3 J1 = H.J1();
                if (J1 != null) {
                    int i = J1.d().b;
                    View b = da3.b();
                    if (b != null) {
                        b.findViewById(R.id.obfuscated_res_0x7f09018e).setBackgroundColor(i);
                    }
                }
                SwanAppActionBar L1 = H.L1();
                L1.f(L1.getCenterTitleView().getCurrentTextColor(), false);
            }
        }
    }

    public final void A(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            bp3.a0(new a(this, i, str));
        }
    }
}
