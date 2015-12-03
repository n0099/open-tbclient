package com.baidu.tieba.write.vote;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ c dOx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.dOx = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        WriteVoteActivity writeVoteActivity;
        int i;
        editText = this.dOx.dOt;
        String trim = editText.getText().toString().trim();
        int g = !TextUtils.isEmpty(trim) ? com.baidu.adp.lib.h.b.g(trim, 7) : 0;
        if (g > 0 && g <= 99) {
            this.dOx.dOo = g;
            if (g == 1 || g == 7 || g == 30) {
                this.dOx.dOp = false;
            } else {
                this.dOx.dOp = true;
            }
            c cVar = this.dOx;
            i = this.dOx.dOo;
            cVar.nB(i);
            aVar.dismiss();
        } else if (g == 0) {
            writeVoteActivity = this.dOx.dOu;
            writeVoteActivity.showToast(n.i.endtime_input_error);
        }
    }
}
