package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fx implements View.OnClickListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(es esVar) {
        this.dVR = esVar;
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
        a.InterfaceC0075a interfaceC0075a;
        String str;
        pbActivity = this.dVR.dOg;
        if (pbActivity.checkUpIsLogin()) {
            lVar = this.dVR.BW;
            if (lVar != null) {
                this.dVR.aHe();
            }
            lVar2 = this.dVR.BW;
            if (lVar2 != null) {
                this.dVR.dUS = false;
                pbActivity4 = this.dVR.dOg;
                lVar3 = this.dVR.BW;
                interfaceC0075a = this.dVR.dVr;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity4, (View) lVar3.el(3).aqi, false, interfaceC0075a);
            }
            view2 = this.dVR.dUN;
            if (view2 != null) {
                view3 = this.dVR.dUN;
                view3.setVisibility(8);
                this.dVR.dUS = false;
            }
            this.dVR.aFG();
            try {
                com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c11425");
                pbActivity2 = this.dVR.dOg;
                ayVar.ab("tid", pbActivity2.aEE().getPbData().aDO().getTid());
                pbActivity3 = this.dVR.dOg;
                ayVar.ab("obj_id", new StringBuilder(String.valueOf(pbActivity3.aEE().getPbData().aDO().rt().productId)).toString());
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
        str = this.dVR.mForumId;
        TiebaStatic.log(s.ab("fid", str));
    }
}
