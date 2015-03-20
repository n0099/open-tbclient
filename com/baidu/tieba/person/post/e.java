package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ PersonPostActivity bRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonPostActivity personPostActivity) {
        this.bRh = personPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bRh.blb = com.baidu.tbadk.core.a.j.bl(4) % 3;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "post");
        httpMessage.addParam("val", String.valueOf(this.bRh.blb + 1));
        this.bRh.sendMessage(httpMessage);
    }
}
