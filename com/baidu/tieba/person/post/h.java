package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements bo {
    final /* synthetic */ g bRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bRo = gVar;
    }

    @Override // com.baidu.tieba.person.bo
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        bo boVar;
        bo boVar2;
        if (z) {
            this.bRo.bRl = personPostModel;
        } else {
            personPostModel2 = this.bRo.bRl;
            if (personPostModel2 != null) {
                personPostModel3 = this.bRo.bRl;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        boVar = this.bRo.bRk;
        if (boVar != null) {
            boVar2 = this.bRo.bRk;
            boVar2.a(personPostModel, z);
        }
        this.bRo.notifyDataSetChanged();
    }
}
