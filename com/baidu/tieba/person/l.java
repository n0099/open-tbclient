package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ g bHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.bHb = gVar;
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
        this.bHb.byo = ((Integer) view.getTag()).intValue();
        i = this.bHb.byo;
        if (i >= 0) {
            i2 = this.bHb.byo;
            qVar = this.bHb.bGQ;
            if (i2 < qVar.getCount()) {
                z = this.bHb.bGW;
                if (!z) {
                    g gVar = this.bHb;
                    qVar2 = this.bHb.bGQ;
                    i3 = this.bHb.byo;
                    gVar.bGV = (ForumData) qVar2.getItem(i3);
                    forumData = this.bHb.bGV;
                    if (forumData != null) {
                        forumData2 = this.bHb.bGV;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bHb.bGV;
                            if (forumData3.getName() != null) {
                                g gVar2 = this.bHb;
                                forumData4 = this.bHb.bGV;
                                gVar2.bGR = forumData4.getName();
                                this.bHb.bGW = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bHb.bGV;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bHb.bGR;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bHb.bGV;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m255getInst().getTbs());
                                this.bHb.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
