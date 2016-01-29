package com.baidu.tieba.recommendfrs.b;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tieba.recommendfrs.data.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c dGO;
    private final /* synthetic */ l dGP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, l lVar) {
        this.dGO = cVar;
        this.dGP = lVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void GP() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.dGO.dGM;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.dGO.dGL;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.dGO.dGN;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.dGO.dGN;
                textView2.setMaxLines(1);
            }
        }
        this.dGO.dGL = lineCount;
        textView = this.dGO.dGN;
        textView.setText(this.dGP.getDesc());
    }
}
