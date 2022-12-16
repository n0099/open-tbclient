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
/* loaded from: classes7.dex */
public class zp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final String c;
    public String d;
    public boolean e;
    public String f;
    @Nullable
    public final bq0 g;
    @NonNull
    public String h;
    @NonNull
    public final HashMap<String, String> i;

    public zp0(@NonNull JSONObject jSONObject, boolean z) {
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
        this.i = new HashMap<>();
        this.h = jSONObject.toString();
        this.e = TextUtils.equals(jSONObject.optString("video_stretch_switch"), "1");
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
            this.g = bq0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (opt2 = jSONObject.opt(next)) != null && !(opt2 instanceof JSONObject) && !(opt2 instanceof JSONArray)) {
                    this.i.put(next, jSONObject.optString(next));
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
        this.g = bq0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        Iterator<String> keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            if (!TextUtils.isEmpty(next2) && (opt = jSONObject.opt(next2)) != null && !(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
                this.i.put(next2, jSONObject.optString(next2));
            }
        }
    }

    @Nullable
    public static zp0 b(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, jSONObject, z)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new zp0(jSONObject, z);
        }
        return (zp0) invokeLZ.objValue;
    }

    @Nullable
    public static zp0 c(HashMap hashMap) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap == null || (obj = hashMap.get(WriteActivityConfig.VIDEO_INFO)) == null) {
                return null;
            }
            zp0 zp0Var = new zp0(p01.c(obj.toString()), true);
            if (hashMap.get("ext_info") != null) {
                zp0Var.f = hashMap.get("ext_info").toString();
            }
            zp0Var.a();
            return zp0Var;
        }
        return (zp0) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.h)) {
            JSONObject c = p01.c(this.h);
            p01.f(c, "videoId", c.optString("video_id"));
            p01.f(c, PrefetchEvent.EVENT_KEY_PAGE_URL, c.optString("page_url"));
            p01.f(c, "videoUrl", c.optString("video_url"));
            p01.f(c, "posterImage", c.optString("poster_image"));
            this.h = c.toString();
        }
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(adBaseModel.f.g)) {
                String str = adBaseModel.f.g;
                this.d = str;
                this.i.put("title", str);
            }
            if (TextUtils.isEmpty(this.f)) {
                this.f = adBaseModel.f.d;
            }
            e();
            bq0 bq0Var = this.g;
            if (bq0Var != null) {
                bq0Var.d(adBaseModel);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !TextUtils.isEmpty(this.h)) {
            JSONObject c = p01.c(this.h);
            if (!TextUtils.isEmpty(this.d) && TextUtils.isEmpty(c.optString("title"))) {
                p01.f(c, "title", this.d);
            }
            JSONObject optJSONObject = c.optJSONObject("ext_log");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            if (TextUtils.isEmpty(optJSONObject.optString("curVid"))) {
                p01.f(optJSONObject, "curVid", this.a);
            }
            if (!optJSONObject.has("mt")) {
                p01.d(optJSONObject, "mt", 2);
            }
            if (!optJSONObject.has("vType")) {
                p01.d(optJSONObject, "vType", 2);
            }
            if (!TextUtils.isEmpty(this.f) && TextUtils.isEmpty(optJSONObject.optString("ad_extra_param"))) {
                p01.f(optJSONObject, "ad_extra_param", this.f);
            }
            p01.f(c, "ext_log", optJSONObject);
            this.h = c.toString();
        }
    }
}
