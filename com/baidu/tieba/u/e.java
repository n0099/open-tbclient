package com.baidu.tieba.u;

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
/* loaded from: classes8.dex */
public class e {
    private String nEL;
    private List<String> nEM;
    private List<String> nEN;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final e nEP = new e();
    }

    private e() {
        this.nEM = new ArrayList();
        this.nEN = new ArrayList();
        if (f.checkSD()) {
            dTe();
        }
    }

    private void dTe() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.l.d.OP(c.a.lqO);
                com.baidu.tieba.l.d.OP(c.a.lqP);
                com.baidu.tieba.l.d.OP(c.a.lqQ);
                com.baidu.tieba.l.d.OP(c.a.lqS);
                com.baidu.tieba.l.d.OP(c.a.lqT);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dTf() {
        return a.nEP;
    }

    public void dTb() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Uh = e.Uh(c.a.lqR);
                    if (Uh != null) {
                        int size = Uh.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Uh.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Uh(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Ui(com.baidu.tieba.l.d.ad(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Ui(String str) {
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
            this.nEM.add(jSONObject.toString());
            String dTg = dTg();
            if (f.checkSD()) {
                A(jSONObject, dTg);
            }
            if (this.nEM.size() >= g.bCy() || z) {
                a(new d(this.nEM, dTg));
                this.nEM.clear();
                this.nEL = null;
            }
        }
    }

    private String dTg() {
        if (StringUtils.isNull(this.nEL)) {
            if (f.checkSD()) {
                this.nEL = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.lqR + this.nEL;
    }

    private void A(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.gw(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean gw(String str, String str2) {
        boolean j;
        if (this.nEN.contains(str)) {
            j = false;
        } else {
            File file = new File(str);
            j = com.baidu.tieba.l.d.j(file, str2 + "\n");
        }
        return j;
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
            if (c.e(c.fY(dVar.nEJ), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.nEK)) {
                n.deleteFile(new File(dVar.nEK));
                this.nEN.add(dVar.nEK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
