package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tieba.k.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class e {
    private String mte;
    private List<String> mtf;
    private List<String> mtg;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        private static final e mti = new e();
    }

    private e() {
        this.mtf = new ArrayList();
        this.mtg = new ArrayList();
        if (f.checkSD()) {
            dAw();
        }
    }

    private void dAw() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.Mx(c.a.khf);
                com.baidu.tieba.k.d.Mx(c.a.khg);
                com.baidu.tieba.k.d.Mx(c.a.khh);
                com.baidu.tieba.k.d.Mx(c.a.khj);
                com.baidu.tieba.k.d.Mx(c.a.khk);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dAx() {
        return a.mti;
    }

    public void dAt() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Rw = e.Rw(c.a.khi);
                    if (Rw != null) {
                        int size = Rw.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Rw.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Rw(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Rx(com.baidu.tieba.k.d.X(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Rx(String str) {
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
            this.mtf.add(jSONObject.toString());
            String dAy = dAy();
            if (f.checkSD()) {
                D(jSONObject, dAy);
            }
            if (this.mtf.size() >= g.bpp() || z) {
                a(new d(this.mtf, dAy));
                this.mtf.clear();
                this.mte = null;
            }
        }
    }

    private String dAy() {
        if (StringUtils.isNull(this.mte)) {
            if (f.checkSD()) {
                this.mte = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.khi + this.mte;
    }

    private void D(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.fV(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean fV(String str, String str2) {
        boolean h;
        if (this.mtg.contains(str)) {
            h = false;
        } else {
            File file = new File(str);
            h = com.baidu.tieba.k.d.h(file, str2 + "\n");
        }
        return h;
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
            if (c.e(c.fm(dVar.mtc), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.mtd)) {
                n.deleteFile(new File(dVar.mtd));
                this.mtg.add(dVar.mtd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
