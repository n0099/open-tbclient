package com.baidu.tieba.q;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.i.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static b hmg = new b();

    public static b bzO() {
        return hmg;
    }

    public void bzP() {
        if (f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.q.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List bzR = b.bzR();
                    int size = bzR.size();
                    for (int i = 0; i < size; i++) {
                        a aVar = (a) bzR.get(i);
                        b.this.d(aVar.fsQ, aVar.cKn);
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    private static File[] bzQ() {
        File file = new File(g.a.fss);
        if (file.exists()) {
            return file.listFiles();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<a> bzR() {
        ArrayList arrayList = new ArrayList();
        File[] bzQ = bzQ();
        if (bzQ != null) {
            for (File file : bzQ) {
                String name = file.getName();
                JSONObject tr = tr(file.getAbsolutePath() + g.a.fsj + "kpi");
                if (tr == null) {
                    com.baidu.tieba.i.d.pl(name);
                } else {
                    JSONObject ts = ts(file.getAbsolutePath() + g.a.fsj + "debug");
                    if (ts == null) {
                        com.baidu.tieba.i.d.pl(name);
                    } else {
                        arrayList.add(new a(name, a(VideoPlatformStatic.Tw(), tr, ts)));
                    }
                }
            }
        }
        return arrayList;
    }

    private static JSONObject tr(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.tieba.i.d.C(file));
                if (P(jSONObject)) {
                    return jSONObject;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static boolean P(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("errorTimes", -1);
        int optInt2 = jSONObject.optInt("postSuccess", -1);
        int optInt3 = jSONObject.optInt("posted", -1);
        return (optInt == -1 || optInt2 == -1 || optInt3 == -1 || (optInt3 != 1 && optInt <= 0)) ? false : true;
    }

    private static JSONObject ts(String str) {
        if (!StringUtils.isNull(str) && new File(str).exists()) {
            try {
                return new JSONObject().put("running", g(com.baidu.tieba.i.d.pk(str)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static JSONArray g(JSONArray jSONArray) {
        int optInt;
        boolean z = false;
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && ((optInt = optJSONObject.optInt("type")) == 501 || optInt == 503 || optInt == 502)) {
                z = true;
                break;
            }
        }
        if (!z) {
            jSONArray.put(new com.baidu.tieba.l.d(HttpStatus.SC_BAD_GATEWAY, "unknown", -4399, "").bkP());
            return jSONArray;
        }
        return jSONArray;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("kpiInfo", jSONObject2);
            jSONObject4.put("baseInfo", jSONObject);
            jSONObject4.put("debugInfo", jSONObject3);
            return jSONObject4;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void d(String str, JSONObject jSONObject) {
        new BdAsyncTask<a, Void, Void>() { // from class: com.baidu.tieba.q.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: a */
            public Void doInBackground(a... aVarArr) {
                if (aVarArr != null && aVarArr.length == 1 && aVarArr[0] != null) {
                    b.this.a(aVarArr[0]);
                }
                return null;
            }
        }.execute(new a(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        try {
            c.f(c.Q(aVar.cKn), TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
            com.baidu.tieba.i.d.pl(aVar.fsQ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
