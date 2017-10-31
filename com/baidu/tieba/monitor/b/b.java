package com.baidu.tieba.monitor.b;

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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b exK = new b();
    private String exH;
    private List<String> exI = new ArrayList();
    private List<String> exJ = new ArrayList();

    private b() {
        if (f.dG()) {
            aNl();
        }
    }

    private void aNl() {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.monitor.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                b.oL(a.InterfaceC0105a.aXW);
                b.oL(a.InterfaceC0105a.aXX);
                b.oL(a.InterfaceC0105a.aXY);
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void oL(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static b aNm() {
        return exK;
    }

    public void aNn() {
        if (f.dG()) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.monitor.b.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    List oM = b.oM(a.InterfaceC0105a.aXZ);
                    if (oM != null) {
                        int size = oM.size();
                        for (int i = 0; i < size; i++) {
                            b.this.a((a) oM.get(i));
                        }
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<a> oM(String str) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(new a(oN(C(listFiles[i])), listFiles[i].getAbsolutePath()));
                }
            }
        }
        return arrayList;
    }

    private static String C(File file) {
        FileInputStream fileInputStream;
        StringBuilder sb = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    return sb.toString();
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            com.baidu.adp.lib.g.a.d(fileInputStream);
            throw th;
        }
        return sb.toString();
    }

    private static List<String> oN(String str) {
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

    public void c(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            this.exI.add(jSONObject.toString());
            String aNo = aNo();
            if (f.dG()) {
                b(jSONObject, aNo);
            }
            if (this.exI.size() >= com.baidu.tbadk.coreExtra.c.f.Ar() || z) {
                a(new a(this.exI, aNo));
                this.exI.clear();
                this.exH = null;
            }
        }
    }

    private String aNo() {
        if (StringUtils.isNull(this.exH)) {
            if (f.dG()) {
                this.exH = String.valueOf(System.currentTimeMillis());
            } else {
                return null;
            }
        }
        return a.InterfaceC0105a.aXZ + this.exH;
    }

    private void b(JSONObject jSONObject, String str) {
        if (!StringUtils.isNull(str) && f.dG()) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.monitor.b.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: u */
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 2) {
                        b.this.bx(strArr[0], strArr[1]);
                    }
                    return null;
                }
            }.execute(str, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean bx(String str, String str2) {
        boolean e;
        if (this.exJ.contains(str)) {
            e = false;
        } else {
            File file = new File(str);
            e = e(file, str2 + "\n");
        }
        return e;
    }

    private static boolean e(File file, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            new BdAsyncTask<a, Void, Void>() { // from class: com.baidu.tieba.monitor.b.b.4
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
            if (B(cl(aVar.exF)) && !StringUtils.isNull(aVar.exG)) {
                k.s(new File(aVar.exG));
                this.exJ.add(aVar.exG);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] cl(List<String> list) {
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
