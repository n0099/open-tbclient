package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fr implements View.OnClickListener {
    private final /* synthetic */ MetaData bRc;
    private final /* synthetic */ String bal;
    final /* synthetic */ ex euB;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.d.a euG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(ex exVar, String str, com.baidu.tbadk.coreExtra.d.a aVar, MetaData metaData) {
        this.euB = exVar;
        this.bal = str;
        this.euG = aVar;
        this.bRc = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.i.gm()) {
            pbActivity3 = this.euB.emy;
            pbActivity3.showToast(t.j.neterror);
            return;
        }
        pbActivity = this.euB.emy;
        if (com.baidu.tbadk.core.util.bn.al(pbActivity.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10803").ab("tid", this.bal).s("obj_locate", 3));
            com.baidu.tbadk.coreExtra.d.a aVar = this.euG;
            String portrait = this.bRc.getPortrait();
            String userId = this.bRc.getUserId();
            pbActivity2 = this.euB.emy;
            aVar.a(true, portrait, userId, true, pbActivity2.getUniqueId());
        }
    }
}
