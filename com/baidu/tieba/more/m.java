package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.a = jVar;
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
        bh.a().h();
    }
}
