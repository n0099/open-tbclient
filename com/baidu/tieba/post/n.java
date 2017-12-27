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
    private String fqx;
    private boolean isSuccess = true;
    private int gGJ = 0;
    private boolean gFU = false;
    private List<c> gGK = new ArrayList();

    static {
        if (f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.n.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    d.oZ(g.a.bPf);
                    d.oZ(g.a.fqu);
                    d.oZ(g.a.fqv);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public n(String str) {
        this.fqx = str;
    }

    public void brU() {
        this.isSuccess = false;
    }

    public void brV() {
        this.isSuccess = true;
    }

    public void brW() {
        this.gGJ++;
    }

    public boolean brX() {
        return this.gGJ > 0;
    }

    public void brY() {
        this.gFU = true;
    }

    public boolean brZ() {
        return this.gFU;
    }

    public void a(c cVar) {
        this.gGK.add(cVar);
        bsb();
        b(cVar);
        bsa();
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
                            d.a(new File(g.a.fqw + g.a.fqn + oVar.fqU + g.a.fqn + "debug"), oVar.gGN.brv().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new o(cVar, this.fqx));
        }
    }

    private void bsa() {
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
                            d.a(new File(g.a.fqw + g.a.fqn + eVar.fqU + g.a.fqn + "kpi"), n.b(eVar.isSuccess, eVar.gFT, eVar.gFU).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.gGJ, this.gFU, this.fqx));
        }
    }

    private void bsb() {
        if (f.lk()) {
            File file = new File(g.a.fqw + g.a.fqn + this.fqx + g.a.fqn);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject aVk() {
        return b(this.isSuccess, this.gGJ, this.gFU);
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

    public JSONObject aVl() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.G(this.gGK)) {
                int size = this.gGK.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gGK.get(i).brv());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
