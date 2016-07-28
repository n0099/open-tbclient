package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements TextureVideoView.b {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dYX = eVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void vx() {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        yVar = this.dYX.dYN;
        if (yVar != null) {
            yVar2 = this.dYX.dYN;
            if (yVar2.aKC != null) {
                yVar3 = this.dYX.dYN;
                if (yVar3.aKC.isPlaying()) {
                    yVar4 = this.dYX.dYN;
                    yVar4.aKC.vr();
                    this.dYX.e(false, 0);
                }
            }
        }
        this.dYX.ajx();
        this.dYX.cBF = false;
    }
}
