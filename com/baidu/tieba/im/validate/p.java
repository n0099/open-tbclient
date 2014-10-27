package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.b<LinkedList<GroupNewsPojo>> {
    private final /* synthetic */ int biZ;
    private final /* synthetic */ int bja;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i, int i2) {
        this.biZ = i;
        this.bja = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Pi */
    public LinkedList<GroupNewsPojo> doInBackground() {
        return com.baidu.tieba.im.db.d.Mx().a(0L, this.biZ, this.bja, "apply_join_group");
    }
}
