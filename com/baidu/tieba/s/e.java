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
    private static e hbl = new e();
    private String hbi;
    private List<String> hbj = new ArrayList();
    private List<String> hbk = new ArrayList();

    private e() {
        if (f.gd()) {
            bzQ();
        }
    }

    private void bzQ() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.j.d.qi(c.a.blH);
                com.baidu.tieba.j.d.qi(c.a.fgW);
                com.baidu.tieba.j.d.qi(c.a.fgX);
                com.baidu.tieba.j.d.qi(c.a.fgZ);
                com.baidu.tieba.j.d.qi(c.a.fha);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e bzR() {
        return hbl;
    }

    public void bzM() {
        if (f.gd()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.s.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List uw = e.uw(c.a.fgY);
                    if (uw != null) {
                        int size = uw.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) uw.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> uw(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(ux(com.baidu.tieba.j.d.B(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> ux(String str) {
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
            this.hbj.add(jSONObject.toString());
            String aWb = aWb();
            if (f.gd()) {
                h(jSONObject, aWb);
            }
            if (this.hbj.size() >= com.baidu.tbadk.coreExtra.model.f.Ff() || z) {
                a(new d(this.hbj, aWb));
                this.hbj.clear();
                this.hbi = null;
            }
        }
    }

    private String aWb() {
        if (StringUtils.isNull(this.hbi)) {
            if (f.gd()) {
                this.hbi = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.fgY + this.hbi;
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
        if (this.hbk.contains(str)) {
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
            if (c.f(c.dE(dVar.hbg), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.hbh)) {
                l.deleteFile(new File(dVar.hbh));
                this.hbk.add(dVar.hbh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
