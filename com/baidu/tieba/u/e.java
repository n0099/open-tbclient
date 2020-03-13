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
    private String kuJ;
    private List<String> kuK;
    private List<String> kuL;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final e kuN = new e();
    }

    private e() {
        this.kuK = new ArrayList();
        this.kuL = new ArrayList();
        if (f.checkSD()) {
            cOO();
        }
    }

    private void cOO() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.EU(c.a.dXo);
                com.baidu.tieba.k.d.EU(c.a.ipX);
                com.baidu.tieba.k.d.EU(c.a.ipY);
                com.baidu.tieba.k.d.EU(c.a.iqa);
                com.baidu.tieba.k.d.EU(c.a.iqb);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e cOP() {
        return a.kuN;
    }

    public void cOK() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List JO = e.JO(c.a.ipZ);
                    if (JO != null) {
                        int size = JO.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) JO.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> JO(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(JP(com.baidu.tieba.k.d.M(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> JP(String str) {
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
            this.kuK.add(jSONObject.toString());
            String cha = cha();
            if (f.checkSD()) {
                q(jSONObject, cha);
            }
            if (this.kuK.size() >= com.baidu.tbadk.coreExtra.model.f.aLZ() || z) {
                a(new d(this.kuK, cha));
                this.kuK.clear();
                this.kuJ = null;
            }
        }
    }

    private String cha() {
        if (StringUtils.isNull(this.kuJ)) {
            if (f.checkSD()) {
                this.kuJ = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.ipZ + this.kuJ;
    }

    private void q(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.eH(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean eH(String str, String str2) {
        boolean e;
        if (this.kuL.contains(str)) {
            e = false;
        } else {
            File file = new File(str);
            e = com.baidu.tieba.k.d.e(file, str2 + "\n");
        }
        return e;
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
            if (c.f(c.en(dVar.kuH), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.kuI)) {
                m.deleteFile(new File(dVar.kuI));
                this.kuL.add(dVar.kuI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
