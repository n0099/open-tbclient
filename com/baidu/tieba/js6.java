package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class js6 implements nb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> a;

    @Override // com.baidu.tieba.nb7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbadkCoreStatisticKey.KEY_VIRTUAL_IMAGE_SHOW : (String) invokeV.objValue;
    }

    public js6() {
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
        this.a = new HashMap<>();
    }

    @Override // com.baidu.tieba.nb7
    public Map<String, String> a(a77 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            Map<String, String> a = businessInfo.a();
            HashMap<String, String> hashMap = this.a;
            String str = a.get("has_customstate");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("obj_source", str);
            if (Intrinsics.areEqual(a.get("has_customstate"), "1")) {
                HashMap<String, String> hashMap2 = this.a;
                String str3 = a.get("customstate_name");
                if (str3 == null) {
                    str3 = "";
                }
                hashMap2.put("obj_name", str3);
            }
            HashMap<String, String> hashMap3 = this.a;
            String str4 = a.get("user_id");
            if (str4 != null) {
                str2 = str4;
            }
            hashMap3.put(TiebaStatic.Params.FRIEND_UID, str2);
            return this.a;
        }
        return (Map) invokeL.objValue;
    }

    public final js6 b(String locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locate)) == null) {
            Intrinsics.checkNotNullParameter(locate, "locate");
            this.a.put("obj_locate", locate);
            return this;
        }
        return (js6) invokeL.objValue;
    }

    public final js6 d(String type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, type)) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.a.put("obj_type", type);
            return this;
        }
        return (js6) invokeL.objValue;
    }
}
