package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ch {
    final /* synthetic */ g bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bUj = gVar;
    }

    @Override // com.baidu.tieba.person.ch
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        ch chVar;
        ch chVar2;
        if (z) {
            this.bUj.bUg = personPostModel;
        } else {
            personPostModel2 = this.bUj.bUg;
            if (personPostModel2 != null) {
                personPostModel3 = this.bUj.bUg;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        chVar = this.bUj.bUf;
        if (chVar != null) {
            chVar2 = this.bUj.bUf;
            chVar2.a(personPostModel, z);
        }
        this.bUj.notifyDataSetChanged();
    }
}
