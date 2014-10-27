package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvg;
    private final /* synthetic */ MarkData bvo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData) {
        this.bvg = pbActivity;
        this.bvo = markData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bvo);
        this.bvg.setResult(-1, intent);
        this.bvg.Wi();
    }
}
