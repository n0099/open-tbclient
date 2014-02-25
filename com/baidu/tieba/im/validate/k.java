package com.baidu.tieba.im.validate;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        if (bVar != null) {
            headImageView = this.a.d;
            bVar.a(headImageView);
        }
    }
}
