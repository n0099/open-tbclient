package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements a.b {
    final /* synthetic */ PbActivity eob;
    private final /* synthetic */ MarkData eok;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.eob = pbActivity;
        this.eok = markData;
        this.eol = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.eok);
        this.eob.setResult(-1, intent);
        this.eol.dismiss();
        this.eob.aMO();
    }
}
