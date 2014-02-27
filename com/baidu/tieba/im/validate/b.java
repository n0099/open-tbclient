package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class b implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(LinkedList<GroupNewsPojo> linkedList) {
        r rVar;
        boolean z;
        r rVar2;
        int i;
        LinkedList<GroupNewsPojo> linkedList2 = linkedList;
        rVar = this.a.b;
        rVar.a(l.a(linkedList2));
        if (linkedList2 != null) {
            ValidateActivity validateActivity = this.a;
            i = validateActivity.l;
            validateActivity.l = i + linkedList2.size();
        }
        z = this.a.i;
        if (!z) {
            rVar2 = this.a.b;
            rVar2.a(false);
        }
        this.a.c();
        this.a.m = false;
    }
}
