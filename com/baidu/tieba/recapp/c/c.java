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
    private final RemoteViews fXE = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), d.h.download_notify_view);

    public c(DownloadData downloadData, int i) {
        sS(i);
        this.fXE.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.j.on_downloading));
        this.fXE.setImageViewResource(d.g.download_btn, d.f.notify_pause_bg);
        this.fXE.setImageViewResource(d.g.download_cancel, d.f.notify_cancel_bg);
        this.fXE.setTextViewText(d.g.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.fJ().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (c.this.fXE != null && aVar != null && aVar.kK() != null) {
                    c.this.fXE.setImageViewBitmap(d.g.app_icon, aVar.kK());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setAction(DownloadReceiver.ACTION_PAUSE_DOWNLOAD);
        intent.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.fXE.setOnClickPendingIntent(d.g.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction(DownloadReceiver.ACTION_CANCEL_DOWNLOAD);
        intent2.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.fXE.setOnClickPendingIntent(d.g.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews blZ() {
        return this.fXE;
    }

    public void bma() {
        this.fXE.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.j.on_downloading));
        this.fXE.setImageViewResource(d.g.download_btn, d.f.notify_pause_bg);
    }

    public void bmb() {
        this.fXE.setTextViewText(d.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.j.downloading_app_paused));
        this.fXE.setImageViewResource(d.g.download_btn, d.f.notify_start_bg);
    }

    public void sS(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.fXE.setProgressBar(d.g.download_progress, 100, i, false);
        this.fXE.setTextViewText(d.g.download_progress_text, str);
    }
}
