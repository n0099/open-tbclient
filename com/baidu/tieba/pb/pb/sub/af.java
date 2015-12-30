package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.b.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements c.a {
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(w wVar) {
        this.cLC = wVar;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        this.cLC.fo(false);
        this.cLC.ao(view);
        this.cLC.fo(true);
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
