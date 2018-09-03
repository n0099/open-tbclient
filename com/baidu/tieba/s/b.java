package com.baidu.tieba.s;

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
    private static b hbg = new b();

    public static b bzN() {
        return hbg;
    }

    public void bzO() {
        if (f.gd()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List bzQ = b.bzQ();
                    int size = bzQ.size();
                    for (int i = 0; i < size; i++) {
                        a aVar = (a) bzQ.get(i);
                        b.this.g(aVar.uuid, aVar.gtH);
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    private static File[] bzP() {
        File file = new File(g.a.fgY);
        if (file.exists()) {
            return file.listFiles();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<a> bzQ() {
        ArrayList arrayList = new ArrayList();
        File[] bzP = bzP();
        if (bzP != null) {
            for (File file : bzP) {
                String name = file.getName();
                JSONObject uy = uy(file.getAbsolutePath() + g.a.fgP + "kpi");
                if (uy == null) {
                    com.baidu.tieba.j.d.qm(name);
                } else {
                    JSONObject uz = uz(file.getAbsolutePath() + g.a.fgP + BuildConfig.BUILD_TYPE);
                    if (uz == null) {
                        com.baidu.tieba.j.d.qm(name);
                    } else {
                        arrayList.add(new a(name, a(VideoPlatformStatic.QH(), uy, uz)));
                    }
                }
            }
        }
        return arrayList;
    }

    private static JSONObject uy(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.tieba.j.d.B(file));
                if (aa(jSONObject)) {
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

    private static boolean aa(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("errorTimes", -1);
        int optInt2 = jSONObject.optInt("postSuccess", -1);
        int optInt3 = jSONObject.optInt("posted", -1);
        return (optInt == -1 || optInt2 == -1 || optInt3 == -1 || (optInt3 != 1 && optInt <= 0)) ? false : true;
    }

    private static JSONObject uz(String str) {
        if (!StringUtils.isNull(str) && new File(str).exists()) {
            try {
                return new JSONObject().put("running", l(com.baidu.tieba.j.d.ql(str)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static JSONArray l(JSONArray jSONArray) {
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
            jSONArray.put(new com.baidu.tieba.m.d(HttpStatus.SC_BAD_GATEWAY, "unknown", -4399, "").bla());
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
            c.f(c.ab(aVar.gtH), TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
            com.baidu.tieba.j.d.qm(aVar.uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
