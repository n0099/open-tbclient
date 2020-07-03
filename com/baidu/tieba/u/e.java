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
    private String lTY;
    private List<String> lTZ;
    private List<String> lUa;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final e lUc = new e();
    }

    private e() {
        this.lTZ = new ArrayList();
        this.lUa = new ArrayList();
        if (f.checkSD()) {
            dlN();
        }
    }

    private void dlN() {
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

    public static e dlO() {
        return a.lUc;
    }

    public void dlK() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List NP = e.NP(c.a.jJf);
                    if (NP != null) {
                        int size = NP.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) NP.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> NP(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(NQ(com.baidu.tieba.k.d.T(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> NQ(String str) {
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
            this.lTZ.add(jSONObject.toString());
            String cCQ = cCQ();
            if (f.checkSD()) {
                z(jSONObject, cCQ);
            }
            if (this.lTZ.size() >= com.baidu.tbadk.coreExtra.model.f.bcL() || z) {
                a(new d(this.lTZ, cCQ));
                this.lTZ.clear();
                this.lTY = null;
            }
        }
    }

    private String cCQ() {
        if (StringUtils.isNull(this.lTY)) {
            if (f.checkSD()) {
                this.lTY = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.jJf + this.lTY;
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
        if (this.lUa.contains(str)) {
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
            if (c.e(c.eY(dVar.lTW), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.lTX)) {
                n.deleteFile(new File(dVar.lTX));
                this.lUa.add(dVar.lTX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
