package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ GroupBannerView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(GroupBannerView groupBannerView) {
        this.a = groupBannerView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        this.a.setImg(bVar);
        this.a.setVisibility(0);
    }
}
