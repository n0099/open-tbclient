package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.setting.usermutelist.h;
/* loaded from: classes.dex */
class e implements h.a {
    final /* synthetic */ UserMuteListActivity czi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UserMuteListActivity userMuteListActivity) {
        this.czi = userMuteListActivity;
    }

    @Override // com.baidu.tieba.setting.usermutelist.h.a
    public void g(long j, String str) {
        this.czi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.czi.getPageContext().getPageActivity(), new StringBuilder(String.valueOf(j)).toString(), str)));
    }
}
