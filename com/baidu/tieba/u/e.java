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
    private String nlr;
    private List<String> nls;
    private List<String> nlt;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a {
        private static final e nlv = new e();
    }

    private e() {
        this.nls = new ArrayList();
        this.nlt = new ArrayList();
        if (f.checkSD()) {
            dNV();
        }
    }

    private void dNV() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.k.d.OE(c.a.kXr);
                com.baidu.tieba.k.d.OE(c.a.kXs);
                com.baidu.tieba.k.d.OE(c.a.kXt);
                com.baidu.tieba.k.d.OE(c.a.kXv);
                com.baidu.tieba.k.d.OE(c.a.kXw);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static e dNW() {
        return a.nlv;
    }

    public void dNS() {
        if (f.checkSD()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.u.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List TA = e.TA(c.a.kXu);
                    if (TA != null) {
                        int size = TA.size();
                        for (int i = 0; i < size; i++) {
                            e.this.a((d) TA.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<d> TA(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new d(TB(com.baidu.tieba.k.d.ab(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> TB(String str) {
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
            this.nls.add(jSONObject.toString());
            String dNX = dNX();
            if (f.checkSD()) {
                D(jSONObject, dNX);
            }
            if (this.nls.size() >= g.bxn() || z) {
                a(new d(this.nls, dNX));
                this.nls.clear();
                this.nlr = null;
            }
        }
    }

    private String dNX() {
        if (StringUtils.isNull(this.nlr)) {
            if (f.checkSD()) {
                this.nlr = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return c.a.kXu + this.nlr;
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
        if (this.nlt.contains(str)) {
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
            if (c.e(c.fP(dVar.nlp), TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.nlq)) {
                n.deleteFile(new File(dVar.nlq));
                this.nlt.add(dVar.nlq);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
