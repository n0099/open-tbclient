package com.bytedance.sdk.openadsdk.core.dynamic.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29853a;

    /* renamed from: b  reason: collision with root package name */
    public float f29854b;

    /* renamed from: c  reason: collision with root package name */
    public float f29855c;

    /* renamed from: d  reason: collision with root package name */
    public float f29856d;

    /* renamed from: e  reason: collision with root package name */
    public float f29857e;

    /* renamed from: f  reason: collision with root package name */
    public float f29858f;

    /* renamed from: g  reason: collision with root package name */
    public c f29859g;

    /* renamed from: h  reason: collision with root package name */
    public List<f> f29860h;

    public f() {
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

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f29853a = str;
        }
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29855c : invokeV.floatValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29856d : invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29857e : invokeV.floatValue;
    }

    public void e(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            this.f29858f = f2;
        }
    }

    public List<f> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f29860h : (List) invokeV.objValue;
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29854b : invokeV.floatValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.f29855c = f2;
        }
    }

    public void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.f29856d = f2;
        }
    }

    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.f29857e = f2;
        }
    }

    public c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f29859g : (c) invokeV.objValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f29854b = f2;
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f29859g = cVar;
        }
    }

    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            if (this.f29860h == null) {
                this.f29860h = new ArrayList();
            }
            this.f29860h.add(fVar);
        }
    }

    public static void a(JSONObject jSONObject, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, jSONObject, fVar) == null) || jSONObject == null || fVar == null) {
            return;
        }
        fVar.a(jSONObject.optString("id", PrefetchEvent.EVENT_DATA_ROOT_PATH));
        fVar.a((float) jSONObject.optDouble("x", 0.0d));
        fVar.b((float) jSONObject.optDouble("y", 0.0d));
        fVar.c((float) jSONObject.optDouble("width", 0.0d));
        fVar.d((float) jSONObject.optDouble("height", 0.0d));
        fVar.e((float) jSONObject.optDouble("remainWidth", 0.0d));
        c cVar = new c();
        c.a(jSONObject.optJSONObject("brick"), cVar);
        fVar.a(cVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            Object opt = optJSONArray.opt(i2);
            if (opt != null && !StringUtil.NULL_STRING.equals(opt.toString()) && (opt instanceof JSONArray)) {
                int i3 = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (i3 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                        f fVar2 = new f();
                        a(optJSONObject, fVar2);
                        fVar.a(fVar2);
                        i3++;
                    }
                }
            }
        }
    }
}
