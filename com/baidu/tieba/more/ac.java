package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.a = zVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MoreActivity moreActivity;
        switch (i) {
            case 0:
                TiebaApplication.b().o(true);
                break;
            case 1:
                TiebaApplication.b().o(false);
                break;
        }
        moreActivity = this.a.a;
        moreActivity.r();
    }
}
