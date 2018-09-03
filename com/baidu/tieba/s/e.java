package com.baidu.tieba.s;

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
    private static e hbm = new e();
    private List<String> hbk = new ArrayList();
    private List<String> hbl = new ArrayList();
    private String mCurrentFileName;

    private e() {
        if (f.gd()) {
            bzS();
        }
    }

    private void bzS() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.qk(c.a.blM);
                com.baidu.tieba.j.d.qk(c.a.fgQ);
                com.baidu.tieba.j.d.qk(c.a.fgR);
                com.baidu.tieba.j.d.qk(c.a.fgT);
                com.baidu.tieba.j.d.qk(c.a.fgU);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bzT() {
        return hbm;
    }

    public void bzO() {
        if (f.gd()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List uA = e.uA(c.a.fgS);
                    if (uA != null) {
                        int size = uA.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) uA.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> uA(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(uB(com.baidu.tieba.j.d.B(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> uB(String str) {
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

    public synchronized void b(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.hbk.add(jSONObject.toString());
            String aVX = aVX();
            if (f.gd()) {
                h(jSONObject, aVX);
            }
            if (this.hbk.size() >= com.baidu.tbadk.coreExtra.model.f.Ff() || z) {
                a(new d(this.hbk, aVX));
                this.hbk.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String aVX() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.gd()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fgS + this.mCurrentFileName;
    }

    private void h(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.gd()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cp(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cp(String str, String str2) {
        boolean e;
        if (this.hbl.contains(str)) {
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
            if (c.f(c.dE(dVar.hbi), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hbj)) {
                l.deleteFile(new File(dVar.hbj));
                this.hbl.add(dVar.hbj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
