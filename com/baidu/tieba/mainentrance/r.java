package com.baidu.tieba.mainentrance;

import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements LinearLayoutDetectsSoftKeyboard.a {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
    public void dN(boolean z) {
        this.bVC.bVc = z;
    }
}
