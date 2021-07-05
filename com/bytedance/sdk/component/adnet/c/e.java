package com.bytedance.sdk.component.adnet.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.net.tnc.TNCConfigHandler;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.bytedance.sdk.component.net.utils.MultiProcessFileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f27816d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27817a;

    /* renamed from: b  reason: collision with root package name */
    public d f27818b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27819c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1398221956, "Lcom/bytedance/sdk/component/adnet/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1398221956, "Lcom/bytedance/sdk/component/adnet/c/e;");
                return;
            }
        }
        f27816d = new Object();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            if (!this.f27819c) {
                com.bytedance.sdk.component.adnet.d.d.b(TNCConfigHandler.TAG, "handleConfigChanged: no mainProc");
                return;
            }
            f.a().b();
            try {
                boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
                JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
                JSONObject jSONObject2 = null;
                if (com.bytedance.sdk.component.adnet.a.b() && z && optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject3 = ((JSONObject) optJSONArray.get(i2)).getJSONObject("param");
                        if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                            arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        jSONObject2 = new JSONObject();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObject4 = (JSONObject) it.next();
                            Iterator<String> keys = jSONObject4.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject2.put(next, jSONObject4.getString(next));
                            }
                        }
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(MultiProcessFileUtils.KEY_TNC_CONFIG);
                if (optJSONObject == null && jSONObject2 == null) {
                    com.bytedance.sdk.component.adnet.d.d.a(TNCConfigHandler.TAG, " tnc host_replace_map config is null");
                } else if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    optJSONObject.put("host_replace_map", jSONObject2);
                } else if (jSONObject2 != null) {
                    optJSONObject.put("host_replace_map", jSONObject2);
                }
                d b2 = b(optJSONObject);
                StringBuilder sb = new StringBuilder();
                sb.append("handleConfigChanged, newConfig: ");
                sb.append(b2 == null ? StringUtil.NULL_STRING : b2.toString());
                com.bytedance.sdk.component.adnet.d.d.b(TNCConfigHandler.TAG, sb.toString());
                if (b2 == null) {
                    synchronized (f27816d) {
                        this.f27817a.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putString("tnc_config_str", "").apply();
                        com.bytedance.sdk.component.adnet.d.e.a(this.f27817a, 1, "");
                    }
                    return;
                }
                this.f27818b = b2;
                String jSONObject5 = optJSONObject.toString();
                synchronized (f27816d) {
                    this.f27817a.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putString("tnc_config_str", jSONObject5).apply();
                    com.bytedance.sdk.component.adnet.d.e.a(this.f27817a, 1, jSONObject5);
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    this.f27818b = new d();
                    synchronized (f27816d) {
                        this.f27817a.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putString("tnc_config_str", "").apply();
                        com.bytedance.sdk.component.adnet.d.e.a(this.f27817a, 1, "");
                    }
                } catch (Throwable th2) {
                    synchronized (f27816d) {
                        this.f27817a.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putString("tnc_config_str", "").apply();
                        com.bytedance.sdk.component.adnet.d.e.a(this.f27817a, 1, "");
                        throw th2;
                    }
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                String a2 = com.bytedance.sdk.component.adnet.d.e.a(this.f27817a, 1);
                if (TextUtils.isEmpty(a2)) {
                    com.bytedance.sdk.component.adnet.d.d.b(TNCConfigHandler.TAG, "loadLocalConfigForOtherProcess, data empty");
                    return;
                }
                d b2 = b(new JSONObject(a2));
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfigForOtherProcess, config: ");
                sb.append(b2 == null ? StringUtil.NULL_STRING : b2.toString());
                com.bytedance.sdk.component.adnet.d.d.b(TNCConfigHandler.TAG, sb.toString());
                if (b2 != null) {
                    this.f27818b = b2;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.adnet.d.d.b(TNCConfigHandler.TAG, "loadLocalConfigForOtherProcess, except: " + th.getMessage());
            }
        }
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27818b : (d) invokeV.objValue;
    }

    private d b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            try {
                d dVar = new d();
                if (jSONObject.has("local_enable")) {
                    dVar.f27807a = jSONObject.getInt("local_enable") != 0;
                }
                if (jSONObject.has("probe_enable")) {
                    dVar.f27808b = jSONObject.getInt("probe_enable") != 0;
                }
                if (jSONObject.has("local_host_filter")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                    HashMap hashMap = new HashMap();
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String string = jSONArray.getString(i2);
                            if (!TextUtils.isEmpty(string)) {
                                hashMap.put(string, 0);
                            }
                        }
                    }
                    dVar.f27809c = hashMap;
                } else {
                    dVar.f27809c = null;
                }
                if (jSONObject.has("host_replace_map")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                    HashMap hashMap2 = new HashMap();
                    if (jSONObject2.length() > 0) {
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String string2 = jSONObject2.getString(next);
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                                hashMap2.put(next, string2);
                            }
                        }
                    }
                    dVar.f27810d = hashMap2;
                } else {
                    dVar.f27810d = null;
                }
                dVar.f27811e = jSONObject.optInt("req_to_cnt", dVar.f27811e);
                dVar.f27812f = jSONObject.optInt("req_to_api_cnt", dVar.f27812f);
                dVar.f27813g = jSONObject.optInt("req_to_ip_cnt", dVar.f27813g);
                dVar.f27814h = jSONObject.optInt("req_err_cnt", dVar.f27814h);
                dVar.f27815i = jSONObject.optInt("req_err_api_cnt", dVar.f27815i);
                dVar.j = jSONObject.optInt("req_err_ip_cnt", dVar.j);
                dVar.k = jSONObject.optInt("update_interval", dVar.k);
                dVar.l = jSONObject.optInt("update_random_range", dVar.l);
                dVar.m = jSONObject.optString("http_code_black", dVar.m);
                return dVar;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (d) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f27819c) {
            String string = this.f27817a.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.component.adnet.d.d.b(TNCConfigHandler.TAG, "loadLocalConfig: no existed");
                return;
            }
            try {
                d b2 = b(new JSONObject(string));
                if (b2 != null) {
                    this.f27818b = b2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(b2 == null ? StringUtil.NULL_STRING : b2.toString());
                com.bytedance.sdk.component.adnet.d.d.b(TNCConfigHandler.TAG, sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.component.adnet.d.d.b(TNCConfigHandler.TAG, "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }
}
