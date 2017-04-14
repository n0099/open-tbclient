package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gf implements View.OnClickListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gf(ey eyVar) {
        this.erv = eyVar;
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
        pbActivity = this.erv.eig;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.erv.KM;
            if (jVar != null) {
                this.erv.aNe();
            }
            jVar2 = this.erv.KM;
            if (jVar2 != null) {
                this.erv.eqt = false;
                pbActivity2 = this.erv.eig;
                jVar3 = this.erv.KM;
                interfaceC0072a = this.erv.eqR;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) jVar3.eB(2).ayX, false, interfaceC0072a);
            }
            view2 = this.erv.eqo;
            if (view2 != null) {
                view3 = this.erv.eqo;
                view3.setVisibility(8);
                this.erv.eqt = false;
            }
            this.erv.aLx();
            return;
        }
        com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2);
        str = this.erv.mForumId;
        TiebaStatic.log(s.aa("fid", str));
    }
}
