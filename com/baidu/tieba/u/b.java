package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static final String bqu = File.separator;
    private a hog;
    private String mUrl;
    private String wf;

    /* loaded from: classes.dex */
    public interface a {
        void b(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.wf = str;
        this.mUrl = str2;
        this.hog = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public String doInBackground(Void... voidArr) {
        if (ap.isEmpty(this.wf) || ap.isEmpty(this.mUrl)) {
            return "";
        }
        new File(this.wf).mkdirs();
        String str = this.wf + bqu + "videosplash.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        e eVar = new e();
        eVar.hW().setUrl(this.mUrl);
        if (new com.baidu.adp.lib.network.http.c(eVar).a(str, null, 3, 3000, -1, -1, true, true)) {
            return bEi();
        }
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.hog != null) {
            if (!ap.isEmpty(str)) {
                this.hog.b(true, str, this.mUrl);
            } else {
                this.hog.b(false, null, null);
            }
        }
    }

    private String bEi() {
        File file = new File(this.wf + bqu + "videosplash.temp");
        File file2 = new File(this.wf + bqu + (s.bm(this.mUrl) + ".mp4"));
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            J(file2);
            return file2.getAbsolutePath();
        }
        return "";
    }

    private void J(File file) {
        File[] listFiles;
        if (!ap.isEmpty(this.wf)) {
            File file2 = new File(this.wf);
            if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                for (File file3 : listFiles) {
                    if (file3 != null && !file3.equals(file)) {
                        l.r(file3);
                    }
                }
            }
        }
    }
}
