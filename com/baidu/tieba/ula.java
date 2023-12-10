package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ula {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216223, "Lcom/baidu/tieba/ula;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216223, "Lcom/baidu/tieba/ula;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final Map<String, String> a(v57 businessInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
                Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
                HashMap hashMap = new HashMap();
                Map<String, String> a = businessInfo.a();
                String str = a.get("extra");
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                hashMap.put("obj_id", str);
                String str3 = a.get("weight");
                if (str3 == null) {
                    str3 = "";
                }
                hashMap.put("obj_param1", str3);
                hashMap.put(TiebaStatic.Params.OBJ_PARAM2, "1");
                String str4 = a.get("source");
                if (str4 == null) {
                    str4 = "";
                }
                hashMap.put("obj_source", str4);
                String str5 = a.get("position_from_1");
                String str6 = "0";
                if (str5 == null) {
                    str5 = "0";
                }
                hashMap.put("obj_locate", str5);
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                hashMap.put("uid", currentAccount);
                hashMap.put(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(System.currentTimeMillis() / 1000));
                String str7 = a.get("abtest_tag");
                if (str7 != null) {
                    str2 = str7;
                }
                hashMap.put("ab_tag", str2);
                String str8 = a.get("is_video_work");
                if (str8 != null) {
                    str6 = str8;
                }
                hashMap.put(TiebaStatic.Params.IS_ZP, str6);
                hashMap.put(TiebaStatic.Params.OBJ_PARAM5, "1");
                return hashMap;
            }
            return (Map) invokeL.objValue;
        }
    }
}
