package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.FileDownloader;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewPbActivity newPbActivity) {
        this.f2182a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!com.baidu.tieba.util.x.a()) {
            this.f2182a.showToast(com.baidu.tieba.util.x.b());
        } else {
            FileDownloader.a(this.f2182a, "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.f2182a.getString(R.string.download_baidu_video));
        }
    }
}
