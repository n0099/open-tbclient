package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.cXR = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        ad adVar;
        boolean z;
        ad adVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.cXR.cEJ = ((Integer) view.getTag()).intValue();
        i = this.cXR.cEJ;
        if (i >= 0) {
            i2 = this.cXR.cEJ;
            adVar = this.cXR.cXB;
            if (i2 < adVar.getCount()) {
                z = this.cXR.cXG;
                if (!z) {
                    s sVar = this.cXR;
                    adVar2 = this.cXR.cXB;
                    i3 = this.cXR.cEJ;
                    sVar.cXF = (ForumData) adVar2.getItem(i3);
                    forumData = this.cXR.cXF;
                    if (forumData != null) {
                        forumData2 = this.cXR.cXF;
                        if (forumData2.getId() != null) {
                            forumData3 = this.cXR.cXF;
                            if (forumData3.getName() != null) {
                                s sVar2 = this.cXR;
                                forumData4 = this.cXR.cXF;
                                sVar2.cXC = forumData4.getName();
                                this.cXR.cXG = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.cXR.cXF;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.cXR.cXC;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.cXR.cXF;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.cXR.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
