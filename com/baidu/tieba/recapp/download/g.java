package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g {
    private final RemoteViews muc = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), R.layout.download_notify_view);

    public g(DownloadData downloadData, int i) {
        HS(i);
        this.muc.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.muc.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
        this.muc.setImageViewResource(R.id.download_cancel, R.drawable.notify_cancel_bg);
        this.muc.setTextViewText(R.id.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.e.c.mS().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.g.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (g.this.muc != null && aVar != null && aVar.getRawBitmap() != null) {
                    g.this.muc.setImageViewBitmap(R.id.app_icon, aVar.getRawBitmap());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        this.muc.setOnClickPendingIntent(R.id.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.muc.setOnClickPendingIntent(R.id.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews dAx() {
        return this.muc;
    }

    public void dAy() {
        this.muc.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.muc.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
    }

    public void dAz() {
        this.muc.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.downloading_app_paused));
        this.muc.setImageViewResource(R.id.download_btn, R.drawable.notify_start_bg);
    }

    public void HS(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.muc.setProgressBar(R.id.download_progress, 100, i, false);
        this.muc.setTextViewText(R.id.download_progress_text, str);
    }
}
