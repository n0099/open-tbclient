package com.baidu.tieba.r;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.j.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static e gJv = new e();
    private String gJs;
    private List<String> gJt = new ArrayList();
    private List<String> gJu = new ArrayList();

    private e() {
        if (f.m9do()) {
            bvI();
        }
    }

    private void bvI() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.r.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.py(c.a.bbq);
                com.baidu.tieba.j.d.py(c.a.eQA);
                com.baidu.tieba.j.d.py(c.a.eQB);
                com.baidu.tieba.j.d.py(c.a.eQD);
                com.baidu.tieba.j.d.py(c.a.eQE);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bvJ() {
        return gJv;
    }

    public void bvF() {
        if (f.m9do()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.r.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List tF = e.tF(c.a.eQC);
                    if (tF != null) {
                        int size = tF.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) tF.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> tF(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(tG(com.baidu.tieba.j.d.B(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> tG(String str) {
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
            this.gJt.add(jSONObject.toString());
            String aSc = aSc();
            if (f.m9do()) {
                h(jSONObject, aSc);
            }
            if (this.gJt.size() >= com.baidu.tbadk.coreExtra.model.f.Bs() || z) {
                a(new d(this.gJt, aSc));
                this.gJt.clear();
                this.gJs = null;
            }
        }
    }

    private String aSc() {
        if (StringUtils.isNull(this.gJs)) {
            if (f.m9do()) {
                this.gJs = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.eQC + this.gJs;
    }

    private void h(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.m9do()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.r.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cg(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cg(String str, String str2) {
        boolean e;
        if (this.gJu.contains(str)) {
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
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.r.e.4
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
            if (c.f(c.dx(dVar.gJq), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.gJr)) {
                k.deleteFile(new File(dVar.gJr));
                this.gJu.add(dVar.gJr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
