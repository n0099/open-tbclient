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
    private String fHV;
    private boolean isSuccess = true;
    private int gKI = 0;
    private boolean gJT = false;
    private List<com.baidu.tieba.m.c> gKJ = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hA()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.sm(g.a.bAH);
                    com.baidu.tieba.j.d.sm(g.a.fHS);
                    com.baidu.tieba.j.d.sm(g.a.fHT);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.fHV = str;
    }

    public void bud() {
        this.isSuccess = false;
    }

    public void bue() {
        this.isSuccess = true;
    }

    public void buf() {
        this.gKI++;
    }

    public boolean bug() {
        return this.gKI > 0;
    }

    public void buh() {
        this.gJT = true;
    }

    public boolean bui() {
        return this.gJT;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.gKJ.add(cVar);
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
                            com.baidu.tieba.j.d.a(new File(g.a.fHU + g.a.fHL + lVar.uuid + g.a.fHL + "debug"), lVar.gKM.btE().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.fHV));
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
                            com.baidu.tieba.j.d.a(new File(g.a.fHU + g.a.fHL + eVar.uuid + g.a.fHL + "kpi"), k.b(eVar.isSuccess, eVar.gJS, eVar.gJT).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gKI, this.gJT, this.fHV));
        }
    }

    private void buk() {
        if (com.baidu.adp.lib.util.f.hA()) {
            File file = new File(g.a.fHU + g.a.fHL + this.fHV + g.a.fHL);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bdS() {
        return b(this.isSuccess, this.gKI, this.gJT);
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
            if (!v.I(this.gKJ)) {
                int size = this.gKJ.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gKJ.get(i).btE());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
