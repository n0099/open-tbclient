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
    private int mhV = 0;
    private boolean mhh = false;
    private List<com.baidu.tieba.n.b> mhW = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.On(g.a.kRv);
                    com.baidu.tieba.k.d.On(g.a.kRC);
                    com.baidu.tieba.k.d.On(g.a.kRD);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dvK() {
        this.isSuccess = false;
    }

    public void dvL() {
        this.isSuccess = true;
    }

    public void dvM() {
        this.mhV++;
    }

    public boolean dvN() {
        return this.mhV > 0;
    }

    public void dvO() {
        this.mhh = true;
    }

    public boolean dvP() {
        return this.mhh;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.mhW.add(bVar);
        dvR();
        b(bVar);
        dvQ();
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
                            com.baidu.tieba.k.d.a(new File(g.a.kRE + g.a.kRu + lVar.uuid + g.a.kRu + ETAG.KEY_DEBUG), lVar.mhZ.dvr().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dvQ() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.kRE + g.a.kRu + eVar.uuid + g.a.kRu + "kpi"), k.b(eVar.isSuccess, eVar.mhg, eVar.mhh).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.mhV, this.mhh, this.mUuid));
        }
    }

    private void dvR() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.kRE + g.a.kRu + this.mUuid + g.a.kRu);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject dbI() {
        return b(this.isSuccess, this.mhV, this.mhh);
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

    public JSONObject dbK() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.mhW)) {
                int size = this.mhW.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mhW.get(i).dvr());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
