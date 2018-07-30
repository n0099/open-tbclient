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
/* loaded from: classes2.dex */
public final class k extends com.baidu.ubs.analytics.d.d {
    private static String Yb;

    @Override // com.baidu.ubs.analytics.d.d
    protected final void a() {
        d dVar;
        String str;
        dVar = d.a.hCz;
        if (dVar.bIZ().size() == 0) {
            com.baidu.ubs.analytics.d.b.we(" 线程轮询  app 应该是退出了");
        }
        if (Yb == null && Environment.getExternalStorageState().equals("mounted")) {
            Yb = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath()).append("/baidu/ab/").append(i.q(com.baidu.ubs.analytics.d.bIU().getContext())).append("/").toString();
        }
        com.baidu.ubs.analytics.a.j jVar = new com.baidu.ubs.analytics.a.j();
        p pVar = new p();
        com.baidu.ubs.analytics.a.m mVar = new com.baidu.ubs.analytics.a.m();
        com.baidu.ubs.analytics.a.b bVar = new com.baidu.ubs.analytics.a.b();
        List<com.baidu.ubs.analytics.a.i> bIV = jVar.bIV();
        List<n> bIV2 = pVar.bIV();
        List<com.baidu.ubs.analytics.a.l> bIV3 = mVar.bIV();
        List<com.baidu.ubs.analytics.a.a> bIV4 = bVar.bIV();
        com.baidu.ubs.analytics.d.b.we("这次查询结果       session ：    " + bIV2.size() + "      点击事件   " + bIV4.size() + "    网络请求：  " + bIV.size() + "    页面记录     " + bIV3.size());
        if (bIV.size() == 0 && bIV3.size() == 0 && bIV4.size() == 0) {
            com.baidu.ubs.analytics.d.b.we("这次记录 json 为空的，就不传了  ………………");
            if (bIV2.size() > 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < bIV2.size()) {
                        if (bIV2.get(i2).O() == null) {
                            pVar.wa(bIV2.get(i2).I());
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        } else {
            JSONArray jSONArray = new JSONArray();
            String l = com.baidu.ubs.analytics.d.bIU().l();
            if (com.baidu.ubs.analytics.d.bIU().bIT() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : com.baidu.ubs.analytics.d.bIU().bIT().entrySet()) {
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
            aVar.r(i.q(com.baidu.ubs.analytics.d.bIU().getContext()));
            aVar.b(l);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(i.k(com.baidu.ubs.analytics.d.bIU().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(i.l(com.baidu.ubs.analytics.d.bIU().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.u());
            aVar.j(f.bJf() ? "1" : "0");
            aVar.k(i.m(com.baidu.ubs.analytics.d.bIU().getContext()));
            aVar.m(i.n(com.baidu.ubs.analytics.d.bIU().getContext()));
            aVar.n(i.y());
            aVar.o(i.z());
            aVar.p(i.A());
            int j = i.j(com.baidu.ubs.analytics.d.bIU().getContext());
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
            com.baidu.ubs.analytics.d.bIU();
            aVar.setPhone("");
            bVar2.a(aVar);
            bVar2.c(bIV4);
            bVar2.e(bIV);
            bVar2.b(bIV2);
            bVar2.d(bIV3);
            String a = com.baidu.ubs.analytics.d.h.a(bVar2);
            String L = com.baidu.ubs.analytics.d.g.L(Yb, "ABJson.log");
            if (!L.equals("")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(L);
                stringBuffer.append(a);
                stringBuffer.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.bIU().getContext(), stringBuffer.toString())) {
                    com.baidu.ubs.analytics.d.b.we("上传成功，删除本地文件的       ");
                    com.baidu.ubs.analytics.d.g.wj(Yb + "ABJson.log");
                    a(jVar, pVar, mVar, bVar, bIV3, bIV, bIV4);
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                stringBuffer2.append(a);
                stringBuffer2.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.bIU().getContext(), stringBuffer2.toString())) {
                    a(jVar, pVar, mVar, bVar, bIV3, bIV, bIV4);
                    return;
                } else if (com.baidu.ubs.analytics.d.g.k(a, Yb, "ABJson.log")) {
                    a(jVar, pVar, mVar, bVar, bIV3, bIV, bIV4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("[");
            stringBuffer3.append(a);
            stringBuffer3.append("]");
            if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.bIU().getContext(), stringBuffer3.toString())) {
                a(jVar, pVar, mVar, bVar, bIV3, bIV, bIV4);
            } else if (com.baidu.ubs.analytics.d.g.k(a, Yb, "ABJson.log")) {
                a(jVar, pVar, mVar, bVar, bIV3, bIV, bIV4);
            }
        }
    }

    private static void a(com.baidu.ubs.analytics.a.j jVar, p pVar, com.baidu.ubs.analytics.a.m mVar, com.baidu.ubs.analytics.a.b bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        jVar.a(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
        pVar.vY(m.bJj().I());
        mVar.a(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
        bVar.a(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
    }
}
