package com.baidu.tieba.personCenter.f;

import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TbImageView.a {
    final /* synthetic */ c eBi;
    private final /* synthetic */ HeadImageView eBj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, HeadImageView headImageView) {
        this.eBi = cVar;
        this.eBj = headImageView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        if (!z) {
            this.eBj.setVisibility(8);
            return;
        }
        this.eBj.setVisibility(0);
        aq.j(this.eBj, w.g.person_center_item_extra_img_bg);
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        this.eBj.setVisibility(8);
    }
}
