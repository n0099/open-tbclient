package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1496a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bn bnVar) {
        this.f1496a = bnVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (motionEvent.getAction() == 1) {
            z = this.f1496a.an;
            if (!z && !this.f1496a.y()) {
                this.f1496a.z();
                this.f1496a.V();
                this.f1496a.f1482a.setSelection(this.f1496a.f1482a.getText().length());
                this.f1496a.f1482a.requestFocus();
                gVar = this.f1496a.b;
                gVar.a(this.f1496a.f1482a, 100);
                if (TiebaApplication.f().t()) {
                    gVar2 = this.f1496a.b;
                    StatService.onEvent(gVar2, "pb_reply", "pbclick", 1);
                }
            }
        }
        return false;
    }
}
