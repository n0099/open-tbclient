package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements UserMuteAddAndDelModel.b {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.b
    public void a(UserMuteDelResponseMessage userMuteDelResponseMessage) {
        this.diG.did = 0;
    }
}
