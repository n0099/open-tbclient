package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ MarkData bvC;
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData) {
        this.bvu = pbActivity;
        this.bvC = markData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bvC);
        this.bvu.setResult(-1, intent);
        this.bvu.Wl();
    }
}
