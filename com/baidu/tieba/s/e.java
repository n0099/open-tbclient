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
    private List<String> jtf;
    private List<String> jtg;
    private String mCurrentFileName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static final e jti = new e();
    }

    private e() {
        this.jtf = new ArrayList();
        this.jtg = new ArrayList();
        if (f.gB()) {
            ctk();
        }
    }

    private void ctk() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.AR(c.a.cVw);
                com.baidu.tieba.j.d.AR(c.a.hvt);
                com.baidu.tieba.j.d.AR(c.a.hvu);
                com.baidu.tieba.j.d.AR(c.a.hvw);
                com.baidu.tieba.j.d.AR(c.a.hvx);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e ctl() {
        return a.jti;
    }

    public void ctg() {
        if (f.gB()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Fy = e.Fy(c.a.hvv);
                    if (Fy != null) {
                        int size = Fy.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Fy.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Fy(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Fz(com.baidu.tieba.j.d.L(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Fz(String str) {
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
            this.jtf.add(jSONObject.toString());
            String bOX = bOX();
            if (f.gB()) {
                l(jSONObject, bOX);
            }
            if (this.jtf.size() >= com.baidu.tbadk.coreExtra.model.f.apD() || z) {
                a(new d(this.jtf, bOX));
                this.jtf.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String bOX() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.gB()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.hvv + this.mCurrentFileName;
    }

    private void l(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.gB()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.eq(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean eq(String str, String str2) {
        boolean f;
        if (this.jtg.contains(str)) {
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
            if (c.h(c.en(dVar.jtd), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.jte)) {
                m.deleteFile(new File(dVar.jte));
                this.jtg.add(dVar.jte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
