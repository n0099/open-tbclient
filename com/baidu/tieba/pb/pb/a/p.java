package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ e dYX;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o dYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(e eVar, com.baidu.tbadk.widget.richText.o oVar) {
        this.dYX = eVar;
        this.dYZ = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        this.dYX.ay(this.dYZ.getVideoUrl(), this.dYZ.getDuration());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
