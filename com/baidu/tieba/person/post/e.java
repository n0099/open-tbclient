package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ PersonPostActivity dgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonPostActivity personPostActivity) {
        this.dgG = personPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dgG.cdo = com.baidu.tbadk.core.a.h.bC(4) % 3;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "post");
        httpMessage.addParam("val", String.valueOf(this.dgG.cdo + 1));
        this.dgG.sendMessage(httpMessage);
    }
}
