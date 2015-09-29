package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnClickListener {
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cc ccVar) {
        this.cly = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        View view2;
        View view3;
        PbActivity pbActivity2;
        com.baidu.tbadk.editortools.j jVar3;
        a.InterfaceC0074a interfaceC0074a;
        pbActivity = this.cly.ciJ;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.cly.Kz;
            if (jVar != null) {
                this.cly.agq();
            }
            jVar2 = this.cly.Kz;
            if (jVar2 != null) {
                this.cly.clh = false;
                pbActivity2 = this.cly.ciJ;
                jVar3 = this.cly.Kz;
                interfaceC0074a = this.cly.clt;
                com.baidu.tieba.tbadkCore.c.a.a(pbActivity2, (View) jVar3.dU(3).aoI, false, interfaceC0074a);
            }
            view2 = this.cly.cld;
            if (view2 != null) {
                view3 = this.cly.cld;
                view3.setVisibility(8);
                this.cly.clh = false;
            }
        }
    }
}
