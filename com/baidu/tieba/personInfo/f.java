package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
class f implements UserMuteAddAndDelModel.b {
    final /* synthetic */ PersonInfoActivity csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonInfoActivity personInfoActivity) {
        this.csI = personInfoActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.b
    public void a(UserMuteDelResponseMessage userMuteDelResponseMessage) {
        this.csI.css = 0;
    }
}
