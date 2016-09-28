package com.baidu.tieba.pb.pb.a;

import com.baidu.tieba.play.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements e.b {
    final /* synthetic */ e emY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.emY = eVar;
    }

    @Override // com.baidu.tieba.play.e.b
    public boolean onError(com.baidu.tieba.play.e eVar, int i, int i2) {
        this.emY.e(true, 4);
        return true;
    }
}
