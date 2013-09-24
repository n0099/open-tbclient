package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.f1505a = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TiebaApplication.g().r(true);
                TiebaApplication.g().f(0);
                break;
            case 1:
                TiebaApplication.g().r(true);
                TiebaApplication.g().f(1);
                break;
            case 2:
                TiebaApplication.g().r(true);
                TiebaApplication.g().f(2);
                break;
            case 3:
                TiebaApplication.g().r(false);
                break;
        }
        this.f1505a.x();
    }
}
