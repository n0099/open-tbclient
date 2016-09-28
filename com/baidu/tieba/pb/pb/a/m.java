package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements TbImageView.a {
    final /* synthetic */ e emY;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o ena;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, com.baidu.tbadk.widget.richText.o oVar) {
        this.emY = eVar;
        this.ena = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        this.emY.pa(this.ena.getVideoUrl());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
