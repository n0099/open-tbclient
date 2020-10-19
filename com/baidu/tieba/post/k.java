package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.k.g;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int lVw = 0;
    private boolean lUI = false;
    private List<com.baidu.tieba.n.b> lVx = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.NP(g.a.kEY);
                    com.baidu.tieba.k.d.NP(g.a.kFf);
                    com.baidu.tieba.k.d.NP(g.a.kFg);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dsD() {
        this.isSuccess = false;
    }

    public void dsE() {
        this.isSuccess = true;
    }

    public void dsF() {
        this.lVw++;
    }

    public boolean dsG() {
        return this.lVw > 0;
    }

    public void dsH() {
        this.lUI = true;
    }

    public boolean dsI() {
        return this.lUI;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.lVx.add(bVar);
        dsK();
        b(bVar);
        dsJ();
    }

    private void b(com.baidu.tieba.n.b bVar) {
        if (com.baidu.adp.lib.util.f.checkSD() && bVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized (ETAG.KEY_DEBUG) {
                            com.baidu.tieba.k.d.a(new File(g.a.kFh + g.a.kEX + lVar.uuid + g.a.kEX + ETAG.KEY_DEBUG), lVar.lVA.dsk().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dsJ() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.kFh + g.a.kEX + eVar.uuid + g.a.kEX + "kpi"), k.b(eVar.isSuccess, eVar.lUH, eVar.lUI).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.lVw, this.lUI, this.mUuid));
        }
    }

    private void dsK() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.kFh + g.a.kEX + this.mUuid + g.a.kEX);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cYA() {
        return b(this.isSuccess, this.lVw, this.lUI);
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

    public JSONObject cYC() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.lVx)) {
                int size = this.lVx.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.lVx.get(i).dsk());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
