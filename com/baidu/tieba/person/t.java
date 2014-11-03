package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ o bBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.bBP = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        x xVar;
        boolean z;
        x xVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.bBP.bBi = ((Integer) view.getTag()).intValue();
        i = this.bBP.bBi;
        if (i >= 0) {
            i2 = this.bBP.bBi;
            xVar = this.bBP.bBH;
            if (i2 < xVar.getCount()) {
                z = this.bBP.bBL;
                if (!z) {
                    o oVar = this.bBP;
                    xVar2 = this.bBP.bBH;
                    i3 = this.bBP.bBi;
                    oVar.bBK = (ForumData) xVar2.getItem(i3);
                    forumData = this.bBP.bBK;
                    if (forumData != null) {
                        forumData2 = this.bBP.bBK;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bBP.bBK;
                            if (forumData3.getName() != null) {
                                o oVar2 = this.bBP;
                                forumData4 = this.bBP.bBK;
                                oVar2.bBI = forumData4.getName();
                                this.bBP.bBL = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bBP.bBK;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bBP.bBI;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bBP.bBK;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkApplication.m251getInst().getTbs());
                                this.bBP.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
