package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class xub {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;
    public yub a;
    public JSONObject b;
    public JSONObject c;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final xub a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-275740826, "Lcom/baidu/tieba/xub$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-275740826, "Lcom/baidu/tieba/xub$b;");
                    return;
                }
            }
            a = new xub(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314276, "Lcom/baidu/tieba/xub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314276, "Lcom/baidu/tieba/xub;");
                return;
            }
        }
        d = AppConfig.isDebug();
        e = AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator + "yalog/";
    }

    public xub() {
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
        i();
    }

    public static xub c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (xub) invokeV.objValue;
    }

    public Map<String, zub> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.e();
        }
        return (Map) invokeV.objValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.f();
        }
        return invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.g();
        }
        return invokeV.floatValue;
    }

    public List<avb> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.h();
        }
        return (List) invokeV.objValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.i();
        }
        return invokeV.floatValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.j();
        }
        return invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.k();
        }
        return invokeV.floatValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.a == null) {
                this.a = new yub();
            }
            j();
            k();
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.l();
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.m();
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ xub(a aVar) {
        this();
    }

    public final void j() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!new File(e).exists()) {
                if (d) {
                    Log.d("YaLogConfigManager", "dir not exists.");
                    return;
                }
                return;
            }
            File file = new File(e, "yalog_cloud.txt");
            if (!file.exists()) {
                if (d) {
                    Log.d("YaLogConfigManager", "yalog_cloud.txt not exists, use default value.");
                }
                this.a.p();
                return;
            }
            String a2 = gvb.a(file);
            if (d) {
                Log.d("YaLogConfigManager", "read from local: " + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                this.a.p();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(a2);
                this.b = jSONObject;
                this.a.t(jSONObject.optString(TbConfig.SW_APID));
                this.a.q(this.b.optString("cl"));
                this.a.A((float) this.b.optDouble("tosize"));
                this.a.w((float) this.b.optDouble("sisize"));
                this.a.y((float) this.b.optDouble("spsize"));
                this.a.z((float) this.b.optDouble("sptime"));
                this.a.v((float) this.b.optDouble("idsize"));
                if (this.b.has("spdelist")) {
                    List<String> asList = Arrays.asList(this.b.optString("spdelist"));
                    if (asList.size() > 0) {
                        this.a.s(asList);
                    }
                }
                if (this.b.has("splist")) {
                    JSONObject optJSONObject = this.b.optJSONObject("splist");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                            if (optJSONObject2 != null) {
                                if (!TextUtils.equals("0", optJSONObject2.optString(TbConfig.SW_APID))) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                arrayList.add(new avb(next, z, (float) optJSONObject2.optDouble("size"), (float) optJSONObject2.optDouble("time")));
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.a.x(arrayList);
                    }
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void k() {
        boolean z;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!new File(e).exists()) {
                if (d) {
                    Log.d("YaLogConfigManager", "dir not exists.");
                    return;
                }
                return;
            }
            File file = new File(e, "yalog_id_cloud.txt");
            if (!file.exists()) {
                if (d) {
                    Log.d("YaLogConfigManager", "yalog_id_cloud.txt not exists.");
                    return;
                }
                return;
            }
            String a2 = gvb.a(file);
            if (d) {
                Log.d("YaLogConfigManager", "read from local: " + a2);
            }
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    this.c = jSONObject;
                    if (jSONObject.has("iddemap") && (optJSONObject = this.c.optJSONObject("iddemap")) != null && optJSONObject.length() > 0) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, optJSONObject.optString(next));
                        }
                        if (hashMap.size() > 0) {
                            this.a.r(hashMap);
                        }
                    }
                    if (this.c.has("idlist")) {
                        JSONObject optJSONObject2 = this.c.optJSONObject("idlist");
                        HashMap hashMap2 = new HashMap();
                        if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                            Iterator<String> keys2 = optJSONObject2.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                                if (optJSONObject3 != null) {
                                    String optString = optJSONObject3.optString(TbConfig.SW_APID);
                                    long optLong = optJSONObject3.optLong("v");
                                    if (!TextUtils.equals("0", optString)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    hashMap2.put(next2, new zub(next2, optLong, z, (float) optJSONObject3.optDouble("size")));
                                }
                            }
                        }
                        if (hashMap2.size() > 0) {
                            this.a.u(hashMap2);
                        }
                    }
                } catch (JSONException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                File file = new File(e);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(e, str);
                String str3 = e;
                File file3 = new File(str3, ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str);
                file3.createNewFile();
                gvb.b(str2, file3);
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                if (d) {
                    Log.d("YaLogConfigManager", "save to local: " + str2);
                }
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) && jSONObject != null && jSONObject.length() != 0) {
            if (d) {
                Log.d("YaLogConfigManager", "update Config: " + jSONObject.toString());
            }
            if (this.a == null) {
                this.a = new yub();
            }
            this.a.n(jSONObject);
            p(this.a);
        }
    }

    public final void p(yub yubVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, yubVar) != null) || yubVar == null) {
            return;
        }
        if (this.b == null) {
            this.b = new JSONObject();
        }
        try {
            this.b.put(TbConfig.SW_APID, yubVar.d());
            this.b.put("cl", yubVar.a());
            this.b.put("tosize", String.valueOf(yubVar.k()));
            this.b.put("sisize", String.valueOf(yubVar.g()));
            this.b.put("spsize", String.valueOf(yubVar.i()));
            this.b.put("sptime", String.valueOf(yubVar.j()));
            this.b.put("idsize", String.valueOf(yubVar.f()));
            List<String> c = yubVar.c();
            if (c != null && c.size() > 0) {
                this.b.put("spdelist", TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, c));
            }
            List<avb> h = yubVar.h();
            if (h != null && h.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (avb avbVar : h) {
                    String b2 = avbVar.b();
                    if (!TextUtils.isEmpty(b2)) {
                        JSONObject jSONObject2 = new JSONObject();
                        if (avbVar.c()) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        jSONObject2.put(TbConfig.SW_APID, str);
                        jSONObject2.put("size", avbVar.a());
                        jSONObject2.put("time", avbVar.d());
                        jSONObject.put(b2, jSONObject2);
                    }
                }
                if (jSONObject.length() > 0) {
                    this.b.put("splist", jSONObject);
                }
            }
            n("yalog_cloud.txt", this.b.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void r(yub yubVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, yubVar) != null) || yubVar == null) {
            return;
        }
        if (this.c == null) {
            this.c = new JSONObject();
        }
        try {
            Map<String, String> b2 = yubVar.b();
            if (b2 != null && b2.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (String str2 : b2.keySet()) {
                    jSONObject.put(str2, b2.get(str2));
                }
                this.c.put("iddemap", jSONObject);
            }
            Map<String, zub> e2 = yubVar.e();
            if (e2 != null && e2.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (String str3 : e2.keySet()) {
                    zub zubVar = e2.get(str3);
                    if (zubVar != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        if (zubVar.b()) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        jSONObject3.put(TbConfig.SW_APID, str);
                        jSONObject3.put("size", zubVar.a());
                        jSONObject3.put("v", zubVar.c());
                        jSONObject2.put(str3, jSONObject3);
                    }
                }
                if (jSONObject2.length() > 0) {
                    this.c.put("idlist", jSONObject2);
                }
            }
            n("yalog_id_cloud.txt", this.c.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void q(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048591, this, jSONObject, z) == null) && jSONObject != null && jSONObject.length() != 0) {
            if (d) {
                Log.d("YaLogConfigManager", "update Config: " + jSONObject.toString());
            }
            if (this.a == null) {
                this.a = new yub();
            }
            this.a.o(jSONObject, z);
            r(this.a);
        }
    }
}
