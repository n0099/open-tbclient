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
    private String fHa;
    private boolean isSuccess = true;
    private int gJD = 0;
    private boolean gIO = false;
    private List<com.baidu.tieba.m.c> gJE = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hA()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.rW(g.a.bzT);
                    com.baidu.tieba.j.d.rW(g.a.fGX);
                    com.baidu.tieba.j.d.rW(g.a.fGY);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fHa = str;
    }

    public void btu() {
        this.isSuccess = false;
    }

    public void btv() {
        this.isSuccess = true;
    }

    public void btw() {
        this.gJD++;
    }

    public boolean btx() {
        return this.gJD > 0;
    }

    public void bty() {
        this.gIO = true;
    }

    public boolean btz() {
        return this.gIO;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gJE.add(cVar);
        btB();
        b(cVar);
        btA();
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
                            com.baidu.tieba.j.d.a(new File(g.a.fGZ + g.a.fGQ + lVar.uuid + g.a.fGQ + "debug"), lVar.gJH.bsV().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fHa));
        }
    }

    private void btA() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.fGZ + g.a.fGQ + eVar.uuid + g.a.fGQ + "kpi"), k.b(eVar.isSuccess, eVar.gIN, eVar.gIO).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gJD, this.gIO, this.fHa));
        }
    }

    private void btB() {
        if (com.baidu.adp.lib.util.f.hA()) {
            File file = new File(g.a.fGZ + g.a.fGQ + this.fHa + g.a.fGQ);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bds() {
        return b(this.isSuccess, this.gJD, this.gIO);
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

    public JSONObject bdu() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.I(this.gJE)) {
                int size = this.gJE.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gJE.get(i).bsV());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
