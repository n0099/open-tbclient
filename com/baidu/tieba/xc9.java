package com.baidu.tieba;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.qc9;
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
/* loaded from: classes6.dex */
public final class xc9 extends cd9 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public xc9() {
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

    public static void b(gc9 gc9Var, kc9 kc9Var, ic9 ic9Var, ac9 ac9Var, List list, List list2, List list3) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gc9Var, kc9Var, ic9Var, ac9Var, list, list2, list3}) == null) {
            int i3 = 0;
            if (list2.size() != 0) {
                i = ((com.baidu.ubs.analytics.a.i) list2.get(list2.size() - 1)).getId();
            } else {
                i = 0;
            }
            gc9Var.b(i);
            kc9Var.a(zc9.e().I());
            if (list.size() != 0) {
                i2 = ((com.baidu.ubs.analytics.a.l) list.get(list.size() - 1)).getId();
            } else {
                i2 = 0;
            }
            ic9Var.b(i2);
            if (list3.size() != 0) {
                i3 = ((com.baidu.ubs.analytics.a.a) list3.get(list3.size() - 1)).getId();
            }
            ac9Var.b(i3);
        }
    }

    @Override // com.baidu.tieba.cd9
    public final void a() {
        qc9 qc9Var;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            qc9Var = qc9.a.a;
            if (qc9Var.a().size() == 0) {
                ad9.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(vc9.l(zb9.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            gc9 gc9Var = new gc9();
            kc9 kc9Var = new kc9();
            ic9 ic9Var = new ic9();
            ac9 ac9Var = new ac9();
            List a2 = gc9Var.a();
            List d = kc9Var.d();
            List a3 = ic9Var.a();
            List a4 = ac9Var.a();
            ad9.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                ad9.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (((com.baidu.ubs.analytics.a.n) d.get(i)).O() == null) {
                            kc9Var.c(((com.baidu.ubs.analytics.a.n) d.get(i)).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = zb9.h().j();
            if (zb9.h().k() != null) {
                for (Map.Entry entry : zb9.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", ((com.baidu.ubs.analytics.a.g) entry.getValue()).L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        id9.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(vc9.l(zb9.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(vc9.g(zb9.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(vc9.h(zb9.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            if (sc9.d()) {
                str = "1";
            } else {
                str = "0";
            }
            aVar.j(str);
            aVar.k(vc9.i(zb9.h().getContext()));
            aVar.m(vc9.j(zb9.h().getContext()));
            aVar.n(vc9.m());
            aVar.o(vc9.n());
            aVar.p(vc9.a());
            int f = vc9.f(zb9.h().getContext());
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
            zb9.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = gd9.a(bVar);
            String e2 = fd9.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (lc9.a(zb9.h().getContext(), stringBuffer2.toString())) {
                    ad9.b("上传成功，删除本地文件的       ");
                    fd9.b(a + "ABJson.log");
                    b(gc9Var, kc9Var, ic9Var, ac9Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (lc9.a(zb9.h().getContext(), stringBuffer3.toString())) {
                    b(gc9Var, kc9Var, ic9Var, ac9Var, a3, a2, a4);
                    return;
                } else if (fd9.d(a5, a, "ABJson.log")) {
                    b(gc9Var, kc9Var, ic9Var, ac9Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (lc9.a(zb9.h().getContext(), stringBuffer4.toString())) {
                b(gc9Var, kc9Var, ic9Var, ac9Var, a3, a2, a4);
            } else if (fd9.d(a5, a, "ABJson.log")) {
                b(gc9Var, kc9Var, ic9Var, ac9Var, a3, a2, a4);
            }
        }
    }
}
