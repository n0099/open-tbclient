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
    private String lgv;
    private List<String> lgw;
    private List<String> lgx;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final e lgz = new e();
    }

    private e() {
        this.lgw = new ArrayList();
        this.lgx = new ArrayList();
        if (f.checkSD()) {
            dae();
        }
    }

    private void dae() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.GB(c.a.exz);
                com.baidu.tieba.k.d.GB(c.a.jbz);
                com.baidu.tieba.k.d.GB(c.a.jbA);
                com.baidu.tieba.k.d.GB(c.a.jbC);
                com.baidu.tieba.k.d.GB(c.a.jbD);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e daf() {
        return a.lgz;
    }

    public void dab() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Lx = e.Lx(c.a.jbB);
                    if (Lx != null) {
                        int size = Lx.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Lx.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Lx(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Ly(com.baidu.tieba.k.d.O(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Ly(String str) {
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
            this.lgw.add(jSONObject.toString());
            String csb = csb();
            if (f.checkSD()) {
                r(jSONObject, csb);
            }
            if (this.lgw.size() >= com.baidu.tbadk.coreExtra.model.f.aUA() || z) {
                a(new d(this.lgw, csb));
                this.lgw.clear();
                this.lgv = null;
            }
        }
    }

    private String csb() {
        if (StringUtils.isNull(this.lgv)) {
            if (f.checkSD()) {
                this.lgv = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.jbB + this.lgv;
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
        if (this.lgx.contains(str)) {
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
            if (c.f(c.eC(dVar.lgt), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.lgu)) {
                m.deleteFile(new File(dVar.lgu));
                this.lgx.add(dVar.lgu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
