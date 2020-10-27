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
    private String nfv;
    private List<String> nfw;
    private List<String> nfx;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a {
        private static final e nfz = new e();
    }

    private e() {
        this.nfw = new ArrayList();
        this.nfx = new ArrayList();
        if (f.checkSD()) {
            dLt();
        }
    }

    private void dLt() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.On(c.a.kRv);
                com.baidu.tieba.k.d.On(c.a.kRw);
                com.baidu.tieba.k.d.On(c.a.kRx);
                com.baidu.tieba.k.d.On(c.a.kRz);
                com.baidu.tieba.k.d.On(c.a.kRA);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dLu() {
        return a.nfz;
    }

    public void dLq() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List Tj = e.Tj(c.a.kRy);
                    if (Tj != null) {
                        int size = Tj.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) Tj.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> Tj(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(Tk(com.baidu.tieba.k.d.ab(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> Tk(String str) {
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
            this.nfw.add(jSONObject.toString());
            String dLv = dLv();
            if (f.checkSD()) {
                D(jSONObject, dLv);
            }
            if (this.nfw.size() >= g.buN() || z) {
                a(new d(this.nfw, dLv));
                this.nfw.clear();
                this.nfv = null;
            }
        }
    }

    private String dLv() {
        if (StringUtils.isNull(this.nfv)) {
            if (f.checkSD()) {
                this.nfv = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.kRy + this.nfv;
    }

    private void D(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.checkSD()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.u.e.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                        e.this.gu(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean gu(String str, String str2) {
        boolean i;
        if (this.nfx.contains(str)) {
            i = false;
        } else {
            File file = new File(str);
            i = com.baidu.tieba.k.d.i(file, str2 + "\n");
        }
        return i;
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
            if (c.e(c.fH(dVar.nft), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.nfu)) {
                n.deleteFile(new File(dVar.nfu));
                this.nfx.add(dVar.nfu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
