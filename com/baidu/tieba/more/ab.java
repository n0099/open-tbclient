package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ab implements DialogInterface.OnClickListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.a = yVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MoreActivity moreActivity;
        switch (i) {
            case 0:
                TiebaApplication.a().n(true);
                break;
            case 1:
                TiebaApplication.a().n(false);
                break;
        }
        moreActivity = this.a.a;
        moreActivity.p();
    }
}
