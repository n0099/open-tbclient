package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements TextView.OnEditorActionListener {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            if (this.cMQ.mMode != 0) {
                if (this.cMQ.mMode == 3) {
                    if (TextUtils.isEmpty(this.cMQ.cMj) || this.cMQ.cMj.trim().length() <= 0) {
                        return true;
                    }
                    this.cMQ.gN(this.cMQ.cMj);
                    return true;
                }
                this.cMQ.C(1, this.cMQ.cMj);
                return true;
            }
            this.cMQ.aoL();
            return true;
        }
        return false;
    }
}
