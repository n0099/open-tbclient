package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements PersonPostModel.a {
    final /* synthetic */ f ckR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.ckR = fVar;
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (z) {
            this.ckR.ckO = personPostModel;
        } else {
            personPostModel2 = this.ckR.ckO;
            if (personPostModel2 != null) {
                personPostModel3 = this.ckR.ckO;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        aVar = this.ckR.ckN;
        if (aVar != null) {
            aVar2 = this.ckR.ckN;
            aVar2.a(personPostModel, z);
        }
        this.ckR.notifyDataSetChanged();
    }
}
