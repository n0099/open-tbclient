package com.baidu.tieba.person;

import android.view.ViewTreeObserver;
import com.baidu.tieba.view.UserIconBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        userIconBox = this.a.y;
        userIconBox.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        bc bcVar = this.a;
        userIconBox2 = this.a.y;
        bcVar.C = userIconBox2.getMeasuredWidth();
        this.a.f();
    }
}
