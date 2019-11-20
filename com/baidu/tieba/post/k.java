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
    private String mUuid;
    private boolean isSuccess = true;
    private int iBT = 0;
    private boolean iBf = false;
    private List<com.baidu.tieba.m.c> iBU = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.zL(g.a.dfa);
                    com.baidu.tieba.j.d.zL(g.a.hwi);
                    com.baidu.tieba.j.d.zL(g.a.hwj);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cdN() {
        this.isSuccess = false;
    }

    public void cdO() {
        this.isSuccess = true;
    }

    public void cdP() {
        this.iBT++;
    }

    public boolean cdQ() {
        return this.iBT > 0;
    }

    public void cdR() {
        this.iBf = true;
    }

    public boolean cdS() {
        return this.iBf;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.iBU.add(cVar);
        cdU();
        b(cVar);
        cdT();
    }

    private void b(com.baidu.tieba.m.c cVar) {
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
                            com.baidu.tieba.j.d.a(new File(g.a.hwk + g.a.hwb + lVar.uuid + g.a.hwb + "debug"), lVar.iBX.cdn().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cdT() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.hwk + g.a.hwb + eVar.uuid + g.a.hwb + "kpi"), k.e(eVar.isSuccess, eVar.iBe, eVar.iBf).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.iBT, this.iBf, this.mUuid));
        }
    }

    private void cdU() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.hwk + g.a.hwb + this.mUuid + g.a.hwb);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bMO() {
        return e(this.isSuccess, this.iBT, this.iBf);
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

    public JSONObject bMQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.iBU)) {
                int size = this.iBU.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.iBU.get(i).cdn());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
