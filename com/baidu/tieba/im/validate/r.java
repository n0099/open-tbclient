package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends com.baidu.tieba.im.m<LinkedList<GroupNewsPojo>> {
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* bridge */ /* synthetic */ LinkedList<GroupNewsPojo> a() {
        return com.baidu.tieba.im.db.d.a().a(0L, this.b, this.c, "apply_join_group");
    }
}
