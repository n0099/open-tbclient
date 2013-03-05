package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class aa implements DialogInterface.OnClickListener {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.a = zVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MoreActivity moreActivity;
        switch (i) {
            case 0:
                TiebaApplication.b().e(1);
                break;
            case 1:
                TiebaApplication.b().e(2);
                break;
            case 2:
                TiebaApplication.b().e(3);
                break;
        }
        moreActivity = this.a.a;
        moreActivity.q();
    }
}
