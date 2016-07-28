package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gb implements View.OnClickListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(ew ewVar) {
        this.eiu = ewVar;
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
        pbActivity = this.eiu.eat;
        if (pbActivity.checkUpIsLogin()) {
            lVar = this.eiu.Cw;
            if (lVar != null) {
                this.eiu.aKp();
            }
            lVar2 = this.eiu.Cw;
            if (lVar2 != null) {
                this.eiu.eht = false;
                pbActivity4 = this.eiu.eat;
                lVar3 = this.eiu.Cw;
                interfaceC0074a = this.eiu.ehS;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity4, (View) lVar3.el(3).aqX, false, interfaceC0074a);
            }
            view2 = this.eiu.eho;
            if (view2 != null) {
                view3 = this.eiu.eho;
                view3.setVisibility(8);
                this.eiu.eht = false;
            }
            this.eiu.aIR();
            try {
                com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c11425");
                pbActivity2 = this.eiu.eat;
                ayVar.ab("tid", pbActivity2.aHO().getPbData().aGY().getTid());
                pbActivity3 = this.eiu.eat;
                ayVar.ab("obj_id", new StringBuilder(String.valueOf(pbActivity3.aHO().getPbData().aGY().rs().productId)).toString());
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
        str = this.eiu.mForumId;
        TiebaStatic.log(s.ab("fid", str));
    }
}
