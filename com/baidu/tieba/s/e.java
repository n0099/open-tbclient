package com.baidu.tieba.s;

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
/* loaded from: classes5.dex */
public class e {
    private List<String> iUh;
    private List<String> iUi;
    private String mCurrentFileName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static final e iUk = new e();
    }

    private e() {
        this.iUh = new ArrayList();
        this.iUi = new ArrayList();
        if (f.hy()) {
            ciw();
        }
    }

    private void ciw() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.yP(c.a.cLK);
                com.baidu.tieba.j.d.yP(c.a.gXY);
                com.baidu.tieba.j.d.yP(c.a.gXZ);
                com.baidu.tieba.j.d.yP(c.a.gYb);
                com.baidu.tieba.j.d.yP(c.a.gYc);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e cix() {
        return a.iUk;
    }

    public void cis() {
        if (f.hy()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Dn = e.Dn(c.a.gYa);
                    if (Dn != null) {
                        int size = Dn.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Dn.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Dn(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Do(com.baidu.tieba.j.d.R(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Do(String str) {
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
            this.iUh.add(jSONObject.toString());
            String bED = bED();
            if (f.hy()) {
                m(jSONObject, bED);
            }
            if (this.iUh.size() >= com.baidu.tbadk.coreExtra.model.f.ajz() || z) {
                a(new d(this.iUh, bED));
                this.iUh.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String bED() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.hy()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.gYa + this.mCurrentFileName;
    }

    private void m(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.hy()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.ea(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean ea(String str, String str2) {
        boolean g;
        if (this.iUi.contains(str)) {
            g = false;
        } else {
            File file = new File(str);
            g = com.baidu.tieba.j.d.g(file, str2 + "\n");
        }
        return g;
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
            if (c.g(c.ed(dVar.iUf), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.iUg)) {
                m.deleteFile(new File(dVar.iUg));
                this.iUi.add(dVar.iUg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
