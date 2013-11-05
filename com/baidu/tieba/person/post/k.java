package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f2240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f2240a = jVar;
    }

    @Override // com.baidu.tieba.person.post.e
    public void a(PersonPostReplyModel personPostReplyModel, boolean z) {
        PersonPostReplyModel personPostReplyModel2;
        PersonPostReplyModel personPostReplyModel3;
        m mVar;
        m mVar2;
        if (z) {
            this.f2240a.b = personPostReplyModel;
        } else {
            personPostReplyModel2 = this.f2240a.b;
            if (personPostReplyModel2 != null) {
                personPostReplyModel3 = this.f2240a.b;
                personPostReplyModel3.post_list.addAll(personPostReplyModel.post_list);
            }
        }
        mVar = this.f2240a.f2239a;
        if (mVar != null) {
            mVar2 = this.f2240a.f2239a;
            mVar2.a(personPostReplyModel, z);
        }
        this.f2240a.notifyDataSetChanged();
    }
}
