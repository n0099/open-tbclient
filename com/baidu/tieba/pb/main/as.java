package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!com.baidu.tbadk.core.util.s.bN()) {
            this.bzj.showToast(com.baidu.tbadk.core.util.s.op());
        } else {
            FileDownloader.download(this.bzj.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.bzj.getPageContext().getString(com.baidu.tieba.z.download_baidu_video));
        }
    }
}
