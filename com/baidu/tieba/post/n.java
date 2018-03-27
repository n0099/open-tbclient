package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.idl.authority.BuildConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.i.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private String fvY;
    private boolean isSuccess = true;
    private int gxX = 0;
    private boolean gxi = false;
    private List<com.baidu.tieba.l.c> gxY = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.n.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.i.d.ps(g.a.bRt);
                    com.baidu.tieba.i.d.ps(g.a.fvV);
                    com.baidu.tieba.i.d.ps(g.a.fvW);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public n(String str) {
        this.fvY = str;
    }

    public void bmB() {
        this.isSuccess = false;
    }

    public void bmC() {
        this.isSuccess = true;
    }

    public void bmD() {
        this.gxX++;
    }

    public boolean bmE() {
        return this.gxX > 0;
    }

    public void bmF() {
        this.gxi = true;
    }

    public boolean bmG() {
        return this.gxi;
    }

    public void a(com.baidu.tieba.l.c cVar) {
        this.gxY.add(cVar);
        bmI();
        b(cVar);
        bmH();
    }

    private void b(com.baidu.tieba.l.c cVar) {
        if (com.baidu.adp.lib.util.f.lk() && cVar != null) {
            new BdAsyncTask<o, Void, Void>() { // from class: com.baidu.tieba.post.n.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(o... oVarArr) {
                    if (oVarArr != null && oVarArr.length == 1 && oVarArr[0] != null) {
                        o oVar = oVarArr[0];
                        synchronized (BuildConfig.BUILD_TYPE) {
                            com.baidu.tieba.i.d.a(new File(g.a.fvX + g.a.fvO + oVar.fwv + g.a.fvO + BuildConfig.BUILD_TYPE), oVar.gyb.bmc().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new o(cVar, this.fvY));
        }
    }

    private void bmH() {
        if (com.baidu.adp.lib.util.f.lk()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.n.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.i.d.a(new File(g.a.fvX + g.a.fvO + eVar.fwv + g.a.fvO + "kpi"), n.b(eVar.isSuccess, eVar.gxh, eVar.gxi).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gxX, this.gxi, this.fvY));
        }
    }

    private void bmI() {
        if (com.baidu.adp.lib.util.f.lk()) {
            File file = new File(g.a.fvX + g.a.fvO + this.fvY + g.a.fvO);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aXd() {
        return b(this.isSuccess, this.gxX, this.gxi);
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

    public JSONObject aXe() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.E(this.gxY)) {
                int size = this.gxY.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gxY.get(i).bmc());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
