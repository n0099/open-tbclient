package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gc implements View.OnClickListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(ex exVar) {
        this.ewH = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        View view2;
        View view3;
        PbActivity pbActivity2;
        com.baidu.tbadk.editortools.l lVar3;
        a.InterfaceC0077a interfaceC0077a;
        String str;
        pbActivity = this.ewH.eow;
        if (pbActivity.checkUpIsLogin()) {
            lVar = this.ewH.EJ;
            if (lVar != null) {
                this.ewH.aPP();
            }
            lVar2 = this.ewH.EJ;
            if (lVar2 != null) {
                this.ewH.evI = false;
                pbActivity2 = this.ewH.eow;
                lVar3 = this.ewH.EJ;
                interfaceC0077a = this.ewH.ewf;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) lVar3.ey(3).atI, false, interfaceC0077a);
            }
            view2 = this.ewH.evD;
            if (view2 != null) {
                view3 = this.ewH.evD;
                view3.setVisibility(8);
                this.ewH.evI = false;
            }
            this.ewH.aOq();
            return;
        }
        com.baidu.tbadk.core.util.ax s = new com.baidu.tbadk.core.util.ax("c10517").s("obj_locate", 2);
        str = this.ewH.mForumId;
        TiebaStatic.log(s.ab("fid", str));
    }
}
