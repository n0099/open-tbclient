package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!com.baidu.tbadk.core.util.s.bm()) {
            this.bvg.showToast(com.baidu.tbadk.core.util.s.lu());
        } else {
            FileDownloader.download(this.bvg, "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.bvg.getString(com.baidu.tieba.y.download_baidu_video));
        }
    }
}
