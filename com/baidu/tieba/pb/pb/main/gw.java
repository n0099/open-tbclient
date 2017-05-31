package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gw implements View.OnClickListener {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gw(fx fxVar) {
        this.evi = fxVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        PbActivity pbActivity2;
        com.baidu.tbadk.editortools.j jVar3;
        a.InterfaceC0080a interfaceC0080a;
        com.baidu.tieba.pb.data.f fVar2;
        String str;
        pbActivity = this.evi.elf;
        if (pbActivity.checkUpIsLogin()) {
            fVar = this.evi.epx;
            if (fVar != null) {
                fVar2 = this.evi.epx;
                if (com.baidu.tieba.pb.e.M(fVar2.aIB())) {
                    return;
                }
            }
            jVar = this.evi.JU;
            if (jVar != null) {
                this.evi.aMs();
            }
            jVar2 = this.evi.JU;
            if (jVar2 != null) {
                this.evi.euh = false;
                pbActivity2 = this.evi.elf;
                jVar3 = this.evi.JU;
                interfaceC0080a = this.evi.euI;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) jVar3.ey(2).ayJ, false, interfaceC0080a);
            }
            this.evi.aMP();
            return;
        }
        com.baidu.tbadk.core.util.as r = new com.baidu.tbadk.core.util.as("c10517").r("obj_locate", 2);
        str = this.evi.mForumId;
        TiebaStatic.log(r.Z("fid", str));
    }
}
