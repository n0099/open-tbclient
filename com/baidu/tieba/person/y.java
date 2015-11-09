package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar) {
        this.cqM = rVar;
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
        this.cqM.ccb = ((Integer) view.getTag()).intValue();
        i = this.cqM.ccb;
        if (i >= 0) {
            i2 = this.cqM.ccb;
            acVar = this.cqM.cqw;
            if (i2 < acVar.getCount()) {
                z = this.cqM.cqB;
                if (!z) {
                    r rVar = this.cqM;
                    acVar2 = this.cqM.cqw;
                    i3 = this.cqM.ccb;
                    rVar.cqA = (ForumData) acVar2.getItem(i3);
                    forumData = this.cqM.cqA;
                    if (forumData != null) {
                        forumData2 = this.cqM.cqA;
                        if (forumData2.getId() != null) {
                            forumData3 = this.cqM.cqA;
                            if (forumData3.getName() != null) {
                                r rVar2 = this.cqM;
                                forumData4 = this.cqM.cqA;
                                rVar2.cqx = forumData4.getName();
                                this.cqM.cqB = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.cqM.cqA;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.cqM.cqx;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.cqM.cqA;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.cqM.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
