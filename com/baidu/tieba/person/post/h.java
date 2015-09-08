package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements PersonPostModel.a {
    final /* synthetic */ g clM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.clM = gVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.clM.clJ = personPostModel;
        } else {
            personPostModel2 = this.clM.clJ;
            if (personPostModel2 != null) {
                personPostModel3 = this.clM.clJ;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.clM.clI;
        if (aVar != null) {
            aVar2 = this.clM.clI;
            aVar2.a(personPostModel, z);
        }
        this.clM.notifyDataSetChanged();
    }
}
