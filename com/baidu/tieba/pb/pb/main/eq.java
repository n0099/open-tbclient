package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eq implements View.OnClickListener {
    private final /* synthetic */ String bUY;
    private final /* synthetic */ MetaData biQ;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.d.a biU;
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(dz dzVar, String str, com.baidu.tbadk.coreExtra.d.a aVar, MetaData metaData) {
        this.cSw = dzVar;
        this.bUY = str;
        this.biU = aVar;
        this.biQ = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            pbActivity2 = this.cSw.cNL;
            pbActivity2.showToast(t.j.neterror);
            return;
        }
        pbActivity = this.cSw.cNL;
        if (com.baidu.tbadk.core.util.bi.ah(pbActivity.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10803").aa("tid", this.bUY).r("obj_locate", 3));
            this.biU.a(true, this.biQ.getPortrait(), this.biQ.getUserId());
        }
    }
}
