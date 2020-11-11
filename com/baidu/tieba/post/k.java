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
    private int mnT = 0;
    private boolean mnf = false;
    private List<com.baidu.tieba.n.b> mnU = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.OE(g.a.kXr);
                    com.baidu.tieba.k.d.OE(g.a.kXy);
                    com.baidu.tieba.k.d.OE(g.a.kXz);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dym() {
        this.isSuccess = false;
    }

    public void dyn() {
        this.isSuccess = true;
    }

    public void dyo() {
        this.mnT++;
    }

    public boolean dyp() {
        return this.mnT > 0;
    }

    public void dyq() {
        this.mnf = true;
    }

    public boolean dyr() {
        return this.mnf;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.mnU.add(bVar);
        dyt();
        b(bVar);
        dys();
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
                            com.baidu.tieba.k.d.a(new File(g.a.kXA + g.a.kXq + lVar.uuid + g.a.kXq + ETAG.KEY_DEBUG), lVar.mnX.dxT().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dys() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.kXA + g.a.kXq + eVar.uuid + g.a.kXq + "kpi"), k.b(eVar.isSuccess, eVar.mne, eVar.mnf).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.mnT, this.mnf, this.mUuid));
        }
    }

    private void dyt() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.kXA + g.a.kXq + this.mUuid + g.a.kXq);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject dek() {
        return b(this.isSuccess, this.mnT, this.mnf);
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

    public JSONObject dem() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.mnU)) {
                int size = this.mnU.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mnU.get(i).dxT());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
