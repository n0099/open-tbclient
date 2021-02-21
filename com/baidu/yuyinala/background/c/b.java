package com.baidu.yuyinala.background.c;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.yuyinala.background.c.a;
import java.io.File;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class b {
    public static String oWk = "video_bg_md5_";

    public static void b(final String str, final String str2, final a.InterfaceC0958a interfaceC0958a) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !WJ(str)) {
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.yuyinala.background.c.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    return Boolean.valueOf(b.WK(str2));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass1) bool);
                    if (bool.booleanValue()) {
                        if (interfaceC0958a != null) {
                            interfaceC0958a.Ao(true);
                            return;
                        }
                        return;
                    }
                    a.a(str, str2, interfaceC0958a);
                }
            }.execute(new Void[0]);
        }
    }

    private static boolean WJ(String str) {
        return FileSerialDownLoader.getInstance().isDownloading(str, 24);
    }

    public static boolean WK(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String str2 = oWk + str;
        String in = in(com.baidu.live.storage.b.hH(str));
        return com.baidu.live.h.a.existFile(in) && com.baidu.live.h.a.isDirectory(in) && !com.baidu.live.h.b.b(in, com.baidu.live.h.b.fC(str2));
    }

    public static boolean Yc(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String str2 = oWk + str;
        String in = in(com.baidu.live.storage.b.hH(str));
        return com.baidu.live.h.a.existFile(in) && com.baidu.live.h.a.isDirectory(in);
    }

    public static void gZ(String str, String str2) {
        File[] listFiles;
        String fileMd5;
        if (!TextUtils.isEmpty(str)) {
            String in = in(str2);
            if (com.baidu.live.h.a.existFile(in) && com.baidu.live.h.a.isDirectory(in) && (listFiles = new File(in).listFiles()) != null) {
                JSONArray jSONArray = new JSONArray();
                for (File file : listFiles) {
                    if (file != null && !file.isDirectory() && (fileMd5 = com.baidu.live.h.a.getFileMd5(file)) != null) {
                        jSONArray.put(fileMd5);
                    }
                }
                d.xc().putString(oWk + str, jSONArray.toString());
            }
        }
    }

    public static String in(String str) {
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
                return in(listFiles[0].getAbsolutePath());
            }
            return str;
        }
        return null;
    }
}
