package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // com.baidu.tieba.person.post.g
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        g gVar;
        g gVar2;
        if (z) {
            this.a.b = personPostModel;
        } else {
            personPostModel2 = this.a.b;
            if (personPostModel2 != null) {
                personPostModel3 = this.a.b;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        gVar = this.a.a;
        if (gVar != null) {
            gVar2 = this.a.a;
            gVar2.a(personPostModel, z);
        }
        this.a.notifyDataSetChanged();
    }
}
