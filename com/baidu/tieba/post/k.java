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
/* loaded from: classes23.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int mCt = 0;
    private boolean mBF = false;
    private List<com.baidu.tieba.o.b> mCu = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.l.d.Ph(g.a.lle);
                    com.baidu.tieba.l.d.Ph(g.a.lll);
                    com.baidu.tieba.l.d.Ph(g.a.llm);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dDe() {
        this.isSuccess = false;
    }

    public void dDf() {
        this.isSuccess = true;
    }

    public void dDg() {
        this.mCt++;
    }

    public boolean dDh() {
        return this.mCt > 0;
    }

    public void dDi() {
        this.mBF = true;
    }

    public boolean dDj() {
        return this.mBF;
    }

    public void a(com.baidu.tieba.o.b bVar) {
        this.mCu.add(bVar);
        dDl();
        b(bVar);
        dDk();
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
                            com.baidu.tieba.l.d.a(new File(g.a.lln + g.a.lld + lVar.uuid + g.a.lld + ETAG.KEY_DEBUG), lVar.mCy.dCL().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dDk() {
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
                            com.baidu.tieba.l.d.a(new File(g.a.lln + g.a.lld + eVar.uuid + g.a.lld + "kpi"), k.b(eVar.isSuccess, eVar.mBE, eVar.mBF).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.mCt, this.mBF, this.mUuid));
        }
    }

    private void dDl() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.lln + g.a.lld + this.mUuid + g.a.lld);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject diT() {
        return b(this.isSuccess, this.mCt, this.mBF);
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

    public JSONObject diV() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.mCu)) {
                int size = this.mCu.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mCu.get(i).dCL());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
