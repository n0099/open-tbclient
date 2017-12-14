package com.baidu.tieba.p;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.i.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static e gPn = new e();
    private String gPk;
    private List<String> gPl = new ArrayList();
    private List<String> gPm = new ArrayList();

    private e() {
        if (f.dG()) {
            bAZ();
        }
    }

    private void bAZ() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.p.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.i.d.oP(c.a.bbq);
                com.baidu.tieba.i.d.oP(c.a.eEl);
                com.baidu.tieba.i.d.oP(c.a.eEm);
                com.baidu.tieba.i.d.oP(c.a.eEo);
                com.baidu.tieba.i.d.oP(c.a.eEp);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bBa() {
        return gPn;
    }

    public void bAV() {
        if (f.dG()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.p.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List tQ = e.tQ(c.a.eEn);
                    if (tQ != null) {
                        int size = tQ.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) tQ.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> tQ(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(tR(com.baidu.tieba.i.d.B(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> tR(String str) {
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

    public synchronized void c(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.gPl.add(jSONObject.toString());
            String aOl = aOl();
            if (f.dG()) {
                b(jSONObject, aOl);
            }
            if (this.gPl.size() >= com.baidu.tbadk.coreExtra.model.f.AE() || z) {
                a(new d(this.gPl, aOl));
                this.gPl.clear();
                this.gPk = null;
            }
        }
    }

    private String aOl() {
        if (StringUtils.isNull(this.gPk)) {
            if (f.dG()) {
                this.gPk = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.eEn + this.gPk;
    }

    private void b(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.dG()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.p.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cl(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cl(String str, String str2) {
        boolean e;
        if (this.gPm.contains(str)) {
            e = false;
        } else {
            File file = new File(str);
            e = com.baidu.tieba.i.d.e(file, str2 + "\n");
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.p.e.4
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
            if (c.e(c.dL(dVar.gPi), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.gPj)) {
                k.deleteFile(new File(dVar.gPj));
                this.gPm.add(dVar.gPj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
