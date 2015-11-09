package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements PersonPostModel.a {
    final /* synthetic */ g csX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.csX = gVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.csX.csU = personPostModel;
        } else {
            personPostModel2 = this.csX.csU;
            if (personPostModel2 != null) {
                personPostModel3 = this.csX.csU;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.csX.csT;
        if (aVar != null) {
            aVar2 = this.csX.csT;
            aVar2.a(personPostModel, z);
        }
        this.csX.notifyDataSetChanged();
    }
}
