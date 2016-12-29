package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fw implements View.OnClickListener {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(er erVar) {
        this.egZ = erVar;
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
        pbActivity = this.egZ.dYB;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.egZ.EM;
            if (jVar != null) {
                this.egZ.aLO();
            }
            jVar2 = this.egZ.EM;
            if (jVar2 != null) {
                this.egZ.ega = false;
                pbActivity2 = this.egZ.dYB;
                jVar3 = this.egZ.EM;
                interfaceC0072a = this.egZ.egv;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) jVar3.eC(2).auh, false, interfaceC0072a);
            }
            view2 = this.egZ.efV;
            if (view2 != null) {
                view3 = this.egZ.efV;
                view3.setVisibility(8);
                this.egZ.ega = false;
            }
            this.egZ.aKg();
            return;
        }
        com.baidu.tbadk.core.util.at s = new com.baidu.tbadk.core.util.at("c10517").s("obj_locate", 2);
        str = this.egZ.mForumId;
        TiebaStatic.log(s.ab("fid", str));
    }
}
