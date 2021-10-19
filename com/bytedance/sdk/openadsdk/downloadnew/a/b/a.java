package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompatJellybean;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public m f67971a;

    /* renamed from: b  reason: collision with root package name */
    public String f67972b;

    /* renamed from: c  reason: collision with root package name */
    public String f67973c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67974d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    public a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f67973c = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        String str2;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            m mVar = null;
            if (jSONObject == null) {
                return null;
            }
            try {
                str = jSONObject.optString("tag", null);
            } catch (Exception unused) {
                str = null;
                str2 = null;
            }
            try {
                str2 = jSONObject.optString(NotificationCompatJellybean.KEY_LABEL, null);
                try {
                    jSONObject2 = jSONObject.optJSONObject("extra");
                    try {
                        mVar = com.bytedance.sdk.openadsdk.core.b.a(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    jSONObject2 = null;
                }
            } catch (Exception unused4) {
                str2 = null;
                jSONObject2 = str2;
                return a().a(str).b(str2).b(jSONObject2).a(mVar);
            }
            return a().a(str).b(str2).b(jSONObject2).a(mVar);
        }
        return (a) invokeL.objValue;
    }

    public a b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            this.f67974d = jSONObject;
            return this;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tag", this.f67972b);
                jSONObject.put(NotificationCompatJellybean.KEY_LABEL, this.f67973c);
                if (this.f67974d != null) {
                    jSONObject.put("extra", this.f67974d);
                }
                if (this.f67971a != null) {
                    jSONObject.put("material_meta", this.f67971a.aP());
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            this.f67971a = mVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f67972b = str;
            return this;
        }
        return (a) invokeL.objValue;
    }
}
