package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.c<Boolean> {
    private final /* synthetic */ ValidateItemData a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ValidateItemData validateItemData) {
        this.a = validateItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(this.a));
    }
}
