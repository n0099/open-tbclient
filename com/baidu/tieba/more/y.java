package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.f1508a = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TiebaApplication.g().a(1);
                break;
            case 1:
                TiebaApplication.g().a(0);
                break;
            case 2:
                TiebaApplication.g().a(2);
                break;
        }
        this.f1508a.o();
    }
}
