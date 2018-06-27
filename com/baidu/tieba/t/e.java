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
/* loaded from: classes2.dex */
public class e {
    private static e hac = new e();
    private String gZZ;
    private List<String> haa = new ArrayList();
    private List<String> hab = new ArrayList();

    private e() {
        if (f.ge()) {
            bBn();
        }
    }

    private void bBn() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.qp(c.a.blb);
                com.baidu.tieba.j.d.qp(c.a.fgN);
                com.baidu.tieba.j.d.qp(c.a.fgO);
                com.baidu.tieba.j.d.qp(c.a.fgQ);
                com.baidu.tieba.j.d.qp(c.a.fgR);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bBo() {
        return hac;
    }

    public void bBk() {
        if (f.ge()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List uy = e.uy(c.a.fgP);
                    if (uy != null) {
                        int size = uy.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) uy.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> uy(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(uz(com.baidu.tieba.j.d.B(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> uz(String str) {
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
            this.haa.add(jSONObject.toString());
            String aXG = aXG();
            if (f.ge()) {
                h(jSONObject, aXG);
            }
            if (this.haa.size() >= com.baidu.tbadk.coreExtra.model.f.Fj() || z) {
                a(new d(this.haa, aXG));
                this.haa.clear();
                this.gZZ = null;
            }
        }
    }

    private String aXG() {
        if (StringUtils.isNull(this.gZZ)) {
            if (f.ge()) {
                this.gZZ = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fgP + this.gZZ;
    }

    private void h(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.ge()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.t.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cs(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cs(String str, String str2) {
        boolean e;
        if (this.hab.contains(str)) {
            e = false;
        } else {
            File file = new File(str);
            e = com.baidu.tieba.j.d.e(file, str2 + "\n");
        }
        return e;
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
            if (c.f(c.dI(dVar.gZX), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.gZY)) {
                l.deleteFile(new File(dVar.gZY));
                this.hab.add(dVar.gZY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
