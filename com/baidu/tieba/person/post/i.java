package com.baidu.tieba.person.post;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PersonPostModel.a {
    final /* synthetic */ h dEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dEv = hVar;
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
            this.dEv.dEs = personPostModel;
        } else {
            personPostModel2 = this.dEv.dEs;
            if (personPostModel2 != null) {
                personPostModel3 = this.dEv.dEs;
                bdUniqueId = this.dEv.aoj;
                personPostModel3.setUniqueId(bdUniqueId);
                personPostModel4 = this.dEv.dEs;
                personPostModel4.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.dEv.dEr;
        if (aVar != null) {
            aVar2 = this.dEv.dEr;
            aVar2.a(personPostModel, z);
        }
        this.dEv.notifyDataSetChanged();
    }
}
