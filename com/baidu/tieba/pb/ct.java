package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements com.baidu.tieba.d.b {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.a = csVar;
    }

    @Override // com.baidu.tieba.d.b
    public boolean a(View view, MotionEvent motionEvent) {
        this.a.j(false);
        this.a.b(view);
        this.a.j(true);
        return true;
    }

    @Override // com.baidu.tieba.d.b
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.d.b
    public boolean c(View view, MotionEvent motionEvent) {
        this.a.Z();
        return false;
    }
}
