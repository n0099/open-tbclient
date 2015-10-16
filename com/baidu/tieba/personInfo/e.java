package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class e implements UserMuteAddAndDelModel.a {
    final /* synthetic */ PersonInfoActivity csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonInfoActivity personInfoActivity) {
        this.csI = personInfoActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        this.csI.css = 1;
    }
}
