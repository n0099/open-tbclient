package com.baidu.tieba.s;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.j.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private List<String> hzo;
    private List<String> hzp;
    private String mCurrentFileName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static final e hzr = new e();
    }

    private e() {
        this.hzo = new ArrayList();
        this.hzp = new ArrayList();
        if (f.hA()) {
            bHx();
        }
    }

    private void bHx() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.rT(c.a.bzQ);
                com.baidu.tieba.j.d.rT(c.a.fDZ);
                com.baidu.tieba.j.d.rT(c.a.fEa);
                com.baidu.tieba.j.d.rT(c.a.fEc);
                com.baidu.tieba.j.d.rT(c.a.fEd);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bHy() {
        return a.hzr;
    }

    public void bHt() {
        if (f.hA()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List wt = e.wt(c.a.fEb);
                    if (wt != null) {
                        int size = wt.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) wt.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> wt(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(wu(com.baidu.tieba.j.d.I(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> wu(String str) {
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

    public synchronized void b(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.hzo.add(jSONObject.toString());
            String bcM = bcM();
            if (f.hA()) {
                j(jSONObject, bcM);
            }
            if (this.hzo.size() >= com.baidu.tbadk.coreExtra.model.f.JM() || z) {
                a(new d(this.hzo, bcM));
                this.hzo.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String bcM() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.hA()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fEb + this.mCurrentFileName;
    }

    private void j(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.hA()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cP(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cP(String str, String str2) {
        boolean g;
        if (this.hzp.contains(str)) {
            g = false;
        } else {
            File file = new File(str);
            g = com.baidu.tieba.j.d.g(file, str2 + "\n");
        }
        return g;
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
            if (c.g(c.dV(dVar.hzm), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hzn)) {
                l.deleteFile(new File(dVar.hzn));
                this.hzp.add(dVar.hzn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
