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
    private String fhf;
    private boolean isSuccess = true;
    private int gjD = 0;
    private boolean giN = false;
    private List<com.baidu.tieba.m.c> gjE = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.gd()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.qi(g.a.blH);
                    com.baidu.tieba.j.d.qi(g.a.fhc);
                    com.baidu.tieba.j.d.qi(g.a.fhd);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fhf = str;
    }

    public void blC() {
        this.isSuccess = false;
    }

    public void blD() {
        this.isSuccess = true;
    }

    public void blE() {
        this.gjD++;
    }

    public boolean blF() {
        return this.gjD > 0;
    }

    public void blG() {
        this.giN = true;
    }

    public boolean blH() {
        return this.giN;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gjE.add(cVar);
        blJ();
        b(cVar);
        blI();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.gd() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized (BuildConfig.BUILD_TYPE) {
                            com.baidu.tieba.j.d.a(new File(g.a.fhe + g.a.fgV + lVar.uuid + g.a.fgV + BuildConfig.BUILD_TYPE), lVar.gjH.bld().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fhf));
        }
    }

    private void blI() {
        if (com.baidu.adp.lib.util.f.gd()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.fhe + g.a.fgV + eVar.uuid + g.a.fgV + "kpi"), k.b(eVar.isSuccess, eVar.giM, eVar.giN).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gjD, this.giN, this.fhf));
        }
    }

    private void blJ() {
        if (com.baidu.adp.lib.util.f.gd()) {
            File file = new File(g.a.fhe + g.a.fgV + this.fhf + g.a.fgV);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aVV() {
        return b(this.isSuccess, this.gjD, this.giN);
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

    public JSONObject aVW() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!w.z(this.gjE)) {
                int size = this.gjE.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gjE.get(i).bld());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
