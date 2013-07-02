package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnTouchListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (motionEvent.getAction() == 1) {
            z = this.a.an;
            if (!z && !this.a.y()) {
                this.a.z();
                this.a.V();
                this.a.a.setSelection(this.a.a.getText().length());
                this.a.a.requestFocus();
                gVar = this.a.b;
                gVar.a(this.a.a, 100);
                if (TiebaApplication.f().t()) {
                    gVar2 = this.a.b;
                    StatService.onEvent(gVar2, "pb_reply", "pbclick", 1);
                }
            }
        }
        return false;
    }
}
