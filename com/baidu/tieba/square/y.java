package com.baidu.tieba.square;

import com.baidu.tieba.view.az;
/* loaded from: classes.dex */
class y implements az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f1859a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareActivity squareActivity) {
        this.f1859a = squareActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        if (!z) {
            return;
        }
        this.f1859a.a(true);
    }
}
