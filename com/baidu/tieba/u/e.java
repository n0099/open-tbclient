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
    private String nEK;
    private List<String> nEL;
    private List<String> nEM;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final e nEO = new e();
    }

    private e() {
        this.nEL = new ArrayList();
        this.nEM = new ArrayList();
        if (f.checkSD()) {
            dTf();
        }
    }

    private void dTf() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.l.d.OO(c.a.lqO);
                com.baidu.tieba.l.d.OO(c.a.lqP);
                com.baidu.tieba.l.d.OO(c.a.lqQ);
                com.baidu.tieba.l.d.OO(c.a.lqS);
                com.baidu.tieba.l.d.OO(c.a.lqT);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dTg() {
        return a.nEO;
    }

    public void dTc() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Ug = e.Ug(c.a.lqR);
                    if (Ug != null) {
                        int size = Ug.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Ug.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Ug(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Uh(com.baidu.tieba.l.d.ad(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Uh(String str) {
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
            this.nEL.add(jSONObject.toString());
            String dTh = dTh();
            if (f.checkSD()) {
                A(jSONObject, dTh);
            }
            if (this.nEL.size() >= g.bCz() || z) {
                a(new d(this.nEL, dTh));
                this.nEL.clear();
                this.nEK = null;
            }
        }
    }

    private String dTh() {
        if (StringUtils.isNull(this.nEK)) {
            if (f.checkSD()) {
                this.nEK = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.lqR + this.nEK;
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
        if (this.nEM.contains(str)) {
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
            if (c.e(c.fY(dVar.nEI), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.nEJ)) {
                n.deleteFile(new File(dVar.nEJ));
                this.nEM.add(dVar.nEJ);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
