package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        r rVar;
        boolean z;
        r rVar2;
        int i;
        rVar = this.a.b;
        rVar.a(l.a(linkedList));
        if (linkedList != null) {
            ValidateActivity validateActivity = this.a;
            i = validateActivity.l;
            validateActivity.l = i + linkedList.size();
        }
        z = this.a.i;
        if (!z) {
            rVar2 = this.a.b;
            rVar2.a(false);
        }
        this.a.e();
        this.a.m = false;
    }
}
