package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bk bkVar) {
        this.f1243a = bkVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (motionEvent.getAction() == 1) {
            z = this.f1243a.an;
            if (!z && !this.f1243a.y()) {
                this.f1243a.z();
                this.f1243a.V();
                this.f1243a.f1229a.setSelection(this.f1243a.f1229a.getText().length());
                this.f1243a.f1229a.requestFocus();
                gVar = this.f1243a.b;
                gVar.a(this.f1243a.f1229a, 100);
                if (TiebaApplication.f().t()) {
                    gVar2 = this.f1243a.b;
                    StatService.onEvent(gVar2, "pb_reply", "pbclick", 1);
                }
            }
        }
        return false;
    }
}
