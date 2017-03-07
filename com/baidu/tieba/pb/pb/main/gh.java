package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gh implements View.OnClickListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gh(fa faVar) {
        this.etn = faVar;
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
        a.InterfaceC0073a interfaceC0073a;
        String str;
        pbActivity = this.etn.eka;
        if (pbActivity.checkUpIsLogin()) {
            jVar = this.etn.Ll;
            if (jVar != null) {
                this.etn.aMV();
            }
            jVar2 = this.etn.Ll;
            if (jVar2 != null) {
                this.etn.esk = false;
                pbActivity2 = this.etn.eka;
                jVar3 = this.etn.Ll;
                interfaceC0073a = this.etn.esI;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) jVar3.ey(2).ayH, false, interfaceC0073a);
            }
            view2 = this.etn.esf;
            if (view2 != null) {
                view3 = this.etn.esf;
                view3.setVisibility(8);
                this.etn.esk = false;
            }
            this.etn.aLp();
            return;
        }
        com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2);
        str = this.etn.mForumId;
        TiebaStatic.log(s.Z("fid", str));
    }
}
