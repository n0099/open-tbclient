package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class io0 {
    public static /* synthetic */ Interceptable $ic;
    public static final io0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947860095, "Lcom/baidu/tieba/io0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947860095, "Lcom/baidu/tieba/io0;");
                return;
            }
        }
        a = new io0();
    }

    public io0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final HashMap<String, String> a(HashMap<String, String> hashMap) throws IllegalStateException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hashMap)) == null) {
            for (String str : CollectionsKt__CollectionsKt.arrayListOf("reward", WriteActivityConfig.VIDEO_INFO, "convert", "panel", "common_info", "ext_info")) {
                if (hashMap.containsKey(str)) {
                    String str2 = hashMap.get(str);
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                    }
                }
                throw new IllegalStateException("key: " + str + " 数据不可为 null");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public final JSONObject b(HashMap<String, String> hashMap) throws JSONException {
        InterceptResult invokeL;
        String str;
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject c = a.c(hashMap.get("reward"));
            JSONObject c2 = a.c(hashMap.get(WriteActivityConfig.VIDEO_INFO));
            JSONObject c3 = a.c(hashMap.get("convert"));
            JSONObject c4 = a.c(hashMap.get("panel"));
            JSONObject c5 = a.c(hashMap.get("common_info"));
            JSONObject c6 = a.c(hashMap.get("app_info"));
            JSONObject c7 = a.c(hashMap.get("download"));
            JSONObject c8 = a.c(hashMap.get("cmd_policy"));
            String str6 = hashMap.get("ext_info");
            hashMap.get("lp_real_url");
            String str7 = hashMap.get("type");
            if (c3 != null) {
                c3.put("type", str7);
            }
            if (c3 != null) {
                c3.put("download", c7);
            }
            if (c3 != null) {
                c3.put("app_info", c6);
            }
            if (c3 != null) {
                c3.put("button_scheme", c3.optString("button_scheme"));
            }
            if (c3 != null) {
                c3.put("ext", str6);
            }
            if (c3 != null) {
                str = "button_scheme";
                c3.put(BdVideoAd.AD_VIDEO_DAPAGE, ClogBuilder.Page.WELFAREMAXLP.type);
            } else {
                str = "button_scheme";
            }
            jSONObject.put("reward", c);
            jSONObject.put("app_info", c6);
            jSONObject.put("cmd_policy", c8);
            jSONObject.put("ext_info", str6);
            jSONObject.put(WriteActivityConfig.VIDEO_INFO, c2);
            jSONObject.put("convert", c3);
            jSONObject.put(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, c7);
            String str8 = null;
            if (c5 != null) {
                jSONArray = c5.optJSONArray("ad_monitor_url");
            } else {
                jSONArray = null;
            }
            jSONObject.put("ad_monitor_url", jSONArray);
            jSONObject.put("type", str7);
            if (c4 != null) {
                str2 = c4.optString("panel_cmd");
            } else {
                str2 = null;
            }
            jSONObject.put("panel_cmd", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_AD_STYLE, AdBaseModel.STYLE.REWARD_VIDEO_LP_IMPL.value);
            if (c4 != null) {
                str3 = c4.optString("brand_name");
            } else {
                str3 = null;
            }
            jSONObject2.put("user_name", str3);
            if (c4 != null) {
                str4 = c4.optString("title");
            } else {
                str4 = null;
            }
            jSONObject2.put("title", str4);
            if (c4 != null) {
                str5 = c4.optString("avatar");
            } else {
                str5 = null;
            }
            jSONObject2.put(RecommendDetailActivityConfig.USER_PORTRAIT, str5);
            if (c3 != null) {
                str8 = c3.optString(str);
            }
            jSONObject2.put("scheme", str8);
            jSONObject.put("ad_common", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("convert", c3);
            Unit unit = Unit.INSTANCE;
            jSONObject.put("enhance", jSONObject3);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject c(String str) throws JSONException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            return new JSONObject(str);
        }
        return (JSONObject) invokeL.objValue;
    }

    public final xp0 d(HashMap<String, String> toLpModel) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, toLpModel)) == null) {
            Intrinsics.checkNotNullParameter(toLpModel, "$this$toLpModel");
            a(toLpModel);
            JSONObject b = b(toLpModel);
            AdBaseModel d = wp0.d("", 0, b, b.optString("ext_info"));
            if (d != null) {
                return (xp0) d;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.model.AdRewardVideoLpModel");
        }
        return (xp0) invokeL.objValue;
    }
}
