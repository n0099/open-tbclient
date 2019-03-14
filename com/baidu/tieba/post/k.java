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
/* loaded from: classes5.dex */
public class k {
    private String gYh;
    private boolean isSuccess = true;
    private int icg = 0;
    private boolean ibs = false;
    private List<com.baidu.tieba.m.c> ich = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.hy()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.yP(g.a.cLK);
                    com.baidu.tieba.j.d.yP(g.a.gYe);
                    com.baidu.tieba.j.d.yP(g.a.gYf);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.gYh = str;
    }

    public void bUS() {
        this.isSuccess = false;
    }

    public void bUT() {
        this.isSuccess = true;
    }

    public void bUU() {
        this.icg++;
    }

    public boolean bUV() {
        return this.icg > 0;
    }

    public void bUW() {
        this.ibs = true;
    }

    public boolean bUX() {
        return this.ibs;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.ich.add(cVar);
        bUZ();
        b(cVar);
        bUY();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.hy() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.gYg + g.a.gXX + lVar.uuid + g.a.gXX + "debug"), lVar.ick.bUs().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.gYh));
        }
    }

    private void bUY() {
        if (com.baidu.adp.lib.util.f.hy()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.gYg + g.a.gXX + eVar.uuid + g.a.gXX + "kpi"), k.e(eVar.isSuccess, eVar.ibr, eVar.ibs).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.icg, this.ibs, this.gYh));
        }
    }

    private void bUZ() {
        if (com.baidu.adp.lib.util.f.hy()) {
            File file = new File(g.a.gYg + g.a.gXX + this.gYh + g.a.gXX);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bEv() {
        return e(this.isSuccess, this.icg, this.ibs);
    }

    public static final JSONObject e(boolean z, int i, boolean z2) {
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

    public JSONObject bEx() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.T(this.ich)) {
                int size = this.ich.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.ich.get(i).bUs());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
