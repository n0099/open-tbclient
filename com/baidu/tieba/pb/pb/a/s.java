package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TextureVideoView.b {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.dgC = rVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void vu() {
        an anVar;
        an anVar2;
        an anVar3;
        anVar = this.dgC.dgr;
        if (anVar != null) {
            anVar2 = this.dgC.dgr;
            if (anVar2.dgT != null) {
                anVar3 = this.dgC.dgr;
                anVar3.dgT.stopPlayback();
            }
        }
        this.dgC.awb();
    }
}
