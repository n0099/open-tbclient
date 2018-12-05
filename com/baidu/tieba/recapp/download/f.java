package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class f {
    private final RemoteViews gMp = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), e.h.download_notify_view);

    public f(DownloadData downloadData, int i) {
        tM(i);
        this.gMp.setTextViewText(e.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(e.j.on_downloading));
        this.gMp.setImageViewResource(e.g.download_btn, e.f.notify_pause_bg);
        this.gMp.setImageViewResource(e.g.download_cancel, e.f.notify_cancel_bg);
        this.gMp.setTextViewText(e.g.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.jA().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.f.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (f.this.gMp != null && aVar != null && aVar.op() != null) {
                    f.this.gMp.setImageViewBitmap(e.g.app_icon, aVar.op());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        this.gMp.setOnClickPendingIntent(e.g.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.gMp.setOnClickPendingIntent(e.g.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews buJ() {
        return this.gMp;
    }

    public void buK() {
        this.gMp.setTextViewText(e.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(e.j.on_downloading));
        this.gMp.setImageViewResource(e.g.download_btn, e.f.notify_pause_bg);
    }

    public void buL() {
        this.gMp.setTextViewText(e.g.download_status_text, TbadkCoreApplication.getInst().getResources().getString(e.j.downloading_app_paused));
        this.gMp.setImageViewResource(e.g.download_btn, e.f.notify_start_bg);
    }

    public void tM(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.gMp.setProgressBar(e.g.download_progress, 100, i, false);
        this.gMp.setTextViewText(e.g.download_progress_text, str);
    }
}
