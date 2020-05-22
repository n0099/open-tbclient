package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.k.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int kEq = 0;
    private boolean kDC = false;
    private List<com.baidu.tieba.n.c> kEr = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.In(g.a.eMg);
                    com.baidu.tieba.k.d.In(g.a.jqM);
                    com.baidu.tieba.k.d.In(g.a.jqN);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cSq() {
        this.isSuccess = false;
    }

    public void cSr() {
        this.isSuccess = true;
    }

    public void cSs() {
        this.kEq++;
    }

    public boolean cSt() {
        return this.kEq > 0;
    }

    public void cSu() {
        this.kDC = true;
    }

    public boolean cSv() {
        return this.kDC;
    }

    public void a(com.baidu.tieba.n.c cVar) {
        this.kEr.add(cVar);
        cSx();
        b(cVar);
        cSw();
    }

    private void b(com.baidu.tieba.n.c cVar) {
        if (com.baidu.adp.lib.util.f.checkSD() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.k.d.a(new File(g.a.jqO + g.a.jqF + lVar.uuid + g.a.jqF + "debug"), lVar.kEu.cRR().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cSw() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.k.d.a(new File(g.a.jqO + g.a.jqF + eVar.uuid + g.a.jqF + "kpi"), k.b(eVar.isSuccess, eVar.kDB, eVar.kDC).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.kEq, this.kDC, this.mUuid));
        }
    }

    private void cSx() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.jqO + g.a.jqF + this.mUuid + g.a.jqF);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cys() {
        return b(this.isSuccess, this.kEq, this.kDC);
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

    public JSONObject cyu() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.kEr)) {
                int size = this.kEr.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.kEr.get(i).cRR());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
