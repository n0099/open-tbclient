package com.baidu.tieba.pb.video;

import com.baidu.tieba.pb.view.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements d.a {
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.eKu = lVar;
    }

    @Override // com.baidu.tieba.pb.view.d.a
    public void onAnimationEnd() {
        this.eKu.jI(false);
    }
}
