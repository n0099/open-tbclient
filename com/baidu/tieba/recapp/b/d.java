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
    private final RemoteViews eXT = new RemoteViews(TbadkCoreApplication.m9getInst().getPackageName(), r.j.download_notify_view);

    public d(DownloadData downloadData, int i) {
        qS(i);
        this.eXT.setTextViewText(r.h.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(r.l.downloading_app));
        this.eXT.setImageViewResource(r.h.download_btn, r.g.notify_pause_bg);
        this.eXT.setImageViewResource(r.h.download_cancel, r.g.notify_cancel_bg);
        this.eXT.setTextViewText(r.h.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.ey().a(downloadData.getApp_icon(), 17, new e(this), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.m9getInst().getContext(), DownloadReceiver.class);
        intent.setAction(DownloadReceiver.ACTION_PAUSE_DOWNLOAD);
        intent.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.eXT.setOnClickPendingIntent(r.h.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.m9getInst().getContext(), DownloadReceiver.class);
        intent2.setAction(DownloadReceiver.ACTION_CANCEL_DOWNLOAD);
        intent2.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.eXT.setOnClickPendingIntent(r.h.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.m9getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews baa() {
        return this.eXT;
    }

    public void bab() {
        this.eXT.setTextViewText(r.h.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(r.l.downloading_app));
        this.eXT.setImageViewResource(r.h.download_btn, r.g.notify_pause_bg);
    }

    public void bac() {
        this.eXT.setTextViewText(r.h.download_status_text, TbadkCoreApplication.m9getInst().getResources().getString(r.l.downloading_app_paused));
        this.eXT.setImageViewResource(r.h.download_btn, r.g.notify_start_bg);
    }

    public void qS(int i) {
        String str;
        if (i > 0) {
            str = String.valueOf(i) + "%";
        } else {
            str = "0%";
        }
        this.eXT.setProgressBar(r.h.download_progress, 100, i, false);
        this.eXT.setTextViewText(r.h.download_progress_text, str);
    }
}
