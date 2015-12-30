package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.cOw = sVar;
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
        this.cOw.cyc = ((Integer) view.getTag()).intValue();
        i = this.cOw.cyc;
        if (i >= 0) {
            i2 = this.cOw.cyc;
            adVar = this.cOw.cOh;
            if (i2 < adVar.getCount()) {
                z = this.cOw.cOm;
                if (!z) {
                    s sVar = this.cOw;
                    adVar2 = this.cOw.cOh;
                    i3 = this.cOw.cyc;
                    sVar.cOl = (ForumData) adVar2.getItem(i3);
                    forumData = this.cOw.cOl;
                    if (forumData != null) {
                        forumData2 = this.cOw.cOl;
                        if (forumData2.getId() != null) {
                            forumData3 = this.cOw.cOl;
                            if (forumData3.getName() != null) {
                                s sVar2 = this.cOw;
                                forumData4 = this.cOw.cOl;
                                sVar2.cOi = forumData4.getName();
                                this.cOw.cOm = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.cOw.cOl;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.cOw.cOi;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.cOw.cOl;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.cOw.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
