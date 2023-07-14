package com.baidu.tieba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes6.dex */
public class l43 extends jb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends gd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l43 c;

        public a(l43 l43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l43Var;
        }

        @Override // com.baidu.tieba.gd2, com.baidu.tieba.jd2
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                    Map<String, String> t = np3.t(np3.o(str));
                    if (t != null && t.get("statusCode") != null) {
                        try {
                            n43.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), URLDecoder.decode(t.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            n43.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), null);
                        }
                    } else {
                        n43.a().onPayResult(6, null);
                    }
                    jb2.a3();
                    return true;
                }
                return super.a(str);
            }
            return invokeL.booleanValue;
        }
    }

    public l43() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (jd2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jb2
    public ey1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return pi2.U().f0().i(getContext());
        }
        return (ey1) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.baidu.tieba.cy1] */
    @Override // com.baidu.tieba.jb2, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e2, viewGroup, false);
            inflate.findViewById(R.id.obfuscated_res_0x7f090190).setVisibility(8);
            ey1 j = j();
            this.G0 = j;
            j.W(b3());
            this.H0 = this.G0.r();
            this.G0.loadUrl(this.I0);
            this.G0.i((FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bc), this.H0.covertToView());
            if (V1()) {
                inflate = Y1(inflate);
            }
            return F1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
