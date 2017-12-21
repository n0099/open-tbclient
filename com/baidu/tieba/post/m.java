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
    private String eEy;
    private boolean isSuccess = true;
    private int fSV = 0;
    private boolean fSj = false;
    private List<c> fSW = new ArrayList();

    static {
        if (f.dG()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.m.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.i.d.oP(g.a.bbu);
                    com.baidu.tieba.i.d.oP(g.a.eEv);
                    com.baidu.tieba.i.d.oP(g.a.eEw);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public m(String str) {
        this.eEy = str;
    }

    public void bkn() {
        this.isSuccess = false;
    }

    public void bko() {
        this.isSuccess = true;
    }

    public void bkp() {
        this.fSV++;
    }

    public boolean bkq() {
        return this.fSV > 0;
    }

    public void bkr() {
        this.fSj = true;
    }

    public boolean bks() {
        return this.fSj;
    }

    public void a(c cVar) {
        this.fSW.add(cVar);
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
                            com.baidu.tieba.i.d.a(new File(g.a.eEx + g.a.eEo + nVar.eEV + g.a.eEo + "debug"), nVar.fSZ.bjQ().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new n(cVar, this.eEy));
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
                            com.baidu.tieba.i.d.a(new File(g.a.eEx + g.a.eEo + dVar.eEV + g.a.eEo + "kpi"), m.a(dVar.isSuccess, dVar.fSi, dVar.fSj).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new d(this.isSuccess, this.fSV, this.fSj, this.eEy));
        }
    }

    private void bku() {
        if (f.dG()) {
            File file = new File(g.a.eEx + g.a.eEo + this.eEy + g.a.eEo);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aOh() {
        return a(this.isSuccess, this.fSV, this.fSj);
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
            if (!v.w(this.fSW)) {
                int size = this.fSW.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.fSW.get(i).bjQ());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
