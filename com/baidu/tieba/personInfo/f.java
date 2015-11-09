package com.baidu.tieba.personInfo;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
class f implements UserMuteAddAndDelModel.b {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonInfoActivity personInfoActivity) {
        this.cue = personInfoActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.b
    public void a(UserMuteDelResponseMessage userMuteDelResponseMessage) {
        this.cue.ctO = 0;
    }
}
