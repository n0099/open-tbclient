package com.baidu.tieba.square;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1757a;
    private final /* synthetic */ HeadImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, HeadImageView headImageView) {
        this.f1757a = tVar;
        this.b = headImageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.f1757a.a(this.b, bVar.f());
        }
    }
}
