package com.baidu.tieba.s;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.j.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static b hqo = new b();

    public static b bFQ() {
        return hqo;
    }

    public void bFR() {
        if (f.hB()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List bFT = b.bFT();
                    int size = bFT.size();
                    for (int i = 0; i < size; i++) {
                        a aVar = (a) bFT.get(i);
                        b.this.g(aVar.uuid, aVar.gIA);
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    private static File[] bFS() {
        File file = new File(g.a.fwb);
        if (file.exists()) {
            return file.listFiles();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<a> bFT() {
        ArrayList arrayList = new ArrayList();
        File[] bFS = bFS();
        if (bFS != null) {
            for (File file : bFS) {
                String name = file.getName();
                JSONObject vJ = vJ(file.getAbsolutePath() + g.a.fvS + "kpi");
                if (vJ == null) {
                    com.baidu.tieba.j.d.rs(name);
                } else {
                    JSONObject vK = vK(file.getAbsolutePath() + g.a.fvS + "debug");
                    if (vK == null) {
                        com.baidu.tieba.j.d.rs(name);
                    } else {
                        arrayList.add(new a(name, a(VideoPlatformStatic.Ur(), vJ, vK)));
                    }
                }
            }
        }
        return arrayList;
    }

    private static JSONObject vJ(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.tieba.j.d.H(file));
                if (au(jSONObject)) {
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

    private static boolean au(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("errorTimes", -1);
        int optInt2 = jSONObject.optInt("postSuccess", -1);
        int optInt3 = jSONObject.optInt("posted", -1);
        return (optInt == -1 || optInt2 == -1 || optInt3 == -1 || (optInt3 != 1 && optInt <= 0)) ? false : true;
    }

    private static JSONObject vK(String str) {
        if (!StringUtils.isNull(str) && new File(str).exists()) {
            try {
                return new JSONObject().put("running", t(com.baidu.tieba.j.d.rr(str)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static JSONArray t(JSONArray jSONArray) {
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
            jSONArray.put(new com.baidu.tieba.m.d(502, "unknown", -4399, "").bqV());
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

    public void g(String str, JSONObject jSONObject) {
        new BdAsyncTask<a, Void, Void>() { // from class: com.baidu.tieba.s.b.2
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
            c.g(c.av(aVar.gIA), TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
            com.baidu.tieba.j.d.rs(aVar.uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
