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
public class kn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final String c;
    public String d;
    public String e;
    @Nullable
    public final mn0 f;
    @NonNull
    public String g;
    @NonNull
    public final HashMap<String, String> h;

    public kn0(@NonNull JSONObject jSONObject, boolean z) {
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
            this.f = mn0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
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
        this.f = mn0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        Iterator<String> keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            if (!TextUtils.isEmpty(next2) && (opt = jSONObject.opt(next2)) != null && !(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
                this.h.put(next2, jSONObject.optString(next2));
            }
        }
    }

    @Nullable
    public static kn0 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new kn0(jSONObject, false);
        }
        return (kn0) invokeL.objValue;
    }

    @Nullable
    public static kn0 c(HashMap hashMap) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap == null || (obj = hashMap.get(WriteActivityConfig.VIDEO_INFO)) == null) {
                return null;
            }
            kn0 kn0Var = new kn0(yx0.c(obj.toString()), true);
            if (hashMap.get("ext_info") != null) {
                kn0Var.e = hashMap.get("ext_info").toString();
            }
            kn0Var.a();
            return kn0Var;
        }
        return (kn0) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.g)) {
            return;
        }
        JSONObject c = yx0.c(this.g);
        yx0.f(c, "videoId", c.optString("video_id"));
        yx0.f(c, PrefetchEvent.EVENT_KEY_PAGE_URL, c.optString("page_url"));
        yx0.f(c, "videoUrl", c.optString("video_url"));
        yx0.f(c, "posterImage", c.optString("poster_image"));
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
            mn0 mn0Var = this.f;
            if (mn0Var != null) {
                mn0Var.d(adBaseModel);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.g)) {
            return;
        }
        JSONObject c = yx0.c(this.g);
        if (!TextUtils.isEmpty(this.d) && TextUtils.isEmpty(c.optString("title"))) {
            yx0.f(c, "title", this.d);
        }
        JSONObject optJSONObject = c.optJSONObject("ext_log");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (TextUtils.isEmpty(optJSONObject.optString("curVid"))) {
            yx0.f(optJSONObject, "curVid", this.a);
        }
        if (!optJSONObject.has("mt")) {
            yx0.d(optJSONObject, "mt", 2);
        }
        if (!optJSONObject.has("vType")) {
            yx0.d(optJSONObject, "vType", 2);
        }
        if (!TextUtils.isEmpty(this.e) && TextUtils.isEmpty(optJSONObject.optString("ad_extra_param"))) {
            yx0.f(optJSONObject, "ad_extra_param", this.e);
        }
        yx0.f(c, "ext_log", optJSONObject);
        this.g = c.toString();
    }
}
