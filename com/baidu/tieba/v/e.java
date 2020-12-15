package com.baidu.tieba.v;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tieba.l.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class e {
    private String nAD;
    private List<String> nAE;
    private List<String> nAF;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a {
        private static final e nAH = new e();
    }

    private e() {
        this.nAE = new ArrayList();
        this.nAF = new ArrayList();
        if (f.checkSD()) {
            dTn();
        }
    }

    private void dTn() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.v.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.l.d.Ph(c.a.lle);
                com.baidu.tieba.l.d.Ph(c.a.llf);
                com.baidu.tieba.l.d.Ph(c.a.llg);
                com.baidu.tieba.l.d.Ph(c.a.lli);
                com.baidu.tieba.l.d.Ph(c.a.llj);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dTo() {
        return a.nAH;
    }

    public void dTk() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.v.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List UA = e.UA(c.a.llh);
                    if (UA != null) {
                        int size = UA.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) UA.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> UA(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(UB(com.baidu.tieba.l.d.aa(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> UB(String str) {
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
            this.nAE.add(jSONObject.toString());
            String dTp = dTp();
            if (f.checkSD()) {
                A(jSONObject, dTp);
            }
            if (this.nAE.size() >= g.bAd() || z) {
                a(new d(this.nAE, dTp));
                this.nAE.clear();
                this.nAD = null;
            }
        }
    }

    private String dTp() {
        if (StringUtils.isNull(this.nAD)) {
            if (f.checkSD()) {
                this.nAD = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.llh + this.nAD;
    }

    private void A(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.v.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.gz(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean gz(String str, String str2) {
        boolean i;
        if (this.nAF.contains(str)) {
            i = false;
        } else {
            File file = new File(str);
            i = com.baidu.tieba.l.d.i(file, str2 + "\n");
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.v.e.4
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
            if (c.e(c.gd(dVar.nAB), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.nAC)) {
                n.deleteFile(new File(dVar.nAC));
                this.nAF.add(dVar.nAC);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
