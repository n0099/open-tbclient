package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class j {
    private final RemoteViews gpf = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), f.h.download_notify_view);

    public j(DownloadData downloadData, int i) {
        sf(i);
        this.gpf.setTextViewText(f.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(f.j.on_downloading));
        this.gpf.setImageViewResource(f.g.download_btn, f.C0146f.notify_pause_bg);
        this.gpf.setImageViewResource(f.g.download_cancel, f.C0146f.notify_cancel_bg);
        this.gpf.setTextViewText(f.g.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.ih().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.j.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (j.this.gpf != null && aVar != null && aVar.nb() != null) {
                    j.this.gpf.setImageViewBitmap(f.g.app_icon, aVar.nb());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.gpf.setOnClickPendingIntent(f.g.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.gpf.setOnClickPendingIntent(f.g.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews bny() {
        return this.gpf;
    }

    public void bnz() {
        this.gpf.setTextViewText(f.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(f.j.on_downloading));
        this.gpf.setImageViewResource(f.g.download_btn, f.C0146f.notify_pause_bg);
    }

    public void bnA() {
        this.gpf.setTextViewText(f.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(f.j.downloading_app_paused));
        this.gpf.setImageViewResource(f.g.download_btn, f.C0146f.notify_start_bg);
    }

    public void sf(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.gpf.setProgressBar(f.g.download_progress, 100, i, false);
        this.gpf.setTextViewText(f.g.download_progress_text, str);
    }
}
