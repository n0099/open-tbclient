package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnClickListener {
    final /* synthetic */ cc clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cc ccVar) {
        this.clJ = ccVar;
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
        pbActivity = this.clJ.ciU;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.clJ.KA;
            if (jVar != null) {
                this.clJ.agq();
            }
            jVar2 = this.clJ.KA;
            if (jVar2 != null) {
                this.clJ.cls = false;
                pbActivity2 = this.clJ.ciU;
                jVar3 = this.clJ.KA;
                interfaceC0074a = this.clJ.clE;
                com.baidu.tieba.tbadkCore.c.a.a(pbActivity2, (View) jVar3.dU(3).aoJ, false, interfaceC0074a);
            }
            view2 = this.clJ.clo;
            if (view2 != null) {
                view3 = this.clJ.clo;
                view3.setVisibility(8);
                this.clJ.cls = false;
            }
        }
    }
}
