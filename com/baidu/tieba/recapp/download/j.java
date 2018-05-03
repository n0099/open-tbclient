package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class j {
    private final RemoteViews fXD = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), d.i.download_notify_view);

    public j(DownloadData downloadData, int i) {
        rM(i);
        this.fXD.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.k.on_downloading));
        this.fXD.setImageViewResource(d.g.download_btn, d.f.notify_pause_bg);
        this.fXD.setImageViewResource(d.g.download_cancel, d.f.notify_cancel_bg);
        this.fXD.setTextViewText(d.g.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.fp().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.j.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (j.this.fXD != null && aVar != null && aVar.km() != null) {
                    j.this.fXD.setImageViewBitmap(d.g.app_icon, aVar.km());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.fXD.setOnClickPendingIntent(d.g.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.fXD.setOnClickPendingIntent(d.g.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews bju() {
        return this.fXD;
    }

    public void bjv() {
        this.fXD.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.k.on_downloading));
        this.fXD.setImageViewResource(d.g.download_btn, d.f.notify_pause_bg);
    }

    public void bjw() {
        this.fXD.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.k.downloading_app_paused));
        this.fXD.setImageViewResource(d.g.download_btn, d.f.notify_start_bg);
    }

    public void rM(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.fXD.setProgressBar(d.g.download_progress, 100, i, false);
        this.fXD.setTextViewText(d.g.download_progress_text, str);
    }
}
