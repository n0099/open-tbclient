package com.baidu.tieba.mainentrance;

import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements LinearLayoutDetectsSoftKeyboard.a {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
    public void dH(boolean z) {
        this.bQZ.bQA = z;
    }
}
