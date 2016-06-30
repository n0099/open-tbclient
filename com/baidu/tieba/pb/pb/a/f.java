package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements TextureVideoView.b {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dML = eVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void vx() {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        yVar = this.dML.dMD;
        if (yVar != null) {
            yVar2 = this.dML.dMD;
            if (yVar2.aJJ != null) {
                yVar3 = this.dML.dMD;
                if (yVar3.aJJ.isPlaying()) {
                    yVar4 = this.dML.dMD;
                    yVar4.aJJ.vr();
                    this.dML.d(false, 0);
                }
            }
        }
        this.dML.aiN();
        this.dML.cyQ = false;
    }
}
