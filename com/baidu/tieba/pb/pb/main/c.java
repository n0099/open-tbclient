package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.b.c;
/* loaded from: classes.dex */
class c implements c.a {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        cc ccVar;
        com.baidu.tbadk.editortools.c.d dVar;
        cc ccVar2;
        cc ccVar3;
        com.baidu.tbadk.editortools.c.d dVar2;
        cc ccVar4;
        com.baidu.tbadk.editortools.c.d dVar3;
        ccVar = this.ciz.cia;
        ccVar.eI(false);
        dVar = this.ciz.cij;
        if (dVar != null) {
            ccVar4 = this.ciz.cia;
            dVar3 = this.ciz.cij;
            ccVar4.eN(dVar3.Br());
        }
        ccVar2 = this.ciz.cia;
        ccVar2.ab(view);
        ccVar3 = this.ciz.cia;
        ccVar3.eI(true);
        dVar2 = this.ciz.cij;
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
        cc ccVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        cc ccVar2;
        cc ccVar3;
        com.baidu.tbadk.editortools.c.d dVar3;
        boolean W;
        if (view != null && view.getId() == i.f.richText) {
            W = this.ciz.W(view);
            if (W) {
                return true;
            }
        }
        dVar = this.ciz.cij;
        if (dVar != null) {
            ccVar3 = this.ciz.cia;
            dVar3 = this.ciz.cij;
            ccVar3.eN(dVar3.Br());
        }
        ccVar = this.ciz.cia;
        ccVar.ago();
        dVar2 = this.ciz.cij;
        dVar2.Bu();
        ccVar2 = this.ciz.cia;
        ccVar2.agM();
        return false;
    }
}
