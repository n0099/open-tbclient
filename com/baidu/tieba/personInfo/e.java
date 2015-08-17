package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
class e implements UserMuteAddAndDelModel.b {
    final /* synthetic */ PersonInfoActivity clO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonInfoActivity personInfoActivity) {
        this.clO = personInfoActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.b
    public void a(UserMuteDelResponseMessage userMuteDelResponseMessage) {
        this.clO.clz = 0;
    }
}
