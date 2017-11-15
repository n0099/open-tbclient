package com.baidu.tieba.monitor.c;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.monitor.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b eye = new b();
    private String eyb;
    private List<String> eyc = new ArrayList();
    private List<String> eyd = new ArrayList();

    private b() {
        if (f.dG()) {
            aNu();
        }
    }

    private void aNu() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.monitor.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.monitor.b.oG(a.InterfaceC0105a.aYf);
                com.baidu.tieba.monitor.b.oG(a.InterfaceC0105a.exn);
                com.baidu.tieba.monitor.b.oG(a.InterfaceC0105a.exo);
                com.baidu.tieba.monitor.b.oG(a.InterfaceC0105a.exq);
                com.baidu.tieba.monitor.b.oG(a.InterfaceC0105a.exr);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static b aNv() {
        return eye;
    }

    public void aNw() {
        if (f.dG()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.monitor.c.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List oQ = b.oQ(a.InterfaceC0105a.exp);
                    if (oQ != null) {
                        int size = oQ.size();
                        for (int i = 0; i < size; i++) {
                            b.this.a((a) oQ.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<a> oQ(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new a(oR(com.baidu.tieba.monitor.b.C(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static List<String> oR(String str) {
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
            this.eyc.add(jSONObject.toString());
            String aNp = aNp();
            if (f.dG()) {
                b(jSONObject, aNp);
            }
            if (this.eyc.size() >= com.baidu.tbadk.coreExtra.c.f.Az() || z) {
                a(new a(this.eyc, aNp));
                this.eyc.clear();
                this.eyb = null;
            }
        }
    }

    private String aNp() {
        if (StringUtils.isNull(this.eyb)) {
            if (f.dG()) {
                this.eyb = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return a.InterfaceC0105a.exp + this.eyb;
    }

    private void b(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.dG()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.monitor.c.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: u */
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2) {
                        b.this.by(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean by(String str, String str2) {
        boolean e;
        if (this.eyd.contains(str)) {
            e = false;
        } else {
            File file = new File(str);
            e = com.baidu.tieba.monitor.b.e(file, str2 + "\n");
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            new BdAsyncTask<a, Void, Void>() { // from class: com.baidu.tieba.monitor.c.b.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(a... aVarArr) {
                    if (aVarArr != null && aVarArr.length == 1) {
                        b.this.b(aVarArr[0]);
                    }
                    return null;
                }
            }.execute(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        try {
            if (B(cm(aVar.exZ)) && !StringUtils.isNull(aVar.eya)) {
                k.s(new File(aVar.eya));
                this.eyd.add(aVar.eya);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] cm(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            sb.append("\n");
        }
        return sb.toString().getBytes();
    }

    private static boolean B(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        e eVar = new e();
        eVar.fy().setUrl(TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT);
        eVar.fy().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        eVar.fy().d("", bArr);
        new c(eVar).f(3, -1, -1);
        int i = eVar.fz().responseCode;
        byte[] bArr2 = eVar.fz().vr;
        if (bArr2 == null || i != 200) {
            return false;
        }
        try {
            if (new JSONObject(new String(bArr2, "utf-8")).optJSONObject("error").optInt("errno") != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
