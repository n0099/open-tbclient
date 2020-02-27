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
    private int jAz = 0;
    private boolean jzL = false;
    private List<com.baidu.tieba.n.c> jAA = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.ET(g.a.dXa);
                    com.baidu.tieba.k.d.ET(g.a.ipP);
                    com.baidu.tieba.k.d.ET(g.a.ipQ);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cAk() {
        this.isSuccess = false;
    }

    public void cAl() {
        this.isSuccess = true;
    }

    public void cAm() {
        this.jAz++;
    }

    public boolean cAn() {
        return this.jAz > 0;
    }

    public void cAo() {
        this.jzL = true;
    }

    public boolean cAp() {
        return this.jzL;
    }

    public void a(com.baidu.tieba.n.c cVar) {
        this.jAA.add(cVar);
        cAr();
        b(cVar);
        cAq();
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
                            com.baidu.tieba.k.d.a(new File(g.a.ipR + g.a.ipI + lVar.uuid + g.a.ipI + "debug"), lVar.jAD.czM().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cAq() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.ipR + g.a.ipI + eVar.uuid + g.a.ipI + "kpi"), k.c(eVar.isSuccess, eVar.jzK, eVar.jzL).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.jAz, this.jzL, this.mUuid));
        }
    }

    private void cAr() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.ipR + g.a.ipI + this.mUuid + g.a.ipI);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cgN() {
        return c(this.isSuccess, this.jAz, this.jzL);
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

    public JSONObject cgP() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.jAA)) {
                int size = this.jAA.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.jAA.get(i).czM());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
