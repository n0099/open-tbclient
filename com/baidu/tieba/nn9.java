package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public boolean k;

    public nn9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, advertAppInfo, adCard) != null) || advertAppInfo == null) {
            return;
        }
        int i = advertAppInfo.m;
        if (i == 3) {
            this.a = "apk_download";
            this.f = advertAppInfo.p;
            this.g = advertAppInfo.o;
        } else if (i == 1) {
            this.a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.e = adCard.getButtonText();
        this.b = adCard.userName;
        this.c = adCard.userImage;
        this.d = adCard.scheme;
        this.i = adCard.threadTitle;
        this.j = adCard.getButtonCmdScheme();
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("style");
        this.b = jSONObject.optString("user_name");
        this.c = jSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
        this.d = jSONObject.optString("scheme");
        this.e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f = optJSONObject.optString("pkgname");
            this.g = optJSONObject.optString("download_url");
        }
        jSONObject.optString("content");
        this.k = true;
        this.j = jSONObject.optString("button_scheme");
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.a);
                jSONObject.put("user_name", this.b);
                jSONObject.put(RecommendDetailActivityConfig.USER_PORTRAIT, this.c);
                jSONObject.put("scheme", this.d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f);
                jSONObject2.put("download_url", this.g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.h);
                jSONObject.put("button_scheme", this.j);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
