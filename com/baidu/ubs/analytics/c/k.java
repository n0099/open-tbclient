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
/* loaded from: classes3.dex */
public final class k extends com.baidu.ubs.analytics.d.d {
    private static String az;

    @Override // com.baidu.ubs.analytics.d.d
    protected final void a() {
        d dVar;
        String str;
        dVar = d.a.kai;
        if (dVar.cEz().size() == 0) {
            com.baidu.ubs.analytics.d.b.HO(" 线程轮询  app 应该是退出了");
        }
        if (az == null && Environment.getExternalStorageState().equals("mounted")) {
            az = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath()).append("/baidu/ab/").append(i.q(com.baidu.ubs.analytics.d.cEt().getContext())).append("/").toString();
        }
        com.baidu.ubs.analytics.a.j jVar = new com.baidu.ubs.analytics.a.j();
        p pVar = new p();
        com.baidu.ubs.analytics.a.m mVar = new com.baidu.ubs.analytics.a.m();
        com.baidu.ubs.analytics.a.b bVar = new com.baidu.ubs.analytics.a.b();
        List<com.baidu.ubs.analytics.a.i> cEu = jVar.cEu();
        List<n> cEu2 = pVar.cEu();
        List<com.baidu.ubs.analytics.a.l> cEu3 = mVar.cEu();
        List<com.baidu.ubs.analytics.a.a> cEu4 = bVar.cEu();
        com.baidu.ubs.analytics.d.b.HO("这次查询结果       session ：    " + cEu2.size() + "      点击事件   " + cEu4.size() + "    网络请求：  " + cEu.size() + "    页面记录     " + cEu3.size());
        if (cEu.size() == 0 && cEu3.size() == 0 && cEu4.size() == 0) {
            com.baidu.ubs.analytics.d.b.HO("这次记录 json 为空的，就不传了  ………………");
            if (cEu2.size() > 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < cEu2.size()) {
                        if (cEu2.get(i2).O() == null) {
                            pVar.HK(cEu2.get(i2).I());
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        } else {
            JSONArray jSONArray = new JSONArray();
            String l = com.baidu.ubs.analytics.d.cEt().l();
            if (com.baidu.ubs.analytics.d.cEt().cEs() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : com.baidu.ubs.analytics.d.cEt().cEs().entrySet()) {
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
            aVar.r(i.q(com.baidu.ubs.analytics.d.cEt().getContext()));
            aVar.b(l);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(i.k(com.baidu.ubs.analytics.d.cEt().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(i.l(com.baidu.ubs.analytics.d.cEt().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.u());
            aVar.j(f.cEF() ? "1" : "0");
            aVar.k(i.m(com.baidu.ubs.analytics.d.cEt().getContext()));
            aVar.m(i.n(com.baidu.ubs.analytics.d.cEt().getContext()));
            aVar.n(i.y());
            aVar.o(i.z());
            aVar.p(i.A());
            int j = i.j(com.baidu.ubs.analytics.d.cEt().getContext());
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
            com.baidu.ubs.analytics.d.cEt();
            aVar.setPhone("");
            bVar2.a(aVar);
            bVar2.c(cEu4);
            bVar2.e(cEu);
            bVar2.b(cEu2);
            bVar2.d(cEu3);
            String a = com.baidu.ubs.analytics.d.h.a(bVar2);
            String M = com.baidu.ubs.analytics.d.g.M(az, "ABJson.log");
            if (!M.equals("")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(M);
                stringBuffer.append(a);
                stringBuffer.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cEt().getContext(), stringBuffer.toString())) {
                    com.baidu.ubs.analytics.d.b.HO("上传成功，删除本地文件的       ");
                    com.baidu.ubs.analytics.d.g.HT(az + "ABJson.log");
                    a(jVar, pVar, mVar, bVar, cEu3, cEu, cEu4);
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                stringBuffer2.append(a);
                stringBuffer2.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cEt().getContext(), stringBuffer2.toString())) {
                    a(jVar, pVar, mVar, bVar, cEu3, cEu, cEu4);
                    return;
                } else if (com.baidu.ubs.analytics.d.g.b(a, az, "ABJson.log")) {
                    a(jVar, pVar, mVar, bVar, cEu3, cEu, cEu4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("[");
            stringBuffer3.append(a);
            stringBuffer3.append("]");
            if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cEt().getContext(), stringBuffer3.toString())) {
                a(jVar, pVar, mVar, bVar, cEu3, cEu, cEu4);
            } else if (com.baidu.ubs.analytics.d.g.b(a, az, "ABJson.log")) {
                a(jVar, pVar, mVar, bVar, cEu3, cEu, cEu4);
            }
        }
    }

    private static void a(com.baidu.ubs.analytics.a.j jVar, p pVar, com.baidu.ubs.analytics.a.m mVar, com.baidu.ubs.analytics.a.b bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        jVar.a(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
        pVar.HI(m.cEK().I());
        mVar.a(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
        bVar.a(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
    }
}
