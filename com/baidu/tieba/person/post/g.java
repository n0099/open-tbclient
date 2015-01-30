package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements bq {
    final /* synthetic */ f bJd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.bJd = fVar;
    }

    @Override // com.baidu.tieba.person.bq
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        bq bqVar;
        bq bqVar2;
        if (z) {
            this.bJd.bJa = personPostModel;
        } else {
            personPostModel2 = this.bJd.bJa;
            if (personPostModel2 != null) {
                personPostModel3 = this.bJd.bJa;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        bqVar = this.bJd.bIZ;
        if (bqVar != null) {
            bqVar2 = this.bJd.bIZ;
            bqVar2.a(personPostModel, z);
        }
        this.bJd.notifyDataSetChanged();
    }
}
