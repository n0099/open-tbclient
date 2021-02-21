package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tieba.l.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    private String nKq;
    private List<String> nKr;
    private List<String> nKs;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final e nKu = new e();
    }

    private e() {
        this.nKr = new ArrayList();
        this.nKs = new ArrayList();
        if (f.checkSD()) {
            dRG();
        }
    }

    private void dRG() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.l.d.Ow(c.a.luz);
                com.baidu.tieba.l.d.Ow(c.a.luA);
                com.baidu.tieba.l.d.Ow(c.a.luB);
                com.baidu.tieba.l.d.Ow(c.a.luD);
                com.baidu.tieba.l.d.Ow(c.a.luE);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dRH() {
        return a.nKu;
    }

    public void dRD() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Ui = e.Ui(c.a.luC);
                    if (Ui != null) {
                        int size = Ui.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Ui.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Ui(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Uj(com.baidu.tieba.l.d.Z(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Uj(String str) {
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

    public synchronized void i(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.nKr.add(jSONObject.toString());
            String dRI = dRI();
            if (f.checkSD()) {
                A(jSONObject, dRI);
            }
            if (this.nKr.size() >= g.byX() || z) {
                a(new d(this.nKr, dRI));
                this.nKr.clear();
                this.nKq = null;
            }
        }
    }

    private String dRI() {
        if (StringUtils.isNull(this.nKq)) {
            if (f.checkSD()) {
                this.nKq = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.luC + this.nKq;
    }

    private void A(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.gD(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean gD(String str, String str2) {
        boolean i;
        if (this.nKs.contains(str)) {
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
            if (c.f(c.fW(dVar.nKo), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.nKp)) {
                o.deleteFile(new File(dVar.nKp));
                this.nKs.add(dVar.nKp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
