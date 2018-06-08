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
    private String fdf;
    private boolean isSuccess = true;
    private int gfb = 0;
    private boolean gek = false;
    private List<com.baidu.tieba.m.c> gfc = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.ge()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.qp(g.a.bjC);
                    com.baidu.tieba.j.d.qp(g.a.fdc);
                    com.baidu.tieba.j.d.qp(g.a.fdd);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fdf = str;
    }

    public void bmF() {
        this.isSuccess = false;
    }

    public void bmG() {
        this.isSuccess = true;
    }

    public void bmH() {
        this.gfb++;
    }

    public boolean bmI() {
        return this.gfb > 0;
    }

    public void bmJ() {
        this.gek = true;
    }

    public boolean bmK() {
        return this.gek;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gfc.add(cVar);
        bmM();
        b(cVar);
        bmL();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.ge() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized (BuildConfig.BUILD_TYPE) {
                            com.baidu.tieba.j.d.a(new File(g.a.fde + g.a.fcV + lVar.uuid + g.a.fcV + BuildConfig.BUILD_TYPE), lVar.gff.bmg().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fdf));
        }
    }

    private void bmL() {
        if (com.baidu.adp.lib.util.f.ge()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.fde + g.a.fcV + eVar.uuid + g.a.fcV + "kpi"), k.b(eVar.isSuccess, eVar.gej, eVar.gek).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gfb, this.gek, this.fdf));
        }
    }

    private void bmM() {
        if (com.baidu.adp.lib.util.f.ge()) {
            File file = new File(g.a.fde + g.a.fcV + this.fdf + g.a.fcV);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aWV() {
        return b(this.isSuccess, this.gfb, this.gek);
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

    public JSONObject aWW() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!w.z(this.gfc)) {
                int size = this.gfc.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gfc.get(i).bmg());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
