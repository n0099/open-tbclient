package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.l.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int mMz = 0;
    private boolean mLK = false;
    private List<com.baidu.tieba.n.b> mMA = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.l.d.Ow(f.a.luz);
                    com.baidu.tieba.l.d.Ow(f.a.luG);
                    com.baidu.tieba.l.d.Ow(f.a.luH);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dBt() {
        this.isSuccess = false;
    }

    public void dBu() {
        this.isSuccess = true;
    }

    public void dBv() {
        this.mMz++;
    }

    public boolean dBw() {
        return this.mMz > 0;
    }

    public void dBx() {
        this.mLK = true;
    }

    public boolean dBy() {
        return this.mLK;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.mMA.add(bVar);
        dBA();
        b(bVar);
        dBz();
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
                        synchronized ("debug") {
                            com.baidu.tieba.l.d.a(new File(f.a.luI + f.a.luy + lVar.uuid + f.a.luy + "debug"), lVar.mMD.dBa().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dBz() {
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
                            com.baidu.tieba.l.d.a(new File(f.a.luI + f.a.luy + eVar.uuid + f.a.luy + "kpi"), k.d(eVar.isSuccess, eVar.mLJ, eVar.mLK).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.mMz, this.mLK, this.mUuid));
        }
    }

    private void dBA() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(f.a.luI + f.a.luy + this.mUuid + f.a.luy);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject dgW() {
        return d(this.isSuccess, this.mMz, this.mLK);
    }

    public static final JSONObject d(boolean z, int i, boolean z2) {
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

    public JSONObject dgY() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.mMA)) {
                int size = this.mMA.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mMA.get(i).dBa());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
