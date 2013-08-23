package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bo boVar) {
        this.f1532a = boVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (motionEvent.getAction() == 1) {
            z = this.f1532a.ap;
            if (!z && !this.f1532a.z()) {
                this.f1532a.A();
                this.f1532a.W();
                this.f1532a.f1518a.setSelection(this.f1532a.f1518a.getText().length());
                this.f1532a.f1518a.requestFocus();
                gVar = this.f1532a.b;
                gVar.a(this.f1532a.f1518a, 100);
                if (TiebaApplication.g().u()) {
                    gVar2 = this.f1532a.b;
                    StatService.onEvent(gVar2, "pb_reply", "pbclick", 1);
                }
            }
        }
        return false;
    }
}
