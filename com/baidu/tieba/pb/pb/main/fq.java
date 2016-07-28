package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements View.OnClickListener {
    private final /* synthetic */ String aKw;
    private final /* synthetic */ MetaData bFU;
    final /* synthetic */ ew eiu;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.d.a eiz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(ew ewVar, String str, com.baidu.tbadk.coreExtra.d.a aVar, MetaData metaData) {
        this.eiu = ewVar;
        this.aKw = str;
        this.eiz = aVar;
        this.bFU = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.i.fq()) {
            pbActivity3 = this.eiu.eat;
            pbActivity3.showToast(u.j.neterror);
            return;
        }
        pbActivity = this.eiu.eat;
        if (com.baidu.tbadk.core.util.bn.ab(pbActivity.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10803").ab("tid", this.aKw).s("obj_locate", 3));
            com.baidu.tbadk.coreExtra.d.a aVar = this.eiz;
            String portrait = this.bFU.getPortrait();
            String userId = this.bFU.getUserId();
            pbActivity2 = this.eiu.eat;
            aVar.a(true, portrait, userId, true, pbActivity2.getUniqueId());
        }
    }
}
