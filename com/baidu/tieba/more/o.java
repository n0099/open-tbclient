package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.a = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.h.a().b(0);
                break;
            case 1:
                com.baidu.tbadk.core.h.a().b(1);
                break;
            case 2:
                com.baidu.tbadk.core.h.a().b(2);
                break;
            case 3:
                com.baidu.tbadk.core.h.a().b(3);
                break;
        }
        this.a.y();
        this.a.n();
        bb.a().h();
    }
}
