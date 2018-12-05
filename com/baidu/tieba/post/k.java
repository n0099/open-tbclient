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
    private String fEi;
    private boolean isSuccess = true;
    private int gGM = 0;
    private boolean gFX = false;
    private List<com.baidu.tieba.m.c> gGN = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hA()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.rT(g.a.bzQ);
                    com.baidu.tieba.j.d.rT(g.a.fEf);
                    com.baidu.tieba.j.d.rT(g.a.fEg);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fEi = str;
    }

    public void bsJ() {
        this.isSuccess = false;
    }

    public void bsK() {
        this.isSuccess = true;
    }

    public void bsL() {
        this.gGM++;
    }

    public boolean bsM() {
        return this.gGM > 0;
    }

    public void bsN() {
        this.gFX = true;
    }

    public boolean bsO() {
        return this.gFX;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gGN.add(cVar);
        bsQ();
        b(cVar);
        bsP();
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
                            com.baidu.tieba.j.d.a(new File(g.a.fEh + g.a.fDY + lVar.uuid + g.a.fDY + "debug"), lVar.gGQ.bsk().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fEi));
        }
    }

    private void bsP() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.fEh + g.a.fDY + eVar.uuid + g.a.fDY + "kpi"), k.b(eVar.isSuccess, eVar.gFW, eVar.gFX).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gGM, this.gFX, this.fEi));
        }
    }

    private void bsQ() {
        if (com.baidu.adp.lib.util.f.hA()) {
            File file = new File(g.a.fEh + g.a.fDY + this.fEi + g.a.fDY);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bcF() {
        return b(this.isSuccess, this.gGM, this.gFX);
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

    public JSONObject bcH() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.I(this.gGN)) {
                int size = this.gGN.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gGN.get(i).bsk());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
