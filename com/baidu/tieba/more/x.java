package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.f1507a = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TiebaApplication.g().h(1);
                break;
            case 1:
                TiebaApplication.g().h(0);
                break;
            case 2:
                TiebaApplication.g().h(2);
                break;
        }
        this.f1507a.n();
    }
}
