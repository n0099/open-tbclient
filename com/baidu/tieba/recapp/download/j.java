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
    private final RemoteViews ihP = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), d.h.download_notify_view);

    public j(DownloadData downloadData, int i) {
        xQ(i);
        this.ihP.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.j.on_downloading));
        this.ihP.setImageViewResource(d.g.download_btn, d.f.notify_pause_bg);
        this.ihP.setImageViewResource(d.g.download_cancel, d.f.notify_cancel_bg);
        this.ihP.setTextViewText(d.g.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.jB().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.j.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (j.this.ihP != null && aVar != null && aVar.oy() != null) {
                    j.this.ihP.setImageViewBitmap(d.g.app_icon, aVar.oy());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.ihP.setOnClickPendingIntent(d.g.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.ihP.setOnClickPendingIntent(d.g.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews bWQ() {
        return this.ihP;
    }

    public void bWR() {
        this.ihP.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.j.on_downloading));
        this.ihP.setImageViewResource(d.g.download_btn, d.f.notify_pause_bg);
    }

    public void bWS() {
        this.ihP.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.j.downloading_app_paused));
        this.ihP.setImageViewResource(d.g.download_btn, d.f.notify_start_bg);
    }

    public void xQ(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.ihP.setProgressBar(d.g.download_progress, 100, i, false);
        this.ihP.setTextViewText(d.g.download_progress_text, str);
    }
}
