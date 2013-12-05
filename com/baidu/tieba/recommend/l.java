package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbImageView f2417a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar, TbImageView tbImageView) {
        this.b = hVar;
        this.f2417a = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (this.f2417a != null) {
            this.f2417a.invalidate();
        }
    }
}
