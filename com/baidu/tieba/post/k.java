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
/* loaded from: classes5.dex */
public class k {
    private String hyo;
    private boolean isSuccess = true;
    private int iEo = 0;
    private boolean iDA = false;
    private List<com.baidu.tieba.m.c> iEp = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.gB()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.Br(g.a.cWw);
                    com.baidu.tieba.j.d.Br(g.a.hyl);
                    com.baidu.tieba.j.d.Br(g.a.hym);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.hyo = str;
    }

    public void cgP() {
        this.isSuccess = false;
    }

    public void cgQ() {
        this.isSuccess = true;
    }

    public void cgR() {
        this.iEo++;
    }

    public boolean cgS() {
        return this.iEo > 0;
    }

    public void cgT() {
        this.iDA = true;
    }

    public boolean cgU() {
        return this.iDA;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.iEp.add(cVar);
        cgW();
        b(cVar);
        cgV();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.gB() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.hyn + g.a.hye + lVar.uuid + g.a.hye + "debug"), lVar.iEs.cgp().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.hyo));
        }
    }

    private void cgV() {
        if (com.baidu.adp.lib.util.f.gB()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.hyn + g.a.hye + eVar.uuid + g.a.hye + "kpi"), k.e(eVar.isSuccess, eVar.iDz, eVar.iDA).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.iEo, this.iDA, this.hyo));
        }
    }

    private void cgW() {
        if (com.baidu.adp.lib.util.f.gB()) {
            File file = new File(g.a.hyn + g.a.hye + this.hyo + g.a.hye);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bPQ() {
        return e(this.isSuccess, this.iEo, this.iDA);
    }

    public static final JSONObject e(boolean z, int i, boolean z2) {
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

    public JSONObject bPS() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.aa(this.iEp)) {
                int size = this.iEp.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.iEp.get(i).cgp());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
