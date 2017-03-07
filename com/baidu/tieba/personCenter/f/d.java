package com.baidu.tieba.personCenter.f;

import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TbImageView.a {
    final /* synthetic */ c eDl;
    private final /* synthetic */ HeadImageView eDm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, HeadImageView headImageView) {
        this.eDl = cVar;
        this.eDm = headImageView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        if (!z) {
            this.eDm.setVisibility(8);
            return;
        }
        this.eDm.setVisibility(0);
        aq.j(this.eDm, w.g.person_center_item_extra_img_bg);
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        this.eDm.setVisibility(8);
    }
}
