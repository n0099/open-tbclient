package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity cWy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BasePersonInfoActivity basePersonInfoActivity) {
        this.cWy = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        this.cWy.cdo = com.baidu.tbadk.core.a.h.bC(this.cWy.atk()) % 3;
        String str = "";
        switch (this.cWy.atk()) {
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
        i = this.cWy.cdo;
        httpMessage.addParam("val", String.valueOf(i + 1));
        this.cWy.sendMessage(httpMessage);
    }
}
