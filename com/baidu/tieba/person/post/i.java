package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ h bDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bDS = hVar;
    }

    @Override // com.baidu.tieba.person.post.g
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        g gVar;
        g gVar2;
        if (z) {
            this.bDS.bDP = personPostModel;
        } else {
            personPostModel2 = this.bDS.bDP;
            if (personPostModel2 != null) {
                personPostModel3 = this.bDS.bDP;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        gVar = this.bDS.bDO;
        if (gVar != null) {
            gVar2 = this.bDS.bDO;
            gVar2.a(personPostModel, z);
        }
        this.bDS.notifyDataSetChanged();
    }
}
