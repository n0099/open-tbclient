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
    private static e hje = new e();
    private List<String> hjc = new ArrayList();
    private List<String> hjd = new ArrayList();
    private String mCurrentFileName;

    private e() {
        if (f.hk()) {
            bCH();
        }
    }

    private void bCH() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.qP(c.a.brA);
                com.baidu.tieba.j.d.qP(c.a.fon);
                com.baidu.tieba.j.d.qP(c.a.foo);
                com.baidu.tieba.j.d.qP(c.a.foq);
                com.baidu.tieba.j.d.qP(c.a.f0for);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bCI() {
        return hje;
    }

    public void bCD() {
        if (f.hk()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List vj = e.vj(c.a.fop);
                    if (vj != null) {
                        int size = vj.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) vj.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> vj(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(vk(com.baidu.tieba.j.d.H(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> vk(String str) {
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
            this.hjc.add(jSONObject.toString());
            String aYl = aYl();
            if (f.hk()) {
                i(jSONObject, aYl);
            }
            if (this.hjc.size() >= com.baidu.tbadk.coreExtra.model.f.Gv() || z) {
                a(new d(this.hjc, aYl));
                this.hjc.clear();
                this.mCurrentFileName = null;
            }
        }
    }

    private String aYl() {
        if (StringUtils.isNull(this.mCurrentFileName)) {
            if (f.hk()) {
                this.mCurrentFileName = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fop + this.mCurrentFileName;
    }

    private void i(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.hk()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.s.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.cz(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean cz(String str, String str2) {
        boolean f;
        if (this.hjd.contains(str)) {
            f = false;
        } else {
            File file = new File(str);
            f = com.baidu.tieba.j.d.f(file, str2 + "\n");
        }
        return f;
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
            if (c.g(c.dF(dVar.hja), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hjb)) {
                l.deleteFile(new File(dVar.hjb));
                this.hjd.add(dVar.hjb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
