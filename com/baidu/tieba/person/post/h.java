package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements PersonPostModel.a {
    final /* synthetic */ g cQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cQK = gVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.cQK.cQH = personPostModel;
        } else {
            personPostModel2 = this.cQK.cQH;
            if (personPostModel2 != null) {
                personPostModel3 = this.cQK.cQH;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.cQK.cQG;
        if (aVar != null) {
            aVar2 = this.cQK.cQG;
            aVar2.a(personPostModel, z);
        }
        this.cQK.notifyDataSetChanged();
    }
}
