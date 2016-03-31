package com.baidu.tieba.recommendfrs.view;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tieba.recommendfrs.data.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c dZi;
    private final /* synthetic */ p dZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, p pVar) {
        this.dZi = cVar;
        this.dZj = pVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void HR() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.dZi.cHe;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.dZi.cHl;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.dZi.cHf;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.dZi.cHf;
                textView2.setMaxLines(1);
            }
        }
        this.dZi.cHl = lineCount;
        textView = this.dZi.cHf;
        textView.setText(this.dZj.getDesc());
    }
}
