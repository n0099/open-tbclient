package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ab implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f1080a = aaVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        z zVar;
        switch (i) {
            case 0:
                TiebaApplication.f().g(1);
                break;
            case 1:
                TiebaApplication.f().g(2);
                break;
            case 2:
                TiebaApplication.f().g(3);
                break;
        }
        zVar = this.f1080a.f1079a;
        zVar.C();
    }
}
