package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class g {
    private final RemoteViews lDk = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), R.layout.download_notify_view);

    public g(DownloadData downloadData, int i) {
        Gf(i);
        this.lDk.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.lDk.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
        this.lDk.setImageViewResource(R.id.download_cancel, R.drawable.notify_cancel_bg);
        this.lDk.setTextViewText(R.id.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.e.c.mM().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.g.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (g.this.lDk != null && aVar != null && aVar.getRawBitmap() != null) {
                    g.this.lDk.setImageViewBitmap(R.id.app_icon, aVar.getRawBitmap());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        this.lDk.setOnClickPendingIntent(R.id.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.lDk.setOnClickPendingIntent(R.id.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews dnq() {
        return this.lDk;
    }

    public void dnr() {
        this.lDk.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.lDk.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
    }

    public void dnt() {
        this.lDk.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.downloading_app_paused));
        this.lDk.setImageViewResource(R.id.download_btn, R.drawable.notify_start_bg);
    }

    public void Gf(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.lDk.setProgressBar(R.id.download_progress, 100, i, false);
        this.lDk.setTextViewText(R.id.download_progress_text, str);
    }
}
