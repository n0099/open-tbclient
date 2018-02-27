package com.baidu.tieba.videosplash;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static final String bWe = File.separator;
    private a hzv;
    private String mPath;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface a {
        void b(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.mPath = str;
        this.mUrl = str2;
        this.hzv = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(Void... voidArr) {
        if (am.isEmpty(this.mPath) || am.isEmpty(this.mUrl)) {
            return "";
        }
        new File(this.mPath).mkdirs();
        String str = this.mPath + bWe + "videosplash.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        e eVar = new e();
        eVar.nb().setUrl(this.mUrl);
        if (new com.baidu.adp.lib.network.http.c(eVar).a(str, null, 3, PushConstants.WORK_RECEIVER_EVENTCORE_ERROR, -1, -1, true, true)) {
            return bEC();
        }
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.hzv != null) {
            if (!am.isEmpty(str)) {
                this.hzv.b(true, str, this.mUrl);
            } else {
                this.hzv.b(false, null, null);
            }
        }
    }

    private String bEC() {
        File file = new File(this.mPath + bWe + "videosplash.temp");
        File file2 = new File(this.mPath + bWe + (s.ba(this.mUrl) + ".mp4"));
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            K(file2);
            return file2.getAbsolutePath();
        }
        return "";
    }

    private void K(File file) {
        File[] listFiles;
        if (!am.isEmpty(this.mPath)) {
            File file2 = new File(this.mPath);
            if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                for (File file3 : listFiles) {
                    if (file3 != null && !file3.equals(file)) {
                        k.s(file3);
                    }
                }
            }
        }
    }
}
