package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u52 extends q52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String G0;
    public JSONObject H0;
    public boolean I0;

    @Override // com.baidu.tieba.q52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ u52 b;

        public a(u52 u52Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u52Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u52Var;
            this.a = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xr2.V().v(new w13(this.b.G0, this.a.toString(), this.b.H0.optString("slaveId")).a());
                this.b.I0 = false;
            }
        }
    }

    public u52() {
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
        this.I0 = true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C0();
            j63.K().q().f0().v();
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c0 = null;
            super.F0();
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            O2(1);
        }
    }

    @Override // com.baidu.tieba.q52
    public void a2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            b2(view2);
            A2(-1);
            J2(-16777216);
            C2(X(R.string.obfuscated_res_0x7f0f1523));
            E2(true);
            Q2(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void x0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.x0(bundle);
            Bundle r = r();
            if (r == null) {
                return;
            }
            this.G0 = r.getString("plugin_fun_page_path");
            this.H0 = kj3.d(r.getString("plugin_pay_params"));
        }
    }

    public static u52 f3(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            u52 u52Var = new u52();
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("plugin_fun_page_path", str);
                bundle.putString("plugin_pay_params", str2);
                u52Var.m1(bundle);
            }
            return u52Var;
        }
        return (u52) invokeLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View A0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0954, viewGroup, false);
            a2(inflate);
            e3(inflate);
            if (Z1()) {
                inflate = c2(inflate);
            }
            return I1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean G() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.I0 && (jSONObject = this.H0) != null) {
                v13 v13Var = new v13(jSONObject.optString("componentId"));
                v13Var.a = this.H0.optString("slaveId");
                v13Var.b();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2 != null && this.H0 != null) {
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0910a4);
            k63 c0 = k63.c0();
            if (c0 != null) {
                textView.setText(c0.Z().L());
            }
            JSONObject optJSONObject = this.H0.optJSONObject(WebChromeClient.KEY_ARG_ARRAY);
            if (optJSONObject == null) {
                return;
            }
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0910a5)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
            TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0910a7);
            lf4 g = i23.g(this.H0.optString("pluginProvider"));
            if (g != null) {
                textView2.setText(g.s);
            }
            ((Button) view2.findViewById(R.id.obfuscated_res_0x7f0910a6)).setOnClickListener(new a(this, optJSONObject));
        }
    }
}
