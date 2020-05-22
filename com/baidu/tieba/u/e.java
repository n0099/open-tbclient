package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.k.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    private String lzk;
    private List<String> lzl;
    private List<String> lzm;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final e lzo = new e();
    }

    private e() {
        this.lzl = new ArrayList();
        this.lzm = new ArrayList();
        if (f.checkSD()) {
            dhq();
        }
    }

    private void dhq() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.In(c.a.eMg);
                com.baidu.tieba.k.d.In(c.a.jqG);
                com.baidu.tieba.k.d.In(c.a.jqH);
                com.baidu.tieba.k.d.In(c.a.jqJ);
                com.baidu.tieba.k.d.In(c.a.jqK);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dhr() {
        return a.lzo;
    }

    public void dhn() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Nn = e.Nn(c.a.jqI);
                    if (Nn != null) {
                        int size = Nn.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Nn.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Nn(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(No(com.baidu.tieba.k.d.S(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> No(String str) {
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

    public synchronized void f(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.lzl.add(jSONObject.toString());
            String cyC = cyC();
            if (f.checkSD()) {
                y(jSONObject, cyC);
            }
            if (this.lzl.size() >= com.baidu.tbadk.coreExtra.model.f.baI() || z) {
                a(new d(this.lzl, cyC));
                this.lzl.clear();
                this.lzk = null;
            }
        }
    }

    private String cyC() {
        if (StringUtils.isNull(this.lzk)) {
            if (f.checkSD()) {
                this.lzk = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.jqI + this.lzk;
    }

    private void y(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.fv(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean fv(String str, String str2) {
        boolean g;
        if (this.lzm.contains(str)) {
            g = false;
        } else {
            File file = new File(str);
            g = com.baidu.tieba.k.d.g(file, str2 + "\n");
        }
        return g;
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
            if (c.e(c.eJ(dVar.lzi), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.lzj)) {
                m.deleteFile(new File(dVar.lzj));
                this.lzm.add(dVar.lzj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
