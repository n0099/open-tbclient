package com.baidu.tieba.im.validate;
/* loaded from: classes.dex */
final class o extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ ValidateItemData a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ValidateItemData validateItemData) {
        this.a = validateItemData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().c(this.a.getNotice_id()));
    }
}
