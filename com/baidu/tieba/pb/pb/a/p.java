package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ e dML;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o dMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(e eVar, com.baidu.tbadk.widget.richText.o oVar) {
        this.dML = eVar;
        this.dMN = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        this.dML.ax(this.dMN.getVideoUrl(), this.dMN.getDuration());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
