package com.baidu.tieba.recapp.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import d.a.o0.t2.c0.i;
/* loaded from: classes5.dex */
public class RecAppDownloadReceiver extends BroadcastReceiver {
    public static final String ACTION_CANCEL_DOWNLOAD = "action_cancel_download";
    public static final String ACTION_PAUSE_DOWNLOAD = "action_pause_download";
    public static final String DOWNLOAD_DATA = "download_data";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DownloadData downloadData = (DownloadData) intent.getSerializableExtra("download_data");
        if (downloadData == null) {
            return;
        }
        int n = i.n(downloadData);
        if ("action_pause_download".equals(intent.getAction())) {
            if (downloadData.getDownloadStaticsData() != null) {
                downloadData.getDownloadStaticsData().setDa_range_nt("1");
            }
            if (n == 7) {
                downloadData.setStatus(5);
                i.l().x(downloadData.getId(), downloadData.getUrl(), downloadData.getName(), downloadData.getPosition(), downloadData.getNotifyId(), downloadData.getTag(), downloadData.isNeedInvokeApk(), downloadData.isForceDownload(), downloadData.isNeedNotify(), downloadData.getApp_icon(), downloadData.getDownloadStaticsData(), downloadData.getUser_name());
                i.l().t(downloadData);
            } else if (n == 1 || n == 5) {
                downloadData.setStatus(4);
                i.l().g(downloadData.getUrl(), downloadData.getId(), true);
                i.l().q(downloadData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
        } else if ("action_cancel_download".equals(intent.getAction())) {
            i.l().i(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016483, downloadData));
        }
    }
}
