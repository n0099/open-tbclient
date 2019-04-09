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
    private String gXV;
    private boolean isSuccess = true;
    private int ibT = 0;
    private boolean ibf = false;
    private List<com.baidu.tieba.m.c> ibU = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hy()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.yO(g.a.cLN);
                    com.baidu.tieba.j.d.yO(g.a.gXS);
                    com.baidu.tieba.j.d.yO(g.a.gXT);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.gXV = str;
    }

    public void bUO() {
        this.isSuccess = false;
    }

    public void bUP() {
        this.isSuccess = true;
    }

    public void bUQ() {
        this.ibT++;
    }

    public boolean bUR() {
        return this.ibT > 0;
    }

    public void bUS() {
        this.ibf = true;
    }

    public boolean bUT() {
        return this.ibf;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.ibU.add(cVar);
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
                            com.baidu.tieba.j.d.a(new File(g.a.gXU + g.a.gXL + lVar.uuid + g.a.gXL + "debug"), lVar.ibX.bUo().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.gXV));
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
                            com.baidu.tieba.j.d.a(new File(g.a.gXU + g.a.gXL + eVar.uuid + g.a.gXL + "kpi"), k.e(eVar.isSuccess, eVar.ibe, eVar.ibf).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.ibT, this.ibf, this.gXV));
        }
    }

    private void bUV() {
        if (com.baidu.adp.lib.util.f.hy()) {
            File file = new File(g.a.gXU + g.a.gXL + this.gXV + g.a.gXL);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bEs() {
        return e(this.isSuccess, this.ibT, this.ibf);
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
            if (!v.T(this.ibU)) {
                int size = this.ibU.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.ibU.get(i).bUo());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
