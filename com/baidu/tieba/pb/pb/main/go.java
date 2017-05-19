package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class go implements View.OnClickListener {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public go(fm fmVar) {
        this.epr = fmVar;
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
        a.InterfaceC0078a interfaceC0078a;
        String str;
        pbActivity = this.epr.efF;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.epr.Kg;
            if (jVar != null) {
                this.epr.aLw();
            }
            jVar2 = this.epr.Kg;
            if (jVar2 != null) {
                this.epr.eot = false;
                pbActivity2 = this.epr.efF;
                jVar3 = this.epr.Kg;
                interfaceC0078a = this.epr.eoS;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) jVar3.ex(2).ayX, false, interfaceC0078a);
            }
            view2 = this.epr.eoo;
            if (view2 != null) {
                view3 = this.epr.eoo;
                view3.setVisibility(8);
                this.epr.eot = false;
                return;
            }
            return;
        }
        com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2);
        str = this.epr.mForumId;
        TiebaStatic.log(s.aa("fid", str));
    }
}
