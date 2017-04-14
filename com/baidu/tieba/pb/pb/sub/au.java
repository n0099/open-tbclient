package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements d.a {
    final /* synthetic */ ao etF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ao aoVar) {
        this.etF = aoVar;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        this.etF.iI(false);
        this.etF.aZ(view);
        this.etF.iI(true);
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean c(View view, MotionEvent motionEvent) {
        return true;
    }
}
