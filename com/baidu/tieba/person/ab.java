package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(s sVar) {
        this.dvP = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        ae aeVar;
        boolean z;
        ae aeVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.dvP.dar = ((Integer) view.getTag()).intValue();
        i = this.dvP.dar;
        if (i >= 0) {
            i2 = this.dvP.dar;
            aeVar = this.dvP.dvz;
            if (i2 < aeVar.getCount()) {
                z = this.dvP.dvE;
                if (!z) {
                    s sVar = this.dvP;
                    aeVar2 = this.dvP.dvz;
                    i3 = this.dvP.dar;
                    sVar.dvD = (ForumData) aeVar2.getItem(i3);
                    forumData = this.dvP.dvD;
                    if (forumData != null) {
                        forumData2 = this.dvP.dvD;
                        if (forumData2.getId() != null) {
                            forumData3 = this.dvP.dvD;
                            if (forumData3.getName() != null) {
                                s sVar2 = this.dvP;
                                forumData4 = this.dvP.dvD;
                                sVar2.dvA = forumData4.getName();
                                this.dvP.dvE = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.dvP.dvD;
                                httpMessage.addParam("fid", forumData5.getId());
                                str = this.dvP.dvA;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.dvP.dvD;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m11getInst().getTbs());
                                this.dvP.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
