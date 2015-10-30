package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.b.c;
/* loaded from: classes.dex */
class c implements c.a {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.ciK = pbActivity;
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
        ccVar = this.ciK.cim;
        ccVar.eI(false);
        dVar = this.ciK.ciu;
        if (dVar != null) {
            ccVar4 = this.ciK.cim;
            dVar3 = this.ciK.ciu;
            ccVar4.eN(dVar3.Bo());
        }
        ccVar2 = this.ciK.cim;
        ccVar2.ab(view);
        ccVar3 = this.ciK.cim;
        ccVar3.eI(true);
        dVar2 = this.ciK.ciu;
        dVar2.Br();
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
            W = this.ciK.W(view);
            if (W) {
                return true;
            }
        }
        dVar = this.ciK.ciu;
        if (dVar != null) {
            ccVar3 = this.ciK.cim;
            dVar3 = this.ciK.ciu;
            ccVar3.eN(dVar3.Bo());
        }
        ccVar = this.ciK.cim;
        ccVar.agk();
        dVar2 = this.ciK.ciu;
        dVar2.Br();
        ccVar2 = this.ciK.cim;
        ccVar2.agI();
        return false;
    }
}
