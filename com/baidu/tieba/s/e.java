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
    private List<String> jwI;
    private List<String> jwJ;
    private String mCurrentFileName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static final e jwL = new e();
    }

    private e() {
        this.jwI = new ArrayList();
        this.jwJ = new ArrayList();
        if (f.gB()) {
            cuu();
        }
    }

    private void cuu() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.Br(c.a.cWw);
                com.baidu.tieba.j.d.Br(c.a.hyf);
                com.baidu.tieba.j.d.Br(c.a.hyg);
                com.baidu.tieba.j.d.Br(c.a.hyi);
                com.baidu.tieba.j.d.Br(c.a.hyj);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e cuv() {
        return a.jwL;
    }

    public void cuq() {
        if (f.gB()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List FZ = e.FZ(c.a.hyh);
                    if (FZ != null) {
                        int size = FZ.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) FZ.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> FZ(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Ga(com.baidu.tieba.j.d.L(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Ga(String str) {
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
            this.jwI.add(jSONObject.toString());
            String bPZ = bPZ();
            if (f.gB()) {
                l(jSONObject, bPZ);
            }
            if (this.jwI.size() >= com.baidu.tbadk.coreExtra.model.f.apR() || z) {
                a(new d(this.jwI, bPZ));
                this.jwI.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String bPZ() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.gB()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.hyh + this.mCurrentFileName;
    }

    private void l(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.gB()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.er(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean er(String str, String str2) {
        boolean f;
        if (this.jwJ.contains(str)) {
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
            if (c.h(c.em(dVar.jwG), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.jwH)) {
                m.deleteFile(new File(dVar.jwH));
                this.jwJ.add(dVar.jwH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
