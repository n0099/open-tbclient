package com.baidu.tieba.person;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonLbsActivity f1339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonLbsActivity personLbsActivity) {
        this.f1339a = personLbsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        imageView = this.f1339a.e;
        if (view != imageView) {
            imageView2 = this.f1339a.f;
            if (view != imageView2) {
                return;
            }
            this.f1339a.b(0, 1);
            return;
        }
        this.f1339a.finish();
    }
}
