package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.l.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static b nKm = new b();

    public static b dRC() {
        return nKm;
    }

    public void dRD() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List dRF = b.dRF();
                    int size = dRF.size();
                    for (int i = 0; i < size; i++) {
                        a aVar = (a) dRF.get(i);
                        b.this.u(aVar.uuid, aVar.hUN);
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    private static File[] dRE() {
        File file = new File(f.a.luI);
        if (file.exists()) {
            return file.listFiles();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<a> dRF() {
        ArrayList arrayList = new ArrayList();
        File[] dRE = dRE();
        if (dRE != null) {
            for (File file : dRE) {
                String name = file.getName();
                JSONObject Ug = Ug(file.getAbsolutePath() + f.a.luy + "kpi");
                if (Ug == null) {
                    com.baidu.tieba.l.d.Oy(name);
                } else {
                    JSONObject Uh = Uh(file.getAbsolutePath() + f.a.luy + "debug");
                    if (Uh == null) {
                        com.baidu.tieba.l.d.Oy(name);
                    } else {
                        arrayList.add(new a(name, a(VideoPlatformStatic.bKQ(), Ug, Uh)));
                    }
                }
            }
        }
        return arrayList;
    }

    private static JSONObject Ug(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.tieba.l.d.Z(file));
                if (eM(jSONObject)) {
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

    private static boolean eM(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("errorTimes", -1);
        int optInt2 = jSONObject.optInt("postSuccess", -1);
        int optInt3 = jSONObject.optInt("posted", -1);
        return (optInt == -1 || optInt2 == -1 || optInt3 == -1 || (optInt3 != 1 && optInt <= 0)) ? false : true;
    }

    private static JSONObject Uh(String str) {
        if (!StringUtils.isNull(str) && new File(str).exists()) {
            try {
                return new JSONObject().put("running", ab(com.baidu.tieba.l.d.Ox(str)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static JSONArray ab(JSONArray jSONArray) {
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
            jSONArray.put(new com.baidu.tieba.n.c(502, "unknown", -4399, "").dBa());
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

    public void u(String str, JSONObject jSONObject) {
        new BdAsyncTask<a, Void, Void>() { // from class: com.baidu.tieba.u.b.2
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
            c.f(c.eN(aVar.hUN), TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
            com.baidu.tieba.l.d.Oy(aVar.uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
