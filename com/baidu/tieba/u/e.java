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
/* loaded from: classes22.dex */
public class e {
    private String mDf;
    private List<String> mDg;
    private List<String> mDh;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        private static final e mDj = new e();
    }

    private e() {
        this.mDg = new ArrayList();
        this.mDh = new ArrayList();
        if (f.checkSD()) {
            dEz();
        }
    }

    private void dEz() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.Na(c.a.kpM);
                com.baidu.tieba.k.d.Na(c.a.kpN);
                com.baidu.tieba.k.d.Na(c.a.kpO);
                com.baidu.tieba.k.d.Na(c.a.kpQ);
                com.baidu.tieba.k.d.Na(c.a.kpR);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dEA() {
        return a.mDj;
    }

    public void dEw() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List RW = e.RW(c.a.kpP);
                    if (RW != null) {
                        int size = RW.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) RW.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> RW(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(RX(com.baidu.tieba.k.d.X(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> RX(String str) {
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
            this.mDg.add(jSONObject.toString());
            String dEB = dEB();
            if (f.checkSD()) {
                D(jSONObject, dEB);
            }
            if (this.mDg.size() >= g.bqk() || z) {
                a(new d(this.mDg, dEB));
                this.mDg.clear();
                this.mDf = null;
            }
        }
    }

    private String dEB() {
        if (StringUtils.isNull(this.mDf)) {
            if (f.checkSD()) {
                this.mDf = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.kpP + this.mDf;
    }

    private void D(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.gi(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean gi(String str, String str2) {
        boolean h;
        if (this.mDh.contains(str)) {
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
            if (c.e(c.fv(dVar.mDd), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.mDe)) {
                n.deleteFile(new File(dVar.mDe));
                this.mDh.add(dVar.mDe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
