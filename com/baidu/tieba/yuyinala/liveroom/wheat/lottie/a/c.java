package com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b;
import java.io.File;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class c {
    public static String oLy = "audio_anim_md5_";

    public static void b(final String str, final String str2, final b.a aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !WQ(str)) {
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    return Boolean.valueOf(c.WR(str2));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass1) bool);
                    if (bool.booleanValue()) {
                        if (aVar != null) {
                            aVar.An(true);
                            return;
                        }
                        return;
                    }
                    b.a(str, str2, aVar);
                }
            }.execute(new Void[0]);
        }
    }

    private static boolean WQ(String str) {
        return FileSerialDownLoader.getInstance().isDownloading(str, 23);
    }

    public static boolean WR(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String str2 = oLy + str;
        String it = it(com.baidu.live.storage.b.hM(str));
        return com.baidu.live.h.a.existFile(it) && com.baidu.live.h.a.isDirectory(it) && !com.baidu.live.h.b.b(it, com.baidu.live.h.b.fI(str2));
    }

    public static void gZ(String str, String str2) {
        File[] listFiles;
        String fileMd5;
        if (!TextUtils.isEmpty(str)) {
            String it = it(str2);
            if (com.baidu.live.h.a.existFile(it) && com.baidu.live.h.a.isDirectory(it) && (listFiles = new File(it).listFiles()) != null) {
                JSONArray jSONArray = new JSONArray();
                for (File file : listFiles) {
                    if (file != null && !file.isDirectory() && (fileMd5 = com.baidu.live.h.a.getFileMd5(file)) != null) {
                        jSONArray.put(fileMd5);
                    }
                }
                d.xf().putString(oLy + str, jSONArray.toString());
            }
        }
    }

    public static String it(String str) {
        if (com.baidu.live.h.a.existFile(str)) {
            if (!com.baidu.live.h.a.isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return null;
            }
            File[] listFiles = new File(str).listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            if (listFiles.length == 1 && listFiles[0] != null && listFiles[0].isDirectory()) {
                return it(listFiles[0].getAbsolutePath());
            }
            return str;
        }
        return null;
    }
}
