package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnClickListener {
    final /* synthetic */ cb cgg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cb cbVar) {
        this.cgg = cbVar;
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
        a.InterfaceC0071a interfaceC0071a;
        pbActivity = this.cgg.ccs;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.cgg.Kz;
            if (jVar != null) {
                this.cgg.aes();
            }
            jVar2 = this.cgg.Kz;
            if (jVar2 != null) {
                this.cgg.cfO = false;
                pbActivity2 = this.cgg.ccs;
                jVar3 = this.cgg.Kz;
                interfaceC0071a = this.cgg.cga;
                com.baidu.tieba.tbadkCore.c.a.a(pbActivity2, (View) jVar3.dT(3).aqi, false, interfaceC0071a);
            }
            view2 = this.cgg.cfK;
            if (view2 != null) {
                view3 = this.cgg.cfK;
                view3.setVisibility(8);
                this.cgg.cfO = false;
            }
        }
    }
}
