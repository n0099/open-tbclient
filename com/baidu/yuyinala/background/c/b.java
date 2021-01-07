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
    public static String oQf = "video_bg_md5_";

    public static void b(final String str, final String str2, final a.InterfaceC0969a interfaceC0969a) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !WF(str)) {
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.yuyinala.background.c.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    return Boolean.valueOf(b.WG(str2));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass1) bool);
                    if (bool.booleanValue()) {
                        if (interfaceC0969a != null) {
                            interfaceC0969a.zZ(true);
                            return;
                        }
                        return;
                    }
                    a.a(str, str2, interfaceC0969a);
                }
            }.execute(new Void[0]);
        }
    }

    private static boolean WF(String str) {
        return FileSerialDownLoader.getInstance().isDownloading(str, 24);
    }

    public static boolean WG(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String str2 = oQf + str;
        String WH = WH(com.baidu.live.ah.b.iw(str));
        return com.baidu.live.i.a.existFile(WH) && com.baidu.live.i.a.isDirectory(WH) && !com.baidu.live.i.b.b(WH, com.baidu.live.i.b.gt(str2));
    }

    public static boolean XY(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String str2 = oQf + str;
        String WH = WH(com.baidu.live.ah.b.iw(str));
        return com.baidu.live.i.a.existFile(WH) && com.baidu.live.i.a.isDirectory(WH);
    }

    public static void gR(String str, String str2) {
        File[] listFiles;
        String fileMd5;
        if (!TextUtils.isEmpty(str)) {
            String WH = WH(str2);
            if (com.baidu.live.i.a.existFile(WH) && com.baidu.live.i.a.isDirectory(WH) && (listFiles = new File(WH).listFiles()) != null) {
                JSONArray jSONArray = new JSONArray();
                for (File file : listFiles) {
                    if (file != null && !file.isDirectory() && (fileMd5 = com.baidu.live.i.a.getFileMd5(file)) != null) {
                        jSONArray.put(fileMd5);
                    }
                }
                d.Ba().putString(oQf + str, jSONArray.toString());
            }
        }
    }

    public static String WH(String str) {
        if (com.baidu.live.i.a.existFile(str)) {
            if (!com.baidu.live.i.a.isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return null;
            }
            File[] listFiles = new File(str).listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            if (listFiles.length == 1 && listFiles[0] != null && listFiles[0].isDirectory()) {
                return WH(listFiles[0].getAbsolutePath());
            }
            return str;
        }
        return null;
    }
}
