package com.baidu.tieba.recapp.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes13.dex */
public class RecAppDownloadReceiver extends BroadcastReceiver {
    public static final String ACTION_CANCEL_DOWNLOAD = "action_cancel_download";
    public static final String ACTION_PAUSE_DOWNLOAD = "action_pause_download";
    public static final String DOWNLOAD_DATA = "download_data";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DownloadData downloadData = (DownloadData) intent.getSerializableExtra("download_data");
        if (downloadData != null) {
            int status = i.getStatus(downloadData);
            if ("action_pause_download".equals(intent.getAction())) {
                if (downloadData.getDownloadStaticsData() != null) {
                    downloadData.getDownloadStaticsData().setDa_range_nt("1");
                }
                if (status == 7) {
                    downloadData.setStatus(5);
                    i.cCF().a(downloadData.getId(), downloadData.getUrl(), downloadData.getName(), downloadData.getPosition(), downloadData.getNotifyId(), downloadData.getTag(), downloadData.isNeedInvokeApk(), downloadData.isForceDownload(), downloadData.isNeedNotify(), downloadData.getApp_icon(), downloadData.getDownloadStaticsData(), downloadData.getUser_name());
                    i.cCF().i(downloadData);
                } else if (status == 1 || status == 5) {
                    downloadData.setStatus(4);
                    i.cCF().A(downloadData.getUrl(), downloadData.getId(), true);
                    i.cCF().k(downloadData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, downloadData));
            } else if ("action_cancel_download".equals(intent.getAction())) {
                i.cCF().m(downloadData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, downloadData));
            }
        }
    }
}
