package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.k.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    private List<String> lgA;
    private List<String> lgB;
    private String lgz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final e lgD = new e();
    }

    private e() {
        this.lgA = new ArrayList();
        this.lgB = new ArrayList();
        if (f.checkSD()) {
            dab();
        }
    }

    private void dab() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.GE(c.a.exE);
                com.baidu.tieba.k.d.GE(c.a.jbD);
                com.baidu.tieba.k.d.GE(c.a.jbE);
                com.baidu.tieba.k.d.GE(c.a.jbG);
                com.baidu.tieba.k.d.GE(c.a.jbH);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dac() {
        return a.lgD;
    }

    public void cZY() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List LA = e.LA(c.a.jbF);
                    if (LA != null) {
                        int size = LA.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) LA.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> LA(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(LB(com.baidu.tieba.k.d.O(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> LB(String str) {
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
            this.lgA.add(jSONObject.toString());
            String crY = crY();
            if (f.checkSD()) {
                r(jSONObject, crY);
            }
            if (this.lgA.size() >= com.baidu.tbadk.coreExtra.model.f.aUy() || z) {
                a(new d(this.lgA, crY));
                this.lgA.clear();
                this.lgz = null;
            }
        }
    }

    private String crY() {
        if (StringUtils.isNull(this.lgz)) {
            if (f.checkSD()) {
                this.lgz = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.jbF + this.lgz;
    }

    private void r(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.eU(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean eU(String str, String str2) {
        boolean g;
        if (this.lgB.contains(str)) {
            g = false;
        } else {
            File file = new File(str);
            g = com.baidu.tieba.k.d.g(file, str2 + "\n");
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.u.e.4
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
            if (c.e(c.eC(dVar.lgx), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.lgy)) {
                m.deleteFile(new File(dVar.lgy));
                this.lgB.add(dVar.lgy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
