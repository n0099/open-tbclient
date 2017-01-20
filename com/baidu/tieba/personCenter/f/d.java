package com.baidu.tieba.personCenter.f;

import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TbImageView.a {
    final /* synthetic */ c ezM;
    private final /* synthetic */ HeadImageView ezN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, HeadImageView headImageView) {
        this.ezM = cVar;
        this.ezN = headImageView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        if (!z) {
            this.ezN.setVisibility(8);
            return;
        }
        this.ezN.setVisibility(0);
        ap.j(this.ezN, r.g.person_center_item_extra_img_bg);
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        this.ezN.setVisibility(8);
    }
}
