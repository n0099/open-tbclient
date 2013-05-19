package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnTouchListener {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bl blVar) {
        this.a = blVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.baidu.tieba.e eVar;
        com.baidu.tieba.e eVar2;
        if (motionEvent.getAction() == 1) {
            z = this.a.ao;
            if (!z) {
                this.a.y();
                this.a.U();
                this.a.a.setSelection(this.a.a.getText().length());
                this.a.a.requestFocus();
                eVar = this.a.b;
                eVar.a(this.a.a, 100);
                if (TiebaApplication.d().n()) {
                    eVar2 = this.a.b;
                    StatService.onEvent(eVar2, "pb_reply", "pbclick", 1);
                }
            }
        }
        return false;
    }
}
