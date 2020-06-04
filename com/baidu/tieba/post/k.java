package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.v;
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
    private int kFy = 0;
    private boolean kEK = false;
    private List<com.baidu.tieba.n.c> kFz = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.Io(g.a.eMr);
                    com.baidu.tieba.k.d.Io(g.a.jrS);
                    com.baidu.tieba.k.d.Io(g.a.jrT);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cSG() {
        this.isSuccess = false;
    }

    public void cSH() {
        this.isSuccess = true;
    }

    public void cSI() {
        this.kFy++;
    }

    public boolean cSJ() {
        return this.kFy > 0;
    }

    public void cSK() {
        this.kEK = true;
    }

    public boolean cSL() {
        return this.kEK;
    }

    public void a(com.baidu.tieba.n.c cVar) {
        this.kFz.add(cVar);
        cSN();
        b(cVar);
        cSM();
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
                            com.baidu.tieba.k.d.a(new File(g.a.jrU + g.a.jrL + lVar.uuid + g.a.jrL + "debug"), lVar.kFC.cSh().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cSM() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.jrU + g.a.jrL + eVar.uuid + g.a.jrL + "kpi"), k.b(eVar.isSuccess, eVar.kEJ, eVar.kEK).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.kFy, this.kEK, this.mUuid));
        }
    }

    private void cSN() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.jrU + g.a.jrL + this.mUuid + g.a.jrL);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cyJ() {
        return b(this.isSuccess, this.kFy, this.kEK);
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

    public JSONObject cyL() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.kFz)) {
                int size = this.kFz.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.kFz.get(i).cSh());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
