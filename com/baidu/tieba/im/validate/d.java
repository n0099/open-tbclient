package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        t tVar;
        boolean z;
        t tVar2;
        int i;
        tVar = this.a.b;
        tVar.a(n.a(linkedList));
        if (linkedList != null) {
            ValidateActivity validateActivity = this.a;
            i = validateActivity.l;
            validateActivity.l = i + linkedList.size();
        }
        z = this.a.i;
        if (!z) {
            tVar2 = this.a.b;
            tVar2.a(false);
        }
        this.a.e();
        this.a.m = false;
    }
}
