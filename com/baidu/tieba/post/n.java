package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.i.d;
import com.baidu.tieba.i.g;
import com.baidu.tieba.l.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private String fst;
    private boolean isSuccess = true;
    private int gwn = 0;
    private boolean gvy = false;
    private List<c> gwo = new ArrayList();

    static {
        if (f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.n.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    d.pj(g.a.bPv);
                    d.pj(g.a.fsq);
                    d.pj(g.a.fsr);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public n(String str) {
        this.fst = str;
    }

    public void blo() {
        this.isSuccess = false;
    }

    public void blp() {
        this.isSuccess = true;
    }

    public void blq() {
        this.gwn++;
    }

    public boolean blr() {
        return this.gwn > 0;
    }

    public void bls() {
        this.gvy = true;
    }

    public boolean blt() {
        return this.gvy;
    }

    public void a(c cVar) {
        this.gwo.add(cVar);
        blv();
        b(cVar);
        blu();
    }

    private void b(c cVar) {
        if (f.lk() && cVar != null) {
            new BdAsyncTask<o, Void, Void>() { // from class: com.baidu.tieba.post.n.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(o... oVarArr) {
                    if (oVarArr != null && oVarArr.length == 1 && oVarArr[0] != null) {
                        o oVar = oVarArr[0];
                        synchronized ("debug") {
                            d.a(new File(g.a.fss + g.a.fsj + oVar.fsQ + g.a.fsj + "debug"), oVar.gwr.bkP().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new o(cVar, this.fst));
        }
    }

    private void blu() {
        if (f.lk()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.n.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            d.a(new File(g.a.fss + g.a.fsj + eVar.fsQ + g.a.fsj + "kpi"), n.b(eVar.isSuccess, eVar.gvx, eVar.gvy).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gwn, this.gvy, this.fst));
        }
    }

    private void blv() {
        if (f.lk()) {
            File file = new File(g.a.fss + g.a.fsj + this.fst + g.a.fsj);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aVu() {
        return b(this.isSuccess, this.gwn, this.gvy);
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

    public JSONObject aVv() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.E(this.gwo)) {
                int size = this.gwo.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gwo.get(i).bkP());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
