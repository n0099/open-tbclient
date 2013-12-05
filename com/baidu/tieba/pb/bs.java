package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(NewPbActivity newPbActivity) {
        this.f2193a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        StatService.onEvent(this.f2193a, "pb_close_phonedialog", "close");
        dialogInterface.cancel();
    }
}
