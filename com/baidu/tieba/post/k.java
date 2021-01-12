package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.l.f;
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
    private int mDd = 0;
    private boolean mCm = false;
    private List<com.baidu.tieba.n.b> mDe = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.l.d.NG(f.a.lme);
                    com.baidu.tieba.l.d.NG(f.a.lml);
                    com.baidu.tieba.l.d.NG(f.a.lmm);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dzc() {
        this.isSuccess = false;
    }

    public void dzd() {
        this.isSuccess = true;
    }

    public void dze() {
        this.mDd++;
    }

    public boolean dzf() {
        return this.mDd > 0;
    }

    public void dzg() {
        this.mCm = true;
    }

    public boolean dzh() {
        return this.mCm;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.mDe.add(bVar);
        dzj();
        b(bVar);
        dzi();
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
                            com.baidu.tieba.l.d.a(new File(f.a.lmn + f.a.lmd + lVar.uuid + f.a.lmd + "debug"), lVar.mDh.dyJ().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dzi() {
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
                            com.baidu.tieba.l.d.a(new File(f.a.lmn + f.a.lmd + eVar.uuid + f.a.lmd + "kpi"), k.d(eVar.isSuccess, eVar.mCl, eVar.mCm).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.mDd, this.mCm, this.mUuid));
        }
    }

    private void dzj() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(f.a.lmn + f.a.lmd + this.mUuid + f.a.lmd);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject deP() {
        return d(this.isSuccess, this.mDd, this.mCm);
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

    public JSONObject deR() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!x.isEmpty(this.mDe)) {
                int size = this.mDe.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mDe.get(i).dyJ());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
