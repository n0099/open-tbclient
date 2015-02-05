package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements bq {
    final /* synthetic */ f bJc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.bJc = fVar;
    }

    @Override // com.baidu.tieba.person.bq
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        bq bqVar;
        bq bqVar2;
        if (z) {
            this.bJc.bIZ = personPostModel;
        } else {
            personPostModel2 = this.bJc.bIZ;
            if (personPostModel2 != null) {
                personPostModel3 = this.bJc.bIZ;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        bqVar = this.bJc.bIY;
        if (bqVar != null) {
            bqVar2 = this.bJc.bIY;
            bqVar2.a(personPostModel, z);
        }
        this.bJc.notifyDataSetChanged();
    }
}
