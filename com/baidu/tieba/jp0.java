package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class jp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final String c;
    public String d;
    public String e;
    @Nullable
    public final lp0 f;
    @NonNull
    public String g;
    @NonNull
    public final HashMap<String, String> h;

    public jp0(@NonNull JSONObject jSONObject, boolean z) {
        Object opt;
        Object opt2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new HashMap<>();
        this.g = jSONObject.toString();
        TextUtils.equals(jSONObject.optString("video_stretch_switch"), "1");
        if (z) {
            this.a = jSONObject.optString(TiebaStatic.Params.VID);
            jSONObject.optString("video_id");
            jSONObject.optString("video_url");
            this.d = jSONObject.optString("title");
            this.b = jSONObject.optInt("duration");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.optDouble("whRatio", 0.0d);
            this.c = jSONObject.optString("poster_image");
            this.f = lp0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (opt2 = jSONObject.opt(next)) != null && !(opt2 instanceof JSONObject) && !(opt2 instanceof JSONArray)) {
                    this.h.put(next, jSONObject.optString(next));
                }
            }
            return;
        }
        this.a = jSONObject.optString(TiebaStatic.Params.VID);
        jSONObject.optString("videoId");
        jSONObject.optString("videoUrl");
        this.d = jSONObject.optString("title");
        this.b = jSONObject.optInt("duration");
        jSONObject.optInt("width");
        jSONObject.optInt("height");
        this.c = jSONObject.optString("posterImage");
        jSONObject.optDouble("whRatio", 0.0d);
        this.f = lp0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        Iterator<String> keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            if (!TextUtils.isEmpty(next2) && (opt = jSONObject.opt(next2)) != null && !(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
                this.h.put(next2, jSONObject.optString(next2));
            }
        }
    }

    @Nullable
    public static jp0 b(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, jSONObject, z)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new jp0(jSONObject, z);
        }
        return (jp0) invokeLZ.objValue;
    }

    @Nullable
    public static jp0 c(HashMap hashMap) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap == null || (obj = hashMap.get(WriteActivityConfig.VIDEO_INFO)) == null) {
                return null;
            }
            jp0 jp0Var = new jp0(xz0.c(obj.toString()), true);
            if (hashMap.get("ext_info") != null) {
                jp0Var.e = hashMap.get("ext_info").toString();
            }
            jp0Var.a();
            return jp0Var;
        }
        return (jp0) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.g)) {
            return;
        }
        JSONObject c = xz0.c(this.g);
        xz0.f(c, "videoId", c.optString("video_id"));
        xz0.f(c, PrefetchEvent.EVENT_KEY_PAGE_URL, c.optString("page_url"));
        xz0.f(c, "videoUrl", c.optString("video_url"));
        xz0.f(c, "posterImage", c.optString("poster_image"));
        this.g = c.toString();
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(adBaseModel.f.g)) {
                String str = adBaseModel.f.g;
                this.d = str;
                this.h.put("title", str);
            }
            if (TextUtils.isEmpty(this.e)) {
                this.e = adBaseModel.f.d;
            }
            e();
            lp0 lp0Var = this.f;
            if (lp0Var != null) {
                lp0Var.d(adBaseModel);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.g)) {
            return;
        }
        JSONObject c = xz0.c(this.g);
        if (!TextUtils.isEmpty(this.d) && TextUtils.isEmpty(c.optString("title"))) {
            xz0.f(c, "title", this.d);
        }
        JSONObject optJSONObject = c.optJSONObject("ext_log");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (TextUtils.isEmpty(optJSONObject.optString("curVid"))) {
            xz0.f(optJSONObject, "curVid", this.a);
        }
        if (!optJSONObject.has("mt")) {
            xz0.d(optJSONObject, "mt", 2);
        }
        if (!optJSONObject.has("vType")) {
            xz0.d(optJSONObject, "vType", 2);
        }
        if (!TextUtils.isEmpty(this.e) && TextUtils.isEmpty(optJSONObject.optString("ad_extra_param"))) {
            xz0.f(optJSONObject, "ad_extra_param", this.e);
        }
        xz0.f(c, "ext_log", optJSONObject);
        this.g = c.toString();
    }
}
