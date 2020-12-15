package com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class c {
    public static String owV = "dating_anim_md5_";

    public static void b(final String str, final String str2, final b.a aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !WU(str)) {
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    return Boolean.valueOf(c.WV(str2));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass1) bool);
                    if (bool.booleanValue()) {
                        if (aVar != null) {
                            aVar.zX(true);
                            return;
                        }
                        return;
                    }
                    b.a(str, str2, aVar);
                }
            }.execute(new Void[0]);
        }
    }

    private static boolean WU(String str) {
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (DownloadData downloadData : downloadList) {
                if (23 == downloadData.getType() && downloadData.getUrl().equals(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean WV(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String str2 = owV + str;
        String WW = WW(com.baidu.live.ag.b.iH(str));
        return com.baidu.live.h.a.existFile(WW) && com.baidu.live.h.a.isDirectory(WW) && !com.baidu.live.h.b.b(WW, com.baidu.live.h.b.gJ(str2));
    }

    public static void gT(String str, String str2) {
        File[] listFiles;
        String fileMd5;
        if (!TextUtils.isEmpty(str)) {
            String WW = WW(str2);
            if (com.baidu.live.h.a.existFile(WW) && com.baidu.live.h.a.isDirectory(WW) && (listFiles = new File(WW).listFiles()) != null) {
                JSONArray jSONArray = new JSONArray();
                for (File file : listFiles) {
                    if (file != null && !file.isDirectory() && (fileMd5 = com.baidu.live.h.a.getFileMd5(file)) != null) {
                        jSONArray.put(fileMd5);
                    }
                }
                d.BM().putString(owV + str, jSONArray.toString());
            }
        }
    }

    public static String WW(String str) {
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
                return WW(listFiles[0].getAbsolutePath());
            }
            return str;
        }
        return null;
    }
}
