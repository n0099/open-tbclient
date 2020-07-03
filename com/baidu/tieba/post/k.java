package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.k.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int kZu = 0;
    private boolean kYG = false;
    private List<com.baidu.tieba.n.c> kZv = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.IQ(g.a.eWD);
                    com.baidu.tieba.k.d.IQ(g.a.jJj);
                    com.baidu.tieba.k.d.IQ(g.a.jJk);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cWW() {
        this.isSuccess = false;
    }

    public void cWX() {
        this.isSuccess = true;
    }

    public void cWY() {
        this.kZu++;
    }

    public boolean cWZ() {
        return this.kZu > 0;
    }

    public void cXa() {
        this.kYG = true;
    }

    public boolean cXb() {
        return this.kYG;
    }

    public void a(com.baidu.tieba.n.c cVar) {
        this.kZv.add(cVar);
        cXd();
        b(cVar);
        cXc();
    }

    private void b(com.baidu.tieba.n.c cVar) {
        if (com.baidu.adp.lib.util.f.checkSD() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.k.d.a(new File(g.a.jJl + g.a.jJc + lVar.uuid + g.a.jJc + "debug"), lVar.kZy.cWx().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cXc() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.k.d.a(new File(g.a.jJl + g.a.jJc + eVar.uuid + g.a.jJc + "kpi"), k.b(eVar.isSuccess, eVar.kYF, eVar.kYG).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.kZu, this.kYG, this.mUuid));
        }
    }

    private void cXd() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.jJl + g.a.jJc + this.mUuid + g.a.jJc);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cCG() {
        return b(this.isSuccess, this.kZu, this.kYG);
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

    public JSONObject cCI() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!w.isEmpty(this.kZv)) {
                int size = this.kZv.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.kZv.get(i).cWx());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
