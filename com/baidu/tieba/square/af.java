package com.baidu.tieba.square;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class af implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1817a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.f1817a = aeVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SquareSearchActivity squareSearchActivity;
        int i2;
        SquareSearchActivity squareSearchActivity2;
        SquareSearchActivity squareSearchActivity3;
        squareSearchActivity = this.f1817a.f1816a;
        i2 = squareSearchActivity.F;
        if (i2 == 0) {
            DatabaseService.q();
            squareSearchActivity3 = this.f1817a.f1816a;
            squareSearchActivity3.n();
            return;
        }
        DatabaseService.r();
        squareSearchActivity2 = this.f1817a.f1816a;
        squareSearchActivity2.p();
    }
}
