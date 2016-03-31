package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ r dej;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.n dem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(r rVar, com.baidu.tbadk.widget.richText.n nVar) {
        this.dej = rVar;
        this.dem = nVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void s(String str, boolean z) {
        this.dej.lL(this.dem.getVideoUrl());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
