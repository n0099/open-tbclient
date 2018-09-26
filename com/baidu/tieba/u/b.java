package com.baidu.tieba.u;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static final String bwn = File.separator;
    private a hvZ;
    private String mUrl;
    private String yz;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.yz = str;
        this.mUrl = str2;
        this.hvZ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public String doInBackground(Void... voidArr) {
        if (ao.isEmpty(this.yz) || ao.isEmpty(this.mUrl)) {
            return "";
        }
        new File(this.yz).mkdirs();
        String str = this.yz + bwn + "videosplash.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        e eVar = new e();
        eVar.jc().setUrl(this.mUrl);
        if (new com.baidu.adp.lib.network.http.c(eVar).a(str, null, 3, 3000, -1, -1, true, true)) {
            return bHb();
        }
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.hvZ != null) {
            if (!ao.isEmpty(str)) {
                this.hvZ.a(true, str, this.mUrl);
            } else {
                this.hvZ.a(false, null, null);
            }
        }
    }

    private String bHb() {
        File file = new File(this.yz + bwn + "videosplash.temp");
        File file2 = new File(this.yz + bwn + (s.bD(this.mUrl) + ".mp4"));
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            P(file2);
            return file2.getAbsolutePath();
        }
        return "";
    }

    private void P(File file) {
        File[] listFiles;
        if (!ao.isEmpty(this.yz)) {
            File file2 = new File(this.yz);
            if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                for (File file3 : listFiles) {
                    if (file3 != null && !file3.equals(file)) {
                        l.x(file3);
                    }
                }
            }
        }
    }
}
