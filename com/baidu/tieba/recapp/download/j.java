package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class j {
    private final RemoteViews gDY = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), e.h.download_notify_view);

    public j(DownloadData downloadData, int i) {
        sZ(i);
        this.gDY.setTextViewText(e.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(e.j.on_downloading));
        this.gDY.setImageViewResource(e.g.download_btn, e.f.notify_pause_bg);
        this.gDY.setImageViewResource(e.g.download_cancel, e.f.notify_cancel_bg);
        this.gDY.setTextViewText(e.g.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.jC().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.j.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (j.this.gDY != null && aVar != null && aVar.os() != null) {
                    j.this.gDY.setImageViewBitmap(e.g.app_icon, aVar.os());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.gDY.setOnClickPendingIntent(e.g.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.gDY.setOnClickPendingIntent(e.g.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews btu() {
        return this.gDY;
    }

    public void btv() {
        this.gDY.setTextViewText(e.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(e.j.on_downloading));
        this.gDY.setImageViewResource(e.g.download_btn, e.f.notify_pause_bg);
    }

    public void btw() {
        this.gDY.setTextViewText(e.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(e.j.downloading_app_paused));
        this.gDY.setImageViewResource(e.g.download_btn, e.f.notify_start_bg);
    }

    public void sZ(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.gDY.setProgressBar(e.g.download_progress, 100, i, false);
        this.gDY.setTextViewText(e.g.download_progress_text, str);
    }
}
