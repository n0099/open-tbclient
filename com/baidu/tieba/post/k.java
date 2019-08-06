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
    private String hwu;
    private boolean isSuccess = true;
    private int iBW = 0;
    private boolean iBi = false;
    private List<com.baidu.tieba.m.c> iBX = new ArrayList();

    static {
        if (com.baidu.adp.lib.util.f.gB()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.post.k.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.j.d.AS(g.a.cVD);
                    com.baidu.tieba.j.d.AS(g.a.hwr);
                    com.baidu.tieba.j.d.AS(g.a.hws);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public k(String str) {
        this.hwu = str;
    }

    public void cgb() {
        this.isSuccess = false;
    }

    public void cgc() {
        this.isSuccess = true;
    }

    public void cgd() {
        this.iBW++;
    }

    public boolean cge() {
        return this.iBW > 0;
    }

    public void cgf() {
        this.iBi = true;
    }

    public boolean cgg() {
        return this.iBi;
    }

    public void a(com.baidu.tieba.m.c cVar) {
        this.iBX.add(cVar);
        cgi();
        b(cVar);
        cgh();
    }

    private void b(com.baidu.tieba.m.c cVar) {
        if (com.baidu.adp.lib.util.f.gB() && cVar != null) {
            new BdAsyncTask<l, Void, Void>() { // from class: com.baidu.tieba.post.k.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(l... lVarArr) {
                    if (lVarArr != null && lVarArr.length == 1 && lVarArr[0] != null) {
                        l lVar = lVarArr[0];
                        synchronized ("debug") {
                            com.baidu.tieba.j.d.a(new File(g.a.hwt + g.a.hwk + lVar.uuid + g.a.hwk + "debug"), lVar.iCa.cfB().toString() + "\n", true);
                        }
                    }
                    return null;
                }
            }.execute(new l(cVar, this.hwu));
        }
    }

    private void cgh() {
        if (com.baidu.adp.lib.util.f.gB()) {
            new BdAsyncTask<e, Void, Void>() { // from class: com.baidu.tieba.post.k.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(e... eVarArr) {
                    if (eVarArr != null && eVarArr.length == 1 && eVarArr[0] != null) {
                        e eVar = eVarArr[0];
                        synchronized ("kpi") {
                            com.baidu.tieba.j.d.a(new File(g.a.hwt + g.a.hwk + eVar.uuid + g.a.hwk + "kpi"), k.e(eVar.isSuccess, eVar.iBh, eVar.iBi).toString(), false);
                        }
                    }
                    return null;
                }
            }.execute(new e(this.isSuccess, this.iBW, this.iBi, this.hwu));
        }
    }

    private void cgi() {
        if (com.baidu.adp.lib.util.f.gB()) {
            File file = new File(g.a.hwt + g.a.hwk + this.hwu + g.a.hwk);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public JSONObject bPd() {
        return e(this.isSuccess, this.iBW, this.iBi);
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

    public JSONObject bPf() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!v.aa(this.iBX)) {
                int size = this.iBX.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.iBX.get(i).cfB());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
