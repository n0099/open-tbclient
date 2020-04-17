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
    private int kmr = 0;
    private boolean klD = false;
    private List<com.baidu.tieba.n.c> kms = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.GB(g.a.exz);
                    com.baidu.tieba.k.d.GB(g.a.jbF);
                    com.baidu.tieba.k.d.GB(g.a.jbG);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cLs() {
        this.isSuccess = false;
    }

    public void cLt() {
        this.isSuccess = true;
    }

    public void cLu() {
        this.kmr++;
    }

    public boolean cLv() {
        return this.kmr > 0;
    }

    public void cLw() {
        this.klD = true;
    }

    public boolean cLx() {
        return this.klD;
    }

    public void a(com.baidu.tieba.n.c cVar) {
        this.kms.add(cVar);
        cLz();
        b(cVar);
        cLy();
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
                            com.baidu.tieba.k.d.a(new File(g.a.jbH + g.a.jby + lVar.uuid + g.a.jby + "debug"), lVar.kmv.cKT().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cLy() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.jbH + g.a.jby + eVar.uuid + g.a.jby + "kpi"), k.b(eVar.isSuccess, eVar.klC, eVar.klD).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.kmr, this.klD, this.mUuid));
        }
    }

    private void cLz() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.jbH + g.a.jby + this.mUuid + g.a.jby);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject crR() {
        return b(this.isSuccess, this.kmr, this.klD);
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

    public JSONObject crT() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.kms)) {
                int size = this.kms.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.kms.get(i).cKT());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
