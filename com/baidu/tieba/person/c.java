package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ BasePersonInfoActivity cpt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BasePersonInfoActivity basePersonInfoActivity) {
        this.cpt = basePersonInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        this.cpt.bGb = com.baidu.tbadk.core.a.h.br(this.cpt.aiF()) % 3;
        String str = "";
        switch (this.cpt.aiF()) {
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
        i = this.cpt.bGb;
        httpMessage.addParam("val", String.valueOf(i + 1));
        this.cpt.sendMessage(httpMessage);
    }
}
