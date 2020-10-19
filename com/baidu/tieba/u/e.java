package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tieba.k.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class e {
    private String mSS;
    private List<String> mST;
    private List<String> mSU;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a {
        private static final e mSW = new e();
    }

    private e() {
        this.mST = new ArrayList();
        this.mSU = new ArrayList();
        if (f.checkSD()) {
            dIl();
        }
    }

    private void dIl() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.NP(c.a.kEY);
                com.baidu.tieba.k.d.NP(c.a.kEZ);
                com.baidu.tieba.k.d.NP(c.a.kFa);
                com.baidu.tieba.k.d.NP(c.a.kFc);
                com.baidu.tieba.k.d.NP(c.a.kFd);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dIm() {
        return a.mSW;
    }

    public void dIi() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List SK = e.SK(c.a.kFb);
                    if (SK != null) {
                        int size = SK.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) SK.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> SK(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(SL(com.baidu.tieba.k.d.aa(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> SL(String str) {
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

    public synchronized void g(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.mST.add(jSONObject.toString());
            String dIn = dIn();
            if (f.checkSD()) {
                D(jSONObject, dIn);
            }
            if (this.mST.size() >= g.bsU() || z) {
                a(new d(this.mST, dIn));
                this.mST.clear();
                this.mSS = null;
            }
        }
    }

    private String dIn() {
        if (StringUtils.isNull(this.mSS)) {
            if (f.checkSD()) {
                this.mSS = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.kFb + this.mSS;
    }

    private void D(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.gp(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean gp(String str, String str2) {
        boolean h;
        if (this.mSU.contains(str)) {
            h = false;
        } else {
            File file = new File(str);
            h = com.baidu.tieba.k.d.h(file, str2 + "\n");
        }
        return h;
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
            if (c.e(c.fy(dVar.mSQ), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.mSR)) {
                n.deleteFile(new File(dVar.mSR));
                this.mSU.add(dVar.mSR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
