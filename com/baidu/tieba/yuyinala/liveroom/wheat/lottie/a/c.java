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
    public static String ogq = "dating_anim_md5_";

    public static void b(final String str, final String str2, final b.a aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !VU(str)) {
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    return Boolean.valueOf(c.VV(str2));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass1) bool);
                    if (bool.booleanValue()) {
                        if (aVar != null) {
                            aVar.zm(true);
                            return;
                        }
                        return;
                    }
                    b.a(str, str2, aVar);
                }
            }.execute(new Void[0]);
        }
    }

    private static boolean VU(String str) {
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (DownloadData downloadData : downloadList) {
                if (22 == downloadData.getType() && downloadData.getUrl().equals(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean VV(String str) {
        if (StringUtils.isNull(str, true)) {
            return false;
        }
        String str2 = ogq + str;
        String VW = VW(com.baidu.live.ac.b.ij(str));
        return com.baidu.live.f.a.existFile(VW) && com.baidu.live.f.a.isDirectory(VW) && !com.baidu.live.f.b.b(VW, com.baidu.live.f.b.gu(str2));
    }

    public static void gO(String str, String str2) {
        File[] listFiles;
        String fileMd5;
        if (!TextUtils.isEmpty(str)) {
            String VW = VW(str2);
            if (com.baidu.live.f.a.existFile(VW) && com.baidu.live.f.a.isDirectory(VW) && (listFiles = new File(VW).listFiles()) != null) {
                JSONArray jSONArray = new JSONArray();
                for (File file : listFiles) {
                    if (file != null && !file.isDirectory() && (fileMd5 = com.baidu.live.f.a.getFileMd5(file)) != null) {
                        jSONArray.put(fileMd5);
                    }
                }
                d.AZ().putString(ogq + str, jSONArray.toString());
            }
        }
    }

    public static String VW(String str) {
        if (com.baidu.live.f.a.existFile(str)) {
            if (!com.baidu.live.f.a.isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return null;
            }
            File[] listFiles = new File(str).listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            if (listFiles.length == 1 && listFiles[0] != null && listFiles[0].isDirectory()) {
                return VW(listFiles[0].getAbsolutePath());
            }
            return str;
        }
        return null;
    }
}
