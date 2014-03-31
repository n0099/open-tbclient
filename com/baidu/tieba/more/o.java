package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class o implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TbadkApplication.j().d(1);
                break;
            case 1:
                TbadkApplication.j().d(2);
                break;
            case 2:
                TbadkApplication.j().d(3);
                break;
        }
        this.a.o();
    }
}
