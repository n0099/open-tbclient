package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gf implements View.OnClickListener {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gf(ey eyVar) {
        this.etN = eyVar;
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
        a.InterfaceC0072a interfaceC0072a;
        String str;
        pbActivity = this.etN.ekw;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.etN.KO;
            if (jVar != null) {
                this.etN.aOf();
            }
            jVar2 = this.etN.KO;
            if (jVar2 != null) {
                this.etN.esK = false;
                pbActivity2 = this.etN.ekw;
                jVar3 = this.etN.KO;
                interfaceC0072a = this.etN.etj;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) jVar3.eB(2).ayZ, false, interfaceC0072a);
            }
            view2 = this.etN.esF;
            if (view2 != null) {
                view3 = this.etN.esF;
                view3.setVisibility(8);
                this.etN.esK = false;
            }
            this.etN.aMy();
            return;
        }
        com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2);
        str = this.etN.mForumId;
        TiebaStatic.log(s.aa("fid", str));
    }
}
