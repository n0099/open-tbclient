package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ a a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        com.baidu.adp.widget.a.a aVar2;
        if (aVar != null) {
            a.l = aVar;
            a.m = this.b;
            HeadImageView headImageView = this.a.b;
            aVar2 = a.l;
            headImageView.setImageBitmap(aVar2.h());
        }
    }
}
