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
    private String fwc;
    private boolean isSuccess = true;
    private int gyu = 0;
    private boolean gxF = false;
    private List<com.baidu.tieba.m.c> gyv = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hB()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.rq(g.a.bvI);
                    com.baidu.tieba.j.d.rq(g.a.fvZ);
                    com.baidu.tieba.j.d.rq(g.a.fwa);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fwc = str;
    }

    public void bru() {
        this.isSuccess = false;
    }

    public void brv() {
        this.isSuccess = true;
    }

    public void brw() {
        this.gyu++;
    }

    public boolean brx() {
        return this.gyu > 0;
    }

    public void bry() {
        this.gxF = true;
    }

    public boolean brz() {
        return this.gxF;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gyv.add(cVar);
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
                            com.baidu.tieba.j.d.a(new File(g.a.fwb + g.a.fvS + lVar.uuid + g.a.fvS + "debug"), lVar.gyy.bqV().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fwc));
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
                            com.baidu.tieba.j.d.a(new File(g.a.fwb + g.a.fvS + eVar.uuid + g.a.fvS + "kpi"), k.b(eVar.isSuccess, eVar.gxE, eVar.gxF).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gyu, this.gxF, this.fwc));
        }
    }

    private void brB() {
        if (com.baidu.adp.lib.util.f.hB()) {
            File file = new File(g.a.fwb + g.a.fvS + this.fwc + g.a.fvS);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bbr() {
        return b(this.isSuccess, this.gyu, this.gxF);
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
            if (!v.J(this.gyv)) {
                int size = this.gyv.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gyv.get(i).bqV());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
