package com.baidu.tieba.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.j.g;
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
    private int jwc = 0;
    private boolean jvo = false;
    private List<com.baidu.tieba.m.c> jwd = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.Et(g.a.dSM);
                    com.baidu.tieba.j.d.Et(g.a.ikk);
                    com.baidu.tieba.j.d.Et(g.a.ikl);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.mUuid = str;
    }

    public void cxG() {
        this.isSuccess = false;
    }

    public void cxH() {
        this.isSuccess = true;
    }

    public void cxI() {
        this.jwc++;
    }

    public boolean cxJ() {
        return this.jwc > 0;
    }

    public void cxK() {
        this.jvo = true;
    }

    public boolean cxL() {
        return this.jvo;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.jwd.add(cVar);
        cxN();
        b(cVar);
        cxM();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.checkSD() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.ikm + g.a.ikd + lVar.uuid + g.a.ikd + "debug"), lVar.jwg.cxi().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.mUuid));
        }
    }

    private void cxM() {
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
                            com.baidu.tieba.j.d.a(new File(g.a.ikm + g.a.ikd + eVar.uuid + g.a.ikd + "kpi"), k.c(eVar.isSuccess, eVar.jvn, eVar.jvo).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.jwc, this.jvo, this.mUuid));
        }
    }

    private void cxN() {
        if (com.baidu.adp.lib.util.f.checkSD()) {
            File file = new File(g.a.ikm + g.a.ikd + this.mUuid + g.a.ikd);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject cea() {
        return c(this.isSuccess, this.jwc, this.jvo);
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

    public JSONObject cec() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.isEmpty(this.jwd)) {
                int size = this.jwd.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.jwd.get(i).cxi());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
