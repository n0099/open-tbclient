package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements View.OnClickListener {
    private final /* synthetic */ String aUn;
    private final /* synthetic */ MetaData bnB;
    final /* synthetic */ eu dnc;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.d.a dnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(eu euVar, String str, com.baidu.tbadk.coreExtra.d.a aVar, MetaData metaData) {
        this.dnc = euVar;
        this.aUn = str;
        this.dnh = aVar;
        this.bnB = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (!com.baidu.adp.lib.util.i.jf()) {
            pbActivity2 = this.dnc.dfw;
            pbActivity2.showToast(t.j.neterror);
            return;
        }
        pbActivity = this.dnc.dfw;
        if (com.baidu.tbadk.core.util.bl.ad(pbActivity.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10803").ac("tid", this.aUn).r("obj_locate", 3));
            this.dnh.a(true, this.bnB.getPortrait(), this.bnB.getUserId());
        }
    }
}
