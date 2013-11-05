package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.f2026a = wVar;
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
        this.f2026a.p();
    }
}
