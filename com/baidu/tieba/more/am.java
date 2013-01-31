package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class am implements DialogInterface.OnClickListener {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MsgRemindActivity msgRemindActivity;
        switch (i) {
            case 0:
                TiebaApplication.b().j(true);
                break;
            case 1:
                TiebaApplication.b().j(false);
                break;
        }
        com.baidu.tieba.c.k.v();
        msgRemindActivity = this.a.a;
        msgRemindActivity.n();
    }
}
