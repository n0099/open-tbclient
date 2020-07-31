package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.k.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class e {
    private String mbr;
    private List<String> mbs;
    private List<String> mbt;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        private static final e mbv = new e();
    }

    private e() {
        this.mbs = new ArrayList();
        this.mbt = new ArrayList();
        if (f.checkSD()) {
            dpa();
        }
    }

    private void dpa() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.JF(c.a.jRH);
                com.baidu.tieba.k.d.JF(c.a.jRI);
                com.baidu.tieba.k.d.JF(c.a.jRJ);
                com.baidu.tieba.k.d.JF(c.a.jRL);
                com.baidu.tieba.k.d.JF(c.a.jRM);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dpb() {
        return a.mbv;
    }

    public void doX() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Oy = e.Oy(c.a.jRK);
                    if (Oy != null) {
                        int size = Oy.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Oy.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Oy(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Oz(com.baidu.tieba.k.d.W(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Oz(String str) {
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
            this.mbs.add(jSONObject.toString());
            String dpc = dpc();
            if (f.checkSD()) {
                B(jSONObject, dpc);
            }
            if (this.mbs.size() >= com.baidu.tbadk.coreExtra.model.f.bgE() || z) {
                a(new d(this.mbs, dpc));
                this.mbs.clear();
                this.mbr = null;
            }
        }
    }

    private String dpc() {
        if (StringUtils.isNull(this.mbr)) {
            if (f.checkSD()) {
                this.mbr = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.jRK + this.mbr;
    }

    private void B(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.fE(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean fE(String str, String str2) {
        boolean h;
        if (this.mbt.contains(str)) {
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
            if (c.e(c.fe(dVar.mbp), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.mbq)) {
                n.deleteFile(new File(dVar.mbq));
                this.mbt.add(dVar.mbq);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
