package com.baidu.tieba.write.vote;

import android.app.Activity;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ c dOx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.dOx = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteVoteActivity writeVoteActivity;
        EditText editText;
        writeVoteActivity = this.dOx.dOu;
        Activity pageActivity = writeVoteActivity.getPageContext().getPageActivity();
        editText = this.dOx.dOt;
        com.baidu.adp.lib.util.k.c(pageActivity, editText);
        aVar.dismiss();
    }
}
