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
    private static e hse = new e();
    private List<String> hsc = new ArrayList();
    private List<String> hsd = new ArrayList();
    private String mCurrentFileName;

    private e() {
        if (f.hA()) {
            bFu();
        }
    }

    private void bFu() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.rr(c.a.bwt);
                com.baidu.tieba.j.d.rr(c.a.fxj);
                com.baidu.tieba.j.d.rr(c.a.fxk);
                com.baidu.tieba.j.d.rr(c.a.fxm);
                com.baidu.tieba.j.d.rr(c.a.fxn);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bFv() {
        return hse;
    }

    public void bFq() {
        if (f.hA()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List vQ = e.vQ(c.a.fxl);
                    if (vQ != null) {
                        int size = vQ.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) vQ.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> vQ(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(vR(com.baidu.tieba.j.d.H(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> vR(String str) {
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
            this.hsc.add(jSONObject.toString());
            String baW = baW();
            if (f.hA()) {
                j(jSONObject, baW);
            }
            if (this.hsc.size() >= com.baidu.tbadk.coreExtra.model.f.II() || z) {
                a(new d(this.hsc, baW));
                this.hsc.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String baW() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.hA()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fxl + this.mCurrentFileName;
    }

    private void j(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.hA()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cK(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cK(String str, String str2) {
        boolean g;
        if (this.hsd.contains(str)) {
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
            if (c.g(c.dR(dVar.hsa), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hsb)) {
                l.deleteFile(new File(dVar.hsb));
                this.hsd.add(dVar.hsb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
