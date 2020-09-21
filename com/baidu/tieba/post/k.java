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
/* loaded from: classes22.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int lGi = 0;
    private boolean lFu = false;
    private List<com.baidu.tieba.n.b> lGj = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.Na(g.a.kpM);
                    com.baidu.tieba.k.d.Na(g.a.kpT);
                    com.baidu.tieba.k.d.Na(g.a.kpU);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void doS() {
        this.isSuccess = false;
    }

    public void doT() {
        this.isSuccess = true;
    }

    public void doU() {
        this.lGi++;
    }

    public boolean doV() {
        return this.lGi > 0;
    }

    public void doW() {
        this.lFu = true;
    }

    public boolean doX() {
        return this.lFu;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.lGj.add(bVar);
        doZ();
        b(bVar);
        doY();
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
                            com.baidu.tieba.k.d.a(new File(g.a.kpV + g.a.kpL + lVar.uuid + g.a.kpL + ETAG.KEY_DEBUG), lVar.lGm.doz().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void doY() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.kpV + g.a.kpL + eVar.uuid + g.a.kpL + "kpi"), k.b(eVar.isSuccess, eVar.lFt, eVar.lFu).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.lGi, this.lFu, this.mUuid));
        }
    }

    private void doZ() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.kpV + g.a.kpL + this.mUuid + g.a.kpL);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cUR() {
        return b(this.isSuccess, this.lGi, this.lFu);
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

    public JSONObject cUT() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.lGj)) {
                int size = this.lGj.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.lGj.get(i).doz());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
