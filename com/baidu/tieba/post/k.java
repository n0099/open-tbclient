package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.idl.authority.BuildConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.j.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    private String fgW;
    private boolean isSuccess = true;
    private int gjc = 0;
    private boolean gim = false;
    private List<com.baidu.tieba.m.c> gjd = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.ge()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.qp(g.a.blb);
                    com.baidu.tieba.j.d.qp(g.a.fgT);
                    com.baidu.tieba.j.d.qp(g.a.fgU);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fgW = str;
    }

    public void bnj() {
        this.isSuccess = false;
    }

    public void bnk() {
        this.isSuccess = true;
    }

    public void bnl() {
        this.gjc++;
    }

    public boolean bnm() {
        return this.gjc > 0;
    }

    public void bnn() {
        this.gim = true;
    }

    public boolean bno() {
        return this.gim;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gjd.add(cVar);
        bnq();
        b(cVar);
        bnp();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.ge() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized (BuildConfig.BUILD_TYPE) {
                            com.baidu.tieba.j.d.a(new File(g.a.fgV + g.a.fgM + lVar.uuid + g.a.fgM + BuildConfig.BUILD_TYPE), lVar.gjg.bmK().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fgW));
        }
    }

    private void bnp() {
        if (com.baidu.adp.lib.util.f.ge()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.fgV + g.a.fgM + eVar.uuid + g.a.fgM + "kpi"), k.b(eVar.isSuccess, eVar.gil, eVar.gim).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gjc, this.gim, this.fgW));
        }
    }

    private void bnq() {
        if (com.baidu.adp.lib.util.f.ge()) {
            File file = new File(g.a.fgV + g.a.fgM + this.fgW + g.a.fgM);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aXC() {
        return b(this.isSuccess, this.gjc, this.gim);
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

    public JSONObject aXD() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!w.A(this.gjd)) {
                int size = this.gjd.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gjd.get(i).bmK());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
