package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ TbImageView a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar, TbImageView tbImageView) {
        this.b = hVar;
        this.a = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (this.a != null) {
            this.a.invalidate();
        }
    }
}
