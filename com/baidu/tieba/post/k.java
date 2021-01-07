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
/* loaded from: classes8.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int mHK = 0;
    private boolean mGV = false;
    private List<com.baidu.tieba.n.b> mHL = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.l.d.OO(f.a.lqO);
                    com.baidu.tieba.l.d.OO(f.a.lqV);
                    com.baidu.tieba.l.d.OO(f.a.lqW);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dCU() {
        this.isSuccess = false;
    }

    public void dCV() {
        this.isSuccess = true;
    }

    public void dCW() {
        this.mHK++;
    }

    public boolean dCX() {
        return this.mHK > 0;
    }

    public void dCY() {
        this.mGV = true;
    }

    public boolean dCZ() {
        return this.mGV;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.mHL.add(bVar);
        dDb();
        b(bVar);
        dDa();
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
                            com.baidu.tieba.l.d.a(new File(f.a.lqX + f.a.lqN + lVar.uuid + f.a.lqN + "debug"), lVar.mHO.dCB().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dDa() {
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
                            com.baidu.tieba.l.d.a(new File(f.a.lqX + f.a.lqN + eVar.uuid + f.a.lqN + "kpi"), k.d(eVar.isSuccess, eVar.mGU, eVar.mGV).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.mHK, this.mGV, this.mUuid));
        }
    }

    private void dDb() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(f.a.lqX + f.a.lqN + this.mUuid + f.a.lqN);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject diH() {
        return d(this.isSuccess, this.mHK, this.mGV);
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

    public JSONObject diJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!x.isEmpty(this.mHL)) {
                int size = this.mHL.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.mHL.get(i).dCB());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
