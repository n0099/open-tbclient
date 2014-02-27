package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.do  reason: invalid class name */
/* loaded from: classes.dex */
public final class Cdo implements View.OnTouchListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 0;
    }
}
