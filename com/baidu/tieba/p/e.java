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
    private static e gMF = new e();
    private String gMC;
    private List<String> gMD = new ArrayList();
    private List<String> gME = new ArrayList();

    private e() {
        if (f.dG()) {
            bAs();
        }
    }

    private void bAs() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.p.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.i.d.oP(c.a.bbp);
                com.baidu.tieba.i.d.oP(c.a.eDh);
                com.baidu.tieba.i.d.oP(c.a.eDi);
                com.baidu.tieba.i.d.oP(c.a.eDk);
                com.baidu.tieba.i.d.oP(c.a.eDl);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bAt() {
        return gMF;
    }

    public void bAo() {
        if (f.dG()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.p.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List tL = e.tL(c.a.eDj);
                    if (tL != null) {
                        int size = tL.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) tL.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> tL(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(tM(com.baidu.tieba.i.d.C(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> tM(String str) {
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
            this.gMD.add(jSONObject.toString());
            String aOc = aOc();
            if (f.dG()) {
                b(jSONObject, aOc);
            }
            if (this.gMD.size() >= com.baidu.tbadk.coreExtra.model.f.AD() || z) {
                a(new d(this.gMD, aOc));
                this.gMD.clear();
                this.gMC = null;
            }
        }
    }

    private String aOc() {
        if (StringUtils.isNull(this.gMC)) {
            if (f.dG()) {
                this.gMC = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.eDj + this.gMC;
    }

    private void b(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.dG()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.p.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: u */
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.ck(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean ck(String str, String str2) {
        boolean e;
        if (this.gME.contains(str)) {
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
            if (c.e(c.dM(dVar.gMA), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.gMB)) {
                k.s(new File(dVar.gMB));
                this.gME.add(dVar.gMB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
