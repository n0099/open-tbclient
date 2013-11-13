package com.baidu.tieba.im.validate;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.f1812a = fVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1812a.d;
            eVar.a(headImageView);
        }
    }
}
