package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ r cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar) {
        this.cpf = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        ac acVar;
        boolean z;
        ac acVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.cpf.cbp = ((Integer) view.getTag()).intValue();
        i = this.cpf.cbp;
        if (i >= 0) {
            i2 = this.cpf.cbp;
            acVar = this.cpf.coP;
            if (i2 < acVar.getCount()) {
                z = this.cpf.coU;
                if (!z) {
                    r rVar = this.cpf;
                    acVar2 = this.cpf.coP;
                    i3 = this.cpf.cbp;
                    rVar.coT = (ForumData) acVar2.getItem(i3);
                    forumData = this.cpf.coT;
                    if (forumData != null) {
                        forumData2 = this.cpf.coT;
                        if (forumData2.getId() != null) {
                            forumData3 = this.cpf.coT;
                            if (forumData3.getName() != null) {
                                r rVar2 = this.cpf;
                                forumData4 = this.cpf.coT;
                                rVar2.coQ = forumData4.getName();
                                this.cpf.coU = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.cpf.coT;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.cpf.coQ;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.cpf.coT;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.cpf.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
