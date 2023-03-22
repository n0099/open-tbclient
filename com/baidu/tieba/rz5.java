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
public class rz5 {
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

    public rz5() {
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

    public static rz5 a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            rz5 rz5Var = new rz5();
            if (adInfo == null) {
                return rz5Var;
            }
            rz5Var.a = adInfo.adImgUrl;
            rz5Var.b = adInfo.redirectUrl;
            rz5Var.j = adInfo.startShowTime;
            rz5Var.k = adInfo.endShowTime;
            rz5Var.d = adInfo.videoLocalPath;
            rz5Var.e = adInfo.videoJumpUrl;
            rz5Var.f = adInfo.videoMd5;
            rz5Var.g = adInfo.videoDuration;
            rz5Var.h = adInfo.videoWidth;
            rz5Var.i = adInfo.videoHight;
            rz5Var.c = adInfo.adVideoUrl;
            return rz5Var;
        }
        return (rz5) invokeL.objValue;
    }

    public static rz5 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            rz5 rz5Var = new rz5();
            try {
                JSONObject jSONObject = new JSONObject(str);
                rz5Var.a = jSONObject.optString("adImgUrl");
                rz5Var.b = jSONObject.optString("redirectUrl");
                rz5Var.d = jSONObject.optString("videoLocalPath");
                rz5Var.j = jSONObject.optLong("startShowTime");
                rz5Var.k = jSONObject.optLong("endShowTime");
                rz5Var.e = jSONObject.optString("videoJumpUrl");
                rz5Var.f = jSONObject.optString("videoMd5");
                rz5Var.g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                rz5Var.h = jSONObject.optInt("videoWidth");
                rz5Var.i = jSONObject.optInt("videoHeight");
                rz5Var.c = jSONObject.optString("adVideoUrl");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return rz5Var;
        }
        return (rz5) invokeL.objValue;
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
