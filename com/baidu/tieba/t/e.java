package com.baidu.tieba.t;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.j.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    private List<String> ktA;
    private String kty;
    private List<String> ktz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final e ktC = new e();
    }

    private e() {
        this.ktz = new ArrayList();
        this.ktA = new ArrayList();
        if (f.checkSD()) {
            cNq();
        }
    }

    private void cNq() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.ED(c.a.dSV);
                com.baidu.tieba.j.d.ED(c.a.inK);
                com.baidu.tieba.j.d.ED(c.a.inL);
                com.baidu.tieba.j.d.ED(c.a.inN);
                com.baidu.tieba.j.d.ED(c.a.inO);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e cNr() {
        return a.ktC;
    }

    public void cNm() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.t.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List JA = e.JA(c.a.inM);
                    if (JA != null) {
                        int size = JA.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) JA.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> JA(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(JB(com.baidu.tieba.j.d.K(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> JB(String str) {
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

    public synchronized void e(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.ktz.add(jSONObject.toString());
            String cfs = cfs();
            if (f.checkSD()) {
                o(jSONObject, cfs);
            }
            if (this.ktz.size() >= com.baidu.tbadk.coreExtra.model.f.aJC() || z) {
                a(new d(this.ktz, cfs));
                this.ktz.clear();
                this.kty = null;
            }
        }
    }

    private String cfs() {
        if (StringUtils.isNull(this.kty)) {
            if (f.checkSD()) {
                this.kty = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.inM + this.kty;
    }

    private void o(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.t.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.ey(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean ey(String str, String str2) {
        boolean e;
        if (this.ktA.contains(str)) {
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
            if (c.f(c.er(dVar.ktw), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.ktx)) {
                m.deleteFile(new File(dVar.ktx));
                this.ktA.add(dVar.ktx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
