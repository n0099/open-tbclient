package com.baidu.tieba.person;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bc bcVar) {
        this.a = bcVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (bVar != null) {
            headImageView = this.a.d;
            headImageView.setImageResource(0);
            headImageView2 = this.a.d;
            bVar.a(headImageView2);
        }
    }
}
