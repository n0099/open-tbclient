package com.baidu.tieba.write.vote;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ c dnf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.dnf = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        WriteVoteActivity writeVoteActivity;
        int i;
        editText = this.dnf.dnb;
        String trim = editText.getText().toString().trim();
        int g = !TextUtils.isEmpty(trim) ? com.baidu.adp.lib.g.b.g(trim, 7) : 0;
        if (g > 0 && g <= 99) {
            this.dnf.dmW = g;
            if (g == 1 || g == 7 || g == 30) {
                this.dnf.dmX = false;
            } else {
                this.dnf.dmX = true;
            }
            c cVar = this.dnf;
            i = this.dnf.dmW;
            cVar.lZ(i);
            aVar.dismiss();
        } else if (g == 0) {
            writeVoteActivity = this.dnf.dnc;
            writeVoteActivity.showToast(i.h.endtime_input_error);
        }
    }
}
