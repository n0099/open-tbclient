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
    private String gXU;
    private boolean isSuccess = true;
    private int ibS = 0;
    private boolean ibe = false;
    private List<com.baidu.tieba.m.c> ibT = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hy()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.yO(g.a.cLM);
                    com.baidu.tieba.j.d.yO(g.a.gXR);
                    com.baidu.tieba.j.d.yO(g.a.gXS);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.gXU = str;
    }

    public void bUO() {
        this.isSuccess = false;
    }

    public void bUP() {
        this.isSuccess = true;
    }

    public void bUQ() {
        this.ibS++;
    }

    public boolean bUR() {
        return this.ibS > 0;
    }

    public void bUS() {
        this.ibe = true;
    }

    public boolean bUT() {
        return this.ibe;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.ibT.add(cVar);
        bUV();
        b(cVar);
        bUU();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.hy() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.gXT + g.a.gXK + lVar.uuid + g.a.gXK + "debug"), lVar.ibW.bUo().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.gXU));
        }
    }

    private void bUU() {
        if (com.baidu.adp.lib.util.f.hy()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.gXT + g.a.gXK + eVar.uuid + g.a.gXK + "kpi"), k.e(eVar.isSuccess, eVar.ibd, eVar.ibe).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.ibS, this.ibe, this.gXU));
        }
    }

    private void bUV() {
        if (com.baidu.adp.lib.util.f.hy()) {
            File file = new File(g.a.gXT + g.a.gXK + this.gXU + g.a.gXK);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bEs() {
        return e(this.isSuccess, this.ibS, this.ibe);
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

    public JSONObject bEu() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.T(this.ibT)) {
                int size = this.ibT.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.ibT.get(i).bUo());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
