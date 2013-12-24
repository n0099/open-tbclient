package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.tieba.person.post.e
    public void a(PersonPostReplyModel personPostReplyModel, boolean z) {
        PersonPostReplyModel personPostReplyModel2;
        PersonPostReplyModel personPostReplyModel3;
        m mVar;
        m mVar2;
        if (z) {
            this.a.b = personPostReplyModel;
        } else {
            personPostReplyModel2 = this.a.b;
            if (personPostReplyModel2 != null) {
                personPostReplyModel3 = this.a.b;
                personPostReplyModel3.post_list.addAll(personPostReplyModel.post_list);
            }
        }
        mVar = this.a.a;
        if (mVar != null) {
            mVar2 = this.a.a;
            mVar2.a(personPostReplyModel, z);
        }
        this.a.notifyDataSetChanged();
    }
}
