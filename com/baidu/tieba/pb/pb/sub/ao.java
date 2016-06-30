package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements d.a {
    final /* synthetic */ af dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(af afVar) {
        this.dXy = afVar;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        this.dXy.hK(false);
        this.dXy.aY(view);
        this.dXy.hK(true);
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
