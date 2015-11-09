package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.b.c;
/* loaded from: classes.dex */
class f implements c.a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        ct ctVar;
        com.baidu.tbadk.editortools.c.e eVar;
        ct ctVar2;
        ct ctVar3;
        com.baidu.tbadk.editortools.c.e eVar2;
        ct ctVar4;
        com.baidu.tbadk.editortools.c.e eVar3;
        ctVar = this.cjN.cjo;
        ctVar.eL(false);
        eVar = this.cjN.cjw;
        if (eVar != null) {
            ctVar4 = this.cjN.cjo;
            eVar3 = this.cjN.cjw;
            ctVar4.eQ(eVar3.Bf());
        }
        ctVar2 = this.cjN.cjo;
        ctVar2.aa(view);
        ctVar3 = this.cjN.cjo;
        ctVar3.eL(true);
        eVar2 = this.cjN.cjw;
        eVar2.Bi();
        return true;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.c.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.c.e eVar;
        ct ctVar;
        com.baidu.tbadk.editortools.c.e eVar2;
        ct ctVar2;
        ct ctVar3;
        com.baidu.tbadk.editortools.c.e eVar3;
        boolean V;
        if (view != null && view.getId() == i.f.richText) {
            V = this.cjN.V(view);
            if (V) {
                return true;
            }
        }
        eVar = this.cjN.cjw;
        if (eVar != null) {
            ctVar3 = this.cjN.cjo;
            eVar3 = this.cjN.cjw;
            ctVar3.eQ(eVar3.Bf());
        }
        ctVar = this.cjN.cjo;
        ctVar.agP();
        eVar2 = this.cjN.cjw;
        eVar2.Bi();
        ctVar2 = this.cjN.cjo;
        ctVar2.aho();
        return false;
    }
}
