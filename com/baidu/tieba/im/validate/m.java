package com.baidu.tieba.im.validate;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.a = iVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        if (bVar != null) {
            headImageView = this.a.d;
            bVar.a(headImageView);
        }
    }
}
