package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.f1506a = uVar;
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
        this.f1506a.y();
    }
}
