package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
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
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class qp0 {
    public static /* synthetic */ Interceptable $ic;
    public static final qp0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948099384, "Lcom/baidu/tieba/qp0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948099384, "Lcom/baidu/tieba/qp0;");
                return;
            }
        }
        a = new qp0();
    }

    public qp0() {
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
            for (String str : CollectionsKt__CollectionsKt.arrayListOf("reward", "panel", "common_info", MigrateStatisticUtils.EXT_INFO)) {
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
        String str2;
        JSONArray jSONArray;
        String str3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String replace$default;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap)) == null) {
            JSONObject jSONObject4 = new JSONObject();
            JSONObject c = a.c(hashMap.get("reward"));
            JSONObject c2 = a.c(hashMap.get(WriteActivityConfig.VIDEO_INFO));
            JSONObject c3 = a.c(hashMap.get("image_info"));
            JSONObject c4 = a.c(hashMap.get("convert"));
            JSONObject c5 = a.c(hashMap.get("panel"));
            JSONObject c6 = a.c(hashMap.get("common_info"));
            JSONObject c7 = a.c(hashMap.get("app_info"));
            JSONObject c8 = a.c(hashMap.get("download"));
            JSONObject c9 = a.c(hashMap.get("cmd_policy"));
            JSONObject c10 = a.c(hashMap.get("big_card"));
            JSONObject c11 = a.c(hashMap.get("rotation_component"));
            JSONObject c12 = a.c(hashMap.get("ad_tag"));
            JSONObject c13 = a.c(hashMap.get("popover"));
            String str10 = hashMap.get(MigrateStatisticUtils.EXT_INFO);
            String str11 = hashMap.get("lp_real_url");
            String str12 = hashMap.get("type");
            if (c4 != null) {
                c4.put("type", str12);
            }
            if (c4 != null) {
                c4.put("download", c8);
            }
            if (c4 != null) {
                c4.put("app_info", c7);
            }
            if (c4 != null) {
                c4.put("button_scheme", c4.optString("button_scheme"));
            }
            if (c4 != null) {
                c4.put("ext", str10);
            }
            if (c4 != null) {
                str = "button_scheme";
                c4.put(BdVideoAd.AD_VIDEO_DAPAGE, ClogBuilder.Page.WELFAREMAXLP.type);
            } else {
                str = "button_scheme";
            }
            jSONObject4.put("ad_tag", c12);
            jSONObject4.put("popover", c13);
            jSONObject4.put("reward", c);
            jSONObject4.put("app_info", c7);
            jSONObject4.put("cmd_policy", c9);
            jSONObject4.put("big_card", c10);
            jSONObject4.put("rotation_component", c11);
            jSONObject4.put(MigrateStatisticUtils.EXT_INFO, str10);
            jSONObject4.put("lp_real_url", str11);
            jSONObject4.put(WriteActivityConfig.VIDEO_INFO, c2);
            jSONObject4.put("image_info", c3);
            jSONObject4.put("convert", c4);
            qp0 qp0Var = a;
            String str13 = hashMap.get("download");
            String str14 = null;
            if (str13 != null && (replace$default = StringsKt__StringsJVMKt.replace$default(str13, "pkg_name", "apk_name", false, 4, (Object) null)) != null) {
                str2 = StringsKt__StringsJVMKt.replace$default(replace$default, "key", "download_key", false, 4, (Object) null);
            } else {
                str2 = null;
            }
            jSONObject4.put(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, qp0Var.c(str2));
            if (c6 != null) {
                jSONArray = c6.optJSONArray("ad_monitor_url");
            } else {
                jSONArray = null;
            }
            jSONObject4.put("ad_monitor_url", jSONArray);
            jSONObject4.put("type", str12);
            if (c5 != null) {
                str3 = c5.optString("panel_cmd");
            } else {
                str3 = null;
            }
            jSONObject4.put("panel_cmd", str3);
            if (c5 != null) {
                jSONObject = c5.optJSONObject("sliding_tag");
            } else {
                jSONObject = null;
            }
            jSONObject4.put("sliding_tag", jSONObject);
            if (c6 != null) {
                jSONObject2 = c6.optJSONObject("sv_title");
            } else {
                jSONObject2 = null;
            }
            jSONObject4.put("sv_title", jSONObject2);
            if (c6 != null) {
                jSONObject3 = c6.optJSONObject("sv_button");
            } else {
                jSONObject3 = null;
            }
            jSONObject4.put("sv_button", jSONObject3);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(MapBundleKey.MapObjKey.OBJ_AD_STYLE, AdBaseModel.STYLE.REWARD_VIDEO_LP_IMPL.value);
            if (c5 != null) {
                str4 = c5.optString("brand_name");
            } else {
                str4 = null;
            }
            jSONObject5.put("user_name", str4);
            if (c5 != null) {
                str5 = c5.optString("title");
            } else {
                str5 = null;
            }
            jSONObject5.put("title", str5);
            if (c5 != null) {
                str6 = c5.optString("avatar");
            } else {
                str6 = null;
            }
            jSONObject5.put(RecommendDetailActivityConfig.USER_PORTRAIT, str6);
            if (c4 != null) {
                str7 = c4.optString(str);
            } else {
                str7 = null;
            }
            jSONObject5.put("scheme", str7);
            if (c6 != null) {
                str8 = c6.optString("refer_url");
            } else {
                str8 = null;
            }
            jSONObject5.put("refer_url", str8);
            if (c6 != null) {
                str9 = c6.optString("prerender_scheme");
            } else {
                str9 = null;
            }
            if (c6 != null) {
                str14 = c6.optString("refer_url");
            }
            jSONObject5.put("prerender_scheme", w51.l(str9, str14));
            jSONObject4.put("ad_common", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("convert", c4);
            Unit unit = Unit.INSTANCE;
            jSONObject4.put("enhance", jSONObject6);
            return jSONObject4;
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

    public final mr0 d(HashMap<String, String> toLpModel) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, toLpModel)) == null) {
            Intrinsics.checkNotNullParameter(toLpModel, "$this$toLpModel");
            a(toLpModel);
            JSONObject b = b(toLpModel);
            AdBaseModel d = jr0.d("", 0, b, b.optString(MigrateStatisticUtils.EXT_INFO));
            if (d != null) {
                return (mr0) d;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.model.AdRewardVideoLpModel");
        }
        return (mr0) invokeL.objValue;
    }
}
