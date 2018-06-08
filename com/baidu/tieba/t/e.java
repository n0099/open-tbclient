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
    private static e gVX = new e();
    private String gVU;
    private List<String> gVV = new ArrayList();
    private List<String> gVW = new ArrayList();

    private e() {
        if (f.ge()) {
            bAN();
        }
    }

    private void bAN() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.qp(c.a.bjC);
                com.baidu.tieba.j.d.qp(c.a.fcW);
                com.baidu.tieba.j.d.qp(c.a.fcX);
                com.baidu.tieba.j.d.qp(c.a.fcZ);
                com.baidu.tieba.j.d.qp(c.a.fda);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bAO() {
        return gVX;
    }

    public void bAK() {
        if (f.ge()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List uC = e.uC(c.a.fcY);
                    if (uC != null) {
                        int size = uC.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) uC.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> uC(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(uD(com.baidu.tieba.j.d.B(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> uD(String str) {
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
            this.gVV.add(jSONObject.toString());
            String aWZ = aWZ();
            if (f.ge()) {
                h(jSONObject, aWZ);
            }
            if (this.gVV.size() >= com.baidu.tbadk.coreExtra.model.f.ER() || z) {
                a(new d(this.gVV, aWZ));
                this.gVV.clear();
                this.gVU = null;
            }
        }
    }

    private String aWZ() {
        if (StringUtils.isNull(this.gVU)) {
            if (f.ge()) {
                this.gVU = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fcY + this.gVU;
    }

    private void h(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.ge()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.t.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.co(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean co(String str, String str2) {
        boolean e;
        if (this.gVW.contains(str)) {
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
            if (c.f(c.dF(dVar.gVS), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.gVT)) {
                l.deleteFile(new File(dVar.gVT));
                this.gVW.add(dVar.gVT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
