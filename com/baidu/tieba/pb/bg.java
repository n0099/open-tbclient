package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.FileDownloader;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!com.baidu.tieba.util.aa.a()) {
            this.a.showToast(com.baidu.tieba.util.aa.b());
        } else {
            FileDownloader.a(this.a, "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.a.getString(R.string.download_baidu_video));
        }
    }
}
