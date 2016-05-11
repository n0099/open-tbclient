package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements View.OnClickListener {
    private final /* synthetic */ String aQH;
    private final /* synthetic */ MetaData bje;
    final /* synthetic */ el dpu;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.d.a dpz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(el elVar, String str, com.baidu.tbadk.coreExtra.d.a aVar, MetaData metaData) {
        this.dpu = elVar;
        this.aQH = str;
        this.dpz = aVar;
        this.bje = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (!com.baidu.adp.lib.util.i.fq()) {
            pbActivity2 = this.dpu.dhY;
            pbActivity2.showToast(t.j.neterror);
            return;
        }
        pbActivity = this.dpu.dhY;
        if (com.baidu.tbadk.core.util.bl.ac(pbActivity.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10803").ac("tid", this.aQH).s("obj_locate", 3));
            this.dpz.a(true, this.bje.getPortrait(), this.bje.getUserId());
        }
    }
}
