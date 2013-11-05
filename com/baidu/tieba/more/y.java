package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2025a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.f2025a = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TiebaApplication.g().e(0);
                break;
            case 1:
                TiebaApplication.g().e(1);
                break;
            case 2:
                TiebaApplication.g().e(2);
                break;
            case 3:
                TiebaApplication.g().e(3);
                break;
        }
        this.f2025a.A();
        bd.a().f();
    }
}
