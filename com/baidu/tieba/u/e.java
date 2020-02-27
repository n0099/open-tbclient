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
    private String kuv;
    private List<String> kuw;
    private List<String> kux;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final e kuz = new e();
    }

    private e() {
        this.kuw = new ArrayList();
        this.kux = new ArrayList();
        if (f.checkSD()) {
            cOL();
        }
    }

    private void cOL() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.ET(c.a.dXa);
                com.baidu.tieba.k.d.ET(c.a.ipJ);
                com.baidu.tieba.k.d.ET(c.a.ipK);
                com.baidu.tieba.k.d.ET(c.a.ipM);
                com.baidu.tieba.k.d.ET(c.a.ipN);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e cOM() {
        return a.kuz;
    }

    public void cOH() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List JN = e.JN(c.a.ipL);
                    if (JN != null) {
                        int size = JN.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) JN.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> JN(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(JO(com.baidu.tieba.k.d.M(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> JO(String str) {
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
            this.kuw.add(jSONObject.toString());
            String cgX = cgX();
            if (f.checkSD()) {
                q(jSONObject, cgX);
            }
            if (this.kuw.size() >= com.baidu.tbadk.coreExtra.model.f.aLW() || z) {
                a(new d(this.kuw, cgX));
                this.kuw.clear();
                this.kuv = null;
            }
        }
    }

    private String cgX() {
        if (StringUtils.isNull(this.kuv)) {
            if (f.checkSD()) {
                this.kuv = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.ipL + this.kuv;
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
        if (this.kux.contains(str)) {
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
            if (c.f(c.en(dVar.kut), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.kuu)) {
                m.deleteFile(new File(dVar.kuu));
                this.kux.add(dVar.kuu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
