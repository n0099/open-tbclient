package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.bSb = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        ag agVar;
        boolean z;
        ag agVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.bSb.bGS = ((Integer) view.getTag()).intValue();
        i = this.bSb.bGS;
        if (i >= 0) {
            i2 = this.bSb.bGS;
            agVar = this.bSb.bRM;
            if (i2 < agVar.getCount()) {
                z = this.bSb.bRR;
                if (!z) {
                    v vVar = this.bSb;
                    agVar2 = this.bSb.bRM;
                    i3 = this.bSb.bGS;
                    vVar.bRQ = (ForumData) agVar2.getItem(i3);
                    forumData = this.bSb.bRQ;
                    if (forumData != null) {
                        forumData2 = this.bSb.bRQ;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bSb.bRQ;
                            if (forumData3.getName() != null) {
                                v vVar2 = this.bSb;
                                forumData4 = this.bSb.bRQ;
                                vVar2.bRN = forumData4.getName();
                                this.bSb.bRR = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bSb.bRQ;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bSb.bRN;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bSb.bRQ;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.bSb.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
