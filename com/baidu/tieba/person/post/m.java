package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements f {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.tieba.person.post.f
    public final void a(PersonPostReplyModel personPostReplyModel, boolean z) {
        PersonPostReplyModel personPostReplyModel2;
        PersonPostReplyModel personPostReplyModel3;
        o oVar;
        o oVar2;
        if (z) {
            this.a.b = personPostReplyModel;
        } else {
            personPostReplyModel2 = this.a.b;
            if (personPostReplyModel2 != null) {
                personPostReplyModel3 = this.a.b;
                personPostReplyModel3.post_list.addAll(personPostReplyModel.post_list);
            }
        }
        oVar = this.a.a;
        if (oVar != null) {
            oVar2 = this.a.a;
            oVar2.a(personPostReplyModel, z);
        }
        this.a.notifyDataSetChanged();
    }
}
