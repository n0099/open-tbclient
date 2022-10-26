package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vo0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public String b;
    public final String c;
    public final String d;
    public final boolean e;

    public vo0(JSONObject jSONObject, boolean z) {
        String str;
        String str2;
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
        if (z) {
            str = EmotionResourceInfo.JSON_KEY_PKG_NAME;
        } else {
            str = "apk_name";
        }
        this.a = jSONObject.optString(str);
        if (z) {
            str2 = "key";
        } else {
            str2 = "download_key";
        }
        this.d = jSONObject.optString(str2);
        this.b = jSONObject.optString("deferred_cmd");
        this.c = jSONObject.optString("download_url");
        jSONObject.optString("source", "apk_yuansheng");
        this.e = a();
    }

    public static vo0 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new vo0(jSONObject, false);
        }
        return (vo0) invokeL.objValue;
    }

    public static vo0 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new vo0(jSONObject, true);
        }
        return (vo0) invokeL.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
