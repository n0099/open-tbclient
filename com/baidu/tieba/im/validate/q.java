package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ ValidateItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ValidateItemData validateItemData) {
        this.b = validateItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.d.a().c(this.b.getNotice_id()));
    }
}
