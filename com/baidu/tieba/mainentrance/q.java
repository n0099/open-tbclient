package com.baidu.tieba.mainentrance;

import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements LinearLayoutDetectsSoftKeyboard.a {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
    public void eY(boolean z) {
        this.cLU.cLu = z;
    }
}
