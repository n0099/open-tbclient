package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.view.v {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.v
    public void a(boolean z) {
        BdLog.d("simon", "onSoftKeyboardShown", String.valueOf(z));
        this.a.D = z;
    }
}
