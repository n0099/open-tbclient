package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ g bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.bHc = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        q qVar;
        boolean z;
        q qVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.bHc.byp = ((Integer) view.getTag()).intValue();
        i = this.bHc.byp;
        if (i >= 0) {
            i2 = this.bHc.byp;
            qVar = this.bHc.bGR;
            if (i2 < qVar.getCount()) {
                z = this.bHc.bGX;
                if (!z) {
                    g gVar = this.bHc;
                    qVar2 = this.bHc.bGR;
                    i3 = this.bHc.byp;
                    gVar.bGW = (ForumData) qVar2.getItem(i3);
                    forumData = this.bHc.bGW;
                    if (forumData != null) {
                        forumData2 = this.bHc.bGW;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bHc.bGW;
                            if (forumData3.getName() != null) {
                                g gVar2 = this.bHc;
                                forumData4 = this.bHc.bGW;
                                gVar2.bGS = forumData4.getName();
                                this.bHc.bGX = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bHc.bGW;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bHc.bGS;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bHc.bGW;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m255getInst().getTbs());
                                this.bHc.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
