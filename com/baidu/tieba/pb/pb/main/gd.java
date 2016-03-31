package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gd implements View.OnClickListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(eu euVar) {
        this.dnc = euVar;
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
        a.InterfaceC0081a interfaceC0081a;
        String str;
        pbActivity = this.dnc.dfw;
        if (pbActivity.checkUpIsLogin()) {
            lVar = this.dnc.LE;
            if (lVar != null) {
                this.dnc.ayw();
            }
            lVar2 = this.dnc.LE;
            if (lVar2 != null) {
                this.dnc.dmb = false;
                pbActivity2 = this.dnc.dfw;
                lVar3 = this.dnc.LE;
                interfaceC0081a = this.dnc.dmy;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) lVar3.eC(3).toolView, false, interfaceC0081a);
            }
            view2 = this.dnc.dlV;
            if (view2 != null) {
                view3 = this.dnc.dlV;
                view3.setVisibility(8);
                this.dnc.dmb = false;
            }
            this.dnc.ayL();
            return;
        }
        com.baidu.tbadk.core.util.aw r = new com.baidu.tbadk.core.util.aw("c10517").r("obj_locate", 2);
        str = this.dnc.mForumId;
        TiebaStatic.log(r.ac("fid", str));
    }
}
