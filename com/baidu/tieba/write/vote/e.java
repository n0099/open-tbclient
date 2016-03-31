package com.baidu.tieba.write.vote;

import android.app.Activity;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ c eKJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.eKJ = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteVoteActivity writeVoteActivity;
        EditText editText;
        writeVoteActivity = this.eKJ.eKG;
        Activity pageActivity = writeVoteActivity.getPageContext().getPageActivity();
        editText = this.eKJ.eKF;
        com.baidu.adp.lib.util.k.c(pageActivity, editText);
        aVar.dismiss();
    }
}
