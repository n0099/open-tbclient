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
/* loaded from: classes5.dex */
public final class nk6 implements v17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> a;

    @Override // com.baidu.tieba.v17
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK : (String) invokeV.objValue;
    }

    public nk6() {
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

    @Override // com.baidu.tieba.v17
    public Map<String, String> a(hy6 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            Map<String, String> a = businessInfo.a();
            this.a.put("obj_type", tk6.a.a(businessInfo));
            this.a.put("obj_source", "1");
            this.a.put("obj_param1", "1");
            HashMap<String, String> hashMap = this.a;
            String str = a.get("live_type");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put(TiebaStatic.Params.OBJ_PARAM2, str);
            HashMap<String, String> hashMap2 = this.a;
            String str3 = a.get("thread_id");
            if (str3 != null) {
                str2 = str3;
            }
            hashMap2.put("obj_id", str2);
            return this.a;
        }
        return (Map) invokeL.objValue;
    }

    public final nk6 b(String locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locate)) == null) {
            Intrinsics.checkNotNullParameter(locate, "locate");
            this.a.put("obj_locate", locate);
            return this;
        }
        return (nk6) invokeL.objValue;
    }
}
