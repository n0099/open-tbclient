package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ac implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.f1396a = abVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aa aaVar;
        switch (i) {
            case 0:
                TiebaApplication.f().e(1);
                break;
            case 1:
                TiebaApplication.f().e(2);
                break;
            case 2:
                TiebaApplication.f().e(3);
                break;
        }
        aaVar = this.f1396a.f1395a;
        aaVar.F();
    }
}
