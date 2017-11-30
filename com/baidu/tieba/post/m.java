package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.i.g;
import com.baidu.tieba.l.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m {
    private String eDq;
    private boolean isSuccess = true;
    private int fRX = 0;
    private boolean fRl = false;
    private List<c> fRY = new ArrayList();

    static {
        if (f.dG()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.m.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.i.d.oP(g.a.bbp);
                    com.baidu.tieba.i.d.oP(g.a.eDn);
                    com.baidu.tieba.i.d.oP(g.a.eDo);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public m(String str) {
        this.eDq = str;
    }

    public void bkf() {
        this.isSuccess = false;
    }

    public void bkg() {
        this.isSuccess = true;
    }

    public void bkh() {
        this.fRX++;
    }

    public boolean bki() {
        return this.fRX > 0;
    }

    public void bkj() {
        this.fRl = true;
    }

    public boolean bkk() {
        return this.fRl;
    }

    public void a(c cVar) {
        this.fRY.add(cVar);
        bkm();
        b(cVar);
        bkl();
    }

    private void b(c cVar) {
        if (f.dG() && cVar != null) {
            new BdAsyncTask<n, Void, Void>() { // from class: com.baidu.tieba.post.m.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(n... nVarArr) {
                    if (nVarArr != null && nVarArr.length == 1 && nVarArr[0] != null) {
                        n nVar = nVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.i.d.a(new File(g.a.eDp + g.a.eDg + nVar.eDN + g.a.eDg + "debug"), nVar.fSb.bjI().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new n(cVar, this.eDq));
        }
    }

    private void bkl() {
        if (f.dG()) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.post.m.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(d... dVarArr) {
                    if (dVarArr != null && dVarArr.length == 1 && dVarArr[0] != null) {
                        d dVar = dVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.i.d.a(new File(g.a.eDp + g.a.eDg + dVar.eDN + g.a.eDg + "kpi"), m.a(dVar.isSuccess, dVar.fRk, dVar.fRl).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new d(this.isSuccess, this.fRX, this.fRl, this.eDq));
        }
    }

    private void bkm() {
        if (f.dG()) {
            File file = new File(g.a.eDp + g.a.eDg + this.eDq + g.a.eDg);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aNY() {
        return a(this.isSuccess, this.fRX, this.fRl);
    }

    public static final JSONObject a(boolean z, int i, boolean z2) {
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

    public JSONObject aNZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.w(this.fRY)) {
                int size = this.fRY.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.fRY.get(i).bjI());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
