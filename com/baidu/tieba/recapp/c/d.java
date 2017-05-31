package com.baidu.tieba.recapp.c;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    private final RemoteViews fgQ = new RemoteViews(TbadkCoreApplication.m9getInst().getPackageName(), w.j.download_notify_view);

    public d(DownloadData downloadData, int i) {
        ri(i);
        this.fgQ.setTextViewText(w.h.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(w.l.downloading_app));
        this.fgQ.setImageViewResource(w.h.download_btn, w.g.notify_pause_bg);
        this.fgQ.setImageViewResource(w.h.download_cancel, w.g.notify_cancel_bg);
        this.fgQ.setTextViewText(w.h.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.fM().a(downloadData.getApp_icon(), 17, new e(this), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.m9getInst().getContext(), DownloadReceiver.class);
        intent.setAction(DownloadReceiver.ACTION_PAUSE_DOWNLOAD);
        intent.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.fgQ.setOnClickPendingIntent(w.h.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.m9getInst().getContext(), DownloadReceiver.class);
        intent2.setAction(DownloadReceiver.ACTION_CANCEL_DOWNLOAD);
        intent2.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.fgQ.setOnClickPendingIntent(w.h.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews aZQ() {
        return this.fgQ;
    }

    public void aZR() {
        this.fgQ.setTextViewText(w.h.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(w.l.downloading_app));
        this.fgQ.setImageViewResource(w.h.download_btn, w.g.notify_pause_bg);
    }

    public void aZS() {
        this.fgQ.setTextViewText(w.h.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(w.l.downloading_app_paused));
        this.fgQ.setImageViewResource(w.h.download_btn, w.g.notify_start_bg);
    }

    public void ri(int i) {
        String str;
        if (i > 0) {
            str = String.valueOf(i) + "%";
        } else {
            str = "0%";
        }
        this.fgQ.setProgressBar(w.h.download_progress, 100, i, false);
        this.fgQ.setTextViewText(w.h.download_progress_text, str);
    }
}
