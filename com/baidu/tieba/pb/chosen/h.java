package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.pb.chosen.a.d {
    final /* synthetic */ PbChosenActivity bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.bFY = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.d
    public void aP(String str, String str2) {
        this.bFY.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bFY.getPageContext().getPageActivity(), str, str2)));
    }
}
