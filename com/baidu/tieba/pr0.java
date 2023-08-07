package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public String e;
    public final float f;
    public boolean g;
    public String h;
    @Nullable
    public final rr0 i;
    @NonNull
    public String j;
    @NonNull
    public final HashMap<String, String> k;

    public pr0(@NonNull JSONObject jSONObject, boolean z) {
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
        this.k = new HashMap<>();
        this.g = TextUtils.equals(jSONObject.optString("video_stretch_switch"), "1");
        this.f = (float) jSONObject.optDouble("video_aspect_ratio", 0.0d);
        if (z) {
            this.a = jSONObject.optString("vid");
            jSONObject.optString("video_id");
            this.b = jSONObject.optString("video_url");
            this.e = jSONObject.optString("title");
            this.c = jSONObject.optInt("duration");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.optDouble("whRatio", 0.0d);
            this.d = jSONObject.optString("poster_image");
            this.i = rr0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
            try {
                jSONObject.putOpt("videoUrl", this.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (opt2 = jSONObject.opt(next)) != null && !(opt2 instanceof JSONObject) && !(opt2 instanceof JSONArray)) {
                    this.k.put(next, jSONObject.optString(next));
                }
            }
        } else {
            this.a = jSONObject.optString("vid");
            jSONObject.optString("videoId");
            this.b = jSONObject.optString("videoUrl");
            this.e = jSONObject.optString("title");
            this.c = jSONObject.optInt("duration");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            this.d = jSONObject.optString("posterImage");
            jSONObject.optDouble("whRatio", 0.0d);
            this.i = rr0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
            try {
                jSONObject.putOpt("video_url", this.b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            Iterator<String> keys2 = jSONObject.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (!TextUtils.isEmpty(next2) && (opt = jSONObject.opt(next2)) != null && !(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
                    this.k.put(next2, jSONObject.optString(next2));
                }
            }
        }
        this.j = jSONObject.toString();
    }

    @Nullable
    public static pr0 b(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, jSONObject, z)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new pr0(jSONObject, z);
        }
        return (pr0) invokeLZ.objValue;
    }

    @Nullable
    public static pr0 c(HashMap hashMap) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap == null || (obj = hashMap.get(WriteActivityConfig.VIDEO_INFO)) == null) {
                return null;
            }
            pr0 pr0Var = new pr0(b31.c(obj.toString()), true);
            if (hashMap.get(MigrateStatisticUtils.EXT_INFO) != null) {
                pr0Var.h = hashMap.get(MigrateStatisticUtils.EXT_INFO).toString();
            }
            pr0Var.a();
            return pr0Var;
        }
        return (pr0) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.j)) {
            JSONObject c = b31.c(this.j);
            b31.f(c, "videoId", c.optString("video_id"));
            b31.f(c, PrefetchEvent.EVENT_KEY_PAGE_URL, c.optString("page_url"));
            b31.f(c, "videoUrl", c.optString("video_url"));
            b31.f(c, "posterImage", c.optString("poster_image"));
            this.j = c.toString();
        }
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) {
            if (TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(adBaseModel.f.g)) {
                String str = adBaseModel.f.g;
                this.e = str;
                this.k.put("title", str);
            }
            if (TextUtils.isEmpty(this.h)) {
                this.h = adBaseModel.f.d;
            }
            e();
            rr0 rr0Var = this.i;
            if (rr0Var != null) {
                rr0Var.d(adBaseModel);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !TextUtils.isEmpty(this.j)) {
            JSONObject c = b31.c(this.j);
            if (!TextUtils.isEmpty(this.e) && TextUtils.isEmpty(c.optString("title"))) {
                b31.f(c, "title", this.e);
            }
            JSONObject optJSONObject = c.optJSONObject(BasicVideoParserKt.EXT_LOG);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            if (TextUtils.isEmpty(optJSONObject.optString("curVid"))) {
                b31.f(optJSONObject, "curVid", this.a);
            }
            if (!optJSONObject.has("mt")) {
                b31.d(optJSONObject, "mt", 2);
            }
            if (!optJSONObject.has("vType")) {
                b31.d(optJSONObject, "vType", 2);
            }
            if (!TextUtils.isEmpty(this.h) && TextUtils.isEmpty(optJSONObject.optString("ad_extra_param"))) {
                b31.f(optJSONObject, "ad_extra_param", this.h);
            }
            b31.f(c, BasicVideoParserKt.EXT_LOG, optJSONObject);
            this.j = c.toString();
        }
    }
}
