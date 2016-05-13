package com.baidu.tieba.recommendfrs.view;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tieba.recommendfrs.data.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c ecp;
    private final /* synthetic */ p ecq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, p pVar) {
        this.ecp = cVar;
        this.ecq = pVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void Ge() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.ecp.cHp;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.ecp.cHw;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.ecp.cHq;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.ecp.cHq;
                textView2.setMaxLines(1);
            }
        }
        this.ecp.cHw = lineCount;
        textView = this.ecp.cHq;
        textView.setText(this.ecq.getDesc());
    }
}
