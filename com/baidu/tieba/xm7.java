package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tieba.feed.log.FeedStat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class xm7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948305255, "Lcom/baidu/tieba/xm7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948305255, "Lcom/baidu/tieba/xm7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes9.dex */
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

        public final void a(String id, Map<String, String> businessInfo, Map<String, String> logInfo, Map<String, String> runInfo) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, id, businessInfo, logInfo, runInfo) == null) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
                Intrinsics.checkNotNullParameter(logInfo, "logInfo");
                Intrinsics.checkNotNullParameter(runInfo, "runInfo");
                if (Intrinsics.areEqual(id, "image_click") && (i = JavaTypesHelper.toInt(runInfo.get("get_pic_index"), -1)) >= 0) {
                    JSONArray jSONArray = new JSONArray();
                    String str = businessInfo.get("mix_card_pic_type_list");
                    if (str != null) {
                        try {
                            jSONArray = new JSONArray(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (jSONArray.length() > 0) {
                        Object obj = jSONArray.get(i);
                        String str2 = logInfo.get("common_info_from_c15455");
                        if (str2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject = new JSONObject(str2);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("base_info");
                            if (optJSONObject == null) {
                                optJSONObject = new JSONObject();
                            } else {
                                Intrinsics.checkNotNullExpressionValue(optJSONObject, "jsonObject.optJSONObject…ASE_INFO) ?: JSONObject()");
                            }
                            optJSONObject.put("stat_key", CommonStatisticKey.KEY_LIVE_MERGE_CARD_CLICK);
                            optJSONObject.put("obj_locate", obj);
                            jSONObject.put("base_info", optJSONObject);
                            FeedStat.a.l(jSONObject, runInfo);
                        }
                    }
                }
            }
        }
    }
}
