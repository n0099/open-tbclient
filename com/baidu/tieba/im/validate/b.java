package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1895a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ValidateActivity validateActivity) {
        this.f1895a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        n nVar;
        boolean z;
        n nVar2;
        nVar = this.f1895a.b;
        nVar.a(l.a(linkedList));
        if (linkedList != null) {
            ValidateActivity.a(this.f1895a, linkedList.size());
        }
        z = this.f1895a.i;
        if (!z) {
            nVar2 = this.f1895a.b;
            nVar2.a(false);
        }
        this.f1895a.e();
        this.f1895a.m = false;
    }
}
