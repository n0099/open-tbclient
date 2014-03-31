package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class w implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ v a;
    private final /* synthetic */ TbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, TbImageView tbImageView) {
        this.a = vVar;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (this.b != null) {
            this.b.invalidate();
        }
    }
}
