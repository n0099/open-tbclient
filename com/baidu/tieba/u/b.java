package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static final String dcc = File.separator;
    private a jJx;
    private String mUrl;
    private String wX;

    /* loaded from: classes.dex */
    public interface a {
        void b(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.wX = str;
        this.mUrl = str2;
        this.jJx = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (aq.isEmpty(this.wX) || aq.isEmpty(this.mUrl)) {
            return "";
        }
        new File(this.wX).mkdirs();
        String str = this.wX + dcc + "videosplash.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        e eVar = new e();
        eVar.iu().setUrl(this.mUrl);
        if (new com.baidu.adp.lib.network.http.c(eVar).a(str, null, 3, 3000, -1, -1, true, true)) {
            return cyT();
        }
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.jJx != null) {
            if (!aq.isEmpty(str)) {
                this.jJx.b(true, str, this.mUrl);
            } else {
                this.jJx.b(false, null, null);
            }
        }
    }

    private String cyT() {
        File file = new File(this.wX + dcc + "videosplash.temp");
        File file2 = new File(this.wX + dcc + (s.bn(this.mUrl) + ".mp4"));
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
        if (!aq.isEmpty(this.wX)) {
            File file2 = new File(this.wX);
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
