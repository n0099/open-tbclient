package com.baidu.tieba.person;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.view.UserIconBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        userIconBox = this.a.v;
        userIconBox.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        aj ajVar = this.a;
        userIconBox2 = this.a.v;
        ajVar.z = userIconBox2.getMeasuredWidth();
        this.a.g();
    }
}
