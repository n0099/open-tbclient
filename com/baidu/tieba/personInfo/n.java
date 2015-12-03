package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements UserMuteAddAndDelModel.b {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar) {
        this.cSn = dVar;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.b
    public void a(UserMuteDelResponseMessage userMuteDelResponseMessage) {
        this.cSn.cRR = 0;
    }
}
