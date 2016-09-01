package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements a.b {
    final /* synthetic */ PbActivity eob;
    private final /* synthetic */ MarkData eoj;
    private final /* synthetic */ MarkData eok;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.eob = pbActivity;
        this.eoj = markData;
        this.eok = markData2;
        this.eol = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        com.baidu.tbadk.baseEditMark.a aVar5;
        com.baidu.tbadk.baseEditMark.a aVar6;
        com.baidu.tbadk.baseEditMark.a aVar7;
        com.baidu.tbadk.baseEditMark.a aVar8;
        aVar.dismiss();
        aVar2 = this.eob.dKY;
        if (aVar2 != null) {
            aVar3 = this.eob.dKY;
            if (aVar3.nv()) {
                aVar7 = this.eob.dKY;
                aVar7.nw();
                aVar8 = this.eob.dKY;
                aVar8.ad(false);
            }
            aVar4 = this.eob.dKY;
            aVar4.a(this.eoj);
            aVar5 = this.eob.dKY;
            aVar5.ad(true);
            aVar6 = this.eob.dKY;
            aVar6.nx();
        }
        this.eok.setPostId(this.eoj.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.eok);
        this.eob.setResult(-1, intent);
        this.eol.dismiss();
        this.eob.aMO();
    }
}
