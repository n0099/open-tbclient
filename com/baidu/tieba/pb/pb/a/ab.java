package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements TbImageView.a {
    final /* synthetic */ q cKS;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.m cKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(q qVar, com.baidu.tbadk.widget.richText.m mVar) {
        this.cKS = qVar;
        this.cKV = mVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        this.cKS.ky(this.cKV.getVideoUrl());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
