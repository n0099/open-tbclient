package com.baidu.tieba.recapp.download;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.recapp.t;
import java.io.File;
/* loaded from: classes8.dex */
public class j implements com.baidu.tbadk.download.c {
    @Override // com.baidu.tbadk.download.c
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData != null) {
            SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0);
            long j = sharedPreferences.getLong(downloadData.getId(), 0L);
            if (j <= 1 || (downloadData.getSize() > 1 && j != downloadData.getSize())) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(downloadData.getId(), downloadData.getSize());
                edit.commit();
            }
            i.dDF().c(downloadData);
            i.dDF().b(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public boolean onFileDownloaded(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void onFileDownloadSucceed(DownloadData downloadData) {
        if (downloadData != null) {
            String[] tag = downloadData.getTag();
            if (tag != null && tag.length == 3) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "dl_game_success", "click", 1, "dev_id", downloadData.getId(), "ref_id", tag[0], "is_detail", tag[2], "ref_type", tag[1]);
            }
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
            i.dDF().b(downloadData);
            String path = downloadData.getPath();
            String Rl = TextUtils.isEmpty(path) ? com.baidu.tieba.recapp.b.Rl(downloadData.getId()) : path;
            com.baidu.tieba.ad.download.b.a.ghF.get().bLH().onSuccess(downloadData.getId(), Rl);
            if (downloadData.isNeedInvokeApk() && !t.Rx(Rl)) {
                com.baidu.tieba.recapp.b.deleteFileOrDir(new File(Rl));
            }
        }
    }

    @Override // com.baidu.tbadk.download.c
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        i dDF = i.dDF();
        if (i == 3) {
            dDF.k(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, downloadData));
        } else {
            dDF.l(downloadData);
        }
        i.dDF().b(downloadData);
    }
}
