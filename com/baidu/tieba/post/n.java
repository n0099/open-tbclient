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
    private String frY;
    private boolean isSuccess = true;
    private int gvS = 0;
    private boolean gvd = false;
    private List<c> gvT = new ArrayList();

    static {
        if (f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.n.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    d.pc(g.a.bPm);
                    d.pc(g.a.frV);
                    d.pc(g.a.frW);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public n(String str) {
        this.frY = str;
    }

    public void bln() {
        this.isSuccess = false;
    }

    public void blo() {
        this.isSuccess = true;
    }

    public void blp() {
        this.gvS++;
    }

    public boolean blq() {
        return this.gvS > 0;
    }

    public void blr() {
        this.gvd = true;
    }

    public boolean bls() {
        return this.gvd;
    }

    public void a(c cVar) {
        this.gvT.add(cVar);
        blu();
        b(cVar);
        blt();
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
                            d.a(new File(g.a.frX + g.a.frO + oVar.fsv + g.a.frO + "debug"), oVar.gvW.bkO().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new o(cVar, this.frY));
        }
    }

    private void blt() {
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
                            d.a(new File(g.a.frX + g.a.frO + eVar.fsv + g.a.frO + "kpi"), n.b(eVar.isSuccess, eVar.gvc, eVar.gvd).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gvS, this.gvd, this.frY));
        }
    }

    private void blu() {
        if (f.lk()) {
            File file = new File(g.a.frX + g.a.frO + this.frY + g.a.frO);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aVp() {
        return b(this.isSuccess, this.gvS, this.gvd);
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

    public JSONObject aVq() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.E(this.gvT)) {
                int size = this.gvT.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gvT.get(i).bkO());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
