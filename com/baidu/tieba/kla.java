package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class kla implements ub7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kla() {
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

    @Override // com.baidu.tieba.ub7
    public Map<String, String> a(r57 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            HashMap hashMap = new HashMap();
            Map<String, String> a = businessInfo.a();
            String str = a.get("live_type");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("obj_type", str);
            String str3 = a.get("live_app_id");
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put(TiebaStatic.Params.OBJ_PARAM3, str3);
            String str4 = a.get("abtest_tag");
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put("ab_tag", str4);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            hashMap.put("uid", currentAccount);
            String str5 = a.get("extra");
            if (str5 == null) {
                str5 = "";
            }
            hashMap.put("obj_param1", str5);
            String str6 = a.get("source");
            if (str6 == null) {
                str6 = "";
            }
            hashMap.put("obj_source", str6);
            String str7 = a.get("position_from_1");
            if (str7 == null) {
                str7 = "";
            }
            hashMap.put(TiebaStatic.Params.OBJ_FLOOR, str7);
            hashMap.put(TiebaStatic.Params.OBJ_PARAM4, "0");
            String cuid = TbadkCoreApplication.getInst().getCuid();
            if (cuid != null) {
                str2 = cuid;
            }
            hashMap.put("cuid", str2);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
