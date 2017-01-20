package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gh implements View.OnClickListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gh(ez ezVar) {
        this.eqf = ezVar;
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
        String str;
        pbActivity = this.eqf.ehi;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.eqf.DX;
            if (jVar != null) {
                this.eqf.aNC();
            }
            jVar2 = this.eqf.DX;
            if (jVar2 != null) {
                this.eqf.epg = false;
                pbActivity2 = this.eqf.ehi;
                jVar3 = this.eqf.DX;
                interfaceC0074a = this.eqf.epC;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) jVar3.eD(2).atm, false, interfaceC0074a);
            }
            view2 = this.eqf.epb;
            if (view2 != null) {
                view3 = this.eqf.epb;
                view3.setVisibility(8);
                this.eqf.epg = false;
            }
            this.eqf.aLT();
            return;
        }
        com.baidu.tbadk.core.util.ar s = new com.baidu.tbadk.core.util.ar("c10517").s("obj_locate", 2);
        str = this.eqf.mForumId;
        TiebaStatic.log(s.ab("fid", str));
    }
}
