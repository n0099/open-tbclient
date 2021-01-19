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
/* loaded from: classes7.dex */
public class e {
    private String nAg;
    private List<String> nAh;
    private List<String> nAi;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final e nAk = new e();
    }

    private e() {
        this.nAh = new ArrayList();
        this.nAi = new ArrayList();
        if (f.checkSD()) {
            dPn();
        }
    }

    private void dPn() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.l.d.NH(c.a.lme);
                com.baidu.tieba.l.d.NH(c.a.lmf);
                com.baidu.tieba.l.d.NH(c.a.lmg);
                com.baidu.tieba.l.d.NH(c.a.lmi);
                com.baidu.tieba.l.d.NH(c.a.lmj);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dPo() {
        return a.nAk;
    }

    public void dPk() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List SZ = e.SZ(c.a.lmh);
                    if (SZ != null) {
                        int size = SZ.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) SZ.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> SZ(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Ta(com.baidu.tieba.l.d.ac(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Ta(String str) {
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
            this.nAh.add(jSONObject.toString());
            String dPp = dPp();
            if (f.checkSD()) {
                A(jSONObject, dPp);
            }
            if (this.nAh.size() >= g.byF() || z) {
                a(new d(this.nAh, dPp));
                this.nAh.clear();
                this.nAg = null;
            }
        }
    }

    private String dPp() {
        if (StringUtils.isNull(this.nAg)) {
            if (f.checkSD()) {
                this.nAg = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.lmh + this.nAg;
    }

    private void A(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.gv(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean gv(String str, String str2) {
        boolean j;
        if (this.nAi.contains(str)) {
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
            if (c.e(c.fY(dVar.nAe), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.nAf)) {
                n.deleteFile(new File(dVar.nAf));
                this.nAi.add(dVar.nAf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
