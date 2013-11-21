package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tieba.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2001a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.f2001a = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tieba.d.a.a().b(0);
                break;
            case 1:
                com.baidu.tieba.d.a.a().b(1);
                break;
            case 2:
                com.baidu.tieba.d.a.a().b(2);
                break;
            case 3:
                com.baidu.tieba.d.a.a().b(3);
                break;
        }
        this.f2001a.C();
        this.f2001a.q();
        bf.a().h();
    }
}
