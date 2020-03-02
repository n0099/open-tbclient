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
/* loaded from: classes8.dex */
public final class k extends com.baidu.ubs.analytics.d.d {
    private static String az;

    @Override // com.baidu.ubs.analytics.d.d
    protected final void a() {
        d dVar;
        String str;
        dVar = d.a.kWb;
        if (dVar.cXv().size() == 0) {
            com.baidu.ubs.analytics.d.b.Ls(" 线程轮询  app 应该是退出了");
        }
        if (az == null && Environment.getExternalStorageState().equals("mounted")) {
            az = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath()).append("/baidu/ab/").append(i.q(com.baidu.ubs.analytics.d.cXo().getContext())).append("/").toString();
        }
        com.baidu.ubs.analytics.a.j jVar = new com.baidu.ubs.analytics.a.j();
        p pVar = new p();
        com.baidu.ubs.analytics.a.m mVar = new com.baidu.ubs.analytics.a.m();
        com.baidu.ubs.analytics.a.b bVar = new com.baidu.ubs.analytics.a.b();
        List<com.baidu.ubs.analytics.a.i> cXp = jVar.cXp();
        List<n> cXp2 = pVar.cXp();
        List<com.baidu.ubs.analytics.a.l> cXp3 = mVar.cXp();
        List<com.baidu.ubs.analytics.a.a> cXp4 = bVar.cXp();
        com.baidu.ubs.analytics.d.b.Ls("这次查询结果       session ：    " + cXp2.size() + "      点击事件   " + cXp4.size() + "    网络请求：  " + cXp.size() + "    页面记录     " + cXp3.size());
        if (cXp.size() == 0 && cXp3.size() == 0 && cXp4.size() == 0) {
            com.baidu.ubs.analytics.d.b.Ls("这次记录 json 为空的，就不传了  ………………");
            if (cXp2.size() > 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < cXp2.size()) {
                        if (cXp2.get(i2).O() == null) {
                            pVar.Lo(cXp2.get(i2).I());
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        } else {
            JSONArray jSONArray = new JSONArray();
            String l = com.baidu.ubs.analytics.d.cXo().l();
            if (com.baidu.ubs.analytics.d.cXo().m() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : com.baidu.ubs.analytics.d.cXo().m().entrySet()) {
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
            aVar.r(i.q(com.baidu.ubs.analytics.d.cXo().getContext()));
            aVar.b(l);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(i.k(com.baidu.ubs.analytics.d.cXo().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(i.l(com.baidu.ubs.analytics.d.cXo().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.u());
            aVar.j(f.cXB() ? "1" : "0");
            aVar.k(i.m(com.baidu.ubs.analytics.d.cXo().getContext()));
            aVar.m(i.n(com.baidu.ubs.analytics.d.cXo().getContext()));
            aVar.n(i.y());
            aVar.o(i.z());
            aVar.p(i.A());
            int j = i.j(com.baidu.ubs.analytics.d.cXo().getContext());
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
            com.baidu.ubs.analytics.d.cXo();
            aVar.setPhone("");
            bVar2.a(aVar);
            bVar2.c(cXp4);
            bVar2.e(cXp);
            bVar2.b(cXp2);
            bVar2.d(cXp3);
            String a = com.baidu.ubs.analytics.d.h.a(bVar2);
            String P = com.baidu.ubs.analytics.d.g.P(az, "ABJson.log");
            if (!P.equals("")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(P);
                stringBuffer.append(a);
                stringBuffer.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cXo().getContext(), stringBuffer.toString())) {
                    com.baidu.ubs.analytics.d.b.Ls("上传成功，删除本地文件的       ");
                    com.baidu.ubs.analytics.d.g.Lx(az + "ABJson.log");
                    a(jVar, pVar, mVar, bVar, cXp3, cXp, cXp4);
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                stringBuffer2.append(a);
                stringBuffer2.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cXo().getContext(), stringBuffer2.toString())) {
                    a(jVar, pVar, mVar, bVar, cXp3, cXp, cXp4);
                    return;
                } else if (com.baidu.ubs.analytics.d.g.b(a, az, "ABJson.log")) {
                    a(jVar, pVar, mVar, bVar, cXp3, cXp, cXp4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("[");
            stringBuffer3.append(a);
            stringBuffer3.append("]");
            if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.cXo().getContext(), stringBuffer3.toString())) {
                a(jVar, pVar, mVar, bVar, cXp3, cXp, cXp4);
            } else if (com.baidu.ubs.analytics.d.g.b(a, az, "ABJson.log")) {
                a(jVar, pVar, mVar, bVar, cXp3, cXp, cXp4);
            }
        }
    }

    private static void a(com.baidu.ubs.analytics.a.j jVar, p pVar, com.baidu.ubs.analytics.a.m mVar, com.baidu.ubs.analytics.a.b bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        jVar.a(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
        pVar.Lm(m.cXG().I());
        mVar.a(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
        bVar.a(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
    }
}
