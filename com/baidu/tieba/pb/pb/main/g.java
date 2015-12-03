package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.b.c;
/* loaded from: classes.dex */
class g implements c.a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        da daVar;
        com.baidu.tbadk.editortools.d.e eVar;
        da daVar2;
        da daVar3;
        com.baidu.tbadk.editortools.d.e eVar2;
        da daVar4;
        com.baidu.tbadk.editortools.d.e eVar3;
        daVar = this.cCm.cBL;
        daVar.fp(false);
        eVar = this.cCm.cBS;
        if (eVar != null) {
            daVar4 = this.cCm.cBL;
            eVar3 = this.cCm.cBS;
            daVar4.fu(eVar3.Cf());
        }
        daVar2 = this.cCm.cBL;
        daVar2.aj(view);
        daVar3 = this.cCm.cBL;
        daVar3.fp(true);
        eVar2 = this.cCm.cBS;
        eVar2.Ci();
        return true;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        da daVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        da daVar2;
        da daVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        boolean ac;
        if (view != null && view.getId() == n.f.richText) {
            ac = this.cCm.ac(view);
            if (ac) {
                return true;
            }
        }
        eVar = this.cCm.cBS;
        if (eVar != null) {
            daVar3 = this.cCm.cBL;
            eVar3 = this.cCm.cBS;
            daVar3.fu(eVar3.Cf());
        }
        daVar = this.cCm.cBL;
        daVar.aln();
        eVar2 = this.cCm.cBS;
        eVar2.Ci();
        daVar2 = this.cCm.cBL;
        daVar2.alO();
        return false;
    }
}
