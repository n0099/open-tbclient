package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements d.a {
    final /* synthetic */ y dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(y yVar) {
        this.dqN = yVar;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        this.dqN.gR(false);
        this.dqN.aQ(view);
        this.dqN.gR(true);
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
