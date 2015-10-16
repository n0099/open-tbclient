package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar) {
        this.cpq = rVar;
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
        this.cpq.cbA = ((Integer) view.getTag()).intValue();
        i = this.cpq.cbA;
        if (i >= 0) {
            i2 = this.cpq.cbA;
            acVar = this.cpq.cpa;
            if (i2 < acVar.getCount()) {
                z = this.cpq.cpf;
                if (!z) {
                    r rVar = this.cpq;
                    acVar2 = this.cpq.cpa;
                    i3 = this.cpq.cbA;
                    rVar.cpe = (ForumData) acVar2.getItem(i3);
                    forumData = this.cpq.cpe;
                    if (forumData != null) {
                        forumData2 = this.cpq.cpe;
                        if (forumData2.getId() != null) {
                            forumData3 = this.cpq.cpe;
                            if (forumData3.getName() != null) {
                                r rVar2 = this.cpq;
                                forumData4 = this.cpq.cpe;
                                rVar2.cpb = forumData4.getName();
                                this.cpq.cpf = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.cpq.cpe;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.cpq.cpb;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.cpq.cpe;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.cpq.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
