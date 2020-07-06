package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.k.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    private String lUb;
    private List<String> lUc;
    private List<String> lUd;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final e lUf = new e();
    }

    private e() {
        this.lUc = new ArrayList();
        this.lUd = new ArrayList();
        if (f.checkSD()) {
            dlR();
        }
    }

    private void dlR() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.IQ(c.a.eWD);
                com.baidu.tieba.k.d.IQ(c.a.jJd);
                com.baidu.tieba.k.d.IQ(c.a.jJe);
                com.baidu.tieba.k.d.IQ(c.a.jJg);
                com.baidu.tieba.k.d.IQ(c.a.jJh);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dlS() {
        return a.lUf;
    }

    public void dlO() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List NQ = e.NQ(c.a.jJf);
                    if (NQ != null) {
                        int size = NQ.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) NQ.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> NQ(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(NR(com.baidu.tieba.k.d.T(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> NR(String str) {
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

    public synchronized void g(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.lUc.add(jSONObject.toString());
            String cCR = cCR();
            if (f.checkSD()) {
                z(jSONObject, cCR);
            }
            if (this.lUc.size() >= com.baidu.tbadk.coreExtra.model.f.bcL() || z) {
                a(new d(this.lUc, cCR));
                this.lUc.clear();
                this.lUb = null;
            }
        }
    }

    private String cCR() {
        if (StringUtils.isNull(this.lUb)) {
            if (f.checkSD()) {
                this.lUb = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.jJf + this.lUb;
    }

    private void z(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.fC(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean fC(String str, String str2) {
        boolean g;
        if (this.lUd.contains(str)) {
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
            if (c.e(c.eY(dVar.lTZ), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.lUa)) {
                n.deleteFile(new File(dVar.lUa));
                this.lUd.add(dVar.lUa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
