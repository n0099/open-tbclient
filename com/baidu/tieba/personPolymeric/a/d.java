package com.baidu.tieba.personPolymeric.a;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.e.c<com.baidu.tieba.personPolymeric.d.q> {
    final /* synthetic */ c eGp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eGp = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: aRc */
    public com.baidu.tieba.personPolymeric.d.q fF() {
        Context context;
        context = this.eGp.mContext;
        return new com.baidu.tieba.personPolymeric.d.q(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void o(com.baidu.tieba.personPolymeric.d.q qVar) {
        if (qVar != null) {
            qVar.removeAllViews();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public com.baidu.tieba.personPolymeric.d.q p(com.baidu.tieba.personPolymeric.d.q qVar) {
        return qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public com.baidu.tieba.personPolymeric.d.q q(com.baidu.tieba.personPolymeric.d.q qVar) {
        return qVar;
    }
}
