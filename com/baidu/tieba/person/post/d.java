package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class d implements i {
    final /* synthetic */ PersonPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonPostActivity personPostActivity) {
        this.a = personPostActivity;
    }

    @Override // com.baidu.tieba.person.post.i
    public void a(int i) {
        PersonPostAdapter personPostAdapter;
        personPostAdapter = this.a.h;
        personPostAdapter.c(i);
    }
}
