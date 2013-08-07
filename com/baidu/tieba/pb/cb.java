package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bn bnVar) {
        this.f1494a = bnVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (motionEvent.getAction() == 1) {
            z = this.f1494a.an;
            if (!z && !this.f1494a.y()) {
                this.f1494a.z();
                this.f1494a.V();
                this.f1494a.f1480a.setSelection(this.f1494a.f1480a.getText().length());
                this.f1494a.f1480a.requestFocus();
                gVar = this.f1494a.b;
                gVar.a(this.f1494a.f1480a, 100);
                if (TiebaApplication.f().t()) {
                    gVar2 = this.f1494a.b;
                    StatService.onEvent(gVar2, "pb_reply", "pbclick", 1);
                }
            }
        }
        return false;
    }
}
