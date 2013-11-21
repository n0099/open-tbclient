package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.FileDownloader;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewPbActivity newPbActivity) {
        this.f2074a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!com.baidu.tieba.util.af.a()) {
            this.f2074a.showToast(com.baidu.tieba.util.af.b());
        } else {
            FileDownloader.a(this.f2074a, "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.f2074a.getString(R.string.download_baidu_video));
        }
    }
}
