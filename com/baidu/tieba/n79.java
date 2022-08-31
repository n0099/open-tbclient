package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.g79;
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
public final class n79 extends s79 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public n79() {
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

    public static void b(w69 w69Var, a79 a79Var, y69 y69Var, q69 q69Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{w69Var, a79Var, y69Var, q69Var, list, list2, list3}) == null) {
            w69Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            a79Var.a(p79.e().I());
            y69Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            q69Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.baidu.tieba.s79
    public final void a() {
        g79 g79Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g79Var = g79.a.a;
            if (g79Var.a().size() == 0) {
                q79.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(l79.l(p69.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            w69 w69Var = new w69();
            a79 a79Var = new a79();
            y69 y69Var = new y69();
            q69 q69Var = new q69();
            List<com.baidu.ubs.analytics.a.i> a2 = w69Var.a();
            List<com.baidu.ubs.analytics.a.n> d = a79Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = y69Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = q69Var.a();
            q79.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                q79.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            a79Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = p69.h().j();
            if (p69.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : p69.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        y79.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(l79.l(p69.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(l79.g(p69.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(l79.h(p69.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(i79.d() ? "1" : "0");
            aVar.k(l79.i(p69.h().getContext()));
            aVar.m(l79.j(p69.h().getContext()));
            aVar.n(l79.m());
            aVar.o(l79.n());
            aVar.p(l79.a());
            int f = l79.f(p69.h().getContext());
            aVar.l(f == 1 ? "WIFI" : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            p69.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = w79.a(bVar);
            String e2 = v79.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (b79.a(p69.h().getContext(), stringBuffer2.toString())) {
                    q79.b("上传成功，删除本地文件的       ");
                    v79.b(a + "ABJson.log");
                    b(w69Var, a79Var, y69Var, q69Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (b79.a(p69.h().getContext(), stringBuffer3.toString())) {
                    b(w69Var, a79Var, y69Var, q69Var, a3, a2, a4);
                    return;
                } else if (v79.d(a5, a, "ABJson.log")) {
                    b(w69Var, a79Var, y69Var, q69Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (b79.a(p69.h().getContext(), stringBuffer4.toString())) {
                b(w69Var, a79Var, y69Var, q69Var, a3, a2, a4);
            } else if (v79.d(a5, a, "ABJson.log")) {
                b(w69Var, a79Var, y69Var, q69Var, a3, a2, a4);
            }
        }
    }
}
