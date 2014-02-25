package com.baidu.tieba.person;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.a = anVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (bVar != null) {
            headImageView = this.a.j;
            headImageView.setImageResource(0);
            headImageView2 = this.a.j;
            bVar.a(headImageView2);
        }
    }
}
