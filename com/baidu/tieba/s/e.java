package com.baidu.tieba.s;

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
/* loaded from: classes5.dex */
public class e {
    private String jvI;
    private List<String> jvJ;
    private List<String> jvK;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static final e jvM = new e();
    }

    private e() {
        this.jvJ = new ArrayList();
        this.jvK = new ArrayList();
        if (f.checkSD()) {
            csh();
        }
    }

    private void csh() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.zL(c.a.dfa);
                com.baidu.tieba.j.d.zL(c.a.hwc);
                com.baidu.tieba.j.d.zL(c.a.hwd);
                com.baidu.tieba.j.d.zL(c.a.hwf);
                com.baidu.tieba.j.d.zL(c.a.hwg);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e csi() {
        return a.jvM;
    }

    public void csd() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List EB = e.EB(c.a.hwe);
                    if (EB != null) {
                        int size = EB.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) EB.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> EB(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(EC(com.baidu.tieba.j.d.x(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> EC(String str) {
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

    public synchronized void d(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.jvJ.add(jSONObject.toString());
            String bMX = bMX();
            if (f.checkSD()) {
                l(jSONObject, bMX);
            }
            if (this.jvJ.size() >= com.baidu.tbadk.coreExtra.model.f.arJ() || z) {
                a(new d(this.jvJ, bMX));
                this.jvJ.clear();
                this.jvI = null;
            }
        }
    }

    private String bMX() {
        if (StringUtils.isNull(this.jvI)) {
            if (f.checkSD()) {
                this.jvI = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.hwe + this.jvI;
    }

    private void l(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.ed(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean ed(String str, String str2) {
        boolean c;
        if (this.jvK.contains(str)) {
            c = false;
        } else {
            File file = new File(str);
            c = com.baidu.tieba.j.d.c(file, str2 + "\n");
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.s.e.4
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
            if (c.f(c.ez(dVar.jvG), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.jvH)) {
                m.deleteFile(new File(dVar.jvH));
                this.jvK.add(dVar.jvH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
