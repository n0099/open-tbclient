package com.baidu.tieba.im.validate;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1805a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ValidateActivity validateActivity) {
        this.f1805a = validateActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        m mVar;
        boolean z;
        m mVar2;
        mVar = this.f1805a.b;
        mVar.a(k.a(linkedList));
        z = this.f1805a.i;
        if (!z) {
            mVar2 = this.f1805a.b;
            mVar2.a(false);
        }
        this.f1805a.d();
    }
}
