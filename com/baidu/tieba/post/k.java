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
    private int jAN = 0;
    private boolean jzZ = false;
    private List<com.baidu.tieba.n.c> jAO = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.EU(g.a.dXo);
                    com.baidu.tieba.k.d.EU(g.a.iqd);
                    com.baidu.tieba.k.d.EU(g.a.iqe);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cAn() {
        this.isSuccess = false;
    }

    public void cAo() {
        this.isSuccess = true;
    }

    public void cAp() {
        this.jAN++;
    }

    public boolean cAq() {
        return this.jAN > 0;
    }

    public void cAr() {
        this.jzZ = true;
    }

    public boolean cAs() {
        return this.jzZ;
    }

    public void a(com.baidu.tieba.n.c cVar) {
        this.jAO.add(cVar);
        cAu();
        b(cVar);
        cAt();
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
                            com.baidu.tieba.k.d.a(new File(g.a.iqf + g.a.ipW + lVar.uuid + g.a.ipW + "debug"), lVar.jAR.czP().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cAt() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.iqf + g.a.ipW + eVar.uuid + g.a.ipW + "kpi"), k.c(eVar.isSuccess, eVar.jzY, eVar.jzZ).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.jAN, this.jzZ, this.mUuid));
        }
    }

    private void cAu() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.iqf + g.a.ipW + this.mUuid + g.a.ipW);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cgQ() {
        return c(this.isSuccess, this.jAN, this.jzZ);
    }

    public static final JSONObject c(boolean z, int i, boolean z2) {
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

    public JSONObject cgS() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.jAO)) {
                int size = this.jAO.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.jAO.get(i).czP());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
