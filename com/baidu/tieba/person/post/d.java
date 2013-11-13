package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class d implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonPostActivity f2271a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonPostActivity personPostActivity) {
        this.f2271a = personPostActivity;
    }

    @Override // com.baidu.tieba.person.post.i
    public void a(int i) {
        PersonPostAdapter personPostAdapter;
        personPostAdapter = this.f2271a.h;
        personPostAdapter.c(i);
    }
}
