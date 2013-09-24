package com.baidu.tieba.person.post;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1715a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.f1715a = aVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        com.baidu.adp.widget.a.c cVar2;
        if (cVar != null) {
            a.j = cVar;
            a.k = this.b;
            HeadImageView headImageView = this.f1715a.b;
            cVar2 = a.j;
            headImageView.setImageBitmap(cVar2.f());
        }
    }
}
