package com.baidu.tieba.t;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.j.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private List<String> hDG;
    private List<String> hDH;
    private String mCurrentFileName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static final e hDJ = new e();
    }

    private e() {
        this.hDG = new ArrayList();
        this.hDH = new ArrayList();
        if (f.hA()) {
            bIW();
        }
    }

    private void bIW() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.sm(c.a.bAG);
                com.baidu.tieba.j.d.sm(c.a.fHL);
                com.baidu.tieba.j.d.sm(c.a.fHM);
                com.baidu.tieba.j.d.sm(c.a.fHO);
                com.baidu.tieba.j.d.sm(c.a.fHP);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bIX() {
        return a.hDJ;
    }

    public void bIS() {
        if (f.hA()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List wM = e.wM(c.a.fHN);
                    if (wM != null) {
                        int size = wM.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) wM.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> wM(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(wN(com.baidu.tieba.j.d.J(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> wN(String str) {
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
            this.hDG.add(jSONObject.toString());
            String bea = bea();
            if (f.hA()) {
                j(jSONObject, bea);
            }
            if (this.hDG.size() >= com.baidu.tbadk.coreExtra.model.f.Kc() || z) {
                a(new d(this.hDG, bea));
                this.hDG.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String bea() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.hA()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fHN + this.mCurrentFileName;
    }

    private void j(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.hA()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.t.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cR(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cR(String str, String str2) {
        boolean g;
        if (this.hDH.contains(str)) {
            g = false;
        } else {
            File file = new File(str);
            g = com.baidu.tieba.j.d.g(file, str2 + "\n");
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.t.e.4
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
            if (c.g(c.dX(dVar.hDE), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hDF)) {
                l.deleteFile(new File(dVar.hDF));
                this.hDH.add(dVar.hDF);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
