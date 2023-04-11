package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.ParseError;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class op0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final AdBaseModel.STYLE a;
    @NonNull
    public final String b;
    @NonNull
    public String c;
    @NonNull
    public final String d;
    @NonNull
    public final String e;
    @NonNull
    public final String f;
    @NonNull
    public final String g;
    @NonNull
    public final String h;
    @NonNull
    public final String i;
    @NonNull
    public final List<String> j;
    @NonNull
    public final List<hp0> k;
    @NonNull
    public final String l;
    @NonNull
    public final String m;

    public op0(@NonNull AdBaseModel.STYLE style, @NonNull String str, int i, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull String str2) {
        int length;
        int length2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {style, str, Integer.valueOf(i), jSONObject, jSONObject2, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = style;
        this.b = jSONObject2.optString("id");
        this.c = jSONObject2.optString("scheme");
        if (!TextUtils.isEmpty(str2)) {
            this.d = str2;
        } else {
            this.d = jSONObject2.optString("ext_info");
        }
        this.e = jSONObject2.optString("user_name");
        this.f = jSONObject2.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
        this.g = jSONObject2.optString("title");
        if (jSONObject2.optInt("title_lines", 0) > 0) {
        }
        this.h = jSONObject2.optString("tag", "广告");
        this.i = jSONObject2.optString("recommend_reason");
        this.j = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("recommend_reason");
        if (optJSONArray == null) {
            length = 0;
        } else {
            length = optJSONArray.length();
        }
        for (int i4 = 0; i4 < length; i4++) {
            String optString = optJSONArray.optString(i4);
            if (!TextUtils.isEmpty(optString)) {
                v01.b(this.j, optString);
            }
        }
        this.k = new ArrayList();
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("pic_list");
        if (optJSONArray2 == null) {
            length2 = 0;
        } else {
            length2 = optJSONArray2.length();
        }
        for (int i5 = 0; i5 < length2; i5++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i5);
            if (optJSONObject != null) {
                v01.b(this.k, hp0.a(optJSONObject));
            }
        }
        gq0.a(jSONObject2.optJSONArray("lottie_list"));
        this.l = jSONObject2.optString("refer_url");
        this.m = jSONObject2.optString("prerender_scheme");
    }

    public static op0 a(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, String str2) throws ParseError {
        InterceptResult invokeCommon;
        AdBaseModel.STYLE style;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), jSONObject, jSONObject2, str2})) == null) {
            try {
                style = AdBaseModel.STYLE.from(jSONObject2.optString(MapBundleKey.MapObjKey.OBJ_AD_STYLE, "hidden"));
            } catch (Throwable unused) {
                style = null;
            }
            AdBaseModel.STYLE style2 = style;
            if (style2 != null) {
                return new op0(style2, str, i, jSONObject, jSONObject2, str2);
            }
            throw ParseError.contentError(24, jSONObject2.optString(MapBundleKey.MapObjKey.OBJ_AD_STYLE));
        }
        return (op0) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (hp0 hp0Var : this.k) {
                hp0Var.b();
            }
        }
    }
}
