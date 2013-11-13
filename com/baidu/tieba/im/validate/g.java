package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1809a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f1809a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        Button button;
        ValidateItemData validateItemData;
        validateActivity = this.f1809a.i;
        button = this.f1809a.h;
        validateItemData = this.f1809a.j;
        validateActivity.a(button, 100, 0, 0L, validateItemData);
    }
}
