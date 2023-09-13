package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class w6a implements tc7, e97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tc7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a implements v97 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.v97
        public void a(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                Intrinsics.checkNotNullParameter(map, "map");
                hu6.b().b(new o5a(map.get("fname"), map.get("tid"), map.get("fid")));
            }
        }
    }

    public w6a() {
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

    @Override // com.baidu.tieba.e97
    public v97 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new a();
        }
        return (v97) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tc7
    public Map<String, String> a(f87 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            HashMap hashMap = new HashMap();
            String str = businessInfo.a().get("forum_name");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("fname", str);
            String str3 = businessInfo.a().get("forum_id");
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put("fid", str3);
            String str4 = businessInfo.a().get("thread_id");
            if (str4 != null) {
                str2 = str4;
            }
            hashMap.put("tid", str2);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
