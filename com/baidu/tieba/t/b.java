package com.baidu.tieba.t;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.idl.authority.BuildConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.tieba.j.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static b gVQ = new b();

    public static b bAJ() {
        return gVQ;
    }

    public void bAK() {
        if (f.ge()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List bAM = b.bAM();
                    int size = bAM.size();
                    for (int i = 0; i < size; i++) {
                        a aVar = (a) bAM.get(i);
                        b.this.f(aVar.uuid, aVar.cnj);
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    private static File[] bAL() {
        File file = new File(g.a.fde);
        if (file.exists()) {
            return file.listFiles();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<a> bAM() {
        ArrayList arrayList = new ArrayList();
        File[] bAL = bAL();
        if (bAL != null) {
            for (File file : bAL) {
                String name = file.getName();
                JSONObject uA = uA(file.getAbsolutePath() + g.a.fcV + "kpi");
                if (uA == null) {
                    com.baidu.tieba.j.d.qr(name);
                } else {
                    JSONObject uB = uB(file.getAbsolutePath() + g.a.fcV + BuildConfig.BUILD_TYPE);
                    if (uB == null) {
                        com.baidu.tieba.j.d.qr(name);
                    } else {
                        arrayList.add(new a(name, a(VideoPlatformStatic.PY(), uA, uB)));
                    }
                }
            }
        }
        return arrayList;
    }

    private static JSONObject uA(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.tieba.j.d.B(file));
                if (ac(jSONObject)) {
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

    private static boolean ac(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("errorTimes", -1);
        int optInt2 = jSONObject.optInt("postSuccess", -1);
        int optInt3 = jSONObject.optInt("posted", -1);
        return (optInt == -1 || optInt2 == -1 || optInt3 == -1 || (optInt3 != 1 && optInt <= 0)) ? false : true;
    }

    private static JSONObject uB(String str) {
        if (!StringUtils.isNull(str) && new File(str).exists()) {
            try {
                return new JSONObject().put("running", g(com.baidu.tieba.j.d.qq(str)));
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
            jSONArray.put(new com.baidu.tieba.m.d(HttpStatus.SC_BAD_GATEWAY, "unknown", -4399, "").bmg());
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

    public void f(String str, JSONObject jSONObject) {
        new BdAsyncTask<a, Void, Void>() { // from class: com.baidu.tieba.t.b.2
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
            c.f(c.ad(aVar.cnj), TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
            com.baidu.tieba.j.d.qr(aVar.uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
