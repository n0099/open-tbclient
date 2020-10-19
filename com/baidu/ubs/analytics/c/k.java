package com.baidu.ubs.analytics.c;

import android.os.Build;
import android.os.Environment;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.ubs.analytics.a.n;
import com.baidu.ubs.analytics.a.p;
import com.baidu.ubs.analytics.b;
import com.baidu.ubs.analytics.c.d;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class k extends com.baidu.ubs.analytics.d.d {
    private static String az;

    @Override // com.baidu.ubs.analytics.d.d
    protected final void a() {
        d dVar;
        String str;
        dVar = d.a.nFL;
        if (dVar.dUf().size() == 0) {
            com.baidu.ubs.analytics.d.b.I(" 线程轮询  app 应该是退出了");
        }
        if (az == null && Environment.getExternalStorageState().equals("mounted")) {
            az = new StringBuffer().append(Environment.getExternalStorageDirectory().getPath()).append("/baidu/ab/").append(i.q(com.baidu.ubs.analytics.d.dUa().getContext())).append("/").toString();
        }
        com.baidu.ubs.analytics.a.j jVar = new com.baidu.ubs.analytics.a.j();
        p pVar = new p();
        com.baidu.ubs.analytics.a.m mVar = new com.baidu.ubs.analytics.a.m();
        com.baidu.ubs.analytics.a.b bVar = new com.baidu.ubs.analytics.a.b();
        List<com.baidu.ubs.analytics.a.i> dUb = jVar.dUb();
        List<n> dUb2 = pVar.dUb();
        List<com.baidu.ubs.analytics.a.l> dUb3 = mVar.dUb();
        List<com.baidu.ubs.analytics.a.a> dUb4 = bVar.dUb();
        com.baidu.ubs.analytics.d.b.I("这次查询结果       session ：    " + dUb2.size() + "      点击事件   " + dUb4.size() + "    网络请求：  " + dUb.size() + "    页面记录     " + dUb3.size());
        if (dUb.size() == 0 && dUb3.size() == 0 && dUb4.size() == 0) {
            com.baidu.ubs.analytics.d.b.I("这次记录 json 为空的，就不传了  ………………");
            if (dUb2.size() > 1) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < dUb2.size()) {
                        if (dUb2.get(i2).O() == null) {
                            pVar.D(dUb2.get(i2).I());
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        } else {
            JSONArray jSONArray = new JSONArray();
            String l = com.baidu.ubs.analytics.d.dUa().l();
            if (com.baidu.ubs.analytics.d.dUa().dTZ() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : com.baidu.ubs.analytics.d.dUa().dTZ().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SID, entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.baidu.ubs.analytics.d.j.a(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar2 = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(i.q(com.baidu.ubs.analytics.d.dUa().getContext()));
            aVar.b(l);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(i.k(com.baidu.ubs.analytics.d.dUa().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(i.l(com.baidu.ubs.analytics.d.dUa().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.u());
            aVar.j(f.ab() ? "1" : "0");
            aVar.k(i.m(com.baidu.ubs.analytics.d.dUa().getContext()));
            aVar.m(i.n(com.baidu.ubs.analytics.d.dUa().getContext()));
            aVar.n(i.y());
            aVar.o(i.z());
            aVar.p(i.A());
            int j = i.j(com.baidu.ubs.analytics.d.dUa().getContext());
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
            com.baidu.ubs.analytics.d.dUa();
            aVar.setPhone("");
            bVar2.a(aVar);
            bVar2.c(dUb4);
            bVar2.e(dUb);
            bVar2.b(dUb2);
            bVar2.d(dUb3);
            String a2 = com.baidu.ubs.analytics.d.h.a(bVar2);
            String X = com.baidu.ubs.analytics.d.g.X(az, "ABJson.log");
            if (!X.equals("")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(X);
                stringBuffer.append(a2);
                stringBuffer.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.dUa().getContext(), stringBuffer.toString())) {
                    com.baidu.ubs.analytics.d.b.I("上传成功，删除本地文件的       ");
                    com.baidu.ubs.analytics.d.g.Vl(az + "ABJson.log");
                    a(jVar, pVar, mVar, bVar, dUb3, dUb, dUb4);
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                stringBuffer2.append(a2);
                stringBuffer2.append("]");
                if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.dUa().getContext(), stringBuffer2.toString())) {
                    a(jVar, pVar, mVar, bVar, dUb3, dUb, dUb4);
                    return;
                } else if (com.baidu.ubs.analytics.d.g.b(a2, az, "ABJson.log")) {
                    a(jVar, pVar, mVar, bVar, dUb3, dUb, dUb4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("[");
            stringBuffer3.append(a2);
            stringBuffer3.append("]");
            if (com.baidu.ubs.analytics.b.a.a(com.baidu.ubs.analytics.d.dUa().getContext(), stringBuffer3.toString())) {
                a(jVar, pVar, mVar, bVar, dUb3, dUb, dUb4);
            } else if (com.baidu.ubs.analytics.d.g.b(a2, az, "ABJson.log")) {
                a(jVar, pVar, mVar, bVar, dUb3, dUb, dUb4);
            }
        }
    }

    private static void a(com.baidu.ubs.analytics.a.j jVar, p pVar, com.baidu.ubs.analytics.a.m mVar, com.baidu.ubs.analytics.a.b bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        jVar.a(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
        pVar.Vf(m.dUq().I());
        mVar.a(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
        bVar.a(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
    }
}
