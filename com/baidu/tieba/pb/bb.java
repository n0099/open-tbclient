package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.f1505a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        StatService.onEvent(this.f1505a, "pb_close_phonedialog", "close");
        dialogInterface.cancel();
    }
}
