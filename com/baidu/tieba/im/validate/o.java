package com.baidu.tieba.im.validate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ ValidateItemData biY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ValidateItemData validateItemData) {
        this.biY = validateItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.d.Mx().ga(this.biY.getNotice_id()));
    }
}
