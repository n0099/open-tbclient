package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gd implements View.OnClickListener {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(ey eyVar) {
        this.eCT = eyVar;
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
        a.InterfaceC0078a interfaceC0078a;
        String str;
        pbActivity = this.eCT.eug;
        if (pbActivity.checkUpIsLogin()) {
            lVar = this.eCT.EL;
            if (lVar != null) {
                this.eCT.aRU();
            }
            lVar2 = this.eCT.EL;
            if (lVar2 != null) {
                this.eCT.eBU = false;
                if (com.baidu.tbadk.core.sharedPref.b.um().getInt("graffiti_reply_tip_show", 0) >= 3) {
                    pbActivity2 = this.eCT.eug;
                    lVar3 = this.eCT.EL;
                    interfaceC0078a = this.eCT.eCp;
                    com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) lVar3.eB(2).auC, false, interfaceC0078a);
                }
            }
            view2 = this.eCT.eBP;
            if (view2 != null) {
                view3 = this.eCT.eBP;
                view3.setVisibility(8);
                this.eCT.eBU = false;
            }
            this.eCT.aQj();
            return;
        }
        com.baidu.tbadk.core.util.av s = new com.baidu.tbadk.core.util.av("c10517").s("obj_locate", 2);
        str = this.eCT.mForumId;
        TiebaStatic.log(s.ab("fid", str));
    }
}
