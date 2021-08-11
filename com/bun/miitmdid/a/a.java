package com.bun.miitmdid.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.a.a.c;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes9.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public C1865a f63560a;

    /* renamed from: com.bun.miitmdid.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1865a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.bun.miitmdid.a.a.a f63561a;

        /* renamed from: b  reason: collision with root package name */
        public com.bun.miitmdid.a.a.b f63562b;

        /* renamed from: c  reason: collision with root package name */
        public c f63563c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f63564d;

        public C1865a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63564d = aVar;
        }
    }

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
                return;
            }
        }
        this.f63560a = new C1865a(this);
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String a2 = com.bun.miitmdid.utils.c.a(context, "supplierconfig.json");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            a aVar = new a();
            JSONTokener jSONTokener = new JSONTokener(a2);
            boolean z = false;
            try {
                jSONObject = (JSONObject) jSONTokener.nextValue();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("supplier")) == null) {
                return null;
            }
            boolean a3 = a(aVar, optJSONObject);
            boolean b2 = b(aVar, optJSONObject);
            boolean c2 = c(aVar, optJSONObject);
            if (a3 && b2 && c2) {
                z = true;
            }
            if (z) {
                return aVar;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static boolean a(a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aVar, jSONObject)) == null) {
            if (jSONObject == null || aVar == null) {
                return false;
            }
            if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_HUAWEI) != null) {
                aVar.f63560a.f63561a = new com.bun.miitmdid.a.a.a();
            }
            return aVar.f63560a.f63561a != null;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, aVar, jSONObject)) == null) {
            if (jSONObject == null || aVar == null) {
                return false;
            }
            if (jSONObject.optJSONObject(RomUtils.MANUFACTURER_XIAOMI) != null) {
                aVar.f63560a.f63563c = new c();
            }
            return aVar.f63560a.f63563c != null;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, jSONObject)) == null) {
            if (jSONObject == null || aVar == null) {
                return false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(RomUtils.MANUFACTURER_VIVO);
            com.bun.miitmdid.a.a.b bVar = new com.bun.miitmdid.a.a.b();
            if (optJSONObject != null) {
                bVar.f63565a = optJSONObject.optString("appid");
                aVar.f63560a.f63562b = bVar;
            }
            return aVar.f63560a.f63562b != null;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.bun.miitmdid.a.b
    public String a() {
        InterceptResult invokeV;
        com.bun.miitmdid.a.a.b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            C1865a c1865a = this.f63560a;
            return (c1865a == null || (bVar = c1865a.f63562b) == null || (str = bVar.f63565a) == null) ? "" : str;
        }
        return (String) invokeV.objValue;
    }
}
