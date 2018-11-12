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
/* loaded from: classes4.dex */
public class k {
    private String fxs;
    private boolean isSuccess = true;
    private int gzW = 0;
    private boolean gzh = false;
    private List<com.baidu.tieba.m.c> gzX = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hA()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.rr(g.a.bwt);
                    com.baidu.tieba.j.d.rr(g.a.fxp);
                    com.baidu.tieba.j.d.rr(g.a.fxq);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fxs = str;
    }

    public void bqQ() {
        this.isSuccess = false;
    }

    public void bqR() {
        this.isSuccess = true;
    }

    public void bqS() {
        this.gzW++;
    }

    public boolean bqT() {
        return this.gzW > 0;
    }

    public void bqU() {
        this.gzh = true;
    }

    public boolean bqV() {
        return this.gzh;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gzX.add(cVar);
        bqX();
        b(cVar);
        bqW();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.hA() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.fxr + g.a.fxi + lVar.uuid + g.a.fxi + "debug"), lVar.gAa.bqr().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fxs));
        }
    }

    private void bqW() {
        if (com.baidu.adp.lib.util.f.hA()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.fxr + g.a.fxi + eVar.uuid + g.a.fxi + "kpi"), k.b(eVar.isSuccess, eVar.gzg, eVar.gzh).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gzW, this.gzh, this.fxs));
        }
    }

    private void bqX() {
        if (com.baidu.adp.lib.util.f.hA()) {
            File file = new File(g.a.fxr + g.a.fxi + this.fxs + g.a.fxi);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject baO() {
        return b(this.isSuccess, this.gzW, this.gzh);
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

    public JSONObject baQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.I(this.gzX)) {
                int size = this.gzX.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gzX.get(i).bqr());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
