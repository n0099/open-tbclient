package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.util.bv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar) {
        this.a = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tieba.h.a.a().b(0);
                break;
            case 1:
                com.baidu.tieba.h.a.a().b(1);
                break;
            case 2:
                com.baidu.tieba.h.a.a().b(2);
                break;
            case 3:
                com.baidu.tieba.h.a.a().b(3);
                break;
        }
        this.a.C();
        this.a.q();
        bv.a().h();
    }
}
