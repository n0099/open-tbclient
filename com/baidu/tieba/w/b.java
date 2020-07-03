package com.baidu.tieba.w;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static final String FILE_SEP = File.separator;
    private String mPath;
    private String mUrl;
    private a mgS;

    /* loaded from: classes.dex */
    public interface a {
        void c(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.mPath = str;
        this.mUrl = str2;
        this.mgS = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (ar.isEmpty(this.mPath) || ar.isEmpty(this.mUrl)) {
            return "";
        }
        new File(this.mPath).mkdirs();
        String str = this.mPath + FILE_SEP + "videosplash.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        e eVar = new e();
        eVar.kT().setUrl(this.mUrl);
        if (new com.baidu.adp.lib.network.http.c(eVar).a(str, null, 3, 3000, -1, -1, true, true)) {
            return dqj();
        }
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.mgS != null) {
            if (!ar.isEmpty(str)) {
                this.mgS.c(true, str, this.mUrl);
            } else {
                this.mgS.c(false, null, null);
            }
        }
    }

    private String dqj() {
        File file = new File(this.mPath + FILE_SEP + "videosplash.temp");
        File file2 = new File(this.mPath + FILE_SEP + (s.toMd5(this.mUrl) + ".mp4"));
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            Y(file2);
            return file2.getAbsolutePath();
        }
        return "";
    }

    private void Y(File file) {
        File[] listFiles;
        if (!ar.isEmpty(this.mPath)) {
            File file2 = new File(this.mPath);
            if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                for (File file3 : listFiles) {
                    if (file3 != null && !file3.equals(file)) {
                        n.deleteFileOrDir(file3);
                    }
                }
            }
        }
    }
}
