package com.baidu.tieba.w;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static final String FILE_SEP = File.separator;
    private a lNb;
    private String mPath;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface a {
        void c(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.mPath = str;
        this.mUrl = str2;
        this.lNb = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (aq.isEmpty(this.mPath) || aq.isEmpty(this.mUrl)) {
            return "";
        }
        new File(this.mPath).mkdirs();
        String str = this.mPath + FILE_SEP + "videosplash.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        e eVar = new e();
        eVar.kD().setUrl(this.mUrl);
        if (new com.baidu.adp.lib.network.http.c(eVar).a(str, null, 3, 3000, -1, -1, true, true)) {
            return dlY();
        }
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.lNb != null) {
            if (!aq.isEmpty(str)) {
                this.lNb.c(true, str, this.mUrl);
            } else {
                this.lNb.c(false, null, null);
            }
        }
    }

    private String dlY() {
        File file = new File(this.mPath + FILE_SEP + "videosplash.temp");
        File file2 = new File(this.mPath + FILE_SEP + (s.toMd5(this.mUrl) + ".mp4"));
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            X(file2);
            return file2.getAbsolutePath();
        }
        return "";
    }

    private void X(File file) {
        File[] listFiles;
        if (!aq.isEmpty(this.mPath)) {
            File file2 = new File(this.mPath);
            if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                for (File file3 : listFiles) {
                    if (file3 != null && !file3.equals(file)) {
                        m.deleteFileOrDir(file3);
                    }
                }
            }
        }
    }
}
