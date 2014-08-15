package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!com.baidu.tbadk.core.util.s.a()) {
            this.a.showToast(com.baidu.tbadk.core.util.s.b());
        } else {
            FileDownloader.download(this.a, "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.a.getString(com.baidu.tieba.x.download_baidu_video));
        }
    }
}
