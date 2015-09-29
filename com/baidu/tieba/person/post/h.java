package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements PersonPostModel.a {
    final /* synthetic */ g crq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.crq = gVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.crq.crn = personPostModel;
        } else {
            personPostModel2 = this.crq.crn;
            if (personPostModel2 != null) {
                personPostModel3 = this.crq.crn;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.crq.crm;
        if (aVar != null) {
            aVar2 = this.crq.crm;
            aVar2.a(personPostModel, z);
        }
        this.crq.notifyDataSetChanged();
    }
}
