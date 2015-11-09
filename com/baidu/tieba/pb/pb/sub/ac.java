package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.b.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements c.a {
    final /* synthetic */ v coo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.coo = vVar;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        this.coo.eL(false);
        this.coo.aa(view);
        this.coo.eL(true);
        return true;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean c(View view, MotionEvent motionEvent) {
        return true;
    }
}
