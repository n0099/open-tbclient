package com.baidu.tieba.write.vote;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ c dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.dpu = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        EditText editText;
        WriteVoteActivity writeVoteActivity;
        int i;
        editText = this.dpu.dpq;
        String trim = editText.getText().toString().trim();
        int g = !TextUtils.isEmpty(trim) ? com.baidu.adp.lib.g.b.g(trim, 7) : 0;
        if (g > 0 && g <= 99) {
            this.dpu.dpl = g;
            if (g == 1 || g == 7 || g == 30) {
                this.dpu.dpm = false;
            } else {
                this.dpu.dpm = true;
            }
            c cVar = this.dpu;
            i = this.dpu.dpl;
            cVar.mp(i);
            aVar.dismiss();
        } else if (g == 0) {
            writeVoteActivity = this.dpu.dpr;
            writeVoteActivity.showToast(i.h.endtime_input_error);
        }
    }
}
