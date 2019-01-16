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
    private String fHU;
    private boolean isSuccess = true;
    private int gKH = 0;
    private boolean gJS = false;
    private List<com.baidu.tieba.m.c> gKI = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hA()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.sm(g.a.bAG);
                    com.baidu.tieba.j.d.sm(g.a.fHR);
                    com.baidu.tieba.j.d.sm(g.a.fHS);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fHU = str;
    }

    public void bud() {
        this.isSuccess = false;
    }

    public void bue() {
        this.isSuccess = true;
    }

    public void buf() {
        this.gKH++;
    }

    public boolean bug() {
        return this.gKH > 0;
    }

    public void buh() {
        this.gJS = true;
    }

    public boolean bui() {
        return this.gJS;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gKI.add(cVar);
        buk();
        b(cVar);
        buj();
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
                            com.baidu.tieba.j.d.a(new File(g.a.fHT + g.a.fHK + lVar.uuid + g.a.fHK + "debug"), lVar.gKL.btE().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fHU));
        }
    }

    private void buj() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.fHT + g.a.fHK + eVar.uuid + g.a.fHK + "kpi"), k.b(eVar.isSuccess, eVar.gJR, eVar.gJS).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gKH, this.gJS, this.fHU));
        }
    }

    private void buk() {
        if (com.baidu.adp.lib.util.f.hA()) {
            File file = new File(g.a.fHT + g.a.fHK + this.fHU + g.a.fHK);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bdS() {
        return b(this.isSuccess, this.gKH, this.gJS);
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

    public JSONObject bdU() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.I(this.gKI)) {
                int size = this.gKI.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gKI.get(i).btE());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
