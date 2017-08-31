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
    private final RemoteViews fFa = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), d.j.download_notify_view);

    public c(DownloadData downloadData, int i) {
        rY(i);
        this.fFa.setTextViewText(d.h.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.l.on_downloading));
        this.fFa.setImageViewResource(d.h.download_btn, d.g.notify_pause_bg);
        this.fFa.setImageViewResource(d.h.download_cancel, d.g.notify_cancel_bg);
        this.fFa.setTextViewText(d.h.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.fK().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.recapp.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (c.this.fFa != null && aVar != null && aVar.kO() != null) {
                    c.this.fFa.setImageViewBitmap(d.h.app_icon, aVar.kO());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setAction(DownloadReceiver.ACTION_PAUSE_DOWNLOAD);
        intent.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.fFa.setOnClickPendingIntent(d.h.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction(DownloadReceiver.ACTION_CANCEL_DOWNLOAD);
        intent2.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.fFa.setOnClickPendingIntent(d.h.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews bhl() {
        return this.fFa;
    }

    public void bhm() {
        this.fFa.setTextViewText(d.h.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.l.on_downloading));
        this.fFa.setImageViewResource(d.h.download_btn, d.g.notify_pause_bg);
    }

    public void bhn() {
        this.fFa.setTextViewText(d.h.download_status_text, TbadkCoreApplication.getInst().getResources().getString(d.l.downloading_app_paused));
        this.fFa.setImageViewResource(d.h.download_btn, d.g.notify_start_bg);
    }

    public void rY(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.fFa.setProgressBar(d.h.download_progress, 100, i, false);
        this.fFa.setTextViewText(d.h.download_progress_text, str);
    }
}
