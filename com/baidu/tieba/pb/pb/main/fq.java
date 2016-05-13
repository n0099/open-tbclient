package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements View.OnClickListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(el elVar) {
        this.dpu = elVar;
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
        a.InterfaceC0073a interfaceC0073a;
        String str;
        pbActivity = this.dpu.dhY;
        if (pbActivity.checkUpIsLogin()) {
            lVar = this.dpu.BV;
            if (lVar != null) {
                this.dpu.ayV();
            }
            lVar2 = this.dpu.BV;
            if (lVar2 != null) {
                this.dpu.dov = false;
                pbActivity2 = this.dpu.dhY;
                lVar3 = this.dpu.BV;
                interfaceC0073a = this.dpu.doS;
                com.baidu.tieba.tbadkCore.b.a.a(pbActivity2, (View) lVar3.eh(3).aps, false, interfaceC0073a);
            }
            view2 = this.dpu.doq;
            if (view2 != null) {
                view3 = this.dpu.doq;
                view3.setVisibility(8);
                this.dpu.dov = false;
            }
            this.dpu.axy();
            return;
        }
        com.baidu.tbadk.core.util.aw s = new com.baidu.tbadk.core.util.aw("c10517").s("obj_locate", 2);
        str = this.dpu.mForumId;
        TiebaStatic.log(s.ac("fid", str));
    }
}
