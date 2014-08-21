package com.baidu.tieba.person;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.view.UserIconBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        userIconBox = this.a.v;
        userIconBox.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        ak akVar = this.a;
        userIconBox2 = this.a.v;
        akVar.z = userIconBox2.getMeasuredWidth();
        this.a.g();
    }
}
