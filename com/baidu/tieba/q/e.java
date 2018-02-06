package com.baidu.tieba.q;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.i.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static e hnC = new e();
    private List<String> hnA = new ArrayList();
    private List<String> hnB = new ArrayList();
    private String hnz;

    private e() {
        if (f.lk()) {
            bAD();
        }
    }

    private void bAD() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.q.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.i.d.ps(c.a.bRD);
                com.baidu.tieba.i.d.ps(c.a.fvL);
                com.baidu.tieba.i.d.ps(c.a.fvM);
                com.baidu.tieba.i.d.ps(c.a.fvO);
                com.baidu.tieba.i.d.ps(c.a.fvP);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bAE() {
        return hnC;
    }

    public void bAz() {
        if (f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.q.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List ty = e.ty(c.a.fvN);
                    if (ty != null) {
                        int size = ty.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) ty.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> ty(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(tz(com.baidu.tieba.i.d.C(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> tz(String str) {
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
            this.hnA.add(jSONObject.toString());
            String aXh = aXh();
            if (f.lk()) {
                f(jSONObject, aXh);
            }
            if (this.hnA.size() >= com.baidu.tbadk.coreExtra.model.f.IE() || z) {
                a(new d(this.hnA, aXh));
                this.hnA.clear();
                this.hnz = null;
            }
        }
    }

    private String aXh() {
        if (StringUtils.isNull(this.hnz)) {
            if (f.lk()) {
                this.hnz = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fvN + this.hnz;
    }

    private void f(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.lk()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.q.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.ch(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean ch(String str, String str2) {
        boolean e;
        if (this.hnB.contains(str)) {
            e = false;
        } else {
            File file = new File(str);
            e = com.baidu.tieba.i.d.e(file, str2 + "\n");
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.q.e.4
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
            if (c.f(c.dG(dVar.hnx), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hny)) {
                k.deleteFile(new File(dVar.hny));
                this.hnB.add(dVar.hny);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
