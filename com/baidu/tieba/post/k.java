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
    private int kmv = 0;
    private boolean klH = false;
    private List<com.baidu.tieba.n.c> kmw = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.GE(g.a.exE);
                    com.baidu.tieba.k.d.GE(g.a.jbJ);
                    com.baidu.tieba.k.d.GE(g.a.jbK);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cLq() {
        this.isSuccess = false;
    }

    public void cLr() {
        this.isSuccess = true;
    }

    public void cLs() {
        this.kmv++;
    }

    public boolean cLt() {
        return this.kmv > 0;
    }

    public void cLu() {
        this.klH = true;
    }

    public boolean cLv() {
        return this.klH;
    }

    public void a(com.baidu.tieba.n.c cVar) {
        this.kmw.add(cVar);
        cLx();
        b(cVar);
        cLw();
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
                            com.baidu.tieba.k.d.a(new File(g.a.jbL + g.a.jbC + lVar.uuid + g.a.jbC + "debug"), lVar.kmz.cKR().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cLw() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.jbL + g.a.jbC + eVar.uuid + g.a.jbC + "kpi"), k.b(eVar.isSuccess, eVar.klG, eVar.klH).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.kmv, this.klH, this.mUuid));
        }
    }

    private void cLx() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.jbL + g.a.jbC + this.mUuid + g.a.jbC);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject crP() {
        return b(this.isSuccess, this.kmv, this.klH);
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

    public JSONObject crR() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.kmw)) {
                int size = this.kmw.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.kmw.get(i).cKR());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
