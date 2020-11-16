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
/* loaded from: classes22.dex */
public class e {
    private List<String> nmA;
    private String nmy;
    private List<String> nmz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private static final e nmC = new e();
    }

    private e() {
        this.nmz = new ArrayList();
        this.nmA = new ArrayList();
        if (f.checkSD()) {
            dNU();
        }
    }

    private void dNU() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.v.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.l.d.Oa(c.a.kXJ);
                com.baidu.tieba.l.d.Oa(c.a.kXK);
                com.baidu.tieba.l.d.Oa(c.a.kXL);
                com.baidu.tieba.l.d.Oa(c.a.kXN);
                com.baidu.tieba.l.d.Oa(c.a.kXO);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dNV() {
        return a.nmC;
    }

    public void dNR() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.v.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Tl = e.Tl(c.a.kXM);
                    if (Tl != null) {
                        int size = Tl.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Tl.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Tl(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Tm(com.baidu.tieba.l.d.ab(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Tm(String str) {
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
            this.nmz.add(jSONObject.toString());
            String dNW = dNW();
            if (f.checkSD()) {
                A(jSONObject, dNW);
            }
            if (this.nmz.size() >= g.bwD() || z) {
                a(new d(this.nmz, dNW));
                this.nmz.clear();
                this.nmy = null;
            }
        }
    }

    private String dNW() {
        if (StringUtils.isNull(this.nmy)) {
            if (f.checkSD()) {
                this.nmy = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.kXM + this.nmy;
    }

    private void A(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.v.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.gu(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean gu(String str, String str2) {
        boolean i;
        if (this.nmA.contains(str)) {
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
            if (c.e(c.fP(dVar.nmw), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.nmx)) {
                n.deleteFile(new File(dVar.nmx));
                this.nmA.add(dVar.nmx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
