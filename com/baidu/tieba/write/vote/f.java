package com.baidu.tieba.write.vote;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ c dnF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.dnF = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        WriteVoteActivity writeVoteActivity;
        int i;
        editText = this.dnF.dnB;
        String trim = editText.getText().toString().trim();
        int g = !TextUtils.isEmpty(trim) ? com.baidu.adp.lib.g.b.g(trim, 7) : 0;
        if (g > 0 && g <= 99) {
            this.dnF.dnw = g;
            if (g == 1 || g == 7 || g == 30) {
                this.dnF.dnx = false;
            } else {
                this.dnF.dnx = true;
            }
            c cVar = this.dnF;
            i = this.dnF.dnw;
            cVar.mb(i);
            aVar.dismiss();
        } else if (g == 0) {
            writeVoteActivity = this.dnF.dnC;
            writeVoteActivity.showToast(i.h.endtime_input_error);
        }
    }
}
