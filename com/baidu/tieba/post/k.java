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
    private String hpm;
    private boolean isSuccess = true;
    private int iux = 0;
    private boolean itJ = false;
    private List<com.baidu.tieba.m.c> iuy = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.gs()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.Ae(g.a.cTY);
                    com.baidu.tieba.j.d.Ae(g.a.hpj);
                    com.baidu.tieba.j.d.Ae(g.a.hpk);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.hpm = str;
    }

    public void ccO() {
        this.isSuccess = false;
    }

    public void ccP() {
        this.isSuccess = true;
    }

    public void ccQ() {
        this.iux++;
    }

    public boolean ccR() {
        return this.iux > 0;
    }

    public void ccS() {
        this.itJ = true;
    }

    public boolean ccT() {
        return this.itJ;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.iuy.add(cVar);
        ccV();
        b(cVar);
        ccU();
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
                            com.baidu.tieba.j.d.a(new File(g.a.hpl + g.a.hpc + lVar.uuid + g.a.hpc + "debug"), lVar.iuB.ccp().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.hpm));
        }
    }

    private void ccU() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.hpl + g.a.hpc + eVar.uuid + g.a.hpc + "kpi"), k.e(eVar.isSuccess, eVar.itI, eVar.itJ).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.iux, this.itJ, this.hpm));
        }
    }

    private void ccV() {
        if (com.baidu.adp.lib.util.f.gs()) {
            File file = new File(g.a.hpl + g.a.hpc + this.hpm + g.a.hpc);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bMd() {
        return e(this.isSuccess, this.iux, this.itJ);
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

    public JSONObject bMf() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.aa(this.iuy)) {
                int size = this.iuy.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.iuy.get(i).ccp());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
