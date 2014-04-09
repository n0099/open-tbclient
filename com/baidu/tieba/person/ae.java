package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.a = abVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
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
