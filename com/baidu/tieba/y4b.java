package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.r4b;
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
/* loaded from: classes8.dex */
public final class y4b extends d5b {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public y4b() {
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

    public static void b(h4b h4bVar, l4b l4bVar, j4b j4bVar, b4b b4bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{h4bVar, l4bVar, j4bVar, b4bVar, list, list2, list3}) == null) {
            int i3 = 0;
            if (list2.size() != 0) {
                i = list2.get(list2.size() - 1).getId();
            } else {
                i = 0;
            }
            h4bVar.b(i);
            l4bVar.a(a5b.e().I());
            if (list.size() != 0) {
                i2 = list.get(list.size() - 1).getId();
            } else {
                i2 = 0;
            }
            j4bVar.b(i2);
            if (list3.size() != 0) {
                i3 = list3.get(list3.size() - 1).getId();
            }
            b4bVar.b(i3);
        }
    }

    @Override // com.baidu.tieba.d5b
    public final void a() {
        r4b r4bVar;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r4bVar = r4b.a.a;
            if (r4bVar.a().size() == 0) {
                b5b.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(w4b.l(a4b.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            h4b h4bVar = new h4b();
            l4b l4bVar = new l4b();
            j4b j4bVar = new j4b();
            b4b b4bVar = new b4b();
            List<com.baidu.ubs.analytics.a.i> a2 = h4bVar.a();
            List<com.baidu.ubs.analytics.a.n> d = l4bVar.d();
            List<com.baidu.ubs.analytics.a.l> a3 = j4bVar.a();
            List<com.baidu.ubs.analytics.a.a> a4 = b4bVar.a();
            b5b.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                b5b.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            l4bVar.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = a4b.h().j();
            if (a4b.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : a4b.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        j5b.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(w4b.l(a4b.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(w4b.g(a4b.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(w4b.h(a4b.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            if (t4b.d()) {
                str = "1";
            } else {
                str = "0";
            }
            aVar.j(str);
            aVar.k(w4b.i(a4b.h().getContext()));
            aVar.m(w4b.j(a4b.h().getContext()));
            aVar.n(w4b.m());
            aVar.o(w4b.n());
            aVar.p(w4b.a());
            int f = w4b.f(a4b.h().getContext());
            if (f == 1) {
                str2 = "WIFI";
            } else if (f == 2) {
                str2 = "2G";
            } else if (f == 3) {
                str2 = "3G";
            } else if (f == 4) {
                str2 = "4G";
            } else if (f == 5) {
                str2 = "unKnow";
            } else {
                str2 = "noNet";
            }
            aVar.l(str2);
            a4b.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = h5b.a(bVar);
            String e2 = g5b.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (m4b.a(a4b.h().getContext(), stringBuffer2.toString())) {
                    b5b.b("上传成功，删除本地文件的       ");
                    g5b.b(a + "ABJson.log");
                    b(h4bVar, l4bVar, j4bVar, b4bVar, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (m4b.a(a4b.h().getContext(), stringBuffer3.toString())) {
                    b(h4bVar, l4bVar, j4bVar, b4bVar, a3, a2, a4);
                    return;
                } else if (g5b.d(a5, a, "ABJson.log")) {
                    b(h4bVar, l4bVar, j4bVar, b4bVar, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (m4b.a(a4b.h().getContext(), stringBuffer4.toString())) {
                b(h4bVar, l4bVar, j4bVar, b4bVar, a3, a2, a4);
            } else if (g5b.d(a5, a, "ABJson.log")) {
                b(h4bVar, l4bVar, j4bVar, b4bVar, a3, a2, a4);
            }
        }
    }
}
