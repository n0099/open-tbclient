package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnClickListener {
    final /* synthetic */ PersonLbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PersonLbsActivity personLbsActivity) {
        this.a = personLbsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        button = this.a.g;
        if (view != button) {
            button2 = this.a.h;
            if (view != button2) {
                return;
            }
            this.a.a(0, 1);
            return;
        }
        this.a.finish();
    }
}
