package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.jb9;
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
public final class qb9 extends vb9 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public qb9() {
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

    public static void b(za9 za9Var, db9 db9Var, bb9 bb9Var, ta9 ta9Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{za9Var, db9Var, bb9Var, ta9Var, list, list2, list3}) == null) {
            za9Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            db9Var.a(sb9.e().I());
            bb9Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            ta9Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.baidu.tieba.vb9
    public final void a() {
        jb9 jb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jb9Var = jb9.a.a;
            if (jb9Var.a().size() == 0) {
                tb9.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(ob9.l(sa9.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            za9 za9Var = new za9();
            db9 db9Var = new db9();
            bb9 bb9Var = new bb9();
            ta9 ta9Var = new ta9();
            List<com.baidu.ubs.analytics.a.i> a2 = za9Var.a();
            List<com.baidu.ubs.analytics.a.n> d = db9Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = bb9Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = ta9Var.a();
            tb9.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                tb9.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            db9Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = sa9.h().j();
            if (sa9.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : sa9.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        bc9.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(ob9.l(sa9.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(ob9.g(sa9.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(ob9.h(sa9.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(lb9.d() ? "1" : "0");
            aVar.k(ob9.i(sa9.h().getContext()));
            aVar.m(ob9.j(sa9.h().getContext()));
            aVar.n(ob9.m());
            aVar.o(ob9.n());
            aVar.p(ob9.a());
            int f = ob9.f(sa9.h().getContext());
            aVar.l(f == 1 ? "WIFI" : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            sa9.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = zb9.a(bVar);
            String e2 = yb9.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (eb9.a(sa9.h().getContext(), stringBuffer2.toString())) {
                    tb9.b("上传成功，删除本地文件的       ");
                    yb9.b(a + "ABJson.log");
                    b(za9Var, db9Var, bb9Var, ta9Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (eb9.a(sa9.h().getContext(), stringBuffer3.toString())) {
                    b(za9Var, db9Var, bb9Var, ta9Var, a3, a2, a4);
                    return;
                } else if (yb9.d(a5, a, "ABJson.log")) {
                    b(za9Var, db9Var, bb9Var, ta9Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (eb9.a(sa9.h().getContext(), stringBuffer4.toString())) {
                b(za9Var, db9Var, bb9Var, ta9Var, a3, a2, a4);
            } else if (yb9.d(a5, a, "ABJson.log")) {
                b(za9Var, db9Var, bb9Var, ta9Var, a3, a2, a4);
            }
        }
    }
}
