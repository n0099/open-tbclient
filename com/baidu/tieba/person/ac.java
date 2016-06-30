package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(t tVar) {
        this.eeh = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        af afVar;
        boolean z;
        af afVar2;
        int i3;
        ForumData forumData;
        ForumData forumData2;
        ForumData forumData3;
        ForumData forumData4;
        ForumData forumData5;
        String str;
        ForumData forumData6;
        this.eeh.dGZ = ((Integer) view.getTag()).intValue();
        i = this.eeh.dGZ;
        if (i >= 0) {
            i2 = this.eeh.dGZ;
            afVar = this.eeh.edR;
            if (i2 < afVar.getCount()) {
                z = this.eeh.edW;
                if (!z) {
                    t tVar = this.eeh;
                    afVar2 = this.eeh.edR;
                    i3 = this.eeh.dGZ;
                    tVar.edV = (ForumData) afVar2.getItem(i3);
                    forumData = this.eeh.edV;
                    if (forumData != null) {
                        forumData2 = this.eeh.edV;
                        if (forumData2.getId() != null) {
                            forumData3 = this.eeh.edV;
                            if (forumData3.getName() != null) {
                                t tVar2 = this.eeh;
                                forumData4 = this.eeh.edV;
                                tVar2.edS = forumData4.getName();
                                this.eeh.edW = true;
                                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                                forumData5 = this.eeh.edV;
                                httpMessage.addParam("fid", forumData5.getId());
                                str = this.eeh.edS;
                                httpMessage.addParam("kw", str);
                                forumData6 = this.eeh.edV;
                                httpMessage.addParam("favo_type", String.valueOf(forumData6.getFavo_type()));
                                httpMessage.addParam("tbs", TbadkCoreApplication.m9getInst().getTbs());
                                this.eeh.sendMessage(httpMessage);
                            }
                        }
                    }
                }
            }
        }
    }
}
