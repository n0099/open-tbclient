package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2024a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f2024a = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TiebaApplication.g().s(true);
                TiebaApplication.g().f(0);
                break;
            case 1:
                TiebaApplication.g().s(true);
                TiebaApplication.g().f(1);
                break;
            case 2:
                TiebaApplication.g().s(true);
                TiebaApplication.g().f(2);
                break;
            case 3:
                TiebaApplication.g().s(false);
                break;
        }
        this.f2024a.z();
    }
}
