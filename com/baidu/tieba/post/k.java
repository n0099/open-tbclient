package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.k.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int lgN = 0;
    private boolean lfZ = false;
    private List<com.baidu.tieba.n.b> lgO = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.JF(g.a.jRJ);
                    com.baidu.tieba.k.d.JF(g.a.jRQ);
                    com.baidu.tieba.k.d.JF(g.a.jRR);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dae() {
        this.isSuccess = false;
    }

    public void daf() {
        this.isSuccess = true;
    }

    public void dag() {
        this.lgN++;
    }

    public boolean dah() {
        return this.lgN > 0;
    }

    public void dai() {
        this.lfZ = true;
    }

    public boolean daj() {
        return this.lfZ;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.lgO.add(bVar);
        dal();
        b(bVar);
        dak();
    }

    private void b(com.baidu.tieba.n.b bVar) {
        if (com.baidu.adp.lib.util.f.checkSD() && bVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.k.d.a(new File(g.a.jRS + g.a.jRI + lVar.uuid + g.a.jRI + "debug"), lVar.lgR.cZL().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dak() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.jRS + g.a.jRI + eVar.uuid + g.a.jRI + "kpi"), k.b(eVar.isSuccess, eVar.lfY, eVar.lfZ).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.lgN, this.lfZ, this.mUuid));
        }
    }

    private void dal() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.jRS + g.a.jRI + this.mUuid + g.a.jRI);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cGv() {
        return b(this.isSuccess, this.lgN, this.lfZ);
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

    public JSONObject cGx() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!x.isEmpty(this.lgO)) {
                int size = this.lgO.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.lgO.get(i).cZL());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
