package com.baidu.tieba.newfaceshop;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private static volatile c lCu;
    public static final String lCv = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/";
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    public static c diB() {
        if (lCu == null) {
            synchronized (c.class) {
                if (lCu == null) {
                    lCu = new c();
                }
            }
        }
        return lCu;
    }

    public boolean v(List<String> list, boolean z) {
        int i;
        if (list == null || list.isEmpty()) {
            return false;
        }
        int i2 = 0;
        for (String str : list) {
            MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
            myEmotionGroupData.setGroupId(str);
            myEmotionGroupData.setUid(TbadkApplication.getCurrentAccount());
            if (com.baidu.tieba.faceshop.a.cyB().a(myEmotionGroupData)) {
                o.deleteFileOrDir(new File(lCv + str));
                i.cyR().JN(str);
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        if (i2 > 0) {
            MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
            if (z) {
                d.diF().diG();
            }
            return true;
        }
        return false;
    }

    public List<MyEmotionGroupData> diC() {
        try {
            List<MyEmotionGroupData> JG = com.baidu.tieba.faceshop.a.cyB().JG(TbadkCoreApplication.getCurrentAccount());
            Iterator<MyEmotionGroupData> it = JG.iterator();
            while (it.hasNext()) {
                MyEmotionGroupData next = it.next();
                if (next.getGroupId() != null && next.getGroupId().contains("collect_")) {
                    it.remove();
                }
            }
            return JG;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public MyEmotionGroupData OW(String str) {
        return com.baidu.tieba.faceshop.a.cyB().eS(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public boolean w(List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            i.cyR().i(list, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
            if (z) {
                d.diF().diG();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(String str, final com.baidu.tieba.newfaceshop.a.b bVar) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        bVar.onFail("url null");
                    }
                });
                return;
            }
            return;
        }
        final String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
        DownloadData downloadData = new DownloadData(nameMd5FromUrl, nameMd5FromUrl, str, new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.newfaceshop.c.2
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
            }

            @Override // com.baidu.tbadk.download.c
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.c
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                String str2;
                if (o.isGif(null, nameMd5FromUrl)) {
                    str2 = ".gif";
                } else {
                    str2 = ".jpg";
                }
                final String str3 = downloadData2.getPath() + str2;
                if (o.renameTo(downloadData2.getPath(), str3)) {
                    new z(TbadkApplication.getInst().getContext()).saveImage(str3);
                    if (bVar != null) {
                        c.this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bVar.onSuccess(str3);
                            }
                        });
                    }
                } else if (bVar != null) {
                    c.this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.c.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.onFail("rename failed");
                        }
                    });
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                if (bVar != null) {
                    c.this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.c.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.onFail("download failed");
                        }
                    });
                }
            }
        });
        downloadData.setPath((o.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/") + nameMd5FromUrl);
        com.baidu.tbadk.download.d.bBg().f(downloadData);
    }

    public void diD() {
        new BdAsyncTask<Void, Void, List<String>>() { // from class: com.baidu.tieba.newfaceshop.c.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public List<String> doInBackground(Void... voidArr) {
                return c.this.diE();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(List<String> list) {
                if (list != null && !list.isEmpty()) {
                    NewFaceGroupDownloadModel newFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
                    for (String str : list) {
                        newFaceGroupDownloadModel.a(str, false, null);
                    }
                }
            }
        }.execute(new Void[0]);
    }

    public boolean ur(boolean z) {
        List<String> diE = diE();
        if (diE.size() > 0) {
            if (z) {
                v(diE, false);
                return false;
            }
            return false;
        }
        return true;
    }

    public List<String> diE() {
        ArrayList arrayList = new ArrayList();
        for (MyEmotionGroupData myEmotionGroupData : diC()) {
            File file = new File(lCv + myEmotionGroupData.getGroupId());
            BdLog.e("getFileUnExistList Called:" + file.getName() + "   Exsists:" + file.exists());
            if (!file.exists()) {
                arrayList.add(myEmotionGroupData.getGroupId());
            }
        }
        return arrayList;
    }
}
