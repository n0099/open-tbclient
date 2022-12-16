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
public class uw2 extends s32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends p52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw2 c;

        public a(uw2 uw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uw2Var;
        }

        @Override // com.baidu.tieba.p52, com.baidu.tieba.s52
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                    Map<String, String> t = wh3.t(wh3.o(str));
                    if (t != null && t.get("statusCode") != null) {
                        try {
                            ww2.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), URLDecoder.decode(t.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            ww2.a().onPayResult(Integer.valueOf(t.get("statusCode")).intValue(), null);
                        }
                    } else {
                        ww2.a().onPayResult(6, null);
                    }
                    s32.Y2();
                    return true;
                }
                return super.b(str);
            }
            return invokeL.booleanValue;
        }
    }

    public uw2() {
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

    @Override // com.baidu.tieba.s32
    public s52 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (s52) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s32
    public nq1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ya2.U().f0().i(getContext());
        }
        return (nq1) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.baidu.tieba.lq1] */
    @Override // com.baidu.tieba.s32, com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00df, viewGroup, false);
            inflate.findViewById(R.id.obfuscated_res_0x7f09018a).setVisibility(8);
            nq1 k = k();
            this.F0 = k;
            k.Y(Z2());
            this.G0 = this.F0.r();
            this.F0.loadUrl(this.H0);
            this.F0.j((FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901b5), this.G0.covertToView());
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
