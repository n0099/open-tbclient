package com.baidu.tieba.write.vote;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ c eqP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.eqP = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        WriteVoteActivity writeVoteActivity;
        int i;
        editText = this.eqP.eqL;
        String trim = editText.getText().toString().trim();
        int g = !TextUtils.isEmpty(trim) ? com.baidu.adp.lib.h.b.g(trim, 7) : 0;
        if (g > 0 && g <= 99) {
            this.eqP.eqG = g;
            if (g == 1 || g == 7 || g == 30) {
                this.eqP.eqH = false;
            } else {
                this.eqP.eqH = true;
            }
            c cVar = this.eqP;
            i = this.eqP.eqG;
            cVar.pO(i);
            aVar.dismiss();
        } else if (g == 0) {
            writeVoteActivity = this.eqP.eqM;
            writeVoteActivity.showToast(t.j.endtime_input_error);
        }
    }
}
