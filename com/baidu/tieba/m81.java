package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
@Service
/* loaded from: classes5.dex */
public final class m81 extends sh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    @Override // com.baidu.tieba.sh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "prerender" : (String) invokeV.objValue;
    }

    public m81() {
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
        this.a = "PreRenderAction";
    }

    @Override // com.baidu.tieba.sh0
    public boolean b(Context context, wh0 schemeModel, Map<String, Object> map, ai0 ai0Var) {
        InterceptResult invokeLLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, schemeModel, map, ai0Var)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schemeModel, "schemeModel");
            super.b(context, schemeModel, map, ai0Var);
            if (cm0.b().a().a("ad_do_prerender", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i81 c = g81.c();
                if (c != null) {
                    c.c();
                }
                return false;
            }
            HashMap<String, String> d = schemeModel.d();
            Intrinsics.checkNotNullExpressionValue(d, "schemeModel.params");
            String str = d.get("url");
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                o81.a("PreRender_" + this.a, "URL 为空，协议错误，无法预渲染");
                return false;
            }
            d.get("web_type");
            String str2 = d.get(TiebaStatic.Params.REFER);
            i81 c2 = g81.c();
            if (c2 != null) {
                c2.b(str, null, str2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
