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
    private String fwd;
    private boolean isSuccess = true;
    private int gyv = 0;
    private boolean gxG = false;
    private List<com.baidu.tieba.m.c> gyw = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hB()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.rq(g.a.bvI);
                    com.baidu.tieba.j.d.rq(g.a.fwa);
                    com.baidu.tieba.j.d.rq(g.a.fwb);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fwd = str;
    }

    public void bru() {
        this.isSuccess = false;
    }

    public void brv() {
        this.isSuccess = true;
    }

    public void brw() {
        this.gyv++;
    }

    public boolean brx() {
        return this.gyv > 0;
    }

    public void bry() {
        this.gxG = true;
    }

    public boolean brz() {
        return this.gxG;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gyw.add(cVar);
        brB();
        b(cVar);
        brA();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.hB() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.fwc + g.a.fvT + lVar.uuid + g.a.fvT + "debug"), lVar.gyz.bqV().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fwd));
        }
    }

    private void brA() {
        if (com.baidu.adp.lib.util.f.hB()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.fwc + g.a.fvT + eVar.uuid + g.a.fvT + "kpi"), k.b(eVar.isSuccess, eVar.gxF, eVar.gxG).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gyv, this.gxG, this.fwd));
        }
    }

    private void brB() {
        if (com.baidu.adp.lib.util.f.hB()) {
            File file = new File(g.a.fwc + g.a.fvT + this.fwd + g.a.fvT);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bbr() {
        return b(this.isSuccess, this.gyv, this.gxG);
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

    public JSONObject bbs() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.J(this.gyw)) {
                int size = this.gyw.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gyw.get(i).bqV());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
