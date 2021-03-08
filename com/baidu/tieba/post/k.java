package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.l.f;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int mOB = 0;
    private boolean mNM = false;
    private List<com.baidu.tieba.n.b> mOC = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.l.d.OC(f.a.lwB);
                    com.baidu.tieba.l.d.OC(f.a.lwI);
                    com.baidu.tieba.l.d.OC(f.a.lwJ);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dBB() {
        this.isSuccess = false;
    }

    public void dBC() {
        this.isSuccess = true;
    }

    public void dBD() {
        this.mOB++;
    }

    public boolean dBE() {
        return this.mOB > 0;
    }

    public void dBF() {
        this.mNM = true;
    }

    public boolean dBG() {
        return this.mNM;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.mOC.add(bVar);
        dBI();
        b(bVar);
        dBH();
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
                            com.baidu.tieba.l.d.a(new File(f.a.lwK + f.a.lwA + lVar.uuid + f.a.lwA + ETAG.KEY_DEBUG), lVar.mOF.dBi().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dBH() {
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
                            com.baidu.tieba.l.d.a(new File(f.a.lwK + f.a.lwA + eVar.uuid + f.a.lwA + "kpi"), k.c(eVar.isSuccess, eVar.mNL, eVar.mNM).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.mOB, this.mNM, this.mUuid));
        }
    }

    private void dBI() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(f.a.lwK + f.a.lwA + this.mUuid + f.a.lwA);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject dhf() {
        return c(this.isSuccess, this.mOB, this.mNM);
    }

    public static final JSONObject c(boolean z, int i, boolean z2) {
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

    public JSONObject dhh() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.mOC)) {
                int size = this.mOC.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mOC.get(i).dBi());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
