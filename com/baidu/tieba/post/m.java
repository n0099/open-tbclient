package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.i.g;
import com.baidu.tieba.l.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m {
    private String eEu;
    private boolean isSuccess = true;
    private int fSQ = 0;
    private boolean fSe = false;
    private List<c> fSR = new ArrayList();

    static {
        if (f.dG()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.m.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.i.d.oP(g.a.bbq);
                    com.baidu.tieba.i.d.oP(g.a.eEr);
                    com.baidu.tieba.i.d.oP(g.a.eEs);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public m(String str) {
        this.eEu = str;
    }

    public void bkn() {
        this.isSuccess = false;
    }

    public void bko() {
        this.isSuccess = true;
    }

    public void bkp() {
        this.fSQ++;
    }

    public boolean bkq() {
        return this.fSQ > 0;
    }

    public void bkr() {
        this.fSe = true;
    }

    public boolean bks() {
        return this.fSe;
    }

    public void a(c cVar) {
        this.fSR.add(cVar);
        bku();
        b(cVar);
        bkt();
    }

    private void b(c cVar) {
        if (f.dG() && cVar != null) {
            new BdAsyncTask<n, Void, Void>() { // from class: com.baidu.tieba.post.m.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(n... nVarArr) {
                    if (nVarArr != null && nVarArr.length == 1 && nVarArr[0] != null) {
                        n nVar = nVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.i.d.a(new File(g.a.eEt + g.a.eEk + nVar.eER + g.a.eEk + "debug"), nVar.fSU.bjQ().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new n(cVar, this.eEu));
        }
    }

    private void bkt() {
        if (f.dG()) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.post.m.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(d... dVarArr) {
                    if (dVarArr != null && dVarArr.length == 1 && dVarArr[0] != null) {
                        d dVar = dVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.i.d.a(new File(g.a.eEt + g.a.eEk + dVar.eER + g.a.eEk + "kpi"), m.a(dVar.isSuccess, dVar.fSd, dVar.fSe).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new d(this.isSuccess, this.fSQ, this.fSe, this.eEu));
        }
    }

    private void bku() {
        if (f.dG()) {
            File file = new File(g.a.eEt + g.a.eEk + this.eEu + g.a.eEk);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aOh() {
        return a(this.isSuccess, this.fSQ, this.fSe);
    }

    public static final JSONObject a(boolean z, int i, boolean z2) {
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

    public JSONObject aOi() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.w(this.fSR)) {
                int size = this.fSR.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.fSR.get(i).bjQ());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
