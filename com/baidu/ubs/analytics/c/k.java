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
/* loaded from: classes.dex */
public final class k extends com.baidu.ubs.analytics.d.d {
    private static String QI;

    @Override // com.baidu.ubs.analytics.d.d
    protected final void a() {
        d dVar;
        String str;
        dVar = d.a.hkO;
        if (dVar.bES().size() == 0) {
            com.baidu.ubs.analytics.d.b.vk(" 线程轮询  app 应该是退出了");
        }
        if (QI == null && Environment.getExternalStorageState().equals("mounted")) {
            QI = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath()).append("/baidu/ab/").append(i.q(com.baidu.ubs.analytics.d.bEN().getContext())).append("/").toString();
        }
        com.baidu.ubs.analytics.a.j jVar = new com.baidu.ubs.analytics.a.j();
        p pVar = new p();
        com.baidu.ubs.analytics.a.m mVar = new com.baidu.ubs.analytics.a.m();
        com.baidu.ubs.analytics.a.b bVar = new com.baidu.ubs.analytics.a.b();
        List<com.baidu.ubs.analytics.a.i> bEO = jVar.bEO();
        List<n> bEO2 = pVar.bEO();
        List<com.baidu.ubs.analytics.a.l> bEO3 = mVar.bEO();
        List<com.baidu.ubs.analytics.a.a> bEO4 = bVar.bEO();
        com.baidu.ubs.analytics.d.b.vk("这次查询结果       session ：    " + bEO2.size() + "      点击事件   " + bEO4.size() + "    网络请求：  " + bEO.size() + "    页面记录     " + bEO3.size());
        if (bEO.size() == 0 && bEO3.size() == 0 && bEO4.size() == 0) {
            com.baidu.ubs.analytics.d.b.vk("这次记录 json 为空的，就不传了  ………………");
            if (bEO2.size() > 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < bEO2.size()) {
                        if (bEO2.get(i2).O() == null) {
                            pVar.vg(bEO2.get(i2).I());
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        } else {
            JSONArray jSONArray = new JSONArray();
            String l = com.baidu.ubs.analytics.d.bEN().l();
            if (com.baidu.ubs.analytics.d.bEN().bEM() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : com.baidu.ubs.analytics.d.bEN().bEM().entrySet()) {
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
            aVar.r(i.q(com.baidu.ubs.analytics.d.bEN().getContext()));
            aVar.b(l);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(i.k(com.baidu.ubs.analytics.d.bEN().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(i.l(com.baidu.ubs.analytics.d.bEN().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.u());
            aVar.j(f.bEY() ? "1" : "0");
            aVar.k(i.m(com.baidu.ubs.analytics.d.bEN().getContext()));
            aVar.m(i.n(com.baidu.ubs.analytics.d.bEN().getContext()));
            aVar.n(i.y());
            aVar.o(i.z());
            aVar.p(i.A());
            int j = i.j(com.baidu.ubs.analytics.d.bEN().getContext());
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
            com.baidu.ubs.analytics.d.bEN();
            aVar.setPhone("");
            bVar2.a(aVar);
            bVar2.c(bEO4);
            bVar2.e(bEO);
            bVar2.b(bEO2);
            bVar2.d(bEO3);
            String a = com.baidu.ubs.analytics.d.h.a(bVar2);
            String co = com.baidu.ubs.analytics.d.g.co(QI, "ABJson.log");
            if (!co.equals("")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(co);
                stringBuffer.append(a);
                stringBuffer.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.bEN().getContext(), stringBuffer.toString())) {
                    com.baidu.ubs.analytics.d.b.vk("上传成功，删除本地文件的       ");
                    com.baidu.ubs.analytics.d.g.vp(QI + "ABJson.log");
                    a(jVar, pVar, mVar, bVar, bEO3, bEO, bEO4);
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                stringBuffer2.append(a);
                stringBuffer2.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.bEN().getContext(), stringBuffer2.toString())) {
                    a(jVar, pVar, mVar, bVar, bEO3, bEO, bEO4);
                    return;
                } else if (com.baidu.ubs.analytics.d.g.K(a, QI, "ABJson.log")) {
                    a(jVar, pVar, mVar, bVar, bEO3, bEO, bEO4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("[");
            stringBuffer3.append(a);
            stringBuffer3.append("]");
            if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.bEN().getContext(), stringBuffer3.toString())) {
                a(jVar, pVar, mVar, bVar, bEO3, bEO, bEO4);
            } else if (com.baidu.ubs.analytics.d.g.K(a, QI, "ABJson.log")) {
                a(jVar, pVar, mVar, bVar, bEO3, bEO, bEO4);
            }
        }
    }

    private static void a(com.baidu.ubs.analytics.a.j jVar, p pVar, com.baidu.ubs.analytics.a.m mVar, com.baidu.ubs.analytics.a.b bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        jVar.a(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
        pVar.ve(m.bFd().I());
        mVar.a(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
        bVar.a(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
    }
}
