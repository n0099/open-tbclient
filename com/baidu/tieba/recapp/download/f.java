package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f {
    private final RemoteViews gnS = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), d.i.download_notify_view);

    public f(DownloadData downloadData, int i) {
        sh(i);
        this.gnS.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.k.on_downloading));
        this.gnS.setImageViewResource(d.g.download_btn, d.f.notify_pause_bg);
        this.gnS.setImageViewResource(d.g.download_cancel, d.f.notify_cancel_bg);
        this.gnS.setTextViewText(d.g.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.ig().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (f.this.gnS != null && aVar != null && aVar.mZ() != null) {
                    f.this.gnS.setImageViewBitmap(d.g.app_icon, aVar.mZ());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        this.gnS.setOnClickPendingIntent(d.g.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.gnS.setOnClickPendingIntent(d.g.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews boT() {
        return this.gnS;
    }

    public void boU() {
        this.gnS.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.k.on_downloading));
        this.gnS.setImageViewResource(d.g.download_btn, d.f.notify_pause_bg);
    }

    public void boV() {
        this.gnS.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.k.downloading_app_paused));
        this.gnS.setImageViewResource(d.g.download_btn, d.f.notify_start_bg);
    }

    public void sh(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.gnS.setProgressBar(d.g.download_progress, 100, i, false);
        this.gnS.setTextViewText(d.g.download_progress_text, str);
    }
}
