package com.baidu.tieba.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f2040a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f2040a = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        com.baidu.adp.a.g gVar;
        gVar = this.f2040a.f2039a.mLoadDataCallBack;
        gVar.a(true);
    }
}
