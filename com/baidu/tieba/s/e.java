package com.baidu.tieba.s;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.j.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {
    private List<String> jmY;
    private List<String> jmZ;
    private String mCurrentFileName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static final e jnb = new e();
    }

    private e() {
        this.jmY = new ArrayList();
        this.jmZ = new ArrayList();
        if (f.gs()) {
            cqA();
        }
    }

    private void cqA() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.Ag(c.a.cUa);
                com.baidu.tieba.j.d.Ag(c.a.hph);
                com.baidu.tieba.j.d.Ag(c.a.hpi);
                com.baidu.tieba.j.d.Ag(c.a.hpk);
                com.baidu.tieba.j.d.Ag(c.a.hpl);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e cqB() {
        return a.jnb;
    }

    public void cqw() {
        if (f.gs()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List EK = e.EK(c.a.hpj);
                    if (EK != null) {
                        int size = EK.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) EK.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> EK(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(EL(com.baidu.tieba.j.d.L(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> EL(String str) {
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
            this.jmY.add(jSONObject.toString());
            String bMp = bMp();
            if (f.gs()) {
                l(jSONObject, bMp);
            }
            if (this.jmY.size() >= com.baidu.tbadk.coreExtra.model.f.aox() || z) {
                a(new d(this.jmY, bMp));
                this.jmY.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String bMp() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.gs()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.hpj + this.mCurrentFileName;
    }

    private void l(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.gs()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.ep(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean ep(String str, String str2) {
        boolean f;
        if (this.jmZ.contains(str)) {
            f = false;
        } else {
            File file = new File(str);
            f = com.baidu.tieba.j.d.f(file, str2 + "\n");
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.s.e.4
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
            if (c.h(c.ek(dVar.jmW), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.jmX)) {
                m.deleteFile(new File(dVar.jmX));
                this.jmZ.add(dVar.jmX);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
