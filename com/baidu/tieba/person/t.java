package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ o bBB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.bBB = oVar;
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
        this.bBB.bAU = ((Integer) view.getTag()).intValue();
        i = this.bBB.bAU;
        if (i >= 0) {
            i2 = this.bBB.bAU;
            xVar = this.bBB.bBt;
            if (i2 < xVar.getCount()) {
                z = this.bBB.bBx;
                if (!z) {
                    o oVar = this.bBB;
                    xVar2 = this.bBB.bBt;
                    i3 = this.bBB.bAU;
                    oVar.bBw = (ForumData) xVar2.getItem(i3);
                    forumData = this.bBB.bBw;
                    if (forumData != null) {
                        forumData2 = this.bBB.bBw;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bBB.bBw;
                            if (forumData3.getName() != null) {
                                o oVar2 = this.bBB;
                                forumData4 = this.bBB.bBw;
                                oVar2.bBu = forumData4.getName();
                                this.bBB.bBx = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bBB.bBw;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bBB.bBu;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bBB.bBw;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkApplication.m251getInst().getTbs());
                                this.bBB.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
