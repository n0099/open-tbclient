package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.home.ab abVar;
        com.baidu.tieba.home.ab abVar2;
        int intValue = ((Integer) view.getTag()).intValue();
        abVar = this.a.c;
        if (abVar.c() != null) {
            abVar2 = this.a.c;
            this.a.a(((com.baidu.tieba.a.ae) abVar2.c().get(intValue)).c(), intValue);
        }
    }
}
