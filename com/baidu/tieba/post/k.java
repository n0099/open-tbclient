package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.j.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {
    private String hvC;
    private boolean isSuccess = true;
    private int iAS = 0;
    private boolean iAe = false;
    private List<com.baidu.tieba.m.c> iAT = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.gB()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.AR(g.a.cVw);
                    com.baidu.tieba.j.d.AR(g.a.hvz);
                    com.baidu.tieba.j.d.AR(g.a.hvA);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.hvC = str;
    }

    public void cfJ() {
        this.isSuccess = false;
    }

    public void cfK() {
        this.isSuccess = true;
    }

    public void cfL() {
        this.iAS++;
    }

    public boolean cfM() {
        return this.iAS > 0;
    }

    public void cfN() {
        this.iAe = true;
    }

    public boolean cfO() {
        return this.iAe;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.iAT.add(cVar);
        cfQ();
        b(cVar);
        cfP();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.gB() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.hvB + g.a.hvs + lVar.uuid + g.a.hvs + "debug"), lVar.iAW.cfj().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.hvC));
        }
    }

    private void cfP() {
        if (com.baidu.adp.lib.util.f.gB()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.hvB + g.a.hvs + eVar.uuid + g.a.hvs + "kpi"), k.e(eVar.isSuccess, eVar.iAd, eVar.iAe).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.iAS, this.iAe, this.hvC));
        }
    }

    private void cfQ() {
        if (com.baidu.adp.lib.util.f.gB()) {
            File file = new File(g.a.hvB + g.a.hvs + this.hvC + g.a.hvs);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bOP() {
        return e(this.isSuccess, this.iAS, this.iAe);
    }

    public static final JSONObject e(boolean z, int i, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("postSuccess", z2 ? z ? 1 : 0 : 0);
            jSONObject.put("errorTimes", i);
            jSONObject.put("posted", z2 ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject bOR() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.aa(this.iAT)) {
                int size = this.iAT.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.iAT.get(i).cfj());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
