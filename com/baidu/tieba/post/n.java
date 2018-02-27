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
    private String fvI;
    private boolean isSuccess = true;
    private int gxH = 0;
    private boolean gwS = false;
    private List<com.baidu.tieba.l.c> gxI = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.n.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.i.d.ps(g.a.bRq);
                    com.baidu.tieba.i.d.ps(g.a.fvF);
                    com.baidu.tieba.i.d.ps(g.a.fvG);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public n(String str) {
        this.fvI = str;
    }

    public void bmA() {
        this.isSuccess = false;
    }

    public void bmB() {
        this.isSuccess = true;
    }

    public void bmC() {
        this.gxH++;
    }

    public boolean bmD() {
        return this.gxH > 0;
    }

    public void bmE() {
        this.gwS = true;
    }

    public boolean bmF() {
        return this.gwS;
    }

    public void a(com.baidu.tieba.l.c cVar) {
        this.gxI.add(cVar);
        bmH();
        b(cVar);
        bmG();
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
                            com.baidu.tieba.i.d.a(new File(g.a.fvH + g.a.fvy + oVar.fwf + g.a.fvy + BuildConfig.BUILD_TYPE), oVar.gxL.bmb().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new o(cVar, this.fvI));
        }
    }

    private void bmG() {
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
                            com.baidu.tieba.i.d.a(new File(g.a.fvH + g.a.fvy + eVar.fwf + g.a.fvy + "kpi"), n.b(eVar.isSuccess, eVar.gwR, eVar.gwS).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gxH, this.gwS, this.fvI));
        }
    }

    private void bmH() {
        if (com.baidu.adp.lib.util.f.lk()) {
            File file = new File(g.a.fvH + g.a.fvy + this.fvI + g.a.fvy);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aXc() {
        return b(this.isSuccess, this.gxH, this.gwS);
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

    public JSONObject aXd() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.E(this.gxI)) {
                int size = this.gxI.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gxI.get(i).bmb());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
