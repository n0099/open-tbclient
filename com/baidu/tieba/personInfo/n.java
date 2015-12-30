package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements UserMuteAddAndDelModel.a {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        this.cWV.cWu = 1;
    }
}
