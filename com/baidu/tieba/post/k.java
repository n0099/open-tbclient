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
    private int lxr = 0;
    private boolean lwD = false;
    private List<com.baidu.tieba.n.b> lxs = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.k.d.My(g.a.khm);
                    com.baidu.tieba.k.d.My(g.a.kht);
                    com.baidu.tieba.k.d.My(g.a.khu);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void dll() {
        this.isSuccess = false;
    }

    public void dlm() {
        this.isSuccess = true;
    }

    public void dln() {
        this.lxr++;
    }

    public boolean dlo() {
        return this.lxr > 0;
    }

    public void dlp() {
        this.lwD = true;
    }

    public boolean dlq() {
        return this.lwD;
    }

    public void a(com.baidu.tieba.n.b bVar) {
        this.lxs.add(bVar);
        dls();
        b(bVar);
        dlr();
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
                            com.baidu.tieba.k.d.a(new File(g.a.khv + g.a.khl + lVar.uuid + g.a.khl + ETAG.KEY_DEBUG), lVar.lxv.dkS().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(bVar, this.mUuid));
        }
    }

    private void dlr() {
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
                            com.baidu.tieba.k.d.a(new File(g.a.khv + g.a.khl + eVar.uuid + g.a.khl + "kpi"), k.b(eVar.isSuccess, eVar.lwC, eVar.lwD).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.lxr, this.lwD, this.mUuid));
        }
    }

    private void dls() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.khv + g.a.khl + this.mUuid + g.a.khl);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cRl() {
        return b(this.isSuccess, this.lxr, this.lwD);
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

    public JSONObject cRn() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!y.isEmpty(this.lxs)) {
                int size = this.lxs.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.lxs.get(i).dkS());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
