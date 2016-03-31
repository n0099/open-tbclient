package com.baidu.tieba.person.post;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PersonPostModel.a {
    final /* synthetic */ h dBn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dBn = hVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        BdUniqueId bdUniqueId;
        PersonPostModel personPostModel4;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.dBn.dBj = personPostModel;
        } else {
            personPostModel2 = this.dBn.dBj;
            if (personPostModel2 != null) {
                personPostModel3 = this.dBn.dBj;
                bdUniqueId = this.dBn.dBk;
                personPostModel3.setUniqueId(bdUniqueId);
                personPostModel4 = this.dBn.dBj;
                personPostModel4.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.dBn.dBi;
        if (aVar != null) {
            aVar2 = this.dBn.dBi;
            aVar2.a(personPostModel, z);
        }
        this.dBn.notifyDataSetChanged();
    }
}
