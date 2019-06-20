package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static final String cYL = File.separator;
    private a jzM;
    private String mUrl;
    private String wU;

    /* loaded from: classes.dex */
    public interface a {
        void b(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.wU = str;
        this.mUrl = str2;
        this.jzM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (ap.isEmpty(this.wU) || ap.isEmpty(this.mUrl)) {
            return "";
        }
        new File(this.wU).mkdirs();
        String str = this.wU + cYL + "videosplash.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        e eVar = new e();
        eVar.ik().setUrl(this.mUrl);
        if (new com.baidu.adp.lib.network.http.c(eVar).a(str, null, 3, 3000, -1, -1, true, true)) {
            return cuU();
        }
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.jzM != null) {
            if (!ap.isEmpty(str)) {
                this.jzM.b(true, str, this.mUrl);
            } else {
                this.jzM.b(false, null, null);
            }
        }
    }

    private String cuU() {
        File file = new File(this.wU + cYL + "videosplash.temp");
        File file2 = new File(this.wU + cYL + (s.bm(this.mUrl) + ".mp4"));
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            T(file2);
            return file2.getAbsolutePath();
        }
        return "";
    }

    private void T(File file) {
        File[] listFiles;
        if (!ap.isEmpty(this.wU)) {
            File file2 = new File(this.wU);
            if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                for (File file3 : listFiles) {
                    if (file3 != null && !file3.equals(file)) {
                        m.A(file3);
                    }
                }
            }
        }
    }
}
