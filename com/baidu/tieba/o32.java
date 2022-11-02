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
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o32 extends k32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String F0;
    public JSONObject G0;
    public boolean H0;

    @Override // com.baidu.tieba.k32
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ o32 b;

        public a(o32 o32Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o32Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o32Var;
            this.a = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                rp2.U().u(new qz2(this.b.F0, this.a.toString(), this.b.G0.optString("slaveId")).a());
                this.b.H0 = false;
            }
        }
    }

    public o32() {
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
        this.H0 = true;
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c0 = null;
            super.B0();
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            H2(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.y0();
            d43.K().q().e0().v();
        }
    }

    @Override // com.baidu.tieba.k32
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            V1(view2);
            t2(-1);
            C2(-16777216);
            v2(G(R.string.obfuscated_res_0x7f0f12ac));
            x2(true);
            J2(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.u0(bundle);
            Bundle p = p();
            if (p == null) {
                return;
            }
            this.F0 = p.getString("plugin_fun_page_path");
            this.G0 = eh3.d(p.getString("plugin_pay_params"));
        }
    }

    public static o32 Y2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            o32 o32Var = new o32();
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("plugin_fun_page_path", str);
                bundle.putString("plugin_pay_params", str2);
                o32Var.j1(bundle);
            }
            return o32Var;
        }
        return (o32) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.k32
    public boolean I() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.H0 && (jSONObject = this.G0) != null) {
                pz2 pz2Var = new pz2(jSONObject.optString("componentId"));
                pz2Var.a = this.G0.optString("slaveId");
                pz2Var.b();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X2(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2 != null && this.G0 != null) {
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e73);
            e43 b0 = e43.b0();
            if (b0 != null) {
                textView.setText(b0.Y().K());
            }
            JSONObject optJSONObject = this.G0.optJSONObject("args");
            if (optJSONObject == null) {
                return;
            }
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e74)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
            TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e76);
            fd4 g = c03.g(this.G0.optString("pluginProvider"));
            if (g != null) {
                textView2.setText(g.s);
            }
            ((Button) view2.findViewById(R.id.obfuscated_res_0x7f090e75)).setOnClickListener(new a(this, optJSONObject));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d082e, viewGroup, false);
            U1(inflate);
            X2(inflate);
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
