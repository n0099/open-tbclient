package com.baidu.tieba.view;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        tbImageView = this.a.m;
        if (tbImageView.getTag() != null) {
            tbImageView2 = this.a.m;
            if (((String) tbImageView2.getTag()).equals(str)) {
                tbImageView3 = this.a.m;
                tbImageView3.invalidate();
            }
        }
    }
}
