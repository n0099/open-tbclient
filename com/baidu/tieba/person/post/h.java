package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements f {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.tieba.person.post.f
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        f fVar;
        f fVar2;
        if (z) {
            this.a.b = personPostModel;
        } else {
            personPostModel2 = this.a.b;
            if (personPostModel2 != null) {
                personPostModel3 = this.a.b;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        fVar = this.a.a;
        if (fVar != null) {
            fVar2 = this.a.a;
            fVar2.a(personPostModel, z);
        }
        this.a.notifyDataSetChanged();
    }
}
