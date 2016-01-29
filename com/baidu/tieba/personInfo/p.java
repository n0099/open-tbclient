package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements UserMuteAddAndDelModel.a {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        this.diG.did = 1;
    }
}
