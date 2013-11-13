package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ab implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1970a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(w wVar) {
        this.f1970a = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
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
        this.f1970a.t();
    }
}
