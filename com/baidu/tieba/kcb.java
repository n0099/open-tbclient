package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.statistics.ApkStaticNetService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kcb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public List<mcb> h;
    public List<String> i;
    public Map<String, String> j;
    public Map<String, lcb> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947909695, "Lcom/baidu/tieba/kcb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947909695, "Lcom/baidu/tieba/kcb;");
                return;
            }
        }
        l = AppConfig.isDebug();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.equals("1", this.b)) {
                this.b = "0";
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (Map) invokeV.objValue;
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!TextUtils.equals("0", this.a)) {
                this.a = "1";
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public Map<String, lcb> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.k;
        }
        return (Map) invokeV.objValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.g;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.g = 20.0f;
            }
            return this.g;
        }
        return invokeV.floatValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float f = this.d;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.d = 1.0f;
            }
            return this.d;
        }
        return invokeV.floatValue;
    }

    public List<mcb> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            float f = this.e;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.e = 20.0f;
            }
            return this.e;
        }
        return invokeV.floatValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            float f = this.f;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.f = 7.0f;
            }
            return this.f;
        }
        return invokeV.floatValue;
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            float f = this.c;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.c = 100.0f;
            }
            return this.c;
        }
        return invokeV.floatValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return TextUtils.equals("1", a());
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return TextUtils.equals("1", d());
        }
        return invokeV.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a = "1";
            this.b = "0";
            this.c = 100.0f;
            this.d = 1.0f;
            this.e = 20.0f;
            this.f = 7.0f;
            this.g = 20.0f;
        }
    }

    public kcb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new HashMap();
    }

    public void A(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.c = f;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.b = str;
        }
    }

    public void r(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, map) == null) {
            this.j = map;
        }
    }

    public void s(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.i = list;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.a = str;
        }
    }

    public void u(Map<String, lcb> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, map) == null) {
            this.k = map;
        }
    }

    public void v(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f) == null) {
            this.g = f;
        }
    }

    public void w(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f) == null) {
            this.d = f;
        }
    }

    public void x(List<mcb> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            this.h = list;
        }
    }

    public void y(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f) == null) {
            this.e = f;
        }
    }

    public void z(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f) == null) {
            this.f = f;
        }
    }

    public void n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                if (l) {
                    Log.d("YaLogConfigData", "yalog config params is: " + jSONObject.toString());
                }
                String optString = jSONObject.optString("switch");
                this.a = optString;
                if (!TextUtils.equals("0", optString)) {
                    this.a = "1";
                }
                String optString2 = jSONObject.optString(DownloadStatisticConstants.UBC_VALUE_CLEAR);
                this.b = optString2;
                if (!TextUtils.equals("1", optString2)) {
                    this.b = "0";
                }
                float optDouble = (float) jSONObject.optDouble(ApkStaticNetService.STATIC_DOWNLOAD_SIZE);
                this.c = optDouble;
                if (optDouble <= 0.0f || Float.isNaN(optDouble)) {
                    this.c = 100.0f;
                }
                float optDouble2 = (float) jSONObject.optDouble("singlesize");
                this.d = optDouble2;
                if (optDouble2 <= 0.0f || Float.isNaN(optDouble2)) {
                    this.d = 1.0f;
                }
                float optDouble3 = (float) jSONObject.optDouble("spacesize");
                this.e = optDouble3;
                if (optDouble3 <= 0.0f || Float.isNaN(optDouble3)) {
                    this.e = 20.0f;
                }
                float optDouble4 = (float) jSONObject.optDouble("spacetimeout");
                this.f = optDouble4;
                if (optDouble4 <= 0.0f || Float.isNaN(optDouble4)) {
                    this.f = 7.0f;
                }
                float optDouble5 = (float) jSONObject.optDouble("idsize");
                this.g = optDouble5;
                if (optDouble5 <= 0.0f || Float.isNaN(optDouble5)) {
                    this.g = 20.0f;
                }
                this.i = new ArrayList();
                JSONObject optJSONObject2 = jSONObject.optJSONObject("set");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next);
                        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("data")) != null && optJSONObject.length() != 0) {
                            boolean z = !TextUtils.equals("0", optJSONObject.optString("switch"));
                            float optDouble6 = (float) optJSONObject.optDouble("size");
                            if (optDouble6 <= 0.0f || Float.isNaN(optDouble6)) {
                                optDouble6 = this.e;
                            }
                            float optDouble7 = (float) optJSONObject.optDouble("timeout");
                            if (optDouble7 <= 0.0f || Float.isNaN(optDouble7)) {
                                optDouble7 = this.f;
                            }
                            mcb mcbVar = new mcb(next, z, optDouble6, optDouble7);
                            if (mcbVar.e(z, this.e, this.f)) {
                                this.i.add(next);
                            } else {
                                this.h.add(mcbVar);
                            }
                        }
                    }
                }
            } else if (l) {
                Log.d("YaLogConfigData", "ConfigData is null");
            }
        }
    }

    public void o(JSONObject jSONObject, boolean z) {
        lcb lcbVar;
        long j;
        long j2;
        lcb lcbVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, jSONObject, z) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                if (l) {
                    Log.d("YaLogConfigData", "yalog id content is: " + jSONObject.toString());
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("set");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                        if (optJSONObject2 != null) {
                            long optLong = optJSONObject2.optLong("version");
                            if (this.j != null && this.j.containsKey(next)) {
                                j2 = Long.parseLong(this.j.get(next));
                            } else {
                                if (this.k != null && this.k.containsKey(next) && (lcbVar2 = this.k.get(next)) != null) {
                                    j2 = lcbVar2.c();
                                }
                                j2 = 0;
                            }
                            if (!z || j2 < optLong) {
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("data");
                                if (optJSONObject3 != null && optJSONObject3.length() != 0 && optJSONObject3.has("yalogswitch")) {
                                    boolean z2 = !TextUtils.equals(optJSONObject3.optString("yalogswitch"), "0");
                                    float optDouble = (float) optJSONObject3.optDouble("yalogsize");
                                    if (optDouble <= 0.0f || Float.isNaN(optDouble)) {
                                        optDouble = f();
                                    }
                                    lcb lcbVar3 = new lcb(next, optLong, z2, optDouble);
                                    if (lcbVar3.d(z2, f())) {
                                        Map<String, String> map = this.j;
                                        if (map != null) {
                                            map.put(next, String.valueOf(optLong));
                                        }
                                        Map<String, lcb> map2 = this.k;
                                        if (map2 != null && map2.containsKey(next)) {
                                            this.k.remove(next);
                                        }
                                    } else {
                                        Map<String, lcb> map3 = this.k;
                                        if (map3 != null) {
                                            map3.put(next, lcbVar3);
                                        }
                                        Map<String, String> map4 = this.j;
                                        if (map4 != null && map4.containsKey(next)) {
                                            this.j.remove(next);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("del");
                if (optJSONObject4 != null && optJSONObject4.length() > 0) {
                    Iterator<String> keys2 = optJSONObject4.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        long optLong2 = optJSONObject4.optLong(next2, 0L);
                        Map<String, String> map5 = this.j;
                        if (map5 != null && !TextUtils.isEmpty(map5.get(next2))) {
                            try {
                                j = Long.parseLong(this.j.get(next2));
                            } catch (NumberFormatException unused) {
                                j = 0;
                            }
                            if (!z || j < optLong2) {
                                this.j.remove(next2);
                            }
                        } else {
                            Map<String, lcb> map6 = this.k;
                            if (map6 != null && map6.containsKey(next2) && (lcbVar = this.k.get(next2)) != null) {
                                long c = lcbVar.c();
                                if (!z || c < optLong2) {
                                    this.k.remove(next2);
                                }
                            }
                        }
                    }
                }
            } else if (l) {
                Log.d("YaLogConfigData", "yalog id content is null");
            }
        }
    }
}
