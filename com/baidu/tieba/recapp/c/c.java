package com.baidu.tieba.recapp.c;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private final RemoteViews fHa = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), d.j.download_notify_view);

    public c(DownloadData downloadData, int i) {
        sb(i);
        this.fHa.setTextViewText(d.h.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.l.downloading_app));
        this.fHa.setImageViewResource(d.h.download_btn, d.g.notify_pause_bg);
        this.fHa.setImageViewResource(d.h.download_cancel, d.g.notify_cancel_bg);
        this.fHa.setTextViewText(d.h.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.fU().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (c.this.fHa != null && aVar != null && aVar.kX() != null) {
                    c.this.fHa.setImageViewBitmap(d.h.app_icon, aVar.kX());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setAction(DownloadReceiver.ACTION_PAUSE_DOWNLOAD);
        intent.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.fHa.setOnClickPendingIntent(d.h.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction(DownloadReceiver.ACTION_CANCEL_DOWNLOAD);
        intent2.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.fHa.setOnClickPendingIntent(d.h.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews bir() {
        return this.fHa;
    }

    public void bis() {
        this.fHa.setTextViewText(d.h.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.l.downloading_app));
        this.fHa.setImageViewResource(d.h.download_btn, d.g.notify_pause_bg);
    }

    public void bit() {
        this.fHa.setTextViewText(d.h.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.l.downloading_app_paused));
        this.fHa.setImageViewResource(d.h.download_btn, d.g.notify_start_bg);
    }

    public void sb(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.fHa.setProgressBar(d.h.download_progress, 100, i, false);
        this.fHa.setTextViewText(d.h.download_progress_text, str);
    }
}
