package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ t a;
    private final /* synthetic */ TbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, TbImageView tbImageView) {
        this.a = tVar;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (this.b != null) {
            this.b.invalidate();
        }
    }
}
