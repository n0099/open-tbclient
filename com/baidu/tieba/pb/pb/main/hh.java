package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hh implements View.OnClickListener {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hh(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        PbActivity pbActivity2;
        com.baidu.tbadk.editortools.j jVar3;
        a.InterfaceC0083a interfaceC0083a;
        com.baidu.tieba.pb.data.f fVar2;
        String str;
        pbActivity = this.eEv.euf;
        if (pbActivity.checkUpIsLogin()) {
            fVar = this.eEv.eyH;
            if (fVar != null) {
                fVar2 = this.eEv.eyH;
                if (com.baidu.tieba.pb.i.N(fVar2.aMv())) {
                    return;
                }
            }
            jVar = this.eEv.JT;
            if (jVar != null) {
                this.eEv.aQq();
            }
            jVar2 = this.eEv.JT;
            if (jVar2 != null) {
                this.eEv.eDs = false;
                pbActivity2 = this.eEv.euf;
                jVar3 = this.eEv.JT;
                interfaceC0083a = this.eEv.eDV;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) jVar3.eA(2).azL, false, interfaceC0083a);
            }
            this.eEv.aQN();
            return;
        }
        com.baidu.tbadk.core.util.au r = new com.baidu.tbadk.core.util.au("c10517").r("obj_locate", 2);
        str = this.eEv.mForumId;
        TiebaStatic.log(r.Z("fid", str));
    }
}
