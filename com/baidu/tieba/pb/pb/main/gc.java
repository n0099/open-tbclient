package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gc implements View.OnClickListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(ex exVar) {
        this.euB = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        View view2;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        View view3;
        PbActivity pbActivity4;
        com.baidu.tbadk.editortools.l lVar3;
        a.InterfaceC0074a interfaceC0074a;
        String str;
        pbActivity = this.euB.emy;
        if (pbActivity.checkUpIsLogin()) {
            lVar = this.euB.EJ;
            if (lVar != null) {
                this.euB.aPg();
            }
            lVar2 = this.euB.EJ;
            if (lVar2 != null) {
                this.euB.etA = false;
                pbActivity4 = this.euB.emy;
                lVar3 = this.euB.EJ;
                interfaceC0074a = this.euB.etZ;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity4, (View) lVar3.ez(3).aue, false, interfaceC0074a);
            }
            view2 = this.euB.etv;
            if (view2 != null) {
                view3 = this.euB.etv;
                view3.setVisibility(8);
                this.euB.etA = false;
            }
            this.euB.aNI();
            try {
                com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c11425");
                pbActivity2 = this.euB.emy;
                ayVar.ab("tid", pbActivity2.aMG().getPbData().aLQ().getTid());
                pbActivity3 = this.euB.emy;
                ayVar.ab("obj_id", new StringBuilder(String.valueOf(pbActivity3.aMG().getPbData().aLQ().sx().productId)).toString());
                if (ayVar != null) {
                    TiebaStatic.log(ayVar);
                    return;
                }
                return;
            } catch (Exception e) {
                return;
            }
        }
        com.baidu.tbadk.core.util.ay s = new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 2);
        str = this.euB.mForumId;
        TiebaStatic.log(s.ab("fid", str));
    }
}
