package com.baidu.tieba.q;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.i.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static e hlT = new e();
    private String hlQ;
    private List<String> hlR = new ArrayList();
    private List<String> hlS = new ArrayList();

    private e() {
        if (f.lk()) {
            bzR();
        }
    }

    private void bzR() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.q.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.i.d.pc(c.a.bPm);
                com.baidu.tieba.i.d.pc(c.a.frP);
                com.baidu.tieba.i.d.pc(c.a.frQ);
                com.baidu.tieba.i.d.pc(c.a.frS);
                com.baidu.tieba.i.d.pc(c.a.frT);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bzS() {
        return hlT;
    }

    public void bzN() {
        if (f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.q.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List tm = e.tm(c.a.frR);
                    if (tm != null) {
                        int size = tm.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) tm.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> tm(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(tn(com.baidu.tieba.i.d.C(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> tn(String str) {
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
            this.hlR.add(jSONObject.toString());
            String aVt = aVt();
            if (f.lk()) {
                b(jSONObject, aVt);
            }
            if (this.hlR.size() >= com.baidu.tbadk.coreExtra.model.f.HW() || z) {
                a(new d(this.hlR, aVt));
                this.hlR.clear();
                this.hlQ = null;
            }
        }
    }

    private String aVt() {
        if (StringUtils.isNull(this.hlQ)) {
            if (f.lk()) {
                this.hlQ = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.frR + this.hlQ;
    }

    private void b(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.lk()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.q.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cg(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cg(String str, String str2) {
        boolean e;
        if (this.hlS.contains(str)) {
            e = false;
        } else {
            File file = new File(str);
            e = com.baidu.tieba.i.d.e(file, str2 + "\n");
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            new BdAsyncTask<d, Void, Void>() { // from class: com.baidu.tieba.q.e.4
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
            if (c.f(c.dA(dVar.hlO), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hlP)) {
                k.deleteFile(new File(dVar.hlP));
                this.hlS.add(dVar.hlP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
