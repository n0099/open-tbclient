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
    private String hpq;
    private boolean isSuccess = true;
    private int iuB = 0;
    private boolean itN = false;
    private List<com.baidu.tieba.m.c> iuC = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.gs()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.Ag(g.a.cUa);
                    com.baidu.tieba.j.d.Ag(g.a.hpn);
                    com.baidu.tieba.j.d.Ag(g.a.hpo);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.hpq = str;
    }

    public void ccS() {
        this.isSuccess = false;
    }

    public void ccT() {
        this.isSuccess = true;
    }

    public void ccU() {
        this.iuB++;
    }

    public boolean ccV() {
        return this.iuB > 0;
    }

    public void ccW() {
        this.itN = true;
    }

    public boolean ccX() {
        return this.itN;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.iuC.add(cVar);
        ccZ();
        b(cVar);
        ccY();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.gs() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.hpp + g.a.hpg + lVar.uuid + g.a.hpg + "debug"), lVar.iuF.cct().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.hpq));
        }
    }

    private void ccY() {
        if (com.baidu.adp.lib.util.f.gs()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.hpp + g.a.hpg + eVar.uuid + g.a.hpg + "kpi"), k.e(eVar.isSuccess, eVar.itM, eVar.itN).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.iuB, this.itN, this.hpq));
        }
    }

    private void ccZ() {
        if (com.baidu.adp.lib.util.f.gs()) {
            File file = new File(g.a.hpp + g.a.hpg + this.hpq + g.a.hpg);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bMh() {
        return e(this.isSuccess, this.iuB, this.itN);
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

    public JSONObject bMj() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.aa(this.iuC)) {
                int size = this.iuC.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.iuC.get(i).cct());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
