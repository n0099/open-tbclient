package com.baidu.tieba.im.validate;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.f1903a = gVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        if (eVar != null) {
            headImageView = this.f1903a.d;
            eVar.a(headImageView);
        }
    }
}
