package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class d implements UserMuteAddAndDelModel.a {
    final /* synthetic */ PersonInfoActivity clO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.clO = personInfoActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        this.clO.clz = 1;
        TiebaStatic.log(com.baidu.tieba.usermute.m.cPj);
    }
}
