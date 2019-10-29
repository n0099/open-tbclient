package com.baidu.tieba.recapp.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k {
    private final RemoteViews iIV = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), (int) R.layout.download_notify_view);

    public k(DownloadData downloadData, int i) {
        yj(i);
        this.iIV.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.iIV.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
        this.iIV.setImageViewResource(R.id.download_cancel, R.drawable.notify_cancel_bg);
        this.iIV.setTextViewText(R.id.downapp_name, downloadData.getUser_name());
        com.baidu.adp.lib.f.c.fT().a(downloadData.getApp_icon(), 17, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.download.k.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (k.this.iIV != null && aVar != null && aVar.getRawBitmap() != null) {
                    k.this.iIV.setImageViewBitmap(R.id.app_icon, aVar.getRawBitmap());
                }
            }
        }, BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent.setAction("action_pause_download");
        intent.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.iIV.setOnClickPendingIntent(R.id.download_btn, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), RecAppDownloadReceiver.class);
        intent2.setAction("action_cancel_download");
        intent2.putExtra("download_data", downloadData);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.iIV.setOnClickPendingIntent(R.id.download_cancel, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews cfV() {
        return this.iIV;
    }

    public void cfW() {
        this.iIV.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.on_downloading));
        this.iIV.setImageViewResource(R.id.download_btn, R.drawable.notify_pause_bg);
    }

    public void cfX() {
        this.iIV.setTextViewText(R.id.download_status_text, TbadkCoreApplication.getInst().getResources().getString(R.string.downloading_app_paused));
        this.iIV.setImageViewResource(R.id.download_btn, R.drawable.notify_start_bg);
    }

    public void yj(int i) {
        String str;
        if (i > 0) {
            str = i + "%";
        } else {
            str = "0%";
        }
        this.iIV.setProgressBar(R.id.download_progress, 100, i, false);
        this.iIV.setTextViewText(R.id.download_progress_text, str);
    }
}
