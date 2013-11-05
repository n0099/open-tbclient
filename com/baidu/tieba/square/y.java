package com.baidu.tieba.square;

import com.baidu.tieba.view.az;
/* loaded from: classes.dex */
class y implements az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f2381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareActivity squareActivity) {
        this.f2381a = squareActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        if (z) {
            this.f2381a.a(true);
        }
    }
}
