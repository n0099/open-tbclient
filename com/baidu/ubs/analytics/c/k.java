package com.baidu.ubs.analytics.c;

import android.os.Build;
import android.os.Environment;
import com.baidu.ubs.analytics.a.n;
import com.baidu.ubs.analytics.a.p;
import com.baidu.ubs.analytics.b;
import com.baidu.ubs.analytics.c.d;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class k extends com.baidu.ubs.analytics.d.d {
    private static String az;

    @Override // com.baidu.ubs.analytics.d.d
    protected final void a() {
        d dVar;
        String str;
        dVar = d.a.kVt;
        if (dVar.cWf().size() == 0) {
            com.baidu.ubs.analytics.d.b.Lf(" 线程轮询  app 应该是退出了");
        }
        if (az == null && Environment.getExternalStorageState().equals("mounted")) {
            az = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath()).append("/baidu/ab/").append(i.q(com.baidu.ubs.analytics.d.cVY().getContext())).append("/").toString();
        }
        com.baidu.ubs.analytics.a.j jVar = new com.baidu.ubs.analytics.a.j();
        p pVar = new p();
        com.baidu.ubs.analytics.a.m mVar = new com.baidu.ubs.analytics.a.m();
        com.baidu.ubs.analytics.a.b bVar = new com.baidu.ubs.analytics.a.b();
        List<com.baidu.ubs.analytics.a.i> cVZ = jVar.cVZ();
        List<n> cVZ2 = pVar.cVZ();
        List<com.baidu.ubs.analytics.a.l> cVZ3 = mVar.cVZ();
        List<com.baidu.ubs.analytics.a.a> cVZ4 = bVar.cVZ();
        com.baidu.ubs.analytics.d.b.Lf("这次查询结果       session ：    " + cVZ2.size() + "      点击事件   " + cVZ4.size() + "    网络请求：  " + cVZ.size() + "    页面记录     " + cVZ3.size());
        if (cVZ.size() == 0 && cVZ3.size() == 0 && cVZ4.size() == 0) {
            com.baidu.ubs.analytics.d.b.Lf("这次记录 json 为空的，就不传了  ………………");
            if (cVZ2.size() > 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < cVZ2.size()) {
                        if (cVZ2.get(i2).O() == null) {
                            pVar.Lb(cVZ2.get(i2).I());
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        } else {
            JSONArray jSONArray = new JSONArray();
            String l = com.baidu.ubs.analytics.d.cVY().l();
            if (com.baidu.ubs.analytics.d.cVY().m() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : com.baidu.ubs.analytics.d.cVY().m().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.baidu.ubs.analytics.d.j.a(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar2 = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(i.q(com.baidu.ubs.analytics.d.cVY().getContext()));
            aVar.b(l);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(i.k(com.baidu.ubs.analytics.d.cVY().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(i.l(com.baidu.ubs.analytics.d.cVY().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.u());
            aVar.j(f.cWl() ? "1" : "0");
            aVar.k(i.m(com.baidu.ubs.analytics.d.cVY().getContext()));
            aVar.m(i.n(com.baidu.ubs.analytics.d.cVY().getContext()));
            aVar.n(i.y());
            aVar.o(i.z());
            aVar.p(i.A());
            int j = i.j(com.baidu.ubs.analytics.d.cVY().getContext());
            if (j == 1) {
                str = "WIFI";
            } else if (j == 2) {
                str = "2G";
            } else if (j == 3) {
                str = "3G";
            } else if (j == 4) {
                str = "4G";
            } else if (j == 5) {
                str = "unKnow";
            } else {
                str = "noNet";
            }
            aVar.l(str);
            com.baidu.ubs.analytics.d.cVY();
            aVar.setPhone("");
            bVar2.a(aVar);
            bVar2.c(cVZ4);
            bVar2.e(cVZ);
            bVar2.b(cVZ2);
            bVar2.d(cVZ3);
            String a = com.baidu.ubs.analytics.d.h.a(bVar2);
            String K = com.baidu.ubs.analytics.d.g.K(az, "ABJson.log");
            if (!K.equals("")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(K);
                stringBuffer.append(a);
                stringBuffer.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cVY().getContext(), stringBuffer.toString())) {
                    com.baidu.ubs.analytics.d.b.Lf("上传成功，删除本地文件的       ");
                    com.baidu.ubs.analytics.d.g.Lk(az + "ABJson.log");
                    a(jVar, pVar, mVar, bVar, cVZ3, cVZ, cVZ4);
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                stringBuffer2.append(a);
                stringBuffer2.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cVY().getContext(), stringBuffer2.toString())) {
                    a(jVar, pVar, mVar, bVar, cVZ3, cVZ, cVZ4);
                    return;
                } else if (com.baidu.ubs.analytics.d.g.b(a, az, "ABJson.log")) {
                    a(jVar, pVar, mVar, bVar, cVZ3, cVZ, cVZ4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("[");
            stringBuffer3.append(a);
            stringBuffer3.append("]");
            if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cVY().getContext(), stringBuffer3.toString())) {
                a(jVar, pVar, mVar, bVar, cVZ3, cVZ, cVZ4);
            } else if (com.baidu.ubs.analytics.d.g.b(a, az, "ABJson.log")) {
                a(jVar, pVar, mVar, bVar, cVZ3, cVZ, cVZ4);
            }
        }
    }

    private static void a(com.baidu.ubs.analytics.a.j jVar, p pVar, com.baidu.ubs.analytics.a.m mVar, com.baidu.ubs.analytics.a.b bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        jVar.a(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
        pVar.KZ(m.cWq().I());
        mVar.a(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
        bVar.a(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
    }
}
