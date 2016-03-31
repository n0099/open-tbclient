package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements c.a {
    final /* synthetic */ x dpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(x xVar) {
        this.dpf = xVar;
    }

    @Override // com.baidu.tieba.pb.a.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        this.dpf.go(false);
        this.dpf.aM(view);
        this.dpf.go(true);
        return true;
    }

    @Override // com.baidu.tieba.pb.a.c.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.a.c.a
    public boolean c(View view, MotionEvent motionEvent) {
        return true;
    }
}
