package com.baidu.tieba.image;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TbImageView.a {
    final /* synthetic */ a coa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.coa = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        h hVar;
        h hVar2;
        if (z) {
            hVar2 = this.coa.cnW;
            hVar2.ail();
        }
        hVar = this.coa.cnW;
        hVar.aim();
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        h hVar;
        hVar = this.coa.cnW;
        hVar.aim();
    }
}
