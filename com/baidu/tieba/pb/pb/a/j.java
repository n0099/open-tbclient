package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements TbImageView.a {
    final /* synthetic */ d dXu;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.n dXw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar, com.baidu.tbadk.widget.richText.n nVar) {
        this.dXu = dVar;
        this.dXw = nVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        this.dXu.nO(this.dXw.getVideoUrl());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
