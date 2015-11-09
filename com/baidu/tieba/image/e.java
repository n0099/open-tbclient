package com.baidu.tieba.image;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TbImageView.a {
    final /* synthetic */ a bPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bPj = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        h hVar;
        h hVar2;
        if (z) {
            hVar2 = this.bPj.bPf;
            hVar2.aam();
        }
        hVar = this.bPj.bPf;
        hVar.aao();
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        h hVar;
        hVar = this.bPj.bPf;
        hVar.aao();
    }
}
