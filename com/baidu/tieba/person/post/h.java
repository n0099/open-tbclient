package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements bo {
    final /* synthetic */ g bRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bRE = gVar;
    }

    @Override // com.baidu.tieba.person.bo
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        bo boVar;
        bo boVar2;
        if (z) {
            this.bRE.bRB = personPostModel;
        } else {
            personPostModel2 = this.bRE.bRB;
            if (personPostModel2 != null) {
                personPostModel3 = this.bRE.bRB;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        boVar = this.bRE.bRA;
        if (boVar != null) {
            boVar2 = this.bRE.bRA;
            boVar2.a(personPostModel, z);
        }
        this.bRE.notifyDataSetChanged();
    }
}
