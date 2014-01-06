package com.baidu.tieba.im.validate;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        HeadImageView headImageView;
        if (dVar != null) {
            headImageView = this.a.d;
            dVar.a(headImageView);
        }
    }
}
