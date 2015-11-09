package com.baidu.tieba.mainentrance;

import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements LinearLayoutDetectsSoftKeyboard.a {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
    public void dP(boolean z) {
        this.bWd.bVD = z;
    }
}
