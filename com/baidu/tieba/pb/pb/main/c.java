package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.b.c;
/* loaded from: classes.dex */
class c implements c.a {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        cb cbVar;
        com.baidu.tbadk.editortools.c.d dVar;
        cb cbVar2;
        cb cbVar3;
        com.baidu.tbadk.editortools.c.d dVar2;
        cb cbVar4;
        com.baidu.tbadk.editortools.c.d dVar3;
        cbVar = this.cbo.caQ;
        cbVar.ev(false);
        dVar = this.cbo.caX;
        if (dVar != null) {
            cbVar4 = this.cbo.caQ;
            dVar3 = this.cbo.caX;
            cbVar4.eA(dVar3.Br());
        }
        cbVar2 = this.cbo.caQ;
        cbVar2.Z(view);
        cbVar3 = this.cbo.caQ;
        cbVar3.ev(true);
        dVar2 = this.cbo.caX;
        dVar2.Bu();
        return true;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.c.d dVar;
        cb cbVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        cb cbVar2;
        cb cbVar3;
        com.baidu.tbadk.editortools.c.d dVar3;
        boolean U;
        if (view != null && view.getId() == i.f.richText) {
            U = this.cbo.U(view);
            if (U) {
                return true;
            }
        }
        dVar = this.cbo.caX;
        if (dVar != null) {
            cbVar3 = this.cbo.caQ;
            dVar3 = this.cbo.caX;
            cbVar3.eA(dVar3.Br());
        }
        cbVar = this.cbo.caQ;
        cbVar.aec();
        dVar2 = this.cbo.caX;
        dVar2.Bu();
        cbVar2 = this.cbo.caQ;
        cbVar2.aeA();
        return false;
    }
}
