package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.b.c;
/* loaded from: classes.dex */
class h implements c.a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        dk dkVar;
        com.baidu.tbadk.editortools.d.e eVar;
        dk dkVar2;
        dk dkVar3;
        com.baidu.tbadk.editortools.d.e eVar2;
        dk dkVar4;
        com.baidu.tbadk.editortools.d.e eVar3;
        dkVar = this.cFS.cFq;
        dkVar.fo(false);
        eVar = this.cFS.cFx;
        if (eVar != null) {
            dkVar4 = this.cFS.cFq;
            eVar3 = this.cFS.cFx;
            dkVar4.ft(eVar3.BU());
        }
        dkVar2 = this.cFS.cFq;
        dkVar2.ao(view);
        dkVar3 = this.cFS.cFq;
        dkVar3.fo(true);
        eVar2 = this.cFS.cFx;
        eVar2.BX();
        return true;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        dk dkVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        dk dkVar2;
        dk dkVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        boolean ah;
        if (view != null && view.getId() == n.g.richText) {
            ah = this.cFS.ah(view);
            if (ah) {
                return true;
            }
        }
        eVar = this.cFS.cFx;
        if (eVar != null) {
            dkVar3 = this.cFS.cFq;
            eVar3 = this.cFS.cFx;
            dkVar3.ft(eVar3.BU());
        }
        dkVar = this.cFS.cFq;
        dkVar.amz();
        eVar2 = this.cFS.cFx;
        eVar2.BX();
        dkVar2 = this.cFS.cFq;
        dkVar2.ana();
        return false;
    }
}
