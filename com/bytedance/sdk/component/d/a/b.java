package com.bytedance.sdk.component.d.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64857a;

    /* renamed from: b  reason: collision with root package name */
    public int f64858b;

    /* renamed from: c  reason: collision with root package name */
    public String f64859c;

    public b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64857a = e.f64874a;
        this.f64858b = 0;
        this.f64859c = "";
        this.f64858b = i2;
        this.f64859c = str;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cupCount", this.f64857a);
                jSONObject.put("sdkThreadCount", this.f64858b);
                jSONObject.put("sdkThreadNames", this.f64859c);
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
