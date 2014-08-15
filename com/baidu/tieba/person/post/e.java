package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ PersonPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonPostActivity personPostActivity) {
        this.a = personPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.d = com.baidu.tbadk.core.account.o.a(4) % 3;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "post");
        httpMessage.addParam("val", String.valueOf(this.a.d + 1));
        this.a.a(httpMessage);
    }
}
