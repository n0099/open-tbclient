package com.baidu.tieba.personCenter.g;

import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TbImageView.a {
    final /* synthetic */ c eDQ;
    private final /* synthetic */ HeadImageView eDR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, HeadImageView headImageView) {
        this.eDQ = cVar;
        this.eDR = headImageView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void u(String str, boolean z) {
        if (!z) {
            this.eDR.setVisibility(8);
            return;
        }
        this.eDR.setVisibility(0);
        av.k(this.eDR, t.f.person_center_item_extra_img_bg);
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        this.eDR.setVisibility(8);
    }
}
