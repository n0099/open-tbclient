package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar) {
        this.ciI = rVar;
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
        this.ciI.bWM = ((Integer) view.getTag()).intValue();
        i = this.ciI.bWM;
        if (i >= 0) {
            i2 = this.ciI.bWM;
            acVar = this.ciI.cis;
            if (i2 < acVar.getCount()) {
                z = this.ciI.cix;
                if (!z) {
                    r rVar = this.ciI;
                    acVar2 = this.ciI.cis;
                    i3 = this.ciI.bWM;
                    rVar.ciw = (ForumData) acVar2.getItem(i3);
                    forumData = this.ciI.ciw;
                    if (forumData != null) {
                        forumData2 = this.ciI.ciw;
                        if (forumData2.getId() != null) {
                            forumData3 = this.ciI.ciw;
                            if (forumData3.getName() != null) {
                                r rVar2 = this.ciI;
                                forumData4 = this.ciI.ciw;
                                rVar2.cit = forumData4.getName();
                                this.ciI.cix = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.ciI.ciw;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.ciI.cit;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.ciI.ciw;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.ciI.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
