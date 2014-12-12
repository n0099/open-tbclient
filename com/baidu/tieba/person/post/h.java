package com.baidu.tieba.person.post;

import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.br;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements br {
    final /* synthetic */ g bHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bHr = gVar;
    }

    @Override // com.baidu.tieba.person.br
    public void a(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        PersonPostModel personPostModel3;
        br brVar;
        br brVar2;
        if (z) {
            this.bHr.bHo = personPostModel;
        } else {
            personPostModel2 = this.bHr.bHo;
            if (personPostModel2 != null) {
                personPostModel3 = this.bHr.bHo;
                personPostModel3.post_list.addAll(personPostModel.post_list);
            }
        }
        brVar = this.bHr.bHn;
        if (brVar != null) {
            brVar2 = this.bHr.bHn;
            brVar2.a(personPostModel, z);
        }
        this.bHr.notifyDataSetChanged();
    }
}
