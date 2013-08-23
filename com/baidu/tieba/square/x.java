package com.baidu.tieba.square;

import com.baidu.tieba.view.ax;
/* loaded from: classes.dex */
class x implements ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f1759a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareActivity squareActivity) {
        this.f1759a = squareActivity;
    }

    @Override // com.baidu.tieba.view.ax
    public void a(boolean z) {
        if (!z) {
            return;
        }
        this.f1759a.a(true);
    }
}
