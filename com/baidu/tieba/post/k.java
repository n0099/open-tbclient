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
/* loaded from: classes2.dex */
public class k {
    private String fow;
    private boolean isSuccess = true;
    private int gqU = 0;
    private boolean gqe = false;
    private List<com.baidu.tieba.m.c> gqV = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.qP(g.a.brA);
                    com.baidu.tieba.j.d.qP(g.a.fot);
                    com.baidu.tieba.j.d.qP(g.a.fou);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fow = str;
    }

    public void bof() {
        this.isSuccess = false;
    }

    public void bog() {
        this.isSuccess = true;
    }

    public void boh() {
        this.gqU++;
    }

    public boolean boi() {
        return this.gqU > 0;
    }

    public void boj() {
        this.gqe = true;
    }

    public boolean bok() {
        return this.gqe;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gqV.add(cVar);
        bom();
        b(cVar);
        bol();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.hk() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.fov + g.a.fom + lVar.uuid + g.a.fom + "debug"), lVar.gqY.bnG().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fow));
        }
    }

    private void bol() {
        if (com.baidu.adp.lib.util.f.hk()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.fov + g.a.fom + eVar.uuid + g.a.fom + "kpi"), k.b(eVar.isSuccess, eVar.gqd, eVar.gqe).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gqU, this.gqe, this.fow));
        }
    }

    private void bom() {
        if (com.baidu.adp.lib.util.f.hk()) {
            File file = new File(g.a.fov + g.a.fom + this.fow + g.a.fom);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aYf() {
        return b(this.isSuccess, this.gqU, this.gqe);
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

    public JSONObject aYg() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.z(this.gqV)) {
                int size = this.gqV.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gqV.get(i).bnG());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
