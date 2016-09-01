package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements TbImageView.a {
    final /* synthetic */ e elb;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o eld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(e eVar, com.baidu.tbadk.widget.richText.o oVar) {
        this.elb = eVar;
        this.eld = oVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void u(String str, boolean z) {
        this.elb.ay(this.eld.getVideoUrl(), this.eld.getDuration());
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
