package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.b<LinkedList<GroupNewsPojo>> {
    private final /* synthetic */ int a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public LinkedList<GroupNewsPojo> a() {
        return com.baidu.tieba.im.db.d.a().a(0L, this.a, this.b, "apply_join_group");
    }
}
