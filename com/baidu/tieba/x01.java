package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.CollapsingTextHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
@Service
/* loaded from: classes9.dex */
public final class x01 extends re0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.re0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "toast" : (String) invokeV.objValue;
    }

    public x01() {
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

    @Override // com.baidu.tieba.re0
    public boolean b(Context context, ve0 schemeModel, Map<String, Object> map, ze0 ze0Var) {
        InterceptResult invokeLLLL;
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, schemeModel, map, ze0Var)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schemeModel, "schemeModel");
            super.b(context, schemeModel, map, ze0Var);
            HashMap<String, String> d = schemeModel.d();
            Intrinsics.checkNotNullExpressionValue(d, "schemeModel.params");
            w01 w01Var = new w01(d);
            if (TextUtils.isEmpty(w01Var.c())) {
                return true;
            }
            if (w01Var.b() >= 0 && w01Var.b() < w01Var.c().length()) {
                StringBuilder sb = new StringBuilder();
                String c2 = w01Var.c();
                int b = w01Var.b();
                if (c2 != null) {
                    String substring = c2.substring(0, b);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append(CollapsingTextHelper.ELLIPSIS_NORMAL);
                    c = sb.toString();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                c = w01Var.c();
            }
            y01.a().b(context, c, w01Var.a());
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
