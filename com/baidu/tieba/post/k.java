package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.idl.authority.BuildConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.j.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    private String eQJ;
    private boolean isSuccess = true;
    private int fSJ = 0;
    private boolean fRU = false;
    private List<com.baidu.tieba.m.c> fSK = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.m9do()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.py(g.a.bbq);
                    com.baidu.tieba.j.d.py(g.a.eQG);
                    com.baidu.tieba.j.d.py(g.a.eQH);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.eQJ = str;
    }

    public void bhH() {
        this.isSuccess = false;
    }

    public void bhI() {
        this.isSuccess = true;
    }

    public void bhJ() {
        this.fSJ++;
    }

    public boolean bhK() {
        return this.fSJ > 0;
    }

    public void bhL() {
        this.fRU = true;
    }

    public boolean bhM() {
        return this.fRU;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.fSK.add(cVar);
        bhO();
        b(cVar);
        bhN();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.m9do() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized (BuildConfig.BUILD_TYPE) {
                            com.baidu.tieba.j.d.a(new File(g.a.eQI + g.a.eQz + lVar.uuid + g.a.eQz + BuildConfig.BUILD_TYPE), lVar.fSN.bhi().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.eQJ));
        }
    }

    private void bhN() {
        if (com.baidu.adp.lib.util.f.m9do()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.eQI + g.a.eQz + eVar.uuid + g.a.eQz + "kpi"), k.b(eVar.isSuccess, eVar.fRT, eVar.fRU).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.fSJ, this.fRU, this.eQJ));
        }
    }

    private void bhO() {
        if (com.baidu.adp.lib.util.f.m9do()) {
            File file = new File(g.a.eQI + g.a.eQz + this.eQJ + g.a.eQz);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aRY() {
        return b(this.isSuccess, this.fSJ, this.fRU);
    }

    public static final JSONObject b(boolean z, int i, boolean z2) {
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

    public JSONObject aRZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.w(this.fSK)) {
                int size = this.fSK.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.fSK.get(i).bhi());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
