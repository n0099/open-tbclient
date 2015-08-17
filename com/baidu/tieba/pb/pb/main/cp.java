package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnClickListener {
    final /* synthetic */ cb cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cb cbVar) {
        this.cfj = cbVar;
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
        a.InterfaceC0069a interfaceC0069a;
        pbActivity = this.cfj.cbx;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.cfj.Kz;
            if (jVar != null) {
                this.cfj.aee();
            }
            jVar2 = this.cfj.Kz;
            if (jVar2 != null) {
                this.cfj.ceR = false;
                pbActivity2 = this.cfj.cbx;
                jVar3 = this.cfj.Kz;
                interfaceC0069a = this.cfj.cfd;
                com.baidu.tieba.tbadkCore.c.a.a(pbActivity2, (View) jVar3.dL(3).aox, false, interfaceC0069a);
            }
            view2 = this.cfj.ceN;
            if (view2 != null) {
                view3 = this.cfj.ceN;
                view3.setVisibility(8);
                this.cfj.ceR = false;
            }
        }
    }
}
