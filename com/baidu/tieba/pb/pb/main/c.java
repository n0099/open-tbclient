package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.b.c;
/* loaded from: classes.dex */
class c implements c.a {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.ccj = pbActivity;
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
        cbVar = this.ccj.cbL;
        cbVar.eD(false);
        dVar = this.ccj.cbS;
        if (dVar != null) {
            cbVar4 = this.ccj.cbL;
            dVar3 = this.ccj.cbS;
            cbVar4.eI(dVar3.BE());
        }
        cbVar2 = this.ccj.cbL;
        cbVar2.Z(view);
        cbVar3 = this.ccj.cbL;
        cbVar3.eD(true);
        dVar2 = this.ccj.cbS;
        dVar2.BH();
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
            U = this.ccj.U(view);
            if (U) {
                return true;
            }
        }
        dVar = this.ccj.cbS;
        if (dVar != null) {
            cbVar3 = this.ccj.cbL;
            dVar3 = this.ccj.cbS;
            cbVar3.eI(dVar3.BE());
        }
        cbVar = this.ccj.cbL;
        cbVar.aeq();
        dVar2 = this.ccj.cbS;
        dVar2.BH();
        cbVar2 = this.ccj.cbL;
        cbVar2.aeO();
        return false;
    }
}
