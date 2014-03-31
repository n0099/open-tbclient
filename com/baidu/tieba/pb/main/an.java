package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import com.baidu.tieba.FileDownloader;
/* loaded from: classes.dex */
final class an implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!com.baidu.tbadk.core.util.w.a()) {
            this.a.showToast(com.baidu.tbadk.core.util.w.b());
        } else {
            FileDownloader.a(this.a, "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.a.getString(com.baidu.tieba.a.k.download_baidu_video));
        }
    }
}
