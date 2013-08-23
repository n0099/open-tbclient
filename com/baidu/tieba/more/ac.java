package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ac implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.f1433a = abVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aa aaVar;
        switch (i) {
            case 0:
                TiebaApplication.g().d(1);
                break;
            case 1:
                TiebaApplication.g().d(2);
                break;
            case 2:
                TiebaApplication.g().d(3);
                break;
        }
        aaVar = this.f1433a.f1432a;
        aaVar.F();
    }
}
