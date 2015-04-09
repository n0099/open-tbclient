package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.pb.chosen.a.d {
    final /* synthetic */ PbChosenActivity bGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.bGl = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.d
    public void aP(String str, String str2) {
        this.bGl.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bGl.getPageContext().getPageActivity(), str, str2)));
    }
}
