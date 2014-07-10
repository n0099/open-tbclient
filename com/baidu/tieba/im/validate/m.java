package com.baidu.tieba.im.validate;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.a = iVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView;
        if (aVar != null) {
            headImageView = this.a.c;
            aVar.a(headImageView);
        }
    }
}
