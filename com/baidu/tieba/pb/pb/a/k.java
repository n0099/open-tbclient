package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements TbImageView.a {
    final /* synthetic */ e esY;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o eta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, com.baidu.tbadk.widget.richText.o oVar) {
        this.esY = eVar;
        this.eta = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        this.esY.pn(this.eta.getVideoUrl());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
