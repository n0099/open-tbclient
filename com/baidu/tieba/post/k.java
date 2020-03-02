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
    private int jAB = 0;
    private boolean jzN = false;
    private List<com.baidu.tieba.n.c> jAC = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.ET(g.a.dXb);
                    com.baidu.tieba.k.d.ET(g.a.ipR);
                    com.baidu.tieba.k.d.ET(g.a.ipS);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cAm() {
        this.isSuccess = false;
    }

    public void cAn() {
        this.isSuccess = true;
    }

    public void cAo() {
        this.jAB++;
    }

    public boolean cAp() {
        return this.jAB > 0;
    }

    public void cAq() {
        this.jzN = true;
    }

    public boolean cAr() {
        return this.jzN;
    }

    public void a(com.baidu.tieba.n.c cVar) {
        this.jAC.add(cVar);
        cAt();
        b(cVar);
        cAs();
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
                            com.baidu.tieba.k.d.a(new File(g.a.ipT + g.a.ipK + lVar.uuid + g.a.ipK + "debug"), lVar.jAF.czO().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cAs() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.ipT + g.a.ipK + eVar.uuid + g.a.ipK + "kpi"), k.c(eVar.isSuccess, eVar.jzM, eVar.jzN).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.jAB, this.jzN, this.mUuid));
        }
    }

    private void cAt() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.ipT + g.a.ipK + this.mUuid + g.a.ipK);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cgP() {
        return c(this.isSuccess, this.jAB, this.jzN);
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

    public JSONObject cgR() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.jAC)) {
                int size = this.jAC.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.jAC.get(i).czO());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
