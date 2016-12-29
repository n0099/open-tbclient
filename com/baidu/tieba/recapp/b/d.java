package com.baidu.tieba.recapp.b;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d {
    private final RemoteViews eOq = new RemoteViews(TbadkCoreApplication.m9getInst().getPackageName(), r.h.download_notify_view);

    public d(DownloadData downloadData, int i) {
        qi(i);
        this.eOq.setTextViewText(r.g.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(r.j.downloading_app));
        this.eOq.setImageViewResource(r.g.download_btn, r.f.notify_pause_bg);
        this.eOq.setImageViewResource(r.g.download_cancel, r.f.notify_cancel_bg);
        this.eOq.setTextViewText(r.g.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.g.c.eA().a(downloadData.getApp_icon(), 17, new e(this), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.m9getInst().getContext(), DownloadReceiver.class);
        intent.setAction(DownloadReceiver.ACTION_PAUSE_DOWNLOAD);
        intent.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.eOq.setOnClickPendingIntent(r.g.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.m9getInst().getContext(), DownloadReceiver.class);
        intent2.setAction(DownloadReceiver.ACTION_CANCEL_DOWNLOAD);
        intent2.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.eOq.setOnClickPendingIntent(r.g.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews aYk() {
        return this.eOq;
    }

    public void aYl() {
        this.eOq.setTextViewText(r.g.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(r.j.downloading_app));
        this.eOq.setImageViewResource(r.g.download_btn, r.f.notify_pause_bg);
    }

    public void aYm() {
        this.eOq.setTextViewText(r.g.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(r.j.downloading_app_paused));
        this.eOq.setImageViewResource(r.g.download_btn, r.f.notify_start_bg);
    }

    public void qi(int i) {
        String str;
        if (i > 0) {
            str = String.valueOf(i) + "%";
        } else {
            str = "0%";
        }
        this.eOq.setProgressBar(r.g.download_progress, 100, i, false);
        this.eOq.setTextViewText(r.g.download_progress_text, str);
    }
}
