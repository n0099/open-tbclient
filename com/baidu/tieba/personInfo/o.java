package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements UserMuteAddAndDelModel.b {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.b
    public void a(UserMuteDelResponseMessage userMuteDelResponseMessage) {
        this.cWV.cWu = 0;
    }
}
