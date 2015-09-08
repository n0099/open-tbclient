package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar) {
        this.cjC = rVar;
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
        this.cjC.bXD = ((Integer) view.getTag()).intValue();
        i = this.cjC.bXD;
        if (i >= 0) {
            i2 = this.cjC.bXD;
            acVar = this.cjC.cjm;
            if (i2 < acVar.getCount()) {
                z = this.cjC.cjr;
                if (!z) {
                    r rVar = this.cjC;
                    acVar2 = this.cjC.cjm;
                    i3 = this.cjC.bXD;
                    rVar.cjq = (ForumData) acVar2.getItem(i3);
                    forumData = this.cjC.cjq;
                    if (forumData != null) {
                        forumData2 = this.cjC.cjq;
                        if (forumData2.getId() != null) {
                            forumData3 = this.cjC.cjq;
                            if (forumData3.getName() != null) {
                                r rVar2 = this.cjC;
                                forumData4 = this.cjC.cjq;
                                rVar2.cjn = forumData4.getName();
                                this.cjC.cjr = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.cjC.cjq;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.cjC.cjn;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.cjC.cjq;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.cjC.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
