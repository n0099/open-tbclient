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
    private String hpp;
    private boolean isSuccess = true;
    private int iuA = 0;
    private boolean itM = false;
    private List<com.baidu.tieba.m.c> iuB = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.gs()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.Ae(g.a.cTZ);
                    com.baidu.tieba.j.d.Ae(g.a.hpm);
                    com.baidu.tieba.j.d.Ae(g.a.hpn);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.hpp = str;
    }

    public void ccR() {
        this.isSuccess = false;
    }

    public void ccS() {
        this.isSuccess = true;
    }

    public void ccT() {
        this.iuA++;
    }

    public boolean ccU() {
        return this.iuA > 0;
    }

    public void ccV() {
        this.itM = true;
    }

    public boolean ccW() {
        return this.itM;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.iuB.add(cVar);
        ccY();
        b(cVar);
        ccX();
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
                            com.baidu.tieba.j.d.a(new File(g.a.hpo + g.a.hpf + lVar.uuid + g.a.hpf + "debug"), lVar.iuE.ccs().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.hpp));
        }
    }

    private void ccX() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.hpo + g.a.hpf + eVar.uuid + g.a.hpf + "kpi"), k.e(eVar.isSuccess, eVar.itL, eVar.itM).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.iuA, this.itM, this.hpp));
        }
    }

    private void ccY() {
        if (com.baidu.adp.lib.util.f.gs()) {
            File file = new File(g.a.hpo + g.a.hpf + this.hpp + g.a.hpf);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bMg() {
        return e(this.isSuccess, this.iuA, this.itM);
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

    public JSONObject bMi() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.aa(this.iuB)) {
                int size = this.iuB.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.iuB.get(i).ccs());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
