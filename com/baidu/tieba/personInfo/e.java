package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class e implements UserMuteAddAndDelModel.a {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonInfoActivity personInfoActivity) {
        this.cue = personInfoActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        this.cue.ctO = 1;
    }
}
