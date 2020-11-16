package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.l.g;
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
    private int moo = 0;
    private boolean mnz = false;
    private List<com.baidu.tieba.o.b> mop = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.l.d.Oa(g.a.kXJ);
                    com.baidu.tieba.l.d.Oa(g.a.kXQ);
                    com.baidu.tieba.l.d.Oa(g.a.kXR);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dxM() {
        this.isSuccess = false;
    }

    public void dxN() {
        this.isSuccess = true;
    }

    public void dxO() {
        this.moo++;
    }

    public boolean dxP() {
        return this.moo > 0;
    }

    public void dxQ() {
        this.mnz = true;
    }

    public boolean dxR() {
        return this.mnz;
    }

    public void a(com.baidu.tieba.o.b bVar) {
        this.mop.add(bVar);
        dxT();
        b(bVar);
        dxS();
    }

    private void b(com.baidu.tieba.o.b bVar) {
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
                            com.baidu.tieba.l.d.a(new File(g.a.kXS + g.a.kXI + lVar.uuid + g.a.kXI + ETAG.KEY_DEBUG), lVar.mos.dxt().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dxS() {
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
                            com.baidu.tieba.l.d.a(new File(g.a.kXS + g.a.kXI + eVar.uuid + g.a.kXI + "kpi"), k.b(eVar.isSuccess, eVar.mny, eVar.mnz).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.moo, this.mnz, this.mUuid));
        }
    }

    private void dxT() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.kXS + g.a.kXI + this.mUuid + g.a.kXI);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject ddH() {
        return b(this.isSuccess, this.moo, this.mnz);
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

    public JSONObject ddJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.mop)) {
                int size = this.mop.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mop.get(i).dxt());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
