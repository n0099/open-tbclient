package com.baidu.tieba.recommendfrs.a;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tieba.recommendfrs.data.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements LineCountNotifyTextView.a {
    final /* synthetic */ b dqK;
    private final /* synthetic */ j dqL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, j jVar) {
        this.dqK = bVar;
        this.dqL = jVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void Fx() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.dqK.dqI;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.dqK.dqH;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.dqK.dqJ;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.dqK.dqJ;
                textView2.setMaxLines(1);
            }
        }
        this.dqK.dqH = lineCount;
        textView = this.dqK.dqJ;
        textView.setText(this.dqL.getDesc());
    }
}
