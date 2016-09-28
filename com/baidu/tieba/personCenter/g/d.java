package com.baidu.tieba.personCenter.g;

import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TbImageView.a {
    final /* synthetic */ c eFU;
    private final /* synthetic */ HeadImageView eFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, HeadImageView headImageView) {
        this.eFU = cVar;
        this.eFV = headImageView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        if (!z) {
            this.eFV.setVisibility(8);
            return;
        }
        this.eFV.setVisibility(0);
        av.k(this.eFV, r.f.person_center_item_extra_img_bg);
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        this.eFV.setVisibility(8);
    }
}
