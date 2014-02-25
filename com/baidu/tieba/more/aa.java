package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class aa implements DialogInterface.OnClickListener {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(v vVar) {
        this.a = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TiebaApplication.g().c(1);
                break;
            case 1:
                TiebaApplication.g().c(2);
                break;
            case 2:
                TiebaApplication.g().c(3);
                break;
        }
        this.a.t();
    }
}
