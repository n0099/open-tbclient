package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements View.OnClickListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(ct ctVar) {
        this.cmY = ctVar;
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
        a.InterfaceC0075a interfaceC0075a;
        pbActivity = this.cmY.cjZ;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.cmY.KB;
            if (jVar != null) {
                this.cmY.agS();
            }
            jVar2 = this.cmY.KB;
            if (jVar2 != null) {
                this.cmY.cmG = false;
                pbActivity2 = this.cmY.cjZ;
                jVar3 = this.cmY.KB;
                interfaceC0075a = this.cmY.cmS;
                com.baidu.tieba.tbadkCore.c.a.a(pbActivity2, (View) jVar3.dU(3).toolView, false, interfaceC0075a);
            }
            view2 = this.cmY.cmC;
            if (view2 != null) {
                view3 = this.cmY.cmC;
                view3.setVisibility(8);
                this.cmY.cmG = false;
            }
        }
    }
}
