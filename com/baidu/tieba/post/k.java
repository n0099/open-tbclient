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
/* loaded from: classes17.dex */
public class k {
    private String mUuid;
    private boolean isSuccess = true;
    private int lxg = 0;
    private boolean lws = false;
    private List<com.baidu.tieba.n.b> lxh = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.Mx(g.a.khf);
                    com.baidu.tieba.k.d.Mx(g.a.khm);
                    com.baidu.tieba.k.d.Mx(g.a.khn);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dli() {
        this.isSuccess = false;
    }

    public void dlj() {
        this.isSuccess = true;
    }

    public void dlk() {
        this.lxg++;
    }

    public boolean dll() {
        return this.lxg > 0;
    }

    public void dlm() {
        this.lws = true;
    }

    public boolean dln() {
        return this.lws;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.lxh.add(bVar);
        dlp();
        b(bVar);
        dlo();
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
                            com.baidu.tieba.k.d.a(new File(g.a.kho + g.a.khe + lVar.uuid + g.a.khe + ETAG.KEY_DEBUG), lVar.lxk.dkP().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dlo() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.kho + g.a.khe + eVar.uuid + g.a.khe + "kpi"), k.b(eVar.isSuccess, eVar.lwr, eVar.lws).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.lxg, this.lws, this.mUuid));
        }
    }

    private void dlp() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.kho + g.a.khe + this.mUuid + g.a.khe);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cRk() {
        return b(this.isSuccess, this.lxg, this.lws);
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

    public JSONObject cRm() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.lxh)) {
                int size = this.lxh.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.lxh.get(i).dkP());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
