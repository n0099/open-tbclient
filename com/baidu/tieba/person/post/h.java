package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements PersonPostModel.a {
    final /* synthetic */ g crB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.crB = gVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.crB.cry = personPostModel;
        } else {
            personPostModel2 = this.crB.cry;
            if (personPostModel2 != null) {
                personPostModel3 = this.crB.cry;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.crB.crx;
        if (aVar != null) {
            aVar2 = this.crB.crx;
            aVar2.a(personPostModel, z);
        }
        this.crB.notifyDataSetChanged();
    }
}
