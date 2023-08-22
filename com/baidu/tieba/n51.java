package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
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
/* loaded from: classes7.dex */
public final class n51 extends cj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.cj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "toast" : (String) invokeV.objValue;
    }

    public n51() {
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

    @Override // com.baidu.tieba.cj0
    public boolean b(Context context, gj0 schemeModel, Map<String, Object> map, kj0 kj0Var) {
        InterceptResult invokeLLLL;
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, schemeModel, map, kj0Var)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schemeModel, "schemeModel");
            super.b(context, schemeModel, map, kj0Var);
            HashMap<String, String> d = schemeModel.d();
            Intrinsics.checkNotNullExpressionValue(d, "schemeModel.params");
            m51 m51Var = new m51(d);
            if (TextUtils.isEmpty(m51Var.c())) {
                return true;
            }
            if (m51Var.b() >= 0 && m51Var.b() < m51Var.c().length()) {
                StringBuilder sb = new StringBuilder();
                String c2 = m51Var.c();
                int b = m51Var.b();
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
                c = m51Var.c();
            }
            Toast.makeText(context, c, m51Var.a()).show();
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
