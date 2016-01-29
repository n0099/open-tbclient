package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PersonPostModel.a {
    final /* synthetic */ h dgN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dgN = hVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.dgN.dgK = personPostModel;
        } else {
            personPostModel2 = this.dgN.dgK;
            if (personPostModel2 != null) {
                personPostModel3 = this.dgN.dgK;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.dgN.dgJ;
        if (aVar != null) {
            aVar2 = this.dgN.dgJ;
            aVar2.a(personPostModel, z);
        }
        this.dgN.notifyDataSetChanged();
    }
}
