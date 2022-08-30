package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.i79;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.b;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p79 extends u79 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public p79() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(y69 y69Var, c79 c79Var, a79 a79Var, s69 s69Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{y69Var, c79Var, a79Var, s69Var, list, list2, list3}) == null) {
            y69Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            c79Var.a(r79.e().I());
            a79Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            s69Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.baidu.tieba.u79
    public final void a() {
        i79 i79Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i79Var = i79.a.a;
            if (i79Var.a().size() == 0) {
                s79.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(n79.l(r69.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            y69 y69Var = new y69();
            c79 c79Var = new c79();
            a79 a79Var = new a79();
            s69 s69Var = new s69();
            List<com.baidu.ubs.analytics.a.i> a2 = y69Var.a();
            List<com.baidu.ubs.analytics.a.n> d = c79Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = a79Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = s69Var.a();
            s79.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                s79.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            c79Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = r69.h().j();
            if (r69.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : r69.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        a89.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(n79.l(r69.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(n79.g(r69.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(n79.h(r69.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(k79.d() ? "1" : "0");
            aVar.k(n79.i(r69.h().getContext()));
            aVar.m(n79.j(r69.h().getContext()));
            aVar.n(n79.m());
            aVar.o(n79.n());
            aVar.p(n79.a());
            int f = n79.f(r69.h().getContext());
            aVar.l(f == 1 ? "WIFI" : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            r69.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = y79.a(bVar);
            String e2 = x79.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (d79.a(r69.h().getContext(), stringBuffer2.toString())) {
                    s79.b("上传成功，删除本地文件的       ");
                    x79.b(a + "ABJson.log");
                    b(y69Var, c79Var, a79Var, s69Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (d79.a(r69.h().getContext(), stringBuffer3.toString())) {
                    b(y69Var, c79Var, a79Var, s69Var, a3, a2, a4);
                    return;
                } else if (x79.d(a5, a, "ABJson.log")) {
                    b(y69Var, c79Var, a79Var, s69Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (d79.a(r69.h().getContext(), stringBuffer4.toString())) {
                b(y69Var, c79Var, a79Var, s69Var, a3, a2, a4);
            } else if (x79.d(a5, a, "ABJson.log")) {
                b(y69Var, c79Var, a79Var, s69Var, a3, a2, a4);
            }
        }
    }
}
