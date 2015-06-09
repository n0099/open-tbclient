package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ch {
    final /* synthetic */ g bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bUk = gVar;
    }

    @Override // com.baidu.tieba.person.ch
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        ch chVar;
        ch chVar2;
        if (z) {
            this.bUk.bUh = personPostModel;
        } else {
            personPostModel2 = this.bUk.bUh;
            if (personPostModel2 != null) {
                personPostModel3 = this.bUk.bUh;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        chVar = this.bUk.bUg;
        if (chVar != null) {
            chVar2 = this.bUk.bUg;
            chVar2.a(personPostModel, z);
        }
        this.bUk.notifyDataSetChanged();
    }
}
