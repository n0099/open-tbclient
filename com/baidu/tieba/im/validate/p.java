package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.c<LinkedList<GroupNewsPojo>> {
    private final /* synthetic */ int a;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i, int i2) {
        this.a = i;
        this.c = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public LinkedList<GroupNewsPojo> b() {
        return com.baidu.tieba.im.db.c.a().a(0L, this.a, this.c, "apply_join_group");
    }
}
