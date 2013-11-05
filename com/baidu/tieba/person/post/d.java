package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class d implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonPostActivity f2236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonPostActivity personPostActivity) {
        this.f2236a = personPostActivity;
    }

    @Override // com.baidu.tieba.person.post.i
    public void a(int i) {
        PersonPostAdapter personPostAdapter;
        personPostAdapter = this.f2236a.g;
        personPostAdapter.c(i);
    }
}
