package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ ValidateItemData bjm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ValidateItemData validateItemData) {
        this.bjm = validateItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.d.MB().a(this.bjm));
    }
}
