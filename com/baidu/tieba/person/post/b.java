package com.baidu.tieba.person.post;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2255a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.b = aVar;
        this.f2255a = str;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        com.baidu.adp.widget.ImageView.e eVar2;
        if (eVar != null) {
            com.baidu.adp.widget.ImageView.e unused = a.j = eVar;
            String unused2 = a.k = this.f2255a;
            HeadImageView headImageView = this.b.b;
            eVar2 = a.j;
            headImageView.setImageBitmap(eVar2.f());
        }
    }
}
