package com.baidu.tieba.person;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ PersonLbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PersonLbsActivity personLbsActivity) {
        this.a = personLbsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        imageView = this.a.g;
        if (view != imageView) {
            imageView2 = this.a.h;
            if (view != imageView2) {
                return;
            }
            this.a.a(0, 1);
            return;
        }
        this.a.finish();
    }
}
