package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public int i;
    public long j;
    public long k;

    public k86() {
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
        this.d = "";
        this.c = "";
        this.e = "";
        this.f = "";
        this.b = "";
        this.a = "";
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !TextUtils.isEmpty(this.d);
        }
        return invokeV.booleanValue;
    }

    public static k86 a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            k86 k86Var = new k86();
            if (adInfo == null) {
                return k86Var;
            }
            k86Var.a = adInfo.adImgUrl;
            k86Var.b = adInfo.redirectUrl;
            k86Var.j = adInfo.startShowTime;
            k86Var.k = adInfo.endShowTime;
            k86Var.d = adInfo.videoLocalPath;
            k86Var.e = adInfo.videoJumpUrl;
            k86Var.f = adInfo.videoMd5;
            k86Var.g = adInfo.videoDuration;
            k86Var.h = adInfo.videoWidth;
            k86Var.i = adInfo.videoHight;
            k86Var.c = adInfo.adVideoUrl;
            return k86Var;
        }
        return (k86) invokeL.objValue;
    }

    public static k86 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            k86 k86Var = new k86();
            try {
                JSONObject jSONObject = new JSONObject(str);
                k86Var.a = jSONObject.optString("adImgUrl");
                k86Var.b = jSONObject.optString("redirectUrl");
                k86Var.d = jSONObject.optString("videoLocalPath");
                k86Var.j = jSONObject.optLong("startShowTime");
                k86Var.k = jSONObject.optLong("endShowTime");
                k86Var.e = jSONObject.optString("videoJumpUrl");
                k86Var.f = jSONObject.optString("videoMd5");
                k86Var.g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                k86Var.h = jSONObject.optInt("videoWidth");
                k86Var.i = jSONObject.optInt("videoHeight");
                k86Var.c = jSONObject.optString("adVideoUrl");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return k86Var;
        }
        return (k86) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ((System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.b);
                jSONObject.put("videoLocalPath", this.d);
                jSONObject.put("startShowTime", this.j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f);
                jSONObject.put("videoJumpUrl", this.e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.g);
                jSONObject.put("videoWidth", this.h);
                jSONObject.put("videoHeight", this.i);
                jSONObject.put("adVideoUrl", this.c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
