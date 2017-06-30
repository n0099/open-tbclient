package com.baidu.tieba.personPolymeric.a;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.e.c<com.baidu.tieba.personPolymeric.d.s> {
    final /* synthetic */ c eUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eUy = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: aUW */
    public com.baidu.tieba.personPolymeric.d.s fK() {
        Context context;
        context = this.eUy.mContext;
        return new com.baidu.tieba.personPolymeric.d.s(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void o(com.baidu.tieba.personPolymeric.d.s sVar) {
        if (sVar != null) {
            sVar.removeAllViews();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public com.baidu.tieba.personPolymeric.d.s p(com.baidu.tieba.personPolymeric.d.s sVar) {
        return sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public com.baidu.tieba.personPolymeric.d.s q(com.baidu.tieba.personPolymeric.d.s sVar) {
        return sVar;
    }
}
