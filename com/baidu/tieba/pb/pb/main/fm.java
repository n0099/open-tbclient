package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fm implements View.OnClickListener {
    private final /* synthetic */ String aJD;
    private final /* synthetic */ MetaData bEH;
    final /* synthetic */ es dVR;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.d.a dVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(es esVar, String str, com.baidu.tbadk.coreExtra.d.a aVar, MetaData metaData) {
        this.dVR = esVar;
        this.aJD = str;
        this.dVW = aVar;
        this.bEH = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.i.fr()) {
            pbActivity3 = this.dVR.dOg;
            pbActivity3.showToast(u.j.neterror);
            return;
        }
        pbActivity = this.dVR.dOg;
        if (com.baidu.tbadk.core.util.bn.ab(pbActivity.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10803").ab("tid", this.aJD).s("obj_locate", 3));
            com.baidu.tbadk.coreExtra.d.a aVar = this.dVW;
            String portrait = this.bEH.getPortrait();
            String userId = this.bEH.getUserId();
            pbActivity2 = this.dVR.dOg;
            aVar.a(true, portrait, userId, true, pbActivity2.getUniqueId());
        }
    }
}
