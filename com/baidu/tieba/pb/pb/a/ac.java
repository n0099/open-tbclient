package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ r dgC;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o dgF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(r rVar, com.baidu.tbadk.widget.richText.o oVar) {
        this.dgC = rVar;
        this.dgF = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        this.dgC.lP(this.dgF.getVideoUrl());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
