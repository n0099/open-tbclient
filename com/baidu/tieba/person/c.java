package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity bES;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BasePersonInfoActivity basePersonInfoActivity) {
        this.bES = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        this.bES.biQ = com.baidu.tbadk.core.account.o.bh(this.bES.ZU()) % 3;
        String str = "";
        switch (this.bES.ZU()) {
            case 2:
                str = "like";
                break;
            case 3:
                str = "group";
                break;
            case 4:
                str = "post";
                break;
            case 5:
                str = "friend";
                break;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", str);
        i = this.bES.biQ;
        httpMessage.addParam("val", String.valueOf(i + 1));
        this.bES.sendMessage(httpMessage);
    }
}
