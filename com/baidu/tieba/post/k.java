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
/* loaded from: classes8.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int jzE = 0;
    private boolean jyQ = false;
    private List<com.baidu.tieba.m.c> jzF = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.ED(g.a.dSV);
                    com.baidu.tieba.j.d.ED(g.a.inQ);
                    com.baidu.tieba.j.d.ED(g.a.inR);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cyN() {
        this.isSuccess = false;
    }

    public void cyO() {
        this.isSuccess = true;
    }

    public void cyP() {
        this.jzE++;
    }

    public boolean cyQ() {
        return this.jzE > 0;
    }

    public void cyR() {
        this.jyQ = true;
    }

    public boolean cyS() {
        return this.jyQ;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.jzF.add(cVar);
        cyU();
        b(cVar);
        cyT();
    }

    private void b(com.baidu.tieba.m.c cVar) {
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
                            com.baidu.tieba.j.d.a(new File(g.a.inS + g.a.inJ + lVar.uuid + g.a.inJ + "debug"), lVar.jzI.cyp().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cyT() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.inS + g.a.inJ + eVar.uuid + g.a.inJ + "kpi"), k.c(eVar.isSuccess, eVar.jyP, eVar.jyQ).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.jzE, this.jyQ, this.mUuid));
        }
    }

    private void cyU() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.inS + g.a.inJ + this.mUuid + g.a.inJ);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cfj() {
        return c(this.isSuccess, this.jzE, this.jyQ);
    }

    public static final JSONObject c(boolean z, int i, boolean z2) {
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

    public JSONObject cfl() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.jzF)) {
                int size = this.jzF.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.jzF.get(i).cyp());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
