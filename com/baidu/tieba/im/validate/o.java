package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ ValidateItemData bjm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ValidateItemData validateItemData) {
        this.bjm = validateItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.d.MB().ga(this.bjm.getNotice_id()));
    }
}
