package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements TextureVideoView.b {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.elb = eVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void onSurfaceDestroyed() {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        yVar = this.elb.ekR;
        if (yVar != null) {
            yVar2 = this.elb.ekR;
            if (yVar2.aPh != null) {
                yVar3 = this.elb.ekR;
                if (yVar3.aPh.isPlaying()) {
                    yVar4 = this.elb.ekR;
                    yVar4.aPh.wv();
                    this.elb.d(false, 0);
                }
            }
        }
        this.elb.aol();
        this.elb.cNk = false;
    }
}
