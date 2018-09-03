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
    private String fgZ;
    private boolean isSuccess = true;
    private int gjC = 0;
    private boolean giM = false;
    private List<com.baidu.tieba.m.c> gjD = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.gd()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.qk(g.a.blM);
                    com.baidu.tieba.j.d.qk(g.a.fgW);
                    com.baidu.tieba.j.d.qk(g.a.fgX);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fgZ = str;
    }

    public void blz() {
        this.isSuccess = false;
    }

    public void blA() {
        this.isSuccess = true;
    }

    public void blB() {
        this.gjC++;
    }

    public boolean blC() {
        return this.gjC > 0;
    }

    public void blD() {
        this.giM = true;
    }

    public boolean blE() {
        return this.giM;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gjD.add(cVar);
        blG();
        b(cVar);
        blF();
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
                            com.baidu.tieba.j.d.a(new File(g.a.fgY + g.a.fgP + lVar.uuid + g.a.fgP + BuildConfig.BUILD_TYPE), lVar.gjG.bla().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fgZ));
        }
    }

    private void blF() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.fgY + g.a.fgP + eVar.uuid + g.a.fgP + "kpi"), k.b(eVar.isSuccess, eVar.giL, eVar.giM).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gjC, this.giM, this.fgZ));
        }
    }

    private void blG() {
        if (com.baidu.adp.lib.util.f.gd()) {
            File file = new File(g.a.fgY + g.a.fgP + this.fgZ + g.a.fgP);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aVR() {
        return b(this.isSuccess, this.gjC, this.giM);
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

    public JSONObject aVS() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!w.z(this.gjD)) {
                int size = this.gjD.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gjD.get(i).bla());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
