package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class x implements c.a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.pb.a.c.a
    public boolean a(View view, MotionEvent motionEvent) {
        eu euVar;
        com.baidu.tbadk.editortools.d.e eVar;
        eu euVar2;
        eu euVar3;
        com.baidu.tbadk.editortools.d.e eVar2;
        eu euVar4;
        com.baidu.tbadk.editortools.d.e eVar3;
        euVar = this.dht.dgF;
        euVar.go(false);
        eVar = this.dht.dgP;
        if (eVar != null) {
            euVar4 = this.dht.dgF;
            eVar3 = this.dht.dgP;
            euVar4.eL(eVar3.DT());
        }
        euVar2 = this.dht.dgF;
        euVar2.aM(view);
        euVar3 = this.dht.dgF;
        euVar3.go(true);
        eVar2 = this.dht.dgP;
        eVar2.DW();
        return true;
    }

    @Override // com.baidu.tieba.pb.a.c.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.a.c.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.editortools.d.e eVar;
        eu euVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        eu euVar2;
        eu euVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        boolean aJ;
        if (view != null && view.getId() == t.g.richText) {
            aJ = this.dht.aJ(view);
            if (aJ) {
                return true;
            }
        }
        eVar = this.dht.dgP;
        if (eVar != null) {
            euVar3 = this.dht.dgF;
            eVar3 = this.dht.dgP;
            euVar3.eL(eVar3.DT());
        }
        euVar = this.dht.dgF;
        euVar.ayk();
        eVar2 = this.dht.dgP;
        eVar2.DW();
        euVar2 = this.dht.dgF;
        euVar2.amI();
        return false;
    }
}
