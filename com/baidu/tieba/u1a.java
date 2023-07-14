package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class u1a implements qc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qc7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "c10705" : (String) invokeV.objValue;
    }

    public u1a() {
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

    @Override // com.baidu.tieba.qc7
    public Map<String, String> a(d87 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            HashMap hashMap = new HashMap();
            Map<String, String> a = businessInfo.a();
            hashMap.putAll(d2a.a.a(businessInfo));
            String str = a.get("pic_count");
            String str2 = "0";
            if (str == null) {
                str = "0";
            }
            hashMap.put("obj_type", str);
            hashMap.put(TiebaStatic.Params.AB_ACTION, "show");
            String str3 = a.get("has_concerned");
            if (str3 == null) {
                str3 = "0";
            }
            hashMap.put(TiebaStatic.Params.AB_TYPE, str3);
            hashMap.put(TiebaStatic.Params.IS_FULL, "");
            String str4 = a.get("author_is_living");
            if (str4 == null) {
                str4 = "0";
            }
            hashMap.put(TiebaStatic.Params.OBJ_PARAM6, str4);
            String str5 = a.get(TiebaStatic.Params.GUA_TYPE);
            if (str5 != null) {
                str2 = str5;
            }
            hashMap.put(TiebaStatic.Params.GUA_TYPE, str2);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
