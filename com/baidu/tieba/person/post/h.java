package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements PersonPostModel.a {
    final /* synthetic */ g cVm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cVm = gVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.cVm.cVj = personPostModel;
        } else {
            personPostModel2 = this.cVm.cVj;
            if (personPostModel2 != null) {
                personPostModel3 = this.cVm.cVj;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.cVm.cVi;
        if (aVar != null) {
            aVar2 = this.cVm.cVi;
            aVar2.a(personPostModel, z);
        }
        this.cVm.notifyDataSetChanged();
    }
}
