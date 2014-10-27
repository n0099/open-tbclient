package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ h bDE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bDE = hVar;
    }

    @Override // com.baidu.tieba.person.post.g
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        g gVar;
        g gVar2;
        if (z) {
            this.bDE.bDB = personPostModel;
        } else {
            personPostModel2 = this.bDE.bDB;
            if (personPostModel2 != null) {
                personPostModel3 = this.bDE.bDB;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        gVar = this.bDE.bDA;
        if (gVar != null) {
            gVar2 = this.bDE.bDA;
            gVar2.a(personPostModel, z);
        }
        this.bDE.notifyDataSetChanged();
    }
}
