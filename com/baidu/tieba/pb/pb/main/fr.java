package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fr implements View.OnClickListener {
    private final /* synthetic */ MetaData bQV;
    private final /* synthetic */ String baD;
    final /* synthetic */ ex ewH;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.d.a ewM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(ex exVar, String str, com.baidu.tbadk.coreExtra.d.a aVar, MetaData metaData) {
        this.ewH = exVar;
        this.baD = str;
        this.ewM = aVar;
        this.bQV = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        String str;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.i.gm()) {
            pbActivity3 = this.ewH.eow;
            pbActivity3.showToast(r.j.neterror);
            return;
        }
        pbActivity = this.ewH.eow;
        if (com.baidu.tbadk.core.util.bm.ak(pbActivity.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10803").ab("tid", this.baD).s("obj_locate", 3));
            com.baidu.tbadk.coreExtra.d.a aVar = this.ewM;
            String portrait = this.bQV.getPortrait();
            String userId = this.bQV.getUserId();
            pbActivity2 = this.ewH.eow;
            BdUniqueId uniqueId = pbActivity2.getUniqueId();
            str = this.ewH.mForumId;
            aVar.a(true, portrait, userId, true, uniqueId, str);
        }
    }
}
