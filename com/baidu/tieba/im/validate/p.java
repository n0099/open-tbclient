package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.b<LinkedList<GroupNewsPojo>> {
    private final /* synthetic */ int bjn;
    private final /* synthetic */ int bjo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i, int i2) {
        this.bjn = i;
        this.bjo = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Pl */
    public LinkedList<GroupNewsPojo> doInBackground() {
        return com.baidu.tieba.im.db.d.MB().a(0L, this.bjn, this.bjo, "apply_join_group");
    }
}
