package com.baidu.tieba.person.post;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements PersonPostModel.a {
    final /* synthetic */ h enp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.enp = hVar;
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
            this.enp.enm = personPostModel;
        } else {
            personPostModel2 = this.enp.enm;
            if (personPostModel2 != null) {
                personPostModel3 = this.enp.enm;
                bdUniqueId = this.enp.aoZ;
                personPostModel3.setUniqueId(bdUniqueId);
                personPostModel4 = this.enp.enm;
                personPostModel4.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.enp.enl;
        if (aVar != null) {
            aVar2 = this.enp.enl;
            aVar2.a(personPostModel, z);
        }
        this.enp.notifyDataSetChanged();
    }
}
