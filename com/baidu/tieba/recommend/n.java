package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class n implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ j a;
    private final /* synthetic */ TbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar, TbImageView tbImageView) {
        this.a = jVar;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (this.b != null) {
            this.b.invalidate();
        }
    }
}
