package com.baidu.tieba.write.vote;

import android.app.Activity;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ c dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.dpu = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteVoteActivity writeVoteActivity;
        EditText editText;
        writeVoteActivity = this.dpu.dpr;
        Activity pageActivity = writeVoteActivity.getPageContext().getPageActivity();
        editText = this.dpu.dpq;
        com.baidu.adp.lib.util.k.c(pageActivity, editText);
        aVar.dismiss();
    }
}
