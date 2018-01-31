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
    private static e hmn = new e();
    private String hmk;
    private List<String> hml = new ArrayList();
    private List<String> hmm = new ArrayList();

    private e() {
        if (f.lk()) {
            bzT();
        }
    }

    private void bzT() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.q.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.i.d.pj(c.a.bPv);
                com.baidu.tieba.i.d.pj(c.a.fsk);
                com.baidu.tieba.i.d.pj(c.a.fsl);
                com.baidu.tieba.i.d.pj(c.a.fsn);
                com.baidu.tieba.i.d.pj(c.a.fso);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bzU() {
        return hmn;
    }

    public void bzP() {
        if (f.lk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.q.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List tt = e.tt(c.a.fsm);
                    if (tt != null) {
                        int size = tt.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) tt.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> tt(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(tu(com.baidu.tieba.i.d.C(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> tu(String str) {
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
            this.hml.add(jSONObject.toString());
            String aVy = aVy();
            if (f.lk()) {
                b(jSONObject, aVy);
            }
            if (this.hml.size() >= com.baidu.tbadk.coreExtra.model.f.HY() || z) {
                a(new d(this.hml, aVy));
                this.hml.clear();
                this.hmk = null;
            }
        }
    }

    private String aVy() {
        if (StringUtils.isNull(this.hmk)) {
            if (f.lk()) {
                this.hmk = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fsm + this.hmk;
    }

    private void b(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.lk()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.q.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cf(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cf(String str, String str2) {
        boolean e;
        if (this.hmm.contains(str)) {
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
            if (c.f(c.dA(dVar.hmi), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hmj)) {
                k.deleteFile(new File(dVar.hmj));
                this.hmm.add(dVar.hmj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
