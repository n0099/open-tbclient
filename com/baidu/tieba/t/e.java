package com.baidu.tieba.t;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.j.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    private String kpQ;
    private List<String> kpR;
    private List<String> kpS;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final e kpU = new e();
    }

    private e() {
        this.kpR = new ArrayList();
        this.kpS = new ArrayList();
        if (f.checkSD()) {
            cMj();
        }
    }

    private void cMj() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.Et(c.a.dSM);
                com.baidu.tieba.j.d.Et(c.a.ike);
                com.baidu.tieba.j.d.Et(c.a.ikf);
                com.baidu.tieba.j.d.Et(c.a.ikh);
                com.baidu.tieba.j.d.Et(c.a.iki);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e cMk() {
        return a.kpU;
    }

    public void cMf() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Jq = e.Jq(c.a.ikg);
                    if (Jq != null) {
                        int size = Jq.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Jq.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Jq(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Jr(com.baidu.tieba.j.d.K(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Jr(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String[] split = str.split("\n");
        int length = split.length;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            if (!StringUtils.isNull(split[i])) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }

    public synchronized void e(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.kpR.add(jSONObject.toString());
            String cej = cej();
            if (f.checkSD()) {
                o(jSONObject, cej);
            }
            if (this.kpR.size() >= com.baidu.tbadk.coreExtra.model.f.aJi() || z) {
                a(new d(this.kpR, cej));
                this.kpR.clear();
                this.kpQ = null;
            }
        }
    }

    private String cej() {
        if (StringUtils.isNull(this.kpQ)) {
            if (f.checkSD()) {
                this.kpQ = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.ikg + this.kpQ;
    }

    private void o(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.t.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.ew(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean ew(String str, String str2) {
        boolean e;
        if (this.kpS.contains(str)) {
            e = false;
        } else {
            File file = new File(str);
            e = com.baidu.tieba.j.d.e(file, str2 + "\n");
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.t.e.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(d... dVarArr) {
                    if (dVarArr != null && dVarArr.length == 1 && dVarArr[0] != null) {
                        e.this.b(dVarArr[0]);
                    }
                    return null;
                }
            }.execute(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(d dVar) {
        try {
            if (c.f(c.er(dVar.kpO), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.kpP)) {
                m.deleteFile(new File(dVar.kpP));
                this.kpS.add(dVar.kpP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
