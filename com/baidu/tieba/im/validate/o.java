package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends com.baidu.tieba.im.m<Boolean> {
    private final /* synthetic */ ValidateItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ValidateItemData validateItemData) {
        this.b = validateItemData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.d.a().a(this.b));
    }
}
