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
    private int iCK = 0;
    private boolean iBW = false;
    private List<com.baidu.tieba.m.c> iCL = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.zL(g.a.dfR);
                    com.baidu.tieba.j.d.zL(g.a.hwZ);
                    com.baidu.tieba.j.d.zL(g.a.hxa);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cdP() {
        this.isSuccess = false;
    }

    public void cdQ() {
        this.isSuccess = true;
    }

    public void cdR() {
        this.iCK++;
    }

    public boolean cdS() {
        return this.iCK > 0;
    }

    public void cdT() {
        this.iBW = true;
    }

    public boolean cdU() {
        return this.iBW;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.iCL.add(cVar);
        cdW();
        b(cVar);
        cdV();
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
                            com.baidu.tieba.j.d.a(new File(g.a.hxb + g.a.hwS + lVar.uuid + g.a.hwS + "debug"), lVar.iCO.cdp().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cdV() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.hxb + g.a.hwS + eVar.uuid + g.a.hwS + "kpi"), k.e(eVar.isSuccess, eVar.iBV, eVar.iBW).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.iCK, this.iBW, this.mUuid));
        }
    }

    private void cdW() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.hxb + g.a.hwS + this.mUuid + g.a.hwS);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bMQ() {
        return e(this.isSuccess, this.iCK, this.iBW);
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

    public JSONObject bMS() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.iCL)) {
                int size = this.iCL.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.iCL.get(i).cdp());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
