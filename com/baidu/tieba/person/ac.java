package com.baidu.tieba.person;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.view.UserIconBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.a = abVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        userIconBox = this.a.y;
        userIconBox.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        ab abVar = this.a;
        userIconBox2 = this.a.y;
        abVar.C = userIconBox2.getMeasuredWidth();
        this.a.b();
    }
}
