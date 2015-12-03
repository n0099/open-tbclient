package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.cKg = sVar;
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
        this.cKg.cua = ((Integer) view.getTag()).intValue();
        i = this.cKg.cua;
        if (i >= 0) {
            i2 = this.cKg.cua;
            adVar = this.cKg.cJR;
            if (i2 < adVar.getCount()) {
                z = this.cKg.cJW;
                if (!z) {
                    s sVar = this.cKg;
                    adVar2 = this.cKg.cJR;
                    i3 = this.cKg.cua;
                    sVar.cJV = (ForumData) adVar2.getItem(i3);
                    forumData = this.cKg.cJV;
                    if (forumData != null) {
                        forumData2 = this.cKg.cJV;
                        if (forumData2.getId() != null) {
                            forumData3 = this.cKg.cJV;
                            if (forumData3.getName() != null) {
                                s sVar2 = this.cKg;
                                forumData4 = this.cKg.cJV;
                                sVar2.cJS = forumData4.getName();
                                this.cKg.cJW = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.cKg.cJV;
                                httpMessage.addParam(ImageViewerConfig.FORUM_ID, forumData5.getId());
                                str = this.cKg.cJS;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.cKg.cJV;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
                                this.cKg.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
