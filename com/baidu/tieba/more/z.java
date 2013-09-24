package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.f1509a = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TiebaApplication.g().g(1);
                break;
            case 1:
                TiebaApplication.g().g(2);
                break;
            case 2:
                TiebaApplication.g().g(3);
                break;
        }
        this.f1509a.p();
    }
}
