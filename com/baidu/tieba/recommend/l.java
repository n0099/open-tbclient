package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ h a;
    private final /* synthetic */ TbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar, TbImageView tbImageView) {
        this.a = hVar;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (this.b != null) {
            this.b.invalidate();
        }
    }
}
