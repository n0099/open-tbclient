package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ g bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.bFr = gVar;
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
        this.bFr.bwG = ((Integer) view.getTag()).intValue();
        i = this.bFr.bwG;
        if (i >= 0) {
            i2 = this.bFr.bwG;
            qVar = this.bFr.bFg;
            if (i2 < qVar.getCount()) {
                z = this.bFr.bFm;
                if (!z) {
                    g gVar = this.bFr;
                    qVar2 = this.bFr.bFg;
                    i3 = this.bFr.bwG;
                    gVar.bFl = (ForumData) qVar2.getItem(i3);
                    forumData = this.bFr.bFl;
                    if (forumData != null) {
                        forumData2 = this.bFr.bFl;
                        if (forumData2.getId() != null) {
                            forumData3 = this.bFr.bFl;
                            if (forumData3.getName() != null) {
                                g gVar2 = this.bFr;
                                forumData4 = this.bFr.bFl;
                                gVar2.bFh = forumData4.getName();
                                this.bFr.bFm = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.bFr.bFl;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.bFr.bFh;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.bFr.bFl;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m255getInst().getTbs());
                                this.bFr.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
