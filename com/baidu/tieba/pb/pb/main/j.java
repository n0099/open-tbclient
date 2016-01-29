package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.b.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class j implements c.a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        dz dzVar;
        com.baidu.tbadk.editortools.d.e eVar;
        dz dzVar2;
        dz dzVar3;
        com.baidu.tbadk.editortools.d.e eVar2;
        dz dzVar4;
        com.baidu.tbadk.editortools.d.e eVar3;
        dzVar = this.cNq.cMK;
        dzVar.fE(false);
        eVar = this.cNq.cMU;
        if (eVar != null) {
            dzVar4 = this.cNq.cMK;
            eVar3 = this.cNq.cMU;
            dzVar4.ep(eVar3.Dk());
        }
        dzVar2 = this.cNq.cMK;
        dzVar2.aE(view);
        dzVar3 = this.cNq.cMK;
        dzVar3.fE(true);
        eVar2 = this.cNq.cMU;
        eVar2.Dn();
        return true;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        dz dzVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        dz dzVar2;
        dz dzVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        boolean aA;
        if (view != null && view.getId() == t.g.richText) {
            aA = this.cNq.aA(view);
            if (aA) {
                return true;
            }
        }
        eVar = this.cNq.cMU;
        if (eVar != null) {
            dzVar3 = this.cNq.cMK;
            eVar3 = this.cNq.cMU;
            dzVar3.ep(eVar3.Dk());
        }
        dzVar = this.cNq.cMK;
        dzVar.aqT();
        eVar2 = this.cNq.cMU;
        eVar2.Dn();
        dzVar2 = this.cNq.cMK;
        dzVar2.ajp();
        return false;
    }
}
