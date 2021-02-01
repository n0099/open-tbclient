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
    private int mMk = 0;
    private boolean mLv = false;
    private List<com.baidu.tieba.n.b> mMl = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.l.d.Ov(f.a.lul);
                    com.baidu.tieba.l.d.Ov(f.a.lus);
                    com.baidu.tieba.l.d.Ov(f.a.lut);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dBm() {
        this.isSuccess = false;
    }

    public void dBn() {
        this.isSuccess = true;
    }

    public void dBo() {
        this.mMk++;
    }

    public boolean dBp() {
        return this.mMk > 0;
    }

    public void dBq() {
        this.mLv = true;
    }

    public boolean dBr() {
        return this.mLv;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.mMl.add(bVar);
        dBt();
        b(bVar);
        dBs();
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
                            com.baidu.tieba.l.d.a(new File(f.a.luu + f.a.luk + lVar.uuid + f.a.luk + "debug"), lVar.mMo.dAT().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dBs() {
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
                            com.baidu.tieba.l.d.a(new File(f.a.luu + f.a.luk + eVar.uuid + f.a.luk + "kpi"), k.d(eVar.isSuccess, eVar.mLu, eVar.mLv).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.mMk, this.mLv, this.mUuid));
        }
    }

    private void dBt() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(f.a.luu + f.a.luk + this.mUuid + f.a.luk);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject dgP() {
        return d(this.isSuccess, this.mMk, this.mLv);
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

    public JSONObject dgR() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.mMl)) {
                int size = this.mMl.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mMl.get(i).dAT());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
